package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

@Entity
public class CompanyWithDepartmentsDB {

    @Embedded
    @NonNull
    public CompanyDB companyDB;

    @Relation(parentColumn = CompanyDB.COMPANY_ID, entityColumn = CompanyDB.COMPANY_ID, entity = DepartmentDB.class)
    @Nullable
    public List<DepartmentDB> departments;

    @Override
    public String toString() {
        if (departments != null) {
            return "CompanyWithDepartmentsDB{" +
                    "companyDB=" + companyDB.toString() +
                    ", departments=" + departments.toString() +
                    '}';
        } else return "CompanyWithDepartmentsDB{" +
                "companyDB=" + companyDB.toString() +
                ", departments=" + "[ ]" +
                '}';
    }
}
