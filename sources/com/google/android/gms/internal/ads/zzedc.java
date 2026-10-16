package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzedc implements com.google.android.gms.ads.internal.overlay.zzr, zzcmq {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzecr zzc;
    private zzcku zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private com.google.android.gms.ads.internal.client.zzdk zzh;
    private boolean zzi;

    zzedc(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzq(com.google.android.gms.ads.internal.client.zzdk zzdkVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector had an internal error.");
            try {
                zzdkVar.zze(zzfma.zzd(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        }
        if (this.zzc == null) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector had an internal error.");
            try {
                com.google.android.gms.ads.internal.zzt.l().zzg(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzdkVar.zze(zzfma.zzd(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        }
        if (!this.zze && !this.zzf) {
            if (com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() >= this.zzg + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkr)).intValue())) {
                return true;
            }
        }
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector cannot be opened because it is already open.");
        try {
            zzdkVar.zze(zzfma.zzd(19, null, null));
        } catch (RemoteException unused3) {
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcmq
    public final synchronized void zza(boolean z2, int i3, String str, String str2) {
        if (z2) {
            com.google.android.gms.ads.internal.util.zze.k("Ad inspector loaded.");
            this.zze = true;
            zzn();
            return;
        }
        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector failed to load.");
        try {
            zzcfd zzcfdVarL = com.google.android.gms.ads.internal.zzt.l();
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 46 + String.valueOf(str).length() + 15 + String.valueOf(str2).length());
            sb.append("Failed to load UI. Error code: ");
            sb.append(i3);
            sb.append(", Description: ");
            sb.append(str);
            sb.append(", Failing URL: ");
            sb.append(str2);
            zzcfdVarL.zzg(new Exception(sb.toString()), "InspectorUi.onAdWebViewFinishedLoading 0");
            com.google.android.gms.ads.internal.client.zzdk zzdkVar = this.zzh;
            if (zzdkVar != null) {
                zzdkVar.zze(zzfma.zzd(17, null, null));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdU(int i3) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.k("Inspector closed.");
            com.google.android.gms.ads.internal.client.zzdk zzdkVar = this.zzh;
            if (zzdkVar != null) {
                try {
                    zzdkVar.zze(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0L;
        this.zzi = false;
        this.zzh = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        this.zzf = true;
        zzn();
    }

    public final void zzl(zzecr zzecrVar) {
        this.zzc = zzecrVar;
    }

    public final synchronized void zzm(com.google.android.gms.ads.internal.client.zzdk zzdkVar, zzbql zzbqlVar, zzbqe zzbqeVar, zzbpr zzbprVar) {
        if (zzq(zzdkVar)) {
            try {
                com.google.android.gms.ads.internal.zzt.h();
                zzcku zzckuVarZza = zzclk.zza(this.zza, zzcne.zzb(), "", false, false, null, null, this.zzb, null, null, null, zzbhp.zza(), null, null, null, null, null);
                this.zzd = zzckuVarZza;
                zzcms zzcmsVarZzP = zzckuVarZza.zzP();
                if (zzcmsVarZzP == null) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Failed to obtain a web view for the ad inspector");
                    try {
                        com.google.android.gms.ads.internal.zzt.l().zzg(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                        zzdkVar.zze(zzfma.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                        return;
                    } catch (RemoteException e3) {
                        com.google.android.gms.ads.internal.zzt.l().zzg(e3, "InspectorUi.openInspector 3");
                        return;
                    }
                }
                this.zzh = zzdkVar;
                Context context = this.zza;
                zzcmsVarZzP.zzab(null, null, null, null, null, false, null, null, null, null, null, null, null, zzbqlVar, null, new zzbqk(context), zzbqeVar, zzbprVar, null, null, null, null);
                zzcmsVarZzP.zzG(this);
                this.zzd.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkp));
                com.google.android.gms.ads.internal.zzt.f();
                com.google.android.gms.ads.internal.overlay.zzn.a(context, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true, null);
                this.zzg = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            } catch (zzclj e4) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Failed to obtain a web view for the ad inspector", e4);
                try {
                    com.google.android.gms.ads.internal.zzt.l().zzg(e4, "InspectorUi.openInspector 0");
                    zzdkVar.zze(zzfma.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                } catch (RemoteException e5) {
                    com.google.android.gms.ads.internal.zzt.l().zzg(e5, "InspectorUi.openInspector 1");
                }
            }
        }
    }

    public final synchronized void zzn() {
        if (this.zze && this.zzf) {
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedb
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp();
                }
            });
        }
    }

    public final Activity zzo() {
        zzcku zzckuVar = this.zzd;
        if (zzckuVar == null || zzckuVar.zzX()) {
            return null;
        }
        return this.zzd.zzj();
    }

    final /* synthetic */ void zzp() {
        this.zzd.zzc("window.inspectorInfo", this.zzc.zzr().toString());
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdT() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdq() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdx() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdy() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdz() {
    }
}
