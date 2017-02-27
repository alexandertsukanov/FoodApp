package com.gda.ws.service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gda.ws.entity.User;
import com.gda.ws.repository.UserRepository;
import com.gda.ws.web.api.dto.UserDto;

@Service
public class UserServiceBean implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceBean.class);

    @Autowired
    private UserRepository repository;

    @Override
    public Collection<UserDto> findAll() {
        LOG.info("> findAll");
        Collection<User> found = repository.findAll();
        Collection<UserDto> result = found.stream()
        		.map(e -> from(e)).collect(Collectors.toList());
        LOG.info("< findAll");
        return result;
    }

    @Override
    public UserDto findOne(Long id) {
        LOG.info("> findOne {}", id);
        User found = repository.findOne(id);
        LOG.info("< findOne {}", id);
        return from(found);
    }

    @Transactional
    @Override
    public UserDto create(UserDto entity) {
        LOG.info("> create");
        User saved = repository.save(from(entity));
        LOG.info("< create");
        return from(saved);
    }

    @Transactional
    @Override
    public UserDto update(UserDto entity) {
        LOG.info("> update {}", entity.getId());
        User updated = repository.save(from(entity));
        LOG.info("< update {}", entity.getId());
        return from(updated);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        LOG.info("> delete {}", id);
        repository.delete(id);
        LOG.info("< delete {}", id);
    }

	@Override
	public UserDto findByDeviceId(String deviceId) {
		LOG.info("> findByDeviceId {}", deviceId);
        User found = repository.findByDeviceId(deviceId);
        LOG.info("< findByDeviceId {}", deviceId);
        return from(found);
	}
	
	private static UserDto from(User entity){
		if(Objects.isNull(entity)){
    		return null;
    	}
		UserDto dto = new UserDto();
    	dto.setId(entity.getId());
    	dto.setDeviceId(entity.getDeviceId());
    	return dto;
    }
    
    private static User from(UserDto dto){
    	if(Objects.isNull(dto)){
    		return null;
    	}
    	User entity = new User();
    	entity.setId(dto.getId());
    	entity.setDeviceId(dto.getDeviceId());
    	return entity;
    }
}
