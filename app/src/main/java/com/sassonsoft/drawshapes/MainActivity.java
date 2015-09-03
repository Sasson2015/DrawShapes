package com.sassonsoft.drawshapes;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView rectImage, circleImage;
    private Button createRect, createCircle;
    private EditText locX, locY, width, height, radius;
    private Spinner color;

    private Rectangle rect;
    private Circle circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializationVariables();

    }

    private void initializationVariables() {
        rectImage = (ImageView) findViewById(R.id.ivRectangle);
        circleImage=(ImageView) findViewById(R.id.ivCircle);
        createRect = (Button) findViewById(R.id.bRectangle);
        createCircle = (Button) findViewById(R.id.bCircle);
        locX = (EditText) findViewById(R.id.etLocX);
        locY = (EditText) findViewById(R.id.etLocY);
        width = (EditText) findViewById(R.id.etRectWidth);
        height = (EditText) findViewById(R.id.etRectHeight);
        radius=(EditText) findViewById(R.id.etRadius);
        color = (Spinner) findViewById(R.id.spinColor);

        createRect.setOnClickListener(this);
        createCircle.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRectangle:
                if (width.getText().toString().equals("") ||
                        height.getText().toString().equals("") ||
                        locX.getText().toString().equals("") ||
                        locY.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Please fill the necessary filed for Rectangle to be created.");
                    builder.setTitle("Fields Require!");
                    builder.setIcon(R.mipmap.error_icon);
                    builder.setPositiveButton("OK", null);
                    builder.create();
                    builder.show();
                } else
                    createRectangle();
                break;

            case R.id.bCircle:
                if (radius.getText().toString().equals("") ||
                        locX.getText().toString().equals("") ||
                        locY.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Please fill the necessary filed for Circle to be created.");
                    builder.setTitle("Fields Require!");
                    builder.setIcon(R.mipmap.error_icon);
                    builder.setPositiveButton("OK", null);
                    builder.create();
                    builder.show();
                } else
                    createCircle();
                break;
        }
    }

    //create the rectangle on the screen
    private void createRectangle() {

        rect = new Rectangle(Integer.parseInt(locX.getText().toString()),
                Integer.parseInt(locY.getText().toString()),
                Color.parseColor(color.getSelectedItem().toString()),
                Integer.parseInt(width.getText().toString()),
                Integer.parseInt(height.getText().toString()));

        ShapeDrawable draw = new ShapeDrawable(new RectShape());
        draw.setIntrinsicHeight(rect.getHeight());
        draw.setIntrinsicWidth(rect.getWidth());
        draw.getPaint().setColor(rect.getColor());

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(rect.getX(), rect.getY(), 0, 0);
        rectImage.setLayoutParams(params);
        rectImage.setImageDrawable(draw);
    }

    //create the circle on the screen
    private void createCircle() {

        circle=new Circle(Integer.parseInt(locX.getText().toString()),
                Integer.parseInt(locY.getText().toString()),
                Color.parseColor(color.getSelectedItem().toString()),
                Integer.parseInt(radius.getText().toString()));

        ShapeDrawable oval = new ShapeDrawable(new OvalShape());
        oval.setIntrinsicHeight(circle.getRadius()*2);
        oval.setIntrinsicWidth(circle.getRadius()*2);
        oval.getPaint().setColor(circle.getColor());

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(circle.getX(), circle.getY(), 0, 0);
        circleImage.setLayoutParams(params);
        circleImage.setImageDrawable(oval);
    }
}
