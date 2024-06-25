package com.LibraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.LibraryManagement.model.Student;

@Transactional
public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Modifying
	@Query("update Student s set s.emailId=:newEmail where s.emailId=:oldEmail")
	int updateStudentEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);

	@Modifying
	@Query("delete from Student s where s.id=:id ")
	int deleteCustom(@Param("id") int id);

	@Modifying
	@Query("update Student s set s.emailId= :#{#student.emailId}," + "s.name=:#{#student.name},"
			+ "s.age=:#{#student.age}," + "s.country=:#{#student.country} where s.id=:#{#student.id}")
	int updateStudentDetails(@Param("student") Student student);

	@Query("select b from Student b where b.emailId=: mail")
	List<Student> find_by_mail(String mail);

	@Query(value = "select * from student s where s.email_id=:mail", nativeQuery = true)
	List<Student> findbymail(String mail);

}