package javaproject.lotto._5.repository;

import javaproject.lotto._5.model.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoRepository extends JpaRepository<Lotto, Long> {
}
