package com.icsd.Service;


import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.icsd.model.Customer;
import com.icsd.model.CustomerDocuments;

public interface CustDocServ {

	 int savedoc(Customer cstmer,String filetype,MultipartFile file) throws IOException;
	 CustomerDocuments fromCustDocId(int custdocid);
	
}