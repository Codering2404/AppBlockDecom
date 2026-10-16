package androidx.media3.effect;

import androidx.media3.effect.VideoFrameProcessingTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements VideoFrameProcessingTaskExecutor.Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultVideoCompositor f42806a;

    public /* synthetic */ w(DefaultVideoCompositor defaultVideoCompositor) {
        this.f42806a = defaultVideoCompositor;
    }

    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
    public final void run() throws Throwable {
        this.f42806a.k();
    }
}
