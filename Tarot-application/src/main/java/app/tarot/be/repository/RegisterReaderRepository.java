package app.tarot.be.repository;

import app.tarot.be.entity.RegisterReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterReaderRepository extends JpaRepository<RegisterReader, Long> {
}
