package sg.edu.np.examrevision2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String TABLE_NAME = "TABLE_NOTES";
    public static final String COLUMN_ID = "NoteID";
    public static final String COLUMN_NOTE = "NoteText";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOTE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNote(String note)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NOTE, note);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public ArrayList<String> getAllNotes()
    {
        ArrayList<String> notes = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while(c.moveToNext())
        {
            notes.add(c.getString(1));
        }
        c.close();
        db.close();
        return notes;
    }
}
