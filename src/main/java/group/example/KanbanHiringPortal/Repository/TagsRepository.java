package group.example.KanbanHiringPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import group.example.KanbanHiringPortal.model.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {
	
	@Query(value="Select t from Tags t WHERE t.candidate_id=:id")
	List<Tags> findAllTags(@Param("id")String id);

}
