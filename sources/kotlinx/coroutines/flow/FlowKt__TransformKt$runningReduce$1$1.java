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
final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f142037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function3 f142038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FlowCollector f142039c;

    FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.f142037a = objectRef;
        this.f142038b = function3;
        this.f142039c = flowCollector;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
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
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1) r0
            int r1 = r0.f142044f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142044f = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f142042c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142044f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            goto L79
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.f142041b
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.f142040a
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1) r2
            kotlin.ResultKt.b(r9)
            goto L60
        L40:
            kotlin.ResultKt.b(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = r7.f142037a
            java.lang.Object r2 = r9.f140144a
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f142386a
            if (r2 != r5) goto L4d
            r2 = r7
            goto L63
        L4d:
            kotlin.jvm.functions.Function3 r5 = r7.f142038b
            r0.f142040a = r7
            r0.f142041b = r9
            r0.f142044f = r4
            java.lang.Object r8 = r5.invoke(r2, r8, r0)
            if (r8 != r1) goto L5c
            goto L78
        L5c:
            r2 = r9
            r9 = r8
            r8 = r2
            r2 = r7
        L60:
            r6 = r9
            r9 = r8
            r8 = r6
        L63:
            r9.f140144a = r8
            kotlinx.coroutines.flow.FlowCollector r8 = r2.f142039c
            kotlin.jvm.internal.Ref$ObjectRef r9 = r2.f142037a
            java.lang.Object r9 = r9.f140144a
            r2 = 0
            r0.f142040a = r2
            r0.f142041b = r2
            r0.f142044f = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L79
        L78:
            return r1
        L79:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
