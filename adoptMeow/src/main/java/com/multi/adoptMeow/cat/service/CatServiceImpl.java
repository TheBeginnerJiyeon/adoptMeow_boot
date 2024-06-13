package com.multi.adoptMeow.cat.service;

import com.multi.adoptMeow.cat.model.dao.CatMapper;
import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import org.springframework.stereotype.Service;

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

}
