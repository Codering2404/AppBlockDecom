package com.squareup.okhttp.internal.http;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RequestException extends Exception {
    @Override // java.lang.Throwable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
