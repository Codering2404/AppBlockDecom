package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcdo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzcdn f77680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzccj f77681b = new zzccj();

    public final zzcdo a(zzcdn zzcdnVar) {
        this.f77680a = zzcdnVar;
        return this;
    }

    public final zzcdo b(String str, String str2) {
        this.f77681b.a(str, str2);
        return this;
    }

    public final zzcdp c() {
        if (this.f77680a != null) {
            return new zzcdp(this, null);
        }
        throw new IllegalStateException("url == null");
    }

    final /* synthetic */ zzcdn d() {
        return this.f77680a;
    }

    final /* synthetic */ zzccj e() {
        return this.f77681b;
    }
}
