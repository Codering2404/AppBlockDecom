package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;

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
public final class TrieNodeMutableEntriesIterator<K, V> extends TrieNodeBaseIterator<K, V, Map.Entry<K, V>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashMapBuilderEntriesIterator f140776d;

    public TrieNodeMutableEntriesIterator(PersistentHashMapBuilderEntriesIterator parentIterator) {
        Intrinsics.checkNotNullParameter(parentIterator, "parentIterator");
        this.f140776d = parentIterator;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        CommonFunctionsKt.a(e());
        k(d() + 2);
        return new MutableMapEntry(this.f140776d, c()[d() - 2], c()[d() - 1]);
    }
}
