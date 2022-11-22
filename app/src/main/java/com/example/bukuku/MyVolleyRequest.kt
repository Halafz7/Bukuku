package com.example.bukuku

import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.JsonObjectRequest
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
        val getRequest = JsonObjectRequest(Request.Method.GET,url,null,Response.Listener { response ->
            iVolley!!.onResponse(response.toString())
        },Response.ErrorListener { error ->
            iVolley!!.onResponse(error.message!!)
        })

        addToRequestQueue(getRequest)
    }

    //POST METHOD dengan Params
    fun postRequest(url: String, username: String, password: String){
        val url = "https://bejobarokah.my.id:8443/auth/test"

        val postRequest = object :StringRequest(Request.Method.POST,url,
        Response.Listener { response ->
            iVolley!!.onResponse(response.toString())
        },Response.ErrorListener { error -> iVolley!!.onResponse(error.message!!) })

        {
            //Ctrl +O
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params.put("username", username)
                params.put("password", password)
                return params
            }
            override fun getBodyContentType(): String {
                return "application/json"
            }
        }
                addToRequestQueue(postRequest)
    }

    fun postRegisterRequest(url: String, username: String, email: String, password: String){
        val url = "https://bejobarokah.my.id:8443/auth/register"

        var jsonObject = JSONObject()
        jsonObject.put("username", username)
        jsonObject.put("email", email)
        jsonObject.put("password", password)

        val postRequest = JsonObjectRequest(Request.Method.POST,url, jsonObject,
            Response.Listener { response ->
                iVolley!!.onResponse(response.toString())
            }, Response.ErrorListener { error ->
                try{
                    iVolley!!.onResponse(error.message!!)
                }catch (e:Exception){
                } })
        addToRequestQueue(postRequest)
    }

    //PUT METHOD dengan Params
    fun putRequest(url: String){
        val putRequest = object :StringRequest(Request.Method.PUT,url,
            Response.Listener { response ->
                iVolley!!.onResponse(response.toString())
            },Response.ErrorListener { error -> iVolley!!.onResponse(error.message!!) })
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
    fun patchRequest(url: String){
        val patchRequest = object :StringRequest(Request.Method.PATCH,url,
            Response.Listener { response ->
                iVolley!!.onResponse(response.toString())
            },Response.ErrorListener { error -> iVolley!!.onResponse(error.message!!) })
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
        val deleteRequest = StringRequest(Request.Method.DELETE,url,Response.Listener { response ->
            iVolley!!.onResponse(response)
        },Response.ErrorListener { error -> iVolley!!.onResponse(error.message!!) })

        addToRequestQueue(deleteRequest)
    }

    companion object{
        private var mInstance : MyVolleyRequest? = null
        @Synchronized
        fun getInstance(context: Context, iVolley: IVolley): MyVolleyRequest{
            if(mInstance == null){
                mInstance = MyVolleyRequest(context,iVolley)
            }
            return mInstance!!
        }
    }

}
