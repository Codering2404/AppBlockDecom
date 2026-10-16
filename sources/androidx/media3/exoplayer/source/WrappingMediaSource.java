package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Void f44992m = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final MediaSource f44993l;

    protected WrappingMediaSource(MediaSource mediaSource) {
        this.f44993l = mediaSource;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        this.f44993l.B(mediaPeriod);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public final long r0(Void r12, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        return A0(j3, mediaPeriodId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public final int s0(Void r12, int i3) {
        return C0(i3);
    }

    protected void E0(Timeline timeline) {
        j0(timeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public final void v0(Void r12, MediaSource mediaSource, Timeline timeline) {
        E0(timeline);
    }

    protected final void G0() {
        w0(f44992m, this.f44993l);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void H(MediaItem mediaItem) {
        this.f44993l.H(mediaItem);
    }

    protected void H0() {
        G0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean M() {
        return this.f44993l.M();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public Timeline O() {
        return this.f44993l.O();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected final void f0(TransferListener transferListener) {
        super.f0(transferListener);
        H0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        return this.f44993l.j(mediaPeriodId, allocator, j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem m() {
        return this.f44993l.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public final MediaSource.MediaPeriodId q0(Void r12, MediaSource.MediaPeriodId mediaPeriodId) {
        return y0(mediaPeriodId);
    }

    protected int C0(int i3) {
        return i3;
    }

    protected MediaSource.MediaPeriodId y0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    protected long A0(long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        return j3;
    }
}
