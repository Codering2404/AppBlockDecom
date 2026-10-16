package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzq f70003a = new zzq();

    protected zzq() {
    }

    public final zzm a(Context context, zzeh zzehVar) {
        String strE;
        String strA = zzehVar.a();
        Set setC = zzehVar.c();
        List listUnmodifiableList = !setC.isEmpty() ? Collections.unmodifiableList(new ArrayList(setC)) : null;
        boolean zG = zzehVar.g(context);
        Bundle bundleD = zzehVar.d(AdMobAdapter.class);
        String strE2 = zzehVar.e();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.a();
            strE = com.google.android.gms.ads.internal.util.client.zzf.E(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strE = null;
        }
        boolean zL = zzehVar.l();
        RequestConfiguration requestConfigurationN = zzeu.f().n();
        return new zzm(8, -1L, bundleD, -1, listUnmodifiableList, zG, Math.max(zzehVar.i(), requestConfigurationN.c()), false, strE2, null, null, strA, zzehVar.h(), zzehVar.j(), Collections.unmodifiableList(new ArrayList(zzehVar.k())), zzehVar.f(), strE, zL, null, requestConfigurationN.d(), (String) Collections.max(Arrays.asList(null, requestConfigurationN.a()), zzp.f70002a), zzehVar.b(), zzehVar.n(), zzehVar.m(), requestConfigurationN.b().a(), zzehVar.p(), zzehVar.q());
    }
}
