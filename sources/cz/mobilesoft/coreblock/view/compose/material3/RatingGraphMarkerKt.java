package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RatingGraphMarkerKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final java.lang.String r68, androidx.compose.ui.Modifier r69, final long r70, long r72, androidx.compose.ui.text.TextStyle r74, kotlin.jvm.functions.Function2 r75, int r76, float r77, float r78, float r79, float r80, float r81, float r82, androidx.compose.foundation.layout.PaddingValues r83, float r84, androidx.compose.runtime.Composer r85, final int r86, final int r87, final int r88) {
        /*
            Method dump skipped, instruction units count: 1413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.RatingGraphMarkerKt.c(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, int, float, float, float, float, float, float, androidx.compose.foundation.layout.PaddingValues, float, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(float f3, float f4, float f5, float f6, Path GenericShape, Size size, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(GenericShape, "$this$GenericShape");
        Intrinsics.checkNotNullParameter(layoutDirection, "<unused var>");
        float fJ = RangesKt.j(f3, Float.intBitsToFloat((int) (size.m() & 4294967295L)) / 2.0f);
        float fO = RangesKt.o(f4, 0.0f, Float.intBitsToFloat((int) (size.m() & 4294967295L)) / 2.0f);
        float fO2 = RangesKt.o(f5, 0.0f, Float.intBitsToFloat((int) (size.m() >> 32)));
        float f7 = fO2 / 2.0f;
        float fO3 = RangesKt.o(f6, 0.0f, Math.min(fO, f7));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m() & 4294967295L)) - fO;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m() >> 32)) / 2.0f;
        float fO4 = RangesKt.o(fIntBitsToFloat2 - f7, fJ, Float.intBitsToFloat((int) (size.m() >> 32)) - fJ);
        float fO5 = RangesKt.o(f7 + fIntBitsToFloat2, fJ, Float.intBitsToFloat((int) (size.m() >> 32)) - fJ);
        float f8 = fO2 * 0.28f;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (4294967295L & size.m()));
        float f9 = fIntBitsToFloat2 + fO3;
        float f10 = fIntBitsToFloat2 - fO3;
        float f11 = fIntBitsToFloat3 - fO3;
        GenericShape.a(fJ, 0.0f);
        GenericShape.c(Float.intBitsToFloat((int) (size.m() >> 32)) - fJ, 0.0f);
        GenericShape.m(Float.intBitsToFloat((int) (size.m() >> 32)), 0.0f, Float.intBitsToFloat((int) (size.m() >> 32)), fJ);
        float f12 = fIntBitsToFloat - fJ;
        GenericShape.c(Float.intBitsToFloat((int) (size.m() >> 32)), f12);
        GenericShape.m(Float.intBitsToFloat((int) (size.m() >> 32)), fIntBitsToFloat, Float.intBitsToFloat((int) (size.m() >> 32)) - fJ, fIntBitsToFloat);
        GenericShape.c(fO5, fIntBitsToFloat);
        GenericShape.m(fIntBitsToFloat2 + f8, fIntBitsToFloat, f9, f11);
        GenericShape.m(fIntBitsToFloat2, fIntBitsToFloat3, f10, f11);
        GenericShape.m(fIntBitsToFloat2 - f8, fIntBitsToFloat, fO4, fIntBitsToFloat);
        GenericShape.c(fJ, fIntBitsToFloat);
        GenericShape.m(0.0f, fIntBitsToFloat, 0.0f, f12);
        GenericShape.c(0.0f, fJ);
        GenericShape.m(0.0f, 0.0f, fJ, 0.0f);
        GenericShape.close();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, Modifier modifier, long j3, long j4, TextStyle textStyle, Function2 function2, int i3, float f3, float f4, float f5, float f6, float f7, float f8, PaddingValues paddingValues, float f9, int i4, int i5, int i6, Composer composer, int i7) {
        c(str, modifier, j3, j4, textStyle, function2, i3, f3, f4, f5, f6, f7, f8, paddingValues, f9, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }
}
