package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ListenableWorker {
    private Context mAppContext;
    private volatile int mStopReason = -256;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Result {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Failure extends Result {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Data f54536a;

            public Failure() {
                this(Data.f54509c);
            }

            public Data e() {
                return this.f54536a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.f54536a.equals(((Failure) obj).f54536a);
            }

            public int hashCode() {
                return (Failure.class.getName().hashCode() * 31) + this.f54536a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f54536a + '}';
            }

            public Failure(Data data) {
                this.f54536a = data;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public int hashCode() {
                return Retry.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Success extends Result {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Data f54537a;

            public Success() {
                this(Data.f54509c);
            }

            public Data e() {
                return this.f54537a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.f54537a.equals(((Success) obj).f54537a);
            }

            public int hashCode() {
                return (Success.class.getName().hashCode() * 31) + this.f54537a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f54537a + '}';
            }

            public Success(Data data) {
                this.f54537a = data;
            }
        }

        Result() {
        }

        public static Result a() {
            return new Failure();
        }

        public static Result b() {
            return new Retry();
        }

        public static Result c() {
            return new Success();
        }

        public static Result d(Data data) {
            return new Success(data);
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.a();
    }

    public ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFutureS = SettableFuture.s();
        settableFutureS.p(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFutureS;
    }

    public final UUID getId() {
        return this.mWorkerParams.c();
    }

    public final Data getInputData() {
        return this.mWorkerParams.d();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.e();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.g();
    }

    public final int getStopReason() {
        return this.mStopReason;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.h();
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.i();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.j();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.k();
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.l();
    }

    public final boolean isStopped() {
        return this.mStopReason != -256;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        return this.mWorkerParams.b().a(getApplicationContext(), getId(), foregroundInfo);
    }

    public ListenableFuture<Void> setProgressAsync(Data data) {
        return this.mWorkerParams.f().a(getApplicationContext(), getId(), data);
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture startWork();

    public final void stop(int i3) {
        this.mStopReason = i3;
        onStopped();
    }

    public void onStopped() {
    }
}
