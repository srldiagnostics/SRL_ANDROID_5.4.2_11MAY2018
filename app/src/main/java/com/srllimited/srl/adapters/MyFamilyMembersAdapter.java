package com.srllimited.srl.adapters;

import java.util.ArrayList;
import java.util.List;

import com.daimajia.swipe.SwipeLayout;
import com.srllimited.srl.AddPatientActivity;
import com.srllimited.srl.MyFamilyActivity;
import com.srllimited.srl.R;
import com.srllimited.srl.constants.Constants;
import com.srllimited.srl.data.ServerResponseData;
import com.srllimited.srl.data.ServerResponseData2;
import com.srllimited.srl.data.UserData;
import com.srllimited.srl.serverapis.ApiRequest;
import com.srllimited.srl.serverapis.ApiRequestHelper;
import com.srllimited.srl.serverapis.ApiRequestManager;
import com.srllimited.srl.serverapis.ApiResponseListener;
import com.srllimited.srl.serverapis.RestApiCallUtil;
import com.srllimited.srl.util.SharedPrefsUtil;
import com.srllimited.srl.util.Util;
import com.srllimited.srl.utilities.AppDataBaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

/**
 * Created by Codefyne on 03/01/2017.
 */

public class MyFamilyMembersAdapter extends RecyclerView.Adapter<MyFamilyMembersAdapter.ViewHolder> {
    // UserData _userAppData;

    private Context mContext;
    boolean userDelete;
    //RestApiCallUtil.dateToEpoch(dob)
    //Data Base
    AppDataBaseHelper appDb = new AppDataBaseHelper(mContext);
    private MyFamilyActivity activity;
    private List<UserData> _userAppData = new ArrayList<>();

    public MyFamilyMembersAdapter(MyFamilyActivity context, List<UserData> myfamilydata) {
        this.mContext = context;
        this.activity = context;
        this._userAppData = myfamilydata;
    }

