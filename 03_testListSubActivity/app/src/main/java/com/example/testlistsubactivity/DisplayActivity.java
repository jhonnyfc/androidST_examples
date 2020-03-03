package com.example.testlistsubactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends Activity {

    int position;
	String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        position = bundle.getInt("position");
		name = bundle.getString("name");

        TextView textView = ((TextView) findViewById(R.id.textViewDisplay));
		textView.setTextSize(40);
		textView.setText(name);
	}

	public void saveLocationName(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_name);
        String name = editText.getText().toString();

		Bundle bundle = new Bundle();
		bundle.putInt("position", position);
        bundle.putString("name", name);

        Intent intent = new Intent();
		intent.putExtras(bundle);
		setResult(RESULT_OK, intent);
		finish();
	}
}
