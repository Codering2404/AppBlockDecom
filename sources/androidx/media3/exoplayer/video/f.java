package androidx.media3.exoplayer.video;

import androidx.media3.common.util.HandlerWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HandlerWrapper f45885a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f45885a.j(runnable);
    }
}
