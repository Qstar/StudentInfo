package service;

import entity.Students;

import java.util.List;

public interface StudentsDAO {
    List<Students> queryAllStudents();

    Students queryStudentBySid(String sid);

    boolean addStudents(Students s);

    boolean updateStudents(Students s);

    boolean deleteStudents(String sid);
}
