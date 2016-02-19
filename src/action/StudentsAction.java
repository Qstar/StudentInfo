package action;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

import java.text.SimpleDateFormat;
import java.util.List;

public class StudentsAction extends SuperAction {
    public String query() {
        StudentsDAO sdao = new StudentsDAOImpl();
        List<Students> list = sdao.queryAllStudents();
        if (list != null && list.size() > 0) {
            session.setAttribute("students_list", list);
        }
        return "query_success";
    }

    public String delete() {
        StudentsDAO sdao = new StudentsDAOImpl();
        String sid = request.getParameter("sid");
        sdao.deleteStudents(sid);
        return "delete_success";

    }

    public String add() throws Exception {
        Students s = new Students();
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        s.setBirthday(sdf.parse(request.getParameter("birthday")));
        s.setAddress(request.getParameter("address"));
        StudentsDAO sdao = new StudentsDAOImpl();
        sdao.addStudents(s);
        return "add_success";
    }

    public String modify() {
        String sid = request.getParameter("sid");
        StudentsDAO sdao = new StudentsDAOImpl();
        Students s = sdao.queryStudentBySid(sid);
        session.setAttribute("modify_students", s);
        return "modify_success";
    }

    public String save() throws Exception {
        Students s = new Students();
        s.setSid(request.getParameter("sid"));
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        s.setBirthday(sdf.parse(request.getParameter("birthday")));
        s.setAddress(request.getParameter("address"));
        StudentsDAO sdao = new StudentsDAOImpl();
        sdao.updateStudents(s);
        return "save_success";
    }
}
