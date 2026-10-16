package ru.noties.markwon.image.network;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import ru.noties.markwon.image.ImageItem;
import ru.noties.markwon.image.SchemeHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class NetworkSchemeHandler extends SchemeHandler {
    static String b(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(59);
        return iIndexOf > -1 ? str.substring(0, iIndexOf) : str;
    }

    public static NetworkSchemeHandler c() {
        return new NetworkSchemeHandler();
    }

    @Override // ru.noties.markwon.image.SchemeHandler
    public ImageItem a(String str, Uri uri) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                return null;
            }
            return new ImageItem(b(httpURLConnection.getHeaderField("Content-Type")), new BufferedInputStream(httpURLConnection.getInputStream()));
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
