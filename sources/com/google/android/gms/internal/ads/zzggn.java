package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzggn {
    public long zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public double zze;
    public float zzf;
    public float zzg;
    public float zzh;
    public float zzi;
    private double zzj;
    private double zzk;

    private static double zzb(MotionEvent motionEvent, double d3, double d4, double d5) {
        return d5 + Math.hypot(((double) motionEvent.getRawX()) - d3, ((double) motionEvent.getRawY()) - d4);
    }

    final /* synthetic */ void zza(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zza++;
            this.zze = 0.0d;
            this.zzj = motionEvent.getRawX();
            this.zzk = motionEvent.getRawY();
            this.zzf = motionEvent.getX();
            this.zzg = motionEvent.getY();
            this.zzh = motionEvent.getRawX();
            this.zzi = motionEvent.getRawY();
            return;
        }
        if (action == 1) {
            this.zzc++;
            this.zze = zzb(motionEvent, this.zzj, this.zzk, this.zze);
            this.zzj = motionEvent.getRawX();
            this.zzk = motionEvent.getRawY();
            return;
        }
        if (action != 2) {
            if (action != 3) {
                return;
            }
            this.zzd++;
        } else {
            this.zzb += (long) (motionEvent.getHistorySize() + 1);
            this.zze = zzb(motionEvent, this.zzj, this.zzk, this.zze);
            this.zzj = motionEvent.getRawX();
            this.zzk = motionEvent.getRawY();
        }
    }
}
