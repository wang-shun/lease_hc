package hc.lease.common.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 等额本息工具类
 * 等额本息还款，也称定期付息，即借款人每月按相等的金额偿还贷款本息，其中每月贷款利息按月初剩余贷款本金计算并逐月结清。把按揭贷款的本金总额与利息总额相加，
 * 然后平均分摊到还款期限的每个月中。作为还款人，每个月还给银行固定金额，但每月还款额中的本金比重逐月递增、利息比重逐月递减。
 */

public class AverageCapitalPlusInterestUtils {

    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还本金和利息
     * <p>
     * 公式：每月偿还本息=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还本金和利息, 不四舍五入，直接截取小数点最后两位
     */
    public static double getPerMonthPrincipalInterest(double invest, double yearRate, int totalmonth) {
        double monthRate = yearRate / 12;
        BigDecimal monthIncome = new BigDecimal(invest)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_HALF_UP);
        return monthIncome.doubleValue();
    }

    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还利息
     * <p>
     * 公式：每月偿还利息=贷款本金×月利率×〔(1+月利率)^还款月数-(1+月利率)^(还款月序号-1)〕÷〔(1+月利率)^还款月数-1〕
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还利息
     */
    public static Map<Integer, BigDecimal> getPerMonthInterest(double invest, double yearRate, int totalmonth, double balancePayment) {
        Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();
        double month = totalmonth / 12;
        BigDecimal big = new BigDecimal(balancePayment * yearRate * month / totalmonth);
        double monthRate = yearRate / 12;
        BigDecimal monthInterest;
        for (int i = 1; i < totalmonth + 1; i++) {
            BigDecimal multiply = new BigDecimal(invest).multiply(new BigDecimal(monthRate));
            BigDecimal sub = new BigDecimal(Math.pow(1 + monthRate, totalmonth)).subtract(new BigDecimal(Math.pow(1 + monthRate, i - 1)));
            monthInterest = multiply.multiply(sub).divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 6, BigDecimal.ROUND_HALF_UP);
            monthInterest = monthInterest.add(big);
            monthInterest = monthInterest.setScale(2, BigDecimal.ROUND_HALF_UP);
            map.put(i, monthInterest);
        }
        return map;
    }

    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还本金
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还本金
     */
    public static Map<Integer, BigDecimal> getPerMonthPrincipal(double invest, double yearRate, int totalmonth, double balancePayment) {
        double monthRate = yearRate / 12;
        double month = totalmonth / 12;
        BigDecimal big = new BigDecimal(balancePayment * yearRate * month / totalmonth);
        BigDecimal monthIncome = new BigDecimal(invest)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_HALF_UP)
                .add(big).setScale(2, BigDecimal.ROUND_HALF_UP);

        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, totalmonth, balancePayment);
        Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();

        for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
            mapPrincipal.put(entry.getKey(), monthIncome.subtract(entry.getValue()));
        }
        return mapPrincipal;
    }

    /**
     * 等额本息计算获取还款方式为等额本息的总利息
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 总利息
     */
   /* public static double getInterestCount(double invest, double yearRate, int totalmonth) {
        BigDecimal count = new BigDecimal(0);
        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, totalmonth);

        for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
            count = count.add(entry.getValue());
        }
        return count.doubleValue();
    }*/

    /**
     * 应还本金总和
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 应还本金总和
     */
    public static double getPrincipalInterestCount(double invest, double yearRate, int totalmonth) {
        double monthRate = yearRate / 12;
        BigDecimal perMonthInterest = new BigDecimal(invest)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal count = perMonthInterest.multiply(new BigDecimal(totalmonth));
        count = count.setScale(2, BigDecimal.ROUND_HALF_UP);
        return count.doubleValue();
    }


    /**
     * 计算本息(加上尾付利息)
     *
     * @param invest         客户综合报价-首期金额-尾款
     * @param yearRate       年利率
     * @param totalmonth     总月份
     * @param balancePayment 尾款
     * @return
     */
    public static double getPerMonthPrincipalInterestAndBalancePayment(double invest, double yearRate, int totalmonth, double balancePayment) {
        double monthRate = yearRate / 12;
        double month = totalmonth / 12;
        BigDecimal big = new BigDecimal(balancePayment * yearRate * month / totalmonth);//尾款利息
        double baseOne = Math.pow(1 + monthRate, totalmonth) - 1;
        System.out.println("baseOne：" + baseOne);
        BigDecimal monthIncome = new BigDecimal(invest);
        monthIncome = monthIncome.multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)));//乘法
        //monthIncome = monthIncome.divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_HALF_UP);//除法
        double monthIncomeOne = monthIncome.doubleValue();
        double monthIncomeTwo = monthIncomeOne / baseOne;
        monthIncome = new BigDecimal(monthIncomeTwo);
        monthIncome = monthIncome.add(big);//加法
        System.out.println("monthIncome：" + monthIncome);
        return monthIncome.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 由月供计算客户综合报价
     *
     * @param monthIncome    月供
     * @param yearRate       年利率
     * @param totalmonth     总月份
     * @param balancePayment 尾款
     * @return
     */
    public static double getComprehensiveQuote(double monthIncome, double yearRate, int totalmonth, double balancePayment) {
        double monthRate = yearRate / 12;
        double month = totalmonth / 12;
        BigDecimal big = new BigDecimal(balancePayment * yearRate * month / totalmonth);//尾款利息
        BigDecimal baseOne = new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1);
        BigDecimal baseTwo = new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth));
        BigDecimal comprehensiveQuote = new BigDecimal(monthIncome);
        comprehensiveQuote = comprehensiveQuote.subtract(big);
        comprehensiveQuote = comprehensiveQuote.multiply(baseOne);
        comprehensiveQuote = comprehensiveQuote.divide(baseTwo, 2, BigDecimal.ROUND_HALF_UP);
        return comprehensiveQuote.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        double invest = 16400; // 本金
        int month = 36;
        double yearRate = 0.17; // 年利率
        double money = 41800;
        double perMonthPrincipalInterest = getPerMonthPrincipalInterestAndBalancePayment(invest, yearRate, month, money);
        System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);

        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, month, money);
        System.out.println("等额本息---每月还款利息：" + mapInterest);
        Map<Integer, BigDecimal> mapPrincipal = getPerMonthPrincipal(invest, yearRate, month, money);
        System.out.println("等额本息---每月还款本金：" + mapPrincipal);
        /*double count = getInterestCount(invest, yearRate, month);
        System.out.println("等额本息---总利息：" + count);*/
        /*double principalInterestCount = getPrincipalInterestCount(invest, yearRate, month);
        System.out.println("等额本息---应还本息总和：" + principalInterestCount);*/

        BigDecimal residualPrincipal = new BigDecimal(invest);

        for (int i = 1; i <= month; i++) {
            residualPrincipal = residualPrincipal.subtract(mapPrincipal.get(i));


            System.out.println("等额本息---剩余本金:" + residualPrincipal);
        }


    }
}
