package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecd extends zzgap {

    @Nullable
    private final SensorManager zza;

    @Nullable
    private final Sensor zzb;
    private float zzc;
    private Float zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;

    @Nullable
    private zzecc zzi;
    private boolean zzj;

    zzecd(Context context) {
        super("FlickDetector", "ads");
        this.zzc = 0.0f;
        this.zzd = Float.valueOf(0.0f);
        this.zze = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
        this.zzf = 0;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
        this.zzj = false;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.zza = sensorManager;
        if (sensorManager != null) {
            this.zzb = sensorManager.getDefaultSensor(4);
        } else {
            this.zzb = null;
        }
    }

    public final void zza(zzecc zzeccVar) {
        this.zzi = zzeccVar;
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkx)).booleanValue()) {
                    if (!this.zzj && (sensorManager = this.zza) != null && (sensor = this.zzb) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.zzj = true;
                        com.google.android.gms.ads.internal.util.zze.k("Listening for flick gestures.");
                    }
                    if (this.zza == null || this.zzb == null) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Flick detection failed to initialize. Failed to obtain gyroscope.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (this.zzj && (sensorManager = this.zza) != null && (sensor = this.zzb) != null) {
                    sensorManager.unregisterListener(this, sensor);
                    this.zzj = false;
                    com.google.android.gms.ads.internal.util.zze.k("Stopped listening for flick gestures.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgap
    public final void zzd(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkx)).booleanValue()) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            if (this.zze + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkz)).intValue()) < jCurrentTimeMillis) {
                this.zzf = 0;
                this.zze = jCurrentTimeMillis;
                this.zzg = false;
                this.zzh = false;
                this.zzc = this.zzd.floatValue();
            }
            Float fValueOf = Float.valueOf(this.zzd.floatValue() + (sensorEvent.values[1] * 4.0f));
            this.zzd = fValueOf;
            float fFloatValue = fValueOf.floatValue();
            float f3 = this.zzc;
            zzbih zzbihVar = zzbiq.zzky;
            if (fFloatValue > f3 + ((Float) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).floatValue()) {
                this.zzc = this.zzd.floatValue();
                this.zzh = true;
            } else if (this.zzd.floatValue() < this.zzc - ((Float) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).floatValue()) {
                this.zzc = this.zzd.floatValue();
                this.zzg = true;
            }
            if (this.zzd.isInfinite()) {
                this.zzd = Float.valueOf(0.0f);
                this.zzc = 0.0f;
            }
            if (this.zzg && this.zzh) {
                com.google.android.gms.ads.internal.util.zze.k("Flick detected.");
                this.zze = jCurrentTimeMillis;
                int i3 = this.zzf + 1;
                this.zzf = i3;
                this.zzg = false;
                this.zzh = false;
                zzecc zzeccVar = this.zzi;
                if (zzeccVar != null) {
                    if (i3 == ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkA)).intValue()) {
                        zzecr zzecrVar = (zzecr) zzeccVar;
                        zzecrVar.zzo(new zzecp(zzecrVar), zzecq.GESTURE);
                    }
                }
            }
        }
    }
}
