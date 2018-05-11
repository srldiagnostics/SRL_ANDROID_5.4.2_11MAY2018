package com.srllimited;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.srllimited.srl.R;
import com.srllimited.srl.adapters.TestRecommondationAdapter;
import com.srllimited.srl.data.ServerResponseData;
import com.srllimited.srl.data.TestRecomandData;
import com.srllimited.srl.data.UserData;
import com.srllimited.srl.serverapis.ApiRequest;
import com.srllimited.srl.serverapis.ApiRequestHelper;
import com.srllimited.srl.serverapis.ApiRequestManager;
import com.srllimited.srl.serverapis.ApiResponseListener;
import com.srllimited.srl.util.Util;
import com.srllimited.srl.utilities.AppDataBaseHelper;
import com.srllimited.srl.widget.UISearchBar;

import java.util.ArrayList;
import java.util.List;

public class SRLRecommondationActivity extends AppCompatActivity  implements View.OnClickListener, TestRecommondationAdapter.NotifyActivity{
    public static Activity srlrecommondation;

    Context context;
    RecyclerView.Adapter mAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    View dragView;
    private RecyclerView mRecyclerView;
    List<TestRecomandData> mBookATestActivities = new ArrayList<>();
    AppDataBaseHelper appDb = new AppDataBaseHelper(this);
   /* public static final int RESULT_CODE_FILTERED_PRODUCT = 10;
    public static final int RESULT_CODE_RESET = 12;
    private static final int RESULT_CODE_SEARCH_LOCATION = 9;
    public static Activity bookatest;
    private static ArrayList<BookTestORPackagesData> mBookaTestFilteredData = new ArrayList<>();
    private final Handler mHandler = new Handler();
    ServerResponseData serverResponseData;
    DatabaseHelper db;
    ProductHeaderDatabase productHeaderDB;
    Context context;
    TextView mSelected_menu_name, count_packages;
    ImageView mHeader_loc_dropdown, mFilter_img_view;
    RecyclerView mTest_receyclerview;
    float dX;
    ImageView offers;
    String listname = "";
    float dY;
    String existingCity = "";
    TextView cart_count;
    int lastAction;

    TextView ordernow;
    LinearLayout book_test_offer_layout;
    List<BookTestORPackagesData> mBookATestActivities = new ArrayList<>();
    FrameLayout progress_frame_layout;
    TextView cartpricetext, mostpopular;
    TextView progress_count_text, progress_text;
    boolean isProgress = false;
    LinearLayout sortprice, sortestname;
    ImageView testsorticon, pricesorticon, testsorttopicon, pricesorttopicon;
    ImageView iv_magnify;
    List<BookTestORPackagesData> tempBookATestActivities = new ArrayList<>();
    List<BookTestORPackagesData> temp = new ArrayList<>();
    BookTestORPackagesData tempBookTestORPackagesData;
    String citys = "";
    //	private EditText mFilterEditText;
    String state = "";
    String cityid = "";
    EditText editText;
    String loggedin_username = "";
    ImageView btnClear;
    String selType = "";
    String city = "";
    int cart_numbers = 0;
    ImageView close_popup;
    TextView phnno, callnow, cancel;
    private FirebaseAnalytics firebaseAnalytics;
    private String bookATest = "B";
    private String pkg = "P";
    private Dialog alertDialog = null;
    //	private ImageView btnClear;*/
    private UISearchBar mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srlrecommondation);
        context = SRLRecommondationActivity.this;
        srlrecommondation = this;
        dragView = findViewById(R.id.draggable_view);
        dragView.setVisibility(View.VISIBLE);

        mBookATestActivities.clear();
        mRecyclerView = (RecyclerView) findViewById(R.id.test_receyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new TestRecommondationAdapter(context, mBookATestActivities, false);
        mRecyclerView.setAdapter(mAdapter);

        dragView.setOnTouchListener(new OnDragTouchListener1(dragView, new OnDragTouchListener1.OnDragActionListener1() {
            @Override
            public void onDragStart(View view) {

            }

            @Override
            public void onDragEnd(View view) {

            }

            @Override
            public void onSingleTap(View view) {

            }
        }));
        UserData _userAppData1 = appDb.getSelectedUserDetail(Util.getStoredUsername(context));
        sendRequest(ApiRequestHelper.getSRLRecommendationPackageDetails(context, Util.getStoredUsername(context),  _userAppData1.getMobile_no()+""));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                Log.d("fcdf","refresh");
                // Refresh items
               // refreshItems();
            }
        });



    }
    private void sendRequest(ApiRequest request)
    {
        ApiRequestManager.getInstance().sendRequest(this, request, mResponseListener);
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public void onChangingListItem(List<TestRecomandData> bookTestORPackagesDatas) {


    }



    //*********************************************************************
    private ApiResponseListener<ServerResponseData> mResponseListener = new ApiResponseListener<ServerResponseData>() {
        @Override
        public void onResponse(final ApiRequest request, final ServerResponseData mserverResponseData) {

            if (mserverResponseData != null) {
                switch (request.getReferralCode()) {
                    case GET_PackageRecommendation:
                    try {
                        mBookATestActivities =  TestRecomandData.newInit(mserverResponseData.getObjectData());
                   if(mBookATestActivities !=null){
                       mAdapter = new TestRecommondationAdapter(context, mBookATestActivities, false);
                       mRecyclerView.setAdapter(mAdapter);
                      // mAdapter.notifyDataSetChanged();
                   }
                    }
                    catch (Exception e){

                    }
                    /*{"code":100,"msg":"Query Successful","data":{"PACKAGE":[{"PTNT_CD":"TRUPF17029327","PRDCT":"CMP70,TPC,4866H","CATEGORY":"advanced","PRICE":"0"},{"PTNT_CD":"TRUPF17029327","PRDCT":"CMP70,TPC,4866H","CATEGORY":"advanced","PRICE":"0"},{"PTNT_CD":"TRUPF17029327","PRDCT":"CMP70,TPC,4866H","CATEGORY":"advanced","PRICE":"0"},{"PTNT_CD":"TRUPF17029327","PRDCT":"CMP79,3180,4866H","CATEGORY":"recommended","PRICE":"0"}]}}*/
                }


            }
        }
      /*  private void setData()
        {
            mBookATestActivities.clear();
            if (mBookATestActivities != null)
            {
                for (BookTestORPackagesData bookatestdata : mBookaTestFilteredData)
                {
                    mBookATestActivities.add(bookatestdata);
                }
            }
            Log.e("setData", mBookATestActivities + "");
            mAdapter.notifyDataSetChanged();
        }*/

        @Override
        public void onResponseError(final ApiRequest request, final Exception error) {

        }
    };

    public static class OnDragTouchListener1 implements View.OnTouchListener
    {
        private GestureDetector gestureDetector;
        private View mView;
        private View mParent;
        private boolean isDragging;
        private boolean isInitialized = false;
        private int width;
        private float xWhenAttached;
        private float maxLeft;
        private float maxRight;
        private float dX;
        private int height;
        private float yWhenAttached;
        private float maxTop;
        private float maxBottom;
        private float dY;
        private OnDragActionListener1 mOnDragActionListener;

        public OnDragTouchListener1(View view)
        {
            this(view, (View) view.getParent(), null);
        }

        public OnDragTouchListener1(View view, View parent)
        {
            this(view, parent, null);
        }

        public OnDragTouchListener1(View view, OnDragActionListener1 onDragActionListener)
        {
            this(view, (View) view.getParent(), onDragActionListener);
        }

        public OnDragTouchListener1(View view, View parent, OnDragActionListener1 onDragActionListener)
        {
            initListener(view, parent);
            setOnDragActionListener(onDragActionListener);
        }

        public void setOnDragActionListener(OnDragActionListener1 onDragActionListener)
        {
            mOnDragActionListener = onDragActionListener;
        }

        public void initListener(View view, View parent)
        {
            View v = parent.getRootView();

            gestureDetector = new GestureDetector(v.getContext(),new SingleTapConfirm());

            mView = view;
            mParent = parent;
            isDragging = false;
            isInitialized = false;

        }

        public void updateBounds()
        {
            updateViewBounds();
            updateParentBounds();
            isInitialized = true;
        }

        public void updateViewBounds()
        {
            width = mView.getWidth();
            xWhenAttached = mView.getX();
            dX = 0;

            height = mView.getHeight();
            yWhenAttached = mView.getY();
            dY = 0;
        }

        public void updateParentBounds()
        {
            maxLeft = 0;
            maxRight = maxLeft + mParent.getWidth();

            maxTop = 0;
            maxBottom = maxTop + mParent.getHeight();
        }

        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            if (gestureDetector.onTouchEvent(event))
            {
                // single tap
                if (mOnDragActionListener != null)
                {
                    mOnDragActionListener.onSingleTap(mView);
                }
                return true;
            }
            else
            {
                if (isDragging)
                {
                    float[] bounds = new float[4];
                    // LEFT
                    bounds[0] = event.getRawX() + dX;
                    if (bounds[0] < maxLeft)
                    {
                        bounds[0] = maxLeft;
                    }
                    // RIGHT
                    bounds[2] = bounds[0] + width;
                    if (bounds[2] > maxRight)
                    {
                        bounds[2] = maxRight;
                        bounds[0] = bounds[2] - width;
                    }
                    // TOP
                    bounds[1] = event.getRawY() + dY;
                    if (bounds[1] < maxTop)
                    {
                        bounds[1] = maxTop;
                    }
                    // BOTTOM
                    bounds[3] = bounds[1] + height;
                    if (bounds[3] > maxBottom)
                    {
                        bounds[3] = maxBottom;
                        bounds[1] = bounds[3] - height;
                    }

                    switch (event.getAction())
                    {
                        case MotionEvent.ACTION_CANCEL:
                        case MotionEvent.ACTION_UP:
                            onDragFinish();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            mView.animate().x(bounds[0]).setDuration(0).start();
                            mView.animate().y(bounds[1]).setDuration(0).start();
                            break;
                    }
                    return true;
                }
                else
                {
                    switch (event.getAction())
                    {
                        case MotionEvent.ACTION_DOWN:
                            isDragging = true;
                            if (!isInitialized)
                            {
                                updateBounds();
                            }
                            dX = v.getX() - event.getRawX();
                            dY = v.getY() - event.getRawY();
                            if (mOnDragActionListener != null)
                            {
                                mOnDragActionListener.onDragStart(mView);
                            }
                            return true;
                    }
                }
            }
            return false;
        }

        private void onDragFinish()
        {
            if (mOnDragActionListener != null)
            {
                mOnDragActionListener.onDragEnd(mView);
            }

            dX = 0;
            dY = 0;
            isDragging = false;
        }

        public interface OnDragActionListener1
        {
            void onDragStart(View view);

            void onDragEnd(View view);

            void onSingleTap(View view);
        }

        private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener
        {
            @Override
            public boolean onSingleTapUp(MotionEvent event)
            {
                return true;
            }
        }
    }
}
