package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ChipColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f16320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f16322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f16323h;

    public /* synthetic */ ChipColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10);
    }

    public final long a(boolean z2) {
        return z2 ? this.f16316a : this.f16320e;
    }

    public final long b(boolean z2) {
        return z2 ? this.f16317b : this.f16321f;
    }

    public final long c(boolean z2) {
        return z2 ? this.f16318c : this.f16322g;
    }

    public final long d(boolean z2) {
        return z2 ? this.f16319d : this.f16323h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipColors)) {
            return false;
        }
        ChipColors chipColors = (ChipColors) obj;
        return Color.t(this.f16316a, chipColors.f16316a) && Color.t(this.f16317b, chipColors.f16317b) && Color.t(this.f16318c, chipColors.f16318c) && Color.t(this.f16319d, chipColors.f16319d) && Color.t(this.f16320e, chipColors.f16320e) && Color.t(this.f16321f, chipColors.f16321f) && Color.t(this.f16322g, chipColors.f16322g) && Color.t(this.f16323h, chipColors.f16323h);
    }

    public int hashCode() {
        return (((((((((((((Color.z(this.f16316a) * 31) + Color.z(this.f16317b)) * 31) + Color.z(this.f16318c)) * 31) + Color.z(this.f16319d)) * 31) + Color.z(this.f16320e)) * 31) + Color.z(this.f16321f)) * 31) + Color.z(this.f16322g)) * 31) + Color.z(this.f16323h);
    }

    private ChipColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.f16316a = j3;
        this.f16317b = j4;
        this.f16318c = j5;
        this.f16319d = j6;
        this.f16320e = j7;
        this.f16321f = j8;
        this.f16322g = j9;
        this.f16323h = j10;
    }
}
