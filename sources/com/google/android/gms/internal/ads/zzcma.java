package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcma extends com.google.android.gms.ads.internal.client.zzdz {
    private final zzchn zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private com.google.android.gms.ads.internal.client.zzed zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbnj zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcma(zzchn zzchnVar, float f3, boolean z2, boolean z3) {
        this.zza = zzchnVar;
        this.zzi = f3;
        this.zzc = z2;
        this.zzd = z3;
    }

    private final void zzw(String str, Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzt(map2);
            }
        });
    }

    private final void zzx(final int i3, final int i4, final boolean z2, final boolean z3) {
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcly
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(i3, i4, z2, z3);
            }
        });
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfw zzfwVar) {
        Object obj = this.zzb;
        boolean z2 = zzfwVar.f69957b;
        boolean z3 = zzfwVar.f69958c;
        synchronized (obj) {
            this.zzl = z2;
            this.zzm = z3;
        }
        boolean z4 = zzfwVar.f69956a;
        zzw("initialState", CollectionUtils.c("muteStart", true != z4 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES, "customControlsRequested", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES, "clickToExpandRequested", true != z3 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES));
    }

    public final void zzd(float f3) {
        synchronized (this.zzb) {
            this.zzj = f3;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final void zze() {
        zzw("play", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final void zzf() {
        zzw("pause", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final void zzg(boolean z2) {
        zzw(true != z2 ? "unmute" : "mute", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final boolean zzh() {
        boolean z2;
        synchronized (this.zzb) {
            z2 = this.zzh;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final int zzi() {
        int i3;
        synchronized (this.zzb) {
            i3 = this.zze;
        }
        return i3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final float zzj() {
        float f3;
        synchronized (this.zzb) {
            f3 = this.zzi;
        }
        return f3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final float zzk() {
        float f3;
        synchronized (this.zzb) {
            f3 = this.zzj;
        }
        return f3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final void zzl(com.google.android.gms.ads.internal.client.zzed zzedVar) {
        synchronized (this.zzb) {
            this.zzf = zzedVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final float zzm() {
        float f3;
        synchronized (this.zzb) {
            f3 = this.zzk;
        }
        return f3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final boolean zzn() {
        boolean z2;
        synchronized (this.zzb) {
            try {
                z2 = false;
                if (this.zzc && this.zzl) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final com.google.android.gms.ads.internal.client.zzed zzo() throws RemoteException {
        com.google.android.gms.ads.internal.client.zzed zzedVar;
        synchronized (this.zzb) {
            zzedVar = this.zzf;
        }
        return zzedVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final boolean zzp() {
        boolean z2;
        Object obj = this.zzb;
        boolean zZzn = zzn();
        synchronized (obj) {
            z2 = false;
            if (!zZzn) {
                try {
                    if (this.zzm && this.zzd) {
                        z2 = true;
                    }
                } finally {
                }
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final void zzq() {
        zzw("stop", null);
    }

    public final void zzr() {
        boolean z2;
        int i3;
        synchronized (this.zzb) {
            z2 = this.zzh;
            i3 = this.zze;
            this.zze = 3;
        }
        zzx(i3, 3, z2, z2);
    }

    public final void zzs(float f3, float f4, int i3, boolean z2, float f5) {
        boolean z3;
        boolean z4;
        int i4;
        synchronized (this.zzb) {
            try {
                z3 = true;
                if (f4 == this.zzi && f5 == this.zzk) {
                    z3 = false;
                }
                this.zzi = f4;
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzom)).booleanValue()) {
                    this.zzj = f3;
                }
                z4 = this.zzh;
                this.zzh = z2;
                i4 = this.zze;
                this.zze = i3;
                float f6 = this.zzk;
                this.zzk = f5;
                if (Math.abs(f5 - f6) > 1.0E-4f) {
                    this.zza.zzE().invalidate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            try {
                zzbnj zzbnjVar = this.zzn;
                if (zzbnjVar != null) {
                    zzbnjVar.zze();
                }
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
        zzx(i4, i3, z4, z2);
    }

    final /* synthetic */ void zzt(Map map) {
        this.zza.zze("pubVideoCmd", map);
    }

    final /* synthetic */ void zzu(int i3, int i4, boolean z2, boolean z3) {
        int i5;
        boolean z4;
        boolean z5;
        com.google.android.gms.ads.internal.client.zzed zzedVar;
        com.google.android.gms.ads.internal.client.zzed zzedVar2;
        com.google.android.gms.ads.internal.client.zzed zzedVar3;
        synchronized (this.zzb) {
            try {
                boolean z6 = this.zzg;
                if (z6 || i4 != 1) {
                    i5 = i4;
                    z4 = false;
                } else {
                    i4 = 1;
                    i5 = 1;
                    z4 = true;
                }
                boolean z7 = i3 != i4;
                if (z7 && i5 == 1) {
                    z5 = true;
                    i5 = 1;
                } else {
                    z5 = false;
                }
                boolean z8 = z7 && i5 == 2;
                boolean z9 = z7 && i5 == 3;
                this.zzg = z6 || z4;
                if (z4) {
                    try {
                        com.google.android.gms.ads.internal.client.zzed zzedVar4 = this.zzf;
                        if (zzedVar4 != null) {
                            zzedVar4.zze();
                        }
                    } catch (RemoteException e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                    }
                }
                if (z5 && (zzedVar3 = this.zzf) != null) {
                    zzedVar3.zzf();
                }
                if (z8 && (zzedVar2 = this.zzf) != null) {
                    zzedVar2.zzg();
                }
                if (z9) {
                    com.google.android.gms.ads.internal.client.zzed zzedVar5 = this.zzf;
                    if (zzedVar5 != null) {
                        zzedVar5.zzh();
                    }
                    this.zza.zzz();
                }
                if (z2 != z3 && (zzedVar = this.zzf) != null) {
                    zzedVar.t1(z3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzv(zzbnj zzbnjVar) {
        synchronized (this.zzb) {
            this.zzn = zzbnjVar;
        }
    }
}
