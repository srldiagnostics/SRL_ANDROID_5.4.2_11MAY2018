package com.srllimited.srl.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.srllimited.srl.R;
import com.srllimited.srl.data.PatientDetailsData;
import com.srllimited.srl.data.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lakhan.Yadav on 4/23/2018.
 */

public class FamilymemberListAdapter extends RecyclerView.Adapter<FamilymemberListAdapter.ViewHolder>{
    private Context mContext;

    private List<UserData> mPatientDetailsDatas = new ArrayList<>();
    public static UserData patientDetailsDataobj;
    View oldselectedview;
    private String lastname = "";
    public static boolean selectionflag=false;
    public FamilymemberListAdapter(Context context, List<UserData> patientDetailsDatases)
    {
        this.mContext = context;
        this.mPatientDetailsDatas = patientDetailsDatases;
    }


    /*public FamilymemberListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patient_detail_child, viewGroup,
                false);
        return new FamilymemberListAdapter.ViewHolder(view);
    }*/
    @Override
public FamilymemberListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patient_detail_child, viewGroup,
            false);
    return new FamilymemberListAdapter.ViewHolder(view);
}
    @Override
    public void onBindViewHolder(final FamilymemberListAdapter.ViewHolder viewHolder, final int i)
    {

        if (viewHolder != null)
        {
            if (mPatientDetailsDatas.get(i) != null)

            {
                if (mPatientDetailsDatas.get(i).getParent_id() != null
                        && !mPatientDetailsDatas.get(i).getParent_id().equalsIgnoreCase("null"))
                {
                    viewHolder.txtptntcd.setText(mPatientDetailsDatas.get(i).getParent_id());
                }

                if (mPatientDetailsDatas.get(i).getFirst_name() != null
                        && !mPatientDetailsDatas.get(i).getFirst_name().equalsIgnoreCase("null"))
                {
                    if (mPatientDetailsDatas.get(i).getLast_name().toString().trim().equalsIgnoreCase("null"))
                    {
                        lastname = "";
                    }
                    else
                    {
                        lastname = mPatientDetailsDatas.get(i).getLast_name().toString().trim();
                    }
                    viewHolder.txtpatientName
                            .setText(mPatientDetailsDatas.get(i).getFirst_name().toString().trim() + " " + lastname);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            patientDetailsDataobj=new UserData();
                            patientDetailsDataobj=mPatientDetailsDatas.get(i);
                            //if(!selectionflag) {


                            viewHolder.itemView.setBackgroundColor(Color.parseColor("#E4E4E4"));

                            if(oldselectedview!=null)
                            {
                                oldselectedview.setBackgroundColor(Color.WHITE);
                            }
                            oldselectedview=viewHolder.itemView;
                            selectionflag=true;
							/*}
							else
							{
                                oldselectedview.setBackgroundColor(Color.WHITE);
								selectionflag=false;

							}*/
                        }
                    });
                }
            }

			/*viewHolder.graphrel.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					Util.killTrendsChart();
					Intent intent = new Intent(mContext, TrendsChartActivity.class);
					//Intent intent = new Intent(mContext, TestActivity.class);
					ReportsData reportsData = null;
					if (mAccessionListDatas.get(i).getReportsDatas() != null && mAccessionListDatas.get(i).getReportsDatas().size() > 0)
					{
						reportsData = mAccessionListDatas.get(i).getReportsDatas().get(0);
					}
					if (reportsData != null && reportsData.getCPT_CODE() != null && !reportsData.getCPT_CODE().equalsIgnoreCase("null"))
					{
						intent.putExtra("obj1", reportsData);
						mContext.startActivity(intent);
					}

				}
			});*/

        }

    }

    @Override
    public int getItemCount()
    {
        if (mPatientDetailsDatas.size() > 0)
        {
            return mPatientDetailsDatas.size();
        }
        else
        {
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtptntcd, txtpatientName;

        private LinearLayout graphrel;

        public ViewHolder(View view)
        {
            super(view);
            graphrel = (LinearLayout) view.findViewById(R.id.graphrel);
            txtptntcd = (TextView) view.findViewById(R.id.txtptntcd);
            txtpatientName = (TextView) view.findViewById(R.id.txtpatientName);
        }

    }

}
