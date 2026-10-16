package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzchk extends zzgap {
    private final SensorManager zza;
    private final Object zzb;
    private final Display zzc;
    private final float[] zzd;
    private final float[] zze;
    private float[] zzf;
    private Handler zzg;
    private zzchj zzh;

    zzchk(Context context) {
        super("OrientationMonitor", "ads");
        this.zza = (SensorManager) context.getSystemService("sensor");
        this.zzc = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzb = new Object();
    }

    final void zza() {
        if (this.zzg != null) {
            return;
        }
        SensorManager sensorManager = this.zza;
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (defaultSensor == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        zzgam zzgamVar = new zzgam(handlerThread.getLooper());
        this.zzg = zzgamVar;
        if (sensorManager.registerListener(this, defaultSensor, 0, zzgamVar)) {
            return;
        }
        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.c("SensorManager.registerListener failed.");
        zzb();
    }

    final void zzb() {
        if (this.zzg == null) {
            return;
        }
        this.zza.unregisterListener(this);
        this.zzg.post(new zzchi(this));
        this.zzg = null;
    }

    final void zzc(zzchj zzchjVar) {
        this.zzh = zzchjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgap
    public final void zzd(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzb) {
            try {
                if (this.zzf == null) {
                    this.zzf = new float[9];
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        float[] fArr2 = this.zzd;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.zzc.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(fArr2, 2, 129, this.zze);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(fArr2, 129, 130, this.zze);
        } else if (rotation != 3) {
            System.arraycopy(fArr2, 0, this.zze, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(fArr2, 130, 1, this.zze);
        }
        float[] fArr3 = this.zze;
        float f3 = fArr3[1];
        fArr3[1] = fArr3[3];
        fArr3[3] = f3;
        float f4 = fArr3[2];
        fArr3[2] = fArr3[6];
        fArr3[6] = f4;
        float f5 = fArr3[5];
        fArr3[5] = fArr3[7];
        fArr3[7] = f5;
        synchronized (this.zzb) {
            System.arraycopy(fArr3, 0, this.zzf, 0, 9);
        }
        zzchj zzchjVar = this.zzh;
        if (zzchjVar != null) {
            zzchjVar.zza();
        }
    }

    final boolean zze(float[] fArr) {
        synchronized (this.zzb) {
            try {
                float[] fArr2 = this.zzf;
                if (fArr2 == null) {
                    return false;
                }
                System.arraycopy(fArr2, 0, fArr, 0, 9);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
