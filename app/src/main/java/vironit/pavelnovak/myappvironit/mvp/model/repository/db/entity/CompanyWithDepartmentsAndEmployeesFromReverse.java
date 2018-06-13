package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;
import java.util.List;

import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB.EMPLOYEE_FIRST_NAME;
import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB.EMPLOYEE_LAST_NAME;
import static vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB.EMPLOYEE_MIDDLE_NAME;

@Entity
public class CompanyWithDepartmentsAndEmployeesFromReverse {

    @ColumnInfo(name = CompanyDB.COMPANY_ID)
    private Long company_id;

    @ColumnInfo(name = "salary")
    @Nullable
    private List<Long> salary;


    @ColumnInfo(name = "company_name")
    @Nullable
    private String companyName;

    @ColumnInfo(name = DepartmentDB.DEPARTMENT_ID)
    @Nullable
    private Long department_id;

    @ColumnInfo(name = "department_name")
    @Nullable
    private String department_name;

    @ColumnInfo(name = EmployeeDB.EMPLOYEE_ID)
    @Nullable
    private Long employeeId;

    @ColumnInfo(name = EMPLOYEE_FIRST_NAME)
    @NonNull
    private String employeeFirstName;

    @ColumnInfo(name = EMPLOYEE_MIDDLE_NAME)
    @NonNull
    private String employeeMiddleName;

    @ColumnInfo(name = EMPLOYEE_LAST_NAME)
    @NonNull
    private String employeeLastName;

    @ColumnInfo(name = "employee_birthday")
    @NonNull
    private Date date;

    public CompanyWithDepartmentsAndEmployeesFromReverse(Long company_id, List<Long> salary, String companyName, Long department_id, String department_name, Long employeeId, @NonNull String employeeFirstName, @NonNull String employeeMiddleName, @NonNull String employeeLastName, @NonNull Date date) {
        this.company_id = company_id;
        this.salary = salary;
        this.companyName = companyName;
        this.department_id = department_id;
        this.department_name = department_name;
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.employeeLastName = employeeLastName;
        this.date = date;
    }

    public Long getCompany_id() {
        return company_id;
    }

    @Nullable
    public List<Long> getSalary() {
        return salary;
    }

    @Nullable
    public String getCompanyName() {
        return companyName;
    }

    @Nullable
    public Long getDepartment_id() {
        return department_id;
    }

    @Nullable
    public String getDepartment_name() {
        return department_name;
    }

    @Nullable
    public Long getEmployeeId() {
        return employeeId;
    }

    @NonNull
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    @NonNull
    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    @NonNull
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CompanyWithDepartmentsAndEmployeesFromReverse{" +
                "company_id=" + company_id +
                ", salary=" + salary +
                ", companyName='" + companyName + '\'' +
                ", department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeMiddleName='" + employeeMiddleName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", date=" + date +
                '}';
    }
}
