package com.petrol.petrol_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.petrol.petrol_project.form.Form;
import com.petrol.petrol_project.util.FirebaseConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class request_form extends AppCompatActivity {

    TextView reqform_txt, customer_txt, vh_txt, srv_txt, add_txt, dl_txt, pay_txt, add_info_txt;
    EditText name_txt, email_txt, phone_txt, vh_model_txt, vh_regno_txt, srv_amount_txt, add_comment_txt, dl_street_txt, dl_city_txt, dl_state_txt, dl_pincode_txt, pay_cardno_txt, pay_expdate_txt, pay_cvv_txt, add_notes_txt;
    RadioButton pay_cre_txt, pay_deb_txt;
    Button submit_btn;

    Bundle extras;
    FirebaseFirestore db;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_form);

        reqform_txt = findViewById(R.id.reqform_txt);
        customer_txt = findViewById(R.id.customer_txt);
        vh_txt = findViewById(R.id.vh_txt);
        srv_txt = findViewById(R.id.srv_txt);
        add_txt = findViewById(R.id.add_txt);
        dl_txt = findViewById(R.id.dl_txt);
        pay_txt = findViewById(R.id.pay_txt);
        add_info_txt = findViewById(R.id.add_info_txt);

        name_txt = findViewById(R.id.name_txt);
        email_txt = findViewById(R.id.email_txt);
        phone_txt = findViewById(R.id.phone_txt);
        vh_model_txt = findViewById(R.id.vh_model_txt);
        vh_regno_txt = findViewById(R.id.vh_regno_txt);
        srv_amount_txt = findViewById(R.id.srv_amount_txt);
        add_comment_txt = findViewById(R.id.add_comment_txt);
        dl_street_txt = findViewById(R.id.dl_street_txt);
        dl_city_txt = findViewById(R.id.dl_city_txt);
        dl_state_txt = findViewById(R.id.dl_state_txt);
        dl_pincode_txt = findViewById(R.id.dl_pincode_txt);
        pay_cardno_txt = findViewById(R.id.pay_cardno_txt);
        pay_expdate_txt = findViewById(R.id.pay_expdate_txt);
        pay_cvv_txt = findViewById(R.id.pay_cvv_txt);
        add_notes_txt = findViewById(R.id.add_notes_txt);

        pay_cre_txt = findViewById(R.id.pay_cre_txt);
        pay_deb_txt = findViewById(R.id.pay_deb_txt);

        submit_btn = findViewById(R.id.submit_btn);

        extras = getIntent().getExtras();
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        String fuelType = extras.getString("request");

        submit_btn.setOnClickListener(v -> {
            FirebaseUser currentUser = auth.getCurrentUser();
            if (currentUser != null) {
                String uid = currentUser.getUid();

                String fullName = name_txt.getText().toString();
                String email = email_txt.getText().toString();
                String phone = phone_txt.getText().toString();
                String vehicleModel = vh_model_txt.getText().toString();
                String vehicleRegNo = vh_regno_txt.getText().toString();
                String serviceAmount = srv_amount_txt.getText().toString();
                String additionalComment = add_comment_txt.getText().toString();
                String streetAddress = dl_street_txt.getText().toString();
                String city = dl_city_txt.getText().toString();
                String state = dl_state_txt.getText().toString();
                String pincode = dl_pincode_txt.getText().toString();
                String cardNumber = pay_cardno_txt.getText().toString();
                String cardExpiryDate = pay_expdate_txt.getText().toString();
                String cardCVV = pay_cvv_txt.getText().toString();
                String additionalNotes = add_notes_txt.getText().toString();
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                String time = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());


                if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone) ||
                        TextUtils.isEmpty(vehicleModel) || TextUtils.isEmpty(vehicleRegNo) || TextUtils.isEmpty(serviceAmount) ||
                        TextUtils.isEmpty(streetAddress) || TextUtils.isEmpty(city) || TextUtils.isEmpty(state) ||
                        TextUtils.isEmpty(pincode) || TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(cardExpiryDate) ||
                        TextUtils.isEmpty(cardCVV)) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Form form = new Form(fuelType, fullName, email, phone, vehicleModel, vehicleRegNo, serviceAmount, additionalComment, streetAddress, city, state, pincode, cardNumber, cardExpiryDate, cardCVV, additionalNotes,date,time);

                String requestId = FirebaseFirestore.getInstance().collection(FirebaseConstants.REQUEST.toString()).document().getId();

                form.setRequestId(requestId);

                db.collection(FirebaseConstants.USER_COLLECTION.toString()).document(uid).collection(FirebaseConstants.REQUEST.toString()).document(requestId)
                        .set(form)
                        .addOnSuccessListener(documentReference -> {
                            Toast.makeText(this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Log.d("check", e.getMessage());
                            Toast.makeText(this, "Failed to Submit Form"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
