package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FinderPatternInfo[] f91907a = new FinderPatternInfo[0];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            double dB = finderPattern2.b() - finderPattern.b();
            if (dB < 0.0d) {
                return -1;
            }
            return dB > 0.0d ? 1 : 0;
        }
    }
}
