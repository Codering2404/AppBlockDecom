package com.android.volley.toolbox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f57791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f57792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f57793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputStream f57794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f57795e;

    public HttpResponse(int i3, List list) {
        this(i3, list, -1, null);
    }

    public final InputStream a() {
        InputStream inputStream = this.f57794d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f57795e != null) {
            return new ByteArrayInputStream(this.f57795e);
        }
        return null;
    }

    public final int b() {
        return this.f57793c;
    }

    public final List c() {
        return Collections.unmodifiableList(this.f57792b);
    }

    public final int d() {
        return this.f57791a;
    }

    public HttpResponse(int i3, List list, int i4, InputStream inputStream) {
        this.f57791a = i3;
        this.f57792b = list;
        this.f57793c = i4;
        this.f57794d = inputStream;
        this.f57795e = null;
    }
}
