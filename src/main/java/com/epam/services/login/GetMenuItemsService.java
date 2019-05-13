package com.epam.services.login;

import java.util.ArrayList;

public interface GetMenuItemsService {
	ArrayList<Menu> getMenuItems(int roleid);
}
