package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzfrt;
import com.google.android.gms.internal.ads.zzfru;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbt extends zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.util.client.zzu f70293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.util.client.zzv f70295c;

    public zzbt(Context context, String str, String str2, zzfru zzfruVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.f70293a = new com.google.android.gms.ads.internal.util.client.zzu(context, com.google.android.gms.ads.internal.zzt.g().P(context, str));
        this.f70294b = str2;
        this.f70295c = zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.f70295c;
        if (zzvVar == null) {
            this.f70293a.b(this.f70294b, null);
        } else {
            new zzfrt(zzvVar.a(), this.f70293a, zzcfr.zze, null, null).zza(this.f70294b);
        }
    }
}
