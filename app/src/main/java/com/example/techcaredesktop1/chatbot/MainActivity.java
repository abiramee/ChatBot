package com.example.techcaredesktop1.chatbot;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.techcaredesktop1.chatbot.Adapter.Adapter;
import com.example.techcaredesktop1.chatbot.Model.Model;
import com.example.techcaredesktop1.chatbot.Network.ApiClient;
import com.example.techcaredesktop1.chatbot.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Model> chat = new ArrayList<>();
    Model model = new Model();
    Adapter adapter;

    private RecyclerView recyclerView;
    private EditText editText;
    private ImageView fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniView();

    }

    private void iniView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyleview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplication());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new Adapter(getApplicationContext(), chat);
        recyclerView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.et_send_bar);
        fab = (ImageView) findViewById(R.id.ib_send);

        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, 0);

        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP:
                        loadData();
                        break;
                }
                return false;
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            loadData();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
    }

    private void loadData() {
        model = new Model(editText.getText().toString(), "", 1, "ok");
        chat.add(model);
        adapter.notifyItemChanged(chat.size() - 1);
        recyclerView.scrollToPosition(chat.size() -1);

        getData(editText.getText().toString());
        editText.setText("");
    }

    private void getData(String message) {
        ApiService apiService = ApiClient.getClient(getApplicationContext()).create(ApiService.class);
        String url = "request.p?key=594b9304-17f6-4efe-8523-a0e57d2fd616&lc=en&ft=1.0&text=" + message;
        Call<Model> breakCall = apiService.getData(url);
        breakCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                model = response.body();
                chat.add(model);
                adapter.notifyItemChanged(chat.size() - 1);
                recyclerView.scrollToPosition(chat.size() -1);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}
