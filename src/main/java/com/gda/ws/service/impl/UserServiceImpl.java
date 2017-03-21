package com.gda.ws.service.impl;

import com.gda.ws.dto.UserDto;
import com.gda.ws.entity.User;
import com.gda.ws.repository.UserRepository;
import com.gda.ws.service.UserService;
import com.gda.ws.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private MapperUtils mapperUtils;


    @Override
    public Collection<UserDto> findAll() {
        LOG.info("> findAll");
        Collection<User> found = repository.findAll();
        Collection<UserDto> result = found.stream()
        		.map(e -> mapperUtils.toUserDto(e)).collect(Collectors.toList());
        LOG.info("< findAll");
        return result;
    }

    @Override
    public UserDto findOne(Long id) {
        LOG.info("> findOne {}", id);
        User found = repository.findOne(id);
        LOG.info("< findOne {}", id);
        return mapperUtils.toUserDto(found);
    }

    @Transactional
    @Override
    public UserDto create(UserDto entity) {
        LOG.info("> create");
        User saved = repository.save(mapperUtils.toUser(entity));
        LOG.info("< create");
        return mapperUtils.toUserDto(saved);
    }

    @Transactional
    @Override
    public UserDto update(UserDto entity) {
        LOG.info("> update {}", entity.getId());
        User updated = repository.save(mapperUtils.toUser(entity));
        LOG.info("< update {}", entity.getId());
        return mapperUtils.toUserDto(updated);
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
        return mapperUtils.toUserDto(found);
	}
	

}
