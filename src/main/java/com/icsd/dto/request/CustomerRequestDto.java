package com.icsd.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.icsd.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


//
//"data": {
//    "firstName": "rohan",
//    "lastName": "kumar",
//    "emailId": "rb@rb.com",
//    "contactNo": "987654321",
//    "gender": "MALE",
//    "password": "icsd",
//    "confirmPassword": "icsd",
//    "addressLine1": "delhi",
//    "addressLine2": "sec 1123",
//    "city": "delhi",
//    "pincode": "132103",
//    "state": "delhis"
//}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {

	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	@Size(min = 2,max = 60,message = "Name should be between 2 to 60")
	public String firstName;
	
	@NotBlank(message = "Last name should not be blank")
	@NotNull(message="Last name should not be null")
	private String lastName;
	
	@NotBlank(message = "emailId name should not be blank")
	@NotNull(message="emailId name should not be null")
	@Email(message ="not valid email formatrrrrrrrrrrrrrr ")
	private String emailId;
	
	@NotBlank(message = "contactNo name should not be blank")
	@NotNull(message="contactNo name should not be null")
	private String contactNo;
	
	private Gender gender;
	
	
	@NotBlank(message = "password name should not be blank")
	@NotNull(message="password name should not be null")
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String  password;
	@NotBlank(message = "confirmPassword name should not be blank")
	@NotNull(message="confirmPassword name should not be null")
	private String confirmPassword;
	@NotBlank(message = "addressLine1 name should not be blank")
	@NotNull(message="addressLine1 name should not be null")
	private String addressLine1;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String addressLine2;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String city;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String State;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String pincode;
	@Override
	public String toString() {
		return "CustomerRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", State=" + State + ", pincode=" + pincode + "]";
	}
		
	
	
	
	}
