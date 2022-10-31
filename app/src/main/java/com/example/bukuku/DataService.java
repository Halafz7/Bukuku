package com.example.bukuku;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataService {

    public static final String QUERY_FOR_REGISTER = "https://bukuku.free.beeceptor.com";

    Context context;

    public DataService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String register);
    }

    public void String(String userName, VolleyResponseListener volleyResponseListener){
        String url = QUERY_FOR_REGISTER + userName;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String register = "";
                try {
                    JSONObject userInfo = response.getJSONObject(0);
                    register = userInfo.getString("usid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context, "register = " + register, Toast.LENGTH_SHORT).show();
                volleyResponseListener.onResponse(register);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Something Wrong", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something Wrong");
            }
        }
        );

        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
