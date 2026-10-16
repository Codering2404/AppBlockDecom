package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class CharRange extends CharProgression implements ClosedRange<Character>, OpenEndRange<Character> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140200f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CharRange f140201g = new CharRange(1, 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CharRange(char c3, char c4) {
        super(c3, c4, 1);
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return n(((Character) comparable).charValue());
    }

    @Override // kotlin.ranges.CharProgression
    public boolean equals(Object obj) {
        if (!(obj instanceof CharRange)) {
            return false;
        }
        if (isEmpty() && ((CharRange) obj).isEmpty()) {
            return true;
        }
        CharRange charRange = (CharRange) obj;
        return g() == charRange.g() && h() == charRange.h();
    }

    @Override // kotlin.ranges.CharProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // kotlin.ranges.CharProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Intrinsics.compare((int) g(), (int) h()) > 0;
    }

    public boolean n(char c3) {
        return Intrinsics.compare((int) g(), (int) c3) <= 0 && Intrinsics.compare((int) c3, (int) h()) <= 0;
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Character f() {
        if (h() != 65535) {
            return Character.valueOf((char) (h() + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Character e() {
        return Character.valueOf(h());
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Character a() {
        return Character.valueOf(g());
    }

    @Override // kotlin.ranges.CharProgression
    public String toString() {
        return g() + FacebookContentProvider.INVALID_FILE_NAME + h();
    }
}
