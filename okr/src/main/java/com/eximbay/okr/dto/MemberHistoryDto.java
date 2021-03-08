package com.eximbay.okr.dto;

import java.time.Instant;
import com.eximbay.okr.entity.MemberHistory;
import com.eximbay.okr.listener.AbstractAuditableDto;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
public class MemberHistoryDto extends AbstractAuditableDto {
private Integer historySeq;
	    private String name;
	    private String localName;
	    private MemberDto member;
	    private String memberId;
	    private String email;
	    private String contactPhone;
	    private String password;
	    private String introduction;
	    private String image;
	    private String position;
	    private int level;
	    private String joiningDate;
	    private int career;
	    private String retirementDate;
	    private Instant lastPasswordChange;
	    private String passwordTempFlag;
	    private int passwordErrorCount;
	    private Instant lassLoginDate;
	    private String adminFlag;
	    private String adminAccessIp;
	    private String useFlag;
	    private String justification;
	    private Instant updatedDate;
		private String editCompanyOkrFlag;
	    
		
	    public void createMemberHistoryDto(String joiningDate ,String retirementDate, String editCompanyOkrFlag,
		String useFlag, String adminFlag, String eamil, MultipartFile files) {

			String joining = joiningDate.replace("-", "");
			this.setJoiningDate(joining);
	
			String retire = joiningDate.replace("-", "");
			this.setRetirementDate(retire);

	        // domain delete
	        int index= eamil.indexOf("@"); 
	        String exceptDomain = eamil.substring(0, index);
	        this.setMemberId(exceptDomain);
	        
	        String UseFlag = (useFlag == "Y") ? "Y" : "N";
	        this.setUseFlag(UseFlag);
	        
	        // Admin Flag 
	        String AdminFlag = (adminFlag == "Y") ? "Y" : "N";
	        this.setAdminFlag(adminFlag);

			String Edit = (editCompanyOkrFlag == "Y") ? "Y" : "N";
	        this.setEditCompanyOkrFlag(Edit);
	        
	    	String imageName = files != null ? files.getOriginalFilename() : "/assets/media/users/default.jpg";
	    	this.setImage(imageName);
	            
	    }
}
