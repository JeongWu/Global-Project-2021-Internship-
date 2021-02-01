package com.eximbay.okr.persistence.repository;

import java.util.List;

import com.eximbay.okr.persistence.entity.Objective;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OkrRepository extends JpaRepository<Objective, Integer> {
    
    //Objective findById(int id);

    @Query(value = "SELECT o.id, o.obj_no, o.obj_name, o.level, o.year, o.quarter, o.status, o.reg_user_id, o.reg_dt, o.mod_user_id, o.mod_dt, o.member_id, "
            + "AVG(IFNULL(k.pct_of_kr_complete, 0)) as percentage FROM objective o "
            + "left outer join key_result k on o.id = k.objective_id "
            + "WHERE o.id = :id "
            + "group by o.id ", nativeQuery = true)
    Objective findById(@Param("id") int id);

    //List<Objective> findByLevelAndQuarterAndYear(String level, Integer quarter, Integer year);

    @Query(value = "SELECT o.id, o.obj_no, o.obj_name, o.level, o.year, o.quarter, o.status, o.reg_user_id, o.reg_dt, o.mod_user_id, o.mod_dt, o.member_id, "
            + "AVG(IFNULL(k.pct_of_kr_complete, 0)) as percentage FROM objective o "
            + "left outer join key_result k on o.id = k.objective_id "
            + "WHERE o.level = :level and o.quarter = :quarter and o.year = :year "
            + "group by o.id ", nativeQuery = true)
    List<Objective> findByLevelAndQuarterAndYear(@Param("level") String level, @Param("quarter") Integer quarter, @Param("year") Integer year);

    //List<Objective> findByLevelAndQuarterAndYearAndMember_TeamId(String level, Integer quarter, Integer year, int teamId);
    
    @Query(value = "SELECT o.id, o.obj_no, o.obj_name, o.level, o.year, o.quarter, o.status, o.reg_user_id, o.reg_dt, o.mod_user_id, o.mod_dt, o.member_id, "
            + "AVG(IFNULL(k.pct_of_kr_complete, 0)) as percentage FROM objective o "
            + "left outer join key_result k on o.id = k.objective_id "
            + "left outer join member m on m.id = o.member_id "
            + "WHERE o.level = :level and o.quarter = :quarter and o.year = :year and m.team_id = :team_id "
            + "group by o.id ", nativeQuery = true)
    List<Objective> findByLevelAndQuarterAndYearAndMember_TeamId(@Param("level") String level, @Param("quarter") Integer quarter, @Param("year") Integer year, @Param("team_id") Integer teamId);


    //List<Objective> findByLevelAndQuarterAndYearAndMemberId(String level, Integer quarter, Integer year, int memberId);
    
    @Query(value = "SELECT o.id, o.obj_no, o.obj_name, o.level, o.year, o.quarter, o.status, o.reg_user_id, o.reg_dt, o.mod_user_id, o.mod_dt, o.member_id, "
            + "AVG(IFNULL(k.pct_of_kr_complete, 0)) as percentage FROM objective o "
            + "left outer join key_result k on o.id = k.objective_id "
            + "WHERE o.level = :level and o.quarter = :quarter and o.year = :year and o.member_id = :member_id "
            + "group by o.id ", nativeQuery = true)
    List<Objective> findByLevelAndQuarterAndYearAndMemberId(@Param("level") String level, @Param("quarter") Integer quarter, @Param("year") Integer year, @Param("member_id") Integer memberId);

}