package com.ftninformatika.glumciapp.db.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable(tableName = Film.TABLE_NAME_USERS)
public class Film {

    public static final String TABLE_NAME_USERS = "filmovi";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAZIV = "naziv";
    public static final String FIELD_ZANR = "zanr";
    public static final String FIELD_GODINA = "godina";
    public static final String FIELD_GLUMAC = "glumac";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIELD_NAZIV)
    private String mNaziv;

    @DatabaseField(columnName = FIELD_ZANR)
    private String mZanr;

    @DatabaseField(columnName = FIELD_GODINA)
    private String mGodina;

    @DatabaseField(columnName = FIELD_GLUMAC, foreign = true, foreignAutoRefresh = true)
    private Glumac mGlumac;




    public Film() {

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNaziv() {
        return mNaziv;
    }

    public void setmNaziv(String mNaziv) {
        this.mNaziv = mNaziv;
    }

    public String getmZanr() {
        return mZanr;
    }

    public void setmZanr(String mZanr) {
        this.mZanr = mZanr;
    }

    public String getmGodina() {
        return mGodina;
    }

    public void setmGodina(String mGodina) {
        this.mGodina = mGodina;
    }

    public Glumac getmGlumac() {
        return mGlumac;
    }

    public void setmGlumac(Glumac mGlumac) {
        this.mGlumac = mGlumac;
    }

    @Override
    public String toString() {
        return "Film{" +
                "mNaziv='" + mNaziv + '\'' +
                ", mZanr='" + mZanr + '\'' +
                '}';
    }
}