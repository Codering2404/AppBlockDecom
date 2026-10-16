package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

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
final class SharingConfig<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow f142206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f142207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferOverflow f142208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineContext f142209d;

    public SharingConfig(Flow flow, int i3, BufferOverflow bufferOverflow, CoroutineContext coroutineContext) {
        this.f142206a = flow;
        this.f142207b = i3;
        this.f142208c = bufferOverflow;
        this.f142209d = coroutineContext;
    }
}
