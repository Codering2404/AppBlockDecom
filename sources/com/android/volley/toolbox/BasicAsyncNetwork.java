package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AsyncNetwork;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.AsyncHttpStack;
import com.android.volley.toolbox.NetworkUtility;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BasicAsyncNetwork extends AsyncNetwork {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AsyncHttpStack f57747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ByteArrayPool f57748e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class InvokeRetryPolicyTask<T> extends RequestTask<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Request f57753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final NetworkUtility.RetryInfo f57754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AsyncNetwork.OnRequestComplete f57755d;

        InvokeRetryPolicyTask(Request request, NetworkUtility.RetryInfo retryInfo, AsyncNetwork.OnRequestComplete onRequestComplete) {
            super(request);
            this.f57753b = request;
            this.f57754c = retryInfo;
            this.f57755d = onRequestComplete;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NetworkUtility.a(this.f57753b, this.f57754c);
                BasicAsyncNetwork.this.c(this.f57753b, this.f57755d);
            } catch (VolleyError e3) {
                this.f57755d.a(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ResponseParsingTask<T> extends RequestTask<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        InputStream f57757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        HttpResponse f57758c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Request f57759d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        AsyncNetwork.OnRequestComplete f57760f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f57761g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        List f57762h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f57763i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ BasicAsyncNetwork f57764j;

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                this.f57764j.k(this.f57761g, this.f57763i, this.f57758c, this.f57759d, this.f57760f, this.f57762h, NetworkUtility.c(this.f57757b, this.f57758c.b(), this.f57764j.f57748e));
            } catch (IOException e3) {
                this.f57764j.j(this.f57759d, this.f57760f, e3, this.f57761g, this.f57758c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Request request, AsyncNetwork.OnRequestComplete onRequestComplete, IOException iOException, long j3, HttpResponse httpResponse, byte[] bArr) {
        try {
            b().execute(new InvokeRetryPolicyTask(request, NetworkUtility.e(request, iOException, j3, httpResponse, bArr), onRequestComplete));
        } catch (VolleyError e3) {
            onRequestComplete.a(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j3, int i3, HttpResponse httpResponse, Request request, AsyncNetwork.OnRequestComplete onRequestComplete, List list, byte[] bArr) {
        NetworkUtility.d(SystemClock.elapsedRealtime() - j3, request, bArr, i3);
        if (i3 < 200 || i3 > 299) {
            j(request, onRequestComplete, new IOException(), j3, httpResponse, bArr);
        } else {
            onRequestComplete.b(new NetworkResponse(i3, bArr, false, SystemClock.elapsedRealtime() - j3, list));
        }
    }

    @Override // com.android.volley.AsyncNetwork
    public void c(final Request request, final AsyncNetwork.OnRequestComplete onRequestComplete) {
        if (b() == null) {
            throw new IllegalStateException("mBlockingExecuter must be set before making a request");
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f57747d.c(request, HttpHeaderParser.c(request.l()), new AsyncHttpStack.OnRequestComplete() { // from class: com.android.volley.toolbox.BasicAsyncNetwork.1
        });
    }

    @Override // com.android.volley.AsyncNetwork
    public void d(ExecutorService executorService) {
        super.d(executorService);
        this.f57747d.d(executorService);
    }

    @Override // com.android.volley.AsyncNetwork
    public void e(ExecutorService executorService) {
        super.e(executorService);
        this.f57747d.e(executorService);
    }
}
