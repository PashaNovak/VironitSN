package vironit.pavelnovak.myappvironit.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vironit.pavelnovak.myappvironit.mvp.model.repository.db.VironitSocialNetworkDatabase;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.DepartmentDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.InsuranceDB;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final VironitSocialNetworkDatabase mVironitSocialNetworkDatabase) {
        PopulateDbAsync task = new PopulateDbAsync(mVironitSocialNetworkDatabase);
        task.execute();
    }

    public static void populateSync(@NonNull final VironitSocialNetworkDatabase mVironitSocialNetworkDatabase) {
        populateWithTestData(mVironitSocialNetworkDatabase);
    }

    private static CompanyDB addCompany(final VironitSocialNetworkDatabase mVironitSocialNetworkDatabase, CompanyDB company) {
        mVironitSocialNetworkDatabase.getCompanyDAO().insertCompanies(company);
        return company;
    }

    private static DepartmentDB addDepartment(final VironitSocialNetworkDatabase mVironitSocialNetworkDatabase, DepartmentDB department) {
        mVironitSocialNetworkDatabase.getDepartmentDAO().insertDepartments(department);
        return department;
    }

    private static EmployeeDB addEmployee(final VironitSocialNetworkDatabase mVironitSocialNetworkDatabase, EmployeeDB employee) {
        mVironitSocialNetworkDatabase.getEmployeeDAO().insertEmployees(employee);
        return employee;
    }

    private static void populateWithTestData(VironitSocialNetworkDatabase mVironitSocialNetworkDatabase) {
        CompanyDB company = new CompanyDB(1L, new ArrayList<>(), "TestCompany1");
        addCompany(mVironitSocialNetworkDatabase, company);

        DepartmentDB department = new DepartmentDB(1L, 1L, "TestDepartment1");
        addDepartment(mVironitSocialNetworkDatabase, department);

        Date date = new Date();
        Date dateNew = new Date(date.getTime() + 86400000L);

        EmployeeDB employee = new EmployeeDB(1L,
                1L,
                "Ivan",
                "Ivanovich",
                "Ivanov",
                new InsuranceDB(1L,
                        1L,
                        "TestInsuranceCompany1",
                        date,
                        dateNew),
                new Date(870048000000L));

        addEmployee(mVironitSocialNetworkDatabase, employee);

//        List<CompanyDB> companies = mVironitSocialNetworkDatabase.getCompanyDAO().getCompanies();
//        List<CompanyDB> companiesByDepartmentName = mVironitSocialNetworkDatabase.getCompanyDAO().getCompaniesByDepartmentName("TestDepartment1");
//        List<CompanyDB> companiesByEmployeeName = mVironitSocialNetworkDatabase.getCompanyDAO().getCompaniesByEmployeeName("Ivan", "Ivanov");

//        List<DepartmentDB> departments = mVironitSocialNetworkDatabase.getDepartmentDAO().getDepartments();
//        List<DepartmentDB> departmentsByName = mVironitSocialNetworkDatabase.getDepartmentDAO().getDepartmentsByName("TestDepartment1");
//        List<DepartmentDB> departmentsByEmployeeName = mVironitSocialNetworkDatabase.getDepartmentDAO().getDepartmentByEmployeeName("Ivan",
//                "Ivanovich", "Ivanov");

//        List<EmployeeDB> employees = mVironitSocialNetworkDatabase.getEmployeeDAO().getEmployeesByFirstAndMiddleName("Ivan",
//                "Ivanovich");
//        List<EmployeeDB> employeesByCompanyName = mVironitSocialNetworkDatabase.getEmployeeDAO().getEmployeeByCompaneName("TestCompany1");

//        Log.d(DatabaseInitializer.TAG, "Companies: " + companies.get(0).getCompanyName());
//        Log.d(DatabaseInitializer.TAG, "Companies by department name: " + companiesByDepartmentName.get(0).getCompanyName());
//        Log.d(DatabaseInitializer.TAG, "Companies by employee name" + companiesByEmployeeName.get(0).getCompanyName() + "\n");

//        Log.d(DatabaseInitializer.TAG, "Departments: " + departments.get(0).getDepartmentName());
//        Log.d(DatabaseInitializer.TAG, "Departments by name: " + departmentsByName.get(0).getDepartmentName());
//        Log.d(DatabaseInitializer.TAG, "Departments by employee name: " + departmentsByEmployeeName.get(0).getDepartmentName() + "\n");
//
//        Log.d(DatabaseInitializer.TAG, "Employees: " + employees.get(0).getEmployeeFirstName());
//        Log.d(DatabaseInitializer.TAG, "Employees by company name: " + employeesByCompanyName.get(0).getEmployeeFirstName());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final VironitSocialNetworkDatabase mVironitSocialNetworkDatabase;

        PopulateDbAsync(VironitSocialNetworkDatabase mVironitSocialNetworkDatabase) {
            this.mVironitSocialNetworkDatabase = mVironitSocialNetworkDatabase;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            populateWithTestData(mVironitSocialNetworkDatabase);
            return null;
        }
    }
}
