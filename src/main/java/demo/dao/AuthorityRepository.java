package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.Authority;

@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, String> {

}
