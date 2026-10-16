package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NestedScrollInteropConnectionKt {
    private static final float e(float f3) {
        return (float) (f3 >= 0.0f ? Math.ceil(f3) : Math.floor(f3));
    }

    public static final int f(float f3) {
        return ((int) e(f3)) * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(long j3) {
        int i3 = Math.abs(Float.intBitsToFloat((int) (j3 >> 32))) >= 0.5f ? 1 : 0;
        return Math.abs(Float.intBitsToFloat((int) (j3 & 4294967295L))) >= 0.5f ? i3 | 2 : i3;
    }

    public static final NestedScrollConnection h(View view, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            view = (View) composer.q(AndroidCompositionLocals_androidKt.j());
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1075877987, i3, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:231)");
        }
        boolean Z = composer.Z(view);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new NestedScrollInteropConnection(view);
            composer.w(objG);
        }
        NestedScrollInteropConnection nestedScrollInteropConnection = (NestedScrollInteropConnection) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return nestedScrollInteropConnection;
    }

    private static final float i(int i3) {
        return i3 * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(int[] iArr, long j3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i3) >= 0.0f ? RangesKt.j(i(iArr[0]), Float.intBitsToFloat(i3)) : RangesKt.e(i(iArr[0]), Float.intBitsToFloat(i3)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4) >= 0.0f ? RangesKt.j(i(iArr[1]), Float.intBitsToFloat(i4)) : RangesKt.e(i(iArr[1]), Float.intBitsToFloat(i4)))) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(int i3) {
        return !NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f3) {
        return f3 * (-1.0f);
    }
}
