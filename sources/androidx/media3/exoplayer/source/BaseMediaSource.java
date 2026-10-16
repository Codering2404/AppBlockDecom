package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMediaSource implements MediaSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f44543a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f44544b = new HashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f44545c = new MediaSourceEventListener.EventDispatcher();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f44546d = new DrmSessionEventListener.EventDispatcher();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Looper f44547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Timeline f44548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PlayerId f44549h;

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void C(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f44547f;
        Assertions.a(looper == null || looper == looperMyLooper);
        this.f44549h = playerId;
        Timeline timeline = this.f44548g;
        this.f44543a.add(mediaSourceCaller);
        if (this.f44547f == null) {
            this.f44547f = looperMyLooper;
            this.f44544b.add(mediaSourceCaller);
            f0(transferListener);
        } else if (timeline != null) {
            G(mediaSourceCaller);
            mediaSourceCaller.z(this, timeline);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void G(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.e(this.f44547f);
        boolean zIsEmpty = this.f44544b.isEmpty();
        this.f44544b.add(mediaSourceCaller);
        if (zIsEmpty) {
            a0();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.f44543a.remove(mediaSourceCaller);
        if (!this.f44543a.isEmpty()) {
            K(mediaSourceCaller);
            return;
        }
        this.f44547f = null;
        this.f44548g = null;
        this.f44549h = null;
        this.f44544b.clear();
        l0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void K(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean zIsEmpty = this.f44544b.isEmpty();
        this.f44544b.remove(mediaSourceCaller);
        if (zIsEmpty || !this.f44544b.isEmpty()) {
            return;
        }
        W();
    }

    protected final DrmSessionEventListener.EventDispatcher P(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f44546d.o(i3, mediaPeriodId);
    }

    protected final DrmSessionEventListener.EventDispatcher Q(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f44546d.o(0, mediaPeriodId);
    }

    protected final MediaSourceEventListener.EventDispatcher T(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f44545c.x(i3, mediaPeriodId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher V(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f44545c.x(0, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void b(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.e(handler);
        Assertions.e(mediaSourceEventListener);
        this.f44545c.h(handler, mediaSourceEventListener);
    }

    protected final PlayerId b0() {
        return (PlayerId) Assertions.i(this.f44549h);
    }

    protected final boolean c0() {
        return !this.f44544b.isEmpty();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void d(MediaSourceEventListener mediaSourceEventListener) {
        this.f44545c.u(mediaSourceEventListener);
    }

    protected final boolean e0() {
        return !this.f44543a.isEmpty();
    }

    protected abstract void f0(TransferListener transferListener);

    protected final void j0(Timeline timeline) {
        this.f44548g = timeline;
        ArrayList arrayList = this.f44543a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((MediaSource.MediaSourceCaller) obj).z(this, timeline);
        }
    }

    protected abstract void l0();

    protected final void m0(PlayerId playerId) {
        this.f44549h = playerId;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void t(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.e(handler);
        Assertions.e(drmSessionEventListener);
        this.f44546d.g(handler, drmSessionEventListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void u(DrmSessionEventListener drmSessionEventListener) {
        this.f44546d.n(drmSessionEventListener);
    }

    protected void W() {
    }

    protected void a0() {
    }
}
