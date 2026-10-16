package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgq {
    private final boolean zza;

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzgq(com.google.android.gms.internal.ads.zzgt r8, com.google.android.gms.internal.ads.zzgs r9) throws com.google.android.gms.internal.ads.zzgr {
        /*
            r7 = this;
            r7.<init>()
            int r0 = r9.zza
            r1 = 6
            r2 = 0
            r3 = 3
            r4 = 1
            if (r0 == r1) goto Ld
            if (r0 != r3) goto Lf
        Ld:
            r0 = r4
            goto L10
        Lf:
            r0 = r2
        L10:
            com.google.android.gms.internal.ads.zzgtj.zza(r0)
            java.nio.ByteBuffer r0 = r9.zzb
            int r0 = r0.remaining()
            r1 = 4
            int r0 = java.lang.Math.min(r1, r0)
            byte[] r1 = new byte[r0]
            java.nio.ByteBuffer r9 = r9.zzb
            java.nio.ByteBuffer r9 = r9.asReadOnlyBuffer()
            r9.get(r1)
            com.google.android.gms.internal.ads.zzes r9 = new com.google.android.gms.internal.ads.zzes
            r9.<init>(r1, r0)
            boolean r0 = r8.zza
            com.google.android.gms.internal.ads.zzgu.zzb(r0)
            boolean r0 = r9.zzi()
            if (r0 == 0) goto L3a
            goto L94
        L3a:
            r0 = 2
            int r1 = r9.zzj(r0)
            boolean r5 = r9.zzi()
            boolean r6 = r8.zzb
            com.google.android.gms.internal.ads.zzgu.zzb(r6)
            if (r5 != 0) goto L4c
        L4a:
            r2 = r4
            goto L94
        L4c:
            if (r1 == r3) goto L50
            if (r1 != 0) goto L52
        L50:
            r5 = r4
            goto L56
        L52:
            boolean r5 = r9.zzi()
        L56:
            r9.zzg()
            boolean r6 = r8.zzd
            r6 = r6 ^ r4
            com.google.android.gms.internal.ads.zzgu.zzb(r6)
            boolean r6 = r9.zzi()
            if (r6 == 0) goto L6e
            boolean r6 = r8.zze
            r6 = r6 ^ r4
            com.google.android.gms.internal.ads.zzgu.zzb(r6)
            r9.zzg()
        L6e:
            boolean r6 = r8.zzc
            com.google.android.gms.internal.ads.zzgu.zzb(r6)
            if (r1 == r3) goto L78
            r9.zzg()
        L78:
            int r8 = r8.zzf
            r9.zzh(r8)
            if (r1 == r0) goto L86
            if (r1 == 0) goto L86
            if (r5 != 0) goto L86
            r9.zzh(r3)
        L86:
            if (r1 == r3) goto L4a
            if (r1 != 0) goto L8b
            goto L4a
        L8b:
            r8 = 8
            int r8 = r9.zzj(r8)
            if (r8 == 0) goto L94
            goto L4a
        L94:
            r7.zza = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgq.<init>(com.google.android.gms.internal.ads.zzgt, com.google.android.gms.internal.ads.zzgs):void");
    }

    public static zzgq zzb(zzgt zzgtVar, zzgs zzgsVar) {
        try {
            return new zzgq(zzgtVar, zzgsVar);
        } catch (zzgr unused) {
            return null;
        }
    }

    public final boolean zza() {
        return this.zza;
    }
}
