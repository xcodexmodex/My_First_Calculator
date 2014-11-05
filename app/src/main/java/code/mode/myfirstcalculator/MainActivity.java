package code.mode.myfirstcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;


    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    /**
     * Called when the activity is first created*
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the elements
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        //set a listener
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        //Check if the fields are empty
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        //Read EditText and fill variables with numbers
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        //defines the button that has been clicked and performs the coorespondingoperation
        //write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMul:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;

        }

        //Form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }


    //Menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //TODO Auto-generated method stub
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }


    //Process menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO Auto-generated method stub
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                //Clear the fields
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                //Exit the application
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}