package de.example.fajar.booklist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.example.fajar.booklist.adapter.BookAdapter;
import de.example.fajar.booklist.model.Books;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {

    private List<Books> booksList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/RobotoSlab-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new BookAdapter(this, booksList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareBookData();
    }

    private  void prepareBookData(){
        Books books = new Books("Harry Potter: the Goblet of Fire", "Fantasy", "J. K Rowling", "https://media.bloomsbury.com/rep/bj/9783551354044.jpg");
        booksList.add(books);

        books = new Books("Angle and Demon", "Action", "Dan Brown", "https://images-na.ssl-images-amazon.com/images/I/81-%2BZ-hkITL.jpg");
        booksList.add(books);

        books = new Books("Call Me by Your Name", "Fantasy", "André Aciman", "https://images-na.ssl-images-amazon.com/images/I/41VeOj88kYL._SY450_.jpg");
        booksList.add(books);

        mAdapter.notifyDataSetChanged();

    }

}
