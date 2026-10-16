package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.exoplayer.source.MediaSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServerSideAdInsertionUtil {
    public static int a(AdPlaybackState adPlaybackState, int i3) {
        int i4 = adPlaybackState.b(i3).f40508b;
        if (i4 == -1) {
            return 0;
        }
        return i4;
    }

    public static long b(long j3, MediaSource.MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.c() ? c(j3, mediaPeriodId.f44755b, mediaPeriodId.f44756c, adPlaybackState) : d(j3, mediaPeriodId.f44758e, adPlaybackState);
    }

    public static long c(long j3, int i3, int i4, AdPlaybackState adPlaybackState) {
        int i5;
        AdPlaybackState.AdGroup adGroupB = adPlaybackState.b(i3);
        long j4 = j3 - adGroupB.f40507a;
        int i6 = adPlaybackState.f40494e;
        while (true) {
            i5 = 0;
            if (i6 >= i3) {
                break;
            }
            AdPlaybackState.AdGroup adGroupB2 = adPlaybackState.b(i6);
            while (i5 < a(adPlaybackState, i6)) {
                j4 -= adGroupB2.f40513g[i5];
                i5++;
            }
            j4 += adGroupB2.f40515i;
            i6++;
        }
        if (i4 < a(adPlaybackState, i3)) {
            while (i5 < i4) {
                j4 -= adGroupB.f40513g[i5];
                i5++;
            }
        }
        return j4;
    }

    public static long d(long j3, int i3, AdPlaybackState adPlaybackState) {
        if (i3 == -1) {
            i3 = adPlaybackState.f40491b;
        }
        long j4 = 0;
        for (int i4 = adPlaybackState.f40494e; i4 < i3; i4++) {
            AdPlaybackState.AdGroup adGroupB = adPlaybackState.b(i4);
            long j5 = adGroupB.f40507a;
            if (j5 == Long.MIN_VALUE || j5 > j3 - j4) {
                break;
            }
            for (int i5 = 0; i5 < a(adPlaybackState, i4); i5++) {
                j4 += adGroupB.f40513g[i5];
            }
            long j6 = adGroupB.f40515i;
            j4 -= j6;
            long j7 = adGroupB.f40507a;
            long j8 = j3 - j4;
            if (j6 + j7 > j8) {
                return Math.max(j7, j8);
            }
        }
        return j3 - j4;
    }

    public static long e(long j3, MediaSource.MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.c() ? f(j3, mediaPeriodId.f44755b, mediaPeriodId.f44756c, adPlaybackState) : g(j3, mediaPeriodId.f44758e, adPlaybackState);
    }

    public static long f(long j3, int i3, int i4, AdPlaybackState adPlaybackState) {
        int i5;
        AdPlaybackState.AdGroup adGroupB = adPlaybackState.b(i3);
        long j4 = j3 + adGroupB.f40507a;
        int i6 = adPlaybackState.f40494e;
        while (true) {
            i5 = 0;
            if (i6 >= i3) {
                break;
            }
            AdPlaybackState.AdGroup adGroupB2 = adPlaybackState.b(i6);
            while (i5 < a(adPlaybackState, i6)) {
                j4 += adGroupB2.f40513g[i5];
                i5++;
            }
            j4 -= adGroupB2.f40515i;
            i6++;
        }
        if (i4 < a(adPlaybackState, i3)) {
            while (i5 < i4) {
                j4 += adGroupB.f40513g[i5];
                i5++;
            }
        }
        return j4;
    }

    public static long g(long j3, int i3, AdPlaybackState adPlaybackState) {
        if (i3 == -1) {
            i3 = adPlaybackState.f40491b;
        }
        long j4 = 0;
        for (int i4 = adPlaybackState.f40494e; i4 < i3; i4++) {
            AdPlaybackState.AdGroup adGroupB = adPlaybackState.b(i4);
            long j5 = adGroupB.f40507a;
            if (j5 == Long.MIN_VALUE || j5 > j3) {
                break;
            }
            long j6 = j5 + j4;
            for (int i5 = 0; i5 < a(adPlaybackState, i4); i5++) {
                j4 += adGroupB.f40513g[i5];
            }
            long j7 = adGroupB.f40515i;
            j4 -= j7;
            if (adGroupB.f40507a + j7 > j3) {
                return Math.max(j6, j3 + j4);
            }
        }
        return j3 + j4;
    }
}
