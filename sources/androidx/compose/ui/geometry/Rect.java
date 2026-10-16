package androidx.compose.ui.geometry;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Rect {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f25601e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Rect f25602f = new Rect(0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f25603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f25604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f25606d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Rect a() {
            return Rect.f25602f;
        }

        private Companion() {
        }
    }

    public Rect(float f3, float f4, float f5, float f6) {
        this.f25603a = f3;
        this.f25604b = f4;
        this.f25605c = f5;
        this.f25606d = f6;
    }

    public static /* synthetic */ Rect h(Rect rect, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = rect.f25603a;
        }
        if ((i3 & 2) != 0) {
            f4 = rect.f25604b;
        }
        if ((i3 & 4) != 0) {
            f5 = rect.f25605c;
        }
        if ((i3 & 8) != 0) {
            f6 = rect.f25606d;
        }
        return rect.g(f3, f4, f5, f6);
    }

    public final Rect A(float f3, float f4) {
        return new Rect(this.f25603a + f3, this.f25604b + f4, this.f25605c + f3, this.f25606d + f4);
    }

    public final Rect B(long j3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        return new Rect(this.f25603a + Float.intBitsToFloat(i3), this.f25604b + Float.intBitsToFloat(i4), this.f25605c + Float.intBitsToFloat(i3), this.f25606d + Float.intBitsToFloat(i4));
    }

    public final float b() {
        return this.f25603a;
    }

    public final float c() {
        return this.f25604b;
    }

    public final float d() {
        return this.f25605c;
    }

    public final float e() {
        return this.f25606d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return Float.compare(this.f25603a, rect.f25603a) == 0 && Float.compare(this.f25604b, rect.f25604b) == 0 && Float.compare(this.f25605c, rect.f25605c) == 0 && Float.compare(this.f25606d, rect.f25606d) == 0;
    }

    public final boolean f(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return (fIntBitsToFloat >= this.f25603a) & (fIntBitsToFloat < this.f25605c) & (fIntBitsToFloat2 >= this.f25604b) & (fIntBitsToFloat2 < this.f25606d);
    }

    public final Rect g(float f3, float f4, float f5, float f6) {
        return new Rect(f3, f4, f5, f6);
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f25603a) * 31) + Float.hashCode(this.f25604b)) * 31) + Float.hashCode(this.f25605c)) * 31) + Float.hashCode(this.f25606d);
    }

    public final float i() {
        return this.f25606d;
    }

    public final long j() {
        float fP = this.f25603a + ((p() - o()) / 2.0f);
        return Offset.e((((long) Float.floatToRawIntBits(this.f25606d)) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32));
    }

    public final long k() {
        float f3 = this.f25603a;
        return Offset.e((((long) Float.floatToRawIntBits(this.f25606d)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
    }

    public final long l() {
        float f3 = this.f25605c;
        return Offset.e((((long) Float.floatToRawIntBits(this.f25606d)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
    }

    public final long m() {
        float fP = this.f25603a + ((p() - o()) / 2.0f);
        return Offset.e((((long) Float.floatToRawIntBits(this.f25604b + ((i() - r()) / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32));
    }

    public final float n() {
        return i() - r();
    }

    public final float o() {
        return this.f25603a;
    }

    public final float p() {
        return this.f25605c;
    }

    public final long q() {
        float fP = p() - o();
        return Size.d((((long) Float.floatToRawIntBits(i() - r())) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32));
    }

    public final float r() {
        return this.f25604b;
    }

    public final long s() {
        float fP = this.f25603a + ((p() - o()) / 2.0f);
        return Offset.e((((long) Float.floatToRawIntBits(this.f25604b)) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32));
    }

    public final long t() {
        float f3 = this.f25603a;
        return Offset.e((((long) Float.floatToRawIntBits(this.f25604b)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
    }

    public String toString() {
        return "Rect.fromLTRB(" + GeometryUtilsKt.a(this.f25603a, 1) + ", " + GeometryUtilsKt.a(this.f25604b, 1) + ", " + GeometryUtilsKt.a(this.f25605c, 1) + ", " + GeometryUtilsKt.a(this.f25606d, 1) + ')';
    }

    public final long u() {
        float f3 = this.f25605c;
        return Offset.e((((long) Float.floatToRawIntBits(this.f25604b)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
    }

    public final float v() {
        return p() - o();
    }

    public final Rect w(float f3, float f4, float f5, float f6) {
        return new Rect(Math.max(this.f25603a, f3), Math.max(this.f25604b, f4), Math.min(this.f25605c, f5), Math.min(this.f25606d, f6));
    }

    public final Rect x(Rect rect) {
        return new Rect(Math.max(this.f25603a, rect.f25603a), Math.max(this.f25604b, rect.f25604b), Math.min(this.f25605c, rect.f25605c), Math.min(this.f25606d, rect.f25606d));
    }

    public final boolean y() {
        return (this.f25603a >= this.f25605c) | (this.f25604b >= this.f25606d);
    }

    public final boolean z(Rect rect) {
        return (this.f25603a < rect.f25605c) & (rect.f25603a < this.f25605c) & (this.f25604b < rect.f25606d) & (rect.f25604b < this.f25606d);
    }
}
