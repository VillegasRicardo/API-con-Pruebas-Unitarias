package back1dia9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import back1dia9.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
