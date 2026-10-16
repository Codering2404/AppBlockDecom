package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqa implements zzapt {
    private final zzaqw zza;
    private long zzf;
    private String zzh;
    private zzahk zzi;
    private zzapz zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = "video/mp2t";
    private final boolean[] zzg = new boolean[3];
    private final zzaqk zzc = new zzaqk(7, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzaqk zzd = new zzaqk(8, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzaqk zze = new zzaqk(6, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private long zzl = -9223372036854775807L;
    private final zzet zzn = new zzet();

    public zzaqa(zzaqw zzaqwVar, boolean z2, boolean z3, String str) {
        this.zza = zzaqwVar;
    }

    @RequiresNonNull
    private final void zzf(long j3, int i3, long j4) {
        if (!this.zzk) {
            this.zzc.zzc(i3);
            this.zzd.zzc(i3);
        }
        this.zze.zzc(i3);
        this.zzj.zzd(j3, i3, j4, this.zzm);
    }

    @RequiresNonNull
    private final void zzg(byte[] bArr, int i3, int i4) {
        if (!this.zzk) {
            this.zzc.zzd(bArr, i3, i4);
            this.zzd.zzd(bArr, i3, i4);
        }
        this.zze.zzd(bArr, i3, i4);
    }

    @RequiresNonNull
    private final void zzh(long j3, int i3, int i4, long j4) {
        if (!this.zzk) {
            zzaqk zzaqkVar = this.zzc;
            zzaqkVar.zze(i4);
            zzaqk zzaqkVar2 = this.zzd;
            zzaqkVar2.zze(i4);
            if (this.zzk) {
                if (zzaqkVar.zzb()) {
                    zzgo zzgoVarZze = zzgp.zze(zzaqkVar.zza, 4, zzaqkVar.zzb);
                    this.zza.zzb(zzgoVarZze.zzm);
                    this.zzj.zza(zzgoVarZze);
                    zzaqkVar.zza();
                } else if (zzaqkVar2.zzb()) {
                    this.zzj.zzb(zzgp.zzh(zzaqkVar2.zza, 4, zzaqkVar2.zzb));
                    zzaqkVar2.zza();
                }
            } else if (zzaqkVar.zzb() && zzaqkVar2.zzb()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzaqkVar.zza, zzaqkVar.zzb));
                arrayList.add(Arrays.copyOf(zzaqkVar2.zza, zzaqkVar2.zzb));
                zzgo zzgoVarZze2 = zzgp.zze(zzaqkVar.zza, 4, zzaqkVar.zzb);
                zzgn zzgnVarZzh = zzgp.zzh(zzaqkVar2.zza, 4, zzaqkVar2.zzb);
                String strZzb = zzdq.zzb(zzgoVarZze2.zza, zzgoVarZze2.zzb, zzgoVarZze2.zzc);
                zzahk zzahkVar = this.zzi;
                zzt zztVar = new zzt();
                zztVar.zza(this.zzh);
                zztVar.zzn(this.zzb);
                zztVar.zzo("video/avc");
                zztVar.zzk(strZzb);
                zztVar.zzv(zzgoVarZze2.zze);
                zztVar.zzw(zzgoVarZze2.zzf);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzgoVarZze2.zzj);
                zzhVar.zzb(zzgoVarZze2.zzk);
                zzhVar.zzc(zzgoVarZze2.zzl);
                zzhVar.zze(zzgoVarZze2.zzh + 8);
                zzhVar.zzf(zzgoVarZze2.zzi + 8);
                zztVar.zzE(zzhVar.zzg());
                zztVar.zzB(zzgoVarZze2.zzg);
                zztVar.zzr(arrayList);
                int i5 = zzgoVarZze2.zzm;
                zztVar.zzq(i5);
                zzahkVar.zzA(zztVar.zzO());
                this.zzk = true;
                this.zza.zzb(i5);
                this.zzj.zza(zzgoVarZze2);
                this.zzj.zzb(zzgnVarZzh);
                zzaqkVar.zza();
                zzaqkVar2.zza();
            }
        }
        zzaqk zzaqkVar3 = this.zze;
        if (zzaqkVar3.zze(i4)) {
            int iZza = zzgp.zza(zzaqkVar3.zza, zzaqkVar3.zzb);
            zzet zzetVar = this.zzn;
            zzetVar.zzb(zzaqkVar3.zza, iZza);
            zzetVar.zzh(4);
            this.zza.zzc(j4, zzetVar);
        }
        if (this.zzj.zze(j3, i3, this.zzk)) {
            this.zzm = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = -9223372036854775807L;
        zzgp.zzj(this.zzg);
        this.zzc.zza();
        this.zzd.zza();
        this.zze.zza();
        this.zza.zze();
        zzapz zzapzVar = this.zzj;
        if (zzapzVar != null) {
            zzapzVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzh = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzi = zzahkVarZzu;
        this.zzj = new zzapz(zzahkVarZzu, false, false);
        this.zza.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzl = j3;
        int i4 = i3 & 2;
        this.zzm = (i4 != 0) | this.zzm;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzet r15) {
        /*
            r14 = this;
            com.google.android.gms.internal.ads.zzahk r1 = r14.zzi
            r1.getClass()
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfl.zza
            int r1 = r15.zzg()
            int r7 = r15.zze()
            byte[] r8 = r15.zzi()
            long r2 = r14.zzf
            int r4 = r15.zzd()
            long r4 = (long) r4
            long r2 = r2 + r4
            r14.zzf = r2
            com.google.android.gms.internal.ads.zzahk r2 = r14.zzi
            int r3 = r15.zzd()
            r2.zzc(r15, r3)
        L26:
            boolean[] r2 = r14.zzg
            int r2 = com.google.android.gms.internal.ads.zzgp.zzi(r8, r1, r7, r2)
            if (r2 == r7) goto L68
            int r3 = r2 + 3
            r3 = r8[r3]
            r9 = r3 & 31
            r3 = 3
            if (r2 <= 0) goto L41
            int r4 = r2 + (-1)
            r5 = r8[r4]
            if (r5 != 0) goto L41
            r3 = 4
            r11 = r3
            r10 = r4
            goto L43
        L41:
            r10 = r2
            r11 = r3
        L43:
            int r2 = r10 - r1
            if (r2 <= 0) goto L4a
            r14.zzg(r8, r1, r10)
        L4a:
            int r3 = r7 - r10
            long r4 = r14.zzf
            long r12 = (long) r3
            long r4 = r4 - r12
            if (r2 >= 0) goto L55
            int r1 = -r2
        L53:
            r12 = r4
            goto L57
        L55:
            r1 = 0
            goto L53
        L57:
            long r5 = r14.zzl
            r0 = r14
            r4 = r1
            r1 = r12
            r0.zzh(r1, r3, r4, r5)
            long r4 = r14.zzl
            r3 = r9
            r0.zzf(r1, r3, r4)
            int r1 = r10 + r11
            goto L26
        L68:
            r14.zzg(r8, r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqa.zzd(com.google.android.gms.internal.ads.zzet):void");
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
        this.zzi.getClass();
        String str = zzfl.zza;
        if (z2) {
            this.zza.zzd();
            zzh(this.zzf, 0, 0, this.zzl);
            zzf(this.zzf, 9, this.zzl);
            zzh(this.zzf, 0, 0, this.zzl);
        }
    }
}
