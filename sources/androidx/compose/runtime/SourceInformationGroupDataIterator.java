package androidx.compose.runtime;

import java.util.ArrayList;
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
final class SourceInformationGroupDataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f24284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BitVector f24288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24289g;

    public SourceInformationGroupDataIterator(SlotTable slotTable, int i3, GroupSourceInformation groupSourceInformation) {
        this.f24284a = slotTable;
        int i4 = slotTable.s()[(i3 * 5) + 4];
        this.f24285b = i4;
        this.f24286c = groupSourceInformation.d();
        int iC = groupSourceInformation.c();
        if (iC <= 0) {
            int i5 = i3 + 1;
            iC = (i5 < slotTable.t() ? slotTable.s()[(i5 * 5) + 4] : slotTable.v()) - i4;
        }
        this.f24287d = iC;
        BitVector bitVector = new BitVector();
        ArrayList arrayListE = groupSourceInformation.e();
        if (arrayListE != null) {
            int size = arrayListE.size();
            for (int i6 = 0; i6 < size; i6++) {
                Object obj = arrayListE.get(i6);
                if (obj instanceof GroupSourceInformation) {
                    GroupSourceInformation groupSourceInformation2 = (GroupSourceInformation) obj;
                    bitVector.e(groupSourceInformation2.d(), groupSourceInformation2.c());
                }
            }
        }
        this.f24288f = bitVector;
        this.f24289g = bitVector.c(this.f24286c);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24289g < this.f24287d;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i3 = this.f24287d;
        int i4 = this.f24289g;
        Object obj = (i4 < 0 || i4 >= i3) ? null : this.f24284a.u()[this.f24285b + this.f24289g];
        this.f24289g = this.f24288f.c(this.f24289g + 1);
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
