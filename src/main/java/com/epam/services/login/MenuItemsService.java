package com.epam.services.login;

import java.io.Serializable;
import java.util.List;

public interface MenuItemsService extends Serializable {
	List<Menu> getMenuItems(int roleid);
}
