package com.qboxus.android.ApiClasses;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.qboxus.android.R;
import com.qboxus.android.interfaces.Callback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class ApiRequest {

    public static void Call_Api (final Activity context, final String url, JSONObject jsonObject,
                                 final Callback callback){


        if(!Variables.is_secure_info) {
            final String[] urlsplit = url.split("/");
            Log.d(Variables.tag, url);

            if (jsonObject != null)
                Log.d(Variables.tag + urlsplit[urlsplit.length - 1], jsonObject.toString());
        }

         JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, jsonObject,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if(!Variables.is_secure_info) {
                            final String[] urlsplit = url.split("/");
                            Log.d(Variables.tag + urlsplit[urlsplit.length - 1], response.toString());
                        }

                        if(callback!=null) {
                            callback.Responce(response.toString());
                        }



                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(!Variables.is_secure_info) {
                    final String[] urlsplit = url.split("/");
                    Log.d(Variables.tag + urlsplit[urlsplit.length - 1], error.toString());
                }

                if(callback!=null)
                  callback .Responce(error.toString());

            }
        }) {
             @Override
             public String getBodyContentType() {
                 return "application/json; charset=utf-8";
             }

             @Override
             public Map<String, String> getHeaders() throws AuthFailureError {
                 HashMap<String, String> headers = new HashMap<String, String>();
                 headers.put("Api-Key","156c4675-9608-4591-b2ec-427503464aac");
                 headers.put("User-Id",Variables.sharedPreferences.getString(Variables.u_id,null));
                 headers.put("Auth-Token", Variables.sharedPreferences.getString(Variables.auth_token,null));
                 Log.d(Variables.tag,headers.toString());
                 return headers;

             }
         };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjReq);

    }


    public static void Call_Api_GetRequest (final Activity context, final String url,
                                            final Callback callback){


        if(!Variables.is_secure_info) {
            final String[] urlsplit = url.split("/");
            Log.d(Variables.tag, url);

        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if(!Variables.is_secure_info) {
                            final String[] urlsplit = url.split("/");
                            Log.d(Variables.tag + urlsplit[urlsplit.length - 1], response.toString());
                        }

                        if(callback!=null) {
                            callback.Responce(response.toString());
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(!Variables.is_secure_info) {
                    final String[] urlsplit = url.split("/");
                    Log.d(Variables.tag + urlsplit[urlsplit.length - 1], error.toString());
                }

                if(callback!=null)
                    callback .Responce(error.toString());

            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Api-Key","156c4675-9608-4591-b2ec-427503464aac");
                headers.put("User-Id",Variables.sharedPreferences.getString(Variables.u_id,null));
                headers.put("Auth-Token", Variables.sharedPreferences.getString(Variables.auth_token,null));
                Log.d(Variables.tag,headers.toString());
                return headers;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjReq);

    }




}
