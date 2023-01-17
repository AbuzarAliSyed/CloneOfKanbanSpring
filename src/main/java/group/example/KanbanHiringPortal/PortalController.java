package group.example.KanbanHiringPortal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import group.example.KanbanHiringPortal.model.Candidate;
import group.example.KanbanHiringPortal.model.Image;
import group.example.KanbanHiringPortal.model.ImageUploadResponse;
import group.example.KanbanHiringPortal.model.Reportobj;
import group.example.KanbanHiringPortal.model.Tags;
import group.example.KanbanHiringPortal.model.User;
import group.example.KanbanHiringPortal.model.average;
import group.example.KanbanHiringPortal.model.comment;
import group.example.KanbanHiringPortal.model.customTag;
import group.example.KanbanHiringPortal.model.search;
import group.example.KanbanHiringPortal.model.status;
import group.example.KanbanHiringPortal.services.KanbanServices;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PortalController {
	
	int count=0;
	
	String userId;
	
	@Autowired
	KanbanServices service;
	
	
	@PostMapping("/register")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception{
		String tempDasId=user.getDasId();
		if(tempDasId!=null && !"".equals(tempDasId)) {
			User userObj=service.fetchUserByDasID(tempDasId);
			
			if (userObj!=null) {
				throw new Exception("user with this dasid already exists");
			}
		}
		
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempDasId=user.getDasId();
		this.userId=user.getDasId();
		String tempPassword=user.getPassword();
		User userObj=null;
		if (tempDasId!=null && tempPassword!=null) {
			userObj=service.fetchUserByDasIDAndPassword(tempDasId, tempPassword);
		}
		
		if(userObj==null) {
			throw new Exception("bad credentials");
		}
		
		return userObj;
		
		
	}
	
	
	@PostMapping("/getData")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Candidate> getdata(@RequestBody List<Candidate> data) throws Exception{
		List<Candidate> userList;
		userList=service.findall();
		if(userList.size()!=0) {
//			System.out.println("This has something");
//			System.out.println(userList.get(0).getCandidateName());
		}
		else {
			System.out.println("We dont get anything");
		}
		return userList;
		
	}
	
	
	@PutMapping("/updateData")
	@CrossOrigin(origins="http://localhost:4200")
	public void updatedata(@RequestBody status stat) {
	System.out.println("The controller hit");
	System.out.println(stat);
		System.out.println(stat.status);
		System.out.println(stat.id);
		service.update(stat.status,stat.id);
		System.out.println("this is the user "+ this.userId);
		service.updateTimestamp(stat.id,this.userId,stat.prevContainer);
	}
	
	@PostMapping("/getObj")
	@CrossOrigin(origins="http://localhost:4200")
	public Candidate getobj(@RequestBody Candidate object) {
		Candidate canObj=null;
		canObj=(service.getCandidateData(object));
		return canObj;
	}
	
	
	@PostMapping("/registerCandidate")
	@CrossOrigin(origins="http://localhost:4200")
	public Candidate registerCandidate(@RequestBody Candidate canObj) throws Exception{
		String tempId=canObj.getCandidateId();
		if(tempId!=null && !"".equals(tempId)) {
			Candidate canObject=service.fetchUserByCandidateID(tempId);
			
			if (canObject!=null) {
				throw new Exception("Candidate with this id already exists");
			}
		}
		
		Candidate canObject=null;
		canObject=service.saveCandidate(canObj);
		return canObject;
	}
	
	
	
	@PutMapping("/updateCustomTags")
	@CrossOrigin(origins="http://localhost:4200")
	public void updateTags(@RequestBody customTag obj) {
		System.out.println("Portal controller Hit");
		System.out.println(obj.getValue());
		System.out.println(obj.getColumnName());
		System.out.println(obj.getId());
		String objValue=obj.getValue();
		String objColName=obj.getColumnName();
		String objId=obj.getId();
		
		if(objColName.equals("gcm")) {
			service.updateGcm(objValue,objId);
		}
		else if(objColName.equals("position")) {
			service.updatePosition(objValue,objId);
		}
		else if(objColName.equals("duedate")) {
			service.updateDuedate(objValue,objId);
			
		}
		else if(objColName.equals("project")) {
			service.updateProject(objValue,objId);
		}
		
	}
	
	
	@PostMapping("/searchData")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Candidate> searchdata(@RequestBody search searchObj) throws Exception {
		
		List<Candidate> canObj;
		canObj=service.searchingData(searchObj);
		
		if(canObj==null) {
			throw new Exception("No record are fetched");
		}
		
		return canObj;
		
	}
	
	
	@PostMapping("/getComments")
	@CrossOrigin(origins="http://localhost:4200")
	public List<comment> getComments(@RequestBody comment comObj){
		System.out.println(comObj.getId());
		System.out.println(comObj.getComment());
		System.out.println(comObj.getMonth());
		service.saveComment(comObj);
		List<comment> listComObj=service.getAllComments(comObj);
		if(comObj.getComment().equals("")) {
			return null;
		}
		
		return listComObj;
		
	}
	
	@PostMapping("getAllComment")
	@CrossOrigin(origins="http://localhost:4200")
	public List<comment> getAllComment(@RequestBody String id){
		List<comment> allComObj=service.getListOfComments(id);
		if(allComObj==null) {
			return null;
		}
		return allComObj;
	}
	
	
	@PutMapping("/exportCsv")
	@CrossOrigin(origins="http://localhost:4200")
	public void getAllCandidateToCsv(@RequestBody search searchObj) throws IOException{
//		System.out.println("The portal controller hit for export CSV");
		List<Candidate> cand=service.writeSearchToCsv(searchObj);
		
//		String[] nameMapping= {"candidateId","candidateName","age",};
		
		JSONArray candi=new JSONArray();
		for(int i=0;i<cand.size();i++) {
			JSONObject jObj=new JSONObject();
			jObj.put("candidateId",cand.get(i).getCandidateId());
			jObj.put("candidateName",cand.get(i).getCandidateName());
			jObj.put("age",cand.get(i).getAge());
			jObj.put("totalExperiance",cand.get(i).getTotalExperiance());
			jObj.put("relevantExperiance",cand.get(i).getRelevantExperiance());
			jObj.put("expectedLwd",cand.get(i).getExpectedLwd());
			jObj.put("location",cand.get(i).getLocation());
			jObj.put("skills",cand.get(i).getSkills());
			jObj.put("technology",cand.get(i).getTechnology());
			jObj.put("maritialStatus",cand.get(i).getMaritialStatus());
			jObj.put("status",cand.get(i).getStatus());
			jObj.put("gcm",cand.get(i).getGcm());
			jObj.put("position",cand.get(i).getPosition());
			jObj.put("duedate",cand.get(i).getDuedate());
			jObj.put("project",cand.get(i).getProject());
			candi.put(jObj);
		}
		
		System.out.println(candi);
		
		JSONObject finalData=new JSONObject();
		finalData.put("search",candi);
		finalData.toString();
		System.out.println(finalData);
		}
//		JSONArray docs=finalData.getJSONArray("search");
//		
//		File file=new File("C:\\Users\\w127364\\OneDrive - Worldline\\Documents\\"+searchObj.filterValue+"_"+searchObj.inputData+".csv");
//		String csvString=CDL.toString(docs);
//		FileUtils.writeStringToFile(file,csvString,Charset.defaultCharset());
		
//	}
	
	
//	@PostMapping("/upload/image")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file) throws IOException{
//		System.out.println("The upload Image is running");
//		ResponseEntity<ImageUploadResponse> returnFile=service.uploadingImage(file);
//		return returnFile;
//	}
//
//	
//	@GetMapping(path= {"/get/image/info/{name}"})
//	public Image getImageDetails(@PathVariable("name") String name) throws IOException{
//		return service.getImageInfo(name);
//		
//	}
//	
//	@GetMapping(path= {"get/image/{name}"})
//	public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
//		return service.getImage(name);
//	}
	
	
	@PostMapping("/saveCandidateProfile")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<ImageUploadResponse> saveCandidateProfile(@RequestParam("file") MultipartFile File,
																	@RequestParam("user") String user,
																	@RequestParam("candidateId") String candId) throws JsonMappingException, JsonProcessingException,IOException{
		
		System.out.println("save candidate portal hit");
		Image image=new Image();
		image.setImage(File.getBytes());
		image.setFileName(File.getOriginalFilename());
		image.setCandidateId(candId);
		
		Image dbImage=service.saveCandidateImage(image);
		
		if (dbImage!=null) {
			return new ResponseEntity<ImageUploadResponse>(new ImageUploadResponse("Image Uploaded Successfully"),HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<ImageUploadResponse>(new ImageUploadResponse("Image Upload Fail"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/generateReport")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Candidate> generateReport(@RequestBody Reportobj repoObj) throws ParseException{
		
		List<Candidate> canObj=null;
		if(repoObj.getFilterValue().equals("monthlyreport")){
			canObj=service.generateMonthlyReport(repoObj.getInputValue());
		}
		else if(repoObj.getFilterValue().equals("quaterlyreport")) {
			if(repoObj.getInputValue().equals("Q1")) {
			canObj=service.generateQuaterlyReport(1);
			}
			else if(repoObj.getInputValue().equals("Q2")) {
				canObj=service.generateQuaterlyReport(2);
				}
			else if(repoObj.getInputValue().equals("Q3")) {
				canObj=service.generateQuaterlyReport(3);
				}
			else if(repoObj.getInputValue().equals("Q4")) {
				canObj=service.generateQuaterlyReport(4);
				}
		}
		
		return canObj;
	}
	
	
	@PutMapping("/reportDataCsv")
	@CrossOrigin(origins="http://localhost:4200")
	public void getreportDataToCsv(@RequestBody List<Candidate> candList) throws IOException{
//		System.out.println("The portal controller hit for export CSV");
		List<Candidate> cand=candList;
		
//		String[] nameMapping= {"candidateId","candidateName","age",};
		
		JSONArray candi=new JSONArray();
		for(int i=0;i<cand.size();i++) {
			JSONObject jObj=new JSONObject();
			jObj.put("candidateId",cand.get(i).getCandidateId());
			jObj.put("candidateName",cand.get(i).getCandidateName());
			jObj.put("age",cand.get(i).getAge());
			jObj.put("totalExperiance",cand.get(i).getTotalExperiance());
			jObj.put("relevantExperiance",cand.get(i).getRelevantExperiance());
			jObj.put("expectedLwd",cand.get(i).getExpectedLwd());
			jObj.put("location",cand.get(i).getLocation());
			jObj.put("skills",cand.get(i).getSkills());
			jObj.put("technology",cand.get(i).getTechnology());
			jObj.put("maritialStatus",cand.get(i).getMaritialStatus());
			jObj.put("status",cand.get(i).getStatus());
			jObj.put("gcm",cand.get(i).getGcm());
			jObj.put("position",cand.get(i).getPosition());
			jObj.put("duedate",cand.get(i).getDuedate());
			jObj.put("project",cand.get(i).getProject());
			candi.put(jObj);
		}
		
		System.out.println(candi);
		
		JSONObject finalData=new JSONObject();
		finalData.put("search",candi);
		finalData.toString();
		System.out.println(finalData);
	}
//		JSONArray docs=finalData.getJSONArray("search");
//		File file=new File("C:\\Users\\w127364\\OneDrive - Worldline\\Documents\\"+"HiringReport"+count+".csv");
//		count+=1;
//		String csvString=CDL.toString(docs);
//		FileUtils.writeStringToFile(file,csvString,Charset.defaultCharset());
//		
//	}
//	
	
	@PostMapping("/averageReportPerLocation")
	@CrossOrigin(origins="http://localhost:4200")
	public average avgReportPerLocation(@RequestBody Reportobj repoObj) throws ParseException{
		return service.generateAverageReport(repoObj.getInputValue());
	}
	
	@PostMapping("/getAllLocations")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Object> getAllLocations(@RequestBody Reportobj repoObj) {
		return service.fetchAllLocation();
	}
	
	
	@PostMapping("exportAverageReport")
	@CrossOrigin(origins="http://localhost:4200")
	public void getAverageDataToCsv(@RequestBody List<average> avgList) throws IOException{
//		System.out.println("The portal controller hit for export CSV");
		List<average> avg=avgList;
		
//		String[] nameMapping= {"candidateId","candidateName","age",};
		
		JSONArray avgListjson=new JSONArray();
		for(int i=0;i<avg.size();i++) {
			JSONObject jObj=new JSONObject();
			jObj.put("location",avg.get(i).getLocation());
			jObj.put("avgDays",avg.get(i).getAvgDays());
			avgListjson.put(jObj);
		}
		
		System.out.println(avgListjson);
		
		JSONObject finalData=new JSONObject();
		finalData.put("search",avgListjson);
		finalData.toString();
		System.out.println(finalData);
	}
//		JSONArray docs=finalData.getJSONArray("search");
//		
//		File file=new File("C:\\Users\\w127364\\OneDrive - Worldline\\Documents\\"+"Avgreport.csv");
//		String csvString=CDL.toString(docs);
//		FileUtils.writeStringToFile(file,csvString,Charset.defaultCharset());
//		
//	}
	
	@DeleteMapping("/delete/{id}")
    @CrossOrigin(origins="http://localhost:4200")
    public String delete(@PathVariable String id){
        System.out.println("---------------->");
        service.delete_candidate(id);
        System.out.println(id);
        return "Candiadte deleted";
    }
	
	@PostMapping("getAllTags")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Tags> getAllTags(@RequestBody String id){
		List<Tags> allComObj=service.getListOfTags(id);
		if(allComObj==null) {
			return null;
		}
		return allComObj;
	}
	
	@PostMapping("/getTags")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Tags> getComments(@RequestBody Tags tagsObj){
		System.out.println("--->"+tagsObj.getCandidate_id());
		System.out.println(tagsObj.getTags());
		service.saveTags(tagsObj);
		List<Tags> listTagsObj=service.getListOfTags(tagsObj.getCandidate_id());
		if(tagsObj.getTags().equals("")) {
			return null;
		}
		
		return listTagsObj;
		
	}
		
}
