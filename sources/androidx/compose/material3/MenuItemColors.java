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
public final class MenuItemColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18146f;

    public /* synthetic */ MenuItemColors(long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8);
    }

    public final long a(boolean z2) {
        return z2 ? this.f18142b : this.f18145e;
    }

    public final long b(boolean z2) {
        return z2 ? this.f18141a : this.f18144d;
    }

    public final long c(boolean z2) {
        return z2 ? this.f18143c : this.f18146f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MenuItemColors)) {
            return false;
        }
        MenuItemColors menuItemColors = (MenuItemColors) obj;
        return Color.t(this.f18141a, menuItemColors.f18141a) && Color.t(this.f18142b, menuItemColors.f18142b) && Color.t(this.f18143c, menuItemColors.f18143c) && Color.t(this.f18144d, menuItemColors.f18144d) && Color.t(this.f18145e, menuItemColors.f18145e) && Color.t(this.f18146f, menuItemColors.f18146f);
    }

    public int hashCode() {
        return (((((((((Color.z(this.f18141a) * 31) + Color.z(this.f18142b)) * 31) + Color.z(this.f18143c)) * 31) + Color.z(this.f18144d)) * 31) + Color.z(this.f18145e)) * 31) + Color.z(this.f18146f);
    }

    private MenuItemColors(long j3, long j4, long j5, long j6, long j7, long j8) {
        this.f18141a = j3;
        this.f18142b = j4;
        this.f18143c = j5;
        this.f18144d = j6;
        this.f18145e = j7;
        this.f18146f = j8;
    }
}
