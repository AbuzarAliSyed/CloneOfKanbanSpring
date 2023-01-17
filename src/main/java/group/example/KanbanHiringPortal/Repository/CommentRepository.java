package group.example.KanbanHiringPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import group.example.KanbanHiringPortal.model.comment;

@Repository
public interface CommentRepository extends JpaRepository<comment,Integer>{

	@Query(value="Select c from comment c where c.id=:id order by c.pId DESC")
	public List<comment> findAllComment(String id);

	
}
