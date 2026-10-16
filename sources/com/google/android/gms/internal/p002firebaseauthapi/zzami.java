package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzami implements zzamf {
    zzami() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final int zza(int i3, Object obj, Object obj2) {
        zzamg zzamgVar = (zzamg) obj;
        if (zzamgVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzamgVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Object zzb(Object obj) {
        return zzamg.zza().zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Object zzc(Object obj) {
        ((zzamg) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Map<?, ?> zzd(Object obj) {
        return (zzamg) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Map<?, ?> zze(Object obj) {
        return (zzamg) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final boolean zzf(Object obj) {
        return !((zzamg) obj).zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final zzamd<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Object zza(Object obj, Object obj2) {
        zzamg zzamgVarZzb = (zzamg) obj;
        zzamg zzamgVar = (zzamg) obj2;
        if (!zzamgVar.isEmpty()) {
            if (!zzamgVarZzb.zzd()) {
                zzamgVarZzb = zzamgVarZzb.zzb();
            }
            zzamgVarZzb.zza(zzamgVar);
        }
        return zzamgVarZzb;
    }
}
