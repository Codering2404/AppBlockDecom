package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbis f76269a = zzbis.f76259h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f76270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f76271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f76272d;

    zzbjc() {
    }

    public final zzbjc a(zzbis zzbisVar) {
        this.f76269a = (zzbis) Preconditions.u(zzbisVar, "callOptions cannot be null");
        return this;
    }

    public final zzbjc b(int i3) {
        this.f76270b = i3;
        return this;
    }

    public final zzbjc c(boolean z2) {
        this.f76271c = z2;
        return this;
    }

    public final zzbjc d(boolean z2) {
        this.f76272d = z2;
        return this;
    }

    public final zzbjd e() {
        return new zzbjd(this.f76269a, this.f76270b, this.f76271c, this.f76272d);
    }
}
