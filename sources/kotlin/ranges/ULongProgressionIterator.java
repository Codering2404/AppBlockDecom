package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
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
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f140249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f140250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f140251d;

    public /* synthetic */ ULongProgressionIterator(long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5);
    }

    public long a() {
        long j3 = this.f140251d;
        if (j3 != this.f140248a) {
            this.f140251d = ULong.b(this.f140250c + j3);
            return j3;
        }
        if (!this.f140249b) {
            throw new NoSuchElementException();
        }
        this.f140249b = false;
        return j3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140249b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ ULong next() {
        return ULong.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private ULongProgressionIterator(long j3, long j4, long j5) {
        this.f140248a = j4;
        boolean z2 = false;
        if (j5 <= 0 ? Long.compareUnsigned(j3, j4) >= 0 : Long.compareUnsigned(j3, j4) <= 0) {
            z2 = true;
        }
        this.f140249b = z2;
        this.f140250c = ULong.b(j5);
        this.f140251d = this.f140249b ? j3 : j4;
    }
}
