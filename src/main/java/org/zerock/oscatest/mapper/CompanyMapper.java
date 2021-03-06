package org.zerock.oscatest.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.oscatest.domain.Company;
import org.zerock.oscatest.domain.Contract;
import org.zerock.oscatest.dto.ListDTO;

import java.util.List;

public interface CompanyMapper {
    //    @Param("comId") String comId, @Param("comName") String comName
    List<Company> getList(ListDTO listDTO);

    void insert(Company company);

    Company info(String comId);

    int getTotal(ListDTO listDTO);

    //    void delete(String comId);
    //update 버전 준비할 것 -> 후에 admin 관리
    void updateAsRemoved(String comId);

    //    void update(@Param("comName") String comName ,@Param("comId") String comId);
    void update(Company company);
}
