package kotlin.ranges;

import java.util.NoSuchElementException;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class IntProgressionIterator extends IntIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140217d;

    public IntProgressionIterator(int i3, int i4, int i5) {
        this.f140214a = i5;
        this.f140215b = i4;
        boolean z2 = false;
        if (i5 <= 0 ? i3 >= i4 : i3 <= i4) {
            z2 = true;
        }
        this.f140216c = z2;
        this.f140217d = z2 ? i3 : i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140216c;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i3 = this.f140217d;
        if (i3 != this.f140215b) {
            this.f140217d = this.f140214a + i3;
            return i3;
        }
        if (!this.f140216c) {
            throw new NoSuchElementException();
        }
        this.f140216c = false;
        return i3;
    }
}
