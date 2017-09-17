package com.example.jojo.androidrssreader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jojo on 12/9/2017.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    private Activity mContext;
    private ArrayList<Post> mObjects;

    public PostAdapter(Context context, int resource, ArrayList<Post> objects) {
        super(context, resource, objects);
        mContext = (Activity)context;
        mObjects = objects;
    }

    static class ViewHolder{
        TextView vTitle, vPubDate;
        ImageView vImage;
        String vImageURL;
        Bitmap bitmap;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = mContext.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item, null);

            viewHolder = new ViewHolder();
            viewHolder.vTitle = (TextView)convertView.findViewById(R.id.title);
            viewHolder.vPubDate = (TextView)convertView.findViewById(R.id.pub_date);
            viewHolder.vImage = (ImageView)convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Post post = mObjects.get(position);
        if(post != null){
            viewHolder.vTitle.setText(post.Title);
            viewHolder.vPubDate.setText(post.PubDate);
            viewHolder.vImageURL = post.ImageURL;
            new DownloadAsyncTask().execute(viewHolder);
            //viewHolder.vImage.setBackgroundResource(R.drawable.android_icon);
        }
        return convertView;
    }

    private class DownloadAsyncTask extends AsyncTask<ViewHolder, Void, ViewHolder> {

        @Override
        protected ViewHolder doInBackground(ViewHolder... params) {
            // TODO Auto-generated method stub
            //load image directly
            ViewHolder viewHolder = params[0];
            try {
                URL imageURL = new URL(viewHolder.vImageURL);
                viewHolder.bitmap = BitmapFactory.decodeStream(imageURL.openStream());
            } catch (IOException e) {
                // TODO: handle exception
                Log.e("error", "Downloading Image Failed");
                viewHolder.bitmap = null;
            }

            return viewHolder;
        }

        @Override
        protected void onPostExecute(ViewHolder result) {
            // TODO Auto-generated method stub
            if (result.bitmap == null) {
                result.vImage.setImageResource(R.drawable.android_icon);
            } else {
                result.vImage.setImageBitmap(result.bitmap);
            }
        }
    }
}
