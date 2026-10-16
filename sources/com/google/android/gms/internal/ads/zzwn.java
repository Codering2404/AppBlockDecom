package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzwn implements zzzc {
    public final zzzc zza;
    final /* synthetic */ zzwo zzb;
    private boolean zzc;

    public zzwn(zzwo zzwoVar, zzzc zzzcVar) {
        Objects.requireNonNull(zzwoVar);
        this.zzb = zzwoVar;
        this.zza = zzzcVar;
    }

    public final void zza() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return !this.zzb.zzo() && this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    @Override // com.google.android.gms.internal.ads.zzzc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzlw r12, com.google.android.gms.internal.ads.zziv r13, int r14) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzwo r0 = r11.zzb
            boolean r1 = r0.zzo()
            r2 = -3
            if (r1 == 0) goto La
            return r2
        La:
            boolean r1 = r11.zzc
            r3 = 4
            r4 = -4
            if (r1 == 0) goto L14
            r13.zzg(r3)
            return r4
        L14:
            com.google.android.gms.internal.ads.zzzc r1 = r11.zza
            long r5 = r0.zzi()
            int r14 = r1.zzd(r12, r13, r14)
            long r7 = r0.zzq()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L30
            if (r14 == r2) goto L30
            r0.zzr(r9)
        L30:
            r1 = -5
            r7 = -9223372036854775808
            if (r14 != r1) goto L5e
            long r13 = r0.zzb
            com.google.android.gms.internal.ads.zzv r0 = r12.zzb
            r0.getClass()
            int r2 = r0.zzK
            r3 = 0
            if (r2 != 0) goto L46
            int r2 = r0.zzL
            if (r2 == 0) goto L5d
            r2 = r3
        L46:
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 == 0) goto L4b
            goto L4d
        L4b:
            int r3 = r0.zzL
        L4d:
            com.google.android.gms.internal.ads.zzt r13 = r0.zza()
            r13.zzJ(r2)
            r13.zzK(r3)
            com.google.android.gms.internal.ads.zzv r13 = r13.zzO()
            r12.zzb = r13
        L5d:
            return r1
        L5e:
            long r0 = r0.zzb
            int r12 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r12 == 0) goto L80
            if (r14 != r4) goto L6c
            long r9 = r13.zze
            int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r12 >= 0) goto L76
        L6c:
            if (r14 != r2) goto L80
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 != 0) goto L80
            boolean r12 = r13.zzd
            if (r12 != 0) goto L80
        L76:
            r13.zza()
            r13.zzg(r3)
            r12 = 1
            r11.zzc = r12
            return r4
        L80:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwn.zzd(com.google.android.gms.internal.ads.zzlw, com.google.android.gms.internal.ads.zziv, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j3) {
        if (this.zzb.zzo()) {
            return -3;
        }
        return this.zza.zze(j3);
    }
}
