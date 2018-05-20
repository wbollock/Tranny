package wbollock.com.tranny;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    ViewGroup buckysLayout; //  need reference to layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buckysLayout = (ViewGroup) findViewById(R.id.buckysLayout);

        buckysLayout.setOnTouchListener( // wait to see when user taps
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) { // when they do touch, call this code
                        moveButton(); // create outside of onCreate
                        return true; // let app know we handled touch event
                    } // end of onTouch
                }
        );// end of listener
    } // end of On Create

    public void moveButton(){
        View buckysButton = findViewById(R.id.buckysButton);
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT); // wrapping content

        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE); // sticking it to the bottom
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE); // sticking it to the right, also

        // now just set the layout Parmaeters to the rules we set
        buckysButton.setLayoutParams(positionRules);

        //now, change size of button
        ViewGroup.LayoutParams sizeRules = buckysButton.getLayoutParams(); // returns info about the button itself
        sizeRules.width = 450;
        sizeRules.height = 300;
        buckysButton.setLayoutParams(sizeRules); // once again, confirm what we want the layout params to be

    }// end of moveButton

}
