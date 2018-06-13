package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.VironitSocialNetworkDatabase;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.DepartmentDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.InsuranceDB;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IMainView;
import vironit.pavelnovak.myappvironit.utils.AppLog;

@InjectViewState
public class MainPresenter extends BaseAppPresenter<IMainView> {

    @Inject
    VironitSocialNetworkDatabase vironitSocialNetworkDatabase;

    public void showProgress() {
        getViewState().showProgress();
    }

    public void showProgressWithMessage(String text) {
        getViewState().showProgress(text);
    }

    public void showMessage(String text) {
        getViewState().showMessage(text, true, null, null);
    }

    public void showDialogMessage(String text) {
        getViewState().showDialogMessage(text, true);
    }

    @NonNull
    @Override
    public String getString(int strResId) {
        return null;
    }

    public MainPresenter() {
        App.getAppComponent().inject(this);
    }

    public void showDialogWithOptions(String title, String message) {
        getViewState().showDialogWithOptions(title, message,
                "ok", "cancel",
                null, null, true);
    }

    public void addData() {
        /*DepartmentDB department = new DepartmentDB(1L, 1L, "TestDepartment1");
        vironitSocialNetworkDatabase.getDepartmentDAO()
                .insertDepartments(department)
                .subscribeOn(mIOScheduler)
                .subscribe();

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
        vironitSocialNetworkDatabase.getEmployeeDAO().insertEmployees(employee)
                .subscribeOn(mIOScheduler)
                .subscribe();*/

        vironitSocialNetworkDatabase.getCompanyDAO()
                .getCompaniesByDepartmentName("Department1")
                .subscribeOn(mIOScheduler)
                .subscribe(companyDB -> AppLog.logPresenter(this, companyDB.getCompanyName() + "AAAAAAAAAAAAAAAAA"),
                        this);

        vironitSocialNetworkDatabase.getCompanyDAO()
                .getCompaniesByEmployeeName("Ivan", "Ivanov")
                .subscribeOn(mIOScheduler)
                .subscribe(companyDB -> AppLog.logPresenter(this, companyDB.getCompanyName() + "AAAAAAAAAAAAAAAAAAAAAAAAA"),
                        this);

        vironitSocialNetworkDatabase.getDepartmentDAO()
                .getDepartmentsByName("Department1")
                .subscribeOn(mIOScheduler)
                .subscribe(departmentDB -> AppLog.logPresenter(this, departmentDB.getDepartmentName() + "AAAAAAAAAAAAAAAAAAAA"),
                        this);

        vironitSocialNetworkDatabase.getDepartmentDAO()
                .getDepartmentByEmployeeName("Ivan", "Ivanovich", "Ivanov")
                .subscribeOn(mIOScheduler)
                .subscribe(departmentDB -> AppLog.logPresenter(this, departmentDB.getDepartmentName() + "AAAAAAAAAAAAAAAAAAAA"),
                        this);

        vironitSocialNetworkDatabase.getEmployeeDAO()
                .getEmployeeByCompaneName("Company1")
                .subscribeOn(mIOScheduler)
                .subscribe(employeeDB -> AppLog.logPresenter(this, employeeDB.getEmployeeFirstName() + " " + employeeDB.getEmployeeLastName()),
                        this);

        vironitSocialNetworkDatabase.getEmployeeDAO()
                .getEmployeesByFirstAndMiddleName("Ivan", "Ivanovich")
                .subscribeOn(mIOScheduler)
                .subscribe(employeeDB -> AppLog.logPresenter(this, employeeDB.getEmployeeFirstName() + " " + employeeDB.getEmployeeLastName()),
                        this);

        vironitSocialNetworkDatabase.getCompanyWithDepatrmentDAO()
                .getCompanyWithDepartments()
                .subscribeOn(mIOScheduler)
                .subscribe(companyAndDepartments -> AppLog.logPresenter(this, companyAndDepartments.toString()), this);

        vironitSocialNetworkDatabase.getCompanyWithDepartmentsAndEmployeesDAO()
                .getCompanyWithDepartmentsAndEmployees()
                .subscribeOn(mIOScheduler)
                .subscribe(companyWithDepartmentsAndEmployees -> AppLog.logPresenter(this, companyWithDepartmentsAndEmployees.toString()), this);

        vironitSocialNetworkDatabase.getCompanyWithDepartmentsAndEmployeesDAO()
                .getCompanyWithDepartmentsAndEmployeesFromReverse(1L)
                .subscribeOn(mIOScheduler)
                .subscribe(companyWithDepartmentsAndEmployeesFromReverse -> AppLog.logPresenter(this, companyWithDepartmentsAndEmployeesFromReverse.toString()), this);
    }
}
