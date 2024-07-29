package DAOINTERFACES;

import java.util.List;

import MODEL.Restaurent;



public interface RestaurentDAO {
	void addResturant(Restaurent restaurent);
	Restaurent getRestaurant(int restaurantId);
	void updateRestaurent(Restaurent restaurant);
    void deleteRestaurant(int restaurantId);
    List<Restaurent> getAllrestaurants();


}
