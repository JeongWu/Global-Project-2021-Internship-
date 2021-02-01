package com.eximbay.okr.persistence.repository;

import java.util.List;

import com.eximbay.okr.persistence.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    
    Team findById(int id);

    @Query(value = "SELECT t.id, t.name, t.reg_user_id, t.reg_dt, t.mod_user_id, t.mod_dt, ( "
      + "SELECT ifnull(AVG(percent), 0) FROM ( "
        + "SELECT AVG(ifnull(k.pct_of_kr_complete, 0)) as percent FROM objective o "
        + "left outer join key_result k on o.id = k.objective_id "
        + "WHERE o.level = :level and o.quarter = :quarter and o.year = :year "
        + "group by o.id ) "
        + ") as percentage "
    + "FROM team t ", nativeQuery = true)
    List<Team> findByLevelAndQuarterAndYear(@Param("level") String level, @Param("quarter") Integer quarter, @Param("year") Integer year);
    
}