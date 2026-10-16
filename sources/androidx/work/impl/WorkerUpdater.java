package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class WorkerUpdater {
    public static final Operation c(final WorkManagerImpl workManagerImpl, final String name, final WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter(workManagerImpl, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(workRequest, "workRequest");
        final OperationImpl operationImpl = new OperationImpl();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.work.impl.WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m364invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m364invoke() {
                new EnqueueRunnable(new WorkContinuationImpl(workManagerImpl, name, ExistingWorkPolicy.KEEP, CollectionsKt.listOf(workRequest)), operationImpl).run();
            }
        };
        workManagerImpl.x().c().execute(new Runnable() { // from class: androidx.work.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.d(workManagerImpl, name, operationImpl, function0, workRequest);
            }
        });
        return operationImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WorkManagerImpl this_enqueueUniquelyNamedPeriodic, String name, OperationImpl operation, Function0 enqueueNew, WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter(this_enqueueUniquelyNamedPeriodic, "$this_enqueueUniquelyNamedPeriodic");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        Intrinsics.checkNotNullParameter(enqueueNew, "$enqueueNew");
        Intrinsics.checkNotNullParameter(workRequest, "$workRequest");
        WorkSpecDao workSpecDaoT = this_enqueueUniquelyNamedPeriodic.w().t();
        List listT = workSpecDaoT.t(name);
        if (listT.size() > 1) {
            e(operation, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) CollectionsKt.firstOrNull(listT);
        if (idAndState == null) {
            enqueueNew.invoke();
            return;
        }
        WorkSpec workSpecL = workSpecDaoT.l(idAndState.f55036a);
        if (workSpecL == null) {
            operation.a(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + idAndState.f55036a + ", that matches a name \"" + name + "\", wasn't found")));
            return;
        }
        if (!workSpecL.m()) {
            e(operation, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return;
        }
        if (idAndState.f55037b == WorkInfo.State.CANCELLED) {
            workSpecDaoT.c(idAndState.f55036a);
            enqueueNew.invoke();
            return;
        }
        WorkSpec workSpecE = WorkSpec.e(workRequest.d(), idAndState.f55036a, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388606, null);
        try {
            Processor processor = this_enqueueUniquelyNamedPeriodic.t();
            Intrinsics.checkNotNullExpressionValue(processor, "processor");
            WorkDatabase workDatabase = this_enqueueUniquelyNamedPeriodic.w();
            Intrinsics.checkNotNullExpressionValue(workDatabase, "workDatabase");
            Configuration configuration = this_enqueueUniquelyNamedPeriodic.p();
            Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
            List schedulers = this_enqueueUniquelyNamedPeriodic.u();
            Intrinsics.checkNotNullExpressionValue(schedulers, "schedulers");
            f(processor, workDatabase, configuration, schedulers, workSpecE, workRequest.c());
            operation.a(Operation.f54551a);
        } catch (Throwable th) {
            operation.a(new Operation.State.FAILURE(th));
        }
    }

    private static final void e(OperationImpl operationImpl, String str) {
        operationImpl.a(new Operation.State.FAILURE(new UnsupportedOperationException(str)));
    }

    private static final WorkManager.UpdateResult f(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List list, final WorkSpec workSpec, final Set set) {
        final String str = workSpec.f55013a;
        final WorkSpec workSpecL = workDatabase.t().l(str);
        if (workSpecL == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        }
        if (workSpecL.f55014b.b()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (workSpecL.m() ^ workSpec.m()) {
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = new Function1<WorkSpec, String>() { // from class: androidx.work.impl.WorkerUpdater$updateWorkImpl$type$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final String invoke(WorkSpec spec) {
                    Intrinsics.checkNotNullParameter(spec, "spec");
                    return spec.m() ? "Periodic" : "OneTime";
                }
            };
            throw new UnsupportedOperationException("Can't update " + ((String) workerUpdater$updateWorkImpl$type$1.invoke(workSpecL)) + " Worker to " + ((String) workerUpdater$updateWorkImpl$type$1.invoke(workSpec)) + " Worker. Update operation must preserve worker's type.");
        }
        final boolean zK = processor.k(str);
        if (!zK) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).a(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.g(workDatabase, workSpecL, workSpec, list, str, set, zK);
            }
        });
        if (!zK) {
            Schedulers.f(configuration, workDatabase, list);
        }
        return zK ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WorkDatabase workDatabase, WorkSpec oldWorkSpec, WorkSpec newWorkSpec, List schedulers, String workSpecId, Set tags, boolean z2) {
        Intrinsics.checkNotNullParameter(workDatabase, "$workDatabase");
        Intrinsics.checkNotNullParameter(oldWorkSpec, "$oldWorkSpec");
        Intrinsics.checkNotNullParameter(newWorkSpec, "$newWorkSpec");
        Intrinsics.checkNotNullParameter(schedulers, "$schedulers");
        Intrinsics.checkNotNullParameter(workSpecId, "$workSpecId");
        Intrinsics.checkNotNullParameter(tags, "$tags");
        WorkSpecDao workSpecDaoT = workDatabase.t();
        WorkTagDao workTagDaoU = workDatabase.u();
        WorkSpec workSpecE = WorkSpec.e(newWorkSpec, null, oldWorkSpec.f55014b, null, null, null, null, 0L, 0L, 0L, null, oldWorkSpec.f55023k, null, 0L, oldWorkSpec.f55026n, 0L, 0L, false, null, oldWorkSpec.i(), oldWorkSpec.f() + 1, oldWorkSpec.g(), oldWorkSpec.h(), 0, 4447229, null);
        if (newWorkSpec.h() == 1) {
            workSpecE.n(newWorkSpec.g());
            workSpecE.o(workSpecE.h() + 1);
        }
        workSpecDaoT.b(EnqueueUtilsKt.b(schedulers, workSpecE));
        workTagDaoU.b(workSpecId);
        workTagDaoU.e(workSpecId, tags);
        if (z2) {
            return;
        }
        workSpecDaoT.s(workSpecId, -1L);
        workDatabase.s().c(workSpecId);
    }
}
