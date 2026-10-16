package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f76348a;

    private zzbko() {
        throw null;
    }

    public final zzbko a(Object obj) {
        this.f76348a = Preconditions.u(obj, "config");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzbkp b() {
        Preconditions.A(this.f76348a != null, "config is not set");
        return new zzbkp(zzbnp.f76488e, this.f76348a, null, 0 == true ? 1 : 0);
    }

    /* synthetic */ zzbko(byte[] bArr) {
    }
}
