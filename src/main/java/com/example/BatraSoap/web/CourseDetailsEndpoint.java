package com.example.BatraSoap.web;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demosoap.courses.CourseDetails;
import com.demosoap.courses.GetCourseDetailRequest;
import com.demosoap.courses.GetCourseDetailResponse;

@Endpoint
public class CourseDetailsEndpoint {

	//method
	//input - request
	//output - response
	@PayloadRoot(namespace = "http://demosoap.com/courses", localPart = "GetCourseDetailRequest")
	@ResponsePayload
	public GetCourseDetailResponse processCourseDetailRequest(@RequestPayload GetCourseDetailRequest request) {
		
		GetCourseDetailResponse response = new GetCourseDetailResponse();
		
		CourseDetails cd = new CourseDetails();
		cd.setId(request.getId());
		cd.setName("Mayank");
		cd.setDescription("ASU Student");
		
		response.setCourseDetails(cd);
		
		return response;
	}
	
}
