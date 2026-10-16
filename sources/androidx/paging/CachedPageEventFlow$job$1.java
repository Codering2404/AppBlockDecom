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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$job$1", f = "CachedPageEventFlow.kt", l = {76}, m = "invokeSuspend")
final class CachedPageEventFlow$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Flow f49605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CachedPageEventFlow f49606c;

    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$job$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CachedPageEventFlow f49607a;

        AnonymousClass1(CachedPageEventFlow cachedPageEventFlow) {
            this.f49607a = cachedPageEventFlow;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        
            if (r7.c(r6, r0) == r1) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.collections.IndexedValue r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.CachedPageEventFlow$job$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.paging.CachedPageEventFlow$job$1$1$emit$1 r0 = (androidx.paging.CachedPageEventFlow$job$1$1$emit$1) r0
                int r1 = r0.f49612f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49612f = r1
                goto L18
            L13:
                androidx.paging.CachedPageEventFlow$job$1$1$emit$1 r0 = new androidx.paging.CachedPageEventFlow$job$1$1$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f49610c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49612f
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r7)
                goto L6b
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.f49609b
                kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
                java.lang.Object r2 = r0.f49608a
                androidx.paging.CachedPageEventFlow$job$1$1 r2 = (androidx.paging.CachedPageEventFlow$job$1.AnonymousClass1) r2
                kotlin.ResultKt.b(r7)
                goto L57
            L40:
                kotlin.ResultKt.b(r7)
                androidx.paging.CachedPageEventFlow r7 = r5.f49607a
                kotlinx.coroutines.flow.MutableSharedFlow r7 = androidx.paging.CachedPageEventFlow.b(r7)
                r0.f49608a = r5
                r0.f49609b = r6
                r0.f49612f = r4
                java.lang.Object r7 = r7.emit(r6, r0)
                if (r7 != r1) goto L56
                goto L6a
            L56:
                r2 = r5
            L57:
                androidx.paging.CachedPageEventFlow r7 = r2.f49607a
                androidx.paging.FlattenedPageController r7 = androidx.paging.CachedPageEventFlow.c(r7)
                r2 = 0
                r0.f49608a = r2
                r0.f49609b = r2
                r0.f49612f = r3
                java.lang.Object r6 = r7.c(r6, r0)
                if (r6 != r1) goto L6b
            L6a:
                return r1
            L6b:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$job$1.AnonymousClass1.emit(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$job$1(Flow flow, CachedPageEventFlow cachedPageEventFlow, Continuation continuation) {
        super(2, continuation);
        this.f49605b = flow;
        this.f49606c = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CachedPageEventFlow$job$1(this.f49605b, this.f49606c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49604a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowN0 = FlowKt.n0(this.f49605b);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f49606c);
            this.f49604a = 1;
            if (flowN0.collect(anonymousClass1, this) == objF) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CachedPageEventFlow$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
