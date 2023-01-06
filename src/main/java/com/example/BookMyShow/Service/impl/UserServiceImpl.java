package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.UserService;
import com.example.BookMyShow.converter.TicketConverter;
import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import com.example.BookMyShow.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto); //Cleaner
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id)
    {

        UserEntity userEntity = userRepository.findById(id).get();

        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);



        List<TicketEntity> ticketEntityList = userEntity.getTicketEntities();

        List<TicketResponseDto> ticketResponseDtoList = new ArrayList<>();

        for(TicketEntity  te: ticketEntityList )
        {
            ticketResponseDtoList.add(TicketConverter.convertEntityToDto(te));
        }

        userResponseDto.setTickets(ticketResponseDtoList);

        return userResponseDto;
    }
}
