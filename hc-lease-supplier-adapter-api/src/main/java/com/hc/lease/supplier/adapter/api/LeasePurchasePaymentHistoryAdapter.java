package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeasePurchasePaymentHistory;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 采购融租还款记录Adapter
 * @author Qiang
 * @version 2017-05-12
 */

public interface LeasePurchasePaymentHistoryAdapter extends BaseAdapter<LeasePurchasePaymentHistory> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
