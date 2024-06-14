package com.multi.adoptMeow.cat.model.dao;


import com.multi.adoptMeow.cat.model.dto.CatColorDTO;
import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import com.multi.adoptMeow.shelter.model.dto.ShelterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CatMapper {

	public int insertCat(CatDTO catDTO);

	public List<CatDTO> selectList(PageDTO pageDTO);

	public int selectCount();
	
	ArrayList<CatColorDTO> selectCatColorList();
	
	ArrayList<ShelterDTO> selectShelterList();
}
