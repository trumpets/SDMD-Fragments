package gr.academic.city.sdmd.fragments.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gr.academic.city.sdmd.fragments.R;
import gr.academic.city.sdmd.fragments.data.Student;
import gr.academic.city.sdmd.fragments.ui.activity.MainActivity;


public class StudentDetailsFragment extends Fragment {

    private static final String ARG_STUDENT_POSITION_IN_LIST = "student_position_in_list";

    public static StudentDetailsFragment newInstance(int studentPositionInList) {
        StudentDetailsFragment fragment = new StudentDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STUDENT_POSITION_IN_LIST, studentPositionInList);
        fragment.setArguments(args);
        return fragment;
    }

    private int studentPositionInList;

    public StudentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            studentPositionInList = getArguments().getInt(ARG_STUDENT_POSITION_IN_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Student student = MainActivity.STUDENTS[studentPositionInList];

        ((TextView)getActivity().findViewById(R.id.tv_first_name)).setText(student.getFirstName());
        ((TextView)getActivity().findViewById(R.id.tv_last_name)).setText(student.getLastName());
        ((TextView)getActivity().findViewById(R.id.tv_email)).setText(student.getEmail());
    }
}
