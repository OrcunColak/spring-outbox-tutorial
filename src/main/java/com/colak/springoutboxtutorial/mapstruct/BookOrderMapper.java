package com.colak.springoutboxtutorial.mapstruct;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;
import com.colak.springoutboxtutorial.jpa.BookOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookOrderMapper {

    BookOrderMapper INSTANCE = Mappers.getMapper(BookOrderMapper.class);

    BookOrder dtoToBookOrder(BookOrderDTO bookOrderDTO);

}
