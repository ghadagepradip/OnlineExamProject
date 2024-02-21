package onlineexam.client;

import java.util.*;

import onlineexam.model.ExamScheduleModel;
import onlineexam.model.Question;
import onlineexam.model.StudentModel;
import onlineexam.service.ExamServices;
import onlineexam.service.QuestionService;
import onlineexam.service.StudentServices;

public class OnlineExamClientApplication {
	public static void main(String[] args) {

		QuestionService qService = new QuestionService();
		ExamServices eServices = new ExamServices();
		StudentServices sServices =new StudentServices();
		ExamScheduleModel model = null;
		do {
			System.out.println("1.Add new question");
			System.out.println("2.View all question");
			System.out.println("3.Add new exam with schedule");
			System.out.println("4.View exam schedule");
			System.out.println("5.Attempt exam by student");
			System.out.println("6.Delete question");
			System.out.println("7.Update question");
			System.out.println("8.Update Exam schedule");
			System.out.println("9.Show student record who has attempted exam");
			System.out.println("10.Delete Student record");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				sc.nextLine();
				System.out.println("Enter Question,its 4 Option and Answer");
				String qname = sc.nextLine();
				String op1 = sc.nextLine();
				String op2 = sc.nextLine();
				String op3 = sc.nextLine();
				String op4 = sc.nextLine();
				String answer = sc.nextLine();
				Question q = new Question(qname, op1, op2, op3, op4, answer);
				boolean b = qService.isAddQuestion(q);
				if (b) {
					System.out.println("Question added succesfully...");
				} else {
					System.out.println("Some problem...");
				}
				break;
			}

			case 2:
				ArrayList al = qService.getAllQuestion();
				if (al != null) {
					for (Object obj : al) {
						Question q1 = (Question) obj;
						System.out.println(q1.getId() + "\t" + q1.getName() + "\t" + q1.getOp1() + "\t" + q1.getOp2()
								+ "\t" + q1.getOp3() + "\t" + q1.getOp4() + "\t" + q1.getAnswer());
					}
				} else {
					System.out.println("No questions are available...");
				}
				break;

			case 3: {
				System.out.println("Enter Exam id,name,date,StarTime and EndTime");
				int eid = sc.nextInt();
				sc.nextLine();
				String ename = sc.nextLine();
				String edate = sc.nextLine();
				String eStarTime = sc.nextLine();
				String eEndTime = sc.nextLine();
				ExamScheduleModel esc = new ExamScheduleModel(eid, ename, edate, eStarTime, eEndTime);
				boolean b = eServices.scheduleExam(esc);
				if (b) {
					System.out.println("Exam scheduled succesfully...");
				} else {
					System.out.println("There is no question bank so no exam schedule...");
				}
				break;
			}

			case 4:
				al = eServices.getExamSchedules();
				if (al != null) {
					for(Object obj1:al)
					{
						 model=(ExamScheduleModel)obj1;
					System.out.println(model.getId() + "\t" + model.getName() + "\t" + model.getDate() + "\t"
							+ model.getStaTime() + "\t" + model.getEndTime() + "\t");
					al = model.getQuestionBank();
					System.out.println("-----------------------------------------------------");
					for (Object obj : al) {
						Question q = (Question) obj;
						System.out.println(q.getId() + "\t" + q.getName() + "\t" + q.getOp1() + "\t" + q.getOp2() + "\t"
								+ q.getOp3() + "\t" + q.getOp4() + "\t" + q.getAnswer());
					}
					System.out.println("-------X---------------------X-------------------X------");
					}
				} else {
					System.out.println("There is no exam schedule...");
				}
				break;

			case 5:
				StudentModel smodel = new StudentModel();
				System.out.println("Enter student id and name");
				int sid=sc.nextInt();
				sc.nextLine();
				String sname=sc.nextLine();
				smodel.setId(sid);
				smodel.setName(sname);
				smodel.setModel(model);
				if (model != null) {
					smodel.setModel(model);
					al = model.getQuestionBank();
					if (al.size() > 0) {
						int index = 0;
						do {
							Question q = (Question) al.get(index);
							System.out.println("Question is: " + q.getName());
							System.out.println("option 1: " + q.getOp1());
							System.out.println("option 2: " + q.getOp2());
							System.out.println("option 3: " + q.getOp3());
							System.out.println("option 4: " + q.getOp4());
							System.out.println("Enter your answer: ");
//							sc.nextLine();
							String answer1 = sc.nextLine();
							if (answer1.equals(q.getAnswer())) {
								q.setStatus(true);
							}
							index++;
						} while (index != al.size());
						
						System.out.println("All questions ");
						int count=0;
						for (Object obj : al) {
							Question q = (Question) obj;
							System.out.println(q.getId() + "\t" + q.getName() + "\t" + q.getOp1() + "\t" + q.getOp2()
									+ "\t" + q.getOp3() + "\t" + q.getOp4() + "\t" + q.getAnswer() + "\t"
									+ q.isStatus());
							if(q.isStatus())
							{
								++count;
							}
						}
						int wrongquestion=al.size()-count;
						float per=((float)((float)count/(float)al.size())*100);
						smodel.setPer(per);
						System.out.println("-----------------------------------------------------");
						System.out.println("Total number of question is "+al.size());
						System.out.println("Total right question "+count);
						System.out.println("Total wrong question "+wrongquestion);
						System.out.println("You total percentage is: "+per);
						System.out.println("-----------------------------------------------------");
						
						sServices.addStudent(smodel);
						
						for (Object obj : al) {
							Question q = (Question) obj;
							if(q.isStatus())
							{
								q.setStatus(false);
							}
						}
					} else {
						System.out.println("Wait for question paper...");
					}

				} else {
					System.out.println("There is no exam...");
				}
				break;
				
			case 6:
				System.out.println("Enter question id to delete: ");
				int id=sc.nextInt();
				al=qService.getAllQuestion();
				boolean b1;
				int flag=0;
				for(Object obj:al)
				{
					Question q1=(Question)obj;
					if(q1.getId()==id)
					{
						System.out.println(q1.getId() + "\t" + q1.getName() + "\t" + q1.getOp1() + "\t" + q1.getOp2()
						+ "\t" + q1.getOp3() + "\t" + q1.getOp4() + "\t" + q1.getAnswer());
						System.out.println("Do you want to delete this question...(yes/no)");
						sc.nextLine();
						String opt=sc.nextLine();
						if(opt.equals("yes"))
						{
							flag=1;
						}
						else {
							flag=2;
						}
						break;
						
					}
				}
				if(flag==1)
				{
					 b1=qService.removeQuestion(id);
					 if(b1)
						{
							System.out.println("Question deleted succesfully...");
						}
						else
						{
							System.out.println("Something is wrong...");
						}
				}
				else if(flag==2)
				{
					System.out.println("Question not deleted");
				}
				else
				{
					System.out.println("Question id not found");
				}
				
				break;
				
			case 7:
				System.out.println("Enter question id to update: ");
				int id1=sc.nextInt();
				al=qService.getAllQuestion();
				Question q1=null;
				boolean b2;
				int flag1=0;
				for(Object obj:al)
				{
					 q1=(Question)obj;
					if(q1.getId()==id1)
					{
						System.out.println(q1.getId() + "\t" + q1.getName() + "\t" + q1.getOp1() + "\t" + q1.getOp2()
						+ "\t" + q1.getOp3() + "\t" + q1.getOp4() + "\t" + q1.getAnswer());
						System.out.println("Do you want to update this question...(yes/no)");
						sc.nextLine();
						String opt=sc.nextLine();
						if(opt.equals("yes"))
						{
							flag1=1;
						}
						else {
							flag1=2;
						}
						break;
						
					}
				}
				if(flag1==1)
				{		
					 b1=qService.updateQuestion(q1);
					 if(b1)
						{
							System.out.println("Question updated succesfully...");
						}
						else
						{
							System.out.println("Something is wrong...");
						}
				}
				else if(flag1==2)
				{
					System.out.println("Question not updated");
				}
				else
				{
					System.out.println("Question id not found");
				}
				
				break;
			
			case 8:
				System.out.println("Enter exam name to update: ");
//				sc.nextLine();
				String uename=sc.nextLine();
				al=eServices.getExamSchedules();
				ExamScheduleModel exam=null;
				
				boolean eb;
				int eflag=0;
				for(Object obj:al)
				{
				 exam=(ExamScheduleModel)obj;
					if(exam.getName().equals(uename))
					{
						System.out.println(exam.getId() + "\t" + exam.getName() + "\t" + exam.getDate() + "\t" + exam.getStaTime()
						+ "\t" + exam.getEndTime());
						System.out.println("Do you want to update this exam schedule...(yes/no)");
						sc.nextLine();
						String opt=sc.nextLine();
						if(opt.equals("yes"))
						{
							eflag=1;
						}
						else {
							eflag=2;
						}
						break;
						
					}
				}
				if(eflag==1)
				{		
					 b1=eServices.updateExamSchedule(exam);
					 if(b1)
						{
							System.out.println("Exam schedule updated succesfully...");
						}
						else
						{
							System.out.println("Something is wrong...");
						}
				}
				else if(eflag==2)
				{
					System.out.println("Exam schedule  not updated");
				}
				else
				{
					System.out.println("Exam schedule not found");
				}
				break;
				
			case 9:
				al = sServices.getStudent();
				StudentModel m1=null;
				if (al != null) {
					for(Object obj1:al)
					{
						m1 =(StudentModel)obj1;
					System.out.println(m1.getId() + "\t" + m1.getName() + "\t" + m1.getModel().getName()+"\t"+m1.getPer());
					}
				} else {
					System.out.println("There are no student records...");
				}
				break;
				
			case 10:
				
				
				System.out.println("Enter Student id to delete: ");
				int stuid=sc.nextInt();
				al=sServices.getStudent();
				if(al==null)
				{
					System.out.println(" No Student present");
					break;
				}
					
				boolean stub;
				int stuflag=0;
				for(Object obj:al)
				{
					StudentModel stu=(StudentModel)obj;
					if(stu.getId()==stuid)
					{
						System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getModel().getName()+"\t"+stu.getPer());
						System.out.println("Do you want to delete this student...(yes/no)");
						sc.nextLine();
						String opt=sc.nextLine();
						if(opt.equals("yes"))
						{
							stuflag=1;
						}
						else {
							stuflag=2;
						}
						break;
						
					}
				}
				if(stuflag==1)
				{
					stub=sServices.removeStudent(stuid);
					 if(stub)
						{
							System.out.println("Student deleted succesfully...");
						}
						else
						{
							System.out.println("Something is wrong...");
						}
				}
				else if(stuflag==2)
				{
					System.out.println("Student not deleted");
				}
				else
				{
					System.out.println("Student id not found");
				}
				
				
				break;
			default:
				System.out.println("Please enter correct choice...");
			}

		} while (true);

	}
}
