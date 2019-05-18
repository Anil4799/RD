package com.epam.services.login;

import java.util.List;

import com.epam.dao.login.LoginDAOImp;

public class MenuItemsSingleton {
	
	 private static MenuItemsSingleton instance;
	 private List<Menu> ls = null;
	 
	 private MenuItemsSingleton(){
		 
	 }
	 
	 public List<Menu> getMenuItems(int roleid) {
			 ls=new LoginDAOImp().getMenuItems(roleid);
			 return ls;
		}
	 public List<Menu> getMenuItems() {
		 return ls;
	}
	 
	 public static MenuItemsSingleton getInstance(){
	        if(instance == null){
	            instance = new MenuItemsSingleton();
	        }
	        return instance;
	    }

}
