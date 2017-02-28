package com.gda.ws.service;

import java.util.Collection;

import com.gda.ws.dto.UserDto;

public interface UserService {

    Collection<UserDto> findAll();
    UserDto findOne(Long id);
    UserDto create(UserDto entity);
    UserDto update(UserDto entity);
    void delete(Long id);
    
    UserDto findByDeviceId(String deviceId);
}
