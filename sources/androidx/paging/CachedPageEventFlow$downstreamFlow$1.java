package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1", f = "CachedPageEventFlow.kt", l = {102}, m = "invokeSuspend")
final class CachedPageEventFlow$downstreamFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super PageEvent<T>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CachedPageEventFlow f49594c;

    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$1", f = "CachedPageEventFlow.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<IndexedValue<? extends PageEvent<T>>, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f49595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49596b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f49596b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(IndexedValue indexedValue, Continuation continuation) {
            return ((AnonymousClass1) create(indexedValue, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f49595a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(((IndexedValue) this.f49596b) != null);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f49597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FlowCollector f49598b;

        AnonymousClass2(Ref.IntRef intRef, FlowCollector flowCollector) {
            this.f49597a = intRef;
            this.f49598b = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.collections.IndexedValue r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof androidx.paging.CachedPageEventFlow$downstreamFlow$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                androidx.paging.CachedPageEventFlow$downstreamFlow$1$2$emit$1 r0 = (androidx.paging.CachedPageEventFlow$downstreamFlow$1$2$emit$1) r0
                int r1 = r0.f49603f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49603f = r1
                goto L18
            L13:
                androidx.paging.CachedPageEventFlow$downstreamFlow$1$2$emit$1 r0 = new androidx.paging.CachedPageEventFlow$downstreamFlow$1$2$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f49601c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49603f
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r5 = r0.f49600b
                kotlin.collections.IndexedValue r5 = (kotlin.collections.IndexedValue) r5
                java.lang.Object r0 = r0.f49599a
                androidx.paging.CachedPageEventFlow$downstreamFlow$1$2 r0 = (androidx.paging.CachedPageEventFlow$downstreamFlow$1.AnonymousClass2) r0
                kotlin.ResultKt.b(r6)
                goto L5d
            L31:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L39:
                kotlin.ResultKt.b(r6)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                int r6 = r5.getIndex()
                kotlin.jvm.internal.Ref$IntRef r2 = r4.f49597a
                int r2 = r2.f140142a
                if (r6 <= r2) goto L65
                kotlinx.coroutines.flow.FlowCollector r6 = r4.f49598b
                java.lang.Object r2 = r5.getValue()
                r0.f49599a = r4
                r0.f49600b = r5
                r0.f49603f = r3
                java.lang.Object r6 = r6.emit(r2, r0)
                if (r6 != r1) goto L5c
                return r1
            L5c:
                r0 = r4
            L5d:
                kotlin.jvm.internal.Ref$IntRef r6 = r0.f49597a
                int r5 = r5.getIndex()
                r6.f140142a = r5
            L65:
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$downstreamFlow$1.AnonymousClass2.emit(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$downstreamFlow$1(CachedPageEventFlow cachedPageEventFlow, Continuation continuation) {
        super(2, continuation);
        this.f49594c = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CachedPageEventFlow$downstreamFlow$1 cachedPageEventFlow$downstreamFlow$1 = new CachedPageEventFlow$downstreamFlow$1(this.f49594c, continuation);
        cachedPageEventFlow$downstreamFlow$1.f49593b = obj;
        return cachedPageEventFlow$downstreamFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49592a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f49593b;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.f140142a = Integer.MIN_VALUE;
            Flow flowJ0 = FlowKt.j0(this.f49594c.f49589c, new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(intRef, flowCollector);
            this.f49592a = 1;
            if (flowJ0.collect(anonymousClass2, this) == objF) {
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
        return ((CachedPageEventFlow$downstreamFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
