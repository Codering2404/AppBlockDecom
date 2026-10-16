package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbyg;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzdde;
import com.google.android.gms.internal.ads.zzdky;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzl;
import com.google.android.gms.internal.ads.zzeks;
import com.google.android.gms.internal.ads.zzekt;
import com.google.android.gms.internal.ads.zzell;
import com.google.android.gms.internal.ads.zzeln;
import com.google.android.gms.internal.ads.zzgam;
import com.google.android.gms.internal.ads.zzgua;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzm extends zzbza implements zzah {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f70098x = Color.argb(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Activity f70099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AdOverlayInfoParcel f70100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    zzcku f70101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    zzj f70102d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    zzu f70103f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    FrameLayout f70105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    WebChromeClient.CustomViewCallback f70106i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    zzi f70109l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f70113p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f70114q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f70115r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Toolbar f70119v;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f70104g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f70107j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f70108k = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f70110m = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f70120w = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f70111n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final View.OnClickListener f70112o = new zzd(this);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f70116s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f70117t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f70118u = true;

    public zzm(Activity activity) {
        this.f70099a = activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void k5(android.content.res.Configuration r7) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.k5(android.content.res.Configuration):void");
    }

    private final void l5(View view) {
        zzeln zzelnVarZzU;
        zzell zzellVarZzV;
        zzcku zzckuVar = this.f70101c;
        if (zzckuVar == null) {
            return;
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzgn)).booleanValue() && (zzellVarZzV = zzckuVar.zzV()) != null) {
            zzellVarZzV.zzf(view);
        } else if (((Boolean) zzba.c().zzd(zzbiq.zzgm)).booleanValue() && (zzelnVarZzU = zzckuVar.zzU()) != null && zzelnVarZzU.zzb()) {
            com.google.android.gms.ads.internal.zzt.y().zzg(zzelnVarZzU.zza(), view);
        }
    }

    private static final void m5(zzeln zzelnVar, View view) {
        if (zzelnVar == null || view == null) {
            return;
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzgm)).booleanValue() && zzelnVar.zzb()) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.y().zzh(zzelnVar.zza(), view);
    }

    final void h5() {
        zzcku zzckuVar;
        zzr zzrVar;
        if (this.f70117t) {
            return;
        }
        this.f70117t = true;
        zzcku zzckuVar2 = this.f70101c;
        if (zzckuVar2 != null) {
            this.f70109l.removeView(zzckuVar2.zzE());
            zzj zzjVar = this.f70102d;
            if (zzjVar != null) {
                this.f70101c.zzai(zzjVar.f70094d);
                this.f70101c.zzag(false);
                if (((Boolean) zzba.c().zzd(zzbiq.zzog)).booleanValue() && this.f70101c.getParent() != null) {
                    ((ViewGroup) this.f70101c.getParent()).removeView(this.f70101c.zzE());
                }
                ViewGroup viewGroup = this.f70102d.f70093c;
                View viewZzE = this.f70101c.zzE();
                zzj zzjVar2 = this.f70102d;
                viewGroup.addView(viewZzE, zzjVar2.f70091a, zzjVar2.f70092b);
                this.f70102d = null;
            } else {
                Activity activity = this.f70099a;
                if (activity.getApplicationContext() != null) {
                    this.f70101c.zzai(activity.getApplicationContext());
                }
            }
            this.f70101c = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
            zzrVar.zzdU(this.f70120w);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.f70100b;
        if (adOverlayInfoParcel2 == null || (zzckuVar = adOverlayInfoParcel2.f70044d) == null) {
            return;
        }
        m5(zzckuVar.zzU(), this.f70100b.f70044d.zzE());
    }

    public final void i5() {
        synchronized (this.f70111n) {
            try {
                this.f70114q = true;
                Runnable runnable = this.f70113p;
                if (runnable != null) {
                    zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.f70374l;
                    zzgamVar.removeCallbacks(runnable);
                    zzgamVar.post(this.f70113p);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j5(zzekt zzektVar) throws RemoteException, zzh {
        zzbyu zzbyuVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel == null || (zzbyuVar = adOverlayInfoParcel.f70062w) == null) {
            throw new zzh("noioou");
        }
        zzbyuVar.zzh(ObjectWrapper.i5(zzektVar));
    }

    public final void n5(boolean z2, boolean z3) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzl zzlVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        boolean z4 = true;
        boolean z5 = ((Boolean) zzba.c().zzd(zzbiq.zzbK)).booleanValue() && (adOverlayInfoParcel2 = this.f70100b) != null && (zzlVar2 = adOverlayInfoParcel2.f70055p) != null && zzlVar2.f70429i;
        boolean z6 = ((Boolean) zzba.c().zzd(zzbiq.zzbL)).booleanValue() && (adOverlayInfoParcel = this.f70100b) != null && (zzlVar = adOverlayInfoParcel.f70055p) != null && zzlVar.f70430j;
        if (z2 && z3 && z5 && !z6) {
            new zzbyg(this.f70101c, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzu zzuVar = this.f70103f;
        if (zzuVar != null) {
            if (!z6 && (!z3 || z5)) {
                z4 = false;
            }
            zzuVar.a(z4);
        }
    }

    public final void o5(int i3) {
        Activity activity = this.f70099a;
        if (activity.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.c().zzd(zzbiq.zzgV)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.c().zzd(zzbiq.zzgW)).intValue()) {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= ((Integer) zzba.c().zzd(zzbiq.zzgX)).intValue()) {
                    if (i4 <= ((Integer) zzba.c().zzd(zzbiq.zzgY)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i3);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzh(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void p5(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.f70099a;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f70105h = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.f70105h.addView(view, -1, -1);
        activity.setContentView(this.f70105h);
        this.f70115r = true;
        this.f70106i = customViewCallback;
        this.f70104g = true;
    }

    public final void q5(String str) {
        Toolbar toolbar = this.f70119v;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    protected final void x3() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzrVar;
        if (!this.f70099a.isFinishing() || this.f70116s) {
            return;
        }
        this.f70116s = true;
        zzcku zzckuVar = this.f70101c;
        if (zzckuVar != null) {
            zzckuVar.zzH(this.f70120w - 1);
            synchronized (this.f70111n) {
                try {
                    if (!this.f70114q && this.f70101c.zzaa()) {
                        if (((Boolean) zzba.c().zzd(zzbiq.zzfY)).booleanValue() && !this.f70117t && (adOverlayInfoParcel = this.f70100b) != null && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
                            zzrVar.zzdT();
                        }
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzf
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.f70087a.h5();
                            }
                        };
                        this.f70113p = runnable;
                        com.google.android.gms.ads.internal.util.zzs.f70374l.postDelayed(runnable, ((Long) zzba.c().zzd(zzbiq.zzbJ)).longValue());
                        return;
                    }
                } finally {
                }
            }
        }
        h5();
    }

    public final void zzC() {
        if (this.f70110m) {
            this.f70110m = false;
            zzD();
        }
    }

    protected final void zzD() {
        this.f70101c.zzI();
    }

    public final void zzE() {
        this.f70109l.f70090b = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzH(int i3, String[] strArr, int[] iArr) {
        if (i3 == 12345) {
            Activity activity = this.f70099a;
            zzeks zzeksVarZze = zzekt.zze();
            zzeksVarZze.zza(activity);
            zzeksVarZze.zzb(this.f70100b.f70051l == 5 ? this : null);
            try {
                this.f70100b.f70062w.zzi(strArr, iArr, ObjectWrapper.i5(zzeksVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void zzb() {
        this.f70120w = 3;
        Activity activity = this.f70099a;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.f70051l != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        zzcku zzckuVar = this.f70101c;
        if (zzckuVar != null) {
            zzckuVar.zzae(null);
        }
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel != null && this.f70104g) {
            o5(adOverlayInfoParcel.f70050k);
        }
        if (this.f70105h != null) {
            this.f70099a.setContentView(this.f70109l);
            this.f70115r = true;
            this.f70105h.removeAllViews();
            this.f70105h = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.f70106i;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.f70106i = null;
        }
        this.f70104g = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzah
    public final void zzd() {
        this.f70120w = 2;
        this.f70099a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zze() {
        this.f70120w = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzf() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.f70043c) == null) {
            return;
        }
        zzrVar.zzdv();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean zzg() {
        this.f70120w = 1;
        if (this.f70101c == null) {
            return true;
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzko)).booleanValue() && this.f70101c.canGoBack()) {
            this.f70101c.goBack();
            return false;
        }
        boolean zZzZ = this.f70101c.zzZ();
        if (!zZzZ) {
            this.f70101c.zze("onbackblocked", Collections.EMPTY_MAP);
        }
        return zZzZ;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public void zzh(Bundle bundle) {
        zzr zzrVar;
        if (!this.f70115r) {
            this.f70099a.requestWindowFeature(1);
        }
        this.f70107j = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            Activity activity = this.f70099a;
            AdOverlayInfoParcel adOverlayInfoParcelM = AdOverlayInfoParcel.M(activity.getIntent());
            this.f70100b = adOverlayInfoParcelM;
            if (adOverlayInfoParcelM == null) {
                throw new zzh("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelM.f70063x) {
                activity.setShowWhenLocked(true);
            }
            if (this.f70100b.f70053n.f70151c > 7500000) {
                this.f70120w = 4;
            }
            if (activity.getIntent() != null) {
                this.f70118u = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
            com.google.android.gms.ads.internal.zzl zzlVar = adOverlayInfoParcel.f70055p;
            if (zzlVar != null) {
                boolean z2 = zzlVar.f70422a;
                this.f70108k = z2;
                if (z2) {
                    if (adOverlayInfoParcel.f70051l != 5 && zzlVar.f70427g != -1) {
                        new zzl(this, null).zzb();
                    }
                }
            } else if (adOverlayInfoParcel.f70051l == 5) {
                this.f70108k = true;
                if (adOverlayInfoParcel.f70051l != 5) {
                    new zzl(this, null).zzb();
                }
            } else {
                this.f70108k = false;
            }
            if (bundle == null) {
                if (this.f70118u) {
                    zzdde zzddeVar = this.f70100b.f70060u;
                    if (zzddeVar != null) {
                        zzddeVar.zza();
                    }
                    zzr zzrVar2 = this.f70100b.f70043c;
                    if (zzrVar2 != null) {
                        zzrVar2.zzh();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.f70100b;
                if (adOverlayInfoParcel2.f70051l != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.f70042b;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzdky zzdkyVar = this.f70100b.f70061v;
                    if (zzdkyVar != null) {
                        zzdkyVar.zzdu();
                    }
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.f70100b;
            if (adOverlayInfoParcel3 != null && (zzrVar = adOverlayInfoParcel3.f70043c) != null) {
                zzrVar.zzdo();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.f70100b;
            zzi zziVar = new zzi(activity, adOverlayInfoParcel4.f70054o, adOverlayInfoParcel4.f70053n.f70149a, adOverlayInfoParcel4.f70059t);
            this.f70109l = zziVar;
            zziVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.j().i(activity);
            AdOverlayInfoParcel adOverlayInfoParcel5 = this.f70100b;
            int i3 = adOverlayInfoParcel5.f70051l;
            if (i3 == 1) {
                zzy(false);
                return;
            }
            if (i3 == 2) {
                this.f70102d = new zzj(adOverlayInfoParcel5.f70044d);
                zzy(false);
            } else if (i3 == 3) {
                zzy(true);
            } else {
                if (i3 != 5) {
                    throw new zzh("Could not determine ad overlay type.");
                }
                zzy(false);
            }
        } catch (zzh e3) {
            String message = e3.getMessage();
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(message);
            this.f70120w = 4;
            this.f70099a.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzi() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.f70043c) == null) {
            return;
        }
        zzrVar.zzdq();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzj() {
        zzr zzrVar;
        if (((Boolean) zzba.c().zzd(zzbiq.zzga)).booleanValue()) {
            zzcku zzckuVar = this.f70101c;
            if (zzckuVar == null || zzckuVar.zzX()) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("The webview does not exist. Ignoring action.");
            } else {
                this.f70101c.onResume();
            }
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.f70043c) == null) {
            return;
        }
        zzrVar.zzdp();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzk() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
            zzrVar.zzdx();
        }
        k5(this.f70099a.getResources().getConfiguration());
        if (((Boolean) zzba.c().zzd(zzbiq.zzga)).booleanValue()) {
            return;
        }
        zzcku zzckuVar = this.f70101c;
        if (zzckuVar != null && !zzckuVar.zzX()) {
            this.f70101c.onResume();
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzl() {
        zzr zzrVar;
        zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
            zzrVar.zzdw();
        }
        if (!((Boolean) zzba.c().zzd(zzbiq.zzga)).booleanValue() && this.f70101c != null && (!this.f70099a.isFinishing() || this.f70102d == null)) {
            this.f70101c.onPause();
        }
        x3();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzm(int i3, int i4, Intent intent) {
        zzdzl zzdzlVarZzI;
        AdOverlayInfoParcel adOverlayInfoParcel;
        if (i3 == 236) {
            zzbih zzbihVar = zzbiq.zzoE;
            if (((Boolean) zzba.c().zzd(zzbihVar)).booleanValue()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 66);
                sb.append("Callback from intent launch with requestCode: 236 and resultCode: ");
                sb.append(i4);
                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                zzcku zzckuVar = this.f70101c;
                if (zzckuVar == null || zzckuVar.zzP() == null || (zzdzlVarZzI = zzckuVar.zzP().zzI()) == null || (adOverlayInfoParcel = this.f70100b) == null || !((Boolean) zzba.c().zzd(zzbihVar)).booleanValue()) {
                    return;
                }
                zzdzk zzdzkVarZza = zzdzlVarZzI.zza();
                zzdzkVarZza.zzc("action", "hilca");
                zzdzkVarZza.zzc("gqi", zzgua.zza(adOverlayInfoParcel.f70057r));
                StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length());
                sb2.append(i4);
                zzdzkVarZza.zzc("hilr", sb2.toString());
                if (i4 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("callerPackage");
                    String stringExtra2 = intent.getStringExtra("loadingStage");
                    if (stringExtra != null) {
                        zzdzkVarZza.zzc("hilcp", stringExtra);
                    }
                    if (stringExtra2 != null) {
                        zzdzkVarZza.zzc("hills", stringExtra2);
                    }
                }
                zzdzkVarZza.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzn(IObjectWrapper iObjectWrapper) {
        k5((Configuration) ObjectWrapper.h5(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f70107j);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzp() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
            zzrVar.zzdy();
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzga)).booleanValue() && this.f70101c != null && (!this.f70099a.isFinishing() || this.f70102d == null)) {
            this.f70101c.onPause();
        }
        x3();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzq() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f70100b;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f70043c) != null) {
            zzrVar.zzdz();
        }
        zzcku zzckuVar = this.f70101c;
        if (zzckuVar != null) {
            try {
                this.f70109l.removeView(zzckuVar.zzE());
            } catch (NullPointerException unused) {
            }
        }
        x3();
    }

    public final void zzr(boolean z2) {
        if (this.f70100b.f70063x) {
            return;
        }
        int iIntValue = ((Integer) zzba.c().zzd(zzbiq.zzgd)).intValue();
        boolean z3 = ((Boolean) zzba.c().zzd(zzbiq.zzbM)).booleanValue() || z2;
        zzt zztVar = new zzt();
        zztVar.f70136d = 50;
        zztVar.f70133a = true != z3 ? 0 : iIntValue;
        zztVar.f70134b = true != z3 ? iIntValue : 0;
        zztVar.f70135c = iIntValue;
        this.f70103f = new zzu(this.f70099a, zztVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z3 ? 9 : 11);
        n5(z2, this.f70100b.f70047h);
        this.f70109l.addView(this.f70103f, layoutParams);
        l5(this.f70103f);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzs() {
        this.f70115r = true;
    }

    public final void zzu(boolean z2) {
        if (z2) {
            this.f70109l.setBackgroundColor(0);
        } else {
            this.f70109l.setBackgroundColor(-16777216);
        }
    }

    public final void zzv() {
        this.f70109l.removeView(this.f70103f);
        zzr(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzy(boolean r45) throws com.google.android.gms.ads.internal.overlay.zzh {
        /*
            Method dump skipped, instruction units count: 795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzy(boolean):void");
    }
}
