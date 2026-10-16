package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
public final class CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1 implements Flow<CombinedLoadStates> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Flow f49652a;

    /* JADX INFO: renamed from: androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowCollector f49653a;

        /* JADX INFO: renamed from: androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2", f = "CombinedLoadStates.kt", l = {223}, m = "emit")
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f49654a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f49655b;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f49654a = obj;
                this.f49655b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector) {
            this.f49653a = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2$1 r0 = (androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f49655b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49655b = r1
                goto L18
            L13:
                androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2$1 r0 = new androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f49654a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49655b
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r7)
                goto L4e
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                kotlin.ResultKt.b(r7)
                kotlinx.coroutines.flow.FlowCollector r7 = r5.f49653a
                r2 = r6
                androidx.paging.CombinedLoadStates r2 = (androidx.paging.CombinedLoadStates) r2
                boolean r4 = r2.g()
                if (r4 != 0) goto L45
                boolean r2 = r2.f()
                if (r2 == 0) goto L4e
            L45:
                r0.f49655b = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L4e
                return r1
            L4e:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.f49652a.collect(new AnonymousClass2(flowCollector), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }
}
