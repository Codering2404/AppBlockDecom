package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzblk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f76375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbio f76376b = zzbio.f76249c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f76377c;

    zzblk() {
    }

    public final zzblk a(List list) {
        this.f76375a = list;
        return this;
    }

    public final zzblk b(zzbio zzbioVar) {
        this.f76376b = zzbioVar;
        return this;
    }

    public final zzblk c(Object obj) {
        this.f76377c = obj;
        return this;
    }

    public final zzbll d() {
        return new zzbll(this.f76375a, this.f76376b, this.f76377c, null);
    }
}
