package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class GroupIterator implements Iterator<CompositionGroup>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f23890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23893d;

    public GroupIterator(SlotTable slotTable, int i3, int i4) {
        this.f23890a = slotTable;
        this.f23891b = i4;
        this.f23892c = i3;
        this.f23893d = slotTable.x();
        if (slotTable.y()) {
            SlotTableKt.v();
        }
    }

    private final void b() {
        if (this.f23890a.x() != this.f23893d) {
            SlotTableKt.v();
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompositionGroup next() {
        b();
        int i3 = this.f23892c;
        this.f23892c = SlotTableKt.p(this.f23890a.s(), i3) + i3;
        return new SlotTableGroup(this.f23890a, i3, this.f23893d);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23892c < this.f23891b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
