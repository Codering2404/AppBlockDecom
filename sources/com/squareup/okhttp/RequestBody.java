package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class RequestBody {

    /* JADX INFO: renamed from: com.squareup.okhttp.RequestBody$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass1 extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaType f93007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ByteString f93008b;

        @Override // com.squareup.okhttp.RequestBody
        public long a() {
            return this.f93008b.C();
        }

        @Override // com.squareup.okhttp.RequestBody
        public MediaType b() {
            return this.f93007a;
        }

        @Override // com.squareup.okhttp.RequestBody
        public void c(BufferedSink bufferedSink) {
            bufferedSink.q2(this.f93008b);
        }
    }

    /* JADX INFO: renamed from: com.squareup.okhttp.RequestBody$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass2 extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaType f93009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f93010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f93011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f93012d;

        @Override // com.squareup.okhttp.RequestBody
        public long a() {
            return this.f93010b;
        }

        @Override // com.squareup.okhttp.RequestBody
        public MediaType b() {
            return this.f93009a;
        }

        @Override // com.squareup.okhttp.RequestBody
        public void c(BufferedSink bufferedSink) {
            bufferedSink.write(this.f93011c, this.f93012d, this.f93010b);
        }
    }

    /* JADX INFO: renamed from: com.squareup.okhttp.RequestBody$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass3 extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaType f93013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f93014b;

        @Override // com.squareup.okhttp.RequestBody
        public long a() {
            return this.f93014b.length();
        }

        @Override // com.squareup.okhttp.RequestBody
        public MediaType b() {
            return this.f93013a;
        }

        @Override // com.squareup.okhttp.RequestBody
        public void c(BufferedSink bufferedSink) {
            Source sourceK = null;
            try {
                sourceK = Okio.k(this.f93014b);
                bufferedSink.K0(sourceK);
            } finally {
                Util.c(sourceK);
            }
        }
    }

    public long a() {
        return -1L;
    }

    public abstract MediaType b();

    public abstract void c(BufferedSink bufferedSink);
}
