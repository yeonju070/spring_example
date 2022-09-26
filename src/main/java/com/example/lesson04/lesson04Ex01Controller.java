package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04/ex01")
@Controller		// -> jsp(@RestController = 데이터)
public class lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
		
	// 요청 url : http://localhost/lesson04/ex01/add_user_view
	@RequestMapping(path = "/add_user_view", method = RequestMethod.GET)	// @RequestMapping은 get, post 를 담고있다.
	public String addUserView() {
		return "lesson04/addUser";		// jsp 경로(resources에서 경로를 지정했기 때문에 가능)
	}
	
	// 요청 url : http://localhost/lesson04/ex01/add_user -> 서버의 역할만 하는 url
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 jsp(view 출력)
		return "/lesson04/afterAddUser";
	}
	
	// 요청 url : http://localhost/lesson04/ex01/get_last_user_view
	@GetMapping("/get_last_user_view")
	public String getLastUser(Model model) {
		// 가장 최근에 추가된 사람 한명 가져오기 - DB select
		User user = userBO.getLastUser();
		// 결과 jsp에서 객체값을 꺼내 사용할 수 있다.
		model.addAttribute("result", user);
		model.addAttribute("subject", "회원 정보");
		
		return "lesson04/getLastUser";
	}
	
}
