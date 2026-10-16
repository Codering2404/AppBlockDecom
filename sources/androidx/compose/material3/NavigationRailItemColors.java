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
public final class NavigationRailItemColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f18812g;

    public /* synthetic */ NavigationRailItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9);
    }

    public final long a() {
        return this.f18808c;
    }

    public final long b(boolean z2, boolean z3) {
        return !z3 ? this.f18811f : z2 ? this.f18806a : this.f18809d;
    }

    public final long c(boolean z2, boolean z3) {
        return !z3 ? this.f18812g : z2 ? this.f18807b : this.f18810e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationRailItemColors)) {
            return false;
        }
        NavigationRailItemColors navigationRailItemColors = (NavigationRailItemColors) obj;
        return Color.t(this.f18806a, navigationRailItemColors.f18806a) && Color.t(this.f18809d, navigationRailItemColors.f18809d) && Color.t(this.f18807b, navigationRailItemColors.f18807b) && Color.t(this.f18810e, navigationRailItemColors.f18810e) && Color.t(this.f18808c, navigationRailItemColors.f18808c) && Color.t(this.f18811f, navigationRailItemColors.f18811f) && Color.t(this.f18812g, navigationRailItemColors.f18812g);
    }

    public int hashCode() {
        return (((((((((((Color.z(this.f18806a) * 31) + Color.z(this.f18809d)) * 31) + Color.z(this.f18807b)) * 31) + Color.z(this.f18810e)) * 31) + Color.z(this.f18808c)) * 31) + Color.z(this.f18811f)) * 31) + Color.z(this.f18812g);
    }

    private NavigationRailItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.f18806a = j3;
        this.f18807b = j4;
        this.f18808c = j5;
        this.f18809d = j6;
        this.f18810e = j7;
        this.f18811f = j8;
        this.f18812g = j9;
    }
}
