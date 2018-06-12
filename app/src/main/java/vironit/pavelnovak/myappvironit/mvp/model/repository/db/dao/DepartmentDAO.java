package vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.DepartmentDB;

@Dao
public interface DepartmentDAO {
    @Query("SELECT * from DEPARTMENT")
    Single<DepartmentDB> getDepartments();

    @Query("SELECT * from DEPARTMENT WHERE department_name like :departmentName")
    Single<DepartmentDB> getDepartmentsByName(String departmentName);

    @Query("SELECT * from DEPARTMENT WHERE department_id like " +
            "(SELECT department_id FROM EMPLOYEE WHERE employee_first_name like :employeeFirstName and employee_middle_name like :employeeMiddleName and employee_last_name like :employeeLastName)")
    Single<DepartmentDB> getDepartmentByEmployeeName(String employeeFirstName,
                                                   String employeeMiddleName,
                                                   String employeeLastName);

    @Insert
    void insertDepartments(DepartmentDB... departments);

    @Delete
    void deleteDepartments(DepartmentDB... departments);
}
