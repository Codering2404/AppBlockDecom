package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140252f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ULongRange f140253g = new ULongRange(-1, 0, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ULongRange(long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable a() {
        return ULong.a(p());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return l(((ULong) comparable).g());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable e() {
        return ULong.a(o());
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object obj) {
        if (!(obj instanceof ULongRange)) {
            return false;
        }
        if (isEmpty() && ((ULongRange) obj).isEmpty()) {
            return true;
        }
        ULongRange uLongRange = (ULongRange) obj;
        return g() == uLongRange.g() && h() == uLongRange.h();
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable f() {
        return ULong.a(n());
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.b(g() ^ ULong.b(g() >>> 32))) * 31) + ((int) ULong.b(h() ^ ULong.b(h() >>> 32)));
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Long.compareUnsigned(g(), h()) > 0;
    }

    public boolean l(long j3) {
        return Long.compareUnsigned(g(), j3) <= 0 && Long.compareUnsigned(j3, h()) <= 0;
    }

    public long n() {
        if (h() != -1) {
            return ULong.b(h() + ULong.b(((long) 1) & 4294967295L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public long o() {
        return h();
    }

    public long p() {
        return g();
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ((Object) ULong.f(g())) + FacebookContentProvider.INVALID_FILE_NAME + ((Object) ULong.f(h()));
    }

    private ULongRange(long j3, long j4) {
        super(j3, j4, 1L, null);
    }
}
