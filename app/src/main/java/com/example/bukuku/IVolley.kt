package com.example.bukuku

import com.android.volley.VolleyError
import org.json.JSONArray
import org.json.JSONObject

interface IVolley {
    fun onResponse(response:JSONObject)
    fun onArrayResponse(response: JSONArray)
    fun onErrorResponse(error: VolleyError)
}