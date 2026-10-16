package com.google.android.libraries.places.internal;

import com.appsflyer.AppsFlyerProperties;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbja {
    public static zzbit a(zzbit zzbitVar, List list) {
        Preconditions.u(zzbitVar, AppsFlyerProperties.CHANNEL);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbitVar = new zzbiz(zzbitVar, (zzbiy) it.next(), null);
        }
        return zzbitVar;
    }
}
