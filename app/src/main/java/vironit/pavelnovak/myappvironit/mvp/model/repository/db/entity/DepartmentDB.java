package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.DepartmentDB.DEPARTMENT_TABLE_NAME;

@Entity(tableName = DEPARTMENT_TABLE_NAME,
        foreignKeys = {@ForeignKey(entity = CompanyDB.class,
                parentColumns = CompanyDB.COMPANY_ID,
                childColumns = CompanyDB.COMPANY_ID,
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)})

public class DepartmentDB {

    public static final String DEPARTMENT_TABLE_NAME = "DEPARTMENT";

    public static final String DEPARTMENT_ID = "department_id";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DEPARTMENT_ID)
    @Nullable
    private Long departmentId;

    @ColumnInfo(name = CompanyDB.COMPANY_ID)
    @Nullable
    private Long companyId;

    @ColumnInfo(name = "department_name")
    @NonNull
    private String departmentName;

    public DepartmentDB(@Nullable Long departmentId, @Nullable Long companyId, @NonNull String departmentName) {
        this.departmentId = departmentId;
        this.companyId = companyId;
        this.departmentName = departmentName;
    }

    @Nullable
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(@Nullable Long departmentId) {
        this.departmentId = departmentId;
    }

    @Nullable
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(@Nullable Long companyId) {
        this.companyId = companyId;
    }

    @NonNull
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@NonNull String departmentName) {
        this.departmentName = departmentName;
    }
}
