package kotlin.ranges;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.UInt;
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
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final UIntRange f140243g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f140242f = new Companion(defaultConstructorMarker);
        f140243g = new UIntRange(-1, 0, defaultConstructorMarker);
    }

    public /* synthetic */ UIntRange(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable a() {
        return UInt.a(p());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return l(((UInt) comparable).f());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable e() {
        return UInt.a(o());
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object obj) {
        if (!(obj instanceof UIntRange)) {
            return false;
        }
        if (isEmpty() && ((UIntRange) obj).isEmpty()) {
            return true;
        }
        UIntRange uIntRange = (UIntRange) obj;
        return g() == uIntRange.g() && h() == uIntRange.h();
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable f() {
        return UInt.a(n());
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Integer.compareUnsigned(g(), h()) > 0;
    }

    public boolean l(int i3) {
        return Integer.compareUnsigned(g(), i3) <= 0 && Integer.compareUnsigned(i3, h()) <= 0;
    }

    public int o() {
        return h();
    }

    public int p() {
        return g();
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return ((Object) UInt.e(g())) + FacebookContentProvider.INVALID_FILE_NAME + ((Object) UInt.e(h()));
    }

    private UIntRange(int i3, int i4) {
        super(i3, i4, 1, null);
    }

    public int n() {
        if (h() != -1) {
            return UInt.b(h() + 1);
        }
        throw new IllegalStateException(bfIdKSjLOVjG.uUgKVzFJ);
    }
}
