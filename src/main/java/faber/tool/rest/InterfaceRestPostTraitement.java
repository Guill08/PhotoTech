package faber.tool.rest;

import org.json.JSONObject;

/*
RSI
16/02/2024
14:48
*/public interface InterfaceRestPostTraitement {
     void postTraitement(JSONObject json);
     void postTraitement();
     void postTraitement(String valeur);

}
