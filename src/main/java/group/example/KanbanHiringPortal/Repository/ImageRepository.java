package group.example.KanbanHiringPortal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.example.KanbanHiringPortal.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image,String>{
}
	

