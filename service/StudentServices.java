package onlineexam.service;

import java.util.ArrayList;

import onlineexam.model.StudentModel;
import onlineexam.repository.StudentRepository;

public class StudentServices {
	
	StudentRepository repo =new StudentRepository();
	public void addStudent (StudentModel s)
	{
		repo.addStudent(s);
	}
	public ArrayList getStudent ()
	{
		return repo.getStudent();
	}
	public boolean removeStudent(int id)
	{
		return repo.removeStudent(id);
	}

}
