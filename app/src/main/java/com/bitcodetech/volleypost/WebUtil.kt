package com.bitcodetech.volleypost

import android.content.Context
import android.util.Log
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class WebUtil(
    val context: Context
) {

    val requestQueue : RequestQueue
    init {
        requestQueue = Volley.newRequestQueue(context)
    }

    fun postNameAndJob(
        name :String,
        job : String
    ) {

        val inputJSONObject = JSONObject()
        inputJSONObject.put("name", name)
        inputJSONObject.put("job", job)

        /*val jsonObjectRequest = JsonObjectRequest(
            Method.POST,
            "https://reqres.in/api/users",
            inputJSONObject,
            object : Response.Listener<JSONObject> {
                override fun onResponse(response: JSONObject?) {
                    Log.e("tag", response.toString())
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    TODO("Not yet implemented")
                }
            }
        )*/

        val jsonObjectRequest = object : StringRequest(
            Method.POST,
            "https://reqres.in/api/users",
            object : Response.Listener<String> {
                override fun onResponse(response: String?) {
                    Log.e("tag", response.toString())
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    TODO("Not yet implemented")
                }
            }
        ) {
            /*override fun getHeaders(): MutableMap<String, String> {
                return super.getHeaders()
            }*/

            override fun getParams(): MutableMap<String, String>? {
                val map = HashMap<String, String>()
                map.put("name", "ABCD")
                map.put("job", "dev")
                return map
            }
        }

        requestQueue.add(jsonObjectRequest)

    }
}