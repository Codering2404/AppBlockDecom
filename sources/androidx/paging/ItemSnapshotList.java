package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
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
public final class ItemSnapshotList<T> extends AbstractList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f49838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f49839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f49840c;

    public ItemSnapshotList(int i3, int i4, List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f49838a = i3;
        this.f49839b = i4;
        this.f49840c = items;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i3) {
        if (i3 >= 0 && i3 < this.f49838a) {
            return null;
        }
        int i4 = this.f49838a;
        if (i3 < this.f49840c.size() + i4 && i4 <= i3) {
            return this.f49840c.get(i3 - this.f49838a);
        }
        int size = this.f49838a + this.f49840c.size();
        if (i3 < size() && size <= i3) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + i3 + " in ItemSnapshotList of size " + size());
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f49838a + this.f49840c.size() + this.f49839b;
    }
}
