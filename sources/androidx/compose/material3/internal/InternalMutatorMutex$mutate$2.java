package androidx.compose.material3.internal;

import androidx.compose.animation.core.h;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.material3.internal.InternalMutatorMutex;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
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
@DebugMetadata(c = "androidx.compose.material3.internal.InternalMutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {SensibleDefaults.X_OFFSET, 103}, m = "invokeSuspend")
final class InternalMutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f22053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f22054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f22055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f22056d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f22057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutatePriority f22058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ InternalMutatorMutex f22059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f22060i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalMutatorMutex$mutate$2(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f22058g = mutatePriority;
        this.f22059h = internalMutatorMutex;
        this.f22060i = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$2 = new InternalMutatorMutex$mutate$2(this.f22058g, this.f22059h, this.f22060i, continuation);
        internalMutatorMutex$mutate$2.f22057f = obj;
        return internalMutatorMutex$mutate$2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        InternalMutatorMutex.Mutator mutator;
        InternalMutatorMutex internalMutatorMutex;
        Function1 function1;
        Throwable th;
        InternalMutatorMutex internalMutatorMutex2;
        InternalMutatorMutex.Mutator mutator2;
        Mutex mutex2;
        Object objF = IntrinsicsKt.f();
        ?? r12 = this.f22056d;
        try {
            try {
                if (r12 == 0) {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f22057f;
                    MutatePriority mutatePriority = this.f22058g;
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.v8);
                    Intrinsics.checkNotNull(element);
                    InternalMutatorMutex.Mutator mutator3 = new InternalMutatorMutex.Mutator(mutatePriority, (Job) element);
                    this.f22059h.f(mutator3);
                    mutex = this.f22059h.f22050b;
                    Function1 function12 = this.f22060i;
                    InternalMutatorMutex internalMutatorMutex3 = this.f22059h;
                    this.f22057f = mutator3;
                    this.f22053a = mutex;
                    this.f22054b = function12;
                    this.f22055c = internalMutatorMutex3;
                    this.f22056d = 1;
                    if (mutex.f(null, this) != objF) {
                        mutator = mutator3;
                        internalMutatorMutex = internalMutatorMutex3;
                        function1 = function12;
                    }
                    return objF;
                }
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    internalMutatorMutex2 = (InternalMutatorMutex) this.f22054b;
                    mutex2 = (Mutex) this.f22053a;
                    mutator2 = (InternalMutatorMutex.Mutator) this.f22057f;
                    try {
                        ResultKt.b(obj);
                        h.a(internalMutatorMutex2.f22049a, mutator2, null);
                        mutex2.i(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        h.a(internalMutatorMutex2.f22049a, mutator2, null);
                        throw th;
                    }
                }
                internalMutatorMutex = (InternalMutatorMutex) this.f22055c;
                function1 = (Function1) this.f22054b;
                Mutex mutex3 = (Mutex) this.f22053a;
                mutator = (InternalMutatorMutex.Mutator) this.f22057f;
                ResultKt.b(obj);
                mutex = mutex3;
                this.f22057f = mutator;
                this.f22053a = mutex;
                this.f22054b = internalMutatorMutex;
                this.f22055c = null;
                this.f22056d = 2;
                Object objInvoke = function1.invoke(this);
                if (objInvoke != objF) {
                    internalMutatorMutex2 = internalMutatorMutex;
                    mutex2 = mutex;
                    obj = objInvoke;
                    mutator2 = mutator;
                    h.a(internalMutatorMutex2.f22049a, mutator2, null);
                    mutex2.i(null);
                    return obj;
                }
                return objF;
            } catch (Throwable th3) {
                th = th3;
                internalMutatorMutex2 = internalMutatorMutex;
                mutator2 = mutator;
                h.a(internalMutatorMutex2.f22049a, mutator2, null);
                throw th;
            }
        } catch (Throwable th4) {
            r12.i(null);
            throw th4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InternalMutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
