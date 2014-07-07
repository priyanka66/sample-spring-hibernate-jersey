package com.hashedin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tasks")
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t") ,
				@NamedQuery(name="Task.findByStatus", query = "SELECT t FROM Task t WHERE t.status = :status")})

public class Task {

	@Id
	@GeneratedValue
	private Long taskId;

	private String title;
	private String createdDate;
	private String endDate;
	private String  status;
	
	
	@ManyToOne
	@JoinColumn(name="userId" ,referencedColumnName="userId")
    private User user;
	
	@ManyToOne
	@JoinColumn(name="projectId" ,referencedColumnName="projectId")
	private Project project;
	
	public Project getProject() {
		return project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", project=" + project + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
