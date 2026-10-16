package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbmi f76403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbmi f76404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbmj f76405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f76406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f76407e;

    private zzbmh() {
        throw null;
    }

    public final zzbmh a(zzbmi zzbmiVar) {
        this.f76403a = zzbmiVar;
        return this;
    }

    public final zzbmh b(zzbmi zzbmiVar) {
        this.f76404b = zzbmiVar;
        return this;
    }

    public final zzbmh c(zzbmj zzbmjVar) {
        this.f76405c = zzbmjVar;
        return this;
    }

    public final zzbmh d(String str) {
        this.f76406d = str;
        return this;
    }

    public final zzbmh e(boolean z2) {
        this.f76407e = true;
        return this;
    }

    public final zzbml f() {
        return new zzbml(this.f76405c, this.f76406d, this.f76403a, this.f76404b, null, false, false, this.f76407e, null);
    }

    /* synthetic */ zzbmh(byte[] bArr) {
    }
}
