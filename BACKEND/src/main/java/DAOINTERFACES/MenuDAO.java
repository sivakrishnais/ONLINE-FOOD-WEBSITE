package DAOINTERFACES;

import java.util.List;

import javax.swing.JMenu;

import MODEL.Menu;



public interface MenuDAO {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenuByRestaurent();

}
