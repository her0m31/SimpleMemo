package uka.ayagi.simplememo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.ListView;
import uka.ayagi.simplememo.Trimun;

public class SimpleMemo extends Activity implements OnClickListener {
	private ListView listView;
	private Adapter adapter;
	private ArrayList<Object>  list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);

		list = new ArrayList<Object>();
		list = Serializing.Load(this);

		adapter = new Adapter(this, R.layout.row, list);
		listView = ((ListView) findViewById(R.id.listview));
		listView.setAdapter(adapter);

		registerForContextMenu(listView);
		findViewById(R.id.btnInsert).setOnClickListener(this);
	}

	//ボタン押
	@Override
	public void onClick(View v) {
		EditText editText = (EditText)findViewById(R.id.textBox);
		Data item = new Data();
		item.setDate(createDate());
		String text = editText.getText().toString();
		//Trimunは自作クラス
		if( Trimun.trimCheck(text = Trimun.trimming(text))) {
	    	editText.setText("");
	    }
		else {
			item.setText(text);
			editText.setText("");
			list.add(0, item);
			Serializing.Save(this, list);
			adapter.notifyDataSetChanged();
		}
	}

	//リストアイテム長押し時
	public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, view, menuInfo);
		menu.setHeaderTitle(R.string.context_header);
		menu.add(0, 0, 0, R.string.context_delete);
	}

	  //コンテキストメニュークリック時のリスナ
	public boolean onContextItemSelected(MenuItem item){
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
	    switch(item.getItemId()){
	    	case 0:
	    		list.remove(info.position);
	    		Serializing.Save(this, list);
	      		adapter.notifyDataSetChanged();
	      		return true;
	    	default:
	    		return super.onContextItemSelected(item);
	    }
	}

	public String createDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(date);
	}
}

