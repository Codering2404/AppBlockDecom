package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
public final class TopAppBarColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f21538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f21539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f21542e;

    public /* synthetic */ TopAppBarColors(long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7);
    }

    public final long a(float f3) {
        return ColorKt.i(this.f21538a, this.f21539b, EasingKt.c().a(f3));
    }

    public final TopAppBarColors b(long j3, long j4, long j5, long j6, long j7) {
        return new TopAppBarColors(j3 != 16 ? j3 : this.f21538a, j4 != 16 ? j4 : this.f21539b, j5 != 16 ? j5 : this.f21540c, j6 != 16 ? j6 : this.f21541d, j7 != 16 ? j7 : this.f21542e, null);
    }

    public final long c() {
        return this.f21542e;
    }

    public final long d() {
        return this.f21540c;
    }

    public final long e() {
        return this.f21541d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return Color.t(this.f21538a, topAppBarColors.f21538a) && Color.t(this.f21539b, topAppBarColors.f21539b) && Color.t(this.f21540c, topAppBarColors.f21540c) && Color.t(this.f21541d, topAppBarColors.f21541d) && Color.t(this.f21542e, topAppBarColors.f21542e);
    }

    public int hashCode() {
        return (((((((Color.z(this.f21538a) * 31) + Color.z(this.f21539b)) * 31) + Color.z(this.f21540c)) * 31) + Color.z(this.f21541d)) * 31) + Color.z(this.f21542e);
    }

    private TopAppBarColors(long j3, long j4, long j5, long j6, long j7) {
        this.f21538a = j3;
        this.f21539b = j4;
        this.f21540c = j5;
        this.f21541d = j6;
        this.f21542e = j7;
    }
}
