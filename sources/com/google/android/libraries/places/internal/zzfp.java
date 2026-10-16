package com.google.android.libraries.places.internal;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzfp implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzfp f77831a = new zzfp();

    private /* synthetic */ zzfp() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int i3 = zzfq.f77833d;
        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
    }
}
