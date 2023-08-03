package sage.springcoder.jamhubservice.web.repositories;

//import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sage.springcoder.jamhubservice.web.entity.Jam;

import java.util.UUID;

@Repository
public interface JamRepository extends JpaRepository<Jam, UUID> {

    Page<Jam> findAllByJamName(String jamName, Pageable pageable);

    Page<Jam> findAllByJamFlavor(String jamFlavor, Pageable pageable);

    Page<Jam> findAllByJamNameAndJamFlavor(String jamName, String jamFlavor, Pageable pageable);

    Jam findByUpc(String upc);

}
