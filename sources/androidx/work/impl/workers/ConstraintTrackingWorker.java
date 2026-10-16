package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkerParameters f55264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f55265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f55266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SettableFuture f55267d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListenableWorker f55268f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.f55264a = workerParameters;
        this.f55265b = new Object();
        this.f55267d = SettableFuture.s();
    }

    private final void d() {
        if (this.f55267d.isCancelled()) {
            return;
        }
        String strJ = getInputData().j("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        Logger loggerE = Logger.e();
        Intrinsics.checkNotNullExpressionValue(loggerE, "get()");
        if (strJ == null || strJ.length() == 0) {
            loggerE.c(ConstraintTrackingWorkerKt.f55269a, "No worker to delegate to.");
            SettableFuture future = this.f55267d;
            Intrinsics.checkNotNullExpressionValue(future, "future");
            ConstraintTrackingWorkerKt.d(future);
            return;
        }
        ListenableWorker listenableWorkerB = getWorkerFactory().b(getApplicationContext(), strJ, this.f55264a);
        this.f55268f = listenableWorkerB;
        if (listenableWorkerB == null) {
            loggerE.a(ConstraintTrackingWorkerKt.f55269a, "No worker to delegate to.");
            SettableFuture future2 = this.f55267d;
            Intrinsics.checkNotNullExpressionValue(future2, "future");
            ConstraintTrackingWorkerKt.d(future2);
            return;
        }
        WorkManagerImpl workManagerImplR = WorkManagerImpl.r(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImplR, "getInstance(applicationContext)");
        WorkSpecDao workSpecDaoT = workManagerImplR.w().t();
        String string = getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
        WorkSpec workSpecL = workSpecDaoT.l(string);
        if (workSpecL == null) {
            SettableFuture future3 = this.f55267d;
            Intrinsics.checkNotNullExpressionValue(future3, "future");
            ConstraintTrackingWorkerKt.d(future3);
            return;
        }
        Trackers trackersV = workManagerImplR.v();
        Intrinsics.checkNotNullExpressionValue(trackersV, "workManagerImpl.trackers");
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackersV);
        CoroutineDispatcher coroutineDispatcherB = workManagerImplR.x().b();
        Intrinsics.checkNotNullExpressionValue(coroutineDispatcherB, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
        final Job jobB = WorkConstraintsTrackerKt.b(workConstraintsTracker, workSpecL, coroutineDispatcherB, this);
        this.f55267d.addListener(new Runnable() { // from class: j.b
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.f(jobB);
            }
        }, new SynchronousExecutor());
        if (!workConstraintsTracker.a(workSpecL)) {
            loggerE.a(ConstraintTrackingWorkerKt.f55269a, "Constraints not met for delegate " + strJ + ". Requesting retry.");
            SettableFuture future4 = this.f55267d;
            Intrinsics.checkNotNullExpressionValue(future4, "future");
            ConstraintTrackingWorkerKt.e(future4);
            return;
        }
        loggerE.a(ConstraintTrackingWorkerKt.f55269a, "Constraints met for delegate " + strJ);
        try {
            ListenableWorker listenableWorker = this.f55268f;
            Intrinsics.checkNotNull(listenableWorker);
            final ListenableFuture listenableFutureStartWork = listenableWorker.startWork();
            Intrinsics.checkNotNullExpressionValue(listenableFutureStartWork, "delegate!!.startWork()");
            listenableFutureStartWork.addListener(new Runnable() { // from class: j.c
                @Override // java.lang.Runnable
                public final void run() {
                    ConstraintTrackingWorker.g(this.f139530a, listenableFutureStartWork);
                }
            }, getBackgroundExecutor());
        } catch (Throwable th) {
            loggerE.b(ConstraintTrackingWorkerKt.f55269a, "Delegated worker " + strJ + " threw exception in startWork.", th);
            synchronized (this.f55265b) {
                try {
                    if (!this.f55266c) {
                        SettableFuture future5 = this.f55267d;
                        Intrinsics.checkNotNullExpressionValue(future5, "future");
                        ConstraintTrackingWorkerKt.d(future5);
                    } else {
                        loggerE.a(ConstraintTrackingWorkerKt.f55269a, "Constraints were unmet, Retrying.");
                        SettableFuture future6 = this.f55267d;
                        Intrinsics.checkNotNullExpressionValue(future6, "future");
                        ConstraintTrackingWorkerKt.e(future6);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Job job) {
        Intrinsics.checkNotNullParameter(job, "$job");
        job.cancel((CancellationException) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ConstraintTrackingWorker this$0, ListenableFuture innerFuture) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(innerFuture, "$innerFuture");
        synchronized (this$0.f55265b) {
            try {
                if (this$0.f55266c) {
                    SettableFuture future = this$0.f55267d;
                    Intrinsics.checkNotNullExpressionValue(future, "future");
                    ConstraintTrackingWorkerKt.e(future);
                } else {
                    this$0.f55267d.q(innerFuture);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ConstraintTrackingWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f55268f;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? getStopReason() : 0);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: j.a
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.h(this.f139528a);
            }
        });
        SettableFuture future = this.f55267d;
        Intrinsics.checkNotNullExpressionValue(future, "future");
        return future;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void e(WorkSpec workSpec, ConstraintsState state) {
        Intrinsics.checkNotNullParameter(workSpec, bfIdKSjLOVjG.tmhV);
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.e().a(ConstraintTrackingWorkerKt.f55269a, "Constraints changed for " + workSpec);
        if (state instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.f55265b) {
                this.f55266c = true;
                Unit unit = Unit.f139807a;
            }
        }
    }
}
