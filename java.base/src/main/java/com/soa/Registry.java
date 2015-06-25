package com.soa;

import java.util.List;

/**
 * </p>
 * Date:2015/5/26   Time:14:34
 *
 * @author: jiangbo.wjb
 */
public interface Registry {

    List<ServiceMetadata> listAllServices();

    ServiceMetadata getServiceMetadata(String serviceInterface);

    ServiceMetadata getServiceMetadata(String name,String serviceInterface);

}
