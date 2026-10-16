package androidx.media3.transformer;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.effect.MultipleInputVideoGraph;
import androidx.media3.transformer.TransformerVideoGraph;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TransformerMultipleInputVideoGraph extends MultipleInputVideoGraph implements TransformerVideoGraph {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements TransformerVideoGraph.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoFrameProcessor.Factory f48579a;

        public Factory(VideoFrameProcessor.Factory factory) {
            this.f48579a = factory;
        }

        @Override // androidx.media3.transformer.TransformerVideoGraph.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TransformerMultipleInputVideoGraph a(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List list, long j3, boolean z2) {
            return new TransformerMultipleInputVideoGraph(context, this.f48579a, colorInfo, debugViewProvider, listener, executor, videoCompositorSettings, list, j3, z2);
        }
    }

    @Override // androidx.media3.transformer.TransformerVideoGraph
    public void g() {
        w().b(-3L);
    }

    @Override // androidx.media3.transformer.TransformerVideoGraph
    public GraphInput i(int i3) throws VideoFrameProcessingException {
        l(i3);
        return new VideoFrameProcessingWrapper(h(i3), ImmutableList.y(), x());
    }

    private TransformerMultipleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List list, long j3, boolean z2) {
        super(context, factory, colorInfo, debugViewProvider, listener, executor, videoCompositorSettings, list, j3, z2);
    }
}
