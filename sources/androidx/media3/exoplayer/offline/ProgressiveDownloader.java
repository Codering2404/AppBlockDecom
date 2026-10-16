package androidx.media3.exoplayer.offline;

import androidx.media3.common.MediaItem;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.exoplayer.offline.Downloader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveDownloader implements Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f44473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSpec f44474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CacheDataSource f44475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CacheWriter f44476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PriorityTaskManager f44477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Downloader.ProgressListener f44478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile RunnableFutureTask f44479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f44480h;

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this.f44473a = (Executor) Assertions.e(executor);
        Assertions.e(mediaItem.f40714b);
        DataSpec dataSpecA = new DataSpec.Builder().i(mediaItem.f40714b.f40810a).f(mediaItem.f40714b.f40815f).b(4).a();
        this.f44474b = dataSpecA;
        CacheDataSource cacheDataSourceC = factory.c();
        this.f44475c = cacheDataSourceC;
        this.f44476d = new CacheWriter(cacheDataSourceC, dataSpecA, null, new CacheWriter.ProgressListener() { // from class: androidx.media3.exoplayer.offline.d
            @Override // androidx.media3.datasource.cache.CacheWriter.ProgressListener
            public final void a(long j3, long j4, long j5) {
                this.f44511a.d(j3, j4, j5);
            }
        });
        this.f44477e = factory.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j3, long j4, long j5) {
        Downloader.ProgressListener progressListener = this.f44478f;
        if (progressListener == null) {
            return;
        }
        progressListener.a(j3, j4, (j3 == -1 || j3 == 0) ? -1.0f : (j4 * 100.0f) / j3);
    }

    @Override // androidx.media3.exoplayer.offline.Downloader
    public void a(Downloader.ProgressListener progressListener) {
        this.f44478f = progressListener;
        PriorityTaskManager priorityTaskManager = this.f44477e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-4000);
        }
        boolean z2 = false;
        while (!z2) {
            try {
                if (this.f44480h) {
                    break;
                }
                this.f44479g = new RunnableFutureTask<Void, IOException>() { // from class: androidx.media3.exoplayer.offline.ProgressiveDownloader.1
                    @Override // androidx.media3.common.util.RunnableFutureTask
                    protected void c() {
                        ProgressiveDownloader.this.f44476d.b();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // androidx.media3.common.util.RunnableFutureTask
                    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                    public Void d() throws InterruptedIOException {
                        ProgressiveDownloader.this.f44476d.a();
                        return null;
                    }
                };
                PriorityTaskManager priorityTaskManager2 = this.f44477e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-4000);
                }
                this.f44473a.execute(this.f44479g);
                try {
                    this.f44479g.get();
                    z2 = true;
                } catch (ExecutionException e3) {
                    Throwable th = (Throwable) Assertions.e(e3.getCause());
                    if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th instanceof IOException) {
                            throw ((IOException) th);
                        }
                        Util.f1(th);
                    }
                }
            } catch (Throwable th2) {
                ((RunnableFutureTask) Assertions.e(this.f44479g)).a();
                PriorityTaskManager priorityTaskManager3 = this.f44477e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.d(-4000);
                }
                throw th2;
            }
        }
        ((RunnableFutureTask) Assertions.e(this.f44479g)).a();
        PriorityTaskManager priorityTaskManager4 = this.f44477e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.d(-4000);
        }
    }

    @Override // androidx.media3.exoplayer.offline.Downloader
    public void cancel() {
        this.f44480h = true;
        RunnableFutureTask runnableFutureTask = this.f44479g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    @Override // androidx.media3.exoplayer.offline.Downloader
    public void remove() {
        this.f44475c.o().k(this.f44475c.p().b(this.f44474b));
    }
}
