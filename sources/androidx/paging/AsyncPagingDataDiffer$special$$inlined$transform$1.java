package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1", f = "AsyncPagingDataDiffer.kt", l = {40}, m = "invokeSuspend")
public final class AsyncPagingDataDiffer$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super CombinedLoadStates>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f49573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AsyncPagingDataDiffer f49574d;

    /* JADX INFO: renamed from: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowCollector f49575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AsyncPagingDataDiffer f49576b;

        /* JADX INFO: renamed from: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1", f = "AsyncPagingDataDiffer.kt", l = {224, 225, 229}, m = "emit")
        public static final class C00781 extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f49577a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f49578b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f49580d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f49581f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f49582g;

            public C00781(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f49577a = obj;
                this.f49578b |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, AsyncPagingDataDiffer asyncPagingDataDiffer) {
            this.f49576b = asyncPagingDataDiffer;
            this.f49575a = flowCollector;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.G(r9, r5, r0) == r1) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        
            if (r9.emit(r8, r0) != r1) goto L31;
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
                boolean r0 = r9 instanceof androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1.C00781
                if (r0 == 0) goto L13
                r0 = r9
                androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1 r0 = (androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1.C00781) r0
                int r1 = r0.f49578b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49578b = r1
                goto L18
            L13:
                androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1 r0 = new androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f49577a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49578b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L55
                if (r2 == r5) goto L45
                if (r2 == r4) goto L39
                if (r2 != r3) goto L31
                kotlin.ResultKt.b(r9)
                goto La9
            L31:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L39:
                java.lang.Object r8 = r0.f49581f
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                java.lang.Object r2 = r0.f49580d
                androidx.paging.CombinedLoadStates r2 = (androidx.paging.CombinedLoadStates) r2
                kotlin.ResultKt.b(r9)
                goto L9a
            L45:
                java.lang.Object r8 = r0.f49582g
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                java.lang.Object r2 = r0.f49581f
                androidx.paging.CombinedLoadStates r2 = (androidx.paging.CombinedLoadStates) r2
                java.lang.Object r5 = r0.f49580d
                androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1 r5 = (androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1) r5
                kotlin.ResultKt.b(r9)
                goto L80
            L55:
                kotlin.ResultKt.b(r9)
                kotlinx.coroutines.flow.FlowCollector r9 = r7.f49575a
                androidx.paging.CombinedLoadStates r8 = (androidx.paging.CombinedLoadStates) r8
                androidx.paging.AsyncPagingDataDiffer r2 = r7.f49576b
                kotlinx.coroutines.flow.MutableStateFlow r2 = r2.k()
                java.lang.Object r2 = r2.getValue()
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L9c
                r0.f49580d = r7
                r0.f49581f = r8
                r0.f49582g = r9
                r0.f49578b = r5
                java.lang.Object r2 = kotlinx.coroutines.YieldKt.a(r0)
                if (r2 != r1) goto L7d
                goto La8
            L7d:
                r5 = r7
                r2 = r8
                r8 = r9
            L80:
                androidx.paging.AsyncPagingDataDiffer r9 = r5.f49576b
                kotlinx.coroutines.flow.MutableStateFlow r9 = r9.k()
                androidx.paging.AsyncPagingDataDiffer$loadStateFlow$1$1 r5 = new androidx.paging.AsyncPagingDataDiffer$loadStateFlow$1$1
                r5.<init>(r6)
                r0.f49580d = r2
                r0.f49581f = r8
                r0.f49582g = r6
                r0.f49578b = r4
                java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.G(r9, r5, r0)
                if (r9 != r1) goto L9a
                goto La8
            L9a:
                r9 = r8
                r8 = r2
            L9c:
                r0.f49580d = r6
                r0.f49581f = r6
                r0.f49578b = r3
                java.lang.Object r8 = r9.emit(r8, r0)
                if (r8 != r1) goto La9
            La8:
                return r1
            La9:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$special$$inlined$transform$1(Flow flow, Continuation continuation, AsyncPagingDataDiffer asyncPagingDataDiffer) {
        super(2, continuation);
        this.f49573c = flow;
        this.f49574d = asyncPagingDataDiffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AsyncPagingDataDiffer$special$$inlined$transform$1 asyncPagingDataDiffer$special$$inlined$transform$1 = new AsyncPagingDataDiffer$special$$inlined$transform$1(this.f49573c, continuation, this.f49574d);
        asyncPagingDataDiffer$special$$inlined$transform$1.f49572b = obj;
        return asyncPagingDataDiffer$special$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49571a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f49572b;
            Flow flow = this.f49573c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.f49574d);
            this.f49571a = 1;
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
        return ((AsyncPagingDataDiffer$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
