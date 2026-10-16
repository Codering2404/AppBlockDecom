package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzp implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzp f70002a = new zzp();

    private /* synthetic */ zzp() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        List list = RequestConfiguration.f69678f;
        return list.indexOf((String) obj) - list.indexOf((String) obj2);
    }
}
