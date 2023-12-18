package com.style.repository;

import com.style.entity.GetOverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchOverViewRepository extends JpaRepository<GetOverView, String> {
    @Query(value = "{CALL sm.usp_StyleMaster_SearchOverview(?1,?2,?3,?4,?5,?6,?7,?8,?9)}", nativeQuery = true)
    public List<GetOverView> searchOverView(String pStyleMasterCode,
                                               String pSeason,
                                               String pProductType,
                                               String pFactoryAllocation,
                                               String pMerAccountName,
                                               String pFromDate,
                                               String pToDate,
                                               Integer pPageIndex,
                                               Integer pPageSize);
}
