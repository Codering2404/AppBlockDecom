package androidx.paging;

import androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1", f = "FlowExt.kt", l = {148, 151}, m = "emit")
final class FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    /* synthetic */ Object f49753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FlowExtKt$combineWithoutBatching$2$1$1.AnonymousClass1 f49754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f49755c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1(FlowExtKt$combineWithoutBatching$2$1$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f49754b = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49753a = obj;
        this.f49755c |= Integer.MIN_VALUE;
        return this.f49754b.emit(null, this);
    }
}
