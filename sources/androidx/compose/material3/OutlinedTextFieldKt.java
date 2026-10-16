package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class OutlinedTextFieldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18949a = Dp.g(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f18950b;

    static {
        long jL = TypeScaleTokens.f23622a.l();
        TextUnitKt.b(jL);
        f18950b = TextUnitKt.l(TextUnit.f(jL), TextUnit.h(jL) / 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.text.input.TextFieldValue r68, final kotlin.jvm.functions.Function1 r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2 r74, kotlin.jvm.functions.Function2 r75, kotlin.jvm.functions.Function2 r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94, final int r95) {
        /*
            Method dump skipped, instruction units count: 1441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.a(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final java.lang.String r68, final kotlin.jvm.functions.Function1 r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2 r74, kotlin.jvm.functions.Function2 r75, kotlin.jvm.functions.Function2 r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94, final int r95) {
        /*
            Method dump skipped, instruction units count: 1441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.b(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void c(final Modifier modifier, final Function2 function2, final Function3 function3, Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, final Function2 function26, final boolean z2, final float f3, final Function1 function1, final Function2 function27, Function2 function28, PaddingValues paddingValues, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        float f4;
        final Function2 function29;
        Function2 function210;
        Composer composerK = composer.k(1408290209);
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerK.Z(modifier) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        int i8 = i3 & 384;
        int i9 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i8 == 0) {
            i5 |= composerK.I(function3) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function22) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(function23) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(function24) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.I(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= composerK.I(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= composerK.b(z2) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.c(f3) ? 536870912 : 268435456;
        }
        int i10 = i5;
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.I(function1) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.I(function27) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            if (composerK.I(function28)) {
                i9 = 256;
            }
            i6 |= i9;
        }
        if ((i4 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i6 |= composerK.Z(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int i11 = i6;
        if ((i10 & 306783379) == 306783378 && (i11 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            function29 = function22;
            function210 = function28;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1408290209, i10, i11, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:468)");
            }
            boolean z3 = ((i11 & 7168) == 2048) | ((i11 & 14) == 4) | ((234881024 & i10) == 67108864) | ((1879048192 & i10) == 536870912);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new OutlinedTextFieldMeasurePolicy(function1, z2, f3, paddingValues2);
                composerK.w(objG);
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objG;
            LayoutDirection layoutDirection = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, outlinedTextFieldMeasurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            function27.invoke(composerK, Integer.valueOf((i11 >> 3) & 14));
            composerK.a0(250370369);
            if (function23 != null) {
                Modifier modifierThen = LayoutIdKt.b(Modifier.b8, "Leading").then(TextFieldImplKt.k());
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierThen);
                Function0 function0A2 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion.e());
                Updater.e(composerA2, compositionLocalMapU2, companion.g());
                Function2 function2B2 = companion.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function23.invoke(composerK, Integer.valueOf((i10 >> 12) & 14));
                composerK.y();
            }
            composerK.U();
            composerK.a0(250379492);
            if (function24 != null) {
                Modifier modifierThen2 = LayoutIdKt.b(Modifier.b8, "Trailing").then(TextFieldImplKt.k());
                MeasurePolicy measurePolicyG2 = BoxKt.g(Alignment.f25072a.e(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierThen2);
                Function0 function0A3 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A3);
                } else {
                    composerK.v();
                }
                Composer composerA3 = Updater.a(composerK);
                Updater.e(composerA3, measurePolicyG2, companion.e());
                Updater.e(composerA3, compositionLocalMapU3, companion.g());
                Function2 function2B3 = companion.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                function24.invoke(composerK, Integer.valueOf((i10 >> 15) & 14));
                composerK.y();
            }
            composerK.U();
            float fG = PaddingKt.g(paddingValues2, layoutDirection);
            float f5 = PaddingKt.f(paddingValues2, layoutDirection);
            if (function23 != null) {
                i7 = 0;
                fG = Dp.g(RangesKt.e(Dp.g(fG - TextFieldImplKt.j()), Dp.g(0)));
            } else {
                i7 = 0;
            }
            float fG2 = fG;
            if (function24 != null) {
                f5 = Dp.g(RangesKt.e(Dp.g(f5 - TextFieldImplKt.j()), Dp.g(i7)));
            }
            composerK.a0(250410106);
            if (function25 != null) {
                Modifier modifierM = PaddingKt.m(SizeKt.E(SizeKt.k(LayoutIdKt.b(Modifier.b8, "Prefix"), TextFieldImplKt.o(), 0.0f, 2, null), null, false, 3, null), fG2, 0.0f, TextFieldImplKt.p(), 0.0f, 10, null);
                MeasurePolicy measurePolicyG3 = BoxKt.g(Alignment.f25072a.o(), false);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierM);
                Function0 function0A4 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG3, companion.e());
                Updater.e(composerA4, compositionLocalMapU4, companion.g());
                Function2 function2B4 = companion.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion.f());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.f6642a;
                function25.invoke(composerK, Integer.valueOf((i10 >> 18) & 14));
                composerK.y();
            }
            composerK.U();
            composerK.a0(250422072);
            if (function26 != null) {
                f4 = f5;
                Modifier modifierM2 = PaddingKt.m(SizeKt.E(SizeKt.k(LayoutIdKt.b(Modifier.b8, "Suffix"), TextFieldImplKt.o(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.p(), 0.0f, f4, 0.0f, 10, null);
                MeasurePolicy measurePolicyG4 = BoxKt.g(Alignment.f25072a.o(), false);
                int iA5 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU5 = composerK.u();
                Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierM2);
                Function0 function0A5 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A5);
                } else {
                    composerK.v();
                }
                Composer composerA5 = Updater.a(composerK);
                Updater.e(composerA5, measurePolicyG4, companion.e());
                Updater.e(composerA5, compositionLocalMapU5, companion.g());
                Function2 function2B5 = companion.b();
                if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                    composerA5.w(Integer.valueOf(iA5));
                    composerA5.p(Integer.valueOf(iA5), function2B5);
                }
                Updater.e(composerA5, modifierF5, companion.f());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.f6642a;
                function26.invoke(composerK, Integer.valueOf((i10 >> 21) & 14));
                composerK.y();
            } else {
                f4 = f5;
            }
            composerK.U();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierE = SizeKt.E(SizeKt.k(companion2, TextFieldImplKt.o(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                fG2 = Dp.g(0);
            }
            Modifier modifierM3 = PaddingKt.m(modifierE, fG2, 0.0f, function26 == null ? f4 : Dp.g(0), 0.0f, 10, null);
            composerK.a0(250444361);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.b(companion2, "Hint").then(modifierM3), composerK, Integer.valueOf((i10 >> 3) & 112));
            }
            composerK.U();
            Modifier modifierThen3 = LayoutIdKt.b(companion2, "TextField").then(modifierM3);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG5 = BoxKt.g(companion3.o(), true);
            int iA6 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU6 = composerK.u();
            Modifier modifierF6 = ComposedModifierKt.f(composerK, modifierThen3);
            Function0 function0A6 = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A6);
            } else {
                composerK.v();
            }
            Composer composerA6 = Updater.a(composerK);
            Updater.e(composerA6, measurePolicyG5, companion.e());
            Updater.e(composerA6, compositionLocalMapU6, companion.g());
            Function2 function2B6 = companion.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                composerA6.w(Integer.valueOf(iA6));
                composerA6.p(Integer.valueOf(iA6), function2B6);
            }
            Updater.e(composerA6, modifierF6, companion.f());
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf((i10 >> 3) & 14));
            composerK.y();
            composerK.a0(250455481);
            if (function22 != null) {
                Modifier modifierB = LayoutIdKt.b(SizeKt.E(SizeKt.k(companion2, DpKt.c(TextFieldImplKt.o(), TextFieldImplKt.m(), f3), 0.0f, 2, null), null, false, 3, null), "Label");
                MeasurePolicy measurePolicyG6 = BoxKt.g(companion3.o(), false);
                int iA7 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU7 = composerK.u();
                Modifier modifierF7 = ComposedModifierKt.f(composerK, modifierB);
                Function0 function0A7 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A7);
                } else {
                    composerK.v();
                }
                Composer composerA7 = Updater.a(composerK);
                Updater.e(composerA7, measurePolicyG6, companion.e());
                Updater.e(composerA7, compositionLocalMapU7, companion.g());
                Function2 function2B7 = companion.b();
                if (composerA7.i() || !Intrinsics.areEqual(composerA7.G(), Integer.valueOf(iA7))) {
                    composerA7.w(Integer.valueOf(iA7));
                    composerA7.p(Integer.valueOf(iA7), function2B7);
                }
                Updater.e(composerA7, modifierF7, companion.f());
                function29 = function22;
                function29.invoke(composerK, Integer.valueOf((i10 >> 9) & 14));
                composerK.y();
            } else {
                function29 = function22;
            }
            composerK.U();
            composerK.a0(250473414);
            if (function28 != null) {
                Modifier modifierH = PaddingKt.h(SizeKt.E(SizeKt.k(LayoutIdKt.b(companion2, "Supporting"), TextFieldImplKt.n(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.r(TextFieldDefaults.f20812a, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                MeasurePolicy measurePolicyG7 = BoxKt.g(companion3.o(), false);
                int iA8 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU8 = composerK.u();
                Modifier modifierF8 = ComposedModifierKt.f(composerK, modifierH);
                Function0 function0A8 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A8);
                } else {
                    composerK.v();
                }
                Composer composerA8 = Updater.a(composerK);
                Updater.e(composerA8, measurePolicyG7, companion.e());
                Updater.e(composerA8, compositionLocalMapU8, companion.g());
                Function2 function2B8 = companion.b();
                if (composerA8.i() || !Intrinsics.areEqual(composerA8.G(), Integer.valueOf(iA8))) {
                    composerA8.w(Integer.valueOf(iA8));
                    composerA8.p(Integer.valueOf(iA8), function2B8);
                }
                Updater.e(composerA8, modifierF8, companion.f());
                function210 = function28;
                function210.invoke(composerK, Integer.valueOf((i11 >> 6) & 14));
                composerK.y();
            } else {
                function210 = function28;
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function2 function211 = function210;
            final PaddingValues paddingValues3 = paddingValues2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i12) {
                    OutlinedTextFieldKt.c(modifier, function2, function3, function29, function23, function24, function25, function26, z2, f3, function1, function27, function211, paddingValues3, composer2, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f3, long j3, float f4, PaddingValues paddingValues) {
        int iJ = ComparisonsKt.j(i7, i9, i5, i6, MathHelpersKt.c(i8, 0, f3));
        float fD = paddingValues.d() * f4;
        return Math.max(Constraints.m(j3), Math.max(i3, Math.max(i4, MathKt.d(MathHelpersKt.b(fD, Math.max(fD, i8 / 2.0f), f3) + iJ + (paddingValues.a() * f4)))) + i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f3, long j3, float f4, PaddingValues paddingValues) {
        int i10 = i5 + i6;
        int iMax = i3 + Math.max(i7 + i10, Math.max(i9 + i10, MathHelpersKt.c(i8, 0, f3))) + i4;
        LayoutDirection layoutDirection = LayoutDirection.f30001a;
        return Math.max(iMax, Math.max(MathKt.d((i8 + (Dp.g(paddingValues.b(layoutDirection) + paddingValues.c(layoutDirection)) * f4)) * f3), Constraints.n(j3)));
    }

    public static final long k() {
        return f18950b;
    }

    public static final Modifier l(Modifier modifier, final Function0 function0, final PaddingValues paddingValues) {
        return DrawModifierKt.d(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f19109a;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.f30002b.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f19109a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                long jM = ((Size) function0.invoke()).m();
                float fI = Size.i(jM);
                if (fI <= 0.0f) {
                    contentDrawScope.i2();
                    return;
                }
                float fM1 = contentDrawScope.M1(OutlinedTextFieldKt.f18949a);
                float fM12 = contentDrawScope.M1(paddingValues.b(contentDrawScope.getLayoutDirection())) - fM1;
                float f3 = 2;
                float fI2 = fI + fM12 + (fM1 * f3);
                LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                int[] iArr = WhenMappings.f19109a;
                float fI3 = iArr[layoutDirection.ordinal()] == 1 ? Size.i(contentDrawScope.b()) - fI2 : RangesKt.e(fM12, 0.0f);
                if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                    fI2 = Size.i(contentDrawScope.b()) - RangesKt.e(fM12, 0.0f);
                }
                float f4 = fI2;
                float fG = Size.g(jM);
                float f5 = (-fG) / f3;
                float f6 = fG / f3;
                int iA = ClipOp.f25711b.a();
                DrawContext drawContextQ1 = contentDrawScope.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    drawContextQ1.e().c(fI3, f5, f4, f6, iA);
                    contentDrawScope.i2();
                } finally {
                    drawContextQ1.g().k();
                    drawContextQ1.h(jB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Placeable.PlacementScope placementScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f3, boolean z2, float f4, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable placeable10;
        boolean z3;
        int i5;
        int i6;
        Placeable.PlacementScope.k(placementScope, placeable8, IntOffset.f29988b.b(), 0.0f, 2, null);
        int iT = i3 - TextFieldImplKt.t(placeable9);
        int iD = MathKt.d(paddingValues.d() * f4);
        int iD2 = MathKt.d(PaddingKt.g(paddingValues, layoutDirection) * f4);
        float fJ = TextFieldImplKt.j() * f4;
        if (placeable != null) {
            Placeable.PlacementScope.m(placementScope, placeable, 0, Alignment.f25072a.i().a(placeable.O0(), iT), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            placeable10 = placeable6;
            Placeable.PlacementScope.m(placementScope, placeable10, MathKt.d(placeable == null ? 0.0f : (TextFieldImplKt.v(placeable) - fJ) * (1 - f3)) + iD2, MathHelpersKt.c(z2 ? Alignment.f25072a.i().a(placeable6.O0(), iT) : iD, -(placeable6.O0() / 2), f3), 0.0f, 4, null);
        } else {
            placeable10 = placeable6;
        }
        if (placeable3 != null) {
            i6 = iD;
            i5 = iT;
            z3 = z2;
            Placeable.PlacementScope.m(placementScope, placeable3, TextFieldImplKt.v(placeable), n(z2, iT, iD, placeable10, placeable3), 0.0f, 4, null);
        } else {
            z3 = z2;
            i5 = iT;
            i6 = iD;
        }
        int iV = TextFieldImplKt.v(placeable) + TextFieldImplKt.v(placeable3);
        Placeable.PlacementScope.m(placementScope, placeable5, iV, n(z3, i5, i6, placeable10, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.m(placementScope, placeable7, iV, n(z3, i5, i6, placeable10, placeable7), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.m(placementScope, placeable4, (i4 - TextFieldImplKt.v(placeable2)) - placeable4.X0(), n(z3, i5, i6, placeable10, placeable4), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.m(placementScope, placeable2, i4 - placeable2.X0(), Alignment.f25072a.i().a(placeable2.O0(), i5), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.m(placementScope, placeable9, 0, i5, 0.0f, 4, null);
        }
    }

    private static final int n(boolean z2, int i3, int i4, Placeable placeable, Placeable placeable2) {
        if (z2) {
            i4 = Alignment.f25072a.i().a(placeable2.O0(), i3);
        }
        return Math.max(i4, TextFieldImplKt.t(placeable) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(int i3, int i4) {
        return i3 == Integer.MAX_VALUE ? i3 : i3 - i4;
    }
}
