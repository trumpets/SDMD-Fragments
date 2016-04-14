package gr.academic.city.sdmd.fragments.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gr.academic.city.sdmd.fragments.R;
import gr.academic.city.sdmd.fragments.ui.fragment.StudentDetailsFragment;

/**
 * Created by trumpets on 4/14/16.
 */
public class StudentDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_STUDENT_POSITION_IN_LIST = "student_position_in_list";

    public static Intent getStartIntent(Context context, int studentPositionInList) {
        Intent intent = new Intent(context, StudentDetailsActivity.class);
        intent.putExtra(EXTRA_STUDENT_POSITION_IN_LIST, studentPositionInList);

        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        int studentPositionInList = getIntent().getIntExtra(EXTRA_STUDENT_POSITION_IN_LIST, -1);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            StudentDetailsFragment firstFragment = StudentDetailsFragment.newInstance(studentPositionInList);

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
