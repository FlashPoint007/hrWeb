package com.dhu.mapper;

import com.dhu.dto.EmpAndWage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Mapper
@Repository
public interface WageMapper {
    void updateEmpAndWage(EmpAndWage empAndWage);

    Collection<EmpAndWage> selectEmpAndWage();

    EmpAndWage selectEmpAndWageById(int id);

    void addNewWageById(Integer id);
}
