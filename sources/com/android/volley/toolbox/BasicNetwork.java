package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BasicNetwork implements Network {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HttpStack f57765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BaseHttpStack f57766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final ByteArrayPool f57767c;

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    @Override // com.android.volley.Network
    public NetworkResponse a(Request request) {
        IOException iOException;
        HttpResponse httpResponse;
        byte[] bArr;
        Request request2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            try {
                HttpResponse httpResponseB = this.f57766b.b(request, HttpHeaderParser.c(request.l()));
                try {
                    int iD = httpResponseB.d();
                    List listC = httpResponseB.c();
                    if (iD == 304) {
                        return NetworkUtility.b(request, SystemClock.elapsedRealtime() - jElapsedRealtime, listC);
                    }
                    InputStream inputStreamA = httpResponseB.a();
                    byte[] bArrC = inputStreamA != null ? NetworkUtility.c(inputStreamA, httpResponseB.b(), this.f57767c) : new byte[0];
                    try {
                        NetworkUtility.d(SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArrC, iD);
                        if (iD < 200 || iD > 299) {
                            throw new IOException();
                        }
                        return new NetworkResponse(iD, bArrC, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listC);
                    } catch (IOException e3) {
                        e = e3;
                        request2 = request;
                        httpResponse = httpResponseB;
                        bArr = bArrC;
                        iOException = e;
                        NetworkUtility.a(request2, NetworkUtility.e(request2, iOException, jElapsedRealtime, httpResponse, bArr));
                        request = request2;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bArr = null;
                    httpResponse = httpResponseB;
                    request2 = request;
                }
            } catch (IOException e5) {
                iOException = e5;
                httpResponse = null;
                bArr = null;
                request2 = request;
            }
            NetworkUtility.a(request2, NetworkUtility.e(request2, iOException, jElapsedRealtime, httpResponse, bArr));
            request = request2;
        }
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.f57766b = baseHttpStack;
        this.f57765a = baseHttpStack;
        this.f57767c = byteArrayPool;
    }
}
