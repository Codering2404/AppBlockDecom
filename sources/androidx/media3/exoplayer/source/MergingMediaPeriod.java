package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaPeriod[] f44765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean[] f44766b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f44768d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MediaPeriod.Callback f44771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TrackGroupArray f44772i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SequenceableLoader f44774k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList f44769f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f44770g = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IdentityHashMap f44767c = new IdentityHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaPeriod[] f44773j = new MediaPeriod[0];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ForwardingTrackSelection implements ExoTrackSelection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExoTrackSelection f44775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TrackGroup f44776b;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
            this.f44775a = exoTrackSelection;
            this.f44776b = trackGroup;
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public Format b(int i3) {
            return this.f44776b.a(this.f44775a.d(i3));
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public void c() {
            this.f44775a.c();
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public int d(int i3) {
            return this.f44775a.d(i3);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public void e(float f3) {
            this.f44775a.e(f3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            return this.f44775a.equals(forwardingTrackSelection.f44775a) && this.f44776b.equals(forwardingTrackSelection.f44776b);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public void f() {
            this.f44775a.f();
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public int g(int i3) {
            return this.f44775a.g(i3);
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public TrackGroup h() {
            return this.f44776b;
        }

        public int hashCode() {
            return ((527 + this.f44776b.hashCode()) * 31) + this.f44775a.hashCode();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public void i(boolean z2) {
            this.f44775a.i(z2);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public void j() {
            this.f44775a.j();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public int k() {
            return this.f44775a.k();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public Format l() {
            return this.f44776b.a(this.f44775a.k());
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public int length() {
            return this.f44775a.length();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public void m() {
            this.f44775a.m();
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.f44768d = compositeSequenceableLoaderFactory;
        this.f44765a = mediaPeriodArr;
        this.f44774k = compositeSequenceableLoaderFactory.empty();
        this.f44766b = new boolean[mediaPeriodArr.length];
        for (int i3 = 0; i3 < mediaPeriodArr.length; i3++) {
            long j3 = jArr[i3];
            if (j3 != 0) {
                this.f44766b[i3] = true;
                this.f44765a[i3] = new TimeOffsetMediaPeriod(mediaPeriodArr[i3], j3);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f44774k.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        if (this.f44769f.isEmpty()) {
            return this.f44774k.b(loadingInfo);
        }
        int size = this.f44769f.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((MediaPeriod) this.f44769f.get(i3)).b(loadingInfo);
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        return this.f44774k.c();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        return this.f44774k.e();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        this.f44774k.f(j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void g(MediaPeriod mediaPeriod) {
        this.f44769f.remove(mediaPeriod);
        if (!this.f44769f.isEmpty()) {
            return;
        }
        int i3 = 0;
        for (MediaPeriod mediaPeriod2 : this.f44765a) {
            i3 += mediaPeriod2.s().f44987a;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f44765a;
            if (i4 >= mediaPeriodArr.length) {
                this.f44772i = new TrackGroupArray(trackGroupArr);
                ((MediaPeriod.Callback) Assertions.e(this.f44771h)).g(this);
                return;
            }
            TrackGroupArray trackGroupArrayS = mediaPeriodArr[i4].s();
            int i6 = trackGroupArrayS.f44987a;
            int i7 = 0;
            while (i7 < i6) {
                TrackGroup trackGroupB = trackGroupArrayS.b(i7);
                Format[] formatArr = new Format[trackGroupB.f41153a];
                for (int i8 = 0; i8 < trackGroupB.f41153a; i8++) {
                    Format formatA = trackGroupB.a(i8);
                    Format.Builder builderB = formatA.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i4);
                    sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                    String str = formatA.f40618a;
                    if (str == null) {
                        str = "";
                    }
                    sb.append(str);
                    formatArr[i8] = builderB.f0(sb.toString()).N();
                }
                TrackGroup trackGroup = new TrackGroup(i4 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + trackGroupB.f41154b, formatArr);
                this.f44770g.put(trackGroup, trackGroupB);
                trackGroupArr[i5] = trackGroup;
                i7++;
                i5++;
            }
            i4++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.f44773j;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.f44765a[0]).i(j3, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        long j4 = this.f44773j[0].j(j3);
        int i3 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f44773j;
            if (i3 >= mediaPeriodArr.length) {
                return j4;
            }
            if (mediaPeriodArr[i3].j(j4) != j4) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i3++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        int i3 = 0;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            SampleStream sampleStream = sampleStreamArr[i4];
            Integer num = sampleStream == null ? null : (Integer) this.f44767c.get(sampleStream);
            iArr[i4] = num == null ? -1 : num.intValue();
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i4];
            if (exoTrackSelection != null) {
                String str = exoTrackSelection.h().f41154b;
                iArr2[i4] = Integer.parseInt(str.substring(0, str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)));
            } else {
                iArr2[i4] = -1;
            }
        }
        this.f44767c.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.f44765a.length);
        long j4 = j3;
        int i5 = 0;
        while (i5 < this.f44765a.length) {
            for (int i6 = i3; i6 < exoTrackSelectionArr.length; i6++) {
                sampleStreamArr3[i6] = iArr[i6] == i5 ? sampleStreamArr[i6] : null;
                if (iArr2[i6] == i5) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.e(exoTrackSelectionArr[i6]);
                    exoTrackSelectionArr2[i6] = new ForwardingTrackSelection(exoTrackSelection2, (TrackGroup) Assertions.e((TrackGroup) this.f44770g.get(exoTrackSelection2.h())));
                } else {
                    exoTrackSelectionArr2[i6] = null;
                }
            }
            int i7 = i5;
            long jK = this.f44765a[i5].k(exoTrackSelectionArr2, zArr, sampleStreamArr3, zArr2, j4);
            if (i7 == 0) {
                j4 = jK;
            } else if (jK != j4) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i8 = 0; i8 < exoTrackSelectionArr.length; i8++) {
                if (iArr2[i8] == i7) {
                    SampleStream sampleStream2 = (SampleStream) Assertions.e(sampleStreamArr3[i8]);
                    sampleStreamArr2[i8] = sampleStreamArr3[i8];
                    this.f44767c.put(sampleStream2, Integer.valueOf(i7));
                    z2 = true;
                } else if (iArr[i8] == i7) {
                    Assertions.g(sampleStreamArr3[i8] == null);
                }
            }
            if (z2) {
                arrayList.add(this.f44765a[i7]);
            }
            i5 = i7 + 1;
            i3 = 0;
        }
        int i9 = i3;
        System.arraycopy(sampleStreamArr2, i9, sampleStreamArr, i9, length);
        this.f44773j = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[i9]);
        this.f44774k = this.f44768d.a(arrayList, Lists.p(arrayList, new Function() { // from class: androidx.media3.exoplayer.source.a0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((MediaPeriod) obj).s().c();
            }
        }));
        return j4;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        long j3 = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.f44773j) {
            long jL = mediaPeriod.l();
            if (jL == -9223372036854775807L) {
                if (j3 != -9223372036854775807L && mediaPeriod.j(j3) != j3) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j3 == -9223372036854775807L) {
                for (MediaPeriod mediaPeriod2 : this.f44773j) {
                    if (mediaPeriod2 == mediaPeriod) {
                        break;
                    }
                    if (mediaPeriod2.j(jL) != jL) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j3 = jL;
            } else if (jL != j3) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j3;
    }

    public MediaPeriod m(int i3) {
        return this.f44766b[i3] ? ((TimeOffsetMediaPeriod) this.f44765a[i3]).d() : this.f44765a[i3];
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void h(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f44771h)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() {
        for (MediaPeriod mediaPeriod : this.f44765a) {
            mediaPeriod.o();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f44771h = callback;
        Collections.addAll(this.f44769f, this.f44765a);
        for (MediaPeriod mediaPeriod : this.f44765a) {
            mediaPeriod.r(this, j3);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return (TrackGroupArray) Assertions.e(this.f44772i);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        for (MediaPeriod mediaPeriod : this.f44773j) {
            mediaPeriod.u(j3, z2);
        }
    }
}
