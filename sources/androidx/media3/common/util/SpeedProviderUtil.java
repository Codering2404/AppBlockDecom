package androidx.media3.common.util;

import androidx.media3.common.audio.SpeedProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SpeedProviderUtil {
    public static long a(SpeedProvider speedProvider, long j3) {
        long j4 = 0;
        double dMin = 0.0d;
        while (j4 < j3) {
            long jB = speedProvider.b(j4);
            if (jB == -9223372036854775807L) {
                jB = Long.MAX_VALUE;
            }
            dMin += (Math.min(jB, j3) - j4) / ((double) speedProvider.a(j4));
            j4 = jB;
        }
        return (long) Math.floor(dMin);
    }

    public static long b(SpeedProvider speedProvider, long j3, int i3) {
        Assertions.a(j3 >= 0);
        Assertions.a(i3 > 0);
        long jB = speedProvider.b(Util.Y0(j3, i3));
        if (jB == -9223372036854775807L) {
            return -1L;
        }
        return Util.I(jB, i3);
    }

    public static float c(SpeedProvider speedProvider, long j3, int i3) {
        Assertions.a(j3 >= 0);
        Assertions.a(i3 > 0);
        return speedProvider.a(Util.Y0(j3, i3));
    }
}
