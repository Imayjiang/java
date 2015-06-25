package com.tmall.pyramid.domain.model;

import com.tmall.pyramid.domain.BusinessCheckException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 18:59 </p>
 *
 * @author jiangbo.wjb
 */
public class ReasonRepository {

    public Reason[] applyReason(final Trade trade) {
        //这里要借助规则引擎来match合适的reason
        Collection<Reason> collection = SampleReasonKeeper.getReasons().values();
        return collection.toArray(new Reason[collection.size()]);
    }

    public Reason[] recomposeReason(final Trade trade, final Refund refund) {
        //同样需要借助规则引擎 ,这里有个问题，如果规则引擎不支持依赖former的
        //transition，那么需要自己实现一个状态机
        final Reason[] reasonArr = applyReason(trade);
        if (reasonArr == null || reasonArr.length == 0) {
            return null;
        }

        List<Reason> reasonList = Arrays.asList(reasonArr);
        final Reason former = refund.getReason();
        if (reasonList.contains(former)) {
            reasonList.remove(former);
        }
        return reasonList.toArray(new Reason[reasonList.size()]);
    }

    public Reason find(final String reasonId) {
        return SampleReasonKeeper.getReasons().get(reasonId);
    }

    private static class SampleReasonKeeper {
        private static final Reason SEVEN_DAYS = new Reason("1", "7 days",
                "just for 7 days without excuse");

        private static final Reason DONT_WANT = new Reason("2", "i don't want it");

        private static final Reason FAKE = new Reason("3", "fake goods");

        private static final Map<String, Reason> REPO = new HashMap<String, Reason>();

        static {
            for (Field field : SampleReasonKeeper.class.getDeclaredFields()) {
                if (field.getType().equals(Reason.class)) {
                    try {
                        field.setAccessible(true);
                        Reason reason = (Reason) field.get(null);
                        REPO.put(reason.getId(), reason);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        static Map<String, Reason> getReasons() {
            return REPO;
        }
    }
}
