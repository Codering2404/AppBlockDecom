package androidx.media3.common;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectionOverride {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f41158c = Util.y0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41159d = Util.y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackGroup f41160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList f41161b;

    public int a() {
        return this.f41160a.f41155c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackSelectionOverride.class == obj.getClass()) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
            if (this.f41160a.equals(trackSelectionOverride.f41160a) && this.f41161b.equals(trackSelectionOverride.f41161b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f41160a.hashCode() + (this.f41161b.hashCode() * 31);
    }
}
