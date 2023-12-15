package com.style.repository;

import com.style.entity.GetOverView;
import com.style.entity.StyleMasterDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleMasterRepository extends JpaRepository<GetOverView, Integer> {
    //GetOverView
    @Query(value = "{CALL sm.usp_StyleMaster_GetOverview(?,?)}", nativeQuery = true)
    public List<GetOverView> getOverview(Integer pPageIndex, Integer pPageSize);
}
