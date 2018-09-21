package com.hc.lease.postlending.strategy.impl;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.constant.RepaymentStatusType;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.adapter.api.LeaseSchemeRepaymentStatusAdapter;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentService;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.postlending.adapter.api.LeaseOverdueLogAdapter;
import com.hc.lease.postlending.model.LeaseOverdueLog;
import com.hc.lease.postlending.service.api.LeaseOverdueLogService;
import com.hc.lease.postlending.strategy.Strategy;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 贷后
 * 定时检测逾期的月租并插入逾期流水
 * Created by Administrator on 2017/8/28.
 */
public class PostlendingCheckOverdueRepaymentStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        LeaseSchemeRepaymentStatusAdapter leaseSchemeRepaymentStatusAdapter = (LeaseSchemeRepaymentStatusAdapter) SpringContextHolder.getBean("leaseSchemeRepaymentStatusAdapter");
        LeaseSchemeRepaymentService leaseSchemeRepaymentService = (LeaseSchemeRepaymentService) SpringContextHolder.getBean("leaseSchemeRepaymentService");
        LeaseOverdueLogAdapter leaseOverdueLogAdapter = (LeaseOverdueLogAdapter) SpringContextHolder.getBean("leaseOverdueLogAdapter");

        Map<String, Object> paramsMap = null;
        Date nowDate = DateTime.now().toDate();
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentService.checkOverdue(paramsMap);//检测融租合同的已逾期，未扣款的月租
        List<LeaseOverdueLog> leaseOverdueLogInsertBatch = new ArrayList<LeaseOverdueLog>();
        List<LeaseOverdueLog> leaseOverdueLogUpdateBatch = new ArrayList<LeaseOverdueLog>();
        if (leaseSchemeRepaymentList != null) {
            if (leaseSchemeRepaymentList.size() > 0) {
                for (int i = 0; i < leaseSchemeRepaymentList.size(); i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentList.get(i);
                    Long accountId = leaseSchemeRepayment.getLesseeId();
                    Long id = leaseSchemeRepayment.getId();
                    Long contractId = leaseSchemeRepayment.getContractId();
                    Date repaymentDate = leaseSchemeRepayment.getRepaymentDate();
                    BigDecimal total = leaseSchemeRepayment.getTotal();
                    leaseSchemeRepayment.setOverdue(0);//是否逾期 0 是 1 否
                    leaseSchemeRepayment.setUpdateTime(nowDate);

                    Integer timeDifference = Integer.parseInt(String.valueOf(DateUtil.timeDifference(repaymentDate, nowDate)));//两个日期秒数相差
                    Integer overdueDayUp = DateUtil.secondsToDate(timeDifference);//逾期天数

                    leaseSchemeRepaymentList.get(i).setOverdueDay(overdueDayUp);

                    paramsMap = Maps.newHashMap();
                    paramsMap.put("repaymentId", id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id
                    paramsMap.put("contractId", contractId);
                    paramsMap.put("type", RepaymentStatusType.TYPE_0);//款项类型 0:月租;1:挂靠

                    //更新/新增 逾期记录 数据
                    LeaseOverdueLog leaseOverdueLog = leaseOverdueLogAdapter.selectByContractIdRepaymentId(paramsMap, dubboTreaceParames);
                    BigDecimal totalOverdue = leaseSchemeRepayment.getOverdueRate().multiply(new BigDecimal(overdueDayUp)).multiply(total).setScale(2, BigDecimal.ROUND_HALF_UP);//逾期金额
                    if (leaseOverdueLog != null) {//更新
                        leaseOverdueLog.setContractId(contractId);
                        leaseOverdueLog.setRepaymentId(id);
                        leaseOverdueLog.setUpdateTime(nowDate);
                        leaseOverdueLog.setOverdueDay(overdueDayUp);//逾期天数
                        leaseOverdueLog.setNowTime(nowDate);
                        leaseOverdueLog.setPrice(leaseSchemeRepayment.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseOverdueLogUpdateBatch.add(leaseOverdueLog);
                    } else {//新增
                        leaseOverdueLog = new LeaseOverdueLog();
                        leaseOverdueLog.setContractId(contractId);
                        leaseOverdueLog.setRepaymentId(id);
                        leaseOverdueLog.setUpdateTime(nowDate);
                        leaseOverdueLog.setOverdueDay(overdueDayUp);//逾期天数
                        leaseOverdueLog.setAccountId(accountId);
                        leaseOverdueLog.setCreateTime(nowDate);
                        leaseOverdueLog.setRepaymentTime(repaymentDate);
                        leaseOverdueLog.setNowTime(nowDate);
                        leaseOverdueLog.setPaymentResult(PaymentResult.TYPE_0);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                        leaseOverdueLog.setType(RepaymentStatusType.TYPE_0);//款项类型 0:月租;1:挂靠
                        leaseOverdueLog.setPrice(leaseSchemeRepayment.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseOverdueLogInsertBatch.add(leaseOverdueLog);
                    }
                    //更新/新增 逾期记录 数据

                    //插入逾期 支付状态汇总管理

                    paramsMap = Maps.newHashMap();
                    paramsMap.put("repaymentId", id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id
                    paramsMap.put("contractId", contractId);
                    paramsMap.put("type", RepaymentStatusType.TYPE_2);//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                    LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusAdapter.findByType(paramsMap, dubboTreaceParames);//查询某个合同某一期的某种款项的数据

                    if (leaseSchemeRepaymentStatus != null) {//修改
                        leaseSchemeRepaymentStatus.setRepaymentId(id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                        leaseSchemeRepaymentStatus.setContractId(contractId);//融租合同主键id
                        leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_2);//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                        leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setUpdateBy(null);
                        leaseSchemeRepaymentStatus.setTotlePrice(leaseSchemeRepayment.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseSchemeRepaymentStatusAdapter.updateByPrimaryKeySelective(leaseSchemeRepaymentStatus);
                    } else {//新增
                        leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                        leaseSchemeRepaymentStatus.setRepaymentId(id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                        leaseSchemeRepaymentStatus.setContractId(contractId);//融租合同主键id
                        leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_2);//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                        leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setUpdateBy(null);
                        leaseSchemeRepaymentStatus.setCreateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setCreateBy(null);
                        leaseSchemeRepaymentStatus.setTotlePrice(leaseSchemeRepayment.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                        leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
                        leaseSchemeRepaymentStatusAdapter.insertSelective(leaseSchemeRepaymentStatus);
                    }
                    //插入逾期 支付状态汇总管理

                }
                leaseSchemeRepaymentService.batchUpdate(leaseSchemeRepaymentList, dubboTreaceParames);//更新 还款记录 逾期

                //更新 逾期记录 数据
                if (leaseOverdueLogUpdateBatch.size() > 0) {
                    leaseOverdueLogAdapter.updateBatch(leaseOverdueLogUpdateBatch, dubboTreaceParames);
                }
                //更新 逾期记录 数据

                //新增 逾期记录 数据
                if (leaseOverdueLogInsertBatch.size() > 0) {
                    leaseOverdueLogAdapter.insertBatch(leaseOverdueLogInsertBatch, dubboTreaceParames);
                }
                //新增 逾期记录 数据

            }
        }

        return true;
    }
}
