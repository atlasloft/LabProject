package lab.PureUI;

import core.AdminTableV;

/**
 * Created by minute on 2017/2/2.
 */

//import db.Tools;

//管理员登录界面
public class View {
    UIStateManager uism = new UIStateManager();
    //主界面
    Home home = new Home();
    //报名界面
    Register register = new Register();
    //管理员管理界面
    AdminTableV adminTableV = new AdminTableV();
    //管理员登录界面
    AdminLogin adminLogin = new AdminLogin();

    //    ArrayList UIList = Lists.newArrayList(home,register,adminLogin,adminTableV);
    //如果所有UI类都实现initializable 接口,或许就可以遍历初始化?
    //都继承showable 接口 ,就可以用 接口建立对象 进行 遍历了吧
    public void init() {
        home.init();
        register.init();
        adminLogin.init();
        adminTableV.init();
    }




}