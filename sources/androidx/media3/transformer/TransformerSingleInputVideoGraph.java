package androidx.media3.transformer;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.SingleInputVideoGraph;
import androidx.media3.transformer.TransformerVideoGraph;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TransformerSingleInputVideoGraph extends SingleInputVideoGraph implements TransformerVideoGraph {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f48580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private VideoFrameProcessingWrapper f48581o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements TransformerVideoGraph.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoFrameProcessor.Factory f48582a;

        public Factory(VideoFrameProcessor.Factory factory) {
            this.f48582a = factory;
        }

        @Override // androidx.media3.transformer.TransformerVideoGraph.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TransformerSingleInputVideoGraph a(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List list, long j3, boolean z2) {
            return new TransformerSingleInputVideoGraph(context, this.f48582a, colorInfo, listener, debugViewProvider, executor, videoCompositorSettings, z2, list, j3);
        }
    }

    @Override // androidx.media3.transformer.TransformerVideoGraph
    public void g() {
        h(k()).b(-3L);
    }

    @Override // androidx.media3.transformer.TransformerVideoGraph
    public GraphInput i(int i3) {
        Assertions.g(this.f48581o == null);
        l(i3);
        VideoFrameProcessingWrapper videoFrameProcessingWrapper = new VideoFrameProcessingWrapper(h(i3), this.f48580n, e());
        this.f48581o = videoFrameProcessingWrapper;
        return videoFrameProcessingWrapper;
    }

    private TransformerSingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, VideoGraph.Listener listener, DebugViewProvider debugViewProvider, Executor executor, VideoCompositorSettings videoCompositorSettings, boolean z2, List list, long j3) {
        super(context, factory, colorInfo, listener, debugViewProvider, executor, videoCompositorSettings, z2, j3);
        this.f48580n = list;
    }
}
