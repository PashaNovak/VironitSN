package vironit.pavelnovak.myappvironit.mvp.model.repository.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyWithDepartmentsDB;

@Dao
public interface CompanyWithDepatrmentDAO {

    @Query("SELECT * from COMPANY")
    Single<CompanyWithDepartmentsDB> getCompanyWithDepartments();
}
