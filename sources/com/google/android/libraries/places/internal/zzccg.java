package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzccg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f77545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f77546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f77547c;

    public zzccg(boolean z2) {
    }

    public final zzccg a(zzccf... zzccfVarArr) {
        String[] strArr = new String[zzccfVarArr.length];
        for (int i3 = 0; i3 < zzccfVarArr.length; i3++) {
            strArr[i3] = zzccfVarArr[i3].f77544a;
        }
        this.f77545a = strArr;
        return this;
    }

    public final zzccg b(String... strArr) {
        this.f77545a = strArr == null ? null : (String[]) strArr.clone();
        return this;
    }

    public final zzccg c(zzcct... zzcctVarArr) {
        String[] strArr = new String[zzcctVarArr.length];
        for (int i3 = 0; i3 < zzcctVarArr.length; i3++) {
            strArr[i3] = zzcctVarArr[i3].f77599a;
        }
        this.f77546b = strArr;
        return this;
    }

    public final zzccg d(String... strArr) {
        this.f77546b = strArr == null ? null : (String[]) strArr.clone();
        return this;
    }

    public final zzccg e(boolean z2) {
        this.f77547c = true;
        return this;
    }

    public final zzcch f() {
        return new zzcch(this, null);
    }

    final /* synthetic */ String[] g() {
        return this.f77545a;
    }

    final /* synthetic */ String[] h() {
        return this.f77546b;
    }

    final /* synthetic */ boolean i() {
        return this.f77547c;
    }

    public zzccg(zzcch zzcchVar) {
        boolean z2 = zzcchVar.f77550a;
        this.f77545a = zzcchVar.c();
        this.f77546b = zzcchVar.d();
        this.f77547c = zzcchVar.f77553d;
    }
}
