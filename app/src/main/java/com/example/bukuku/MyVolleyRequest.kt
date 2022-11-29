package com.example.bukuku

import android.content.Context
import android.graphics.Bitmap
import android.util.Base64
import android.util.LruCache
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MyVolleyRequest {
    private var mRequestQueue:RequestQueue?=null
    private var context:Context?=null
    private var iVolley:IVolley?=null
    var imageLoader:ImageLoader?=null
        private set

    val requestQueue:RequestQueue
        get() {
            if (mRequestQueue == null)
                mRequestQueue = Volley.newRequestQueue(context!!.applicationContext)
            return mRequestQueue!!

        }

    private constructor(context: Context,iVolley: IVolley){
        this.context = context
        this.iVolley = iVolley
        mRequestQueue = requestQueue
        this.imageLoader = ImageLoader(mRequestQueue, object:ImageLoader.ImageCache{
            private val mCache = LruCache<String,Bitmap>(10)
            override fun getBitmap(url: String?): Bitmap? {
                return mCache.get(url)
            }

            override fun putBitmap(url: String?, bitmap: Bitmap?) {
                mCache.put(url, bitmap)
            }

        })
    }

    private constructor(context: Context){
        this.context = context
        this.iVolley = iVolley
        mRequestQueue = requestQueue
        this.imageLoader = ImageLoader(mRequestQueue, object:ImageLoader.ImageCache{
            private val mCache = LruCache<String,Bitmap>(10)
            override fun getBitmap(url: String?): Bitmap? {
                return mCache.get(url)
            }

            override fun putBitmap(url: String?, bitmap: Bitmap?) {
                mCache.put(url, bitmap)
            }

        })
    }

    fun<T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req);
    }

    //GET METHOD
    fun getRequest(url:String){
        val getRequest = object: JsonObjectRequest(Request.Method.GET,url,null, { response ->
            iVolley!!.onResponse(response)
        }, { error ->
            iVolley!!.onErrorResponse(error)
        })
        {
            override fun getHeaders(): MutableMap<String, String> {
                var pref = context!!.applicationContext.getSharedPreferences("BUKUKU_APP", Context.MODE_PRIVATE)
                var token = pref.getString("token", null)
                var headers = HashMap<String, String>()
                headers.put("Authorization", "Bearer " + token)
                return headers
            }
        }

        addToRequestQueue(getRequest)
    }

    fun getArrayRequest(url:String){
        val getRequest = object: JsonArrayRequest(Request.Method.GET,url,null, { response ->
            iVolley!!.onArrayResponse(response)
        }, { error ->
            iVolley!!.onErrorResponse(error)
        })
        {
            override fun getHeaders(): MutableMap<String, String> {
                var pref = context!!.applicationContext.getSharedPreferences("BUKUKU_APP", Context.MODE_PRIVATE)
                var token = pref.getString("token", null)
                var headers = HashMap<String, String>()
                headers.put("Authorization", "Bearer " + token)
                return headers
            }
        }

        addToRequestQueue(getRequest)
    }

    //POST METHOD dengan Params
    fun postRequest(url: String, jsonObject: JSONObject){
        val postRequest = object: JsonObjectRequest(Request.Method.POST,url, jsonObject,
            { response ->
                iVolley!!.onResponse(response)
            }, { error ->
                iVolley!!.onErrorResponse(error)
            })
        {
            override fun getHeaders(): MutableMap<String, String> {
                var pref = context!!.applicationContext.getSharedPreferences("BUKUKU_APP", Context.MODE_PRIVATE)
                var token = pref.getString("token", null)
                var headers = HashMap<String, String>()
                headers.put("Authorization", "Bearer " + token)
                return headers
            }
        }
        postRequest.setRetryPolicy(DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT))

        addToRequestQueue(postRequest)
    }

    fun registerRequest(url: String, jsonObject: JSONObject){
        val registerRequest = JsonObjectRequest(Request.Method.POST,url, jsonObject,
            { response ->
                iVolley!!.onResponse(response)
            }, { error ->
                iVolley!!.onErrorResponse(error)
            })
        registerRequest.setRetryPolicy(DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT))

        addToRequestQueue(registerRequest)
    }

    fun authRequest(url: String, username: String, password: String){
        val authRequest = object: JsonObjectRequest(Request.Method.POST, url, null,
            {response -> iVolley!!.onResponse(response)},
            {error -> iVolley!!.onErrorResponse(error)})
        {
            override fun getHeaders(): MutableMap<String, String> {
                var credentials = username+":"+password
                var base64EncodedCredentials = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
                var headers = HashMap<String, String>()
                headers.put("Authorization", "Basic " + base64EncodedCredentials)
                return headers
            }
        }
        authRequest.setRetryPolicy(DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT))

        addToRequestQueue(authRequest)
    }

    //PUT METHOD dengan Params
    fun putRequest(url: String, jsonObject: JSONObject){
        val putRequest = object :JsonObjectRequest(Request.Method.PUT,url,jsonObject,
            Response.Listener { response ->
                iVolley!!.onResponse(response)
            },Response.ErrorListener { error -> iVolley!!.onErrorResponse(error) })
        {
            //Ctrl +O
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["name"] = "Afif"
                params["value"] = "Coba-coba PUT"
                return params
            }
        }
        addToRequestQueue(putRequest)
    }

    //PATCH METHOD dengan Params
    fun patchRequest(url: String, jsonObject: JSONObject){
        val patchRequest = object :JsonObjectRequest(Request.Method.PATCH,url,jsonObject,
            Response.Listener { response ->
                iVolley!!.onResponse(response)
            },Response.ErrorListener { error -> iVolley!!.onErrorResponse(error) })
        {
            //Ctrl +O
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["name"] = "Afif"
                params["value"] = "Coba-coba PATCH"
                return params
            }
        }
        addToRequestQueue(patchRequest)
    }

    //DELETE METHOD
    fun deleteRequest(url: String){
        val deleteRequest = object: JsonObjectRequest(Request.Method.DELETE,url,null,
            { response ->
            iVolley!!.onResponse(response)
        }, { error -> iVolley!!.onErrorResponse(error) })
        {
            override fun getHeaders(): MutableMap<String, String> {
                var pref = context!!.applicationContext.getSharedPreferences("BUKUKU_APP", Context.MODE_PRIVATE)
                var token = pref.getString("token", null)
                var headers = HashMap<String, String>()
                headers.put("Authorization", "Bearer " + token)
                return headers
            }
        }

        addToRequestQueue(deleteRequest)
    }

    companion object{
        private var mInstance : MyVolleyRequest? = null
        @Synchronized
        fun getInstance(context: Context, iVolley: IVolley): MyVolleyRequest{
//            if(mInstance == null){
            mInstance = MyVolleyRequest(context,iVolley)
//            }
            return mInstance!!
        }
    }

}
