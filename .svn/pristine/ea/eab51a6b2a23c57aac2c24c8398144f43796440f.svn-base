package com.srllimited.srl.data;

import com.srllimited.srl.constants.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuchiTiwari on 12/18/2016.
 */

public class TestRecomandData
{
	private String ID;
	private String PTNT_CD;
	private String PRDCT;
	private String CATEGORY;
	private double PRICE;
	private String CartPrice;

	public String getCartPrice() {
		return CartPrice;
	}

	public void setCartPrice(String cartPrice) {
		CartPrice = cartPrice;
	}

	/*public List<TestRecomandData> getmProductHeaderListItemDataList() {
		return mProductHeaderListItemDataList;
	}

	public void setmProductHeaderListItemDataList(List<TestRecomandData> mProductHeaderListItemDataList) {
		this.mProductHeaderListItemDataList = mProductHeaderListItemDataList;
	}*/

	public String getPTNT_CD() {
		return PTNT_CD;
	}

	public void setPTNT_CD(String PTNT_CD) {
		this.PTNT_CD = PTNT_CD;
	}

	public String getPRDCT() {
		return PRDCT;
	}

	public void setPRDCT(String PRDCT) {
		this.PRDCT = PRDCT;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double PRICE) {
		this.PRICE = PRICE;
	}

	public boolean isCart() {
		return isCart;
	}

	public void setCart(boolean cart) {
		isCart = cart;
	}





	private boolean isCart = false;

	public static List<TestRecomandData> RecommondedList = new ArrayList<TestRecomandData>();

	public static List<TestRecomandData> newInit(final JSONObject jsonObject)
	{


		try
		{
			JSONArray jsonArray = (JSONArray)jsonObject.get("PACKAGE");
			for(int i=0;i<jsonArray.length();i++) {
				JSONObject obj = new JSONObject(jsonArray.get(i).toString());
				TestRecomandData booktest_or_pkgs = new TestRecomandData();
				try {
					booktest_or_pkgs.setID(obj.getString(Constants.booktest_package_id));
				}
				catch (Exception e){

				}
				try {
					booktest_or_pkgs.setPTNT_CD(obj.getString(Constants.ptnt_cd));
				}
				catch (Exception e){

				}
				try {
					booktest_or_pkgs.setPRDCT(obj.getString(Constants.prdct));
				}
				catch (Exception e){

				}	try {
					booktest_or_pkgs.setPRICE(obj.getDouble(Constants.booktest_package_price));
				}
				catch (Exception e){

				}	try {

					booktest_or_pkgs.setCATEGORY(obj.getString(Constants.booktest_package_category));
				}
				catch (Exception e){

				}
if(booktest_or_pkgs.getCATEGORY().equalsIgnoreCase("recommended")){
	RecommondedList.add(booktest_or_pkgs);
}


			}
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		return RecommondedList;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(final String ID)
	{
		this.ID = ID;
	}



	/*public List<ProductHeaderListItemData> getProductHeaderListItemDataList()
	{
		return mProductHeaderListItemDataList;
	}*/

	/*public void setProductHeaderListItemDataList(final List<TestRecomandData> productHeaderListItemDataList)
	{
		mProductHeaderListItemDataList = productHeaderListItemDataList;
	}*/
}
