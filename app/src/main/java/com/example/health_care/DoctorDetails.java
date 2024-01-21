package com.example.health_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor Name: Ajit Saste","Hospital Address:Pimpri","Exp : 5yrs","Mobile No:9898989898","600"},
            {"Doctor Name: Prasad pawar","Hospital Address:Nigdi","Exp : 15yrs","Mobile No:7878989898","900"},
            {"Doctor Name: Swapnil Kale","Hospital Address:Pune","Exp : 8yrs","Mobile No:9898787898","300"},
            {"Doctor Name: Deepak Deshmukh","Hospital Address:Pimpri","Exp : 6yrs","Mobile No:9898989008","500"},
            {"Doctor Name: Ashok Panda","Hospital Address:Katraj","Exp : 7yrs","Mobile No:7798789898","800"}
    };
    private String[][] doctor_details2={
            {"Doctor Name: Sunil Saste","Hospital Address:Pimpri","Exp : 5yrs","Mobile No:9898989898","600"},
            {"Doctor Name: Vimal pawar","Hospital Address:Nigdi","Exp : 15yrs","Mobile No:7878989898","900"},
            {"Doctor Name: Ramesh Kale","Hospital Address:Pune","Exp : 8yrs","Mobile No:9898787898","300"},
            {"Doctor Name: Deepak Deshmukh","Hospital Address:Pimpri","Exp : 6yrs","Mobile No:9898989008","500"},
            {"Doctor Name: Ashok Panda","Hospital Address:Katraj","Exp : 7yrs","Mobile No:7798789898","800"}
    };
    private String[][] doctor_details3={
            {"Doctor Name: Ajit Saste","Hospital Address:Pimpri","Exp : 5yrs","Mobile No:9898989898","600"},
            {"Doctor Name: Prasad pawar","Hospital Address:Nigdi","Exp : 15yrs","Mobile No:7878989898","900"},
            {"Doctor Name: Kalpana Kale","Hospital Address:Pune","Exp : 8yrs","Mobile No:9898787898","300"},
            {"Doctor Name: Ramesh Deshmukh","Hospital Address:Pimpri","Exp : 6yrs","Mobile No:9898989008","500"},
            {"Doctor Name: Ashok Panda","Hospital Address:Katraj","Exp : 7yrs","Mobile No:7798789898","800"}
    };
    private String[][] doctor_details4={
            {"Doctor Name: Jayant Kumar","Hospital Address:Pimpri","Exp : 5yrs","Mobile No:9898989898","600"},
            {"Doctor Name: Harsh Vijay","Hospital Address:Nigdi","Exp : 15yrs","Mobile No:7878989898","900"},
            {"Doctor Name: Swapnil Kale","Hospital Address:Pune","Exp : 8yrs","Mobile No:9898787898","300"},
            {"Doctor Name: Deepak Deshmukh","Hospital Address:Pimpri","Exp : 6yrs","Mobile No:9898989008","500"},
            {"Doctor Name: Soham Shindre","Hospital Address:Katraj","Exp : 7yrs","Mobile No:7798789898","800"}
    };
    private String[][] doctor_details5={
            {"Doctor Name: Ayush Saste","Hospital Address:Pimpri","Exp : 5yrs","Mobile No:9898989898","600"},
            {"Doctor Name: Tabrak pawar","Hospital Address:Nigdi","Exp : 15yrs","Mobile No:7878989898","900"},
            {"Doctor Name: Ravi Kale","Hospital Address:Pune","Exp : 8yrs","Mobile No:9898787898","300"},
            {"Doctor Name: Anikesh Deshmukh","Hospital Address:Pimpri","Exp : 6yrs","Mobile No:9898989008","500"},
            {"Doctor Name: Ashok Panda","Hospital Address:Katraj","Exp : 7yrs","Mobile No:7798789898","800"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it =getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetails.this,FindDoctor.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line 1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);

        }
    sa= new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
            new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
    }
}