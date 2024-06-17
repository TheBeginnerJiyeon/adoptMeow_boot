package com.multi.adoptMeow.cat.service;


import com.multi.adoptMeow.cat.model.dto.CatColorDTO;
import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import com.multi.adoptMeow.shelter.model.dto.ShelterDTO;

import java.util.ArrayList;
import java.util.List;

public interface CatService {

	int insertCat(CatDTO catDTO) throws Exception;

	List<CatDTO> selectList(PageDTO pageDTO) throws Exception;

	int selectCount() throws Exception;
	
	ArrayList<CatColorDTO> selectCatColorList() throws Exception;
	
	ArrayList<ShelterDTO> selectShelterList() throws Exception;
	
	void insertShelter(ShelterDTO shelterDTO) throws Exception;
	
	int selectShelterCount() throws Exception;
	
	List<ShelterDTO> selectShelterByName(String shelterName) throws  Exception;
}
