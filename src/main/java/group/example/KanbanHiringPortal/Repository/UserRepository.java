package group.example.KanbanHiringPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.example.KanbanHiringPortal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByDasId(String dasId);
	
	
	public User findByDasIdAndPassword(String dasId,String password);
	
	
}
