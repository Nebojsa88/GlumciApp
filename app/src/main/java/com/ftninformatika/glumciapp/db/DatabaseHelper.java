package com.ftninformatika.glumciapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ftninformatika.glumciapp.db.model.Film;
import com.ftninformatika.glumciapp.db.model.Glumac;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME    = "ormlite.db";

    private static final int    DATABASE_VERSION = 1;

    private Dao<Glumac, Integer> glumacDao = null;
    private Dao<Film, Integer> filmDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Glumac.class);
            TableUtils.createTable(connectionSource, Film.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, Glumac.class, true);
            TableUtils.dropTable(connectionSource, Film.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Dao<Glumac, Integer> getGlumacDao() throws SQLException {
        if (glumacDao== null) {
            glumacDao = getDao(Glumac.class);
        }

        return glumacDao;
    }

    public Dao<Film, Integer> getFilmDao() throws SQLException {
        if (filmDao== null) {
            filmDao = getDao(Film.class);
        }

        return filmDao;
    }
    @Override
    public void close() {
        glumacDao = null;
        filmDao = null;
        super.close();
    }
}
