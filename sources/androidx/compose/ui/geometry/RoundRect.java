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
public final class RoundRect {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f25607i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final RoundRect f25608j = RoundRectKt.d(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.f25589b.a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f25609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f25610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f25612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f25613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f25614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f25615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f25616h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoundRect(float f3, float f4, float f5, float f6, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, j3, j4, j5, j6);
    }

    public final float a() {
        return this.f25612d;
    }

    public final long b() {
        return this.f25616h;
    }

    public final long c() {
        return this.f25615g;
    }

    public final float d() {
        return this.f25612d - this.f25610b;
    }

    public final float e() {
        return this.f25609a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.f25609a, roundRect.f25609a) == 0 && Float.compare(this.f25610b, roundRect.f25610b) == 0 && Float.compare(this.f25611c, roundRect.f25611c) == 0 && Float.compare(this.f25612d, roundRect.f25612d) == 0 && CornerRadius.d(this.f25613e, roundRect.f25613e) && CornerRadius.d(this.f25614f, roundRect.f25614f) && CornerRadius.d(this.f25615g, roundRect.f25615g) && CornerRadius.d(this.f25616h, roundRect.f25616h);
    }

    public final float f() {
        return this.f25611c;
    }

    public final float g() {
        return this.f25610b;
    }

    public final long h() {
        return this.f25613e;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.f25609a) * 31) + Float.hashCode(this.f25610b)) * 31) + Float.hashCode(this.f25611c)) * 31) + Float.hashCode(this.f25612d)) * 31) + CornerRadius.e(this.f25613e)) * 31) + CornerRadius.e(this.f25614f)) * 31) + CornerRadius.e(this.f25615g)) * 31) + CornerRadius.e(this.f25616h);
    }

    public final long i() {
        return this.f25614f;
    }

    public final float j() {
        return this.f25611c - this.f25609a;
    }

    public String toString() {
        long j3 = this.f25613e;
        long j4 = this.f25614f;
        long j5 = this.f25615g;
        long j6 = this.f25616h;
        String str = GeometryUtilsKt.a(this.f25609a, 1) + ", " + GeometryUtilsKt.a(this.f25610b, 1) + ", " + GeometryUtilsKt.a(this.f25611c, 1) + ", " + GeometryUtilsKt.a(this.f25612d, 1);
        if (!CornerRadius.d(j3, j4) || !CornerRadius.d(j4, j5) || !CornerRadius.d(j5, j6)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.f(j3)) + ", topRight=" + ((Object) CornerRadius.f(j4)) + ", bottomRight=" + ((Object) CornerRadius.f(j5)) + ", bottomLeft=" + ((Object) CornerRadius.f(j6)) + ')';
        }
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        if (Float.intBitsToFloat(i3) == Float.intBitsToFloat(i4)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.a(Float.intBitsToFloat(i3), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.a(Float.intBitsToFloat(i3), 1) + ", y=" + GeometryUtilsKt.a(Float.intBitsToFloat(i4), 1) + ')';
    }

    private RoundRect(float f3, float f4, float f5, float f6, long j3, long j4, long j5, long j6) {
        this.f25609a = f3;
        this.f25610b = f4;
        this.f25611c = f5;
        this.f25612d = f6;
        this.f25613e = j3;
        this.f25614f = j4;
        this.f25615g = j5;
        this.f25616h = j6;
    }
}
