package com.icsd.serviceImpl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.icsd.model.DeptModel;
import com.icsd.repo.DeptRepo;
import com.icsd.Service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

	private final DeptRepo deptRepo;

	@Override
	public DeptModel saveDept(DeptModel dept) {
		// TODO Auto-generated method stub
		return deptRepo.save(dept);
		
	}

	@Override
	public List<DeptModel> getAllDepts() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}
	
	
}
