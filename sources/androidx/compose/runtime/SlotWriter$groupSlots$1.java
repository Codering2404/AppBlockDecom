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
public final class SlotWriter$groupSlots$1 implements Iterator<Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SlotWriter f24225c;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24223a < this.f24224b;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            return null;
        }
        Object[] objArr = this.f24225c.f24201c;
        SlotWriter slotWriter = this.f24225c;
        int i3 = this.f24223a;
        this.f24223a = i3 + 1;
        return objArr[slotWriter.R(i3)];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
