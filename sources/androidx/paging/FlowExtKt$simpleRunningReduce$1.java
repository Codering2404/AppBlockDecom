package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
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
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", l = {68}, m = "invokeSuspend")
final class FlowExtKt$simpleRunningReduce$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f49773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f49774d;

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f49775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f49776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowCollector f49777c;

        AnonymousClass1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
            this.f49775a = objectRef;
            this.f49776b = function3;
            this.f49777c = flowCollector;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        
            if (r8.emit(r9, r0) != r1) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = (androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1) r0
                int r1 = r0.f49782f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49782f = r1
                goto L18
            L13:
                androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = new androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f49780c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49782f
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r9)
                goto L7f
            L2c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L34:
                java.lang.Object r8 = r0.f49779b
                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
                java.lang.Object r2 = r0.f49778a
                androidx.paging.FlowExtKt$simpleRunningReduce$1$1 r2 = (androidx.paging.FlowExtKt$simpleRunningReduce$1.AnonymousClass1) r2
                kotlin.ResultKt.b(r9)
                goto L66
            L40:
                kotlin.ResultKt.b(r9)
                kotlin.jvm.internal.Ref$ObjectRef r9 = r7.f49775a
                java.lang.Object r2 = r9.f140144a
                java.lang.Object r5 = androidx.paging.FlowExtKt.a()
                if (r2 != r5) goto L4f
                r2 = r7
                goto L69
            L4f:
                kotlin.jvm.functions.Function3 r2 = r7.f49776b
                kotlin.jvm.internal.Ref$ObjectRef r5 = r7.f49775a
                java.lang.Object r5 = r5.f140144a
                r0.f49778a = r7
                r0.f49779b = r9
                r0.f49782f = r4
                java.lang.Object r8 = r2.invoke(r5, r8, r0)
                if (r8 != r1) goto L62
                goto L7e
            L62:
                r2 = r9
                r9 = r8
                r8 = r2
                r2 = r7
            L66:
                r6 = r9
                r9 = r8
                r8 = r6
            L69:
                r9.f140144a = r8
                kotlinx.coroutines.flow.FlowCollector r8 = r2.f49777c
                kotlin.jvm.internal.Ref$ObjectRef r9 = r2.f49775a
                java.lang.Object r9 = r9.f140144a
                r2 = 0
                r0.f49778a = r2
                r0.f49779b = r2
                r0.f49782f = r3
                java.lang.Object r8 = r8.emit(r9, r0)
                if (r8 != r1) goto L7f
            L7e:
                return r1
            L7f:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$simpleRunningReduce$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$simpleRunningReduce$1(Flow flow, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f49773c = flow;
        this.f49774d = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$simpleRunningReduce$1 flowExtKt$simpleRunningReduce$1 = new FlowExtKt$simpleRunningReduce$1(this.f49773c, this.f49774d, continuation);
        flowExtKt$simpleRunningReduce$1.f49772b = obj;
        return flowExtKt$simpleRunningReduce$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49771a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f49772b;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f140144a = FlowExtKt.f49739a;
            Flow flow = this.f49773c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, this.f49774d, flowCollector);
            this.f49771a = 1;
            if (flow.collect(anonymousClass1, this) == objF) {
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
        return ((FlowExtKt$simpleRunningReduce$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
