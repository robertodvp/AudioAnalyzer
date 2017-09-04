package com.research.robertodvp.audioanalyzer;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.research.robertodvp.audioanalyzer.View.GStaffView;

import java.io.FileDescriptor;
import java.io.IOException;

public class ImageAnalyzerActivity extends AppCompatActivity {

    private static int SELECT_PICTURE_1 = 1;
    private static int SELECT_PICTURE_2 = 2;
    private String selectedImagePath;
    //ADDED
    private String filemanagerstring;
    private Button mLoadImage1 = null;
    private Button mLoadImage2 = null;
    private ImageView mImageView1 = null;
    private ImageView mImageView2 = null;

    GStaffView mGStaffView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_analyzer);
        mGStaffView = (GStaffView)findViewById(R.id.idGStaffView);


        mLoadImage1 = (Button)findViewById(R.id.idLoadImageButton);
        mLoadImage2 = (Button)findViewById(R.id.idLoadImageButton2);

        mImageView1 = (ImageView)findViewById(R.id.idImageView1);
        mLoadImage1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,
                            "Select Picture"), SELECT_PICTURE_1);
                }
            });

        mImageView2 = (ImageView)findViewById(R.id.idImageView2);
        mLoadImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE_2);
            }
        });

        mGStaffView.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                System.out.println("X: "+arg1.getX());
                System.out.println("Y: "+arg1.getY());
                System.out.println("Raw X: "+arg1.getRawX());
                System.out.println("Raw Y: "+arg1.getRawY());
                return true;
            }
        }
        );
    }

    //UPDATED
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE_1 || requestCode == SELECT_PICTURE_2) {
                Uri selectedImageUri = data.getData();

                //OI FILE Manager
                filemanagerstring = selectedImageUri.getPath();

                //MEDIA GALLERY
                selectedImagePath = getPath(selectedImageUri);

                //DEBUG PURPOSE - you can delete this if you want
                if(selectedImagePath!=null)
                    System.out.println(selectedImagePath);
                else System.out.println("selectedImagePath is null");
                if(filemanagerstring!=null)
                    System.out.println(filemanagerstring);
                else System.out.println("filemanagerstring is null");

                //NOW WE HAVE OUR WANTED STRING
                if(selectedImagePath!=null)
                    System.out.println("selectedImagePath is the right one for you!");
                else
                    System.out.println("filemanagerstring is the right one for you!");

                try {
                    Bitmap bitmap = getBitmapFromUri(selectedImageUri);
                    if(requestCode==SELECT_PICTURE_1){
                        mImageView1.setImageBitmap(bitmap);
                    }
                    if(requestCode==SELECT_PICTURE_2){
                        mImageView2.setImageBitmap(bitmap);
                    }
                } catch (Exception e) {
                    System.out.println(e.getCause());
                }
            }

        }
    }

    //UPDATED!
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if(cursor!=null)
        {
            //HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            //THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        else return null;
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
}
