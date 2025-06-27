package com.nav.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nav.entity.DoctorEntity;
import com.nav.errors.DoctorNotFoundException;
import com.nav.repository.IDoctorRepository;
import com.nav.vo.DoctorVO;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public List<DoctorVO> findAllDoctors() {
		// use Repo
		List<DoctorEntity> listEntities = doctorRepo.findAll();
		// convert list entity to list of VOV objects
		List<DoctorVO> listVO = new ArrayList<DoctorVO>();
		listEntities.forEach(entity -> {
			DoctorVO vo = new DoctorVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		return listVO;
	}

	@Override
	public String registerDoctor(DoctorVO vo) {
		// convert VO class object to Entity class obj
		DoctorEntity entity = new DoctorEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		
		int idVal = doctorRepo.save(entity).getDid();
		return "Doctor is registered with id value::"+idVal;
	}

	@Override
	public DoctorVO showDoctorById(int id) {
		DoctorEntity entiity = doctorRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		DoctorVO vo = new DoctorVO();
		BeanUtils.copyProperties(entiity, vo);
		return vo;
	}

	@Override
	public String editDoctor(DoctorVO vo) {
		//convert vo object to Entity object
		DoctorEntity entity = doctorRepo.findById(vo.getDid()).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		BeanUtils.copyProperties(vo, entity);
		entity.setUpdateBy(System.getProperty("user.name"));
		//update the object
		doctorRepo.save(entity);
		return vo.getDid()+" Doctor details are updated";
	}

	@Override
	public String removeDoctor(int did) throws Exception {
		DoctorEntity entity = doctorRepo.findById(did).orElseThrow(()->new DoctorNotFoundException("Invalis Doctor Id"));
		doctorRepo.deleteById(did);
		return did+" id Doctor is Deleted";
	}

}
