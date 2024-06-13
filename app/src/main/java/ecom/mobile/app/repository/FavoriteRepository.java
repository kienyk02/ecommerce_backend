package ecom.mobile.app.repository;

import ecom.mobile.app.model.Favorite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    public List<Favorite> findAllByUserId(int id);

    public Optional<Favorite> findFavoriteByUserIdAndProductId(int userId, int productId);

}
