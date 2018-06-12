package vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB;

@Dao
public interface EmployeeDAO {

    @Query("SELECT * from EMPLOYEE WHERE employee_first_name like :employeeFirstName and employee_middle_name like :employeeMiddleName")
    Single<EmployeeDB> getEmployeesByFirstAndMiddleName(String employeeFirstName, String employeeMiddleName);

    @Query("SELECT * from EMPLOYEE WHERE department_id like " +
            "(SELECT department_id FROM DEPARTMENT WHERE company_id like " +
            "(SELECT company_id FROM COMPANY where company_name like :companyName))")
    Single<EmployeeDB> getEmployeeByCompaneName(String companyName);

    @Query("SELECT * from EMPLOYEE")
    Single<EmployeeDB> getEmployees();

    @Insert
    void insertEmployees(EmployeeDB... employees);

    @Delete
    void deleteEmployees(EmployeeDB... employees);
}
