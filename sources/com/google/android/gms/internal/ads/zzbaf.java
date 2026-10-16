package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbaf implements zzfyw {
    final /* synthetic */ zzfxb zza;

    zzbaf(zzbah zzbahVar, zzfxb zzfxbVar) {
        this.zza = zzfxbVar;
        Objects.requireNonNull(zzbahVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyw
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
