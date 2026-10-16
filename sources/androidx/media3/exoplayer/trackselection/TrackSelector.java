package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TrackSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InvalidationListener f45453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BandwidthMeter f45454b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        TrackSelector a(Context context);
    }

    protected final BandwidthMeter b() {
        return (BandwidthMeter) Assertions.i(this.f45454b);
    }

    public TrackSelectionParameters c() {
        return TrackSelectionParameters.F;
    }

    public RendererCapabilities.Listener d() {
        return null;
    }

    public void e(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.f45453a = invalidationListener;
        this.f45454b = bandwidthMeter;
    }

    protected final void f() {
        InvalidationListener invalidationListener = this.f45453a;
        if (invalidationListener != null) {
            invalidationListener.b();
        }
    }

    protected final void g(Renderer renderer) {
        InvalidationListener invalidationListener = this.f45453a;
        if (invalidationListener != null) {
            invalidationListener.a(renderer);
        }
    }

    public boolean h() {
        return false;
    }

    public abstract void i(Object obj);

    public void j() {
        this.f45453a = null;
        this.f45454b = null;
    }

    public abstract TrackSelectorResult k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InvalidationListener {
        void b();

        default void a(Renderer renderer) {
        }
    }

    public void l(AudioAttributes audioAttributes) {
    }
}
