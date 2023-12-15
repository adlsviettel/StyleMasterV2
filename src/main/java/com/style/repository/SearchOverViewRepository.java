package com.style.repository;

import com.style.entity.SearchOverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchOverViewRepository extends JpaRepository<SearchOverView, String> {
    @Query(value = "{CALL sm.usp_StyleMaster_SearchOverview(?1,?2,?3,?4,?5,?6,?7,?8)}", nativeQuery = true)
    public List<SearchOverView> searchOverView(String pStyleMasterCode,
                                               String pSeason,
                                               String pProductType,
                                               String pMerAccountName,
                                               String pFromDate,
                                               String pToDate,
                                               Integer pPageIndex,
                                               Integer pPageSize);
}
