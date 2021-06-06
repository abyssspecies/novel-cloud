package io.abyssspecies.tech.novel.user.repository;

import io.abyssspecies.tech.novel.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description...
 *
 * @author abyss species 2021-06
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
