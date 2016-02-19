package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//所有Action动作的父类
public class SuperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ServletContext application;

    @Override
    public void setServletContext(ServletContext application) {
        this.application = application;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        this.session = this.request.getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
