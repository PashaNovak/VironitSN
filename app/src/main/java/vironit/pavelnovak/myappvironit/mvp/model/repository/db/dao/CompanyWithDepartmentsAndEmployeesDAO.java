package vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyWithDepartmentsAndEmployees;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyWithDepartmentsAndEmployeesFromReverse;

@Dao
public interface CompanyWithDepartmentsAndEmployeesDAO {

    @Query("SELECT * from COMPANY")
    Single<CompanyWithDepartmentsAndEmployees> getCompanyWithDepartmentsAndEmployees();

    @Query("SELECT COMPANY.*, DEPARTMENT.*, EMPLOYEE.* FROM EMPLOYEE INNER JOIN DEPARTMENT ON EMPLOYEE.department_id = DEPARTMENT.department_id INNER JOIN COMPANY ON COMPANY.company_id = DEPARTMENT.company_id WHERE employee_id = :employee_id LIMIT 1")
    Single<CompanyWithDepartmentsAndEmployeesFromReverse> getCompanyWithDepartmentsAndEmployeesFromReverse(Long employee_id);
}
