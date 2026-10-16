package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VideoFrameProcessingTaskExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f42676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f42677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Future f42678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ErrorListener f42679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f42680e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Queue f42681f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f42682g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ErrorListener {
        void a(VideoFrameProcessingException videoFrameProcessingException);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Task {
        void run();
    }

    public VideoFrameProcessingTaskExecutor(ExecutorService executorService, boolean z2, ErrorListener errorListener) {
        this.f42677b = executorService;
        this.f42678c = executorService.submit(new Callable() { // from class: androidx.media3.effect.s2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Thread.currentThread();
            }
        });
        this.f42676a = z2;
        this.f42679d = errorListener;
    }

    public static /* synthetic */ void b(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Task task) {
        videoFrameProcessingTaskExecutor.getClass();
        try {
            task.run();
        } catch (Exception e3) {
            videoFrameProcessingTaskExecutor.f(e3);
        }
    }

    public static /* synthetic */ void c(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z2, Task task) {
        Task task2;
        videoFrameProcessingTaskExecutor.getClass();
        try {
            synchronized (videoFrameProcessingTaskExecutor.f42680e) {
                try {
                    if (videoFrameProcessingTaskExecutor.f42682g && z2) {
                        return;
                    }
                    while (true) {
                        synchronized (videoFrameProcessingTaskExecutor.f42680e) {
                            task2 = (Task) videoFrameProcessingTaskExecutor.f42681f.poll();
                        }
                        if (task2 == null) {
                            task.run();
                            return;
                        }
                        task2.run();
                    }
                } finally {
                }
            }
        } catch (Exception e3) {
            videoFrameProcessingTaskExecutor.f(e3);
        }
    }

    public static /* synthetic */ void d(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, CountDownLatch countDownLatch) {
        synchronized (videoFrameProcessingTaskExecutor.f42680e) {
            videoFrameProcessingTaskExecutor.f42682g = false;
        }
        countDownLatch.countDown();
    }

    private void f(Exception exc) {
        synchronized (this.f42680e) {
            try {
                if (this.f42682g) {
                    return;
                }
                this.f42682g = true;
                this.f42679d.a(VideoFrameProcessingException.a(exc));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean h() throws InterruptedException {
        try {
            return Thread.currentThread() == ((Thread) this.f42678c.get(500L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e3) {
            throw e3;
        } catch (Exception e4) {
            f(e4);
            return false;
        }
    }

    private Future n(final Task task, final boolean z2) {
        return this.f42677b.submit(new Runnable() { // from class: androidx.media3.effect.o2
            @Override // java.lang.Runnable
            public final void run() {
                VideoFrameProcessingTaskExecutor.c(this.f42771a, z2, task);
            }
        });
    }

    public void e() throws InterruptedException {
        synchronized (this.f42680e) {
            this.f42682g = true;
            this.f42681f.clear();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        n(new Task() { // from class: androidx.media3.effect.r2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                VideoFrameProcessingTaskExecutor.d(this.f42786a, countDownLatch);
            }
        }, false);
        countDownLatch.await();
    }

    public void g(final Task task) {
        if (h()) {
            try {
                task.run();
                return;
            } catch (Exception e3) {
                f(e3);
                return;
            }
        }
        try {
            this.f42677b.submit(new Runnable() { // from class: androidx.media3.effect.q2
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrameProcessingTaskExecutor.b(this.f42782a, task);
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (RuntimeException | ExecutionException | TimeoutException e4) {
            f(e4);
        }
    }

    public void i(Task task) {
        Assertions.g(!h());
        synchronized (this.f42680e) {
            this.f42682g = true;
            this.f42681f.clear();
        }
        n(task, false);
        if (this.f42676a) {
            this.f42677b.shutdown();
            if (this.f42677b.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.f42679d.a(new VideoFrameProcessingException("Release timed out. OpenGL resources may not be cleaned up properly."));
        }
    }

    public void j(Task task) {
        k(task, true);
    }

    public void k(Task task, boolean z2) {
        synchronized (this.f42680e) {
            if (this.f42682g && z2) {
                return;
            }
            try {
                n(task, z2);
                e = null;
            } catch (RejectedExecutionException e3) {
                e = e3;
            }
            if (e != null) {
                f(e);
            }
        }
    }

    public void l(Task task) {
        synchronized (this.f42680e) {
            try {
                if (this.f42682g) {
                    return;
                }
                this.f42681f.add(task);
                j(new Task() { // from class: androidx.media3.effect.p2
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        VideoFrameProcessingTaskExecutor.a();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m() {
        try {
            Assertions.g(h());
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            f(e3);
        }
    }

    public static /* synthetic */ void a() {
    }
}
