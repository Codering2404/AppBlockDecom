package com.google.android.gms.internal.ads;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaft {
    private final zzafs zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzaft(zzafs zzafsVar) {
        this.zza = zzafsVar;
    }

    public final zzafy zza(Object... objArr) {
        Constructor constructorZza;
        AtomicBoolean atomicBoolean = this.zzb;
        synchronized (atomicBoolean) {
            if (!atomicBoolean.get()) {
                try {
                    constructorZza = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                    constructorZza = null;
                } catch (Exception e3) {
                    throw new RuntimeException("Error instantiating extension", e3);
                }
            }
            constructorZza = null;
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzafy) constructorZza.newInstance(objArr);
        } catch (Exception e4) {
            throw new IllegalStateException(pMpIcGE.dubuqk, e4);
        }
    }
}
