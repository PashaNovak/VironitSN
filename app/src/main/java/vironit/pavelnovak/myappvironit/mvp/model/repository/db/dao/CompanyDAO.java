package vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyDB;

@Dao
public interface CompanyDAO {

    @Query("SELECT * from COMPANY")
    Single<CompanyDB> getCompanies();

    @Query("SELECT * from COMPANY WHERE company_id like " +
            "(SELECT company_id from DEPARTMENT WHERE department_id like" +
            "(SELECT department_id FROM EMPLOYEE WHERE employee_first_name like :employeeFirstName and employee_last_name like :employeeLastName))")
    Single<CompanyDB> getCompaniesByEmployeeName(String employeeFirstName, String employeeLastName);

    @Query("SELECT * from COMPANY WHERE company_id like (SELECT company_id from DEPARTMENT WHERE department_name like :departmentName)")
    Single<CompanyDB> getCompaniesByDepartmentName(String departmentName);

    @Insert
    void insertCompanies(CompanyDB... companies);

    @Delete
    void deleteCompanies(CompanyDB... companies);
}
