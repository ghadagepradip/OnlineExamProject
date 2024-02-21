package onlineexam.repository;

import java.util.ArrayList;

import onlineexam.model.StudentModel;

public class StudentRepository {

	static ArrayList stu=new ArrayList();
	public void addStudent (StudentModel s)
	{
		stu.add(s);
	}
	public ArrayList getStudent ()
	{
		return stu.size()>0?stu:null;
	}
	public boolean removeStudent(int id)
	{
		boolean b=false;
		try
		{
			if(stu.isEmpty())
			{
				return false;
			}
			for(Object obj:stu)
			{
				StudentModel student=(StudentModel)obj;
				if(student.getId()==id)
				{
					b=stu.remove(obj);
					b=true;
				}
			}
		}
		catch(Exception e)
		{
			return true;
		}
		
		return b;
	}
}
