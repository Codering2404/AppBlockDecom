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
public final class NavigationItemColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f18712g;

    public /* synthetic */ NavigationItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9);
    }

    public final long a() {
        return this.f18708c;
    }

    public final long b(boolean z2, boolean z3) {
        return !z3 ? this.f18711f : z2 ? this.f18706a : this.f18709d;
    }

    public final long c(boolean z2, boolean z3) {
        return !z3 ? this.f18712g : z2 ? this.f18707b : this.f18710e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationItemColors)) {
            return false;
        }
        NavigationItemColors navigationItemColors = (NavigationItemColors) obj;
        return Color.t(this.f18706a, navigationItemColors.f18706a) && Color.t(this.f18709d, navigationItemColors.f18709d) && Color.t(this.f18707b, navigationItemColors.f18707b) && Color.t(this.f18710e, navigationItemColors.f18710e) && Color.t(this.f18708c, navigationItemColors.f18708c) && Color.t(this.f18711f, navigationItemColors.f18711f) && Color.t(this.f18712g, navigationItemColors.f18712g);
    }

    public int hashCode() {
        return (((((((((((Color.z(this.f18706a) * 31) + Color.z(this.f18709d)) * 31) + Color.z(this.f18707b)) * 31) + Color.z(this.f18710e)) * 31) + Color.z(this.f18708c)) * 31) + Color.z(this.f18711f)) * 31) + Color.z(this.f18712g);
    }

    private NavigationItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.f18706a = j3;
        this.f18707b = j4;
        this.f18708c = j5;
        this.f18709d = j6;
        this.f18710e = j7;
        this.f18711f = j8;
        this.f18712g = j9;
    }
}
