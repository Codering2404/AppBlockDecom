package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MediaCodecPerformancePointCoverageProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f44276a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api29 {
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4, double d3) {
            List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            o.a();
            int iC = c(supportedPerformancePoints, n.a(i3, i4, (int) d3));
            if (iC == 1 && MediaCodecPerformancePointCoverageProvider.f44276a == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.f44276a = Boolean.valueOf(d());
                if (MediaCodecPerformancePointCoverageProvider.f44276a.booleanValue()) {
                    return 0;
                }
            }
            return iC;
        }

        private static int b(boolean z2) {
            List supportedPerformancePoints;
            try {
                Format formatN = new Format.Builder().u0("video/avc").N();
                if (formatN.f40632o != null) {
                    List listN = MediaCodecUtil.n(MediaCodecSelector.f44322a, formatN, z2, false);
                    for (int i3 = 0; i3 < listN.size(); i3++) {
                        if (((MediaCodecInfo) listN.get(i3)).f44267d != null && ((MediaCodecInfo) listN.get(i3)).f44267d.getVideoCapabilities() != null && (supportedPerformancePoints = ((MediaCodecInfo) listN.get(i3)).f44267d.getVideoCapabilities().getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                            o.a();
                            return c(supportedPerformancePoints, n.a(1280, 720, 60));
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return 0;
        }

        private static int c(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (l.a(list.get(i3)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }

        private static boolean d() {
            if (Util.f41609a >= 35) {
                return false;
            }
            int iB = b(false);
            int iB2 = b(true);
            if (iB == 0) {
                return true;
            }
            return iB2 == 0 ? iB != 2 : (iB == 2 && iB2 == 2) ? false : true;
        }
    }

    public static int c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4, double d3) {
        if (Util.f41609a < 29) {
            return 0;
        }
        Boolean bool = f44276a;
        if (bool == null || !bool.booleanValue()) {
            return Api29.a(videoCapabilities, i3, i4, d3);
        }
        return 0;
    }
}
