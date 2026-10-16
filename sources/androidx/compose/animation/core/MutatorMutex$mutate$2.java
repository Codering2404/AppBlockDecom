package androidx.compose.animation.core;

import androidx.compose.animation.core.MutatorMutex;
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
@DebugMetadata(c = "androidx.compose.animation.core.MutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {176, 124}, m = "invokeSuspend")
final class MutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f4032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f4033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f4034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4035d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f4036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutatePriority f4037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutatorMutex f4038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f4039i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f4037g = mutatePriority;
        this.f4038h = mutatorMutex;
        this.f4039i = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.f4037g, this.f4038h, this.f4039i, continuation);
        mutatorMutex$mutate$2.f4036f = obj;
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
        ?? r12 = this.f4035d;
        try {
            try {
                if (r12 == 0) {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f4036f;
                    MutatePriority mutatePriority = this.f4037g;
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.v8);
                    Intrinsics.checkNotNull(element);
                    MutatorMutex.Mutator mutator3 = new MutatorMutex.Mutator(mutatePriority, (Job) element);
                    this.f4038h.f(mutator3);
                    mutex = this.f4038h.f4029b;
                    Function1 function12 = this.f4039i;
                    MutatorMutex mutatorMutex3 = this.f4038h;
                    this.f4036f = mutator3;
                    this.f4032a = mutex;
                    this.f4033b = function12;
                    this.f4034c = mutatorMutex3;
                    this.f4035d = 1;
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
                    mutatorMutex2 = (MutatorMutex) this.f4033b;
                    mutex2 = (Mutex) this.f4032a;
                    mutator2 = (MutatorMutex.Mutator) this.f4036f;
                    try {
                        ResultKt.b(obj);
                        h.a(mutatorMutex2.f4028a, mutator2, null);
                        mutex2.i(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        h.a(mutatorMutex2.f4028a, mutator2, null);
                        throw th;
                    }
                }
                mutatorMutex = (MutatorMutex) this.f4034c;
                function1 = (Function1) this.f4033b;
                Mutex mutex3 = (Mutex) this.f4032a;
                mutator = (MutatorMutex.Mutator) this.f4036f;
                ResultKt.b(obj);
                mutex = mutex3;
                this.f4036f = mutator;
                this.f4032a = mutex;
                this.f4033b = mutatorMutex;
                this.f4034c = null;
                this.f4035d = 2;
                Object objInvoke = function1.invoke(this);
                if (objInvoke != objF) {
                    mutatorMutex2 = mutatorMutex;
                    mutex2 = mutex;
                    obj = objInvoke;
                    mutator2 = mutator;
                    h.a(mutatorMutex2.f4028a, mutator2, null);
                    mutex2.i(null);
                    return obj;
                }
                return objF;
            } catch (Throwable th3) {
                th = th3;
                mutatorMutex2 = mutatorMutex;
                mutator2 = mutator;
                h.a(mutatorMutex2.f4028a, mutator2, null);
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
