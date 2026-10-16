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
public final class IconButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f17864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17865d;

    public /* synthetic */ IconButtonColors(long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6);
    }

    public static /* synthetic */ IconButtonColors d(IconButtonColors iconButtonColors, long j3, long j4, long j5, long j6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = iconButtonColors.f17862a;
        }
        long j7 = j3;
        if ((i3 & 2) != 0) {
            j4 = iconButtonColors.f17863b;
        }
        long j8 = j4;
        if ((i3 & 4) != 0) {
            j5 = iconButtonColors.f17864c;
        }
        return iconButtonColors.c(j7, j8, j5, (i3 & 8) != 0 ? iconButtonColors.f17865d : j6);
    }

    public final long a(boolean z2) {
        return z2 ? this.f17862a : this.f17864c;
    }

    public final long b(boolean z2) {
        return z2 ? this.f17863b : this.f17865d;
    }

    public final IconButtonColors c(long j3, long j4, long j5, long j6) {
        return new IconButtonColors(j3 != 16 ? j3 : this.f17862a, j4 != 16 ? j4 : this.f17863b, j5 != 16 ? j5 : this.f17864c, j6 != 16 ? j6 : this.f17865d, null);
    }

    public final long e() {
        return this.f17863b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IconButtonColors)) {
            return false;
        }
        IconButtonColors iconButtonColors = (IconButtonColors) obj;
        return Color.t(this.f17862a, iconButtonColors.f17862a) && Color.t(this.f17863b, iconButtonColors.f17863b) && Color.t(this.f17864c, iconButtonColors.f17864c) && Color.t(this.f17865d, iconButtonColors.f17865d);
    }

    public int hashCode() {
        return (((((Color.z(this.f17862a) * 31) + Color.z(this.f17863b)) * 31) + Color.z(this.f17864c)) * 31) + Color.z(this.f17865d);
    }

    private IconButtonColors(long j3, long j4, long j5, long j6) {
        this.f17862a = j3;
        this.f17863b = j4;
        this.f17864c = j5;
        this.f17865d = j6;
    }
}
