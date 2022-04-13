package com.reffics.groupware.svc.menu.model;

import lombok.Data;

@Data
public class MenuVO {
	private String mainMenuId;
	private String midMenuId;
	private String smlMenuId;
	private String smlMenuNm;
	private String smlMenuSeq;
	private String menuId;
	private String createId;
	private String createDt;
	private String modId;
	private String modDt;

	private String type;
	private String keyword;
}
