package in.ladvas.uchef;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="uchef.db";
    static final String CAT_TABLE = "categories";
    static final String CAT_ID_COL = "cat_id";
    static final String CAT_NAME_COL = "cat_name";

    static final String ING_TABLE = "ingredients";
    static final String ING_ID_COL = "ing_id";
    static final String ING_NAME_COL = "ing_name";
	static final String ING_CAT_ID_COL = "ing_cat_id"; 

	static final String REC_TABLE = "recipes";
    static final String REC_ID_COL = "rec_id";
    static final String REC_NAME_COL = "rec_name";
	static final String REC_DESC_COL = "rec_desc";
	static final String REC_LINK_COL = "rec_link";
	
	static final String ING_REC_TABLE = "ingredients_recipe";
    static final String ING_REC_ID_COL = "ing_rec_id";
	static final String REC_ING_ID_COL = "rec_ing_id";
	
	
    public DBHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table_cat = "create table " + CAT_TABLE + "("
                + CAT_ID_COL + " integer primary key autoincrement,"
                + CAT_NAME_COL + " text," + CAT_ID_COL + " integer)";

        String create_table_ing = "create table " + ING_TABLE + "("
                + ING_ID_COL + " text primary key,"
                + ING_NAME_COL + " integer," + ING_CAT_ID_COL + " integer," + " foreign key (" + ING_CAT_ID_COL +") references " + CAT_TABLE + "(" + CAT_ID_COL + "))";
        
		String create_table_rec = "create table " + REC_TABLE + "("
                + REC_ID_COL + " integer primary key autoincrement,"
                + REC_NAME_COL + " text," + REC_DESC_COL + " text," + REC_LINK_COL +" real )";
		
		
		String create_table_ing_rec = "create table " + ING_REC_TABLE + "("
                + ING_REC_ID_COL + " integer," + " foreign key ("+ ING_REC_ID_COL +") references " + ING_TABLE + "("+ ING_ID_COL +")) "
                + REC_ING_ID_COL + " integer," + " foreign key ("+ REC_ING_ID_COL +") references " + REC_TABLE + "("+ REC_ID_COL +"))";
		
		
		db.execSQL(create_table_cat);
        db.execSQL(create_table_ing);
		db.execSQL(create_table_rec);	
		db.execSQL(create_table_ing_rec);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +  CAT_TABLE);
        onCreate(db);
    }

    public boolean insert_cat(String vegetables, String fruits, String dairy, String meat, String seafood){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAT_ID_COL, 1);
        values.put(CAT_NAME_COL, vegetables);
        values.put(CAT_ID_COL, 2);
        values.put(CAT_NAME_COL, fruits);
        values.put(CAT_ID_COL, 3);
        values.put(CAT_NAME_COL, dairy);
        values.put(CAT_ID_COL, 4);
        values.put(CAT_NAME_COL, meat);
        values.put(CAT_ID_COL, 5);
        values.put(CAT_NAME_COL, seafood);

        db.insert(CAT_TABLE, null, values);
        return true;
    }

    public boolean insert_recipe(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(REC_ID_COL, 1);
        values.put(REC_NAME_COL,"cheesy potato");
        values.put(REC_DESC_COL, "Add potatoes in the cheese");
        values.put(REC_LINK_COL, "www.a2zfoods.com");

        db.insert(REC_TABLE, null, values);
        return true;
    }

    public Cursor getData(String usr){
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlStr = "select * from " + REC_TABLE + " where "
                + REC_ID_COL + " = " + "1" + usr + "'";
        Cursor cursor = db.rawQuery(sqlStr, null);
        return cursor;
    }

    /*public boolean updateData(String usr, int score){
        SQLiteDatabase db = this.getWritableDatabase();
        if(getPlayer(usr) == null){
            return false;
        }
        ContentValues values = new ContentValues();
        values.put(SCORE_COL, score);
        db.update(TABLE_NAME, values, USERNAME_COL + " = ?", new String[]{usr});
        return true;
    }*/

    public ArrayList<String> getAllPlayerNames()
    {
        //Get all records
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from " + CAT_TABLE, null );
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            array_list.add(cursor.getString(cursor.getColumnIndex(CAT_ID_COL)));
            cursor.moveToNext();
        }
        cursor.close();
        return array_list;
    }
}

