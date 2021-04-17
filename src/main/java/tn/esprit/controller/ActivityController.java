package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.entities.Activity;
import tn.esprit.entities.Category;
import tn.esprit.services.IActivityService;

import java.util.List;

@RestController
public class ActivityController {

	@Autowired
	IActivityService iactivityservice;

	// http://localhost:8081/SpringMVC/servlet/ajoutactivity/1/1
	// attributes ,values,file
	@PostMapping(value = "/ajoutactivity/{idkinder}/{iduser}")

	public ResponseEntity<String> ajoutActivity(@ModelAttribute Activity activity,
			@PathVariable("idkinder") int kinderId, @PathVariable("iduser") int userId,
			@RequestParam("file") MultipartFile file) {

		return iactivityservice.ajoutActivity(activity, kinderId, userId, file);

	}

	// http://localhost:8081/SpringMVC/servlet/getAllActivity
	@GetMapping(value = "/getAllActivity")
	@ResponseBody
	public List<Activity> getAllActivity() {
		return iactivityservice.getAllActivity();
	}

	// http://localhost:8081/SpringMVC/servlet/deleteActivityById/1
	@DeleteMapping("/deleteActivityById/{idactivity}")
	@ResponseBody
	public ResponseEntity<String> deleteActivityById(@PathVariable("idactivity") int ActivityId) {
		iactivityservice.deleteActivityById(ActivityId);
		return new ResponseEntity<String>("deleted succesfuly", HttpStatus.OK);
	}

	// http://localhost:8081/SpringMVC/servlet/NbreActivity
	@GetMapping("/NbreActivity")
	@ResponseBody
	public int getNombreActivityJPQL() {
		return iactivityservice.getNombreActivityJPQL();
	}

	// http://localhost:8081/SpringMVC/servlet/Activityname
	@GetMapping("/Activityname")
	@ResponseBody
	public List<String> getAllActivityNamesJPQL() {
		return iactivityservice.getAllActivityNamesJPQL();
	}

	@PutMapping("/updateActivity/{idActivity}")
	@ResponseBody
	public ResponseEntity<String> updateActivity(@ModelAttribute Activity a, @PathVariable("idActivity") int idActivity,
			@RequestParam("file") MultipartFile file) {
		iactivityservice.updateActivity(a, idActivity, file);
		return new ResponseEntity<String>("Activity updated successfully", HttpStatus.OK);

	}

	// http://localhost:8081/SpringMVC/servlet/getActivity/{name}
	@GetMapping("/getActivity/{name}")
	@ResponseBody
	public Activity getActivity(@PathVariable("name") String name) {
		return iactivityservice.getActivity(name);
	}

	// http://localhost:8081/SpringMVC/servlet/retrieveallActivitybycategorie
	@GetMapping(value = "/retrieveallActivitybycategorie/{categorie}")
	@ResponseBody
	public List<Activity> getAllActivityByCategorie(@PathVariable("categorie") Category category) {
		return iactivityservice.getAllActivityByCategorie(category);
	}

	@GetMapping(value="/seach/{keyword}")
	@ResponseBody
	public List<Activity> search(@PathVariable("keyword") String keyword) {
		return iactivityservice.search(keyword);
	}

	@GetMapping(value="/all")
	@ResponseBody
	public List<Activity> activities () {
		return iactivityservice.activities();
	}
	//http://localhost:8081/SpringMVC/servlet/?pageSize=1&pageNo=0&sortBy=
	@GetMapping("pagination")
	public ResponseEntity<List<Activity>> paginationsorting(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy)
	{
		List<Activity> list = iactivityservice.paginationsorting(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Activity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// http://localhost:8081/SpringMVC/servlet/retrieveallActivitysoftoday
	@GetMapping(value = "/retrieveallActivitysoftoday")
	@ResponseBody
	public List<Activity> getAllActivityPourToday() {
		return iactivityservice.getAllActivityPourToday();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Activitysordonnebydate
	@GetMapping(value = "/retrieve-all-Activitysordonnebydate")
	@ResponseBody
	public List<Activity> getAllActivityOrdonneParDate() {
		return iactivityservice.getAllActivityOrdonneParDate();
	}
}