package tw.org.iii.ellen.ellen28;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView birthday,time ;
    private View rootView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthday = findViewById(R.id.birthday) ;
        time = findViewById(R.id.time) ;
        rootView = findViewById(R.id.rootView) ;
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test5(null) ;
            }
        });
    }

    public void test1(View view) {
        newDate() ;
    }

    private void newDate(){
        DatePickerDialog dialog =
                new DatePickerDialog(this,
                        DatePickerDialog.THEME_DEVICE_DEFAULT_DARK,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                birthday.setText(year +"/"+ (month+1) +"/"+ dayOfMonth) ;
                            }
                        }, 2020, 3, 12) ;

        DatePicker picker = dialog.getDatePicker() ;
        Calendar limit = Calendar.getInstance() ;
        limit.set(2020,3,12) ;
        picker.setMaxDate(limit.getTimeInMillis());

        dialog.show() ;
    }



    public void test2(View view) {
        TimePickerDialog dialog =
                new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        }
                },12,30,true) ;

        dialog.show() ;
    }

    private void showMyToast(String mesg, boolean isWarn){
        LayoutInflater inflater = getLayoutInflater() ;
        View view = inflater.inflate(R.layout.toast,null) ;
        ImageView img = view.findViewById(R.id.toast_img) ;
        TextView toast_mesg = view.findViewById(R.id.toast_mesg) ;
        toast_mesg.setText(mesg) ;
        //img.setImageResource(isWarn? R.drawable);

        Toast toast = new Toast(this) ;
        toast.setView(view) ;
        toast.setDuration(Toast.LENGTH_LONG) ;
        toast.setGravity(Gravity.FILL_HORIZONTAL,0,200);
        toast.show() ;
    }

    public void test3(View view) {
        showMyToast("Hello, World",true) ;
    }

    Snackbar snackbar ;
    public void test4(View view) {
        snackbar = Snackbar.make(rootView, "This is SnackBar", Snackbar.LENGTH_INDEFINITE) ;
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyToast("OK",true) ;
            }
        }) ;
        snackbar.setActionTextColor(Color.YELLOW) ;
        snackbar.show() ;
    }

    public void test5(View view) {
        if (snackbar != null)
            snackbar.dismiss() ;
    }
}
