package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class BitmapDescriptorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.google.android.gms.internal.maps.zzi f73120a;

    public static void a(com.google.android.gms.internal.maps.zzi zziVar) {
        if (f73120a != null) {
            return;
        }
        f73120a = (com.google.android.gms.internal.maps.zzi) Preconditions.n(zziVar, "delegate must not be null");
    }
}
