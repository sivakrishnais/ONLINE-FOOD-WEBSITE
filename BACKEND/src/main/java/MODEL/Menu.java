package MODEL;

import java.util.List;



public class Menu  {
	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private int price;
	private boolean isAvaliable;
	private String imagePath;
	/**
	 * @param menuId
	 * @param itemName
	 * @param description
	 * @param price
	 * @param isAvaliable
	 * @param imagePath
	 */
	public Menu() {
		
	}
	public Menu(int menuId, String itemName, String description, int price, boolean isAvaliable) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvaliable = isAvaliable;
		this.imagePath = imagePath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean getIsAvaliable() {
		return isAvaliable;
	}
	public void setIsAvaliable(boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvaliable=" + isAvaliable + ", imagePath=" + imagePath + "]";
	}
	
    
	
	

}
