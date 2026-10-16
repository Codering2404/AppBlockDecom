package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f56936a;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.f56936a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String B0() {
        return this.f56936a.getContentType();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public InputStream I0() {
        return this.f56936a.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f56936a.disconnect();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        try {
            return this.f56936a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String p() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f56936a.getURL() + ". Failed with " + this.f56936a.getResponseCode() + "\n" + a(this.f56936a);
        } catch (IOException e3) {
            Logger.d("get error failed ", e3);
            return e3.getMessage();
        }
    }
}
