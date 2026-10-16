package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", l = {54, 55}, m = "invokeSuspend")
final class FlowExtKt$simpleScan$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f49783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f49784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f49785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f49786d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Flow f49787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function3 f49788g;

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleScan$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f49789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f49790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowCollector f49791c;

        AnonymousClass1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
            this.f49789a = objectRef;
            this.f49790b = function3;
            this.f49791c = flowCollector;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (r7.emit(r8, r0) == r1) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof androidx.paging.FlowExtKt$simpleScan$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.paging.FlowExtKt$simpleScan$1$1$emit$1 r0 = (androidx.paging.FlowExtKt$simpleScan$1$1$emit$1) r0
                int r1 = r0.f49796f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49796f = r1
                goto L18
            L13:
                androidx.paging.FlowExtKt$simpleScan$1$1$emit$1 r0 = new androidx.paging.FlowExtKt$simpleScan$1$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f49794c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49796f
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r8)
                goto L70
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f49793b
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                java.lang.Object r2 = r0.f49792a
                androidx.paging.FlowExtKt$simpleScan$1$1 r2 = (androidx.paging.FlowExtKt$simpleScan$1.AnonymousClass1) r2
                kotlin.ResultKt.b(r8)
                goto L5a
            L40:
                kotlin.ResultKt.b(r8)
                kotlin.jvm.internal.Ref$ObjectRef r8 = r6.f49789a
                kotlin.jvm.functions.Function3 r2 = r6.f49790b
                java.lang.Object r5 = r8.f140144a
                r0.f49792a = r6
                r0.f49793b = r8
                r0.f49796f = r4
                java.lang.Object r7 = r2.invoke(r5, r7, r0)
                if (r7 != r1) goto L56
                goto L6f
            L56:
                r2 = r8
                r8 = r7
                r7 = r2
                r2 = r6
            L5a:
                r7.f140144a = r8
                kotlinx.coroutines.flow.FlowCollector r7 = r2.f49791c
                kotlin.jvm.internal.Ref$ObjectRef r8 = r2.f49789a
                java.lang.Object r8 = r8.f140144a
                r2 = 0
                r0.f49792a = r2
                r0.f49793b = r2
                r0.f49796f = r3
                java.lang.Object r7 = r7.emit(r8, r0)
                if (r7 != r1) goto L70
            L6f:
                return r1
            L70:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$simpleScan$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$simpleScan$1(Object obj, Flow flow, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f49786d = obj;
        this.f49787f = flow;
        this.f49788g = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$simpleScan$1 flowExtKt$simpleScan$1 = new FlowExtKt$simpleScan$1(this.f49786d, this.f49787f, this.f49788g, continuation);
        flowExtKt$simpleScan$1.f49785c = obj;
        return flowExtKt$simpleScan$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (r7.collect(r4, r6) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f49784b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L5b
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f49783a
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r3 = r6.f49785c
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.ResultKt.b(r7)
            goto L44
        L26:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f49785c
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            java.lang.Object r4 = r6.f49786d
            r1.f140144a = r4
            r6.f49785c = r7
            r6.f49783a = r1
            r6.f49784b = r3
            java.lang.Object r3 = r7.emit(r4, r6)
            if (r3 != r0) goto L43
            goto L5a
        L43:
            r3 = r7
        L44:
            kotlinx.coroutines.flow.Flow r7 = r6.f49787f
            androidx.paging.FlowExtKt$simpleScan$1$1 r4 = new androidx.paging.FlowExtKt$simpleScan$1$1
            kotlin.jvm.functions.Function3 r5 = r6.f49788g
            r4.<init>(r1, r5, r3)
            r1 = 0
            r6.f49785c = r1
            r6.f49783a = r1
            r6.f49784b = r2
            java.lang.Object r7 = r7.collect(r4, r6)
            if (r7 != r0) goto L5b
        L5a:
            return r0
        L5b:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$simpleScan$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((FlowExtKt$simpleScan$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
