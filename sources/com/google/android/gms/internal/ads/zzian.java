package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzian extends ThreadLocal {
    final /* synthetic */ zziao zza;

    zzian(zziao zziaoVar) {
        Objects.requireNonNull(zziaoVar);
        this.zza = zziaoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            zzhzz zzhzzVar = zzhzz.zzb;
            zziao zziaoVar = this.zza;
            Mac mac = (Mac) zzhzzVar.zzb(zziaoVar.zzb());
            mac.init(zziaoVar.zzc());
            return mac;
        } catch (GeneralSecurityException e3) {
            throw new IllegalStateException(e3);
        }
    }
}
