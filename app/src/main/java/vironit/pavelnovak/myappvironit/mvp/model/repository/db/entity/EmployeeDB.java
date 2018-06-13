package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB.EMPLOYEE_FIRST_NAME;
import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB.EMPLOYEE_TABLE_NAME;

@Entity(tableName = EMPLOYEE_TABLE_NAME,
        foreignKeys = {@ForeignKey(entity = DepartmentDB.class,
                parentColumns = DepartmentDB.DEPARTMENT_ID,
                childColumns = DepartmentDB.DEPARTMENT_ID,
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)},
        indices = {@Index(value = EMPLOYEE_FIRST_NAME, unique = false, name = "employee_first_name_index")})
public   class EmployeeDB {

    public static final String EMPLOYEE_TABLE_NAME = "EMPLOYEE";

    public static final String EMPLOYEE_ID = "employee_id";

    public static final String EMPLOYEE_FIRST_NAME = "employee_first_name";

    public static final String EMPLOYEE_MIDDLE_NAME = "employee_middle_name";

    public static final String EMPLOYEE_LAST_NAME = "employee_last_name";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = EMPLOYEE_ID)
    @Nullable
    private Long employeeId;

    @ColumnInfo(name = DepartmentDB.DEPARTMENT_ID)
    @Nullable
    private Long departmentId;

    @ColumnInfo(name = EMPLOYEE_FIRST_NAME)
    @NonNull
    private String employeeFirstName;

    @ColumnInfo(name = EMPLOYEE_MIDDLE_NAME)
    @NonNull
    private String employeeMiddleName;

    @ColumnInfo(name = EMPLOYEE_LAST_NAME)
    @NonNull
    private String employeeLastName;

    @Embedded
    @NonNull
    private InsuranceDB insurance;

    @ColumnInfo(name = "employee_birthday")
    @NonNull
    private Date date;

    public EmployeeDB(Long employeeId,
                      Long departmentId,
                      @NonNull String employeeFirstName,
                      @NonNull String employeeMiddleName,
                      @NonNull String employeeLastName,
                      @NonNull InsuranceDB insurance,
                      @NonNull Date date) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.employeeLastName = employeeLastName;
        this.insurance = insurance;
        this.date = date;
    }

    @Nullable
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(@Nullable Long employeeId) {
        this.employeeId = employeeId;
    }

    @Nullable
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(@Nullable Long departmentId) {
        this.departmentId = departmentId;
    }

    @NonNull
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(@NonNull String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    @NonNull
    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    public void setEmployeeMiddleName(@NonNull String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }

    @NonNull
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(@NonNull String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    @NonNull
    public InsuranceDB getInsurance() {
        return insurance;
    }

    public void setInsurance(@NonNull InsuranceDB insurance) {
        this.insurance = insurance;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmployeeDB{" +
                "employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeMiddleName='" + employeeMiddleName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", insurance=" + insurance +
                ", date=" + date +
                '}';
    }
}
