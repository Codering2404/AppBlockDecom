package kotlinx.serialization.descriptors;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SerialDescriptorKt$elementDescriptors$1$1 implements Iterator<SerialDescriptor>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f142745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SerialDescriptor f142746b;

    SerialDescriptorKt$elementDescriptors$1$1(SerialDescriptor serialDescriptor) {
        this.f142746b = serialDescriptor;
        this.f142745a = serialDescriptor.e();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SerialDescriptor next() {
        SerialDescriptor serialDescriptor = this.f142746b;
        int iE = serialDescriptor.e();
        int i3 = this.f142745a;
        this.f142745a = i3 - 1;
        return serialDescriptor.h(iE - i3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f142745a > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
