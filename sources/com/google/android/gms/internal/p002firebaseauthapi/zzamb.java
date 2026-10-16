package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamb implements zzamj {
    private zzamj[] zza;

    zzamb(zzamj... zzamjVarArr) {
        this.zza = zzamjVarArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamj
    public final zzamk zza(Class<?> cls) {
        for (zzamj zzamjVar : this.zza) {
            if (zzamjVar.zzb(cls)) {
                return zzamjVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamj
    public final boolean zzb(Class<?> cls) {
        for (zzamj zzamjVar : this.zza) {
            if (zzamjVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
