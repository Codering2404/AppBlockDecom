package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SparseIntArrayKt$valueIterator$1 extends IntIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseIntArray f34369b;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34368a < this.f34369b.size();
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        SparseIntArray sparseIntArray = this.f34369b;
        int i3 = this.f34368a;
        this.f34368a = i3 + 1;
        return sparseIntArray.valueAt(i3);
    }
}
