package com.google.android.gms.common;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzy {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzy f72367e = new zzy(true, 3, 1, null, null, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f72368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f72369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Throwable f72370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f72371d;

    private zzy(boolean z2, int i3, int i4, String str, Throwable th, long j3) {
        this.f72368a = z2;
        this.f72371d = i3;
        this.f72369b = str;
        this.f72370c = th;
    }

    static zzy b() {
        return f72367e;
    }

    static zzy c(String str) {
        return new zzy(false, 1, 5, str, null, -1L);
    }

    static zzy d(String str, Throwable th) {
        return new zzy(false, 1, 5, str, th, -1L);
    }

    public static zzy f(int i3, long j3) {
        return new zzy(true, i3, 1, null, null, j3);
    }

    static zzy g(int i3, int i4, String str, Throwable th) {
        return new zzy(false, i3, i4, str, th, -1L);
    }

    String a() {
        return this.f72369b;
    }

    final void e() {
        if (this.f72368a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        Throwable th = this.f72370c;
        if (th != null) {
            Log.d("GoogleCertificatesRslt", a(), th);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }

    /* synthetic */ zzy(boolean z2, int i3, int i4, String str, Throwable th, long j3, byte[] bArr) {
        this(false, 1, 5, null, null, -1L);
    }
}
