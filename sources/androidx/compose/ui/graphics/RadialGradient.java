package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class RadialGradient extends ShaderBrush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f25873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f25874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f25875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f25876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f25877e;

    public /* synthetic */ RadialGradient(List list, List list2, long j3, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j3, f3, i3);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo220createShaderuvyYCjk(long j3) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        long j4 = this.f25875c;
        if ((9223372034707292159L & j4) == 9205357640488583168L) {
            long jB = SizeKt.b(j3);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jB & 4294967295L));
        } else {
            fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j4 >> 32)) == Float.POSITIVE_INFINITY ? j3 >> 32 : this.f25875c >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.f25875c & 4294967295L)) == Float.POSITIVE_INFINITY ? j3 & 4294967295L : this.f25875c & 4294967295L));
        }
        List list = this.f25873a;
        List list2 = this.f25874b;
        long jE = Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat2))));
        float fH = this.f25876d;
        if (fH == Float.POSITIVE_INFINITY) {
            fH = Size.h(j3) / 2;
        }
        return ShaderKt.c(jE, fH, list, list2, this.f25877e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return Intrinsics.areEqual(this.f25873a, radialGradient.f25873a) && Intrinsics.areEqual(this.f25874b, radialGradient.f25874b) && Offset.j(this.f25875c, radialGradient.f25875c) && this.f25876d == radialGradient.f25876d && TileMode.g(this.f25877e, radialGradient.f25877e);
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo219getIntrinsicSizeNHjbRc() {
        if ((Float.floatToRawIntBits(this.f25876d) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040) {
            return Size.f25617b.a();
        }
        float f3 = this.f25876d;
        float f4 = 2;
        return Size.d((((long) Float.floatToRawIntBits(f3 * f4)) << 32) | (((long) Float.floatToRawIntBits(f3 * f4)) & 4294967295L));
    }

    public int hashCode() {
        int iHashCode = this.f25873a.hashCode() * 31;
        List list = this.f25874b;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.o(this.f25875c)) * 31) + Float.hashCode(this.f25876d)) * 31) + TileMode.h(this.f25877e);
    }

    public String toString() {
        String str;
        String str2 = "";
        if ((this.f25875c & 9223372034707292159L) != 9205357640488583168L) {
            str = "center=" + ((Object) Offset.s(this.f25875c)) + ", ";
        } else {
            str = "";
        }
        if ((Float.floatToRawIntBits(this.f25876d) & Api.BaseClientBuilder.API_PRIORITY_OTHER) < 2139095040) {
            str2 = "radius=" + this.f25876d + ", ";
        }
        return "RadialGradient(colors=" + this.f25873a + ", stops=" + this.f25874b + ", " + str + str2 + "tileMode=" + ((Object) TileMode.i(this.f25877e)) + ')';
    }

    private RadialGradient(List list, List list2, long j3, float f3, int i3) {
        this.f25873a = list;
        this.f25874b = list2;
        this.f25875c = j3;
        this.f25876d = f3;
        this.f25877e = i3;
    }
}
