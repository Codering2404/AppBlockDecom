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
public final class IntRange extends IntProgression implements ClosedRange<Integer>, OpenEndRange<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140218f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final IntRange f140219g = new IntRange(1, 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange a() {
            return IntRange.f140219g;
        }

        private Companion() {
        }
    }

    public IntRange(int i3, int i4) {
        super(i3, i4, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return p(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object obj) {
        if (!(obj instanceof IntRange)) {
            return false;
        }
        if (isEmpty() && ((IntRange) obj).isEmpty()) {
            return true;
        }
        IntRange intRange = (IntRange) obj;
        return g() == intRange.g() && h() == intRange.h();
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // kotlin.ranges.IntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return g() > h();
    }

    public boolean p(int i3) {
        return g() <= i3 && i3 <= h();
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer f() {
        if (h() != Integer.MAX_VALUE) {
            return Integer.valueOf(h() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer e() {
        return Integer.valueOf(h());
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer a() {
        return Integer.valueOf(g());
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        return g() + FacebookContentProvider.INVALID_FILE_NAME + h();
    }
}
