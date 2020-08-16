package com.ts;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.dao.UserDao;

import com.dto.User;

@Path("myresource")
public class MyResource {	

	@Path("Hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "Hello ! Welcome to REST API";
	}

	

	@Path("getAllUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getResidentAll(){
		System.out.println("Recieved in getAllResidents : " ); 
		UserDao resDaoH = new UserDao();
		List<User> resList = resDaoH.getAllUsers();	
		return resList;	
	}
/*
	@Path("getResidentByloginId/{loginId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getResidentById(@PathParam("loginId") int loginId){
		System.out.println("Recieved in getEmployeeByID : " + loginId); 
		ResidentDao residentDaoH = new ResidentDao();
		residentDaoH.getResidents(loginId);	
		
	}*/
	@Path("getResidentByLoginId/{loginId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getResByName(@PathParam("loginId") String loginId){
		System.out.println("Recieved in getEmployeeByID : " + loginId); 
		UserDao residentDaoH = new UserDao();
		 return (residentDaoH.getResByloginId(loginId));	
		
	}

	@Path("getUser/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("email") String email,@PathParam("password") String password){
		System.out.println("Recieved in getEmployeeByID : " + email); 
		UserDao residentDaoH = new UserDao();
		 return (residentDaoH.getUser(email,password));	
		
	}
	
	@Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void resisterResident(User resident) {
		System.out.println("Data Recieved in Register : " + resident); 
		UserDao resDao = new UserDao();
		System.out.println(resDao.register(resident));
		
	}
	
/*
	@Path("deleteEmp/{empId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmp(@PathParam("empId") int empId){
		System.out.println("Data Recieved in delete : " + empId);
		ResidentDao empDao = new ResidentDao();
		Resident resident = empDao.getResident(empId);
		empDao.deleteResident(resident);
		
	}	
	@Path("updateEmp")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmp(Resident resident){
		System.out.println("Data Recieved in update : " + resident); 
		ResidentDao empDao = new ResidentDao();
		empDao.updateResident(resident);
		
	}	
*/

	
	

	
}

