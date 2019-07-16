package com.example.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends BaseAdapter  {

    String[] movies;
    String[] imagesUrl;
    LayoutInflater inflater;
    Context mContext;
    int[] images = new int[]{
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground};

    public MovieAdapter(String[] movie_title, String[] img_urls, Context context) {
        movies = movie_title;
        imagesUrl = img_urls;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
    }

    @Override
    public int getCount() {//how many data items are present in the array
        return movies.length;
    }

    @Override
    public Object getItem(int position) {
        return movies[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * when an empty row gets exposed -- an wooden plank
     * this method will create an row and insert it in the listview
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //ListRow listRow = new ListRow(mContext);
        if(convertView==null){
            convertView = inflater.inflate(R.layout.list_row, null);
        }

        TextView tv= convertView.findViewById(R.id.detailsTextview);
        ImageView img= convertView.findViewById(R.id.imageview);
       CheckBox checkBox = convertView.findViewById(R.id.mycheckbox);

       // Picasso.with(mContext).load(imagesUrl[position]).into(img);//picasso helps you download image from image url and set it into the imageview
        //picasso help you cache the imagesUrl
        tv.setText(movies[position]);

        Glide.with(mContext)
                //.load(mImageUri) // Load image from assets
                .load(imagesUrl[position]) // Image URL
                .centerCrop() // Image scale type
                .crossFade()
                .override(100,100) // Resize image
                .placeholder(R.drawable.ic_launcher_background) // Place holder image
                .error(R.drawable.ic_launcher_foreground) // On error image
                .into(img); // ImageView to display image


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(mContext, "position checked ="+position, Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;

    }


}
