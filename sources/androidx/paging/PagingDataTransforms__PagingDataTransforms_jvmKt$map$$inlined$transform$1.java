package androidx.paging;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
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
public final class PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1 implements Flow<PageEvent<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Flow f50468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Executor f50469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f50470c;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowCollector f50471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f50472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f50473c;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1$2", f = "PagingDataTransforms.jvm.kt", l = {225, 223}, m = "emit")
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f50474a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f50475b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f50476c;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f50474a = obj;
                this.f50475b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Executor executor, Function1 function1) {
            this.f50471a = flowCollector;
            this.f50472b = executor;
            this.f50473c = function1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
        
            if (r10.emit(r11, r0) == r1) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
            /*
                r9 = this;
                boolean r0 = r11 instanceof androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r11
                androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1$2$1 r0 = (androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f50475b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50475b = r1
                goto L18
            L13:
                androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1$2$1 r0 = new androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1$2$1
                r0.<init>(r11)
            L18:
                java.lang.Object r11 = r0.f50474a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50475b
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L3d
                if (r2 == r5) goto L35
                if (r2 != r4) goto L2d
                kotlin.ResultKt.b(r11)
                goto L6a
            L2d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L35:
                java.lang.Object r10 = r0.f50476c
                kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                kotlin.ResultKt.b(r11)
                goto L5f
            L3d:
                kotlin.ResultKt.b(r11)
                kotlinx.coroutines.flow.FlowCollector r11 = r9.f50471a
                androidx.paging.PageEvent r10 = (androidx.paging.PageEvent) r10
                java.util.concurrent.Executor r2 = r9.f50472b
                kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.ExecutorsKt.b(r2)
                androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$1$1 r6 = new androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$1$1
                kotlin.jvm.functions.Function1 r7 = r9.f50473c
                r6.<init>(r10, r7, r3)
                r0.f50476c = r11
                r0.f50475b = r5
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.g(r2, r6, r0)
                if (r10 != r1) goto L5c
                goto L69
            L5c:
                r8 = r11
                r11 = r10
                r10 = r8
            L5f:
                r0.f50476c = r3
                r0.f50475b = r4
                java.lang.Object r10 = r10.emit(r11, r0)
                if (r10 != r1) goto L6a
            L69:
                return r1
            L6a:
                kotlin.Unit r10 = kotlin.Unit.f139807a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$map$$inlined$transform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.f50468a.collect(new AnonymousClass2(flowCollector, this.f50469b, this.f50470c), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }
}
