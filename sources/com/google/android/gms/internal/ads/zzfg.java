package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfg implements zzdz {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzfg(Handler handler) {
        this.zzb = handler;
    }

    static /* synthetic */ void zzo(zzff zzffVar) {
        List list = zza;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(zzffVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static zzff zzp() {
        zzff zzffVar;
        List list = zza;
        synchronized (list) {
            try {
                zzffVar = list.isEmpty() ? new zzff(null) : (zzff) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzb(int i3) {
        return this.zzb.hasMessages(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zzc(int i3) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(i3), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zzd(int i3, Object obj) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(i3, obj), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zze(int i3, int i4, int i5) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(i3, i4, i5), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zzf(int i3, int i4, int i5, Object obj) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(31, 0, 0, obj), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzg(zzdy zzdyVar) {
        return ((zzff) zzdyVar).zzc(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzh(int i3) {
        return this.zzb.sendEmptyMessage(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzi(int i3, int i4) {
        return this.zzb.sendEmptyMessageDelayed(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzj(int i3, long j3) {
        return this.zzb.sendEmptyMessageAtTime(2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final void zzk(int i3) {
        this.zzb.removeMessages(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final void zzl(Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzm(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzn(Runnable runnable, long j3) {
        return this.zzb.postDelayed(runnable, 1000L);
    }
}
