package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import okio.Sink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface HttpStream {
    void a();

    Sink b(Request request, long j3);

    void c(Request request);

    void d(RetryableSink retryableSink);

    Response.Builder e();

    ResponseBody f(Response response);

    void g(HttpEngine httpEngine);
}
