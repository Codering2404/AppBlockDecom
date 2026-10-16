package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbq f73833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ServiceConnection f73834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzhj f73835c;

    zzhi(zzhj zzhjVar, com.google.android.gms.internal.measurement.zzbq zzbqVar, ServiceConnection serviceConnection) {
        this.f73833a = zzbqVar;
        this.f73834b = serviceConnection;
        Objects.requireNonNull(zzhjVar);
        this.f73835c = zzhjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleZze;
        zzhj zzhjVar = this.f73835c;
        zzhk zzhkVar = zzhjVar.f73837b;
        zzic zzicVar = zzhkVar.f73838a;
        zzicVar.b().h();
        Bundle bundle = new Bundle();
        String strA = zzhjVar.a();
        bundle.putString("package_name", strA);
        try {
            bundleZze = this.f73833a.zze(bundle);
        } catch (Exception e3) {
            zzhkVar.f73838a.a().o().b("Exception occurred while retrieving the Install Referrer", e3.getMessage());
        }
        if (bundleZze == null) {
            zzicVar.a().o().a("Install Referrer Service returned a null response");
            bundleZze = null;
        }
        zzic zzicVar2 = zzhkVar.f73838a;
        zzicVar2.b().h();
        zzic.q();
        if (bundleZze != null) {
            long j3 = bundleZze.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j3 == 0) {
                zzicVar2.a().r().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZze.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzicVar2.a().o().a("No referrer defined in Install Referrer response");
                } else {
                    zzicVar2.a().w().b("InstallReferrer API result", string);
                    Bundle bundleS0 = zzicVar2.C().s0(Uri.parse("?".concat(string)));
                    if (bundleS0 == null) {
                        zzicVar2.a().o().a("No campaign params defined in Install Referrer result");
                    } else {
                        List listAsList = Arrays.asList(((String) zzfy.f73642h1.b(null)).split(","));
                        Iterator<String> it = bundleS0.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (listAsList.contains(it.next())) {
                                long j4 = bundleZze.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                                if (j4 > 0) {
                                    bundleS0.putLong("click_timestamp", j4);
                                }
                            }
                        }
                        if (j3 == zzicVar2.x().f73813g.a()) {
                            zzicVar2.a().w().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzicVar2.g()) {
                            zzicVar2.x().f73813g.b(j3);
                            zzicVar2.a().w().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            bundleS0.putString("_cis", "referrer API v2");
                            zzicVar2.B().w("auto", "_cmp", bundleS0, strA);
                        }
                    }
                }
            }
        }
        ConnectionTracker.b().c(zzicVar2.d(), this.f73834b);
    }
}
