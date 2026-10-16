package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FilteringMediaSource extends WrappingMediaSource {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ImmutableSet f44693n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FilteringMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaPeriod f44694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImmutableSet f44695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MediaPeriod.Callback f44696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TrackGroupArray f44697d;

        public FilteringMediaPeriod(MediaPeriod mediaPeriod, ImmutableSet immutableSet) {
            this.f44694a = mediaPeriod;
            this.f44695b = immutableSet;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean a() {
            return this.f44694a.a();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean b(LoadingInfo loadingInfo) {
            return this.f44694a.b(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long c() {
            return this.f44694a.c();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void h(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.e(this.f44696c)).h(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long e() {
            return this.f44694a.e();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public void f(long j3) {
            this.f44694a.f(j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public void g(MediaPeriod mediaPeriod) {
            TrackGroupArray trackGroupArrayS = mediaPeriod.s();
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i3 = 0; i3 < trackGroupArrayS.f44987a; i3++) {
                TrackGroup trackGroupB = trackGroupArrayS.b(i3);
                if (this.f44695b.contains(Integer.valueOf(trackGroupB.f41155c))) {
                    builderO.a(trackGroupB);
                }
            }
            this.f44697d = new TrackGroupArray((TrackGroup[]) builderO.m().toArray(new TrackGroup[0]));
            ((MediaPeriod.Callback) Assertions.e(this.f44696c)).g(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long i(long j3, SeekParameters seekParameters) {
            return this.f44694a.i(j3, seekParameters);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long j(long j3) {
            return this.f44694a.j(j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
            return this.f44694a.k(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long l() {
            return this.f44694a.l();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void o() {
            this.f44694a.o();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void r(MediaPeriod.Callback callback, long j3) {
            this.f44696c = callback;
            this.f44694a.r(this, j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public TrackGroupArray s() {
            return (TrackGroupArray) Assertions.e(this.f44697d);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void u(long j3, boolean z2) {
            this.f44694a.u(j3, z2);
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        super.B(((FilteringMediaPeriod) mediaPeriod).f44694a);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        return new FilteringMediaPeriod(super.j(mediaPeriodId, allocator, j3), this.f44693n);
    }
}
