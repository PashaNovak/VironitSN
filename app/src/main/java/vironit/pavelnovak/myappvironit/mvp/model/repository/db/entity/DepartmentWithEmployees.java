package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

@Entity
public class DepartmentWithEmployees {

    @Embedded
    @NonNull
    public DepartmentDB departmentDB;

    @Nullable
    @Relation(parentColumn = DepartmentDB.DEPARTMENT_ID, entityColumn = DepartmentDB.DEPARTMENT_ID, entity = EmployeeDB.class)
    public List<EmployeeDB> employees;

    @Override
    public String toString() {
        return "DepartmentWithEmployees{" +
                "departmentDB=" + departmentDB +
                ", employees=" + employees +
                '}';
    }
}
