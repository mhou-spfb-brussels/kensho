package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
