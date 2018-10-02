package de.example.fajar.booklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mBookListTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookListTv = (TextView) findViewById(R.id.tv_book_list);

        String[] bookLists = BookList.getBookNames();
        for (String bookList : bookLists) {
            mBookListTv.append(bookList + "\n\n\n");
        }
    }
}
