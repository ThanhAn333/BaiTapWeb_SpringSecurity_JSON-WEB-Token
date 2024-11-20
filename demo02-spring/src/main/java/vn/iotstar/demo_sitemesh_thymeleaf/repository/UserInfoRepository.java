package vn.iotstar.demo_sitemesh_thymeleaf.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.demo_sitemesh_thymeleaf.entity.UserInfo;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
Optional<UserInfo> findByName(String username);
}
