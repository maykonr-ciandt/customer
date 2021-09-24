package com.mk.customer.dto.mapper;


import com.mk.customer.dto.LeadDto;
import com.mk.customer.model.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LeadMapper {

    LeadMapper INSTANCE = Mappers.getMapper(LeadMapper.class);

    Lead toEntity(final LeadDto dto);

    LeadDto toDto(final Lead entity);

}
