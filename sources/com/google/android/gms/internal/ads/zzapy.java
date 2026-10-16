package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapy implements zzapt {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzarl zzb;
    private zzapx zzg;
    private long zzh;
    private String zzi;
    private zzahk zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzapw zze = new zzapw(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private long zzl = -9223372036854775807L;
    private final zzaqk zzf = new zzaqk(178, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzet zzc = new zzet();

    zzapy(zzarl zzarlVar, String str) {
        this.zzb = zzarlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        zzgp.zzj(this.zzd);
        this.zze.zza();
        zzapx zzapxVar = this.zzg;
        if (zzapxVar != null) {
            zzapxVar.zza();
        }
        this.zzf.zza();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzi = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzj = zzahkVarZzu;
        this.zzg = new zzapx(zzahkVarZzu);
        this.zzb.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzl = j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0185  */
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzet r19) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapy.zzd(com.google.android.gms.internal.ads.zzet):void");
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
        zzapx zzapxVar = this.zzg;
        zzapxVar.getClass();
        if (z2) {
            zzapxVar.zzd(this.zzh, 0, this.zzk);
            this.zzg.zza();
        }
    }
}
