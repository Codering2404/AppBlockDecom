package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

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
final class ArrayBooleanIterator extends BooleanIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean[] f140102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140103b;

    public ArrayBooleanIterator(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f140102a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140103b < this.f140102a.length;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f140102a;
            int i3 = this.f140103b;
            this.f140103b = i3 + 1;
            return zArr[i3];
        } catch (ArrayIndexOutOfBoundsException e3) {
            this.f140103b--;
            throw new NoSuchElementException(e3.getMessage());
        }
    }
}
