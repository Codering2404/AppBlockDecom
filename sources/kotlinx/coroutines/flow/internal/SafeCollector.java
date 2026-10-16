package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowCollector f142389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f142390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f142391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CoroutineContext f142392d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Continuation f142393f;

    public SafeCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.f142383a, EmptyCoroutineContext.f139889a);
        this.f142389a = flowCollector;
        this.f142390b = coroutineContext;
        this.f142391c = ((Number) coroutineContext.fold(0, new Function2() { // from class: kotlinx.coroutines.flow.internal.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(SafeCollector.y(((Integer) obj).intValue(), (CoroutineContext.Element) obj2));
            }
        })).intValue();
    }

    private final void A(DownstreamExceptionContext downstreamExceptionContext, Object obj) {
        throw new IllegalStateException(StringsKt.n("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionContext.f142377b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    private final void q(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Object obj) {
        if (coroutineContext2 instanceof DownstreamExceptionContext) {
            A((DownstreamExceptionContext) coroutineContext2, obj);
        }
        SafeCollector_commonKt.b(this, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y(int i3, CoroutineContext.Element element) {
        return i3 + 1;
    }

    private final Object z(Continuation continuation, Object obj) {
        CoroutineContext context = continuation.getContext();
        JobKt.k(context);
        CoroutineContext coroutineContext = this.f142392d;
        if (coroutineContext != context) {
            q(context, coroutineContext, obj);
            this.f142392d = context;
        }
        this.f142393f = continuation;
        Function3 function3 = SafeCollectorKt.f142394a;
        FlowCollector flowCollector = this.f142389a;
        Intrinsics.checkNotNull(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = function3.invoke(flowCollector, obj, this);
        if (!Intrinsics.areEqual(objInvoke, IntrinsicsKt.f())) {
            this.f142393f = null;
        }
        return objInvoke;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        try {
            Object objZ = z(continuation, obj);
            if (objZ == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objZ == IntrinsicsKt.f() ? objZ : Unit.f139807a;
        } catch (Throwable th) {
            this.f142392d = new DownstreamExceptionContext(th, continuation.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f142393f;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.f142392d;
        return coroutineContext == null ? EmptyCoroutineContext.f139889a : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) {
        Throwable thE = Result.e(obj);
        if (thE != null) {
            this.f142392d = new DownstreamExceptionContext(thE, getContext());
        }
        Continuation continuation = this.f142393f;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return IntrinsicsKt.f();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
