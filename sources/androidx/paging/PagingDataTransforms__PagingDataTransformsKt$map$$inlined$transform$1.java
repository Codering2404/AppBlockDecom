package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
public final class PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1 implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Flow f50408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function2 f50409b;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowCollector f50410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f50411b;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f50412a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f50413b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f50414c;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f50412a = obj;
                this.f50413b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
            this.f50410a = flowCollector;
            this.f50411b = function2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        
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
                boolean r0 = r8 instanceof androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1 r0 = (androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f50413b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50413b = r1
                goto L18
            L13:
                androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1 r0 = new androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f50412a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50413b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3c
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r8)
                goto L5f
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f50414c
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                kotlin.ResultKt.b(r8)
                goto L53
            L3c:
                kotlin.ResultKt.b(r8)
                kotlinx.coroutines.flow.FlowCollector r8 = r6.f50410a
                androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
                kotlin.jvm.functions.Function2 r2 = r6.f50411b
                r0.f50414c = r8
                r0.f50413b = r4
                java.lang.Object r7 = r7.e(r2, r0)
                if (r7 != r1) goto L50
                goto L5e
            L50:
                r5 = r8
                r8 = r7
                r7 = r5
            L53:
                r2 = 0
                r0.f50414c = r2
                r0.f50413b = r3
                java.lang.Object r7 = r7.emit(r8, r0)
                if (r7 != r1) goto L5f
            L5e:
                return r1
            L5f:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.f50408a.collect(new AnonymousClass2(flowCollector, this.f50409b), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }
}
