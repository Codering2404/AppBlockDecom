package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FinderPatternFinder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f92086a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            int iCompare = Integer.compare(finderPattern2.a(), finderPattern.a());
            return iCompare == 0 ? Float.compare(Math.abs(finderPattern.b() - this.f92086a), Math.abs(finderPattern2.b() - this.f92086a)) : iCompare;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f92087a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.b() - this.f92087a), Math.abs(finderPattern.b() - this.f92087a));
        }
    }
}
