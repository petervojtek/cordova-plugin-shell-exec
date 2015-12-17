package org.apache.cordova.plugin;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShellExec extends CordovaPlugin {

@Override
public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("exec")) {
                Process p;
                StringBuffer output = new StringBuffer();
                int exitStatus = 100;
                try {
                        p = Runtime.getRuntime().exec((String) args.get(0));
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
                        String line = "";
                        while ((line = reader.readLine()) != null) {
                                output.append(line + "\n");
                                p.waitFor();
                        }
                        exitStatus = p.exitValue();
                }
                catch (IOException e) {
                        e.printStackTrace();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

                JSONObject json = new JSONObject();
                json.put("exitStatus", exitStatus);
                json.put("output", output.toString());
                callbackContext.success(json);
                return true;
        }
        return false;
}

}
