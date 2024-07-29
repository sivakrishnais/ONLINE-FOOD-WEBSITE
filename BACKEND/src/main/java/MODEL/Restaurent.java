package MODEL;

public class Restaurent {
	private int restaurantId;
	private String name;
	private String cuisineType;
	private int deliverTimel;
	private String address;
    private int adminUserId;
	private double rating;
	private int isActive;
	private String imagePath;

	public Restaurent() {

	}

	/**
	 * @param restaurantId
	 * @param name
	 * @param cuisineType
	 * @param deliverTimel
	 * @param address
	 * @param adminUserId
	 * @param rating
	 * @param isActive
	 * @param imagePath
	 */
	public Restaurent(int restaurantId, String name, String cuisineType, int deliverTimel, String address,
			double rating, int isActive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliverTimel = deliverTimel;
		this.address = address;
        this.rating = rating;
		this.isActive = isActive;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliverTimel() {
		return deliverTimel;
	}

	public void setDeliverTimel(int deliverTimel) {
		this.deliverTimel = deliverTimel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String i) {
		this.imagePath = i;
	}

	@Override
	public String toString() {
		return "Restaurent [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", deliverTimel=" + deliverTimel + ", address=" + address + ", adminUserId=" + adminUserId
				+ ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}

}
