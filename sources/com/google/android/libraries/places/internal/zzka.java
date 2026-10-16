package com.google.android.libraries.places.internal;

import android.net.Uri;
import com.google.android.libraries.places.api.model.Leg;
import com.google.android.libraries.places.api.model.RoutingSummary;
import java.time.Duration;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzka {
    zzka() {
    }

    public static final RoutingSummary a(zzbbc zzbbcVar) {
        ArrayList arrayList = new ArrayList();
        for (zzbbb zzbbbVar : zzbbcVar.G()) {
            arrayList.add(Leg.e(Duration.ofSeconds(zzbbbVar.G().G(), r3.H()), zzbbbVar.H()));
        }
        RoutingSummary.Builder builderA = RoutingSummary.a(arrayList);
        String strH = zzbbcVar.H();
        if (!strH.isEmpty()) {
            builderA.d(Uri.parse(strH));
        }
        return builderA.b();
    }
}
