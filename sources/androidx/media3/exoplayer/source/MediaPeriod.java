package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void g(MediaPeriod mediaPeriod);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    boolean a();

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    boolean b(LoadingInfo loadingInfo);

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    long c();

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    long e();

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    void f(long j3);

    long i(long j3, SeekParameters seekParameters);

    long j(long j3);

    long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3);

    long l();

    void o();

    void r(Callback callback, long j3);

    TrackGroupArray s();

    void u(long j3, boolean z2);
}
