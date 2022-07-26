package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.Raid;

import java.util.List;

public interface ContentService extends JpaRepository<Raid, Long> {
    Raid findRaidById(Long id);
    List<Raid> findAll();
}
