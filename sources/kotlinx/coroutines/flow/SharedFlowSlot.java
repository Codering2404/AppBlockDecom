package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

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
public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f142199a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Continuation f142200b;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(SharedFlowImpl sharedFlowImpl) {
        if (this.f142199a >= 0) {
            return false;
        }
        this.f142199a = sharedFlowImpl.X();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Continuation[] b(SharedFlowImpl sharedFlowImpl) {
        long j3 = this.f142199a;
        this.f142199a = -1L;
        this.f142200b = null;
        return sharedFlowImpl.W(j3);
    }
}
