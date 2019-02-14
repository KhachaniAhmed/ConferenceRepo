package org.mql.dao;

import java.util.List;

import org.mql.entities.UploadFileResponse;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository< UploadFileResponse, Long>{

	List<UploadFileResponse> findByArticleId(Long id);

}
