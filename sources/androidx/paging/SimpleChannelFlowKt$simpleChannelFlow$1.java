package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1", f = "SimpleChannelFlow.kt", l = {49}, m = "invokeSuspend")
final class SimpleChannelFlowKt$simpleChannelFlow$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f50636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f50637c;

    /* JADX INFO: renamed from: androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1", f = "SimpleChannelFlow.kt", l = {67, 68}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f50638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f50639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f50640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f50641d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function2 f50642f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowCollector flowCollector, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f50641d = flowCollector;
            this.f50642f = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50641d, this.f50642f, continuation);
            anonymousClass1.f50640c = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
        
            if (r6.emit(r13, r12) == r0) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007b -> B:7:0x001a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r12.f50639b
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L31
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r12.f50638a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r12.f50640c
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                kotlin.ResultKt.b(r13)
            L1a:
                r13 = r1
                r1 = r5
                goto L52
            L1d:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L25:
                java.lang.Object r1 = r12.f50638a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r12.f50640c
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                kotlin.ResultKt.b(r13)
                goto L63
            L31:
                kotlin.ResultKt.b(r13)
                java.lang.Object r13 = r12.f50640c
                r5 = r13
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                r13 = 0
                r1 = 6
                kotlinx.coroutines.channels.Channel r13 = kotlinx.coroutines.channels.ChannelKt.b(r13, r4, r4, r1, r4)
                androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1 r8 = new androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1
                kotlin.jvm.functions.Function2 r1 = r12.f50642f
                r8.<init>(r13, r1, r4)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.d(r5, r6, r7, r8, r9, r10)
                kotlinx.coroutines.channels.ChannelIterator r13 = r13.iterator()
            L52:
                r12.f50640c = r1
                r12.f50638a = r13
                r12.f50639b = r3
                java.lang.Object r5 = r13.a(r12)
                if (r5 != r0) goto L5f
                goto L7d
            L5f:
                r11 = r1
                r1 = r13
                r13 = r5
                r5 = r11
            L63:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto L7e
                java.lang.Object r13 = r1.next()
                kotlinx.coroutines.flow.FlowCollector r6 = r12.f50641d
                r12.f50640c = r5
                r12.f50638a = r1
                r12.f50639b = r2
                java.lang.Object r13 = r6.emit(r13, r12)
                if (r13 != r0) goto L1a
            L7d:
                return r0
            L7e:
                kotlinx.coroutines.Job.DefaultImpls.b(r5, r4, r3, r4)
                kotlin.Unit r13 = kotlin.Unit.f139807a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleChannelFlowKt$simpleChannelFlow$1(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f50637c = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SimpleChannelFlowKt$simpleChannelFlow$1 simpleChannelFlowKt$simpleChannelFlow$1 = new SimpleChannelFlowKt$simpleChannelFlow$1(this.f50637c, continuation);
        simpleChannelFlowKt$simpleChannelFlow$1.f50636b = obj;
        return simpleChannelFlowKt$simpleChannelFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50635a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((FlowCollector) this.f50636b, this.f50637c, null);
            this.f50635a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((SimpleChannelFlowKt$simpleChannelFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
