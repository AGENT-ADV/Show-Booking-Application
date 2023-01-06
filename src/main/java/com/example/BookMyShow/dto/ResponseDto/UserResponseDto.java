package com.example.BookMyShow.dto.ResponseDto;

import com.example.BookMyShow.dto.TicketDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;

    String name;

    String mobNo;

    //Optional

    List<TicketResponseDto> tickets;
}
