package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalv implements zzalw {
    zzalv() {
    }

    private static <E> zzalm<E> zzc(Object obj, long j3) {
        return (zzalm) zzanz.zze(obj, j3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalw
    public final <L> List<L> zza(Object obj, long j3) {
        zzalm zzalmVarZzc = zzc(obj, j3);
        if (zzalmVarZzc.zzc()) {
            return zzalmVarZzc;
        }
        int size = zzalmVarZzc.size();
        zzalm zzalmVarZza = zzalmVarZzc.zza(size == 0 ? 10 : size << 1);
        zzanz.zza(obj, j3, zzalmVarZza);
        return zzalmVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalw
    public final void zzb(Object obj, long j3) {
        zzc(obj, j3).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.firebase-auth-api.zzalm, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalw
    public final <E> void zza(Object obj, Object obj2, long j3) {
        zzalm zzalmVarZzc = zzc(obj, j3);
        ?? Zzc = zzc(obj2, j3);
        int size = zzalmVarZzc.size();
        int size2 = Zzc.size();
        ?? r02 = zzalmVarZzc;
        r02 = zzalmVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzc = zzalmVarZzc.zzc();
            ?? Zza = zzalmVarZzc;
            if (!zZzc) {
                Zza = zzalmVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r02 = Zza;
        }
        if (size > 0) {
            Zzc = r02;
        }
        zzanz.zza(obj, j3, (Object) Zzc);
    }
}
