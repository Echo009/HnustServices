package cn.echo0.hnustservices.common;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 08:18 PM
 */
public enum ResponseCode {
    SUCCESS(0, "success"),
    ERROR(1, "error"),
    ILLEGAL_ARGUMENT(2, "illegal_argument"),
    INCORRECT_USER_INFO(3,"incorrect stuId or password");
    private final int code;
    private final String desc;
    private ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
