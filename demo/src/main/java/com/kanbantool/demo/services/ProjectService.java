package com.kanbantool.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanbantool.demo.domain.Project;
import com.kanbantool.demo.repositories.ProjectRepository;
import com.kanbantool.demo.exceptions.ProjectIdException;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		
		try {
			project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase());
			return projectRepository.save(project);
		}catch (Exception e) {
			throw new ProjectIdException("Project ID "+ project.getProjectIdentifer().toUpperCase() + "already exists");
		}
	}
}
