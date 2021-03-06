package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

@Repository("projectRepository")
public class ProjectRepositoryImpl implements ProjectRepository
{

    @PersistenceContext
    private EntityManager em;
    
    public Project find(Long projectId) {
        // Returns the Project for given projectId.
        return em.find(Project.class, projectId);
    }

    public Project save(Project project) {
        // Saves the given project object and returns the same.
        em.persist(project);
        em.flush();
        return project;
    }

    @Override
    public List<Project> findAll() {
        // Returns all the projects in our system.
        TypedQuery<Project> query = em.createNamedQuery("Project.findAll", Project.class);
        List<Project> results = query.getResultList();
        return results;
    }

    @Override
    public Project update(Project project, Long projectId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Project delete(Long projectId)
    {
        Project projectToBeDeleted = em.find(Project.class, projectId); 
        em.remove(projectToBeDeleted);
        return projectToBeDeleted;
    }

	@Override
	public List<Task> findTasksByProjectId(Long projectId) {
			return em.find(Project.class,projectId).getTasks();
	}

}
