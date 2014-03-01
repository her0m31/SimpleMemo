package uka.ayagi.simplememo;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<Object> {
	private ArrayList<Object> items;
	private LayoutInflater inflater;

	public Adapter(Context context, int textViewResourceId, ArrayList<Object> items) {
		super(context, textViewResourceId, items);

		this.items = items;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// ビューを受け取る
		View view = convertView;
		if (view == null) {		// 受け取ったビューがnullなら新しくビューを生成
			view = inflater.inflate(R.layout.row, null);		// 背景画像をセットする
		}

		Data item = (Data)items.get(position);		// 表示すべきデータの取得
		if (item != null) {
			TextView screenName = (TextView)view.findViewById(R.id.toptext);
			screenName.setTypeface(Typeface.DEFAULT_BOLD);

			// スクリーンネームをビューにセット
			TextView text = (TextView)view.findViewById(R.id.bottomtext);
			if (screenName != null) {
				screenName.setText(item.getDate());
			}

			// テキストをビューにセット
			if (text != null) {
				text.setText(item.getText());
			}
		}
		return view;
	}
}