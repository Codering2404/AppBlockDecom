package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f24193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24195c;

    public SlotTableGroup(SlotTable slotTable, int i3, int i4) {
        this.f24193a = slotTable;
        this.f24194b = i3;
        this.f24195c = i4;
    }

    private final void e() {
        if (this.f24193a.x() != this.f24195c) {
            SlotTableKt.v();
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String a() {
        int[] iArrS = this.f24193a.s();
        int i3 = this.f24194b;
        if ((iArrS[(i3 * 5) + 1] & 268435456) != 0) {
            Object obj = this.f24193a.u()[SlotTableKt.n(this.f24193a.s(), this.f24194b)];
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        GroupSourceInformation groupSourceInformationH = this.f24193a.H(i3);
        if (groupSourceInformationH != null) {
            return groupSourceInformationH.g();
        }
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object d() {
        e();
        SlotReader slotReaderB = this.f24193a.B();
        try {
            return slotReaderB.a(this.f24194b);
        } finally {
            slotReaderB.d();
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable getData() {
        GroupSourceInformation groupSourceInformationH = this.f24193a.H(this.f24194b);
        return groupSourceInformationH != null ? new SourceInformationGroupDataIterator(this.f24193a, this.f24194b, groupSourceInformationH) : new DataIterator(this.f24193a, this.f24194b);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        if ((this.f24193a.s()[(this.f24194b * 5) + 1] & 536870912) == 0) {
            return Integer.valueOf(this.f24193a.s()[this.f24194b * 5]);
        }
        Object obj = this.f24193a.u()[SlotTableKt.s(this.f24193a.s(), this.f24194b)];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        if ((this.f24193a.s()[(this.f24194b * 5) + 1] & 1073741824) != 0) {
            return this.f24193a.u()[this.f24193a.s()[(this.f24194b * 5) + 4]];
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        e();
        GroupSourceInformation groupSourceInformationH = this.f24193a.H(this.f24194b);
        if (groupSourceInformationH != null) {
            SlotTable slotTable = this.f24193a;
            int i3 = this.f24194b;
            return new SourceInformationGroupIterator(slotTable, i3, groupSourceInformationH, new AnchoredGroupPath(i3));
        }
        SlotTable slotTable2 = this.f24193a;
        int i4 = this.f24194b;
        return new GroupIterator(slotTable2, i4 + 1, i4 + SlotTableKt.p(slotTable2.s(), this.f24194b));
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable b() {
        return this;
    }
}
