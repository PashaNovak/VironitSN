package vironit.pavelnovak.myappvironit.mvp.model.repository.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import vironit.pavelnovak.myappvironit.BuildConfig;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.converters.DateToLongConverter;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.converters.LongListToStringConverter;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao.CompanyWithDepartmentsAndEmployeesDAO;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao.CompanyWithDepatrmentDAO;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao.CompanyDAO;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao.DepartmentDAO;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao.EmployeeDAO;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.DepartmentDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB;

@Database(entities = {CompanyDB.class, DepartmentDB.class, EmployeeDB.class}, version = BuildConfig.DATA_BASE_VERSION)
@TypeConverters({DateToLongConverter.class, LongListToStringConverter.class})
public abstract class VironitSocialNetworkDatabase extends RoomDatabase{

    public abstract CompanyDAO getCompanyDAO();
    public abstract DepartmentDAO getDepartmentDAO();
    public abstract EmployeeDAO getEmployeeDAO();

    public abstract CompanyWithDepatrmentDAO getCompanyWithDepatrmentDAO();
    public abstract CompanyWithDepartmentsAndEmployeesDAO getCompanyWithDepartmentsAndEmployeesDAO();
}
