package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzg implements Comparator {
    zzg() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        Preconditions.m(activityTransition);
        Preconditions.m(activityTransition2);
        int iM = activityTransition.M();
        int iM2 = activityTransition2.M();
        if (iM != iM2) {
            return iM >= iM2 ? 1 : -1;
        }
        int iN = activityTransition.N();
        int iN2 = activityTransition2.N();
        if (iN == iN2) {
            return 0;
        }
        return iN >= iN2 ? 1 : -1;
    }
}
