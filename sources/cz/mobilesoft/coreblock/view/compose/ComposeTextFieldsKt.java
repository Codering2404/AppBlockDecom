package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeTextFieldsKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:393:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0122  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final androidx.compose.ui.text.input.TextFieldValue r64, final kotlin.jvm.functions.Function1 r65, androidx.compose.ui.Modifier r66, boolean r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, kotlin.jvm.functions.Function2 r71, kotlin.jvm.functions.Function2 r72, kotlin.jvm.functions.Function2 r73, kotlin.jvm.functions.Function2 r74, boolean r75, androidx.compose.ui.text.input.VisualTransformation r76, androidx.compose.foundation.text.KeyboardOptions r77, androidx.compose.foundation.text.KeyboardActions r78, boolean r79, int r80, androidx.compose.foundation.interaction.MutableInteractionSource r81, androidx.compose.ui.graphics.Shape r82, androidx.compose.foundation.layout.PaddingValues r83, androidx.compose.material.TextFieldColors r84, float r85, float r86, androidx.compose.runtime.Composer r87, final int r88, final int r89, final int r90, final int r91) {
        /*
            Method dump skipped, instruction units count: 1821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt.g(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material.TextFieldColors, float, float, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:408:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0127  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final java.lang.String r66, final kotlin.jvm.functions.Function1 r67, androidx.compose.ui.Modifier r68, boolean r69, boolean r70, boolean r71, androidx.compose.ui.text.TextStyle r72, kotlin.jvm.functions.Function2 r73, kotlin.jvm.functions.Function2 r74, kotlin.jvm.functions.Function2 r75, kotlin.jvm.functions.Function2 r76, boolean r77, androidx.compose.ui.text.input.VisualTransformation r78, androidx.compose.foundation.text.KeyboardOptions r79, androidx.compose.foundation.text.KeyboardActions r80, boolean r81, int r82, androidx.compose.foundation.interaction.MutableInteractionSource r83, androidx.compose.ui.graphics.Shape r84, androidx.compose.foundation.layout.PaddingValues r85, androidx.compose.material.TextFieldColors r86, long r87, float r89, float r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94, final int r95) {
        /*
            Method dump skipped, instruction units count: 1880
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt.h(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material.TextFieldColors, long, float, float, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier i(boolean z2, boolean z3, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return TextFieldDefaults.k(TextFieldDefaults.f14636a, applyIf, z2, z3, mutableInteractionSource, textFieldColors, 0.0f, 0.0f, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z2, boolean z3, boolean z4, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z5, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z6, int i3, MutableInteractionSource mutableInteractionSource, Shape shape, PaddingValues paddingValues, TextFieldColors textFieldColors, float f3, float f4, int i4, int i5, int i6, int i7, Composer composer, int i8) {
        g(textFieldValue, function1, modifier, z2, z3, z4, textStyle, function2, function22, function23, function24, z5, visualTransformation, keyboardOptions, keyboardActions, z6, i3, mutableInteractionSource, shape, paddingValues, textFieldColors, f3, f4, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), RecomposeScopeImplKt.a(i6), i7);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier l(boolean z2, boolean z3, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return TextFieldDefaults.k(TextFieldDefaults.f14636a, applyIf, z2, z3, mutableInteractionSource, textFieldColors, 0.0f, 0.0f, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, boolean z2, boolean z3, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z4, Function2 function2, Function2 function22, Function2 function23, Function2 function24, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 innerTextField, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.I(innerTextField) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1703331096, i4, -1, "cz.mobilesoft.coreblock.view.compose.ThemedTextField.<anonymous> (ComposeTextFields.kt:106)");
            }
            TextFieldDefaults.f14636a.e(str, innerTextField, z2, z3, visualTransformation, mutableInteractionSource, z4, function2, function22, function23, function24, null, textFieldColors, paddingValues, composer, (i4 << 3) & 112, 24576, 2048);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, Function1 function1, Modifier modifier, boolean z2, boolean z3, boolean z4, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z5, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z6, int i3, MutableInteractionSource mutableInteractionSource, Shape shape, PaddingValues paddingValues, TextFieldColors textFieldColors, long j3, float f3, float f4, int i4, int i5, int i6, int i7, Composer composer, int i8) {
        h(str, function1, modifier, z2, z3, z4, textStyle, function2, function22, function23, function24, z5, visualTransformation, keyboardOptions, keyboardActions, z6, i3, mutableInteractionSource, shape, paddingValues, textFieldColors, j3, f3, f4, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), RecomposeScopeImplKt.a(i6), i7);
        return Unit.f139807a;
    }

    private static final TextFieldColors o(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-957649411, i3, -1, "cz.mobilesoft.coreblock.view.compose.themedTextFieldColors (ComposeTextFields.kt:223)");
        }
        TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(0L, 0L, Color.f25715b.j(), 0L, 0L, ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).u(), 0L, 0L, 0L, 0L, 0L, ComposeColorsKt.j(composer, 0).s(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 384, 0, 48, 2092955);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(TextFieldValue textFieldValue, boolean z2, boolean z3, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z4, Function2 function2, Function2 function22, Function2 function23, Function2 function24, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 innerTextField, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.I(innerTextField) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1457290270, i4, -1, YznnJpHcAmeoW.vAkt);
            }
            TextFieldDefaults.f14636a.e(textFieldValue.i(), innerTextField, z2, z3, visualTransformation, mutableInteractionSource, z4, function2, function22, function23, function24, null, textFieldColors, paddingValues, composer, (i4 << 3) & 112, 24576, 2048);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
