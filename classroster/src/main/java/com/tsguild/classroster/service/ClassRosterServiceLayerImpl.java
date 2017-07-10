/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.service;

import com.tsguild.classroster.dao.ClassRosterAuditDao;
import com.tsguild.classroster.dao.ClassRosterDao;
import com.tsguild.classroster.dao.ClassRosterPersistenceException;
import com.tsguild.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{
    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
       
        if(dao.getStudent(student.getStudentId()) != null){
            throw new ClassRosterDuplicateIdException("ERROR: Could not create student, a student with the Student ID: " + student.getStudentId() + " already exists.");
        }
        
        validateStudentData(student);
        
        dao.addStudent(student.getStudentId(), student);
        //auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
        
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        //auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
    
    
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException{
        if(student.getFirstName()== null || student.getFirstName().trim().length() == 0 || student.getLastName() == null|| student.getLastName().trim().length() == 0 || student.getCohort() == null || student.getCohort().trim().length() == 0){
            throw new ClassRosterDataValidationException("Error: First name, Last name, and Cohort are all REQUIRED fields!!!");
        }
    }
}
