package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PreviewingSingleInputVideoGraph extends SingleInputVideoGraph implements PreviewingVideoGraph {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements PreviewingVideoGraph.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoFrameProcessor.Factory f42536a;

        public Factory(VideoFrameProcessor.Factory factory) {
            this.f42536a = factory;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public boolean a() {
            return false;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public PreviewingVideoGraph b(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List list, long j3) {
            return new PreviewingSingleInputVideoGraph(context, this.f42536a, colorInfo, debugViewProvider, listener, executor, j3);
        }
    }

    @Override // androidx.media3.common.PreviewingVideoGraph
    public void b(long j3) {
        h(k()).b(j3);
    }

    private PreviewingSingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, long j3) {
        super(context, factory, colorInfo, listener, debugViewProvider, executor, VideoCompositorSettings.f41251a, false, j3);
    }
}
