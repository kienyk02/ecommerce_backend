package ecom.mobile.app.repository;

import ecom.mobile.app.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search, Integer> {

    public List<Search> findAllByUserId(int id);

}
