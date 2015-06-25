//package com.json;
//
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///**
// * <p>
// * </p>
// * <p> Date: 2014/10/30 Time: 17:37 </p>
// *
// * @author jiangbo.wjb
// */
//public class TestJson {
//
//    private static String preparedString;
//
//
//    public static void main(String[] args) throws JSONException {
//
//        JSONObject json = new JSONObject(getPreparedString());
//        if (json.getJSONArray("itemList") != null) {
//            JSONArray jsonArray = json.getJSONArray("itemList");
//            System.out.println(jsonArray.toString());
//        }
//
//
//    }
//
//    public static String getPreparedString() {
//        return "{ \"itemList\": [ { \"originalImage\":\"http://img04.taobaocdn.com/bao/uploaded/i4/TB1ARt2GXXXXXbuXFXXXXXXXXXX_!!0-item_pic.jpg\" , \"image\":\"http://img04.taobaocdn.com/bao/uploaded/i4/TB1ARt2GXXXXXbuXFXXXXXXXXXX_!!0-item_pic.jpg_b.jpg\" ,    \"href\":\"http://detail.tmall.com/item.htm?id=40930802127&_scm=1029.tbwt.item.1\" ,\t\"itemId\":\"40930802127\" ,\t\"verticalImage\":null ,\t\"tip\":\"武汉移动专享\\/预存300元免费得价值299元的大唐4G MIFI\\/黑白两色\" , \"fullTitle\":\"武汉移动专享\\/预存300元免费得价值299元的大唐4G MIFI\\/黑白两色\"\t,\t\"title\":\"武汉移动专享\\/预存300元免费得价值299元的大唐4G MIFI\\/黑白两色\"\t,\t\"price\": \"300.00\"\t,\t\"currentPrice\":\"300.00\" ,\t\"vipPrice\":\"\" ,\t\"unitPrice\":\"0.0\" ,\t\"unit\":null ,\t\"isVirtual\":\"false\" ,\t\"ship\":\"0.0\" ,\t\"tradeNum\":\"76\" ,\t\"smallNick\":\"武汉移动官方...\" ,\t\"nick\":\"武汉移动官方旗舰\" ,\t\"sellerId\":\"2170453597\" ,\t\"guarantee\":\"0\"\t,\t\"isLimitPromotion\":\"0\"\t,\t\"loc\":\"湖北武汉\" , \"storeLink\":\"http://store.taobao.com/shop/view_shop.htm?user_number_id=2170453597&ssid=r11\" ,\t\"multipic\": \"1\" ,\t\"commend\":\"49\" , \"commendHref\":\"http://detail.tmall.com/item.htm?id=40930802127&_scm=1029.tbwt.item.1&on_comment=1\" ,\t\"spm\":\"d11\" ,\t\"sellerSpm\":\"d21\" ,\t\"source\":\"normal\" ,\t\"icon\": { \"all\":[ {\"name\":\"sp-mall\",\"title\":\"天猫\",\"value\":null,\"tag\":null,\"href\":\"http://www.tmall.com/\",\"type\":\"0\"} ,{\"name\":\"sp-credit\",\"title\":\"该商品支持信用卡付款\",\"value\":null,\"tag\":null,\"href\":\"http://www.taobao.com/go/act/sale/kadepay.php?ad_id=&am_id=&cm_id=14001249574b437a411d&pm_id=\",\"type\":\"2\"} ]\t} , \"sameItemInfo\":null ,\t\"ratesum\":\"9\" ,\t\"goodRate\":null ,\t\"dsrScore\":\"4.90\" } , { \"originalImage\":\"http://img01.taobaocdn.com/bao/uploaded/i1/TB16EcxGXXXXXceXpXXXXXXXXXX_!!0-item_pic.jpg\" , \"image\":\"http://img01.taobaocdn.com/bao/uploaded/i1/TB16EcxGXXXXXceXpXXXXXXXXXX_!!0-item_pic.jpg_b.jpg\" ,\t\"href\":\"http://detail.tmall.com/item.htm?id=41362936166&_scm=1029.tbwt.item.2\" ,\t\"itemId\":\"41362936166\" ,\t\"verticalImage\":null ,\t\"tip\":\"移动6G流量卡累计卡半年卡全国通用 支持移动3G\\/2G上网卡资费卡\" , \"fullTitle\":\"移动6G流量卡累计卡半年卡全国通用 支持移动3G\\/2G上网卡资费卡\"\t,\t\"title\":\"移动6G流量卡累计卡半年卡全国通用 支持移动3G\\/2G上网卡资费卡\"\t,\t\"price\": \"199.00\" ,\t\"currentPrice\":\"188.00\" ,\t\"vipPrice\":\"\" ,\t\"unitPrice\":\"0.0\" ,\t\"unit\":null ,\t\"isVirtual\":\"false\" ,\t\"ship\":\"12.0\" ,\t\"tradeNum\":\"23\" ,\t\"smallNick\":\"新丰慧数码专...\" , \"nick\":\"新丰慧数码专营店\" ,\t\"sellerId\":\"1096257655\" ,\t\"guarantee\":\"0\"\t,\t\"isLimitPromotion\":\"0\"\t,\t\"loc\":\"广东深圳\" , \"storeLink\":\"http://store.taobao.com/shop/view_shop.htm?user_number_id=1096257655&ssid=r11\" ,\t\"multipic\": \"0\" ,\t\"commend\":\"6\" , \"commendHref\":\"http://detail.tmall.com/item.htm?id=41362936166&_scm=1029.tbwt.item.2&on_comment=1\" ,\t\"spm\":\"d13\" ,\t\"sellerSpm\":\"d23\" ,\t\"source\":\"normal\" ,\t\"icon\": { \"all\":[ {\"name\":\"sp-mall\",\"title\":\"天猫\",\"value\":null,\"tag\":null,\"href\":\"http://www.tmall.com/\",\"type\":\"0\"} ,{\"name\":\"sp-credit\",\"title\":\"该商品支持信用卡付款\",\"value\":null,\"tag\":null,\"href\":\"http://www.taobao.com/go/act/sale/kadepay.php?ad_id=&am_id=&cm_id=14001249574b437a411d&pm_id=\",\"type\":\"2\"} ]\t} , \"sameItemInfo\":null ,\t\"ratesum\":\"9\" ,\t\"goodRate\":null ,\t\"dsrScore\":\"4.88\" } , { \"originalImage\":\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1zCv4GpXXXXc6XXXXXXXXXXXX_!!0-item_pic.jpg\" , \"image\":\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1zCv4GpXXXXc6XXXXXXXXXXXX_!!0-item_pic.jpg_b.jpg\" ,\t\"href\":\"http://detail.tmall.com/item.htm?id=41679233118&_scm=1029.tbwt.item.3\" ,\t\"itemId\":\"41679233118\" ,\t\"verticalImage\":null ,\t\"tip\":\"移动4G资费卡 2G流量卡90天累计季卡 全国2GB流量 移动4G\\/3G\\/2G\" , \"fullTitle\":\"移动4G资费卡 2G流量卡90天累计季卡 全国2GB流量 移动4G\\/3G\\/2G\"\t,\t\"title\":\"移动4G资费卡 2G流量卡90天累计季卡 全国2GB流量 移动4G\\/3G\\/2G\"\t,\t\"price\": \"100.00\"\t,\t\"currentPrice\":\"99.00\" ,\t\"vipPrice\":\"\" ,\t\"unitPrice\":\"0.0\" ,\t\"unit\":null ,\t\"isVirtual\":\"false\" ,\t\"ship\":\"12.0\" ,\t\"tradeNum\":\"19\" ,\t\"smallNick\":\"新丰慧数码专...\" ,\t\"nick\":\"新丰慧数码专营店\" ,\t\"sellerId\":\"1096257655\" ,\t\"guarantee\":\"0\"\t,\t\"isLimitPromotion\":\"0\"\t,\t\"loc\":\"广东深圳\" , \"storeLink\":\"http://store.taobao.com/shop/view_shop.htm?user_number_id=1096257655&ssid=r11\" ,\t\"multipic\": \"0\" ,\t\"commend\":\"4\" , \"commendHref\":\"http://detail.tmall.com/item.htm?id=41679233118&_scm=1029.tbwt.item.3&on_comment=1\" ,\t\"spm\":\"d16\" ,\t\"sellerSpm\":\"d26\" ,\t\"source\":\"normal\" ,\t\"icon\": { \"all\":[ {\"name\":\"sp-mall\",\"title\":\"天猫\",\"value\":null,\"tag\":null,\"href\":\"http://www.tmall.com/\",\"type\":\"0\"} ,{\"name\":\"sp-credit\",\"title\":\"该商品支持信用卡付款\",\"value\":null,\"tag\":null,\"href\":\"http://www.taobao.com/go/act/sale/kadepay.php?ad_id=&am_id=&cm_id=14001249574b437a411d&pm_id=\",\"type\":\"2\"} ]\t} , \"sameItemInfo\":null ,\t\"ratesum\":\"9\" ,\t\"goodRate\":null ,\t\"dsrScore\":\"4.88\" } ] , \"page\": { \"totalPage\":\"2\", \"currentPage\":\"1\", \"pageSize\":\"3\" } , \"loc\": {\"selectedLoc\":\"所在地\"}\t, \"style\":{\"key\":\"style\",\"value\":\"list\"}\t, \"selectedCondition\": { \"totalNumber\":\"6\", \"keyword\": { \"key\":\"q\", \"value\":\"\" }, \"selectedPropertyList\": [ ] } , \"status\": { \"code\": \"200\" , \"url\": \"\" } }";
//    }
//}
//
