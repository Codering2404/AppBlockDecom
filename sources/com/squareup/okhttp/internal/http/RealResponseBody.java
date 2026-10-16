package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RealResponseBody extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Headers f93402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BufferedSource f93403b;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.f93402a = headers;
        this.f93403b = bufferedSource;
    }

    @Override // com.squareup.okhttp.ResponseBody
    public long a() {
        return OkHeaders.c(this.f93402a);
    }

    @Override // com.squareup.okhttp.ResponseBody
    public BufferedSource b() {
        return this.f93403b;
    }
}
