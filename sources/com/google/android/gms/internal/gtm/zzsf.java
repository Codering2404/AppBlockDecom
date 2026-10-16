package com.google.android.gms.internal.gtm;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsf implements zzsg {
    private HttpURLConnection zza;
    private InputStream zzb = null;

    zzsf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzsg
    public final InputStream zza(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zza = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzb = inputStream;
            return inputStream;
        }
        String str2 = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(str2);
        }
        if (responseCode == 503) {
            throw new zzsi(str2);
        }
        throw new IOException(str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzsg
    public final void zzb() {
        HttpURLConnection httpURLConnection = this.zza;
        try {
            InputStream inputStream = this.zzb;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e3) {
            Log.e("GoogleTagManager", "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(String.valueOf(e3.getMessage())), e3);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
