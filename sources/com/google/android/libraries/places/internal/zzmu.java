package com.google.android.libraries.places.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzmu implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbih f78223a;

    private zzmu(zzbih zzbihVar, zzbih zzbihVar2) {
        this.f78223a = zzbihVar;
    }

    public static zzmu a(zzbih zzbihVar, zzbih zzbihVar2) {
        return new zzmu(zzbihVar, zzbihVar2);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzex((Context) this.f78223a.zzb(), zzeq.b());
    }
}
