package com.gda.ws.service;

import com.gda.ws.dto.UserDto;

import java.util.Collection;

public interface UserService {

    Collection<UserDto> findAll();
    UserDto findOne(Long id);
    UserDto create(UserDto entity);
    UserDto update(UserDto entity);
    void delete(Long id);
    
    UserDto findByDeviceId(String deviceId);
}
