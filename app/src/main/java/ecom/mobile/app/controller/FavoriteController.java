package ecom.mobile.app.controller;

import ecom.mobile.app.model.Favorite;
import ecom.mobile.app.service.serviceInterface.FavoriteService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorite/{userId}")
    public List<Favorite> fetchAllFavoriteByUserId(@PathVariable("userId") int id) {
        return favoriteService.fetchAllFavoriteByUserId(id);
    }

    @PostMapping("/favorite")
    public Favorite saveFavorite(@RequestBody Favorite favorite) {
        return favoriteService.saveFavorite(favorite);
    }

    @DeleteMapping("/favorite/{id}")
    public Optional<Favorite> deleteFavorite(@PathVariable("id") int id) {
        return favoriteService.deleteFavorite(id);
    }

    @GetMapping("/favorite/user/{userId}/product/{productId}")
    public Optional<Favorite> checkIfProductFavorite(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
        return favoriteService.checkIfProductFavorite(userId, productId);
    }

}
