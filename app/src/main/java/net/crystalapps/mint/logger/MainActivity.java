package net.crystalapps.mint.logger;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.crystalapps.mint.logger.library.core.MintLog;
import net.crystalapps.mint.logger.library.utils.TextUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String VERBOSE = "VERBOSE";
    private static final String DEBUG   = "DEBUG";
    private static final String INFO    = "INFO";
    private static final String WARN    = "WARN";
    private static final String ERROR   = "ERROR";
    private static final String ASSERT  = "ASSERT";

    private String selectedPriority = VERBOSE;

    private EditText etTag;
    private EditText etMsg;
    private TextView tvPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attach views
        attachViews();

        // attach click listener
        attachListener();
    }

    private void attachViews() {
        etTag = findViewById(R.id.etTag);
        etMsg = findViewById(R.id.etMsg);
        tvPriority = findViewById(R.id.tvPriority);
    }

    private void attachListener() {
        findViewById(R.id.btnChangePriority).setOnClickListener(this);
        findViewById(R.id.btnLog).setOnClickListener(this);
    }

    private void changePriority() {
        String[] options = new String[] {VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Priority");
        builder.setItems(options, (dialogInterface, i) -> {
            selectedPriority = options[i];
            tvPriority.setText(selectedPriority);
        });
        builder.create().show();
    }

    private void log() {

        String tag = etTag.getText().toString().trim();
        String msg = etMsg.getText().toString().trim();

        if (TextUtil.isEmpty(msg)) {
            Toast.makeText(this, "Log message can't be empty", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtil.isEmpty(tag)) {
            switch (selectedPriority) {
                case VERBOSE : MintLog.v(msg);   break;
                case DEBUG   : MintLog.d(msg);   break;
                case INFO    : MintLog.i(msg);   break;
                case WARN    : MintLog.w(msg);   break;
                case ERROR   : MintLog.e(msg);   break;
                case ASSERT  : MintLog.wtf(msg); break;
            }
        }

        else {
            switch (selectedPriority) {
                case VERBOSE : MintLog.v(tag, msg);   break;
                case DEBUG   : MintLog.d(tag, msg);   break;
                case INFO    : MintLog.i(tag, msg);   break;
                case WARN    : MintLog.w(tag, msg);   break;
                case ERROR   : MintLog.e(tag, msg);   break;
                case ASSERT  : MintLog.wtf(tag, msg); break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnChangePriority:
                changePriority();
                break;


            case R.id.btnLog:
                log();
                break;
        }
    }
}
