package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxf extends zzzp {
    private final boolean zzb;
    private final zzbe zzc;
    private final zzbd zzd;
    private zzxd zze;
    private zzxc zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzxf(zzxm zzxmVar, boolean z2) {
        boolean z3;
        super(zzxmVar);
        if (z2) {
            zzxmVar.zzI();
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzb = z3;
        this.zzc = new zzbe();
        this.zzd = new zzbd();
        zzxmVar.zzH();
        this.zze = zzxd.zzp(zzxmVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzs() == null || !obj.equals(zzxd.zzc)) ? obj : this.zze.zzs();
    }

    @RequiresNonNull
    private final boolean zzL(long j3) {
        zzxc zzxcVar = this.zzf;
        int iZze = this.zze.zze(zzxcVar.zza.zza);
        if (iZze == -1) {
            return false;
        }
        zzxd zzxdVar = this.zze;
        zzbd zzbdVar = this.zzd;
        zzxdVar.zzd(iZze, zzbdVar, false);
        long j4 = zzbdVar.zzd;
        if (j4 != -9223372036854775807L && j3 >= j4) {
            j3 = Math.max(0L, j4 - 1);
        }
        zzxcVar.zzo(j3);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzA(zzak zzakVar) {
        if (this.zzi) {
            zzxd zzxdVar = this.zze;
            this.zze = zzxdVar.zzr(zzzl.zzp(zzxdVar.zzb, zzakVar));
        } else {
            this.zze = zzxd.zzp(zzakVar);
        }
        ((zzzp) this).zza.zzA(zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void zzB() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzv(null, ((zzzp) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzzp, com.google.android.gms.internal.ads.zzxm
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final zzxc zzG(zzxk zzxkVar, zzabl zzablVar, long j3) {
        zzxc zzxcVar = new zzxc(zzxkVar, zzablVar, j3);
        zzxcVar.zzr(((zzzp) this).zza);
        if (this.zzh) {
            zzxcVar.zzt(zzxkVar.zza(zzK(zzxkVar.zza)));
            return zzxcVar;
        }
        this.zzf = zzxcVar;
        if (!this.zzg) {
            this.zzg = true;
            zzv(null, ((zzzp) this).zza);
        }
        return zzxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzp, com.google.android.gms.internal.ads.zzxm
    public final void zzD(zzxi zzxiVar) {
        ((zzxc) zzxiVar).zzu();
        if (zzxiVar == this.zzf) {
            this.zzf = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    @Override // com.google.android.gms.internal.ads.zzzp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzE(com.google.android.gms.internal.ads.zzbf r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzh
            r1 = 0
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzxd r0 = r11.zze
            com.google.android.gms.internal.ads.zzxd r12 = r0.zzr(r12)
            r11.zze = r12
            com.google.android.gms.internal.ads.zzxc r12 = r11.zzf
            if (r12 == 0) goto L97
            long r2 = r12.zzq()
            r11.zzL(r2)
            goto L97
        L1a:
            boolean r0 = r12.zzg()
            if (r0 == 0) goto L36
            boolean r0 = r11.zzi
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzxd r0 = r11.zze
            com.google.android.gms.internal.ads.zzxd r12 = r0.zzr(r12)
            goto L33
        L2b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbe.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzxd.zzc
            com.google.android.gms.internal.ads.zzxd r12 = com.google.android.gms.internal.ads.zzxd.zzq(r12, r0, r2)
        L33:
            r11.zze = r12
            goto L97
        L36:
            com.google.android.gms.internal.ads.zzbe r3 = r11.zzc
            r0 = 0
            r4 = 0
            r12.zzb(r0, r3, r4)
            java.lang.Object r8 = r3.zzb
            com.google.android.gms.internal.ads.zzxc r2 = r11.zzf
            if (r2 == 0) goto L5d
            long r6 = r2.zza()
            com.google.android.gms.internal.ads.zzxd r9 = r11.zze
            com.google.android.gms.internal.ads.zzbd r10 = r11.zzd
            com.google.android.gms.internal.ads.zzxk r2 = r2.zza
            java.lang.Object r2 = r2.zza
            r9.zzo(r2, r10)
            com.google.android.gms.internal.ads.zzxd r2 = r11.zze
            r2.zzb(r0, r3, r4)
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L5d
            goto L5e
        L5d:
            r6 = r4
        L5e:
            com.google.android.gms.internal.ads.zzbd r4 = r11.zzd
            r5 = 0
            r2 = r12
            android.util.Pair r12 = r2.zzm(r3, r4, r5, r6)
            java.lang.Object r0 = r12.first
            java.lang.Object r12 = r12.second
            java.lang.Long r12 = (java.lang.Long) r12
            long r3 = r12.longValue()
            boolean r12 = r11.zzi
            if (r12 == 0) goto L7b
            com.google.android.gms.internal.ads.zzxd r12 = r11.zze
            com.google.android.gms.internal.ads.zzxd r12 = r12.zzr(r2)
            goto L7f
        L7b:
            com.google.android.gms.internal.ads.zzxd r12 = com.google.android.gms.internal.ads.zzxd.zzq(r2, r8, r0)
        L7f:
            r11.zze = r12
            com.google.android.gms.internal.ads.zzxc r12 = r11.zzf
            if (r12 == 0) goto L97
            boolean r0 = r11.zzL(r3)
            if (r0 == 0) goto L97
            com.google.android.gms.internal.ads.zzxk r12 = r12.zza
            java.lang.Object r0 = r12.zza
            java.lang.Object r0 = r11.zzK(r0)
            com.google.android.gms.internal.ads.zzxk r1 = r12.zza(r0)
        L97:
            r12 = 1
            r11.zzi = r12
            r11.zzh = r12
            com.google.android.gms.internal.ads.zzxd r12 = r11.zze
            r11.zze(r12)
            if (r1 == 0) goto Lab
            com.google.android.gms.internal.ads.zzxc r12 = r11.zzf
            r12.getClass()
            r12.zzt(r1)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxf.zzE(com.google.android.gms.internal.ads.zzbf):void");
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    protected final zzxk zzF(zzxk zzxkVar) {
        Object objZzs = this.zze.zzs();
        Object obj = zzxkVar.zza;
        if (objZzs != null && this.zze.zzs().equals(obj)) {
            obj = zzxd.zzc;
        }
        return zzxkVar.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzws, com.google.android.gms.internal.ads.zzwj
    public final void zzd() {
        this.zzh = false;
        this.zzg = false;
        super.zzd();
    }

    public final zzbf zzz() {
        return this.zze;
    }
}
