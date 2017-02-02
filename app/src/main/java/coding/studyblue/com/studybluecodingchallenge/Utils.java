package coding.studyblue.com.studybluecodingchallenge;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {


    public boolean isOnline(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }

    public boolean isWifiConnection(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public boolean isCellularConnection(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info.getType() == ConnectivityManager.TYPE_MOBILE;
    }
}
