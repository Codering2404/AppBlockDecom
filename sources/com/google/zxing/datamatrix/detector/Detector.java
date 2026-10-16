package com.google.zxing.datamatrix.detector;

import com.google.zxing.ResultPoint;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Detector {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ResultPointsAndTransitions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResultPoint f91867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ResultPoint f91868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f91869c;

        int a() {
            return this.f91869c;
        }

        public String toString() {
            return this.f91867a + "/" + this.f91868b + '/' + this.f91869c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.a() - resultPointsAndTransitions2.a();
        }
    }
}
