package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzk implements Comparator {
    zzk() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        Preconditions.m(detectedActivity);
        Preconditions.m(detectedActivity2);
        int iCompareTo = Integer.valueOf(detectedActivity2.M()).compareTo(Integer.valueOf(detectedActivity.M()));
        return iCompareTo == 0 ? Integer.valueOf(detectedActivity.N()).compareTo(Integer.valueOf(detectedActivity2.N())) : iCompareTo;
    }
}
