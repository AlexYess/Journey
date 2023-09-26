package com.example.journey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JourneyDatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "journey_manager";
    private static final String TABLE_JOURNEY = "journeys";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_COST = "cost";
    private static final String KEY_TIME = "time";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE_RESOURCE_ID = "image_resource_id";
    private static final String KEY_TAGS = "tags";

    public JourneyDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_JOURNEY + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_COST + " INTEGER,"
                + KEY_TIME + " TEXT,"
                + KEY_LOCATION + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_IMAGE_RESOURCE_ID + " INTEGER,"
                + KEY_TAGS + " TEXT"
                + ")";
        db.execSQL(createTableQuery);

        insertSampleJourneys(db);
    }

    private void insertSampleJourneys(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        // Journey 1
        values.put(KEY_NAME, "Из гор к морю");
        values.put(KEY_COST, 28500);
        values.put(KEY_TIME, "5 дней");
        values.put(KEY_LOCATION, "Россия, Кавказ");
        values.put(KEY_DESCRIPTION, "Описание");
        values.put(KEY_IMAGE_RESOURCE_ID, R.drawable.from_mountains_to_sea);
        values.put(KEY_TAGS, "природа, горы, море, активный отдых, путешествия");
        db.insert(TABLE_JOURNEY, null, values);

        // Journey 2
        values.clear();
        values.put(KEY_NAME, "Расслабляющие Мальдивы");
        values.put(KEY_COST, 150000);
        values.put(KEY_TIME, "7 дней");
        values.put(KEY_LOCATION, "Мальдивы, Мале");
        values.put(KEY_DESCRIPTION, "Описание");
        values.put(KEY_IMAGE_RESOURCE_ID, R.drawable.maldives);
        values.put(KEY_TAGS, "пляж, отдых, экзотика, океан, релакс");
        db.insert(TABLE_JOURNEY, null, values);

        // Journey 3
        values.put(KEY_NAME, "Друзья и Питер");
        values.put(KEY_COST, 20000);
        values.put(KEY_TIME, "8 дней");
        values.put(KEY_LOCATION, "Россия, Санкт-Петербург");
        values.put(KEY_DESCRIPTION, "Description 3");
        values.put(KEY_IMAGE_RESOURCE_ID, R.drawable.friends_and_piter);
        values.put(KEY_TAGS, "город, культура, история, объекты, путешествия");
        db.insert(TABLE_JOURNEY, null, values);

        // Journey 4
        values.put(KEY_NAME, "Горная тропа");
        values.put(KEY_COST, 32000);
        values.put(KEY_TIME, "8 дней");
        values.put(KEY_LOCATION, "Россия, Кавказ");
        values.put(KEY_DESCRIPTION, "Description 4");
        values.put(KEY_IMAGE_RESOURCE_ID, R.drawable.mountain_way);
        values.put(KEY_TAGS, "природа, горы, поход, активный отдых, путешествия");
        db.insert(TABLE_JOURNEY, null, values);

        // Journey 5
        values.put(KEY_NAME, "Культурная столица");
        values.put(KEY_COST, 55000);
        values.put(KEY_TIME, "7 дней");
        values.put(KEY_LOCATION, "Россия, Санкт-Петербург");
        values.put(KEY_DESCRIPTION, "Description 5");
        values.put(KEY_IMAGE_RESOURCE_ID, R.drawable.cultural_piter);
        values.put(KEY_TAGS, "город, культура, искусство, объекты, путешествия");
        db.insert(TABLE_JOURNEY, null, values);

        // Journey 6
        values.put(KEY_NAME, "Теплые Гаити");
        values.put(KEY_COST, 250000);
        values.put(KEY_TIME, "14 дней");
        values.put(KEY_LOCATION, "Гаити, порт Лабади");
        values.put(KEY_DESCRIPTION, "Description 6");
        values.put(KEY_IMAGE_RESOURCE_ID, R.drawable.haiti);
        values.put(KEY_TAGS, "пляж, отдых, экзотика, карибы, путешествия");
        db.insert(TABLE_JOURNEY, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Удаление старой версии таблицы при обновлении базы данных
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOURNEY);
        onCreate(db);
    }

    public List<Journey> getAllJourneys() {
        List<Journey> journeyList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_JOURNEY;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                int cost = cursor.getInt(cursor.getColumnIndex(KEY_COST));
                String time = cursor.getString(cursor.getColumnIndex(KEY_TIME));
                String location = cursor.getString(cursor.getColumnIndex(KEY_LOCATION));
                String description = cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION));
                int imageResourceId = cursor.getInt(cursor.getColumnIndex(KEY_IMAGE_RESOURCE_ID));
                List<String> tags = Arrays.asList(cursor.getString(cursor.getColumnIndex(KEY_TAGS)).split(","));
                Journey journey = new Journey(id, name, cost, time, location, description, imageResourceId, tags);
                journeyList.add(journey);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return journeyList;
    }
}
