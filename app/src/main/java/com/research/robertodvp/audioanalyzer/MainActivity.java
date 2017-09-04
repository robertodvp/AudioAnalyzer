package com.research.robertodvp.audioanalyzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
//import com.research.robertodvp.audioanalyzer.Utilities.MusicXMLFileHelper;

public class MainActivity extends AppCompatActivity {

    private Button mAAnalyzerButton = null;
    private Button mNIdentifierButton = null;
    private Button mGrandStaffButton = null;
    private Button mPortfolioButton = null;
    private static final int  AANALYZER_ACT= 1;
    private static final int  NIDENTIFIER_ACT= 2;
    private static final int  GRANDSTAFF_ACT= 3;
    private static final int  PORTFOLIO_ACT= 5;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.gorilla);

        mAAnalyzerButton = (Button)findViewById(R.id.idMainButton1);
        mNIdentifierButton = (Button)findViewById(R.id.idMainButton2);
        mGrandStaffButton = (Button)findViewById(R.id.idMainButton3);
        mPortfolioButton = (Button)findViewById(R.id.idMainButton5);
        //openNewActivity(5);
        mAAnalyzerButton.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     openNewActivity(AANALYZER_ACT);
                 }
             }
        );

        mNIdentifierButton.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    openNewActivity(NIDENTIFIER_ACT);
               }
            }
        );

        mGrandStaffButton.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                  openNewActivity(GRANDSTAFF_ACT);
              }
          }
        );

        mPortfolioButton.setOnClickListener(new View.OnClickListener() {
                                                 public void onClick(View v) {
                                                     openNewActivity(PORTFOLIO_ACT);
                                                 }
                                             }
        );
    }

    public void openNewActivity(int Activity){

        switch (Activity){
            case 1:{
                Intent intent = new Intent(this, AudioAnalyzerActivity.class);
                startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(this, ImageAnalyzerActivity.class);
                startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(this, GrandStaffActivity.class);
                startActivity(intent);
                break;
            }
            case 4:{
                /*MusicXMLFileHelper obj = new MusicXMLFileHelper();
                try {
                    obj.write();
                }catch (Exception e){
                    System.out.print(e.getCause());
                }*/
                break;
            }
            case 5:{
                Intent intent = new Intent(this, PortfolioActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
}
