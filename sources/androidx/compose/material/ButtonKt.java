package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

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
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fb  */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function0 r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.material.ButtonElevation r39, androidx.compose.ui.graphics.Shape r40, androidx.compose.foundation.BorderStroke r41, androidx.compose.material.ButtonColors r42, androidx.compose.foundation.layout.PaddingValues r43, final kotlin.jvm.functions.Function3 r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 780
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonKt.a(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.ButtonElevation, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ButtonColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b(State state) {
        return ((Color) state.getValue()).B();
    }

    public static final void c(Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3 function3, Composer composer, int i3, int i4) {
        Modifier modifier2 = (i4 & 2) != 0 ? Modifier.b8 : modifier;
        boolean z3 = (i4 & 4) != 0 ? true : z2;
        MutableInteractionSource mutableInteractionSource2 = (i4 & 8) != 0 ? null : mutableInteractionSource;
        ButtonElevation buttonElevation2 = (i4 & 16) != 0 ? null : buttonElevation;
        Shape shapeE = (i4 & 32) != 0 ? MaterialTheme.f13091a.b(composer, 6).e() : shape;
        BorderStroke borderStroke2 = (i4 & 64) == 0 ? borderStroke : null;
        ButtonColors buttonColorsG = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ButtonDefaults.f12323a.g(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues paddingValuesF = (i4 & Function.MAX_NARGS) != 0 ? ButtonDefaults.f12323a.f() : paddingValues;
        if (ComposerKt.M()) {
            ComposerKt.U(288797557, i3, -1, "androidx.compose.material.TextButton (Button.kt:233)");
        }
        a(function0, modifier2, z3, mutableInteractionSource2, buttonElevation2, shapeE, borderStroke2, buttonColorsG, paddingValuesF, function3, composer, i3 & 2147483646, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
