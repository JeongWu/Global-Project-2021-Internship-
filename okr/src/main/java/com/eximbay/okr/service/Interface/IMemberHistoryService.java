package com.eximbay.okr.service.Interface;


import java.time.LocalDate;
import java.util.List;

import com.eximbay.okr.dto.MemberDto;
import com.eximbay.okr.dto.MemberHistoryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IMemberHistoryService extends ISerivce<MemberHistoryDto, Integer> {
	List<MemberHistoryDto> findByName(String name);
	List<MemberHistoryDto> findByMember(MemberDto member);
}
