package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyDB.COMPANY_TABLE_NAME;

@Entity(tableName = COMPANY_TABLE_NAME)
public class CompanyDB {

    public static final String COMPANY_TABLE_NAME = "COMPANY";

    public static final String COMPANY_ID = "company_id";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COMPANY_ID)
    @Nullable private Long companyId;


    @ColumnInfo(name = "salary")
    @NonNull private List<Long> salary;


    @ColumnInfo(name = "company_name")
    @NonNull private String companyName;

    public CompanyDB(@Nullable Long companyId, @NonNull List<Long> salary, @NonNull String companyName) {
        this.companyId = companyId;
        this.salary = salary;
        this.companyName = companyName;
    }

    @Nullable
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(@Nullable Long companyId) {
        this.companyId = companyId;
    }

    @NonNull
    public List<Long> getSalary() {
        return salary;
    }

    public void setSalary(@NonNull List<Long> salary) {
        this.salary = salary;
    }

    @NonNull
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NonNull String companyName) {
        this.companyName = companyName;
    }
}
