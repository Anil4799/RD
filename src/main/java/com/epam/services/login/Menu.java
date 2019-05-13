package com.epam.services.login;

public class Menu {
	int menuId;
	String menuName;
	String menuPagePath;
	public Menu(int menuId,String menuName,String menuPagePath) {
		this.menuName = menuName;
		this.menuPagePath = menuPagePath;
	}
	public Menu(String menuName,String menuPagePath) {
		this.menuName = menuName;
		this.menuPagePath = menuPagePath;
	}
	public void setMenId(int menuId) {
		this.menuId=menuId;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public void menuPagePath(String menuPagePath) {
		this.menuPagePath = menuPagePath;
	}
	public int getMenuId() {
		return menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public String getMenuPagePath() {
		return menuPagePath;
	}
	
}
