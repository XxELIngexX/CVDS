package Proyecto.GestorAlmuerzo.Repository;

import Proyecto.GestorAlmuerzo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que nos permite conectarnos con la base de datos
 * @author Sebastian Zamora Urrego
 * @version 28/10/2023
 */
@Repository
public interface AppRepository extends JpaRepository<User, String> {
}
