package com.reffics.groupware.svc.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reffics.groupware.svc.menu.mapper.MenuMapper;
import com.reffics.groupware.svc.menu.model.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	// 목록
	@Override
	public List<MenuVO> getUserMenus() {
		return menuMapper.getUserMenus();
	}

	// 등록
	@Override
	public void insertMenu(MenuVO param) {
		menuMapper.insert(param);
	}

	// 검색
	@Override
	public List<MenuVO> getUserMenus(MenuVO vo) {
		System.out.println(vo);
		return menuMapper.getUserMenus(vo);
	}

}
