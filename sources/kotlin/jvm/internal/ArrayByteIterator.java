package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

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
final class ArrayByteIterator extends ByteIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f140104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140105b;

    public ArrayByteIterator(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f140104a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140105b < this.f140104a.length;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        try {
            byte[] bArr = this.f140104a;
            int i3 = this.f140105b;
            this.f140105b = i3 + 1;
            return bArr[i3];
        } catch (ArrayIndexOutOfBoundsException e3) {
            this.f140105b--;
            throw new NoSuchElementException(e3.getMessage());
        }
    }
}
