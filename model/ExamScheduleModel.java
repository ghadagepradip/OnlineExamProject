package onlineexam.model;

import java.util.ArrayList;

public class ExamScheduleModel {
	private int id;
	private String name;
	private String date;
	private String starTime,endTime;
	private ArrayList questionBank;
	
	
	public ExamScheduleModel() {
		
	}
	public ExamScheduleModel(int id,String name, String date, String starTime, String endTime) {
		this.id=id;
		this.name = name;
		this.date = date;
		this.starTime = starTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStaTime() {
		return starTime;
	}
	public void setStaTime(String staTime) {
		this.starTime = staTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public ArrayList getQuestionBank() {
		return questionBank;
	}
	public void setQuestionBank(ArrayList questionBank) {
		this.questionBank = questionBank;
	}
}