    @Override
    public MyFamilyMembersAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.family_member_list_item, viewGroup,
                false);
        return new MyFamilyMembersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyFamilyMembersAdapter.ViewHolder viewHolder, final int i) {
        if (viewHolder != null) {
            appDb = new AppDataBaseHelper(activity);
            try {
                if (_userAppData.get(i).getStatus().equalsIgnoreCase("false")) {
                    viewHolder.patientdetailslayout.setVisibility(View.VISIBLE);
                    if (!_userAppData.get(i).getGender().equalsIgnoreCase("null")
                            && !_userAppData.get(i).getGender().isEmpty()) {
                        if (_userAppData.get(i).getGender().equalsIgnoreCase("M")) {
                            viewHolder.genderTVID.setText("Male");
                        } else {
                            viewHolder.genderTVID.setText("Female");
                        }
                    }
                    try {

                        //						long dobValue = Long.valueOf(_userAppData.get(i).getDob());
                        //						Log.e("Date of Birth", _userAppData.get(i).getDob());
                        String dobStr = RestApiCallUtil.epochToDate(_userAppData.get(i).getDob());
                        if (!dobStr.equalsIgnoreCase("null") && dobStr != null && !dobStr.isEmpty()) {
                            viewHolder.dateofbirtTVID.setText(dobStr);
                        } else {
                            viewHolder.dateofbirtTVID.setText("");
                        }
                    } catch (Exception e) {

                    }
                    if (!_userAppData.get(i).getMobile_no().equalsIgnoreCase("null")
                            && !_userAppData.get(i).getMobile_no().isEmpty()
                            && _userAppData.get(i).getMobile_no() != null) {
                        viewHolder.mobileNoTVID.setText(_userAppData.get(i).getMobile_no());
                    } else {
                        viewHolder.mobileNoTVID.setText("");
                    }
                    if (!_userAppData.get(i).getEmail_id().equalsIgnoreCase("null")
                            && !_userAppData.get(i).getEmail_id().isEmpty()
                            && _userAppData.get(i).getEmail_id() != null) {
                        viewHolder.emailIdTVID.setText(_userAppData.get(i).getEmail_id());
                    } else {
                        viewHolder.emailIdTVID.setText("NA");
                    }
                    if (!_userAppData.get(i).getFirst_name().equalsIgnoreCase("null")
                            && !_userAppData.get(i).getFirst_name().isEmpty()
                            && _userAppData.get(i).getFirst_name() != null) {
                        viewHolder.usernameTVID.setText(_userAppData.get(i).getFirst_name());
                    } else {
                        viewHolder.usernameTVID.setText("");
                    }
                    if (!_userAppData.get(i).getPtnt_cd().equalsIgnoreCase("null")
                            && _userAppData.get(i).getPtnt_cd() != null && !_userAppData.get(i).getPtnt_cd().isEmpty()) {
                        viewHolder.userIDTVID.setText(_userAppData.get(i).getPtnt_cd());
                    } else {
                        viewHolder.userIDTVID.setText("");
                    }
                    //_userAppData.get(i).getLast_name() +
                    if (_userAppData.get(i).getGender().equalsIgnoreCase("F")) {
                        //viewHolder.userswitchTVID.setText("Do you Like to Switch to " + "Mrs." + _userAppData.get(i).getFirst_name() + " Account");
                        viewHolder.memberimg2IVID.setBackgroundResource(R.color.emptycolor);
                        viewHolder.memberimg2IVID.setBackgroundResource(R.drawable.family_member_female);
                    } else {
                        //viewHolder.userswitchTVID.setText("Do you Like to Switch to " + "Mr." + _userAppData.get(i).getFirst_name() + " Account");
                        viewHolder.memberimg2IVID.setBackgroundResource(R.color.emptycolor);
                        viewHolder.memberimg2IVID.setBackgroundResource(R.drawable.family_member_male);
                    }

                    //Address Details
                    String addressDetails = "";
                    if (!_userAppData.get(i).getAddress1().equalsIgnoreCase("null")
                            && _userAppData.get(i).getAddress1() != null
                            && !_userAppData.get(i).getAddress1().isEmpty()) {
                        addressDetails = _userAppData.get(i).getAddress1();
                    }
                    if (!_userAppData.get(i).getLandmark().equalsIgnoreCase("null")
                            && _userAppData.get(i).getLandmark() != null
                            && !_userAppData.get(i).getLandmark().isEmpty()) {
                        if (!addressDetails.isEmpty() && addressDetails != null) {
                            addressDetails = addressDetails + " , " + _userAppData.get(i).getLandmark();
                        } else {
                            addressDetails = addressDetails + _userAppData.get(i).getLandmark();
                        }
                    }
                    if (!_userAppData.get(i).getCity().equalsIgnoreCase("null") && _userAppData.get(i).getCity() != null
                            && !_userAppData.get(i).getCity().isEmpty())
                    //addressDetails = addressDetails + " , " + _userAppData.get(i).getCity();
                    {
                        if (!addressDetails.isEmpty() && addressDetails != null) {
                            addressDetails = addressDetails + " , " + _userAppData.get(i).getCity();
                        } else {
                            addressDetails = addressDetails + _userAppData.get(i).getCity();
                        }
                    }
                    if (!_userAppData.get(i).getState().equalsIgnoreCase("null")
                            && _userAppData.get(i).getState() != null && !_userAppData.get(i).getState().isEmpty())
                    //addressDetails = addressDetails + " , " + _userAppData.get(i).getState();
                    {
                        if (!addressDetails.isEmpty() && addressDetails != null) {
                            addressDetails = addressDetails + " , " + _userAppData.get(i).getState();
                        } else {
                            addressDetails = addressDetails + _userAppData.get(i).getState();
                        }
                    }
                    if (!_userAppData.get(i).getZip().equalsIgnoreCase("null") && _userAppData.get(i).getZip() != null
                            && !_userAppData.get(i).getZip().isEmpty())
                    //addressDetails = addressDetails + " , " + _userAppData.get(i).getZip();
                    {
                        if (!addressDetails.isEmpty() && addressDetails != null) {
                            addressDetails = addressDetails + " , " + _userAppData.get(i).getZip();
                        } else {
                            addressDetails = addressDetails + _userAppData.get(i).getZip();
                        }
                    }

                    if (addressDetails != null && !addressDetails.isEmpty()) {
                        viewHolder.addressLabel.setVisibility(View.VISIBLE);
                        viewHolder.completeAddress.setText(addressDetails + "");
                    } else {
                        viewHolder.addressLabel.setVisibility(View.GONE);
                        viewHolder.completeAddress.setVisibility(View.GONE);
                    }

                } else {
                    viewHolder.patientdetailslayout.setVisibility(View.GONE);
                }

                viewHolder.patientdetailslayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("delte click");
                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
            }
            /*viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					System.out.print("Delete click");
				}
			});*/
            viewHolder.btnEdit.setOnClickListener(onEditListener(i, viewHolder));
            viewHolder.btnDelete.setOnClickListener(onDeleteListener(i, viewHolder));
            viewHolder.userdetailsframe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    viewHolder.expanded_layout.setVisibility(View.VISIBLE);
                    viewHolder.expanded_frameLayout.setVisibility(View.VISIBLE);
                }
            });

            viewHolder.bottom_wrapper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    if (Constants.isFamilySel) {
                        SharedPrefsUtil.setStringPreference(mContext, "selectedPerson",
                                _userAppData.get(i).getPtnt_cd() + "");

                        SharedPrefsUtil.setStringPreference(mContext, "selectedName",
                                _userAppData.get(i).getFirst_name() + " " + _userAppData.get(i).getLast_name() + "");

                        Intent intent = new Intent();
                        intent.putExtra("reset", "reset");
                        ((Activity) mContext).setResult(AddPatientActivity.RESULT_CODE_FMAILY, intent);
                        ((Activity) mContext).finish();
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (_userAppData.size() > 0) {
            return _userAppData.size();
        } else {
            return _userAppData.size();
        }

    }

    private View.OnClickListener onEditListener(final int position, final ViewHolder holder) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog(position, holder);
            }
        };
    }

    private View.OnClickListener onDeleteListener(final int position, final ViewHolder holder) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /////////////
                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext,
                        AlertDialog.THEME_HOLO_LIGHT);
                //builder.setTitle("Do you want to Delete USER");
                builder.setMessage("Are you sure you want to delete the family member?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        userDelete = appDb.deleteUser(_userAppData.get(position).getPtnt_cd());
                        List<UserData> arrayFamily = appDb.getUSersList();
                        String familymembers = "";
                        final String userid = Util.getStoredUsername(mContext);
                        UserData primaryuserdata = appDb.getSelectedUserDetail(userid);
                        for (int i = 0; i < arrayFamily.size(); i++) {
                            //if (!jArray.getJSONObject(i).getString(Constants.ptntCd1).equalsIgnoreCase(OTPLogin_PatientDetailAdapter.patientDetailsDataobj.getPTNT_CD())) {
                            if (!arrayFamily.get(i).getPtnt_cd().equalsIgnoreCase(userid)) {
                                familymembers = familymembers + arrayFamily.get(i).getPtnt_cd() + ",";
                            }


                        }
                        if (!familymembers.equalsIgnoreCase("")) {
                            familymembers = familymembers.substring(0, familymembers.length() - 1);
                        }

                        sendRequest(ApiRequestHelper.Family_Member_Mapping(mContext, userid,
                                familymembers, "Android", Constants.devicetobepassed, primaryuserdata.getMobile_no()));// Add family membar on server
                        if (userDelete) {

                            _userAppData.remove(position);
                            holder.swipeLayout.close();
                            activity.updateAdapter();
                        }
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                //////////////////

            }

        };
    }

    private ApiResponseListener<ServerResponseData> mResponseListener = new ApiResponseListener<ServerResponseData>() {
        @Override
        public void onResponse(final ApiRequest request, final ServerResponseData serverResponseData) {
            switch (request.getReferralCode()) {


                case Family_Member_Mapping: {
                    if (serverResponseData.getMsg().equalsIgnoreCase("Query Successful")) {
                        Toast.makeText(mContext, "Family Members Successfully Deleted.. ", Toast.LENGTH_LONG)
                                .show();
                    }
                }
                break;
            }
        }

        @Override
        public void onResponseError(final ApiRequest request, final Exception error) {

        }
    };

    public void sendRequest(ApiRequest request) {
        ApiRequestManager.getInstance().sendRequest(mContext, request, mResponseListener);
    }

    private void showEditDialog(final int position, final ViewHolder holder) {
        holder.swipeLayout.close();
        //mContext.updateAdapter();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public FrameLayout userdetailsframe; // Arrow click first time Visible
        public LinearLayout expanded_layout;
        RelativeLayout bottom_wrapper;
        private TextView usernameTVID, userIDTVID; // visible Button
        private TextView genderTVID, dateofbirtTVID, mobileNoTVID, emailIdTVID; //in Visible TextViews
        private TextView userswitchTVID;
        private TextView addressLabel, completeAddress, landmark, city, state, pincode;
        private FrameLayout expanded_frameLayout; // Arrow Close Icon invisible
        private ImageView memberimg2IVID;
        private LinearLayout patientdetailslayout;
        private ImageView btnDelete;
        private ImageView btnEdit;
        private SwipeLayout swipeLayout;

        public ViewHolder(View view) {
            super(view);
            try {
                patientdetailslayout = (LinearLayout) view.findViewById(R.id.patientdetailslayout);
                //Visible Data
                memberimg2IVID = (ImageView) view.findViewById(R.id.memberimg2IVID);
                genderTVID = (TextView) view.findViewById(R.id.genderTVID);
                dateofbirtTVID = (TextView) view.findViewById(R.id.dateofbirtTVID);
                emailIdTVID = (TextView) view.findViewById(R.id.emailIdTVID);
                usernameTVID = (TextView) view.findViewById(R.id.usernameTVID);
                mobileNoTVID = (TextView) view.findViewById(R.id.mobileNoTVID);

                //
                addressLabel = (TextView) view.findViewById(R.id.addressLabel);
                completeAddress = (TextView) view.findViewById(R.id.completeAddress);
                landmark = (TextView) view.findViewById(R.id.landmark);
                city = (TextView) view.findViewById(R.id.city);
                state = (TextView) view.findViewById(R.id.state);
                pincode = (TextView) view.findViewById(R.id.pincode);

                userswitchTVID = (TextView) view.findViewById(R.id.userswitchTVID);

                userIDTVID = (TextView) view.findViewById(R.id.userIDTVID);

                userdetailsframe = (FrameLayout) view.findViewById(R.id.userdetailsframe);

                expanded_layout = (LinearLayout) view.findViewById(R.id.expanded_layout_familyView);

                bottom_wrapper = (RelativeLayout) view.findViewById(R.id.bottom_wrapper);
                expanded_frameLayout = (FrameLayout) view.findViewById(R.id.expanded_frameLayout);

                //showdetails_layout.setOnClickListener(this);
                expanded_frameLayout.setOnClickListener(this);

                swipeLayout = (SwipeLayout) view.findViewById(R.id.swipe_layout);
                btnDelete = (ImageView) view.findViewById(R.id.delete);
                btnEdit = (ImageView) view.findViewById(R.id.edit_query);
            } catch (Exception e) {

            }
            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.expanded_frameLayout:
                    expanded_layout.setVisibility(View.GONE);
                    expanded_frameLayout.setVisibility(View.GONE);
                    break;
            }
        }
    }

}