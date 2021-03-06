package com.hc.lease.user.adapter.api;

import com.hc.lease.user.model.LeaseAuthoUserOrganization;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 用户-公司、部门、组中间表，用户所属的组织Adapter
 * @author tong
 * @version 2018-08-27
 */

public interface LeaseAuthoUserOrganizationAdapter extends BaseAdapter<LeaseAuthoUserOrganization> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int deleteByUserId(Long userId) throws GMException;

}
