package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakp implements zzafy {
    public static final /* synthetic */ int zza = 0;
    private final zzet zzb;
    private final zzagv zzc;
    private final zzagr zzd;
    private final zzagt zze;
    private final zzahk zzf;
    private zzagb zzg;
    private zzahk zzh;
    private zzahk zzi;
    private int zzj;
    private zzap zzk;
    private zzap zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private zzakt zzr;
    private boolean zzs;

    static {
        int i3 = zzakn.zza;
    }

    public zzakp() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0253  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzi(com.google.android.gms.internal.ads.zzafz r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakp.zzi(com.google.android.gms.internal.ads.zzafz):int");
    }

    private final long zzj(long j3) {
        return this.zzm + ((j3 * 1000000) / ((long) this.zzc.zzd));
    }

    private final boolean zzk(zzafz zzafzVar, boolean z2) throws IOException {
        int iZzm;
        int i3;
        int iZza;
        zzafzVar.zzl();
        if (zzafzVar.zzn() == 0) {
            zzap zzapVarZza = this.zze.zza(zzafzVar, null, 131072);
            this.zzk = zzapVarZza;
            if (zzapVarZza != null) {
                this.zzd.zza(zzapVarZza);
            }
            iZzm = (int) zzafzVar.zzm();
            if (!z2) {
                zzafzVar.zzf(iZzm);
            }
            i3 = 0;
        } else {
            iZzm = 0;
            i3 = 0;
        }
        int i4 = i3;
        int i5 = i4;
        while (true) {
            if (!zzl(zzafzVar)) {
                zzet zzetVar = this.zzb;
                zzetVar.zzh(0);
                int iZzB = zzetVar.zzB();
                if ((i3 == 0 || zzn(iZzB, i3)) && (iZza = zzagw.zza(iZzB)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.zzc.zza(iZzB);
                        i3 = iZzB;
                    }
                    zzafzVar.zzk(iZza - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == 131072) {
                        if (z2) {
                            return false;
                        }
                        zzm();
                        throw new EOFException();
                    }
                    if (z2) {
                        zzafzVar.zzl();
                        zzafzVar.zzk(iZzm + i6);
                    } else {
                        zzafzVar.zzf(1);
                    }
                    i4 = 0;
                    i5 = i6;
                    i3 = 0;
                }
            } else if (i4 <= 0) {
                zzm();
                throw new EOFException();
            }
        }
        if (z2) {
            zzafzVar.zzf(iZzm + i5);
        } else {
            zzafzVar.zzl();
        }
        this.zzj = i3;
        return true;
    }

    private final boolean zzl(zzafz zzafzVar) throws IOException {
        zzakt zzaktVar = this.zzr;
        if (zzaktVar != null) {
            long jZzg = zzaktVar.zzg();
            if (jZzg != -1 && zzafzVar.zzm() > jZzg - 4) {
                return true;
            }
        }
        try {
            return !zzafzVar.zzh(this.zzb.zzi(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final void zzm() {
        zzakt zzaktVar = this.zzr;
        if ((zzaktVar instanceof zzakk) && zzaktVar.zzb()) {
            long j3 = this.zzp;
            if (j3 == -1 || j3 == this.zzr.zzg()) {
                return;
            }
            this.zzr = ((zzakk) this.zzr).zzi(this.zzp);
            zzagb zzagbVar = this.zzg;
            zzagbVar.getClass();
            zzagbVar.zzw(this.zzr);
            this.zzh.getClass();
            this.zzr.zza();
        }
    }

    private static boolean zzn(int i3, long j3) {
        return ((long) (i3 & (-128000))) == (j3 & (-128000));
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        return zzk(zzafzVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzg = zzagbVar;
        zzahk zzahkVarZzu = zzagbVar.zzu(0, 1);
        this.zzh = zzahkVarZzu;
        this.zzi = zzahkVarZzu;
        this.zzg.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws Throwable {
        this.zzh.getClass();
        String str = zzfl.zza;
        int iZzi = zzi(zzafzVar);
        if (iZzi == -1 && (this.zzr instanceof zzakl)) {
            if (this.zzr.zza() != zzj(this.zzn)) {
                throw null;
            }
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzj = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0L;
        this.zzq = 0;
        this.zzp = -1L;
        if (this.zzr instanceof zzakl) {
            throw null;
        }
    }

    public final void zzh() {
        this.zzs = true;
    }

    public zzakp(int i3) {
        this.zzb = new zzet(10);
        this.zzc = new zzagv();
        this.zzd = new zzagr();
        this.zzm = -9223372036854775807L;
        this.zze = new zzagt();
        zzafv zzafvVar = new zzafv();
        this.zzf = zzafvVar;
        this.zzi = zzafvVar;
        this.zzp = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
