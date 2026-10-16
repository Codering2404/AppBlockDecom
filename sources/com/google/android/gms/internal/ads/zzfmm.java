package com.google.android.gms.internal.ads;

import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfmm {
    private final int zzb;
    private final int zzc;
    private final LinkedList zza = new LinkedList();
    private final zzfnl zzd = new zzfnl();

    public zzfmm(int i3, int i4) {
        this.zzb = i3;
        this.zzc = i4;
    }

    private final void zzi() {
        while (true) {
            LinkedList linkedList = this.zza;
            if (linkedList.isEmpty()) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - ((zzfmw) linkedList.getFirst()).zzd < this.zzc) {
                return;
            }
            this.zzd.zzc();
            linkedList.remove();
        }
    }

    public final boolean zza(zzfmw zzfmwVar) {
        this.zzd.zza();
        zzi();
        LinkedList linkedList = this.zza;
        if (linkedList.size() == this.zzb) {
            return false;
        }
        linkedList.add(zzfmwVar);
        return true;
    }

    public final zzfmw zzb() {
        zzfnl zzfnlVar = this.zzd;
        zzfnlVar.zza();
        zzi();
        LinkedList linkedList = this.zza;
        if (linkedList.isEmpty()) {
            return null;
        }
        zzfmw zzfmwVar = (zzfmw) linkedList.remove();
        if (zzfmwVar != null) {
            zzfnlVar.zzb();
        }
        return zzfmwVar;
    }

    public final int zzc() {
        zzi();
        return this.zza.size();
    }

    public final long zzd() {
        return this.zzd.zzd();
    }

    public final long zze() {
        return this.zzd.zze();
    }

    public final int zzf() {
        return this.zzd.zzf();
    }

    public final String zzg() {
        return this.zzd.zzh();
    }

    public final zzfnk zzh() {
        return this.zzd.zzg();
    }
}
