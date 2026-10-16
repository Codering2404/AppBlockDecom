package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class QuantizerWsmeans {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Distance implements Comparable<Distance> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f80638a;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Distance distance) {
            return Double.valueOf(this.f80638a).compareTo(Double.valueOf(distance.f80638a));
        }
    }
}
