package androidx.media3.exoplayer.offline;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.RendererCapabilitiesList;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DownloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultTrackSelector.Parameters f44378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DefaultTrackSelector.Parameters f44379b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DownloadTrackSelection extends BaseTrackSelection {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class Factory implements ExoTrackSelection.Factory {
            @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection.Factory
            public ExoTrackSelection[] a(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
                ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
                for (int i3 = 0; i3 < definitionArr.length; i3++) {
                    ExoTrackSelection.Definition definition = definitionArr[i3];
                    exoTrackSelectionArr[i3] = definition == null ? null : new DownloadTrackSelection(definition.f45435a, definition.f45436b);
                }
                return exoTrackSelectionArr;
            }
        }

        public DownloadTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public int a() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LiveContentUnsupportedException extends IOException {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaPreparer implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaSource f44380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Allocator f44381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList f44382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f44383d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final HandlerThread f44384f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Handler f44385g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Timeline f44386h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public MediaPeriod[] f44387i;

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void h(MediaPeriod mediaPeriod) {
            if (this.f44382c.contains(mediaPeriod)) {
                this.f44385g.obtainMessage(3, mediaPeriod).sendToTarget();
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public void g(MediaPeriod mediaPeriod) {
            this.f44382c.remove(mediaPeriod);
            if (this.f44382c.isEmpty()) {
                this.f44385g.removeMessages(2);
                this.f44383d.sendEmptyMessage(1);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                this.f44380a.C(this, null, PlayerId.f43489d);
                this.f44385g.sendEmptyMessage(2);
                return true;
            }
            int i4 = 0;
            if (i3 == 2) {
                try {
                    if (this.f44387i == null) {
                        this.f44380a.L();
                    } else {
                        while (i4 < this.f44382c.size()) {
                            ((MediaPeriod) this.f44382c.get(i4)).o();
                            i4++;
                        }
                    }
                    this.f44385g.sendEmptyMessageDelayed(2, 100L);
                } catch (IOException e3) {
                    this.f44383d.obtainMessage(2, e3).sendToTarget();
                }
                return true;
            }
            if (i3 == 3) {
                MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                if (this.f44382c.contains(mediaPeriod)) {
                    mediaPeriod.b(new LoadingInfo.Builder().f(0L).d());
                }
                return true;
            }
            if (i3 != 4) {
                return false;
            }
            MediaPeriod[] mediaPeriodArr = this.f44387i;
            if (mediaPeriodArr != null) {
                int length = mediaPeriodArr.length;
                while (i4 < length) {
                    this.f44380a.B(mediaPeriodArr[i4]);
                    i4++;
                }
            }
            this.f44380a.J(this);
            this.f44385g.removeCallbacksAndMessages(null);
            this.f44384f.quit();
            return true;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
        public void z(MediaSource mediaSource, Timeline timeline) {
            MediaPeriod[] mediaPeriodArr;
            if (this.f44386h != null) {
                return;
            }
            if (timeline.n(0, new Timeline.Window()).f()) {
                this.f44383d.obtainMessage(2, new LiveContentUnsupportedException()).sendToTarget();
                return;
            }
            this.f44386h = timeline;
            this.f44387i = new MediaPeriod[timeline.i()];
            int i3 = 0;
            while (true) {
                mediaPeriodArr = this.f44387i;
                if (i3 >= mediaPeriodArr.length) {
                    break;
                }
                MediaPeriod mediaPeriodJ = this.f44380a.j(new MediaSource.MediaPeriodId(timeline.m(i3)), this.f44381b, 0L);
                this.f44387i[i3] = mediaPeriodJ;
                this.f44382c.add(mediaPeriodJ);
                i3++;
            }
            for (MediaPeriod mediaPeriod : mediaPeriodArr) {
                mediaPeriod.r(this, 0L);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnreleaseableRendererCapabilitiesList implements RendererCapabilitiesList {
    }

    static {
        DefaultTrackSelector.Parameters parametersF = DefaultTrackSelector.Parameters.G0.f().f0(true).e0(false).F();
        f44378a = parametersF;
        f44379b = parametersF;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FakeBandwidthMeter implements BandwidthMeter {
        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public TransferListener d() {
            return null;
        }

        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public void a(BandwidthMeter.EventListener eventListener) {
        }

        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public void b(Handler handler, BandwidthMeter.EventListener eventListener) {
        }
    }
}
