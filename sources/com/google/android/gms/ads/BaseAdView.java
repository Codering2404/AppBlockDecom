package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzek;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbzy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAdView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final zzek f69669a;

    protected BaseAdView(Context context, int i3) {
        super(context);
        this.f69669a = new zzek(this, i3);
    }

    public void a() {
        zzbiq.zza(getContext());
        if (((Boolean) zzbko.zze.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmA)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.zzg
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        BaseAdView baseAdView = this.f70855a;
                        try {
                            baseAdView.f69669a.h();
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(baseAdView.getContext()).zzh(e3, "BaseAdView.destroy");
                        }
                    }
                });
                return;
            }
        }
        this.f69669a.h();
    }

    public void b(final AdRequest adRequest) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(getContext());
        if (((Boolean) zzbko.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.zzd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AdRequest adRequest2 = adRequest;
                        BaseAdView baseAdView = this.f70851a;
                        try {
                            baseAdView.f69669a.n(adRequest2.f69644a);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(baseAdView.getContext()).zzh(e3, "BaseAdView.loadAd");
                        }
                    }
                });
                return;
            }
        }
        this.f69669a.n(adRequest.f69644a);
    }

    public void c() {
        zzbiq.zza(getContext());
        if (((Boolean) zzbko.zzg.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmB)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.zze
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        BaseAdView baseAdView = this.f70853a;
                        try {
                            baseAdView.f69669a.o();
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(baseAdView.getContext()).zzh(e3, "BaseAdView.pause");
                        }
                    }
                });
                return;
            }
        }
        this.f69669a.o();
    }

    public void d() {
        zzbiq.zza(getContext());
        if (((Boolean) zzbko.zzh.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmz)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.zzf
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        BaseAdView baseAdView = this.f70854a;
                        try {
                            baseAdView.f69669a.p();
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(baseAdView.getContext()).zzh(e3, "BaseAdView.resume");
                        }
                    }
                });
                return;
            }
        }
        this.f69669a.p();
    }

    public AdListener getAdListener() {
        return this.f69669a.i();
    }

    public AdSize getAdSize() {
        return this.f69669a.j();
    }

    public String getAdUnitId() {
        return this.f69669a.l();
    }

    public OnPaidEventListener getOnPaidEventListener() {
        return this.f69669a.B();
    }

    public long getPlacementId() {
        return this.f69669a.z();
    }

    public ResponseInfo getResponseInfo() {
        return this.f69669a.x();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i7 = ((i5 - i3) - measuredWidth) / 2;
        int i8 = ((i6 - i4) - measuredHeight) / 2;
        childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        AdSize adSize;
        int iC;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e3) {
                zzo.d("Unable to retrieve ad size.", e3);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int iE = adSize.e(context);
                iC = adSize.c(context);
                measuredWidth = iE;
            } else {
                iC = 0;
            }
        } else {
            measureChild(childAt, i3, i4);
            measuredWidth = childAt.getMeasuredWidth();
            iC = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(iC, getSuggestedMinimumHeight()), i4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        zzek zzekVar = this.f69669a;
        zzekVar.q(adListener);
        if (adListener == 0) {
            zzekVar.r(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            zzekVar.r((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            zzekVar.v((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f69669a.s(adSize);
    }

    public void setAdUnitId(String str) {
        this.f69669a.u(str);
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.f69669a.y(onPaidEventListener);
    }

    public void setPlacementId(long j3) {
        this.f69669a.A(j3);
    }
}
