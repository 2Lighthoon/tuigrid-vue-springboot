package com.reffics.groupware.svc.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reffics.groupware.svc.menu.model.MenuVO;
import com.reffics.groupware.svc.menu.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(path = "/api")
@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;

	// 목록
	@GetMapping("/test")
	public List<MenuVO> getUserMenus() {
		return menuService.getUserMenus();
	}

	// 등록
	@PostMapping("/test2")
	public List<MenuVO> insertMenu(@RequestBody MenuVO param) {
		menuService.insertMenu(param);
		return menuService.getUserMenus();
	}

	// 검색
	@GetMapping("/test3")
	public List<MenuVO> search(MenuVO vo, @RequestParam("type") String type, @RequestParam("keyword") String keyword) {
		System.out.println("검색조건:" + vo.getType());
		System.out.println("검색어:" + vo.getKeyword());
		// null 체크하기
		if (vo.getType() == null)
			vo.setType("");
		if (vo.getKeyword() == null)
			vo.setKeyword("");
		return menuService.getUserMenus(vo);
	}

}