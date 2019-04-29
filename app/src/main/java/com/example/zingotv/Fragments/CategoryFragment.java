package com.example.zingotv.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

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
import com.example.zingotv.Adapters.CategoryAdapter;
import com.example.zingotv.DataBase.authItemDatabase;
import com.example.zingotv.Interfaces.ListsDAO;
import com.example.zingotv.MainActivity;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;
import com.example.zingotv.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private com.example.zingotv.ViewModel.authItemViewmodel authItemViewmodel;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private JSONData data;
    private List<Lists> lists;
    CategoryAdapter adapter;
    private com.example.zingotv.Interfaces.authItemDAO authItemDAO;
    private ListsDAO listsDAO;
    authItemDatabase database ;
    RecyclerView recyclerView;
    TextView livetv;
    TextView videos;
    TextView library;
    TextView all;
    TextView premium;
    TextView international;
    TextView crowd_tv;
    TextView sports;
    TextView favourites;
    MainActivity context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
        View v= inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = v.findViewById(R.id.recycler_view);

        database = Room.databaseBuilder(getActivity(), authItemDatabase.class, "post_database").allowMainThreadQueries().build();
        authItemDAO = database.authItemDAO();
        data = authItemDAO.getDataDb();
        database = Room.databaseBuilder(getActivity(), authItemDatabase.class, "post_database").allowMainThreadQueries().build();
        listsDAO = database.listsDAO();
        Log.i("cat", "onCreateView: "+listsDAO.LISTS().size());
        recyclerView.setHasFixedSize(true);
        adapter = new CategoryAdapter(getActivity(), data);
         Log.i("fragment", "onCreateView: "+data.getResponse().getItems().getLists().get(0).getTitle());
        /*mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(
                1, //number of grid columns
                GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredGridLayoutManager);*/
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(adapter);
        return v;
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
