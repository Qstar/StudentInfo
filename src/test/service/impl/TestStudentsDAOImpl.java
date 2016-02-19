package test.service.impl;

import entity.Students;
import org.junit.Assert;
import org.junit.Test;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

import java.util.Date;
import java.util.List;

public class TestStudentsDAOImpl {
    @Test
    public void testQueryAllStudens() {
        StudentsDAO sdao = new StudentsDAOImpl();
        List<Students> list = sdao.queryAllStudents();
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void testGetNewSid() {
        StudentsDAOImpl sdao = new StudentsDAOImpl();
//        System.out.println(sdao.getNewSid());
    }

    @Test
    public void testAddStudents() {
        Students s = new Students();
        s.setSname("张三丰");
        s.setGender("男");
        s.setBirthday(new Date());
        s.setAddress("武当山");
        StudentsDAO sdao = new StudentsDAOImpl();
        Assert.assertEquals(true, sdao.addStudents(s));
    }
}
