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
public final class NavigationBarItemColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f18411g;

    public /* synthetic */ NavigationBarItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9);
    }

    public final long a() {
        return this.f18407c;
    }

    public final long b(boolean z2, boolean z3) {
        return !z3 ? this.f18410f : z2 ? this.f18405a : this.f18408d;
    }

    public final long c(boolean z2, boolean z3) {
        return !z3 ? this.f18411g : z2 ? this.f18406b : this.f18409e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) obj;
        return Color.t(this.f18405a, navigationBarItemColors.f18405a) && Color.t(this.f18408d, navigationBarItemColors.f18408d) && Color.t(this.f18406b, navigationBarItemColors.f18406b) && Color.t(this.f18409e, navigationBarItemColors.f18409e) && Color.t(this.f18407c, navigationBarItemColors.f18407c) && Color.t(this.f18410f, navigationBarItemColors.f18410f) && Color.t(this.f18411g, navigationBarItemColors.f18411g);
    }

    public int hashCode() {
        return (((((((((((Color.z(this.f18405a) * 31) + Color.z(this.f18408d)) * 31) + Color.z(this.f18406b)) * 31) + Color.z(this.f18409e)) * 31) + Color.z(this.f18407c)) * 31) + Color.z(this.f18410f)) * 31) + Color.z(this.f18411g);
    }

    private NavigationBarItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.f18405a = j3;
        this.f18406b = j4;
        this.f18407c = j5;
        this.f18408d = j6;
        this.f18409e = j7;
        this.f18410f = j8;
        this.f18411g = j9;
    }
}
