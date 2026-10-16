package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
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
public final class LongRange extends LongProgression implements ClosedRange<Long>, OpenEndRange<Long> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140228f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final LongRange f140229g = new LongRange(1, 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LongRange(long j3, long j4) {
        super(j3, j4, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return o(((Number) comparable).longValue());
    }

    @Override // kotlin.ranges.LongProgression
    public boolean equals(Object obj) {
        if (!(obj instanceof LongRange)) {
            return false;
        }
        if (isEmpty() && ((LongRange) obj).isEmpty()) {
            return true;
        }
        LongRange longRange = (LongRange) obj;
        return g() == longRange.g() && h() == longRange.h();
    }

    @Override // kotlin.ranges.LongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (g() ^ (g() >>> 32))) + (h() ^ (h() >>> 32)));
    }

    @Override // kotlin.ranges.LongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return g() > h();
    }

    public boolean o(long j3) {
        return g() <= j3 && j3 <= h();
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Long f() {
        if (h() != Long.MAX_VALUE) {
            return Long.valueOf(h() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Long e() {
        return Long.valueOf(h());
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Long a() {
        return Long.valueOf(g());
    }

    @Override // kotlin.ranges.LongProgression
    public String toString() {
        return g() + FacebookContentProvider.INVALID_FILE_NAME + h();
    }
}
