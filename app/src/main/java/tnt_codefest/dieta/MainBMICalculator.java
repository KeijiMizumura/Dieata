package tnt_codefest.dieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainBMICalculator extends AppCompatActivity {
    private EditText field_feet, field_inches, field_pounds;
    private Button button_calculate;
    private TextView label_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bmi_calculator);

        field_feet = findViewById(R.id.field_feet);
        field_inches = findViewById(R.id.field_inches);
        field_pounds = findViewById(R.id.field_pounds);
        button_calculate = findViewById(R.id.button_calculate);
        label_result = findViewById(R.id.label_result);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double feet = Double.parseDouble(field_feet.getText().toString());
                double inches = Double.parseDouble(field_inches.getText().toString());
                double pounds = Double.parseDouble(field_pounds.getText().toString());

                double result = calculateStandard(feet, inches, pounds);
                label_result.setText(((Double) result).toString());

            }
        });
    }

    private double calculateStandard(double feet, double inches, double pounds){
        double height = ((feet * 12) + inches) * 0.025;
        double weight  = pounds * 0.45;

        return (double) Math.round((weight / (height * height)) * 100.0) / 100.0;
    }
}
