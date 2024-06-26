package com.multi.adoptMeow.cat.controller;

import com.multi.adoptMeow.cat.model.dto.CatColorDTO;
import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.cat.service.CatService;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import com.multi.adoptMeow.shelter.model.dto.ShelterDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/cat") // ** 는 모든 하위 폴더 전부
public class CatController {
	
	private final CatService catService;
	
	public CatController(CatService catService) {
		super();
		this.catService = catService;
	}
	
	@RequestMapping("/main")
	public String Main() {
		
		return "redirect:/";
	}
	
	@RequestMapping("/catMain")
	public void catMain() {
	
	}
	
	@RequestMapping("/insert_form")
	public void insertForm() {
		
	}
	
	@RequestMapping("/modify_form")
	public void modifyForm() {
	
	}
	
	@RequestMapping("/delete")
	public void delete() {
	
	}
	
	// 나중에 등록한 이미지가 보이게 넣기
	@GetMapping("/list")
	public void list(@RequestParam("page") int page, Model model) {
		
		PageDTO pageDTO = new PageDTO();
		
		pageDTO.setPage(page);
		
		System.out.println("page: " + pageDTO.getPage());
		
		pageDTO.setStartEnd(pageDTO.getPage());
		
		try {
			List<CatDTO> list = catService.selectList(pageDTO);
			
			System.out.println("list: " + list);
			
			int count = catService.selectCount();
			
			int pages = count / 5 + 1;
			
			model.addAttribute("list", list);
			model.addAttribute("count", count);
			model.addAttribute("pages", pages);
			
			System.out.println("pages : " + pages);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/catList2")
	public void list2(PageDTO pageDTO, Model model) {
		
		
		System.out.println("page: list2" + pageDTO.getPage());
		
		pageDTO.setStartEnd(pageDTO.getPage());
		
		try {
			List<CatDTO> list = catService.selectList(pageDTO);
			
			System.out.println("list: " + list);
			
			
			model.addAttribute("list", list);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/detail_form")
	public void detailForm() {
	
	}
	
	// 등록할 때도 썸네일 넣기 도전??  
	@PostMapping("/insert")
	public void insertCat(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model, CatDTO catDTO,
						  @RequestParam("singleFile") MultipartFile singleFile) {
		
		// 파일을 서버에 저장
		
		// 경로 지정, 폴더 생성
		// 부트의 경우 상대경로가 아닌 절대경로를 넣어야한다는 글을 보고 넣는 중..https://stir.tistory.com/147
		String root = "C:\\code_upload\\Auto_window\\multi_it\\backend\\my_Project\\adoptMeow_boot\\adoptMeow_boot\\adoptMeow\\src\\main\\resources\\static\\img";
		
		System.out.println("root: " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		
		if (!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		System.out.println("singleFile" + singleFile);
		
		// 파일 명 변경
		String originalFileName = singleFile.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		System.out.println("originalFileName" + originalFileName);
		System.out.println("ext" + ext);
		
		String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
		
		// 파일을 서버에 저장
		
		try {
			singleFile.transferTo(new File(filePath + "\\" + savedName));
			
			model.addAttribute("savedName", savedName);
			
			catDTO.setImg(savedName);
			
			// 그 외 유저의 아이디를 보낼 캣dto에 저장
			UsersDTO loginDto = (UsersDTO) httpSession.getAttribute("loginUser");
			
			String userId = loginDto.getId();
			
			catDTO.setCreatedPerson(userId);
			
			int result = catService.insertCat(catDTO);
			
			model.addAttribute("catDTO", catDTO);
			
			System.out.println("catDTO : " + catDTO);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			new File(filePath + "\\" + savedName).delete();
			model.addAttribute("message", "파일 업로드 실패!!");
			
		}
		
		model.addAttribute("message", "cat insert succeess!!");
		
	}
	
	@RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
	public String modifyAndDelete(Model model) {
		
		model.addAttribute("message", "POST 방식의 고양이 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	@GetMapping("detail/{orderNo}")
	public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) {
		model.addAttribute("message", orderNo + "번 고양이 상세 내용 조회용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	
	@ResponseBody
	@PostMapping("/catColorGet")
	public ArrayList<CatColorDTO> catColorGet() {
		
		ArrayList<CatColorDTO> list = null;
		
		try {
			list = catService.selectCatColorList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return list;
		
	}
	
	
	@ResponseBody
	@PostMapping("/shelterGet")
	public ArrayList<ShelterDTO> shelterGet() {
		
		ArrayList<ShelterDTO> list = null;
		
		try {
			list = catService.selectShelterList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		System.out.println(list + "여기를 보십셔");
		
		return list;
		
	}
	
	
	@ResponseBody
	@PostMapping("/ansanCatInsert")
	public void ansanCatInsert(@RequestBody Map<String, List<Map<String, Object>>> requestBody, HttpSession httpSession) {
		
		
		// 데이터 가공 후 보호소 삽입
		List<Map<String, Object>> shelterList = requestBody.get("shelterList");
		System.out.println("shelterList : " + shelterList);
		
		for (Map<String, Object> shelter : shelterList) {
			
			
			try {
				
				ShelterDTO shelterDTO = new ShelterDTO();
				
				int count = catService.selectShelterCount() + 1;
				
				shelterDTO.setId("c" + count + "00");
				shelterDTO.setName(shelter.get("name").toString());
				shelterDTO.setAddr(shelter.get("addr").toString());
				shelterDTO.setTel(shelter.get("tel").toString());
				shelterDTO.setLat(((Double) shelter.get("lat")));
				shelterDTO.setLongt(((Double) shelter.get("longt")));
				
				
				catService.insertShelter(shelterDTO);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		
		// 데이터 가공 후 고양이 삽입
		List<Map<String, Object>> catList = requestBody.get("catList");
		System.out.println("catList : " + catList);
		
		for (Map<String, Object> cat : catList) {
			
			String shelterName = cat.get("보호소명").toString();
			
			try {
				List<ShelterDTO> list = catService.selectShelterByName(shelterName);
				String shelterId = list.get(0).getId();
				
				
				CatDTO catDTO = new CatDTO();
				
				// java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`scott`.`cat`, CONSTRAINT `cat_ibfk_2` FOREIGN KEY (`CAT_COLOR_ID`) REFERENCES `cat_color` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE)
				
				// 오류
				
				catDTO.setName(cat.get("name").toString());
				catDTO.setContent(cat.get("content").toString());
				catDTO.setAge(Integer.parseInt(cat.get("age").toString()));
				catDTO.setShelterId(shelterId);
				catDTO.setImg(cat.get("img").toString());
				
				UsersDTO loginDto = (UsersDTO) httpSession.getAttribute("loginUser");
				
				catDTO.setCreatedPerson(loginDto.getId());
				
				catService.insertCat(catDTO);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			
			String root = "C:\\code_upload\\Auto_window\\multi_it\\backend\\my_Project\\adoptMeow_boot\\adoptMeow_boot\\adoptMeow\\src\\main\\resources\\static\\img";
			System.out.println("root: " + root);
			String filePath = root + "\\uploadFiles";
			
			File mkdir = new File(filePath);
			
			if (!mkdir.exists()) {
				mkdir.mkdirs();
			}
			
			try {
				URL url = new URL(cat.get("img").toString());
				
				String savedName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
				
				
				InputStream in = url.openStream();
				Files.copy(in, Paths.get(filePath + "\\" + savedName));
				System.out.println("savedName : " + savedName);
				
				
			} catch (MalformedURLException e) {
				System.out.println("url 이상 : " + e);
				throw new RuntimeException(e);
			} catch (IOException e) {
				System.out.println("io 이상 : " + e);
				throw new RuntimeException(e);
			}
			
			
		}
		
		
	}
}
//@RestController :  RestController 어노테이션을 사용하면 @ResponseBody 를 일일이 선언 안해도 되게 지원해준다. 
//restController 차체가 controller  + @ResponseBody  ->ajax수업때 진행, springboot보강시
