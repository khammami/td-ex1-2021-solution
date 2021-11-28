package tn.khammami.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create schools list
        List<School> mSchools = new ArrayList<>();
        mSchools.add(new School(getString(R.string.enetcom_name),getString(R.string.enetcom_description),R.drawable.logo_enetcom));
        mSchools.add(new School(getString(R.string.enib_name),getString(R.string.enib_description),R.drawable.logo_enib));
        mSchools.add(new School(getString(R.string.enig_name),getString(R.string.enig_description),R.drawable.logo_enig));
        mSchools.add(new School(getString(R.string.enim_name),getString(R.string.enim_description),R.drawable.logo_enim));
        mSchools.add(new School(getString(R.string.enis_name),getString(R.string.enis_description),R.drawable.logo_enis));
        mSchools.add(new School(getString(R.string.eniso_name),getString(R.string.eniso_description),R.drawable.logo_eniso));
        mSchools.add(new School(getString(R.string.enit_name),getString(R.string.enit_description),R.drawable.logo_enit));
        mSchools.add(new School(getString(R.string.ensi_name),getString(R.string.ensi_description),R.drawable.logo_ensi));
        mSchools.add(new School(getString(R.string.ept_name),getString(R.string.ept_description),R.drawable.logo_ept));
        mSchools.add(new School(getString(R.string.isi_name),getString(R.string.isi_description),R.drawable.logo_isi));
        mSchools.add(new School(getString(R.string.issatso_name),getString(R.string.issatso_description),R.drawable.logo_issat_sousse));
        mSchools.add(new School(getString(R.string.supcom_name),getString(R.string.supcom_description),R.drawable.logo_supcom));

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        SchoolListAdapter mSchoolListAdapter = new SchoolListAdapter(mSchools);
        mRecyclerView.setAdapter(mSchoolListAdapter);

        mSchoolListAdapter.setOnSchoolClickListener(new SchoolClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), SchoolActivity.class);

                School mSchool = mSchools.get(position);

                intent.putExtra(SchoolActivity.SCHOOL_NAME_KEY, mSchool.getName());
                intent.putExtra(SchoolActivity.SCHOOL_DESCRIPTION_KEY, mSchool.getDescription());
                intent.putExtra(SchoolActivity.SCHOOL_LOGO_KEY, mSchool.getLogo());

                startActivity(intent);
            }
        });
    }
}