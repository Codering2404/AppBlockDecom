package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.RandomTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RandomTrackSelection extends BaseTrackSelection {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Random f45448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f45449j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements ExoTrackSelection.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Random f45450a;

        public static /* synthetic */ ExoTrackSelection b(Factory factory, ExoTrackSelection.Definition definition) {
            factory.getClass();
            return new RandomTrackSelection(definition.f45435a, definition.f45436b, definition.f45437c, factory.f45450a);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection.Factory
        public ExoTrackSelection[] a(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            return TrackSelectionUtil.c(definitionArr, new TrackSelectionUtil.AdaptiveTrackSelectionFactory() { // from class: androidx.media3.exoplayer.trackselection.v
                @Override // androidx.media3.exoplayer.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
                public final ExoTrackSelection a(ExoTrackSelection.Definition definition) {
                    return RandomTrackSelection.Factory.b(this.f45474a, definition);
                }
            });
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, int i3, Random random) {
        super(trackGroup, iArr, i3);
        this.f45448i = random;
        this.f45449j = random.nextInt(this.f45342b);
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int a() {
        return this.f45449j;
    }
}
