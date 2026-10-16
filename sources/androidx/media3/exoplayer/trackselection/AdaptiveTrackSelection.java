package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BandwidthMeter f45315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f45316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f45317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f45318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f45319m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f45320n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f45321o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final float f45322p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ImmutableList f45323q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Clock f45324r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f45325s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f45326t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f45327u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f45328v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MediaChunk f45329w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f45330x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AdaptationCheckpoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f45331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f45332b;

        public AdaptationCheckpoint(long j3, long j4) {
            this.f45331a = j3;
            this.f45332b = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            return this.f45331a == adaptationCheckpoint.f45331a && this.f45332b == adaptationCheckpoint.f45332b;
        }

        public int hashCode() {
            return (((int) this.f45331a) * 31) + ((int) this.f45332b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory implements ExoTrackSelection.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f45334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f45335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f45336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f45337e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f45338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final float f45339g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Clock f45340h;

        public Factory() {
            this(ColorExtractionConstants.MAX_PIXEL_SAMPLES, 25000, 25000, 0.7f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.media3.exoplayer.trackselection.ExoTrackSelection[] a(androidx.media3.exoplayer.trackselection.ExoTrackSelection.Definition[] r10, androidx.media3.exoplayer.upstream.BandwidthMeter r11, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r12, androidx.media3.common.Timeline r13) {
            /*
                r9 = this;
                com.google.common.collect.ImmutableList r12 = androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection.o(r10)
                int r13 = r10.length
                androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r13 = new androidx.media3.exoplayer.trackselection.ExoTrackSelection[r13]
                r0 = 0
                r1 = r0
            L9:
                int r2 = r10.length
                if (r1 >= r2) goto L40
                r2 = r10[r1]
                if (r2 == 0) goto L15
                int[] r5 = r2.f45436b
                int r3 = r5.length
                if (r3 != 0) goto L17
            L15:
                r7 = r11
                goto L3c
            L17:
                int r3 = r5.length
                r4 = 1
                if (r3 != r4) goto L28
                androidx.media3.exoplayer.trackselection.FixedTrackSelection r3 = new androidx.media3.exoplayer.trackselection.FixedTrackSelection
                androidx.media3.common.TrackGroup r4 = r2.f45435a
                r5 = r5[r0]
                int r2 = r2.f45437c
                r3.<init>(r4, r5, r2)
                r7 = r11
                goto L3a
            L28:
                androidx.media3.common.TrackGroup r4 = r2.f45435a
                int r6 = r2.f45437c
                java.lang.Object r2 = r12.get(r1)
                r8 = r2
                com.google.common.collect.ImmutableList r8 = (com.google.common.collect.ImmutableList) r8
                r3 = r9
                r7 = r11
                androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection r11 = r3.b(r4, r5, r6, r7, r8)
                r3 = r11
            L3a:
                r13[r1] = r3
            L3c:
                int r1 = r1 + 1
                r11 = r7
                goto L9
            L40:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection.Factory.a(androidx.media3.exoplayer.trackselection.ExoTrackSelection$Definition[], androidx.media3.exoplayer.upstream.BandwidthMeter, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId, androidx.media3.common.Timeline):androidx.media3.exoplayer.trackselection.ExoTrackSelection[]");
        }

        protected AdaptiveTrackSelection b(TrackGroup trackGroup, int[] iArr, int i3, BandwidthMeter bandwidthMeter, ImmutableList immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i3, bandwidthMeter, this.f45333a, this.f45334b, this.f45335c, this.f45336d, this.f45337e, this.f45338f, this.f45339g, immutableList, this.f45340h);
        }

        public Factory(int i3, int i4, int i5, float f3) {
            this(i3, i4, i5, 1279, 719, f3, 0.75f, Clock.f41485a);
        }

        public Factory(int i3, int i4, int i5, int i6, int i7, float f3, float f4, Clock clock) {
            this.f45333a = i3;
            this.f45334b = i4;
            this.f45335c = i5;
            this.f45336d = i6;
            this.f45337e = i7;
            this.f45338f = f3;
            this.f45339g = f4;
            this.f45340h = clock;
        }
    }

    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i3, BandwidthMeter bandwidthMeter, long j3, long j4, long j5, int i4, int i5, float f3, float f4, List list, Clock clock) {
        long j6;
        super(trackGroup, iArr, i3);
        if (j5 < j3) {
            Log.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j6 = j3;
        } else {
            j6 = j5;
        }
        this.f45315i = bandwidthMeter;
        this.f45316j = j3 * 1000;
        this.f45317k = j4 * 1000;
        this.f45318l = j6 * 1000;
        this.f45319m = i4;
        this.f45320n = i5;
        this.f45321o = f3;
        this.f45322p = f4;
        this.f45323q = ImmutableList.t(list);
        this.f45324r = clock;
        this.f45325s = 1.0f;
        this.f45327u = 0;
        this.f45328v = -9223372036854775807L;
        this.f45330x = -2147483647L;
    }

    private static void p(List list, long[] jArr) {
        long j3 = 0;
        for (long j4 : jArr) {
            j3 += j4;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            ImmutableList.Builder builder = (ImmutableList.Builder) list.get(i3);
            if (builder != null) {
                builder.a(new AdaptationCheckpoint(j3, jArr[i3]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList q(ExoTrackSelection.Definition[] definitionArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.f45436b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.Builder builderO = ImmutableList.o();
                builderO.a(new AdaptationCheckpoint(0L, 0L));
                arrayList.add(builderO);
            }
        }
        long[][] jArrR = r(definitionArr);
        int[] iArr = new int[jArrR.length];
        long[] jArr = new long[jArrR.length];
        for (int i3 = 0; i3 < jArrR.length; i3++) {
            long[] jArr2 = jArrR[i3];
            jArr[i3] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        p(arrayList, jArr);
        ImmutableList immutableListS = s(jArrR);
        for (int i4 = 0; i4 < immutableListS.size(); i4++) {
            int iIntValue = ((Integer) immutableListS.get(i4)).intValue();
            int i5 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i5;
            jArr[iIntValue] = jArrR[iIntValue][i5];
            p(arrayList, jArr);
        }
        for (int i6 = 0; i6 < definitionArr.length; i6++) {
            if (arrayList.get(i6) != null) {
                jArr[i6] = jArr[i6] * 2;
            }
        }
        p(arrayList, jArr);
        ImmutableList.Builder builderO2 = ImmutableList.o();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            ImmutableList.Builder builder = (ImmutableList.Builder) arrayList.get(i7);
            builderO2.a(builder == null ? ImmutableList.y() : builder.m());
        }
        return builderO2.m();
    }

    private static long[][] r(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i3 = 0; i3 < definitionArr.length; i3++) {
            ExoTrackSelection.Definition definition = definitionArr[i3];
            if (definition == null) {
                jArr[i3] = new long[0];
            } else {
                jArr[i3] = new long[definition.f45436b.length];
                int i4 = 0;
                while (true) {
                    int[] iArr = definition.f45436b;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    long j3 = definition.f45435a.a(iArr[i4]).f40627j;
                    long[] jArr2 = jArr[i3];
                    if (j3 == -1) {
                        j3 = 0;
                    }
                    jArr2[i4] = j3;
                    i4++;
                }
                Arrays.sort(jArr[i3]);
            }
        }
        return jArr;
    }

    private static ImmutableList s(long[][] jArr) {
        ListMultimap listMultimapE = MultimapBuilder.c().a().e();
        for (int i3 = 0; i3 < jArr.length; i3++) {
            long[] jArr2 = jArr[i3];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i4 = 0;
                while (true) {
                    long[] jArr3 = jArr[i3];
                    double dLog = 0.0d;
                    if (i4 >= jArr3.length) {
                        break;
                    }
                    long j3 = jArr3[i4];
                    if (j3 != -1) {
                        dLog = Math.log(j3);
                    }
                    dArr[i4] = dLog;
                    i4++;
                }
                int i5 = length - 1;
                double d3 = dArr[i5] - dArr[0];
                int i6 = 0;
                while (i6 < i5) {
                    double d4 = dArr[i6];
                    i6++;
                    listMultimapE.put(Double.valueOf(d3 == 0.0d ? 1.0d : (((d4 + dArr[i6]) * 0.5d) - dArr[0]) / d3), Integer.valueOf(i3));
                }
            }
        }
        return ImmutableList.t(listMultimapE.values());
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int a() {
        return this.f45326t;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void c() {
        this.f45329w = null;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void e(float f3) {
        this.f45325s = f3;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void j() {
        this.f45328v = -9223372036854775807L;
        this.f45329w = null;
    }
}
