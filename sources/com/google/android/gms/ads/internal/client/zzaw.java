package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcaa;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzccu;
import com.google.android.gms.internal.ads.zzcem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzk f69821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzi f69822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzfc f69823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbnx f69824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbyy f69825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzcaa f69826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzl f69827g;

    public zzaw(zzk zzkVar, zzi zziVar, zzfc zzfcVar, zzbnx zzbnxVar, zzccu zzccuVar, zzbyy zzbyyVar, zzbny zzbnyVar, zzl zzlVar) {
        this.f69821a = zzkVar;
        this.f69822b = zziVar;
        this.f69823c = zzfcVar;
        this.f69824d = zzbnxVar;
        this.f69825e = zzbyyVar;
        this.f69827g = zzlVar;
    }

    static /* synthetic */ void l(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.a().t(context, zzay.g().f70149a, "gmob-apps", bundle, true);
    }

    public final zzbu a(Context context, zzr zzrVar, String str, zzbvc zzbvcVar) {
        return (zzbu) new zzam(this, context, zzrVar, str, zzbvcVar).d(context, false);
    }

    public final zzbu b(Context context, zzr zzrVar, String str, zzbvc zzbvcVar) {
        return (zzbu) new zzan(this, context, zzrVar, str, zzbvcVar).d(context, false);
    }

    public final zzbq c(Context context, String str, zzbvc zzbvcVar) {
        return (zzbq) new zzap(this, context, str, zzbvcVar).d(context, false);
    }

    public final zzch d(Context context, zzbvc zzbvcVar) {
        return (zzch) new zzar(this, context, zzbvcVar).d(context, false);
    }

    public final zzbmi e(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbmi) new zzav(this, frameLayout, frameLayout2, context).d(context, false);
    }

    public final zzcci f(Context context, String str, zzbvc zzbvcVar) {
        return (zzcci) new zzaa(this, context, str, zzbvcVar).d(context, false);
    }

    public final zzbzb g(Activity activity) {
        zzac zzacVar = new zzac(this, activity);
        Intent intent = activity.getIntent();
        boolean booleanExtra = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.c("useClientJar flag not found in activity intent extras.");
        }
        return (zzbzb) zzacVar.d(activity, booleanExtra);
    }

    public final zzdt h(Context context, zzbvc zzbvcVar) {
        return (zzdt) new zzae(this, context, zzbvcVar).d(context, false);
    }

    public final zzcem i(Context context, zzbvc zzbvcVar) {
        return (zzcem) new zzag(this, context, zzbvcVar).d(context, false);
    }

    public final zzbyu j(Context context, zzbvc zzbvcVar) {
        return (zzbyu) new zzai(this, context, zzbvcVar).d(context, false);
    }

    public final zzbqt k(Context context, zzbvc zzbvcVar, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbqt) new zzak(this, context, zzbvcVar, onH5AdsEventListener).d(context, false);
    }

    final /* synthetic */ zzk m() {
        return this.f69821a;
    }

    final /* synthetic */ zzi n() {
        return this.f69822b;
    }

    final /* synthetic */ zzfc o() {
        return this.f69823c;
    }

    final /* synthetic */ zzbnx p() {
        return this.f69824d;
    }

    final /* synthetic */ zzbyy q() {
        return this.f69825e;
    }

    final /* synthetic */ zzcaa r() {
        return this.f69826f;
    }

    final /* synthetic */ void s(zzcaa zzcaaVar) {
        this.f69826f = zzcaaVar;
    }

    final /* synthetic */ zzl t() {
        return this.f69827g;
    }
}
