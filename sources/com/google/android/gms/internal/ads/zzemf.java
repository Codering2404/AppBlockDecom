package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzemf implements zzdno {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfkf zzc;
    private final zzcku zzd;
    private final zzfky zze;
    private final zzbpt zzf;
    private final boolean zzg;
    private final zzekr zzh;
    private final zzdzl zzi;

    zzemf(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfkf zzfkfVar, zzcku zzckuVar, zzfky zzfkyVar, boolean z2, zzbpt zzbptVar, zzekr zzekrVar, zzdzl zzdzlVar) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfkfVar;
        this.zzd = zzckuVar;
        this.zze = zzfkyVar;
        this.zzg = z2;
        this.zzf = zzbptVar;
        this.zzh = zzekrVar;
        this.zzi = zzdzlVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    @Override // com.google.android.gms.internal.ads.zzdno
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(boolean r18, android.content.Context r19, com.google.android.gms.internal.ads.zzdde r20) {
        /*
            r17 = this;
            r0 = r17
            com.google.common.util.concurrent.ListenableFuture r1 = r0.zzb
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzhbw.zzt(r1)
            com.google.android.gms.internal.ads.zzcuw r1 = (com.google.android.gms.internal.ads.zzcuw) r1
            com.google.android.gms.internal.ads.zzcku r6 = r0.zzd
            r2 = 1
            r6.zzag(r2)
            com.google.android.gms.ads.internal.zzl r7 = new com.google.android.gms.ads.internal.zzl
            boolean r3 = r0.zzg
            if (r3 == 0) goto L1e
            com.google.android.gms.internal.ads.zzbpt r4 = r0.zzf
            boolean r4 = r4.zzc(r2)
            r8 = r4
            goto L1f
        L1e:
            r8 = r2
        L1f:
            r4 = 0
            if (r3 == 0) goto L2b
            com.google.android.gms.internal.ads.zzbpt r3 = r0.zzf
            boolean r3 = r3.zzd()
            if (r3 == 0) goto L2d
            r4 = r2
        L2b:
            r10 = r4
            goto L2f
        L2d:
            r10 = r4
            r4 = r2
        L2f:
            if (r4 == 0) goto L39
            com.google.android.gms.internal.ads.zzbpt r3 = r0.zzf
            float r3 = r3.zze()
        L37:
            r11 = r3
            goto L3b
        L39:
            r3 = 0
            goto L37
        L3b:
            com.google.android.gms.internal.ads.zzfkf r3 = r0.zzc
            boolean r14 = r3.zzO
            r15 = 0
            r9 = 1
            r12 = -1
            r13 = r18
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r20 == 0) goto L4c
            r20.zzb()
        L4c:
            com.google.android.gms.ads.internal.zzt.f()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdnd r1 = r1.zzj()
            int r5 = r3.zzQ
            r8 = -1
            if (r5 == r8) goto L5b
            goto L73
        L5b:
            com.google.android.gms.internal.ads.zzfky r8 = r0.zze
            com.google.android.gms.ads.internal.client.zzx r8 = r8.zzk
            if (r8 == 0) goto L6c
            int r8 = r8.f70032a
            if (r8 != r2) goto L67
            r5 = 7
            goto L73
        L67:
            r9 = 2
            if (r8 != r9) goto L6c
            r5 = 6
            goto L73
        L6c:
            int r8 = com.google.android.gms.ads.internal.util.zze.f70328b
            java.lang.String r8 = "Error setting app open orientation; no targeting orientation available."
            com.google.android.gms.ads.internal.util.client.zzo.a(r8)
        L73:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r8 = r0.zza
            java.lang.String r9 = r3.zzB
            com.google.android.gms.internal.ads.zzfkk r10 = r3.zzs
            java.lang.String r11 = r10.zzb
            java.lang.String r12 = r10.zza
            com.google.android.gms.internal.ads.zzfky r10 = r0.zze
            boolean r3 = r3.zzb()
            if (r3 == 0) goto L89
            com.google.android.gms.internal.ads.zzekr r3 = r0.zzh
        L87:
            r15 = r3
            goto L8b
        L89:
            r3 = 0
            goto L87
        L8b:
            java.lang.String r13 = r10.zzg
            java.lang.String r16 = r6.zzn()
            r3 = 0
            r10 = r7
            r7 = r5
            r5 = 0
            r14 = r4
            r4 = r1
            r1 = r2
            r2 = r14
            r14 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.google.android.gms.internal.ads.zzdzl r3 = r0.zzi
            r4 = r19
            com.google.android.gms.ads.internal.overlay.zzn.a(r4, r2, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemf.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzdde):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zzc;
    }
}
