package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
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
public final class SweepGradient extends ShaderBrush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f25946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f25947c;

    public /* synthetic */ SweepGradient(long j3, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, list, list2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo220createShaderuvyYCjk(long j3) {
        long jE;
        long j4 = this.f25945a;
        if ((9223372034707292159L & j4) == 9205357640488583168L) {
            jE = SizeKt.b(j3);
        } else {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j4 >> 32)) == Float.POSITIVE_INFINITY ? j3 >> 32 : this.f25945a >> 32));
            if (Float.intBitsToFloat((int) (this.f25945a & 4294967295L)) != Float.POSITIVE_INFINITY) {
                j3 = this.f25945a;
            }
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
            jE = Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
        }
        return ShaderKt.d(jE, this.f25946b, this.f25947c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.j(this.f25945a, sweepGradient.f25945a) && Intrinsics.areEqual(this.f25946b, sweepGradient.f25946b) && Intrinsics.areEqual(this.f25947c, sweepGradient.f25947c);
    }

    public int hashCode() {
        int iO = ((Offset.o(this.f25945a) * 31) + this.f25946b.hashCode()) * 31;
        List list = this.f25947c;
        return iO + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str;
        if ((this.f25945a & 9223372034707292159L) != 9205357640488583168L) {
            str = "center=" + ((Object) Offset.s(this.f25945a)) + ", ";
        } else {
            str = "";
        }
        return "SweepGradient(" + str + "colors=" + this.f25946b + ", stops=" + this.f25947c + ')';
    }

    private SweepGradient(long j3, List list, List list2) {
        this.f25945a = j3;
        this.f25946b = list;
        this.f25947c = list2;
    }
}
