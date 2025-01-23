package com.icsd.Service;



import java.util.List;

import com.icsd.model.DeptModel;

public interface DeptService {

	public DeptModel saveDept(DeptModel dept);
	public List<DeptModel> getAllDepts();
	
}

