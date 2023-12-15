package com.style.repository;

import com.style.entity.GetFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetFilterRepository extends JpaRepository<GetFilter, Integer> {
    @Query(value = "{CALL sm.usp_StyleMaster_GetFilter}", nativeQuery = true)
    public List<GetFilter> getFilterList();
}
