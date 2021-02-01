package com.eximbay.okr.repository;

import java.util.List;

import com.eximbay.okr.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "SELECT c.id, c.name, ifnull(( "
        + "SELECT AVG(percentage) from ( "
          +  "SELECT AVG(IFNULL(k.pct_of_kr_complete, 0)) as percentage from Objective o "
            + "left outer join key_result k on o.id = k.objective_id "
            + "WHERE o.level = :level and o.quarter = :quarter and o.year = :year "
            + "group by o.id ) "
            + "),0) as percentage "
        + "from Company c", nativeQuery = true)
    List<Company> findByLevelAndQuarterAndYear(@Param("level") String level, @Param("quarter") Integer quarter, @Param("year") Integer year);

}