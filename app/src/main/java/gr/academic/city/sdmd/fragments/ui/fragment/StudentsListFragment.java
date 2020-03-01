package gr.academic.city.sdmd.fragments.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import gr.academic.city.sdmd.fragments.R;
import gr.academic.city.sdmd.fragments.data.Student;
import gr.academic.city.sdmd.fragments.ui.activity.MainActivity;


public class StudentsListFragment extends Fragment {

    public interface OnFragmentInteractionListener {
        void onStudentSelected(int studentLocationInList);
    }

    public static StudentsListFragment newInstance() {
        return new StudentsListFragment();
    }

    private OnFragmentInteractionListener mListener;

    public StudentsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_students_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListAdapter adapter = new ArrayAdapter<Student>(getContext(), android.R.layout.simple_list_item_1, MainActivity.STUDENTS);

        ListView listView = (ListView) getActivity().findViewById(R.id.lv_students);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onStudentSelected(position);
            }
        });
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
}
