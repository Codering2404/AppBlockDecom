package com.squareup.okhttp;

import java.io.Closeable;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: com.squareup.okhttp.ResponseBody$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass1 extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f93036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BufferedSource f93037b;

        @Override // com.squareup.okhttp.ResponseBody
        public long a() {
            return this.f93036a;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource b() {
            return this.f93037b;
        }
    }

    public abstract long a();

    public abstract BufferedSource b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b().close();
    }
}
