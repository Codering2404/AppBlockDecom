package androidx.compose.material;

import androidx.compose.animation.core.h;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.material.InternalMutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "androidx.compose.material.InternalMutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", l = {177, 138}, m = "invokeSuspend")
final class InternalMutatorMutex$mutateWith$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f13046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f13047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f13048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f13049d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f13050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f13051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutatePriority f13052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ InternalMutatorMutex f13053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function2 f13054j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Object f13055k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalMutatorMutex$mutateWith$2(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function2 function2, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f13052h = mutatePriority;
        this.f13053i = internalMutatorMutex;
        this.f13054j = function2;
        this.f13055k = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InternalMutatorMutex$mutateWith$2 internalMutatorMutex$mutateWith$2 = new InternalMutatorMutex$mutateWith$2(this.f13052h, this.f13053i, this.f13054j, this.f13055k, continuation);
        internalMutatorMutex$mutateWith$2.f13051g = obj;
        return internalMutatorMutex$mutateWith$2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        Function2 function2;
        InternalMutatorMutex.Mutator mutator;
        InternalMutatorMutex internalMutatorMutex;
        Object obj2;
        Throwable th;
        InternalMutatorMutex internalMutatorMutex2;
        InternalMutatorMutex.Mutator mutator2;
        Mutex mutex2;
        Object objF = IntrinsicsKt.f();
        ?? r12 = this.f13050f;
        try {
            try {
                if (r12 == 0) {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f13051g;
                    MutatePriority mutatePriority = this.f13052h;
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.v8);
                    Intrinsics.checkNotNull(element);
                    InternalMutatorMutex.Mutator mutator3 = new InternalMutatorMutex.Mutator(mutatePriority, (Job) element);
                    this.f13053i.f(mutator3);
                    mutex = this.f13053i.f13035b;
                    function2 = this.f13054j;
                    Object obj3 = this.f13055k;
                    InternalMutatorMutex internalMutatorMutex3 = this.f13053i;
                    this.f13051g = mutator3;
                    this.f13046a = mutex;
                    this.f13047b = function2;
                    this.f13048c = obj3;
                    this.f13049d = internalMutatorMutex3;
                    this.f13050f = 1;
                    if (mutex.f(null, this) != objF) {
                        mutator = mutator3;
                        internalMutatorMutex = internalMutatorMutex3;
                        obj2 = obj3;
                    }
                    return objF;
                }
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    internalMutatorMutex2 = (InternalMutatorMutex) this.f13047b;
                    mutex2 = (Mutex) this.f13046a;
                    mutator2 = (InternalMutatorMutex.Mutator) this.f13051g;
                    try {
                        ResultKt.b(obj);
                        h.a(internalMutatorMutex2.f13034a, mutator2, null);
                        mutex2.i(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        h.a(internalMutatorMutex2.f13034a, mutator2, null);
                        throw th;
                    }
                }
                internalMutatorMutex = (InternalMutatorMutex) this.f13049d;
                obj2 = this.f13048c;
                function2 = (Function2) this.f13047b;
                Mutex mutex3 = (Mutex) this.f13046a;
                mutator = (InternalMutatorMutex.Mutator) this.f13051g;
                ResultKt.b(obj);
                mutex = mutex3;
                this.f13051g = mutator;
                this.f13046a = mutex;
                this.f13047b = internalMutatorMutex;
                this.f13048c = null;
                this.f13049d = null;
                this.f13050f = 2;
                Object objInvoke = function2.invoke(obj2, this);
                if (objInvoke != objF) {
                    internalMutatorMutex2 = internalMutatorMutex;
                    mutex2 = mutex;
                    obj = objInvoke;
                    mutator2 = mutator;
                    h.a(internalMutatorMutex2.f13034a, mutator2, null);
                    mutex2.i(null);
                    return obj;
                }
                return objF;
            } catch (Throwable th3) {
                th = th3;
                internalMutatorMutex2 = internalMutatorMutex;
                mutator2 = mutator;
                h.a(internalMutatorMutex2.f13034a, mutator2, null);
                throw th;
            }
        } catch (Throwable th4) {
            r12.i(null);
            throw th4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InternalMutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
