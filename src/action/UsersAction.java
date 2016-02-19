package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Users;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users> {
    private Users user = new Users();

    public String login() {
        UsersDAO udao = new UsersDAOImpl();
        if (udao.usersLogin(user)) {
            //在session中保存登录成功的用户名
            session.setAttribute("loginUserName", user.getUsername());
            return "login_success";
        } else {
            return "login_failure";
        }
    }

    //用户注销
    @SkipValidation
    public String logout() {
        if (session.getAttribute("loginUserName") != null) {
            session.removeAttribute("loginUserName");
        }
        return "logout_success";
    }

    @Override
    public Users getModel() {
        return this.user;
    }

    @Override
    public void validate() {
        if ("".equals(user.getUsername().trim())) {
            this.addFieldError("usernameError", "用户名不能为空!");
        }

        if (user.getPassword().length() < 6) {
            this.addFieldError("passwordError", "密码长度不少于6位!");
        }
    }
}
