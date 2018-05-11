package com.srllimited.srl.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.srllimited.srl.data.TestRecomandData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseRecomondHelper extends SQLiteOpenHelper
{

	// Logcat tag
	private static final String LOG = "DatabaseHelper";

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "TestRecomondationDatabase";

	// Table Names
	private static final String TABLE_BOOKTEST_PACKAGES = "testrecomondpackages";

	// Common column names
	private static final String KEY_ID = "ID";
	private static final String KEY_PRDCT_CODE = "PTNT_CD";
	private static final String KEY_PRICE = "PRICE";
	private static final String KEY_CATEGORY = "CATEGORY";
	private static final String PRDCT = "PRDCT";
	private static final String KEY_IsCART = "IsCart";
	private static final String KEY_CARTPRICE = "CARTPRICE";

	// Table Create Statements
	// Todo table create statement
	private static final String CREATE_TABLE_BOOKTEST_PACKAGES = "CREATE TABLE " + TABLE_BOOKTEST_PACKAGES + "("
			+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_PRDCT_CODE + " TEXT,"+ KEY_PRICE + " TEXT,"  + KEY_CATEGORY + " TEXT," + PRDCT + " TEXT," + KEY_IsCART
			+ " TEXT," + KEY_CARTPRICE + " TEXT," + ")";

	public DatabaseRecomondHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{

		// creating required tables
		db.execSQL(CREATE_TABLE_BOOKTEST_PACKAGES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		//		// on upgrade drop older tables
		//		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_BOOKTEST_PACKAGES);
		//
		//
		//		// create new tables
		//		onCreate(db);
	}

	// ------------------------ "todos" table methods ----------------//

	/*
	 * Creating a todo
	 */
	public long createBookTestOrPackages(TestRecomandData book_pkgs)
	{
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, book_pkgs.getID());
		values.put(KEY_PRDCT_CODE, book_pkgs.getPTNT_CD());
		values.put(PRDCT, book_pkgs.getPRDCT());

		values.put(KEY_PRICE, book_pkgs.getPRICE());
		values.put(KEY_IsCART, book_pkgs.isCart() + "");
		values.put(KEY_CARTPRICE, book_pkgs.getCartPrice());


		return db.insert(TABLE_BOOKTEST_PACKAGES, null, values);
	}
	/*
	 * get single todo
	 */
	public TestRecomandData getBook_Pkg_Object(long todo_id)
	{
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE_BOOKTEST_PACKAGES + " WHERE " + KEY_ID + " = " + todo_id;

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null)
		{
			c.moveToFirst();
		}

		TestRecomandData book_pkgs = new TestRecomandData();

		try
		{
			book_pkgs.setID(c.getString(c.getColumnIndex(KEY_ID)));

			book_pkgs.setPRICE(c.getDouble(c.getColumnIndex(KEY_PRICE)));

			book_pkgs.setCATEGORY(c.getString(c.getColumnIndex(KEY_CATEGORY)));
			book_pkgs.setPTNT_CD(c.getString(c.getColumnIndex(KEY_PRDCT_CODE)));
			book_pkgs.setPRDCT(c.getString(c.getColumnIndex(PRDCT)));
			book_pkgs.setCartPrice(c.getString(c.getColumnIndex(KEY_CARTPRICE)));




		}
		catch (Exception e)
		{

		}

		if (c.getString(c.getColumnIndex(KEY_IsCART)) != null
				&& c.getString(c.getColumnIndex(KEY_IsCART)).equalsIgnoreCase("true"))
		{
			book_pkgs.setCart(true);
		}
		else
		{
			book_pkgs.setCart(false);
		}

		return book_pkgs;
	}

	/**
	 * getting all todos
	 */
	public List<TestRecomandData> getAllBook_pkgs_List()
	{
		List<TestRecomandData> book_pkgs_list = new ArrayList<TestRecomandData>();
		String selectQuery = "SELECT  * FROM " + TABLE_BOOKTEST_PACKAGES;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst())
		{
			do
			{

				TestRecomandData book_pkgs = new TestRecomandData();

				try
				{
					book_pkgs.setID(c.getString(c.getColumnIndex(KEY_ID)));

					book_pkgs.setPRICE(c.getDouble(c.getColumnIndex(KEY_PRICE)));

					book_pkgs.setCATEGORY(c.getString(c.getColumnIndex(KEY_CATEGORY)));
					book_pkgs.setPTNT_CD(c.getString(c.getColumnIndex(KEY_PRDCT_CODE)));
					book_pkgs.setPRDCT(c.getString(c.getColumnIndex(PRDCT)));
					book_pkgs.setCartPrice(c.getString(c.getColumnIndex(KEY_CARTPRICE)));
				}
				catch (Exception e)
				{

				}

				if (c.getString(c.getColumnIndex(KEY_IsCART)) != null
						&& c.getString(c.getColumnIndex(KEY_IsCART)).equalsIgnoreCase("true"))
				{
					book_pkgs.setCart(true);
				}
				else
				{
					book_pkgs.setCart(false);
				}

				///////////////

				book_pkgs_list.add(book_pkgs);
			}
			while (c.moveToNext());
		}

		return book_pkgs_list;
	}

	/*public List<BookTestORPackagesData> getAllBookATests()
	{
		List<BookTestORPackagesData> book_pkgs_list = new ArrayList<BookTestORPackagesData>();
		String selectQuery = "SELECT  * FROM " + TABLE_BOOKTEST_PACKAGES;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst())
		{
			do
			{
				BookTestORPackagesData book_pkgs = new BookTestORPackagesData();
				book_pkgs.setID(c.getInt(c.getColumnIndex(KEY_ID)));
				book_pkgs.setPRDCT_CODE((c.getString(c.getColumnIndex(KEY_PRDCT_CODE))));
				book_pkgs.setPRDCT_ALIASES(c.getString(c.getColumnIndex(KEY_PRDCT_ALIASES)));
				book_pkgs.setGROSS_AMT((c.getString(c.getColumnIndex(KEY_GROSS_AMT))));
				book_pkgs.setPRICE(c.getDouble(c.getColumnIndex(KEY_PRICE)));
				book_pkgs.setDISC((c.getDouble(c.getColumnIndex(KEY_DISC))));
				book_pkgs.setDISC_TYPE(c.getString(c.getColumnIndex(KEY_DISC_TYPE)));
				book_pkgs.setPRDCT_CONSTNS((c.getString(c.getColumnIndex(KEY_PRDCT_CONSTNS))));
				book_pkgs.setCATEGORY(c.getString(c.getColumnIndex(KEY_CATEGORY)));
				book_pkgs.setPTNT_INSTRCTN((c.getString(c.getColumnIndex(KEY_PTNT_INSTRCTN))));
				book_pkgs.setREP_TAT((c.getString(c.getColumnIndex(KEY_REP_TAT))));
				book_pkgs.setINFO(c.getString(c.getColumnIndex(KEY_INFO)));
				book_pkgs.setOFR_CD(c.getString(c.getColumnIndex(KEY_OFR_CD)));
				book_pkgs.setCartPrice(c.getString(c.getColumnIndex(KEY_CARTPRICE)));
				book_pkgs.setBook_pkg(c.getString(c.getColumnIndex(KEY_BOOK_PKG)));
				if (c.getString(c.getColumnIndex(KEY_IsCART)) != null
						&& c.getString(c.getColumnIndex(KEY_IsCART)).equalsIgnoreCase("true"))
				{
					book_pkgs.setCart(true);
				}
				else
				{
					book_pkgs.setCart(false);
				}
				// adding to todo list
				book_pkgs_list.add(book_pkgs);
			}
			while (c.moveToNext());
		}

		return book_pkgs_list;
	}
*/
	/*public List<BookTestORPackagesData> getBookATestsOrPkgs(String selectedCart)
	{
		List<BookTestORPackagesData> book_pkgs_list = new ArrayList<BookTestORPackagesData>();
		String selectQuery = "SELECT  * FROM " + TABLE_BOOKTEST_PACKAGES + " WHERE " + KEY_BOOK_PKG + " = '"
				+ selectedCart + "'";
		;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst())
		{
			do
			{
				BookTestORPackagesData book_pkgs = new BookTestORPackagesData();
				book_pkgs.setID(c.getInt(c.getColumnIndex(KEY_ID)));
				book_pkgs.setPRDCT_CODE((c.getString(c.getColumnIndex(KEY_PRDCT_CODE))));
				book_pkgs.setPRDCT_ALIASES(c.getString(c.getColumnIndex(KEY_PRDCT_ALIASES)));
				book_pkgs.setGROSS_AMT((c.getString(c.getColumnIndex(KEY_GROSS_AMT))));
				book_pkgs.setPRICE(c.getDouble(c.getColumnIndex(KEY_PRICE)));
				book_pkgs.setDISC((c.getDouble(c.getColumnIndex(KEY_DISC))));
				book_pkgs.setDISC_TYPE(c.getString(c.getColumnIndex(KEY_DISC_TYPE)));
				book_pkgs.setPRDCT_CONSTNS((c.getString(c.getColumnIndex(KEY_PRDCT_CONSTNS))));
				book_pkgs.setCATEGORY(c.getString(c.getColumnIndex(KEY_CATEGORY)));
				book_pkgs.setPTNT_INSTRCTN((c.getString(c.getColumnIndex(KEY_PTNT_INSTRCTN))));
				book_pkgs.setREP_TAT((c.getString(c.getColumnIndex(KEY_REP_TAT))));
				book_pkgs.setINFO(c.getString(c.getColumnIndex(KEY_INFO)));
				book_pkgs.setOFR_CD(c.getString(c.getColumnIndex(KEY_OFR_CD)));
				book_pkgs.setCartPrice(c.getString(c.getColumnIndex(KEY_CARTPRICE)));
				book_pkgs.setBook_pkg(c.getString(c.getColumnIndex(KEY_BOOK_PKG)));
				if (c.getString(c.getColumnIndex(KEY_IsCART)) != null
						&& c.getString(c.getColumnIndex(KEY_IsCART)).equalsIgnoreCase("true"))
				{
					book_pkgs.setCart(true);
				}
				else
				{
					book_pkgs.setCart(false);
				}
				// adding to todo list
				book_pkgs_list.add(book_pkgs);
			}
			while (c.moveToNext());
		}

		return book_pkgs_list;
	}*/

	/*
	 * getting todo count
	 */
	public int getToDoCount()
	{
		String countQuery = "SELECT  * FROM " + TABLE_BOOKTEST_PACKAGES;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);

		int count = cursor.getCount();
		cursor.close();

		// return count
		return count;
	}

	/*
	 * Updating a todo
	 */
	public int updateBookOrPkgs(TestRecomandData book_pkgs)
	{
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, book_pkgs.getID());
		values.put(KEY_PRDCT_CODE, book_pkgs.getPTNT_CD());
		values.put(PRDCT, book_pkgs.getPRDCT());
		values.put(KEY_PRICE, book_pkgs.getPRICE());
		values.put(KEY_CATEGORY, book_pkgs.getCATEGORY());

		values.put(KEY_IsCART, book_pkgs.isCart() + "");

		// updating row
		return db.update(TABLE_BOOKTEST_PACKAGES, values, KEY_ID + " = ?",
				new String[] { String.valueOf(book_pkgs.getID()) });
	}

	/*public List<BookTestORPackagesData> getAllPackages()
	{
		List<BookTestORPackagesData> book_pkgs_list = new ArrayList<BookTestORPackagesData>();
		String selectQuery = "SELECT  * FROM " + TABLE_BOOKTEST_PACKAGES;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst())
		{
			do
			{
				BookTestORPackagesData book_pkgs = new BookTestORPackagesData();
				book_pkgs.setID(c.getInt(c.getColumnIndex(KEY_ID)));
				book_pkgs.setPRDCT_CODE((c.getString(c.getColumnIndex(KEY_PRDCT_CODE))));
				book_pkgs.setPRDCT_ALIASES(c.getString(c.getColumnIndex(KEY_PRDCT_ALIASES)));
				book_pkgs.setGROSS_AMT((c.getString(c.getColumnIndex(KEY_GROSS_AMT))));
				book_pkgs.setPRICE(c.getDouble(c.getColumnIndex(KEY_PRICE)));
				book_pkgs.setDISC((c.getDouble(c.getColumnIndex(KEY_DISC))));
				book_pkgs.setDISC_TYPE(c.getString(c.getColumnIndex(KEY_DISC_TYPE)));
				book_pkgs.setPRDCT_CONSTNS((c.getString(c.getColumnIndex(KEY_PRDCT_CONSTNS))));
				book_pkgs.setCATEGORY(c.getString(c.getColumnIndex(KEY_CATEGORY)));
				book_pkgs.setPTNT_INSTRCTN((c.getString(c.getColumnIndex(KEY_PTNT_INSTRCTN))));
				book_pkgs.setREP_TAT((c.getString(c.getColumnIndex(KEY_REP_TAT))));
				book_pkgs.setINFO(c.getString(c.getColumnIndex(KEY_INFO)));
				book_pkgs.setCartPrice(c.getString(c.getColumnIndex(KEY_CARTPRICE)));
				book_pkgs.setBook_pkg(c.getString(c.getColumnIndex(KEY_BOOK_PKG)));
				if (c.getString(c.getColumnIndex(KEY_IsCART)) != null
						&& c.getString(c.getColumnIndex(KEY_IsCART)).equalsIgnoreCase("true"))
				{
					book_pkgs.setCart(true);
				}
				else
				{
					book_pkgs.setCart(false);
				}
				// adding to todo list
				book_pkgs_list.add(book_pkgs);
			}
			while (c.moveToNext());
		}

		return book_pkgs_list;
	}*/

	//	/*
	//	 * Deleting a todo
	//	 */
	//	public void deleteToDo(long tado_id)
	//	{
	//		SQLiteDatabase db = this.getWritableDatabase();
	//		db.delete(CREATE_TABLE_BOOKTEST_PACKAGES, KEY_ID + " = ?",
	//		          new String[]{String.valueOf(tado_id)});
	//	}

	// ------------------------ "tags" table methods ----------------//

	// closing database
	public void closeDB()
	{
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
		{
			db.close();
		}
	}

	/**
	 * get datetime
	 */
	private String getDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void deleteBookATest()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_BOOKTEST_PACKAGES, null, null);
	}

	//	private void search()
	//	{
	//
	//		List<ProductHeaderData> datalist = null;
	//		try
	//		{
	//			datalist = productHeaderDB.getAllHeaderList();
	//		}
	//		catch (Exception e)
	//		{
	//			e.printStackTrace();
	//		}
	//
	//		List<BookTestORPackagesData> datas = new ArrayList<>();
	//
	//		try
	//		{
	//
	//			BookTestORPackagesData bookTestORPackagesData = BookTestORPackagesData.newInit(jObject);
	//
	//			if (bookTestORPackagesData != null)
	//			{
	//
	//				if (datalist != null && !datalist.isEmpty())
	//				{
	//					List<ProductHeaderListItemData> productHeaderListItemDatas = new ArrayList<>();
	//					JSONArray namesArray = jObject.names();
	//					ArrayList<String> lsitToBeAdded = new ArrayList<String>();
	//
	//					if (namesArray != null)
	//					{
	//						for (int j = 0; j < namesArray.length(); j++)
	//						{
	//							lsitToBeAdded.add(namesArray.getString(j));
	//						}
	//					}
	//
	//					if (lsitToBeAdded != null && !lsitToBeAdded.isEmpty())
	//					{
	//						for (ProductHeaderData productHeaderData : datalist)
	//						{
	//
	//							for (String checkHeaders : lsitToBeAdded)
	//							{
	//								if (productHeaderData.getLBL_NAME().equalsIgnoreCase(checkHeaders.toString()))
	//								{
	//
	//									ProductHeaderListItemData productHeaderListItemData = new ProductHeaderListItemData();
	//
	//									String desc = jObject.getString(checkHeaders);
	//
	//									if (productHeaderData.getLBL_HDR() != null && !productHeaderData.getLBL_HDR().isEmpty()
	//											&& desc != null && !desc.isEmpty() && !desc.equalsIgnoreCase("null"))
	//									{
	//										productHeaderListItemData.setHeader(productHeaderData.getLBL_HDR());
	//										productHeaderListItemData.setDesc(desc);
	//
	//										productHeaderListItemDatas.add(productHeaderListItemData);
	//									}
	//								}
	//							}
	//						}
	//
	//						bookTestORPackagesData.setProductHeaderListItemDataList(productHeaderListItemDatas);
	//					}
	//
	//
	//	}

}
