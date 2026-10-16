package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

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
final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f142027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function3 f142028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FlowCollector f142029c;

    FlowKt__TransformKt$runningFold$1$1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.f142027a = objectRef;
        this.f142028b = function3;
        this.f142029c = flowCollector;
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
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1) r0
            int r1 = r0.f142034f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142034f = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f142032c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142034f
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
            java.lang.Object r7 = r0.f142031b
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r2 = r0.f142030a
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1) r2
            kotlin.ResultKt.b(r8)
            goto L5a
        L40:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = r6.f142027a
            kotlin.jvm.functions.Function3 r2 = r6.f142028b
            java.lang.Object r5 = r8.f140144a
            r0.f142030a = r6
            r0.f142031b = r8
            r0.f142034f = r4
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
            kotlinx.coroutines.flow.FlowCollector r7 = r2.f142029c
            kotlin.jvm.internal.Ref$ObjectRef r8 = r2.f142027a
            java.lang.Object r8 = r8.f140144a
            r2 = 0
            r0.f142030a = r2
            r0.f142031b = r2
            r0.f142034f = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L70
        L6f:
            return r1
        L70:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
