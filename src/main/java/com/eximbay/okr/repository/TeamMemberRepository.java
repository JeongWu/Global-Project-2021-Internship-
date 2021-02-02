package com.eximbay.okr.repository;

import java.util.List;

import com.eximbay.okr.dto.TeamDto;
import com.eximbay.okr.entity.TeamMember;
import com.eximbay.okr.entity.TeamMemberId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {

    List<TeamMember> findAll();
    // @Query(value = "SELECT o.id, o.obj_no, o.obj_name, o.level, o.year,
    // o.quarter, o.status, o.reg_user_id, o.reg_dt, o.mod_user_id, o.mod_dt,
    // o.member_id, "
    // + "AVG(IFNULL(k.pct_of_kr_complete, 0)) as percentage FROM objective o "
    // + "left outer join key_result k on o.id = k.objective_id "
    // + "left outer join member m on m.id = o.member_id "
    // + "WHERE o.level = :level and o.quarter = :quarter and o.year = :ye ar and
    // m.team_id = :team_id "
    // + "group by o.id ", nativeQuery = true)
    // List<Objective> findByLevelAndQuarterAndYearAndMember_TeamId(@Param("level")
    // String level, @Param("quarter") Integer quarter, @Param("year") Integer year,
    // @Param("team_id") Integer teamId);

    @Query(value = "SELECT t.team_seq, t.name, t.team_type, t.use_flag,tm.member_seq,m.name,t.division_seq "
            + "FROM team_member tm " + "left outer join team2 t on t.team_seq = tm.team_seq "
            + "left outer join member2 m on m.member_seq = tm.member_seq "
            + "group by tm.apply_begin_date ", nativeQuery = true)
    List<TeamMember> findAll_TeamSeq();

}
