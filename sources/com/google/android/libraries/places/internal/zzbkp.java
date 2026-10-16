package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbkp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnp f76349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f76350b;

    /* synthetic */ zzbkp(zzbnp zzbnpVar, Object obj, zzbiy zzbiyVar, byte[] bArr) {
        this.f76349a = (zzbnp) Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        this.f76350b = obj;
    }

    public static zzbko c() {
        return new zzbko(null);
    }

    public final zzbnp a() {
        return this.f76349a;
    }

    public final Object b() {
        return this.f76350b;
    }
}
