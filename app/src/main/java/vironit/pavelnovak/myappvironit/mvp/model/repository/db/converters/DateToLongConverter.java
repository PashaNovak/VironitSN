package vironit.pavelnovak.myappvironit.mvp.model.repository.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import java.util.Date;

public class DateToLongConverter {

    @TypeConverter
    @Nullable
    public Date fromLongToDate(@Nullable Long dateInLong) {
        if (dateInLong != null) {
            return new Date(dateInLong);
        } else return null;
    }

    @TypeConverter
    @Nullable
    public Long fromDateToLong(@Nullable Date dateInDate) {
        if (dateInDate != null) {
            return dateInDate.getTime();
        } else return null;
    }
}
