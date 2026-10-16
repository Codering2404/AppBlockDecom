package androidx.compose.ui.unit;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class IntRect {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f29992e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final IntRect f29993f = new IntRect(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29997d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRect a() {
            return IntRect.f29993f;
        }

        private Companion() {
        }
    }

    public IntRect(int i3, int i4, int i5, int i6) {
        this.f29994a = i3;
        this.f29995b = i4;
        this.f29996c = i5;
        this.f29997d = i6;
    }

    public static /* synthetic */ IntRect c(IntRect intRect, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = intRect.f29994a;
        }
        if ((i7 & 2) != 0) {
            i4 = intRect.f29995b;
        }
        if ((i7 & 4) != 0) {
            i5 = intRect.f29996c;
        }
        if ((i7 & 8) != 0) {
            i6 = intRect.f29997d;
        }
        return intRect.b(i3, i4, i5, i6);
    }

    public final IntRect b(int i3, int i4, int i5, int i6) {
        return new IntRect(i3, i4, i5, i6);
    }

    public final int d() {
        return this.f29997d;
    }

    public final long e() {
        int iL = this.f29994a + (l() / 2);
        return IntOffset.f((((long) (this.f29995b + (f() / 2))) & 4294967295L) | (((long) iL) << 32));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) obj;
        return this.f29994a == intRect.f29994a && this.f29995b == intRect.f29995b && this.f29996c == intRect.f29996c && this.f29997d == intRect.f29997d;
    }

    public final int f() {
        return this.f29997d - this.f29995b;
    }

    public final int g() {
        return this.f29994a;
    }

    public final int h() {
        return this.f29996c;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f29994a) * 31) + Integer.hashCode(this.f29995b)) * 31) + Integer.hashCode(this.f29996c)) * 31) + Integer.hashCode(this.f29997d);
    }

    public final long i() {
        return IntSize.c((((long) f()) & 4294967295L) | (((long) l()) << 32));
    }

    public final int j() {
        return this.f29995b;
    }

    public final long k() {
        return IntOffset.f((((long) this.f29995b) & 4294967295L) | (((long) this.f29994a) << 32));
    }

    public final int l() {
        return this.f29996c - this.f29994a;
    }

    public final boolean m() {
        return this.f29994a >= this.f29996c || this.f29995b >= this.f29997d;
    }

    public final IntRect n(int i3, int i4) {
        return new IntRect(this.f29994a + i3, this.f29995b + i4, this.f29996c + i3, this.f29997d + i4);
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.f29994a + ", " + this.f29995b + ", " + this.f29996c + ", " + this.f29997d + ')';
    }
}
