package gr.academic.city.sdmd.fragments.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import gr.academic.city.sdmd.fragments.R;
import gr.academic.city.sdmd.fragments.data.Student;
import gr.academic.city.sdmd.fragments.ui.fragment.StudentDetailsFragment;
import gr.academic.city.sdmd.fragments.ui.fragment.StudentsListFragment;

public class MainActivity extends AppCompatActivity implements StudentsListFragment.OnFragmentInteractionListener {

    // DON'T EVER DO THIS; FOR DEMONSTRATIONAL PURPOSES ONLY =)
    public static final Student[] STUDENTS = new Student[]{
            new Student("Michal", "Chmura", "arachnocutter@sdmd-squad.gr"),
            new Student("Athanasios", "Lagias", "crimson@sdmd-squad.gr"),
            new Student("Theofanis", "Mitsou", "hyperion@sdmd-squad.gr"),
            new Student("Konstantinos", "Romanidis", "tricktron@sdmd-squad.gr"),
            new Student("Ibrahim", "Tolaj", "tempest@sdmd-squad.gr"),
            new Student("Shkelzen", "Vishi", "jestermancer@sdmd-squad.gr")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStudentSelected(int studentLocationInList) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        boolean isDualPane = fragmentContainer != null &&
                fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, StudentDetailsFragment.newInstance(studentLocationInList));
            fragmentTransaction.commit();
        } else {
            startActivity(StudentDetailsActivity.getStartIntent(this, studentLocationInList));
        }
    }
}
