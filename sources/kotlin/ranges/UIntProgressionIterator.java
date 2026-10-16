package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f140239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140241d;

    public /* synthetic */ UIntProgressionIterator(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5);
    }

    public int a() {
        int i3 = this.f140241d;
        if (i3 != this.f140238a) {
            this.f140241d = UInt.b(this.f140240c + i3);
            return i3;
        }
        if (!this.f140239b) {
            throw new NoSuchElementException();
        }
        this.f140239b = false;
        return i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140239b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private UIntProgressionIterator(int i3, int i4, int i5) {
        this.f140238a = i4;
        boolean z2 = false;
        int iCompareUnsigned = Integer.compareUnsigned(i3, i4);
        if (i5 <= 0 ? iCompareUnsigned >= 0 : iCompareUnsigned <= 0) {
            z2 = true;
        }
        this.f140239b = z2;
        this.f140240c = UInt.b(i5);
        this.f140241d = this.f140239b ? i3 : i4;
    }
}
