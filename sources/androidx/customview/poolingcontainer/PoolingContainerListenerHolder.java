package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
final class PoolingContainerListenerHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f35457a = new ArrayList();

    public final void a(PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f35457a.add(listener);
    }

    public final void b() {
        for (int lastIndex = CollectionsKt.getLastIndex(this.f35457a); -1 < lastIndex; lastIndex--) {
            ((PoolingContainerListener) this.f35457a.get(lastIndex)).b();
        }
    }

    public final void c(PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f35457a.remove(listener);
    }
}
