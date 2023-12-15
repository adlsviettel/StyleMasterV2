package com.style.repository;

import com.style.entity.InsertStyleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertStyleMasterRepository extends JpaRepository<InsertStyleMaster, Integer> {
    @Procedure(name = "sm.usp_StyleMaster_InsertUpdate")
    public String insertUpdateStyleMaster(@Param("pJSONStyleMaster") String pJSONStyleMaster,
                                    @Param("pAction") Integer pAction,
                                    @Param("pCreatedBy") Integer pCreatedBy,
                                    @Param("pOutput") Integer pOutput);
}
