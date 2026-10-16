package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f74111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Uri f74112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f74114d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzky f74115f;

    zzkx(zzky zzkyVar, boolean z2, Uri uri, String str, String str2) {
        this.f74111a = z2;
        this.f74112b = uri;
        this.f74113c = str;
        this.f74114d = str2;
        Objects.requireNonNull(zzkyVar);
        this.f74115f = zzkyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleS0;
        Bundle bundleS02;
        zzky zzkyVar = this.f74115f;
        zzlj zzljVar = zzkyVar.f74116a;
        zzljVar.h();
        String str = this.f74114d;
        Uri uri = this.f74112b;
        try {
            zzic zzicVar = zzljVar.f73997a;
            zzpp zzppVarC = zzicVar.C();
            if (TextUtils.isEmpty(str)) {
                bundleS0 = null;
            } else if (str.contains("gclid") || str.contains("gbraid") || str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains("utm_id") || str.contains("dclid") || str.contains("srsltid") || str.contains("sfmc_id")) {
                bundleS0 = zzppVarC.s0(Uri.parse("https://google.com/search?".concat(str)));
                if (bundleS0 != null) {
                    bundleS0.putString("_cis", "referrer");
                }
            } else {
                zzppVarC.f73997a.a().v().a("Activity created with data 'referrer' without required params");
                bundleS0 = null;
            }
            String str2 = this.f74113c;
            if (this.f74111a && (bundleS02 = zzicVar.C().s0(uri)) != null) {
                bundleS02.putString("_cis", SDKConstants.PARAM_INTENT);
                if (!bundleS02.containsKey("gclid") && bundleS0 != null && bundleS0.containsKey("gclid")) {
                    bundleS02.putString("_cer", String.format("gclid=%s", bundleS0.getString("gclid")));
                }
                zzljVar.t(str2, "_cmp", bundleS02);
                zzljVar.f74151r.b(str2, bundleS02);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            zzicVar.a().v().b("Activity created with referrer", str);
            if (zzicVar.w().H(null, zzfy.H0)) {
                if (bundleS0 != null) {
                    zzljVar.t(str2, "_cmp", bundleS0);
                    zzljVar.f74151r.b(str2, bundleS0);
                } else {
                    zzicVar.a().v().b("Referrer does not contain valid parameters", str);
                }
                zzljVar.y("auto", "_ldl", null, true);
                return;
            }
            if (!str.contains("gclid") || (!str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && !str.contains("utm_term") && !str.contains("utm_content"))) {
                zzicVar.a().v().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                zzljVar.y("auto", "_ldl", str, true);
            }
        } catch (RuntimeException e3) {
            zzkyVar.f74116a.f73997a.a().o().b("Throwable caught in handleReferrerForOnActivityCreated", e3);
        }
    }
}
