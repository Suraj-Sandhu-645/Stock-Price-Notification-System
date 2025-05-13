package com.example.stock_price_notifier.service;

import com.example.stock_price_notifier.dto.UserDTO;
import com.example.stock_price_notifier.entity.UserEntity;
import com.example.stock_price_notifier.objectMapper.ObjectMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private ObjectMapperConfig objectMapperConfig;

//    public UserService(ObjectMapperConfig objectMapperConfig) {
//        this.objectMapperConfig = objectMapperConfig;
//    }

    public UserDTO registerUser(UserDTO userDTO) {
        UserEntity userEntity = objectMapperConfig.userDtoToUserEntity(userDTO);

        return objectMapperConfig.userEntityToUserDto(userEntity);
    }
}
