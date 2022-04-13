package com.reffics.groupware.svc.menu.service;

import java.util.List;

import com.reffics.groupware.svc.menu.model.MenuVO;

public interface MenuService {
	// 목록
	List<MenuVO> getUserMenus();

	// 등록
	void insertMenu(MenuVO param);

	// 검색
	List<MenuVO> getUserMenus(MenuVO vo);
}
