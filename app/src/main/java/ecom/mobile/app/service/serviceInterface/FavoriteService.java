package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
    List<Favorite> fetchAllFavoriteByUserId(int id);


    Favorite saveFavorite(Favorite favorite);

    Optional<Favorite> deleteFavorite(int id);

    Optional<Favorite> checkIfProductFavorite(int userId, int productId);

}
