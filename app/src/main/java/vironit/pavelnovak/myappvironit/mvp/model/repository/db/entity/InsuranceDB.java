package vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

public class InsuranceDB {

    public static final String INSURANCE_ID = "insurance_id";

    @Nullable private Long insuranceId;

    @Nullable private Long insuranceCompanyId;

    @NonNull private String insuranceCompanyName;

    @NonNull private Date dateStart;

    @NonNull private Date dateFinish;

    public InsuranceDB(Long insuranceId, Long insuranceCompanyId, @NonNull String insuranceCompanyName, @NonNull Date dateStart, @NonNull Date dateFinish) {
        this.insuranceId = insuranceId;
        this.insuranceCompanyId = insuranceCompanyId;
        this.insuranceCompanyName = insuranceCompanyName;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    @Nullable
    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(@Nullable Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Nullable
    public Long getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(@Nullable Long insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    @NonNull
    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(@NonNull String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    @NonNull
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(@NonNull Date dateStart) {
        this.dateStart = dateStart;
    }

    @NonNull
    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(@NonNull Date dateFinish) {
        this.dateFinish = dateFinish;
    }
}
