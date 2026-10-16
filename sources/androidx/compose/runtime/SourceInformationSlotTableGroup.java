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
final class SourceInformationSlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f24296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GroupSourceInformation f24298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SourceInformationGroupPath f24299d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f24300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Iterable f24301g = this;

    public SourceInformationSlotTableGroup(SlotTable slotTable, int i3, GroupSourceInformation groupSourceInformation, SourceInformationGroupPath sourceInformationGroupPath) {
        this.f24296a = slotTable;
        this.f24297b = i3;
        this.f24298c = groupSourceInformation;
        this.f24299d = sourceInformationGroupPath;
        this.f24300f = Integer.valueOf(groupSourceInformation.f());
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String a() {
        return this.f24298c.g();
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable b() {
        return this.f24301g;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object d() {
        return this.f24299d.a(this.f24296a);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable getData() {
        return new SourceInformationGroupDataIterator(this.f24296a, this.f24297b, this.f24298c);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        return this.f24300f;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new SourceInformationGroupIterator(this.f24296a, this.f24297b, this.f24298c, this.f24299d);
    }
}
