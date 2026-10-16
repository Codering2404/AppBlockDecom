package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class SliderColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f19879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f19880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f19881j;

    public /* synthetic */ SliderColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    public static /* synthetic */ SliderColors b(SliderColors sliderColors, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i3, Object obj) {
        long j13;
        long j14;
        long j15 = (i3 & 1) != 0 ? sliderColors.f19872a : j3;
        long j16 = (i3 & 2) != 0 ? sliderColors.f19873b : j4;
        long j17 = (i3 & 4) != 0 ? sliderColors.f19874c : j5;
        long j18 = (i3 & 8) != 0 ? sliderColors.f19875d : j6;
        long j19 = (i3 & 16) != 0 ? sliderColors.f19876e : j7;
        long j20 = (i3 & 32) != 0 ? sliderColors.f19877f : j8;
        long j21 = (i3 & 64) != 0 ? sliderColors.f19878g : j9;
        long j22 = j15;
        long j23 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? sliderColors.f19879h : j10;
        long j24 = (i3 & Function.MAX_NARGS) != 0 ? sliderColors.f19880i : j11;
        if ((i3 & 512) != 0) {
            j14 = j24;
            j13 = sliderColors.f19881j;
        } else {
            j13 = j12;
            j14 = j24;
        }
        return sliderColors.a(j22, j16, j17, j18, j19, j20, j21, j23, j14, j13);
    }

    public final SliderColors a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new SliderColors(j3 != 16 ? j3 : this.f19872a, j4 != 16 ? j4 : this.f19873b, j5 != 16 ? j5 : this.f19874c, j6 != 16 ? j6 : this.f19875d, j7 != 16 ? j7 : this.f19876e, j8 != 16 ? j8 : this.f19877f, j9 != 16 ? j9 : this.f19878g, j10 != 16 ? j10 : this.f19879h, j11 != 16 ? j11 : this.f19880i, j12 != 16 ? j12 : this.f19881j, null);
    }

    public final long c(boolean z2) {
        return z2 ? this.f19872a : this.f19877f;
    }

    public final long d(boolean z2, boolean z3) {
        return z2 ? z3 ? this.f19874c : this.f19876e : z3 ? this.f19879h : this.f19881j;
    }

    public final long e(boolean z2, boolean z3) {
        return z2 ? z3 ? this.f19873b : this.f19875d : z3 ? this.f19878g : this.f19880i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SliderColors)) {
            return false;
        }
        SliderColors sliderColors = (SliderColors) obj;
        return Color.t(this.f19872a, sliderColors.f19872a) && Color.t(this.f19873b, sliderColors.f19873b) && Color.t(this.f19874c, sliderColors.f19874c) && Color.t(this.f19875d, sliderColors.f19875d) && Color.t(this.f19876e, sliderColors.f19876e) && Color.t(this.f19877f, sliderColors.f19877f) && Color.t(this.f19878g, sliderColors.f19878g) && Color.t(this.f19879h, sliderColors.f19879h) && Color.t(this.f19880i, sliderColors.f19880i) && Color.t(this.f19881j, sliderColors.f19881j);
    }

    public int hashCode() {
        return (((((((((((((((((Color.z(this.f19872a) * 31) + Color.z(this.f19873b)) * 31) + Color.z(this.f19874c)) * 31) + Color.z(this.f19875d)) * 31) + Color.z(this.f19876e)) * 31) + Color.z(this.f19877f)) * 31) + Color.z(this.f19878g)) * 31) + Color.z(this.f19879h)) * 31) + Color.z(this.f19880i)) * 31) + Color.z(this.f19881j);
    }

    private SliderColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.f19872a = j3;
        this.f19873b = j4;
        this.f19874c = j5;
        this.f19875d = j6;
        this.f19876e = j7;
        this.f19877f = j8;
        this.f19878g = j9;
        this.f19879h = j10;
        this.f19880i = j11;
        this.f19881j = j12;
    }
}
