package com.reffics.groupware.svc.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reffics.groupware.svc.menu.model.MenuVO;

@Mapper
public interface MenuMapper {
	// 목록
	List<MenuVO> getUserMenus();

	// 등록
	void insert(MenuVO params);

	// 검색
	List<MenuVO> getUserMenus(MenuVO vo);

}
