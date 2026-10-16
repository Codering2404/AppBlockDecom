package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class TextFieldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f20878a = Dp.g(8);

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
    /* JADX WARN: Removed duplicated region for block: B:271:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:359:? A[RETURN, SYNTHETIC] */
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
    public static final void a(final androidx.compose.ui.text.input.TextFieldValue r65, final kotlin.jvm.functions.Function1 r66, androidx.compose.ui.Modifier r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, kotlin.jvm.functions.Function2 r71, kotlin.jvm.functions.Function2 r72, kotlin.jvm.functions.Function2 r73, kotlin.jvm.functions.Function2 r74, kotlin.jvm.functions.Function2 r75, kotlin.jvm.functions.Function2 r76, kotlin.jvm.functions.Function2 r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, int r84, androidx.compose.foundation.interaction.MutableInteractionSource r85, androidx.compose.ui.graphics.Shape r86, androidx.compose.material3.TextFieldColors r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instruction units count: 1439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.a(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    /* JADX WARN: Removed duplicated region for block: B:271:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:359:? A[RETURN, SYNTHETIC] */
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
    public static final void b(final java.lang.String r65, final kotlin.jvm.functions.Function1 r66, androidx.compose.ui.Modifier r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, kotlin.jvm.functions.Function2 r71, kotlin.jvm.functions.Function2 r72, kotlin.jvm.functions.Function2 r73, kotlin.jvm.functions.Function2 r74, kotlin.jvm.functions.Function2 r75, kotlin.jvm.functions.Function2 r76, kotlin.jvm.functions.Function2 r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, int r84, androidx.compose.foundation.interaction.MutableInteractionSource r85, androidx.compose.ui.graphics.Shape r86, androidx.compose.material3.TextFieldColors r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instruction units count: 1439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.b(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void c(final Modifier modifier, Function2 function2, final Function2 function22, final Function3 function3, final Function2 function23, final Function2 function24, final Function2 function25, final Function2 function26, final boolean z2, final float f3, final Function2 function27, Function2 function28, PaddingValues paddingValues, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        float f4;
        final Function2 function29;
        final Function2 function210;
        Composer composerK = composer.k(-1830307184);
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
            i5 |= composerK.I(function22) ? Function.MAX_NARGS : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function3) ? 2048 : 1024;
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
            i6 = i4 | (composerK.I(function27) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.I(function28) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            paddingValues2 = paddingValues;
            if (composerK.Z(paddingValues2)) {
                i9 = Function.MAX_NARGS;
            }
            i6 |= i9;
        } else {
            paddingValues2 = paddingValues;
        }
        int i11 = i6;
        if ((i10 & 306783379) == 306783378 && (i11 & 147) == 146 && composerK.l()) {
            composerK.Q();
            function29 = function2;
            function210 = function28;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1830307184, i10, i11, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
            }
            boolean z3 = ((1879048192 & i10) == 536870912) | ((234881024 & i10) == 67108864) | ((i11 & 896) == 256);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new TextFieldMeasurePolicy(z2, f3, paddingValues2);
                composerK.w(objG);
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objG;
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
            Updater.e(composerA, textFieldMeasurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            function27.invoke(composerK, Integer.valueOf(i11 & 14));
            composerK.a0(1341517187);
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
            composerK.a0(1341526310);
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
            composerK.a0(1341556924);
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
            composerK.a0(1341568890);
            if (function26 != null) {
                float f6 = f5;
                Modifier modifierM2 = PaddingKt.m(SizeKt.E(SizeKt.k(LayoutIdKt.b(Modifier.b8, "Suffix"), TextFieldImplKt.o(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.p(), 0.0f, f6, 0.0f, 10, null);
                f4 = f6;
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
            composerK.a0(1341581092);
            if (function22 != null) {
                Modifier modifierM3 = PaddingKt.m(SizeKt.E(SizeKt.k(LayoutIdKt.b(Modifier.b8, "Label"), DpKt.c(TextFieldImplKt.o(), TextFieldImplKt.m(), f3), 0.0f, 2, null), null, false, 3, null), fG2, 0.0f, f4, 0.0f, 10, null);
                MeasurePolicy measurePolicyG5 = BoxKt.g(Alignment.f25072a.o(), false);
                int iA6 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU6 = composerK.u();
                Modifier modifierF6 = ComposedModifierKt.f(composerK, modifierM3);
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
                function22.invoke(composerK, Integer.valueOf((i10 >> 6) & 14));
                composerK.y();
            }
            composerK.U();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierE = SizeKt.E(SizeKt.k(companion2, TextFieldImplKt.o(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                fG2 = Dp.g(0);
            }
            Modifier modifierM4 = PaddingKt.m(modifierE, fG2, 0.0f, function26 == null ? f4 : Dp.g(0), 0.0f, 10, null);
            composerK.a0(1341611627);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.b(companion2, "Hint").then(modifierM4), composerK, Integer.valueOf((i10 >> 6) & 112));
            }
            composerK.U();
            Modifier modifierThen3 = LayoutIdKt.b(companion2, "TextField").then(modifierM4);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG6 = BoxKt.g(companion3.o(), true);
            int iA7 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU7 = composerK.u();
            Modifier modifierF7 = ComposedModifierKt.f(composerK, modifierThen3);
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
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.f6642a;
            function29 = function2;
            function29.invoke(composerK, Integer.valueOf((i10 >> 3) & 14));
            composerK.y();
            composerK.a0(1341622624);
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
                function210.invoke(composerK, Integer.valueOf((i11 >> 3) & 14));
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
            final PaddingValues paddingValues3 = paddingValues2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextFieldLayout$2
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
                    TextFieldKt.c(modifier, function29, function22, function3, function23, function24, function25, function26, z2, f3, function27, function210, paddingValues3, composer2, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f3, long j3, float f4, PaddingValues paddingValues) {
        boolean z2 = i4 > 0;
        float fG = Dp.g(paddingValues.d() + paddingValues.a()) * f4;
        if (z2) {
            fG = MathHelpersKt.b(Dp.g(TextFieldImplKt.r() * 2) * f4, fG, f3);
        }
        return Math.max(Constraints.m(j3), Math.max(i5, Math.max(i6, MathKt.d(fG + MathHelpersKt.c(0, i4, f3) + ComparisonsKt.j(i3, i9, i7, i8, MathHelpersKt.c(i4, 0, f3))))) + i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3) {
        int i10 = i5 + i6;
        return Math.max(i3 + Math.max(i7 + i10, Math.max(i9 + i10, i8)) + i4, Constraints.n(j3));
    }

    public static final Modifier k(Modifier modifier, final State state) {
        return DrawModifierKt.d(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt$drawIndicatorLine$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.i2();
                float fM1 = contentDrawScope.M1(((BorderStroke) state.getValue()).b());
                float fG = Size.g(contentDrawScope.b()) - (fM1 / 2);
                DrawScope.h2(contentDrawScope, ((BorderStroke) state.getValue()).a(), OffsetKt.a(0.0f, fG), OffsetKt.a(Size.i(contentDrawScope.b()), fG), fM1, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float l() {
        return f20878a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Placeable.PlacementScope placementScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z2, int i5, int i6, float f3, float f4) {
        Placeable.PlacementScope.k(placementScope, placeable8, IntOffset.f29988b.b(), 0.0f, 2, null);
        int iT = i4 - TextFieldImplKt.t(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.m(placementScope, placeable4, 0, Alignment.f25072a.i().a(placeable4.O0(), iT), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.m(placementScope, placeable2, TextFieldImplKt.v(placeable4), (z2 ? Alignment.f25072a.i().a(placeable2.O0(), iT) : MathKt.d(TextFieldImplKt.r() * f4)) - MathKt.d((r1 - i5) * f3), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.m(placementScope, placeable6, TextFieldImplKt.v(placeable4), i6, 0.0f, 4, null);
        }
        int iV = TextFieldImplKt.v(placeable4) + TextFieldImplKt.v(placeable6);
        Placeable.PlacementScope.m(placementScope, placeable, iV, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.m(placementScope, placeable3, iV, i6, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.m(placementScope, placeable7, (i3 - TextFieldImplKt.v(placeable5)) - placeable7.X0(), i6, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.m(placementScope, placeable5, i3 - placeable5.X0(), Alignment.f25072a.i().a(placeable5.O0(), iT), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.m(placementScope, placeable9, 0, iT, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Placeable.PlacementScope placementScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z2, float f3, PaddingValues paddingValues) {
        Placeable.PlacementScope.k(placementScope, placeable7, IntOffset.f29988b.b(), 0.0f, 2, null);
        int iT = i4 - TextFieldImplKt.t(placeable8);
        int iD = MathKt.d(paddingValues.d() * f3);
        if (placeable3 != null) {
            Placeable.PlacementScope.m(placementScope, placeable3, 0, Alignment.f25072a.i().a(placeable3.O0(), iT), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.m(placementScope, placeable5, TextFieldImplKt.v(placeable3), o(z2, iT, iD, placeable5), 0.0f, 4, null);
        }
        int iV = TextFieldImplKt.v(placeable5) + TextFieldImplKt.v(placeable3);
        Placeable.PlacementScope.m(placementScope, placeable, iV, o(z2, iT, iD, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.m(placementScope, placeable2, iV, o(z2, iT, iD, placeable2), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.m(placementScope, placeable6, (i3 - TextFieldImplKt.v(placeable4)) - placeable6.X0(), o(z2, iT, iD, placeable6), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.m(placementScope, placeable4, i3 - placeable4.X0(), Alignment.f25072a.i().a(placeable4.O0(), iT), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.m(placementScope, placeable8, 0, iT, 0.0f, 4, null);
        }
    }

    private static final int o(boolean z2, int i3, int i4, Placeable placeable) {
        return z2 ? Alignment.f25072a.i().a(placeable.O0(), i3) : i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int i3, int i4) {
        return i3 == Integer.MAX_VALUE ? i3 : i3 - i4;
    }
}
