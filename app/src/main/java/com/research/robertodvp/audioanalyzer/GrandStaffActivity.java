package com.research.robertodvp.audioanalyzer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.research.robertodvp.audioanalyzer.Enums.NoteState;


/**
 * Created by robertov on 18/03/2017.
 */

public class GrandStaffActivity extends AppCompatActivity {

    private Button mSaveSelectedNotes_btn = null;
    private TableLayout tblStaffTable = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_view);


        tblStaffTable = (TableLayout)findViewById(R.id.idStaffActiveNotesTable);

        mSaveSelectedNotes_btn = (Button)findViewById(R.id.saveSelectedNotes_btn);

        mSaveSelectedNotes_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    saveSelectedNotes();
                }
            }
        );
    }

    private void saveSelectedNotes(){
        String SaveNotes_str="";
        View v =null;
        View w =null;

        AppCompatTextView tmpTV = (AppCompatTextView) findViewById(R.id.idSavedSelectedNotes);
        tmpTV.setText(SaveNotes_str);
        this.findViewById(android.R.id.content).invalidate();

        for(int i=0; i < tblStaffTable.getChildCount(); i++)
        {
            v = tblStaffTable.getChildAt(i);
            System.out.println(v.getClass());
            System.out.println(v.getAccessibilityClassName());
            if (v instanceof TableRow) {
                for (int j = 0; j < ((TableRow) v).getChildCount(); j++) {
                    w = ((TableRow) v).getChildAt(j);
                    System.out.println(w.getClass());
                    System.out.println(w.getAccessibilityClassName());
                    if (w instanceof StaffNote) {
                        if (((StaffNote) w).getState() == NoteState.SELECTED) {
                            SaveNotes_str += ((StaffNote) w).get_noteId() + ", " +((StaffNote) w).get_alt();
                            tmpTV.setText(SaveNotes_str);
                            SaveNotes_str += ", ";
                            this.findViewById(android.R.id.content).invalidate();
                        }
                    }
                }
            }
        }
    }
}
