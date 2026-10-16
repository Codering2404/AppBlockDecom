package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {213}, m = "invokeSuspend")
final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f40027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f40028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Lifecycle f40029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f40030d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f40031f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f40029c = lifecycle;
        this.f40030d = state;
        this.f40031f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.f40029c, this.f40030d, this.f40031f, continuation);
        pausingDispatcherKt$whenStateAtLeast$2.f40028b = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LifecycleController lifecycleController;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f40027a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lifecycleController = (LifecycleController) this.f40028b;
            try {
                ResultKt.b(obj);
                lifecycleController.b();
                return obj;
            } catch (Throwable th) {
                th = th;
                lifecycleController.b();
                throw th;
            }
        }
        ResultKt.b(obj);
        Job job = (Job) ((CoroutineScope) this.f40028b).getCoroutineContext().get(Job.v8);
        if (job == null) {
            throw new IllegalStateException("when[State] methods should have a parent job");
        }
        PausingDispatcher pausingDispatcher = new PausingDispatcher();
        LifecycleController lifecycleController2 = new LifecycleController(this.f40029c, this.f40030d, pausingDispatcher.f40026b, job);
        try {
            Function2 function2 = this.f40031f;
            this.f40028b = lifecycleController2;
            this.f40027a = 1;
            obj = BuildersKt.g(pausingDispatcher, function2, this);
            if (obj == objF) {
                return objF;
            }
            lifecycleController = lifecycleController2;
            lifecycleController.b();
            return obj;
        } catch (Throwable th2) {
            th = th2;
            lifecycleController = lifecycleController2;
            lifecycleController.b();
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
