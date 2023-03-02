package com.salesken.service;

import java.util.ArrayList;
import java.util.Map;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;

public interface StudentService {

	public Student addStudentAndMarks(Student student) throws StudentException;
	
	
	public Integer getWholeClassAvgPercentageInRecentSem() throws StudentException;
	
	
	public Map<String,Integer> getAvgMarksOfStudentInSubject() throws StudentException;
	
	
	public ArrayList<String> topTwoConsistenceStudents() throws StudentException;
	
}
