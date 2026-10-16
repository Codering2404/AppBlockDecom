package com.bumptech.glide.load;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpException extends IOException {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f66234a;

    public HttpException(int i3) {
        this("Http request failed", i3);
    }

    public HttpException(String str, int i3) {
        this(str, i3, null);
    }

    public HttpException(String str, int i3, Throwable th) {
        super(str + ", status code: " + i3, th);
        this.f66234a = i3;
    }
}
