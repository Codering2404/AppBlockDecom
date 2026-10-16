package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzedu extends zzgap {
    private final Context zza;

    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzedt zzf;
    private boolean zzg;

    zzedu(Context context) {
        super("ShakeDetector", "ads");
        this.zza = context;
    }

    public final void zza(zzedt zzedtVar) {
        this.zzf = zzedtVar;
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzks)).booleanValue()) {
                    if (this.zzb == null) {
                        SensorManager sensorManager2 = (SensorManager) this.zza.getSystemService("sensor");
                        this.zzb = sensorManager2;
                        if (sensorManager2 == null) {
                            String str = bfIdKSjLOVjG.OSeWLed;
                            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.f(str);
                            return;
                        }
                        this.zzc = sensorManager2.getDefaultSensor(1);
                    }
                    if (!this.zzg && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.zzd = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzku)).intValue());
                        this.zzg = true;
                        com.google.android.gms.ads.internal.util.zze.k("Listening for shake gestures.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        synchronized (this) {
            try {
                if (this.zzg) {
                    SensorManager sensorManager = this.zzb;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(this, this.zzc);
                        com.google.android.gms.ads.internal.util.zze.k("Stopped listening for shake gestures.");
                    }
                    this.zzg = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgap
    public final void zzd(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzks)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f3 = fArr[0] / 9.80665f;
            float f4 = fArr[1] / 9.80665f;
            float f5 = fArr[2] / 9.80665f;
            if (((float) Math.sqrt((f3 * f3) + (f4 * f4) + (f5 * f5))) >= ((Float) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkt)).floatValue()) {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
                if (this.zzd + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzku)).intValue()) <= jCurrentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkv)).intValue()) < jCurrentTimeMillis) {
                        this.zze = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.k("Shake detected.");
                    this.zzd = jCurrentTimeMillis;
                    int i3 = this.zze + 1;
                    this.zze = i3;
                    zzedt zzedtVar = this.zzf;
                    if (zzedtVar != null) {
                        if (i3 == ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkw)).intValue()) {
                            zzecr zzecrVar = (zzecr) zzedtVar;
                            zzecrVar.zzo(new zzeco(zzecrVar), zzecq.GESTURE);
                        }
                    }
                }
            }
        }
    }
}
