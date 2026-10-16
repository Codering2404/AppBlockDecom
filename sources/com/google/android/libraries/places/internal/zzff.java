package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzff implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbih f77813a;

    private zzff(zzbih zzbihVar) {
        this.f77813a = zzbihVar;
    }

    public static zzff b(zzbih zzbihVar) {
        return new zzff(zzbihVar);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ImmutableList zzb() {
        ImmutableList immutableListT = ImmutableList.t(((zzbik) this.f77813a).zzb());
        zzbig.a(immutableListT);
        return immutableListT;
    }
}
