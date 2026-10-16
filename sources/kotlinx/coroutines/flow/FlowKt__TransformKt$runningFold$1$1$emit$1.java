package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", l = {105, 106}, m = "emit")
final class FlowKt__TransformKt$runningFold$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f142030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f142031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f142032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FlowKt__TransformKt$runningFold$1$1 f142033d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f142034f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__TransformKt$runningFold$1$1$emit$1(FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1, Continuation continuation) {
        super(continuation);
        this.f142033d = flowKt__TransformKt$runningFold$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f142032c = obj;
        this.f142034f |= Integer.MIN_VALUE;
        return this.f142033d.emit(null, this);
    }
}
