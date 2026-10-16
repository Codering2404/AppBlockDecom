package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class CoroutineWorker extends ListenableWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompletableJob f54499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SettableFuture f54500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f54501c;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f54502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f54503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JobListenableFuture f54504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CoroutineWorker f54505d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JobListenableFuture jobListenableFuture, CoroutineWorker coroutineWorker, Continuation continuation) {
            super(2, continuation);
            this.f54504c = jobListenableFuture;
            this.f54505d = coroutineWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f54504c, this.f54505d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            JobListenableFuture jobListenableFuture;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f54503b;
            if (i3 == 0) {
                ResultKt.b(obj);
                JobListenableFuture jobListenableFuture2 = this.f54504c;
                CoroutineWorker coroutineWorker = this.f54505d;
                this.f54502a = jobListenableFuture2;
                this.f54503b = 1;
                Object objF2 = coroutineWorker.f(this);
                if (objF2 == objF) {
                    return objF;
                }
                jobListenableFuture = jobListenableFuture2;
                obj = objF2;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jobListenableFuture = (JobListenableFuture) this.f54502a;
                ResultKt.b(obj);
            }
            jobListenableFuture.b(obj);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    static final class C03541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f54506a;

        C03541(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CoroutineWorker.this.new C03541(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f54506a;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.f54506a = 1;
                    obj = coroutineWorker.c(this);
                    if (obj == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                CoroutineWorker.this.h().o((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.h().p(th);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03541) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f54499a = JobKt__JobKt.b(null, 1, null);
        SettableFuture settableFutureS = SettableFuture.s();
        Intrinsics.checkNotNullExpressionValue(settableFutureS, "create()");
        this.f54500b = settableFutureS;
        settableFutureS.addListener(new Runnable() { // from class: androidx.work.a
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineWorker.b(this.f54620a);
            }
        }, getTaskExecutor().c());
        this.f54501c = Dispatchers.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CoroutineWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f54500b.isCancelled()) {
            Job.DefaultImpls.b(this$0.f54499a, null, 1, null);
        }
    }

    static /* synthetic */ Object g(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object c(Continuation continuation);

    public CoroutineDispatcher d() {
        return this.f54501c;
    }

    public Object f(Continuation continuation) {
        return g(this, continuation);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        CompletableJob completableJobB = JobKt__JobKt.b(null, 1, null);
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(d().plus(completableJobB));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(completableJobB, null, 2, null);
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    public final SettableFuture h() {
        return this.f54500b;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.f54500b.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(d().plus(this.f54499a)), null, null, new C03541(null), 3, null);
        return this.f54500b;
    }
}
