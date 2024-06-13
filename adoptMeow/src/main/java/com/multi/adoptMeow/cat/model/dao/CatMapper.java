package com.multi.adoptMeow.cat.model.dao;


import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CatMapper {

	public int insertCat(CatDTO catDTO);

	public List<CatDTO> selectList(PageDTO pageDTO);

	public int selectCount();

}
