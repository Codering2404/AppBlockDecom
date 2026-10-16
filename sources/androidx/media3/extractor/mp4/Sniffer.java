package androidx.media3.extractor.mp4;

import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Sniffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f46818a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i3, boolean z2) {
        if ((i3 >>> 8) == 3368816) {
            return true;
        }
        if (i3 == 1751476579 && z2) {
            return true;
        }
        for (int i4 : f46818a) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    public static SniffFailure b(ExtractorInput extractorInput) {
        return c(extractorInput, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.media3.extractor.SniffFailure c(androidx.media3.extractor.ExtractorInput r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Sniffer.c(androidx.media3.extractor.ExtractorInput, boolean, boolean):androidx.media3.extractor.SniffFailure");
    }

    public static SniffFailure d(ExtractorInput extractorInput, boolean z2) {
        return c(extractorInput, false, z2);
    }
}
