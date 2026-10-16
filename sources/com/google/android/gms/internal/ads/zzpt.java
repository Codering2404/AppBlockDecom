package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpt {
    final /* synthetic */ zzpu zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzxk zze;
    private boolean zzf;
    private boolean zzg;

    public zzpt(zzpu zzpuVar, String str, int i3, zzxk zzxkVar) {
        Objects.requireNonNull(zzpuVar);
        this.zza = zzpuVar;
        this.zzb = str;
        this.zzc = i3;
        this.zzd = zzxkVar == null ? -1L : zzxkVar.zzd;
        if (zzxkVar == null || !zzxkVar.zzb()) {
            return;
        }
        this.zze = zzxkVar;
    }

    public final boolean zza(zzbf zzbfVar, zzbf zzbfVar2) {
        int i3 = this.zzc;
        if (i3 < zzbfVar.zza()) {
            zzpu zzpuVar = this.zza;
            zzbfVar.zzb(i3, zzpuVar.zzj(), 0L);
            for (int i4 = zzpuVar.zzj().zzn; i4 <= zzpuVar.zzj().zzo; i4++) {
                int iZze = zzbfVar2.zze(zzbfVar.zzf(i4));
                if (iZze != -1) {
                    i3 = zzbfVar2.zzd(iZze, zzpuVar.zzk(), false).zzc;
                    break;
                }
            }
            i3 = -1;
        } else if (i3 >= zzbfVar2.zza()) {
            i3 = -1;
        }
        this.zzc = i3;
        if (i3 == -1) {
            return false;
        }
        zzxk zzxkVar = this.zze;
        return zzxkVar == null || zzbfVar2.zze(zzxkVar.zza) != -1;
    }

    public final boolean zzb(int i3, zzxk zzxkVar) {
        if (zzxkVar != null) {
            long j3 = zzxkVar.zzd;
            if (j3 != -1) {
                zzxk zzxkVar2 = this.zze;
                return zzxkVar2 == null ? !zzxkVar.zzb() && j3 == this.zzd : j3 == zzxkVar2.zzd && zzxkVar.zzb == zzxkVar2.zzb && zzxkVar.zzc == zzxkVar2.zzc;
            }
        }
        return i3 == this.zzc;
    }

    public final void zzc(int i3, zzxk zzxkVar) {
        if (this.zzd == -1 && i3 == this.zzc && zzxkVar != null) {
            zzpu zzpuVar = this.zza;
            long j3 = zzxkVar.zzd;
            if (j3 >= zzpuVar.zzi()) {
                this.zzd = j3;
            }
        }
    }

    public final boolean zzd(zznn zznnVar) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar == null) {
            return this.zzc != zznnVar.zzc;
        }
        long j3 = this.zzd;
        if (j3 == -1) {
            return false;
        }
        long j4 = zzxkVar.zzd;
        if (j4 > j3) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbf zzbfVar = zznnVar.zzb;
        int iZze = zzbfVar.zze(zzxkVar.zza);
        int iZze2 = zzbfVar.zze(this.zze.zza);
        zzxk zzxkVar2 = this.zze;
        if (j4 < zzxkVar2.zzd || iZze < iZze2) {
            return false;
        }
        if (iZze > iZze2) {
            return true;
        }
        if (!zzxkVar.zzb()) {
            int i3 = zzxkVar.zze;
            return i3 == -1 || i3 > zzxkVar2.zzb;
        }
        int i4 = zzxkVar.zzb;
        int i5 = zzxkVar.zzc;
        int i6 = zzxkVar2.zzb;
        if (i4 <= i6) {
            return i4 == i6 && i5 > zzxkVar2.zzc;
        }
        return true;
    }

    final /* synthetic */ String zze() {
        return this.zzb;
    }

    final /* synthetic */ int zzf() {
        return this.zzc;
    }

    final /* synthetic */ long zzg() {
        return this.zzd;
    }

    final /* synthetic */ zzxk zzh() {
        return this.zze;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    final /* synthetic */ void zzj(boolean z2) {
        this.zzf = true;
    }

    final /* synthetic */ boolean zzk() {
        return this.zzg;
    }

    final /* synthetic */ void zzl(boolean z2) {
        this.zzg = true;
    }
}
