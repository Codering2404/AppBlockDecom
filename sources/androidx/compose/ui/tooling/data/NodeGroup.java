package androidx.compose.ui.tooling.data;

import androidx.compose.ui.unit.IntRect;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

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
public final class NodeGroup extends Group {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f29925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f29926j;

    public NodeGroup(Object obj, Object obj2, IntRect intRect, Collection collection, List list, Collection collection2) {
        super(obj, null, null, null, intRect, collection, collection2, false, null);
        this.f29925i = obj2;
        this.f29926j = list;
    }

    @Override // androidx.compose.ui.tooling.data.Group
    public List e() {
        return this.f29926j;
    }

    public final Object g() {
        return this.f29925i;
    }
}
