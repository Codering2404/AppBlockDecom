package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class NetworkUtility {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RetryInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final VolleyError f57848b;

        private RetryInfo(String str, VolleyError volleyError) {
            this.f57847a = str;
            this.f57848b = volleyError;
        }
    }

    static void a(Request request, RetryInfo retryInfo) {
        RetryPolicy retryPolicyW = request.w();
        int iX = request.x();
        try {
            retryPolicyW.b(retryInfo.f57848b);
            request.b(String.format("%s-retry [timeout=%s]", retryInfo.f57847a, Integer.valueOf(iX)));
        } catch (VolleyError e3) {
            request.b(String.format("%s-timeout-giveup [timeout=%s]", retryInfo.f57847a, Integer.valueOf(iX)));
            throw e3;
        }
    }

    static NetworkResponse b(Request request, long j3, List list) {
        Cache.Entry entryL = request.l();
        if (entryL == null) {
            return new NetworkResponse(RCHTTPStatusCodes.NOT_MODIFIED, (byte[]) null, true, j3, list);
        }
        return new NetworkResponse(RCHTTPStatusCodes.NOT_MODIFIED, entryL.f57642a, true, j3, HttpHeaderParser.a(list, entryL));
    }

    static byte[] c(InputStream inputStream, int i3, ByteArrayPool byteArrayPool) throws Throwable {
        byte[] bArrA;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(byteArrayPool, i3);
        try {
            bArrA = byteArrayPool.a(1024);
            while (true) {
                try {
                    int i4 = inputStream.read(bArrA);
                    if (i4 == -1) {
                        break;
                    }
                    poolingByteArrayOutputStream.write(bArrA, 0, i4);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            VolleyLog.e("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    byteArrayPool.b(bArrA);
                    poolingByteArrayOutputStream.close();
                    throw th;
                }
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                VolleyLog.e("Error occurred when closing InputStream", new Object[0]);
            }
            byteArrayPool.b(bArrA);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }

    static void d(long j3, Request request, byte[] bArr, int i3) {
        if (VolleyLog.f57725b || j3 > 3000) {
            VolleyLog.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, Long.valueOf(j3), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i3), Integer.valueOf(request.w().a()));
        }
    }

    static RetryInfo e(Request request, IOException iOException, long j3, HttpResponse httpResponse, byte[] bArr) throws ServerError, NoConnectionError {
        if (iOException instanceof SocketTimeoutException) {
            return new RetryInfo("socket", new TimeoutError());
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + request.z(), iOException);
        }
        if (httpResponse == null) {
            if (!request.T()) {
                throw new NoConnectionError(iOException);
            }
            return new RetryInfo("connection", new NoConnectionError());
        }
        int iD = httpResponse.d();
        VolleyLog.c("Unexpected response code %d for %s", Integer.valueOf(iD), request.z());
        if (bArr == null) {
            return new RetryInfo("network", new NetworkError());
        }
        NetworkResponse networkResponse = new NetworkResponse(iD, bArr, false, SystemClock.elapsedRealtime() - j3, httpResponse.c());
        if (iD == 401 || iD == 403) {
            return new RetryInfo("auth", new AuthFailureError(networkResponse));
        }
        if (iD >= 400 && iD <= 499) {
            throw new ClientError(networkResponse);
        }
        if (iD < 500 || iD > 599 || !request.U()) {
            throw new ServerError(networkResponse);
        }
        return new RetryInfo("server", new ServerError(networkResponse));
    }
}
