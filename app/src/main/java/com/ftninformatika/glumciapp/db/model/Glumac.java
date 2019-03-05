package com.ftninformatika.glumciapp.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


import java.util.ArrayList;

@DatabaseTable(tableName = Glumac.TABLE_NAME_USERS)
public class Glumac {

    public static final String TABLE_NAME_USERS = "glumci";

    public static final String FIELD_NAME_ID     = "id";
    public static final String FIELD_IME   = "ime";
    public static final String FIELD_PREZIME   = "prezime";
    public static final String FIELD_BIOGRAFIJA   = "biografija";
    public static final String FIELD_OCENA  = "ocena";
    public static final String FIELD_DATUM_RODJENJA   = "datum rodjenja";
    public static final String FIELD_FILMOVI  = "filmovi";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIELD_IME)
    private String mIme;

    @DatabaseField(columnName = FIELD_PREZIME)
    private String mPrezime;

    @DatabaseField(columnName = FIELD_BIOGRAFIJA)
    private String mBiografija;

    @DatabaseField(columnName = FIELD_OCENA)
    private float mOcena;

    @DatabaseField(columnName = FIELD_DATUM_RODJENJA)
    private String mDatumRodjenja;

    @ForeignCollectionField(columnName = FIELD_FILMOVI)
    private ArrayList<Film> mFilmovi;

    public Glumac() {

    }

    public String getmIme() {
        return mIme;
    }

    public void setmIme(String mIme) {
        this.mIme = mIme;
    }

    public String getmPrezime() {
        return mPrezime;
    }

    public void setmPrezime(String mPrezime) {
        this.mPrezime = mPrezime;
    }

    public String getmBiografija() {
        return mBiografija;
    }

    public void setmBiografija(String mBiografija) {
        this.mBiografija = mBiografija;
    }

    public float getmOcena() {
        return mOcena;
    }

    public void setmOcena(float mOcena) {
        this.mOcena = mOcena;
    }

    public String getmDatumRodjenja() {
        return mDatumRodjenja;
    }

    public void setmDatumRodjenja(String mDatumRodjenja) {
        this.mDatumRodjenja = mDatumRodjenja;
    }

    public ArrayList<Film> getmFilmovi() {
        return mFilmovi;
    }

    public void setmFilmovi(ArrayList<Film> mFilmovi) {
        this.mFilmovi = mFilmovi;
    }

    @Override
    public String toString() {
        return "Glumac{" +
                "mIme='" + mIme + '\'' +
                ", mPrezime='" + mPrezime + '\'' +
                '}';
    }
}
