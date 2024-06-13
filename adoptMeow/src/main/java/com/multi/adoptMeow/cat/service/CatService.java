package com.multi.adoptMeow.cat.service;


import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;

import java.util.List;

public interface CatService {

	int insertCat(CatDTO catDTO) throws Exception;

	List<CatDTO> selectList(PageDTO pageDTO) throws Exception;

	int selectCount() throws Exception;

}
