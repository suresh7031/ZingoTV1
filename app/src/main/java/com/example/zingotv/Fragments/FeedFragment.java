package com.example.zingotv.Fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zingotv.Adapters.Adapter;
import com.example.zingotv.DataBase.authItemDatabase;
import com.example.zingotv.Interfaces.ListsDAO;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;
import com.example.zingotv.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FeedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private com.example.zingotv.ViewModel.authItemViewmodel authItemViewmodel;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private JSONData data;
    private List<Lists> lists;
    Adapter adapter;
    private com.example.zingotv.Interfaces.authItemDAO authItemDAO;
    private ListsDAO listsDAO;
    authItemDatabase database;
    RecyclerView recyclerView;
    TextView livetv;
    TextView videos;
    TextView library;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FeedFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedFragment newInstance(String param1, String param2) {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feed, container, false);
        recyclerView = v.findViewById(R.id.recycler_view);
        livetv = v.findViewById(R.id.menu_live_tv);
        videos = v.findViewById(R.id.menu_videos);
        library = v.findViewById(R.id.menu_library);
        Log.i("tag1", "onCreateView: ");

        database = Room.databaseBuilder(getActivity(), authItemDatabase.class, "post_database").allowMainThreadQueries().build();
        authItemDAO = database.authItemDAO();
        data = authItemDAO.getDataDb();
        database = Room.databaseBuilder(getActivity(), authItemDatabase.class, "post_database").allowMainThreadQueries().build();
        listsDAO = database.listsDAO();

        Log.i("Lists", "onCreateView: " + listsDAO.LISTS().get(0).getTitle());

        livetv.setText(data.getResponse().getMenuItems().get(0).getName());
        videos.setText(data.getResponse().getMenuItems().get(1).getName());
        library.setText(data.getResponse().getMenuItems().get(2).getName());
        /* Log.i("fragment", "onCreateView: "+data.size());*/
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(getActivity(), data);
        /*mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(
                1, //number of grid columns
                GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredGridLayoutManager);*/
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mStaggeredGridLayoutManager.setSpanCount(1);

        } else {
            //show in two columns
            mStaggeredGridLayoutManager.setSpanCount(2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


       /* authItemViewmodel = ViewModelProviders.of(this).get(authItemViewmodel.class);

        authItemViewmodel.getData().observe(this, new Observer<List<JSONData>>() {
            @Override
            public void onChanged(List<JSONData> jsonData) {
                adapter.submitList(jsonData);
            }
        });*/


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
