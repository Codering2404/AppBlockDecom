package androidx.compose.material3.carousel;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Keyline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f21711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f21712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f21713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f21714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f21715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f21716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f21717g;

    public Keyline(float f3, float f4, float f5, boolean z2, boolean z3, boolean z4, float f6) {
        this.f21711a = f3;
        this.f21712b = f4;
        this.f21713c = f5;
        this.f21714d = z2;
        this.f21715e = z3;
        this.f21716f = z4;
        this.f21717g = f6;
    }

    public static /* synthetic */ Keyline b(Keyline keyline, float f3, float f4, float f5, boolean z2, boolean z3, boolean z4, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = keyline.f21711a;
        }
        if ((i3 & 2) != 0) {
            f4 = keyline.f21712b;
        }
        if ((i3 & 4) != 0) {
            f5 = keyline.f21713c;
        }
        if ((i3 & 8) != 0) {
            z2 = keyline.f21714d;
        }
        if ((i3 & 16) != 0) {
            z3 = keyline.f21715e;
        }
        if ((i3 & 32) != 0) {
            z4 = keyline.f21716f;
        }
        if ((i3 & 64) != 0) {
            f6 = keyline.f21717g;
        }
        boolean z5 = z4;
        float f7 = f6;
        boolean z6 = z3;
        float f8 = f5;
        return keyline.a(f3, f4, f8, z2, z6, z5, f7);
    }

    public final Keyline a(float f3, float f4, float f5, boolean z2, boolean z3, boolean z4, float f6) {
        return new Keyline(f3, f4, f5, z2, z3, z4, f6);
    }

    public final float c() {
        return this.f21717g;
    }

    public final float d() {
        return this.f21712b;
    }

    public final float e() {
        return this.f21711a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Keyline)) {
            return false;
        }
        Keyline keyline = (Keyline) obj;
        return Float.compare(this.f21711a, keyline.f21711a) == 0 && Float.compare(this.f21712b, keyline.f21712b) == 0 && Float.compare(this.f21713c, keyline.f21713c) == 0 && this.f21714d == keyline.f21714d && this.f21715e == keyline.f21715e && this.f21716f == keyline.f21716f && Float.compare(this.f21717g, keyline.f21717g) == 0;
    }

    public final float f() {
        return this.f21713c;
    }

    public final boolean g() {
        return this.f21715e;
    }

    public final boolean h() {
        return this.f21714d;
    }

    public int hashCode() {
        return (((((((((((Float.hashCode(this.f21711a) * 31) + Float.hashCode(this.f21712b)) * 31) + Float.hashCode(this.f21713c)) * 31) + Boolean.hashCode(this.f21714d)) * 31) + Boolean.hashCode(this.f21715e)) * 31) + Boolean.hashCode(this.f21716f)) * 31) + Float.hashCode(this.f21717g);
    }

    public final boolean i() {
        return this.f21716f;
    }

    public String toString() {
        return "Keyline(size=" + this.f21711a + ", offset=" + this.f21712b + ", unadjustedOffset=" + this.f21713c + ", isFocal=" + this.f21714d + ", isAnchor=" + this.f21715e + ", isPivot=" + this.f21716f + ", cutoff=" + this.f21717g + ')';
    }
}
