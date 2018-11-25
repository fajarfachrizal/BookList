package de.example.fajar.booklist.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.example.fajar.booklist.R;
import de.example.fajar.booklist.model.Books;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{

    private List<Books> booksList;
    private Context context;
    RequestOptions option;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @Nullable@BindView(R.id.book_title)
        TextView mBookTitle;
        @Nullable@BindView(R.id.genre)
        TextView mGenre;
        @Nullable@BindView(R.id.writer)
        TextView mWriter;
        @Nullable@BindView(R.id.image_container)
        ImageView mImageContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public BookAdapter(Context context, List<Books> booksList) {
        this.context = context;
        this.booksList = booksList;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.harry).error(R.drawable.harry);



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Books books = booksList.get(position);
        holder.mBookTitle.setText(books.getTitle());
        holder.mGenre.setText(books.getGenre());
        holder.mWriter.setText(books.getWriter());

        Glide.with(context).load(books.getImgUrl()).apply(option).into(holder.mImageContainer);

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }


}
