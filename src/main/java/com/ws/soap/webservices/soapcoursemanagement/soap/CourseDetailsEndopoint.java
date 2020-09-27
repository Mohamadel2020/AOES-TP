package com.ws.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import sn.edu.uvs.formation.course.CourseDetails;
import sn.edu.uvs.formation.course.GetCourseDetailsRequest;
import sn.edu.uvs.formation.course.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndopoint {
	
	//method
	//input - GetCourseDetailsRequest
	//output - GetCourseDetailsResponse
	
	//http://www.formation.uvs.edu.sn/Course
	//GetCourseDetailsRequest
	@PayloadRoot(namespace="http://www.formation.uvs.edu.sn/Course",
			localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse 
	processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setNomCours("Architecture Orientee Service et Entreprise");
		courseDetails.setDescription("Parcours à la decouverte du service SOAP et REST");
		response.setCourseDetails(courseDetails);
		return response;
	}
}