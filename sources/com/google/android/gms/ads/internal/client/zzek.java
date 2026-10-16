package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbuy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbuy f69890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzq f69891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f69892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoController f69893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final zzaz f69894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zza f69895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AdListener f69896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdSize[] f69897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AppEventListener f69898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbu f69899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private VideoOptions f69900k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f69901l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ViewGroup f69902m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f69903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f69904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private OnPaidEventListener f69905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicLong f69906q;

    public zzek(ViewGroup viewGroup, int i3) {
        this(viewGroup, null, false, zzq.f70003a, null, i3);
    }

    private static zzr f(Context context, AdSize[] adSizeArr, int i3) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.f69653r)) {
                return new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false, false);
            }
        }
        zzr zzrVar = new zzr(context, adSizeArr);
        zzrVar.f70013k = g(i3);
        return zzrVar;
    }

    private static boolean g(int i3) {
        return i3 == 1;
    }

    public final void A(long j3) {
        this.f69906q.set(j3);
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzT(j3);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final OnPaidEventListener B() {
        return this.f69905p;
    }

    public final VideoController C() {
        return this.f69893d;
    }

    public final void a(VideoOptions videoOptions) {
        this.f69900k = videoOptions;
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzG(videoOptions == null ? null : new zzfw(videoOptions));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final VideoOptions b() {
        return this.f69900k;
    }

    public final boolean c(zzbu zzbuVar) {
        try {
            IObjectWrapper iObjectWrapperZzb = zzbuVar.zzb();
            if (iObjectWrapperZzb == null || ((View) ObjectWrapper.h5(iObjectWrapperZzb)).getParent() != null) {
                return false;
            }
            this.f69902m.addView((View) ObjectWrapper.h5(iObjectWrapperZzb));
            this.f69899j = zzbuVar;
            return true;
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            return false;
        }
    }

    final /* synthetic */ void d(IObjectWrapper iObjectWrapper) {
        this.f69902m.addView((View) ObjectWrapper.h5(iObjectWrapper));
    }

    final /* synthetic */ VideoController e() {
        return this.f69893d;
    }

    public final void h() {
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzc();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final AdListener i() {
        return this.f69896g;
    }

    public final AdSize j() {
        zzr zzrVarZzn;
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null && (zzrVarZzn = zzbuVar.zzn()) != null) {
                return com.google.android.gms.ads.zzc.a(zzrVarZzn.f70008f, zzrVarZzn.f70005b, zzrVarZzn.f70004a);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        AdSize[] adSizeArr = this.f69897h;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] k() {
        return this.f69897h;
    }

    public final String l() {
        zzbu zzbuVar;
        if (this.f69901l == null && (zzbuVar = this.f69899j) != null) {
            try {
                this.f69901l = zzbuVar.zzu();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
        return this.f69901l;
    }

    public final AppEventListener m() {
        return this.f69898i;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00be A[Catch: RemoteException -> 0x00bc, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x00bc, blocks: (B:25:0x008b, B:27:0x0091, B:29:0x009f, B:31:0x00b1, B:34:0x00be), top: B:55:0x008b, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(com.google.android.gms.ads.internal.client.zzeh r11) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzek.n(com.google.android.gms.ads.internal.client.zzeh):void");
    }

    public final void o() {
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzf();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void p() {
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzg();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void q(AdListener adListener) {
        this.f69896g = adListener;
        this.f69894e.d(adListener);
    }

    public final void r(zza zzaVar) {
        try {
            this.f69895f = zzaVar;
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzy(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void s(AdSize... adSizeArr) {
        if (this.f69897h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        t(adSizeArr);
    }

    public final void t(AdSize... adSizeArr) {
        this.f69897h = adSizeArr;
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzo(f(this.f69902m.getContext(), this.f69897h, this.f69903n));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        this.f69902m.requestLayout();
    }

    public final void u(String str) {
        if (this.f69901l != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f69901l = str;
    }

    public final void v(AppEventListener appEventListener) {
        try {
            this.f69898i = appEventListener;
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzi(appEventListener != null ? new zzbff(appEventListener) : null);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void w(boolean z2) {
        this.f69904o = z2;
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzz(z2);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final ResponseInfo x() {
        zzdx zzdxVarZzt = null;
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzdxVarZzt = zzbuVar.zzt();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        return ResponseInfo.e(zzdxVarZzt);
    }

    public final void y(OnPaidEventListener onPaidEventListener) {
        try {
            this.f69905p = onPaidEventListener;
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                zzbuVar.zzP(new zzfo(onPaidEventListener));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final long z() {
        AtomicLong atomicLong = this.f69906q;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        try {
            zzbu zzbuVar = this.f69899j;
            if (zzbuVar != null) {
                atomicLong.set(zzbuVar.zzU());
                return atomicLong.get();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        return 0L;
    }

    zzek(ViewGroup viewGroup, AttributeSet attributeSet, boolean z2, zzq zzqVar, zzbu zzbuVar, int i3) {
        zzr zzrVar;
        this.f69890a = new zzbuy();
        this.f69893d = new VideoController();
        this.f69894e = new zzei(this);
        this.f69906q = new AtomicLong();
        this.f69902m = viewGroup;
        this.f69891b = zzqVar;
        this.f69899j = null;
        this.f69892c = new AtomicBoolean(false);
        this.f69903n = i3;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzz zzzVar = new zzz(context, attributeSet);
                this.f69897h = zzzVar.a(z2);
                this.f69901l = zzzVar.b();
                if (viewGroup.isInEditMode()) {
                    com.google.android.gms.ads.internal.util.client.zzf zzfVarA = zzay.a();
                    AdSize adSize = this.f69897h[0];
                    int i4 = this.f69903n;
                    if (adSize.equals(AdSize.f69653r)) {
                        zzrVar = new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false, false);
                    } else {
                        zzrVar = new zzr(context, adSize);
                        zzrVar.f70013k = g(i4);
                    }
                    zzfVarA.n(viewGroup, zzrVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e3) {
                zzay.a().m(viewGroup, new zzr(context, AdSize.f69645j), e3.getMessage(), e3.getMessage());
            }
        }
    }

    public final zzea D() {
        zzbu zzbuVar = this.f69899j;
        if (zzbuVar != null) {
            try {
                return zzbuVar.zzF();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i(qRMDmh.OanTgYiRE, e3);
            }
        }
        return null;
    }
}
