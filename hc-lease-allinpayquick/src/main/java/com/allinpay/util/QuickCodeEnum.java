package com.allinpay.util;

/**
 * 通联协议支付返回状态码
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum QuickCodeEnum {

    //////////////////////////////////////////通联报文头部返回码状态//////////////////////////////////////////

    //////////////成功状态//////////////
    HEAD_CODE_0000("0000", "处理成功"),
    //////////////成功状态//////////////

    //////////////中间状态//////////////
    HEAD_CODE_2007("2007", "交易处理中，请重新发起查询"),
    HEAD_CODE_2008("2008", "交易处理中，请重新发起查询"),
    HEAD_CODE_0001("0001", "系统处理失败，请重新发起"),
    HEAD_CODE_1000("1000", "查询处理异常，请重新发起"),
    HEAD_CODE_1001("1001", "报文解释错，查询报文有问题，请检查后重新发起"),
    //////////////中间状态//////////////

    //////////////失败状态//////////////
    HEAD_CODE_1002("1002", "报文解释错，查询报文有问题，请检查后重新发起"),
    //////////////失败状态//////////////

    //////////////////////////////////////////通联报文头部返回码状态//////////////////////////////////////////


    //////////////////////////////////////////通联报文明细返回码状态//////////////////////////////////////////

    //////////////成功状态//////////////
    REQ_CODE_0000("0000", "处理成功"),
    //////////////成功状态//////////////

    //////////////失败状态//////////////
    REQ_CODE_3602("3602", "处理失败"),//处理失败(最终失败)
    REQ_CODE_3999("3999", "验证码不一致"),//通联协议支付签约 验证码不一致
    REQ_CODE_3888("3888", "身份验证失败"),//
    REQ_CODE_3079("3079", "手机号错或非银行预留手机号"),//
    REQ_CODE_3078("3078", "渠道金额超限"),//
    REQ_CODE_3077("3077", "证件类型或号码错误"),//
    REQ_CODE_3076("3076", "帐号类型不正确"),//
    REQ_CODE_3075("3075", "商户需要在银行或中心登记"),//
    REQ_CODE_3074("3074", "省份信息空缺或错误"),//
    REQ_CODE_3073("3073", "省份信息错误或账号户名不符"),//
    REQ_CODE_3072("3072", "提交金额等于或低于应收取的手续费"),//
    REQ_CODE_3071("3071", "外部系统错误"),//
    REQ_CODE_3070("3070", "处理活期产品主档错误"),//
    REQ_CODE_3069("3069", "长期不动户，请到柜台办理业务"),//
    REQ_CODE_3068("3068", "非个人活期结算户"),//
    REQ_CODE_3067("3067", "该账户已欠费，不能办理此业务"),//
    REQ_CODE_3066("3066", "渠道不支持，交易无法支持"),//
    REQ_CODE_3065("3065", "户名错"),//
    REQ_CODE_3064("3064", "账户不支持"),//
    REQ_CODE_3063("3063", "证件类型和证件号码未输"),//
    REQ_CODE_3062("3062", "无折账号不允许交易"),//
    REQ_CODE_3061("3061", "密码初始状态不正确"),//
    REQ_CODE_3060("3060", "格式错误"),//
    REQ_CODE_3059("3059", "密码挂失"),//
    REQ_CODE_3058("3058", "数字签名或证书错"),//
    REQ_CODE_3057("3057", "账户状态错误"),//
    REQ_CODE_3056("3056", "退票"),//
    REQ_CODE_3055("3055", "当日通兑业务累计金额超过规定金额"),//
    REQ_CODE_3054("3054", "批量回执包超过规定最长回执期限（N日）"),//
    REQ_CODE_3053("3053", "批量回执包未到规定最短回执期限（M日）"),//
    REQ_CODE_3052("3052", "找不到原业务"),//
    REQ_CODE_3051("3051", "重复业务"),//
    REQ_CODE_3050("3050", "业务已撤销"),//
    REQ_CODE_3049("3049", "业务已被拒绝，不能撤销"),//
    REQ_CODE_3048("3048", "业务已经清算，不能撤销"),//
    REQ_CODE_3047("3047", "合同（协议）号已撤销"),//
    REQ_CODE_3046("3046", "合同（协议）号还没有生效"),//
    REQ_CODE_3045("3045", "合同（协议）号在协议库里不存在"),//
    REQ_CODE_3044("3044", "超时拒付"),//
    REQ_CODE_3043("3043", "未与银行签约"),//
    REQ_CODE_3042("3042", "交易金额小于该储种的最低支取金额"),//
    REQ_CODE_3041("3041", "非存折户"),//
    REQ_CODE_3040("3040", "金额错误"),//
    REQ_CODE_3039("3039", "账户已关户"),//
    REQ_CODE_3038("3038", "非通兑户"),//
    REQ_CODE_3037("3037", "磁卡未生效"),//
    REQ_CODE_3036("3036", "货币错误"),//
    REQ_CODE_3035("3035", "找不到原记录"),//
    REQ_CODE_3034("3034", "非活期账号"),//
    REQ_CODE_3033("3033", "无此原交易"),//
    REQ_CODE_3032("3032", "账号货币不符"),//
    REQ_CODE_3031("3031", "账号户名不符"),//
    REQ_CODE_3030("3030", "账号错误"),//
    REQ_CODE_3029("3029", "交易已被冲正"),//
    REQ_CODE_3028("3028", "系统忙，请稍后再提交"),//
    REQ_CODE_3027("3027", "原始交易不成功"),//
    REQ_CODE_3026("3026", "发卡方保密子系统失败"),//
    REQ_CODE_3025("3025", "PIN格式出错"),//
    REQ_CODE_3024("3024", "日期切换进行中"),//
    REQ_CODE_3023("3023", "当日存入的金额当日不能支取"),//
    REQ_CODE_3022("3022", "存折号码有误"),//
    REQ_CODE_3021("3021", "未登折行数超限"),//
    REQ_CODE_3020("3020", "账户被临时锁定"),//
    REQ_CODE_3019("3019", "原交易已被取消或冲正"),//
    REQ_CODE_3018("3018", "已清户"),//
    REQ_CODE_3017("3017", "账户已冻结"),//
    REQ_CODE_3016("3016", "已挂失折"),//
    REQ_CODE_3015("3015", "超出取款次数限制"),//
    REQ_CODE_3014("3014", "原始金额不正确"),//
    REQ_CODE_3013("3013", "超出提款限额"),//
    REQ_CODE_3012("3012", "不允许持卡人进行的交易，请联系发卡行"),//
    REQ_CODE_3011("3011", "密码错"),//
    REQ_CODE_3010("3010", "过期卡"),//
    REQ_CODE_3009("3009", "无此账户"),//
    REQ_CODE_3008("3008", "余额不足"),//
    REQ_CODE_3007("3007", "被窃卡"),//
    REQ_CODE_3006("3006", "已挂失卡"),//
    REQ_CODE_3005("3005", "受卡方与安全保密部门联系"),//
    REQ_CODE_3004("3004", "无效卡号"),//
    //////////////失败状态//////////////

    //////////////中间状态//////////////
    REQ_CODE_2000("2000", "没有该项业务的授权");//
    //////////////中间状态//////////////

    //////////////////////////////////////////通联报文明细返回码状态//////////////////////////////////////////
    private String code;
    private String name;

    QuickCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
