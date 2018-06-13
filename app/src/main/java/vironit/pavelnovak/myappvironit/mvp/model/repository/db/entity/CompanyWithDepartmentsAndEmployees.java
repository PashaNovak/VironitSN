package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

@Entity
public class CompanyWithDepartmentsAndEmployees {

    @Embedded
    @NonNull
    public CompanyDB companyDB;

    @Nullable
    @Relation(parentColumn = CompanyDB.COMPANY_ID, entityColumn = CompanyDB.COMPANY_ID, entity = DepartmentDB.class)
    public List<DepartmentWithEmployees> departmentWithEmployees;

    @Override
    public String toString() {
        return "CompanyWithDepartmentsAndEmployees{" +
                "companyDB=" + companyDB +
                ", departmentWithEmployees=" + departmentWithEmployees +
                '}';
    }
}
