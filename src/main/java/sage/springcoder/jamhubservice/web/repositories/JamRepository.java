package sage.springcoder.jamhubservice.web.repositories;

//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sage.springcoder.jamhubservice.web.entity.Jam;

import java.util.UUID;
@Repository
public interface JamRepository extends JpaRepository<Jam,UUID> {

}
