package androidx.compose.foundation;

import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.MutatorMutex$mutate$2", f = "MutatorMutex.kt", l = {210, 125}, m = "invokeSuspend")
final class MutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f5082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5083d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f5084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutatePriority f5085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutatorMutex f5086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f5087i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f5085g = mutatePriority;
        this.f5086h = mutatorMutex;
        this.f5087i = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.f5085g, this.f5086h, this.f5087i, continuation);
        mutatorMutex$mutate$2.f5084f = obj;
        return mutatorMutex$mutate$2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        MutatorMutex.Mutator mutator;
        MutatorMutex mutatorMutex;
        Function1 function1;
        Throwable th;
        MutatorMutex mutatorMutex2;
        MutatorMutex.Mutator mutator2;
        Mutex mutex2;
        Object objF = IntrinsicsKt.f();
        ?? r12 = this.f5083d;
        try {
            try {
                if (r12 == 0) {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f5084f;
                    MutatePriority mutatePriority = this.f5085g;
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.v8);
                    Intrinsics.checkNotNull(element);
                    MutatorMutex.Mutator mutator3 = new MutatorMutex.Mutator(mutatePriority, (Job) element);
                    this.f5086h.g(mutator3);
                    mutex = this.f5086h.f5077b;
                    Function1 function12 = this.f5087i;
                    MutatorMutex mutatorMutex3 = this.f5086h;
                    this.f5084f = mutator3;
                    this.f5080a = mutex;
                    this.f5081b = function12;
                    this.f5082c = mutatorMutex3;
                    this.f5083d = 1;
                    if (mutex.f(null, this) != objF) {
                        mutator = mutator3;
                        mutatorMutex = mutatorMutex3;
                        function1 = function12;
                    }
                    return objF;
                }
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutatorMutex2 = (MutatorMutex) this.f5081b;
                    mutex2 = (Mutex) this.f5080a;
                    mutator2 = (MutatorMutex.Mutator) this.f5084f;
                    try {
                        ResultKt.b(obj);
                        androidx.compose.animation.core.h.a(mutatorMutex2.f5076a, mutator2, null);
                        mutex2.i(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        androidx.compose.animation.core.h.a(mutatorMutex2.f5076a, mutator2, null);
                        throw th;
                    }
                }
                mutatorMutex = (MutatorMutex) this.f5082c;
                function1 = (Function1) this.f5081b;
                Mutex mutex3 = (Mutex) this.f5080a;
                mutator = (MutatorMutex.Mutator) this.f5084f;
                ResultKt.b(obj);
                mutex = mutex3;
                this.f5084f = mutator;
                this.f5080a = mutex;
                this.f5081b = mutatorMutex;
                this.f5082c = null;
                this.f5083d = 2;
                Object objInvoke = function1.invoke(this);
                if (objInvoke != objF) {
                    mutatorMutex2 = mutatorMutex;
                    mutex2 = mutex;
                    obj = objInvoke;
                    mutator2 = mutator;
                    androidx.compose.animation.core.h.a(mutatorMutex2.f5076a, mutator2, null);
                    mutex2.i(null);
                    return obj;
                }
                return objF;
            } catch (Throwable th3) {
                th = th3;
                mutatorMutex2 = mutatorMutex;
                mutator2 = mutator;
                androidx.compose.animation.core.h.a(mutatorMutex2.f5076a, mutator2, null);
                throw th;
            }
        } catch (Throwable th4) {
            r12.i(null);
            throw th4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
