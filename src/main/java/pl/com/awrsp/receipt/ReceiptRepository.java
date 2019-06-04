package pl.com.awrsp.receipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

  Receipt save(Receipt receipt);
  Optional<Receipt> findById(Long id);
  @Transactional
  @Modifying
  @Query(
      "UPDATE Receipt r SET r.name = :name, r.money = :money, r.category = :category WHERE r.id=:id")
  int update(
      @Param("name") String name,
      @Param("money") double money,
      @Param("category") Categories category,
      @Param("id") long id);

  @Transactional
  @Modifying
  void deleteById(Long id);
}
