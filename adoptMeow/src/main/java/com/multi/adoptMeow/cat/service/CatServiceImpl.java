package com.multi.adoptMeow.cat.service;

import com.multi.adoptMeow.cat.model.dao.CatMapper;
import com.multi.adoptMeow.cat.model.dto.CatColorDTO;
import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import com.multi.adoptMeow.shelter.model.dto.ShelterDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("catService")
public class CatServiceImpl implements CatService {

	private final CatMapper catDAO;

	public CatServiceImpl(CatMapper catMapper) {
		super();
		this.catDAO = catMapper;
	}

	@Override
	public int insertCat(CatDTO catDTO) throws Exception {

		int result = catDAO.insertCat(catDTO);

		if (result < 0) {
			throw new Exception("고양이 등록에 실패하셨습니다.");
		}

		return result;

	}

	@Override
	public List<CatDTO> selectList(PageDTO pageDTO) throws Exception {

		List<CatDTO> list = catDAO.selectList(pageDTO);

		return list;

	}

	@Override
	public int selectCount() throws Exception {
		
		int count = catDAO.selectCount();
		
		return count;
		
		
	}
	
	@Override
	public ArrayList<CatColorDTO> selectCatColorList() throws Exception {
		
		ArrayList<CatColorDTO> list = catDAO.selectCatColorList();
		
		return list;
		
		
	}
	
	@Override
	public ArrayList<ShelterDTO> selectShelterList() throws Exception {
		
		ArrayList<ShelterDTO> list = catDAO.selectShelterList();
		
		
		return list;
	}
	
	@Override
	public void insertShelter(ShelterDTO shelterDTO) throws Exception {
		
		int result= catDAO.insertShelter(shelterDTO);
		
		if(result < 0) {
			throw new Exception("보호소 등록에 실패하셨습니다.");
		}
		
	}
	
	@Override
	public int selectShelterCount() throws Exception {
		int count = catDAO.selectShelterCount();
		
		return count;
	}
	
	@Override
	public List<ShelterDTO> selectShelterByName(String shelterName) throws Exception {
		
		
		List<ShelterDTO> list = catDAO.selectShelterByName(shelterName);
		
		return list;
	}
	
}
