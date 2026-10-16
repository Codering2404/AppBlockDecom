package androidx.media3.exoplayer.trackselection;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MappingTrackSelector extends TrackSelector {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MappedTrackInfo f45440c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MappedTrackInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f45442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f45443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TrackGroupArray[] f45444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f45445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[][][] f45446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final TrackGroupArray f45447g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface RendererSupport {
        }

        MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f45442b = strArr;
            this.f45443c = iArr;
            this.f45444d = trackGroupArrayArr;
            this.f45446f = iArr3;
            this.f45445e = iArr2;
            this.f45447g = trackGroupArray;
            this.f45441a = iArr.length;
        }

        public int a(int i3, int i4, boolean z2) {
            int i5 = this.f45444d[i3].b(i4).f41153a;
            int[] iArr = new int[i5];
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                int iG = g(i3, i4, i7);
                if (iG == 4 || (z2 && iG == 3)) {
                    iArr[i6] = i7;
                    i6++;
                }
            }
            return b(i3, i4, Arrays.copyOf(iArr, i6));
        }

        public int b(int i3, int i4, int[] iArr) {
            int i5 = 0;
            int iMin = 16;
            String str = null;
            boolean z2 = false;
            int i6 = 0;
            while (i5 < iArr.length) {
                String str2 = this.f45444d[i3].b(i4).a(iArr[i5]).f40632o;
                int i7 = i6 + 1;
                if (i6 == 0) {
                    str = str2;
                } else {
                    z2 |= !Objects.equals(str, str2);
                }
                iMin = Math.min(iMin, RendererCapabilities.t(this.f45446f[i3][i4][i5]));
                i5++;
                i6 = i7;
            }
            return z2 ? Math.min(iMin, this.f45445e[i3]) : iMin;
        }

        public int c(int i3, int i4, int i5) {
            return this.f45446f[i3][i4][i5];
        }

        public int d() {
            return this.f45441a;
        }

        public int e(int i3) {
            return this.f45443c[i3];
        }

        public TrackGroupArray f(int i3) {
            return this.f45444d[i3];
        }

        public int g(int i3, int i4, int i5) {
            return RendererCapabilities.R(c(i3, i4, i5));
        }

        public TrackGroupArray h() {
            return this.f45447g;
        }
    }

    private static int m(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z2) {
        int length = rendererCapabilitiesArr.length;
        int i3 = 0;
        boolean z3 = true;
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i4];
            int iMax = 0;
            for (int i5 = 0; i5 < trackGroup.f41153a; i5++) {
                iMax = Math.max(iMax, RendererCapabilities.R(rendererCapabilities.a(trackGroup.a(i5))));
            }
            boolean z4 = iArr[i4] == 0;
            if (iMax > i3 || (iMax == i3 && z2 && !z3 && z4)) {
                length = i4;
                z3 = z4;
                i3 = iMax;
            }
        }
        return length;
    }

    private static int[] n(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) {
        int[] iArr = new int[trackGroup.f41153a];
        for (int i3 = 0; i3 < trackGroup.f41153a; i3++) {
            iArr[i3] = rendererCapabilities.a(trackGroup.a(i3));
        }
        return iArr;
    }

    private static int[] o(RendererCapabilities[] rendererCapabilitiesArr) {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = rendererCapabilitiesArr[i3].N();
        }
        return iArr;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final void i(Object obj) {
        this.f45440c = (MappedTrackInfo) obj;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final TrackSelectorResult k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][][];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = trackGroupArray.f44987a;
            trackGroupArr[i3] = new TrackGroup[i4];
            iArr2[i3] = new int[i4][];
        }
        int[] iArrO = o(rendererCapabilitiesArr);
        for (int i5 = 0; i5 < trackGroupArray.f44987a; i5++) {
            TrackGroup trackGroupB = trackGroupArray.b(i5);
            int iM = m(rendererCapabilitiesArr, trackGroupB, iArr, trackGroupB.f41155c == 5);
            int[] iArrN = iM == rendererCapabilitiesArr.length ? new int[trackGroupB.f41153a] : n(rendererCapabilitiesArr[iM], trackGroupB);
            int i6 = iArr[iM];
            trackGroupArr[iM][i6] = trackGroupB;
            iArr2[iM][i6] = iArrN;
            iArr[iM] = i6 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        String[] strArr = new String[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i7 = 0; i7 < rendererCapabilitiesArr.length; i7++) {
            int i8 = iArr[i7];
            trackGroupArrayArr[i7] = new TrackGroupArray((TrackGroup[]) Util.U0(trackGroupArr[i7], i8));
            iArr2[i7] = (int[][]) Util.U0(iArr2[i7], i8);
            strArr[i7] = rendererCapabilitiesArr[i7].getName();
            iArr3[i7] = rendererCapabilitiesArr[i7].g();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr3, trackGroupArrayArr, iArrO, iArr2, new TrackGroupArray((TrackGroup[]) Util.U0(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length])));
        Pair pairP = p(mappedTrackInfo, iArr2, iArrO, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) pairP.first, (ExoTrackSelection[]) pairP.second, TrackSelectionUtil.a(mappedTrackInfo, (TrackSelection[]) pairP.second), mappedTrackInfo);
    }

    protected abstract Pair p(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);
}
