package com.nav.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nav.service.IDoctorMgmtService;
import com.nav.vo.DoctorVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorOperationsController {
	@Autowired
	private IDoctorMgmtService docService;
	
	@GetMapping("/")
	public String showHomw() {
		return "welcome";
	}
	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {
		System.out.println("DoctorOperationsController.showReport()");
		//use service
		List<DoctorVO> lisdtVO = docService.findAllDoctors();
		//keep the result in shared memory
		map.put("doctorList", lisdtVO);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/register")
	public String showRegisterDoctorForm(@ModelAttribute("docVO") DoctorVO vo) {
		//return LVN (register doctor form)
		return "register_doctor_form";
	}
	
//	@PostMapping("/register")
//	public String registerDoctor(@ModelAttribute("docVO") DoctorVO vo, Map<String,Object> map) {
//		System.out.println("DoctorOperationsController.registerDoctor()");
//		//use service
//		String msg = docService.registerDoctor(vo);
//		List<DoctorVO> listVO = docService.findAllDoctors();
//		//keep the result in model attribute
//		map.put("resultMsg", msg);
//		map.put("doctorList", listVO);
//		//return LVN
//		return "show_report";
//	}
	
//	@PostMapping("/register")
//	public String registerDoctor(@ModelAttribute DoctorVO vo, Map<String, Object> map) {
//		System.out.println("DoctorOperationsController.registerDoctor()");
//		//use service
//		String msg = docService.registerDoctor(vo);
//		map.put("resultMsg", msg);
//		return "redirect:report";
//	}
	
//	@PostMapping("/register")
//	public String registerDoctor(@ModelAttribute("docVO") DoctorVO vo, Map<String,String> map) {
//		System.out.println("DoctorOperationsController.registerDoctor()");
//		//use service
//		String msg = docService.registerDoctor(vo);
//		//keep the result as Model Attribute
//		map.put("resultMsg", msg); //these flash attribute having redirect scope
//		//return LVN
//		return "redirect:report";
//	}
	
//	@PostMapping("/register")
//	public String registerDoctor(@ModelAttribute("docVO") DoctorVO vo, RedirectAttributes attrs) {
//		System.out.println("DoctorOperationsController.registerDoctor()");
//		//use service
//		String msg = docService.registerDoctor(vo);
//		//keep the result as Model Attribute
//		attrs.addFlashAttribute("resultMsg", msg); //these flash attribute having redirect scope
//		//return LVN
//		return "redirect:report";
//	}
	
	@PostMapping("/register")
	public String registerDoctor(@ModelAttribute("docVO") DoctorVO vo, HttpSession session) {
		System.out.println("DoctorOperationsController.registerDoctor()");
		//use service
		String msg = docService.registerDoctor(vo);
		//keep the result as Model Attribute
		session.setAttribute("resultMsg", msg); //these flash attribute having redirect scope
		//return LVN
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEditDoctorFormPage(@RequestParam("no") int no, @ModelAttribute("docVO") DoctorVO vo) {
		DoctorVO vo1 = docService.showDoctorById(no);
		//copy vo obj data to vo1
		BeanUtils.copyProperties(vo1, vo);
		//return LVN
		return "edit_doctor_form";
	}
	

	@PostMapping("/edit")
	public String editDoctor(@ModelAttribute("docVO") DoctorVO vo, RedirectAttributes attrs) {
		System.out.println("DoctorOperationsController.editDoctor()");
		String msg = docService.editDoctor(vo);
		//copy the result as flash Model attribute
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String removeDoctor(@RequestParam("no") int no, RedirectAttributes attrs) throws Exception{
		System.out.println("DoctorOperationsController.removeDoctor()");
		//use service
		String msg = docService.removeDoctor(no);
		//keep the result as Model Attribute
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	
	
}
