package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaad extends ThreadLocal<Mac> {
    private final /* synthetic */ zzaae zza;

    zzaad(zzaae zzaaeVar) {
        Objects.requireNonNull(zzaaeVar);
        this.zza = zzaaeVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            Mac macZza = zzzj.zzb.zza(this.zza.zzc);
            macZza.init(this.zza.zzd);
            return macZza;
        } catch (GeneralSecurityException e3) {
            throw new IllegalStateException(e3);
        }
    }
}
