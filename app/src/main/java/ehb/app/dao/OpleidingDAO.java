package ehb.app.dao;

import ehb.app.entities.Opleiding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpleidingDAO extends CrudRepository<Opleiding,Integer> {

}
