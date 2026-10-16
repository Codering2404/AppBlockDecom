package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
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
public final class LinearGradient extends ShaderBrush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f25809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f25810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f25811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f25812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f25813e;

    public /* synthetic */ LinearGradient(List list, List list2, long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j3, j4, i3);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo220createShaderuvyYCjk(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.f25811c >> 32)) == Float.POSITIVE_INFINITY ? j3 >> 32 : this.f25811c >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.f25811c & 4294967295L)) == Float.POSITIVE_INFINITY ? j3 & 4294967295L : this.f25811c & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.f25812d >> 32)) == Float.POSITIVE_INFINITY ? j3 >> 32 : this.f25812d >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.f25812d & 4294967295L)) == Float.POSITIVE_INFINITY ? j3 & 4294967295L : this.f25812d & 4294967295L));
        List list = this.f25809a;
        List list2 = this.f25810b;
        return ShaderKt.a(Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32)), list, list2, this.f25813e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return Intrinsics.areEqual(this.f25809a, linearGradient.f25809a) && Intrinsics.areEqual(this.f25810b, linearGradient.f25810b) && Offset.j(this.f25811c, linearGradient.f25811c) && Offset.j(this.f25812d, linearGradient.f25812d) && TileMode.g(this.f25813e, linearGradient.f25813e);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo219getIntrinsicSizeNHjbRc() {
        /*
            r8 = this;
            long r0 = r8.f25811c
            r2 = 32
            long r0 = r0 >> r2
            int r0 = (int) r0
            float r0 = java.lang.Float.intBitsToFloat(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            r3 = 2143289344(0x7fc00000, float:NaN)
            if (r1 != 0) goto L42
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L42
            long r0 = r8.f25812d
            long r0 = r0 >> r2
            int r0 = (int) r0
            float r0 = java.lang.Float.intBitsToFloat(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L42
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L42
            long r0 = r8.f25811c
            long r0 = r0 >> r2
            int r0 = (int) r0
            float r0 = java.lang.Float.intBitsToFloat(r0)
            long r4 = r8.f25812d
            long r4 = r4 >> r2
            int r1 = (int) r4
            float r1 = java.lang.Float.intBitsToFloat(r1)
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            goto L43
        L42:
            r0 = r3
        L43:
            long r4 = r8.f25811c
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            int r1 = (int) r4
            float r1 = java.lang.Float.intBitsToFloat(r1)
            boolean r4 = java.lang.Float.isInfinite(r1)
            if (r4 != 0) goto L85
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L85
            long r4 = r8.f25812d
            long r4 = r4 & r6
            int r1 = (int) r4
            float r1 = java.lang.Float.intBitsToFloat(r1)
            boolean r4 = java.lang.Float.isInfinite(r1)
            if (r4 != 0) goto L85
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L85
            long r3 = r8.f25811c
            long r3 = r3 & r6
            int r1 = (int) r3
            float r1 = java.lang.Float.intBitsToFloat(r1)
            long r3 = r8.f25812d
            long r3 = r3 & r6
            int r3 = (int) r3
            float r3 = java.lang.Float.intBitsToFloat(r3)
            float r1 = r1 - r3
            float r3 = java.lang.Math.abs(r1)
        L85:
            int r0 = java.lang.Float.floatToRawIntBits(r0)
            long r0 = (long) r0
            int r3 = java.lang.Float.floatToRawIntBits(r3)
            long r3 = (long) r3
            long r0 = r0 << r2
            long r2 = r3 & r6
            long r0 = r0 | r2
            long r0 = androidx.compose.ui.geometry.Size.d(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.mo219getIntrinsicSizeNHjbRc():long");
    }

    public int hashCode() {
        int iHashCode = this.f25809a.hashCode() * 31;
        List list = this.f25810b;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.o(this.f25811c)) * 31) + Offset.o(this.f25812d)) * 31) + TileMode.h(this.f25813e);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (((((this.f25811c & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str = "start=" + ((Object) Offset.s(this.f25811c)) + ", ";
        } else {
            str = "";
        }
        if ((((9187343241974906880L ^ (this.f25812d & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str2 = "end=" + ((Object) Offset.s(this.f25812d)) + ", ";
        }
        return "LinearGradient(colors=" + this.f25809a + ", stops=" + this.f25810b + ", " + str + str2 + "tileMode=" + ((Object) TileMode.i(this.f25813e)) + ')';
    }

    private LinearGradient(List list, List list2, long j3, long j4, int i3) {
        this.f25809a = list;
        this.f25810b = list2;
        this.f25811c = j3;
        this.f25812d = j4;
        this.f25813e = i3;
    }
}
