package androidx.compose.runtime;

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
final class DataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f23850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23853d;

    public DataIterator(SlotTable slotTable, int i3) {
        this.f23850a = slotTable;
        int i4 = slotTable.s()[(i3 * 5) + 4];
        this.f23851b = i4;
        int i5 = i3 + 1;
        this.f23852c = i5 < slotTable.t() ? slotTable.s()[(i5 * 5) + 4] : slotTable.v();
        this.f23853d = i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23853d < this.f23852c;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i3 = this.f23853d;
        Object obj = (i3 < 0 || i3 >= this.f23850a.u().length) ? null : this.f23850a.u()[this.f23853d];
        this.f23853d++;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this;
    }
}
