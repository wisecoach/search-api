package com.watering.constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/21/14:52
 * @Description: 登录响应码常量类
 */
public class LoginResponseCodeConst extends ResponseCodeConst{
    public static final LoginResponseCodeConst LOGIN_ERROR = new LoginResponseCodeConst(201, "账号未登录");

    public static final LoginResponseCodeConst NOT_HAVE_PRIVILEGES = new LoginResponseCodeConst(202, "无权访问");

    public static final LoginResponseCodeConst ACCOUNT_ERROR = new LoginResponseCodeConst(203,"账号或密码错误");

    public static final LoginResponseCodeConst LOGIN_SUCCESS = new LoginResponseCodeConst(204,"登录成功",true);

    public static final LoginResponseCodeConst LOGOUT_SUCCESS = new LoginResponseCodeConst(205,"登出成功",true);

    public LoginResponseCodeConst(int code, String msg) {
        super(code, msg);
    }

    public LoginResponseCodeConst(int code,String mag,boolean success){
        super(code,mag,success);
    }
}
