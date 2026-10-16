package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
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
final class SourceInformationGroupIterator implements Iterator<CompositionGroup>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f24290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GroupSourceInformation f24292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SourceInformationGroupPath f24293d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24295g;

    public SourceInformationGroupIterator(SlotTable slotTable, int i3, GroupSourceInformation groupSourceInformation, SourceInformationGroupPath sourceInformationGroupPath) {
        this.f24290a = slotTable;
        this.f24291b = i3;
        this.f24292c = groupSourceInformation;
        this.f24293d = sourceInformationGroupPath;
        this.f24294f = slotTable.x();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompositionGroup next() {
        Object obj;
        ArrayList arrayListE = this.f24292c.e();
        if (arrayListE != null) {
            int i3 = this.f24295g;
            this.f24295g = i3 + 1;
            obj = arrayListE.get(i3);
        } else {
            obj = null;
        }
        if (obj instanceof Anchor) {
            return new SlotTableGroup(this.f24290a, ((Anchor) obj).a(), this.f24294f);
        }
        if (obj instanceof GroupSourceInformation) {
            return new SourceInformationSlotTableGroup(this.f24290a, this.f24291b, (GroupSourceInformation) obj, new RelativeGroupPath(this.f24293d, this.f24295g - 1));
        }
        ComposerKt.u("Unexpected group information structure");
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        ArrayList arrayListE = this.f24292c.e();
        return arrayListE != null && this.f24295g < arrayListE.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
