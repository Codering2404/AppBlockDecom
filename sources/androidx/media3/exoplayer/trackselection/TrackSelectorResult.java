package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.RendererConfiguration;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectorResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RendererConfiguration[] f45456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExoTrackSelection[] f45457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Tracks f45458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f45459e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Tracks tracks, Object obj) {
        Assertions.a(rendererConfigurationArr.length == exoTrackSelectionArr.length);
        this.f45456b = rendererConfigurationArr;
        this.f45457c = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.f45458d = tracks;
        this.f45459e = obj;
        this.f45455a = rendererConfigurationArr.length;
    }

    public boolean a(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.f45457c.length != this.f45457c.length) {
            return false;
        }
        for (int i3 = 0; i3 < this.f45457c.length; i3++) {
            if (!b(trackSelectorResult, i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(TrackSelectorResult trackSelectorResult, int i3) {
        return trackSelectorResult != null && Objects.equals(this.f45456b[i3], trackSelectorResult.f45456b[i3]) && Objects.equals(this.f45457c[i3], trackSelectorResult.f45457c[i3]);
    }

    public boolean c(int i3) {
        return this.f45456b[i3] != null;
    }
}
