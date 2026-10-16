package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwm implements zzyd {
    private final zzage zza;
    private zzafy zzb;
    private zzafz zzc;

    public zzwm(zzage zzageVar) {
        this.zza = zzageVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // com.google.android.gms.internal.ads.zzyd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzj r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzagb r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzafp r1 = new com.google.android.gms.internal.ads.zzafp
            r2 = r8
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5)
            r7.zzc = r1
            com.google.android.gms.internal.ads.zzafy r8 = r7.zzb
            if (r8 == 0) goto Lf
            return
        Lf:
            com.google.android.gms.internal.ads.zzage r8 = r7.zza
            com.google.android.gms.internal.ads.zzafy[] r8 = r8.zzb(r9, r10)
            int r10 = r8.length
            com.google.android.gms.internal.ads.zzgwj r11 = com.google.android.gms.internal.ads.zzgwm.zzv(r10)
            r12 = 0
            r13 = 1
            if (r10 != r13) goto L23
            r8 = r8[r12]
            r7.zzb = r8
            goto L7f
        L23:
            r14 = r12
        L24:
            if (r14 >= r10) goto L7b
            r0 = r8[r14]
            boolean r2 = r0.zza(r1)     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            if (r2 == 0) goto L3a
            r7.zzb = r0     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            com.google.android.gms.internal.ads.zzgtj.zzi(r13)
            r1.zzl()
            goto L7b
        L37:
            r0 = move-exception
            r8 = r0
            goto L57
        L3a:
            java.util.List r0 = r0.zzb()     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            r11.zzh(r0)     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            com.google.android.gms.internal.ads.zzafy r0 = r7.zzb
            if (r0 != 0) goto L4d
            long r5 = r1.zzn()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L4f
        L4d:
            r0 = r13
            goto L50
        L4f:
            r0 = r12
        L50:
            com.google.android.gms.internal.ads.zzgtj.zzi(r0)
            r1.zzl()
            goto L78
        L57:
            com.google.android.gms.internal.ads.zzafy r9 = r7.zzb
            if (r9 != 0) goto L63
            long r9 = r1.zzn()
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L64
        L63:
            r12 = r13
        L64:
            com.google.android.gms.internal.ads.zzgtj.zzi(r12)
            r1.zzl()
            throw r8
        L6b:
            com.google.android.gms.internal.ads.zzafy r0 = r7.zzb
            if (r0 != 0) goto L4d
            long r5 = r1.zzn()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L4f
            goto L4d
        L78:
            int r14 = r14 + 1
            goto L24
        L7b:
            com.google.android.gms.internal.ads.zzafy r10 = r7.zzb
            if (r10 == 0) goto L85
        L7f:
            com.google.android.gms.internal.ads.zzafy r8 = r7.zzb
            r8.zzc(r15)
            return
        L85:
            com.google.android.gms.internal.ads.zzzo r10 = new com.google.android.gms.internal.ads.zzzo
            com.google.android.gms.internal.ads.zzgwm r8 = com.google.android.gms.internal.ads.zzgwm.zzr(r8)
            com.google.android.gms.internal.ads.zzwl r12 = com.google.android.gms.internal.ads.zzwl.zza
            java.util.List r8 = com.google.android.gms.internal.ads.zzgxm.zzc(r8, r12)
            java.lang.String r12 = ", "
            java.lang.String r8 = com.google.android.gms.internal.ads.zzgtd.zzd(r8, r12)
            int r12 = r8.length()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            int r12 = r12 + 58
            r13.<init>(r12)
            java.lang.String r12 = "None of the available extractors ("
            r13.append(r12)
            r13.append(r8)
            java.lang.String r8 = ") could read the stream."
            r13.append(r8)
            java.lang.String r8 = r13.toString()
            com.google.android.gms.internal.ads.zzgwm r11 = r11.zzi()
            r10.<init>(r8, r9, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwm.zza(com.google.android.gms.internal.ads.zzj, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzagb):void");
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zzb() {
        zzafy zzafyVar = this.zzb;
        if (zzafyVar != null) {
            zzafyVar.zzf();
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zzc() {
        zzafy zzafyVar = this.zzb;
        if (zzafyVar != null && (zzafyVar instanceof zzakp)) {
            ((zzakp) zzafyVar).zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final long zzd() {
        zzafz zzafzVar = this.zzc;
        if (zzafzVar != null) {
            return zzafzVar.zzn();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zze(long j3, long j4) {
        zzafy zzafyVar = this.zzb;
        zzafyVar.getClass();
        zzafyVar.zze(j3, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final int zzf(zzagy zzagyVar) throws IOException {
        zzafz zzafzVar;
        zzafy zzafyVar = this.zzb;
        if (zzafyVar == null || (zzafzVar = this.zzc) == null) {
            throw null;
        }
        return zzafyVar.zzd(zzafzVar, zzagyVar);
    }
}
