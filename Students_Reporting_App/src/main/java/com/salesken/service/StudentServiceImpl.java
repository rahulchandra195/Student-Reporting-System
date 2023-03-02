package com.salesken.service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student addStudentAndMarks(Student student) throws StudentException {

		Optional<Student> checkPresence = studentRepo.findById(student.getId());

		if (checkPresence.isPresent())

			throw new StudentException("This Student is already resistered...Please add another one. ");

		else

			return studentRepo.save(student);
	}

	@Override
	public Integer getWholeClassAvgPercentageInRecentSem() throws StudentException {

		List<Student> students = studentRepo.findAll();

		if (students != null) {

			Integer totalMarks = 0;

			if (students.get(0).getMarks().getSem2_eng() != null) {
				for (Student s : students) {

					totalMarks = totalMarks
							+ (s.getMarks().getSem2_eng() + s.getMarks().getSem2_math() + s.getMarks().getSem2_sci());

				}

				return (totalMarks / (students.size() * 3)) / 100;
			} else {

				for (Student s : students) {

					totalMarks = totalMarks
							+ (s.getMarks().getSem1_eng() + s.getMarks().getSem1_math() + s.getMarks().getSem1_sci());

				}
				return (totalMarks / (students.size() * 3)) / 100;
			}

		} else {

			throw new StudentException("No Student found..! ");

		}

	}

	@Override
	public Map<String, Integer> getAvgMarksOfStudentInSubject() throws StudentException {

		Map<String, Integer> map = new HashMap<>();

		List<Student> students = studentRepo.findAll();

		if (students != null) {

			Integer totalSci = 0;

			for (Student s : students) {

				totalSci = totalSci + (s.getMarks().getSem1_sci());
				totalSci = totalSci + (s.getMarks().getSem2_sci());

				totalSci = totalSci / 2;

			}
			map.put("science", totalSci / students.size());

			Integer totalmath = 0;

			for (Student s : students) {

				totalmath = totalmath + (s.getMarks().getSem1_math());
				totalmath = totalmath + (s.getMarks().getSem2_math());

				totalmath = totalmath / 2;

			}
			map.put("math", totalmath / students.size());

			Integer totaleng = 0;

			for (Student s : students) {

				totaleng = totaleng + (s.getMarks().getSem1_eng());
				totaleng = totaleng + (s.getMarks().getSem2_eng());

				totaleng = totaleng / 2;

			}
			map.put("english", totaleng / students.size());

		} else {

			throw new StudentException("No Student found..! ");

		}

		return map;
	}

	@Override
	public ArrayList<String> topTwoConsistenceStudents() throws StudentException {

		List<Student> students = studentRepo.findAll();

		List<String> topStudents = new ArrayList<>();

		if (students != null) {

			TreeMap<Integer, String> map = new TreeMap<>();

			for (Student s : students) {

				map.put((s.getMarks().getSem1_eng() + s.getMarks().getSem1_math() + s.getMarks().getSem1_sci()
						+ s.getMarks().getSem2_eng() + s.getMarks().getSem2_math() + s.getMarks().getSem2_sci()),
						s.getName());

			}

			ArrayList<String> top = new ArrayList<>();

			for (Map.Entry<Integer, String> m : map.entrySet()) {

				top.add(m.getValue());

			}

			topStudents.add(top.get(top.size() - 1));
			topStudents.add(top.get(top.size() - 2));

			return  (ArrayList<String>) topStudents;

		} else {

			throw new StudentException("No Student found..! ");

		}

	}

}
