package vironit.pavelnovak.myappvironit.mvp.model.repository.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LongListToStringConverter {
    @TypeConverter
    @NonNull
    public List<Long> stringToListLong(@Nullable String string) {
        return string == null ? new ArrayList<>() : getListFromString(string);
    }

    @TypeConverter
    @NonNull
    public String listLongToString(@Nullable List<Long> list) {
        return list == null ? "" : getStringFromList(list);
    }

    private String getStringFromList(List<Long> list) {
        StringBuilder result = new StringBuilder();
        for (long item : list) {
            result.append(item);
            result.append(',');
        }
        return result.toString();
    }

    private List<Long> getListFromString(String string) {
        List<Long> list = new ArrayList<>();
        for (String element : string.split(",")) {
            list.add(Long.parseLong(element));
        }
        return list;
    }
}
