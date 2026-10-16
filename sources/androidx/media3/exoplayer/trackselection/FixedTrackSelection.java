package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FixedTrackSelection extends BaseTrackSelection {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f45438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f45439j;

    public FixedTrackSelection(TrackGroup trackGroup, int i3, int i4) {
        this(trackGroup, i3, i4, 0, null);
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int a() {
        return 0;
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i3, int i4, int i5, Object obj) {
        super(trackGroup, new int[]{i3}, i4);
        this.f45438i = i5;
        this.f45439j = obj;
    }
}
