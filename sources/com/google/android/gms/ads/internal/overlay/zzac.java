package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbfk;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzdky;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzac extends zzbza implements zzbfk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdOverlayInfoParcel f70066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f70067b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f70071g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f70068c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f70069d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f70070f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f70072h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f70073i = false;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzac(android.app.Activity r3, com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f70068c = r0
            r2.f70069d = r0
            r2.f70070f = r0
            r2.f70072h = r0
            r2.f70073i = r0
            r2.f70066a = r4
            r2.f70067b = r3
            com.google.android.gms.internal.ads.zzbih r3 = com.google.android.gms.internal.ads.zzbiq.zzfH
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r3 = r1.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L48
            com.google.android.gms.internal.ads.zzbih r3 = com.google.android.gms.internal.ads.zzbiq.zzfI
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r3 = r1.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L48
            com.google.android.gms.internal.ads.zzbih r3 = com.google.android.gms.internal.ads.zzbiq.zzfM
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r3 = r1.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L79
        L48:
            com.google.android.gms.ads.internal.overlay.zzc r3 = r4.f70041a
            if (r3 == 0) goto L79
            boolean r3 = r3.f70083k
            if (r3 == 0) goto L79
            java.lang.String r3 = android.os.Build.MANUFACTURER
            com.google.android.gms.internal.ads.zzbih r4 = com.google.android.gms.internal.ads.zzbiq.zzfK
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r4 = r1.zzd(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r3 = r3.matches(r4)
            if (r3 == 0) goto L79
            java.lang.String r3 = android.os.Build.MODEL
            com.google.android.gms.internal.ads.zzbih r4 = com.google.android.gms.internal.ads.zzbiq.zzfL
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r4 = r1.zzd(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r3 = r3.matches(r4)
            if (r3 == 0) goto L79
            r0 = 1
        L79:
            r2.f70071g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzac.<init>(android.app.Activity, com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel):void");
    }

    private final synchronized void zzc() {
        try {
            if (!this.f70069d) {
                zzr zzrVar = this.f70066a.f70043c;
                if (zzrVar != null) {
                    zzrVar.zzdU(4);
                }
                this.f70069d = true;
                if (this.f70071g) {
                    if (((Boolean) zzba.c().zzd(zzbiq.zzfM)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.k().zzc(this);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z2) {
        if (!z2) {
            this.f70073i = true;
        } else if (this.f70073i) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Foregrounded: finishing activity from LauncherOverlay");
            this.f70067b.finish();
        }
    }

    final /* synthetic */ void zzb() {
        if (this.f70072h) {
            this.f70067b.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzf() {
        zzr zzrVar = this.f70066a.f70043c;
        if (zzrVar != null) {
            zzrVar.zzdv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean zzg() {
        return ((Boolean) zzba.c().zzd(zzbiq.zzfI)).booleanValue() && this.f70071g && this.f70072h;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzh(Bundle bundle) {
        zzr zzrVar;
        if (((Boolean) zzba.c().zzd(zzbiq.zzkm)).booleanValue() && !this.f70070f) {
            this.f70067b.requestWindowFeature(1);
        }
        boolean z2 = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z2 = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70066a;
        if (adOverlayInfoParcel == null) {
            this.f70067b.finish();
            return;
        }
        if (z2) {
            this.f70067b.finish();
            return;
        }
        if (bundle == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.f70042b;
            if (zzaVar != null) {
                zzaVar.onAdClicked();
            }
            zzdky zzdkyVar = adOverlayInfoParcel.f70061v;
            if (zzdkyVar != null) {
                zzdkyVar.zzdu();
            }
            Activity activity = this.f70067b;
            if (activity.getIntent() != null && activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
                zzrVar.zzh();
            }
        }
        if (this.f70071g) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzfM)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.k().zzb(this);
            }
        }
        Activity activity2 = this.f70067b;
        zzc zzcVar = adOverlayInfoParcel.f70041a;
        zzad zzadVar = adOverlayInfoParcel.f70049j;
        com.google.android.gms.ads.internal.zzt.e();
        if (zza.b(activity2, zzcVar, zzadVar, zzcVar.f70082j, null, "")) {
            return;
        }
        activity2.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzk() {
        if (this.f70068c) {
            com.google.android.gms.ads.internal.util.zze.k("LauncherOverlay finishing activity");
            this.f70067b.finish();
            return;
        }
        this.f70068c = true;
        this.f70072h = true;
        zzr zzrVar = this.f70066a.f70043c;
        if (zzrVar != null) {
            zzrVar.zzdx();
        }
        if (this.f70071g) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzfH)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.f70374l.postDelayed(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzab
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70065a.zzb();
                    }
                }, ((Integer) zzba.c().zzd(zzbiq.zzfJ)).intValue());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzl() {
        this.f70072h = false;
        zzr zzrVar = this.f70066a.f70043c;
        if (zzrVar != null) {
            zzrVar.zzdw();
        }
        if (this.f70067b.isFinishing()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f70068c);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzp() {
        if (this.f70067b.isFinishing()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzq() {
        if (this.f70067b.isFinishing()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzs() {
        this.f70070f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzn(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzH(int i3, String[] strArr, int[] iArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzm(int i3, int i4, Intent intent) {
    }
}
