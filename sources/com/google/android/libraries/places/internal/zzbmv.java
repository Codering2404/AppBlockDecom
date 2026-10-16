package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbnr f76445a = zzbnr.a(Collections.EMPTY_LIST);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbio f76446b = zzbio.f76249c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbms f76447c;

    zzbmv() {
    }

    public final zzbmv a(zzbnr zzbnrVar) {
        this.f76445a = (zzbnr) Preconditions.u(zzbnrVar, "StatusOr addresses cannot be null.");
        return this;
    }

    public final zzbmv b(zzbms zzbmsVar) {
        this.f76447c = zzbmsVar;
        return this;
    }

    public final zzbmw c() {
        return new zzbmw(this.f76445a, this.f76446b, this.f76447c);
    }
}
