package com.yashinc.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_00;
    Button btn_dot, btn_equal, btn_c, btn_add, btn_minus, btn_multiply, btn_divide, btn_percent, btn_backspace;

    // Flag initialization
    int is_operator_allowed = 0; // Not allowed in the beginning
    int is_digit_allowed = 1; // Yes
    int is_dot_allowed = 1; // Yes allowed in the beginning

    String process;

    TextView inputTxt;
    TextView outputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputTxt = findViewById(R.id.inputTxt);
        outputTxt = findViewById(R.id.outputTxt);

        btn_00 = findViewById(R.id.btn_00);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_c = findViewById(R.id.btn_c);
        btn_backspace = findViewById(R.id.btn_Backspace);
        btn_add = findViewById(R.id.btn_add);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);
        btn_percent = findViewById(R.id.btn_percent);

        btn_c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                inputTxt.setText("");
                outputTxt.setText("");
            }
        });

        btn_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String backspace = null;
                if (inputTxt.getText().length() > 0) {

                    StringBuilder stringBuilder = new StringBuilder(inputTxt.getText());
                    stringBuilder.deleteCharAt(inputTxt.getText().length() - 1);
                    backspace = stringBuilder.toString();
                    inputTxt.setText(backspace);
                }
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "0");
                is_operator_allowed = 1;
            }
        });

        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "00");
                is_operator_allowed = 1;
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "1");
                is_operator_allowed = 1;
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "2");
                is_operator_allowed = 1;
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "3");
                is_operator_allowed = 1;
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "4");
                is_operator_allowed = 1;
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "5");
                is_operator_allowed = 1;
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "6");
                is_operator_allowed = 1;
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "7");
                is_operator_allowed = 1;
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "8");
                is_operator_allowed = 1;
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                inputTxt.setText(process + "9");
                is_operator_allowed = 1;
            }
        });


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_operator_allowed == 1) {
                    process = inputTxt.getText().toString();
                    inputTxt.setText(process + "+");
                    is_operator_allowed = 0;
                    is_dot_allowed = 1;
                }
            }
        });


        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_operator_allowed == 1) {
                    process = inputTxt.getText().toString();
                    inputTxt.setText(process + "-");
                    is_dot_allowed = 1;
                    is_operator_allowed = 0;
                }
            }

        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_operator_allowed == 1) {
                    process = inputTxt.getText().toString();
                    inputTxt.setText(process + "*");
                    is_operator_allowed = 0;
                    is_dot_allowed = 1;
                }
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_operator_allowed == 1) {
                    process = inputTxt.getText().toString();
                    inputTxt.setText(process + "÷");
                    is_operator_allowed = 0;
                    is_dot_allowed = 1;
                }
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_dot_allowed == 1) {
                    process = inputTxt.getText().toString();
                    inputTxt.setText(process + ".");
                    is_dot_allowed = 0;
                }
            }
        });

        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_operator_allowed == 1) {
                    process = inputTxt.getText().toString();
                    inputTxt.setText(process + "%");
                    is_operator_allowed = 0;
                    is_dot_allowed = 1;
                }
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTxt.getText().toString();
                // Condition - empty or no entry by a user. Equal press handling.
                // check if the process string is empty using strlen
                // if it's empty then don't proceed to next statement and just return from the function

                if (process == "") {
                    System.out.println("Don't take input from the user" + isEmpty(""));
                } else {

                    process = process.replace("x", "*");
                    process = process.replace("%", "/100");
                    process = process.replace("÷", "/");
                    Context rhino = Context.enter();

                    rhino.setOptimizationLevel(-1);

                    String finalResult = "";

                    try {
                        ScriptableObject scriptable = rhino.initStandardObjects();
                        finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                    } catch (Exception e) {
                        finalResult = "0";
                    }

                    outputTxt.setText(finalResult);
                }
            }


        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Check out My Application");
            String shareMessage = "https://play.google.com/store/apps/details?id=com.yashinc.calculator&hl=en_IN&gl=US" + BuildConfig.APPLICATION_ID + "\n\n";
            intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(intent, "share by"));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    }






