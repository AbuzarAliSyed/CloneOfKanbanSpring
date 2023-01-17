package group.example.KanbanHiringPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.example.KanbanHiringPortal.model.CandidateLogger;

public interface CandidateLoggerRepository extends JpaRepository<CandidateLogger,Integer> {

//	@Query(value="insert into candidateLogger")
//	void save(String id);
	
	
}
