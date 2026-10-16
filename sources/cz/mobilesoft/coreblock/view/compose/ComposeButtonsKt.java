package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeButtonsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f130414a;

        static {
            int[] iArr = new int[RoundButtonSize.values().length];
            try {
                iArr[RoundButtonSize.Tiny.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoundButtonSize.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoundButtonSize.Medium.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RoundButtonSize.Big.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f130414a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.j(180.0f);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(boolean z2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z2) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(Modifier modifier, String str, ImageVector imageVector, Color color, boolean z2, boolean z3, long j3, long j4, Color color2, ButtonElevation buttonElevation, PaddingValues paddingValues, boolean z4, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        w0(modifier, str, imageVector, color, z2, z3, j3, j4, color2, buttonElevation, paddingValues, z4, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D0(final java.lang.String r27, androidx.compose.ui.text.TextStyle r28, androidx.compose.ui.Modifier r29, final boolean r30, final long r31, final boolean r33, final kotlin.jvm.functions.Function0 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.D0(java.lang.String, androidx.compose.ui.text.TextStyle, androidx.compose.ui.Modifier, boolean, long, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(boolean z2, long j3, TextStyle textStyle, String str, RowScope EmptyWrapperBig, Composer composer, int i3) {
        int i4;
        TextStyle textStyle2;
        Intrinsics.checkNotNullParameter(EmptyWrapperBig, "$this$EmptyWrapperBig");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(EmptyWrapperBig) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2141257843, i4, -1, "cz.mobilesoft.coreblock.view.compose.ProgressButton.<anonymous> (ComposeButtons.kt:1177)");
            }
            if (z2) {
                composer.a0(1358173075);
                ProgressIndicatorKt.b(SizeKt.v(PaddingKt.m(Modifier.b8, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null), Dp.g(24)), j3, 0.0f, 0L, 0, composer, 6, 28);
                composer.U();
            } else {
                composer.a0(1358554313);
                if (textStyle == null) {
                    composer.a0(459469909);
                    TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
                    composer.U();
                    textStyle2 = textStyleH;
                } else {
                    composer.a0(459469165);
                    composer.U();
                    textStyle2 = textStyle;
                }
                androidx.compose.material.TextKt.c(str, EmptyWrapperBig.d(Modifier.b8, Alignment.f25072a.i()), j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle2, composer, 0, 0, 65528);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(String str, TextStyle textStyle, Modifier modifier, boolean z2, long j3, boolean z3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        D0(str, textStyle, modifier, z2, j3, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void G0(final androidx.compose.ui.Modifier r25, final java.lang.String r26, androidx.compose.ui.text.TextStyle r27, long r28, long r30, final boolean r32, final kotlin.jvm.functions.Function0 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.G0(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.text.TextStyle, long, long, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(boolean z2, long j3, long j4, String str, TextStyle textStyle, RowScope Button, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(Button) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(657882289, i4, -1, "cz.mobilesoft.coreblock.view.compose.SelectableBorderButton.<anonymous> (ComposeButtons.kt:1260)");
            }
            androidx.compose.material.TextKt.c(str, Button.d(Modifier.b8, Alignment.f25072a.i()), z2 ? j3 : j4, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.a(), false, 1, 0, null, textStyle, composer, 0, 3120, 55288);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Modifier modifier, String str, TextStyle textStyle, long j3, long j4, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        G0(modifier, str, textStyle, j3, j4, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void J(androidx.compose.ui.Modifier r26, final java.lang.String r27, boolean r28, boolean r29, androidx.compose.ui.graphics.vector.ImageVector r30, final kotlin.jvm.functions.Function0 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.J(androidx.compose.ui.Modifier, java.lang.String, boolean, boolean, androidx.compose.ui.graphics.vector.ImageVector, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier K(float f3, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.k(applyIf, f3, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Modifier modifier, String str, boolean z2, boolean z3, ImageVector imageVector, Function0 function0, int i3, int i4, Composer composer, int i5) {
        J(modifier, str, z2, z3, imageVector, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final ButtonColors L0(long j3, long j4, Color color, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(17897108, i3, -1, "cz.mobilesoft.coreblock.view.compose.buttonColors (ComposeButtons.kt:1272)");
        }
        long jH = color != null ? ColorKt.h(j3, color.B()) : j3;
        ButtonColor.Disabled disabled = new ButtonColor.Disabled(false, null, false, null, 15, null);
        long jA = disabled.a(composer, 0);
        if (color != null) {
            jA = ColorKt.h(jA, color.B());
        }
        ButtonColors buttonColorsA = ButtonDefaults.f12323a.a(jH, j4, jA, disabled.f(composer, 0), composer, (i3 & 112) | (ButtonDefaults.f12334l << 12), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsA;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void M(final java.lang.String r24, androidx.compose.ui.Modifier r25, final androidx.compose.ui.graphics.vector.ImageVector r26, final long r27, final long r29, final long r31, final androidx.compose.ui.graphics.Color r33, final boolean r34, final androidx.compose.material.ButtonElevation r35, androidx.compose.foundation.layout.PaddingValues r36, float r37, final kotlin.jvm.functions.Function0 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.M(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, long, long, long, androidx.compose.ui.graphics.Color, boolean, androidx.compose.material.ButtonElevation, androidx.compose.foundation.layout.PaddingValues, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(ImageVector imageVector, String str, long j3, long j4, RowScope ButtonBigWrapper, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(ButtonBigWrapper, "$this$ButtonBigWrapper");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(ButtonBigWrapper) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1773104341, i4, -1, "cz.mobilesoft.coreblock.view.compose.ButtonBigColoredCenterAligned.<anonymous> (ComposeButtons.kt:883)");
            }
            if (imageVector == null) {
                composer.a0(-1251314936);
            } else {
                composer.a0(-1251314935);
                IconKt.b(imageVector, StringResources_androidKt.b(R.string.Yf, composer, 0), ButtonBigWrapper.d(PaddingKt.m(Modifier.b8, 0.0f, 0.0f, PrimitiveResources_androidKt.a(R.dimen.f95472f, composer, 0), 0.0f, 11, null), Alignment.f25072a.i()), j3, composer, 0, 0);
            }
            composer.U();
            if (str == null) {
                composer.a0(-1250885183);
                composer.U();
            } else {
                composer.a0(-1250885182);
                androidx.compose.material.TextKt.c(str, ButtonBigWrapper.d(Modifier.b8, Alignment.f25072a.i()), j4, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 3120, 55288);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(String str, Modifier modifier, ImageVector imageVector, long j3, long j4, long j5, Color color, boolean z2, ButtonElevation buttonElevation, PaddingValues paddingValues, float f3, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        M(str, modifier, imageVector, j3, j4, j5, color, z2, buttonElevation, paddingValues, f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void P(androidx.compose.ui.Modifier r29, final long r30, final long r32, final androidx.compose.ui.graphics.Color r34, final androidx.compose.material.ButtonElevation r35, androidx.compose.foundation.layout.PaddingValues r36, float r37, final boolean r38, final kotlin.jvm.functions.Function0 r39, final kotlin.jvm.functions.Function3 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.P(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.graphics.Color, androidx.compose.material.ButtonElevation, androidx.compose.foundation.layout.PaddingValues, float, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function3 function3, RowScope Button, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(Button) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2144048726, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonBigWrapper.<anonymous> (ComposeButtons.kt:936)");
            }
            function3.invoke(Button, composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Modifier modifier, long j3, long j4, Color color, ButtonElevation buttonElevation, PaddingValues paddingValues, float f3, boolean z2, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        P(modifier, j3, j4, color, buttonElevation, paddingValues, f3, z2, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void T(androidx.compose.ui.Modifier r67, androidx.compose.ui.graphics.vector.ImageVector r68, java.lang.String r69, final long r70, final long r72, final long r74, final androidx.compose.ui.graphics.Color r76, boolean r77, final androidx.compose.material.ButtonElevation r78, androidx.compose.ui.unit.Dp r79, final cz.mobilesoft.coreblock.view.compose.RoundButtonSize r80, final boolean r81, final kotlin.jvm.functions.Function0 r82, androidx.compose.runtime.Composer r83, final int r84, final int r85, final int r86) {
        /*
            Method dump skipped, instruction units count: 984
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.T(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, long, long, long, androidx.compose.ui.graphics.Color, boolean, androidx.compose.material.ButtonElevation, androidx.compose.ui.unit.Dp, cz.mobilesoft.coreblock.view.compose.RoundButtonSize, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(ImageVector imageVector, String str, boolean z2, long j3, float f3, long j4, TextStyle textStyle, RowScope Button, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(Button) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1450143013, i4, -1, "cz.mobilesoft.coreblock.view.compose.ButtonRound.<anonymous> (ComposeButtons.kt:1005)");
            }
            if (imageVector == null) {
                composer2.a0(1865569149);
            } else {
                composer2.a0(1865569150);
                String strB = StringResources_androidKt.b(R.string.Yf, composer2, 0);
                Modifier.Companion companion = Modifier.b8;
                IconKt.b(imageVector, strB, SizeKt.v(Button.d(companion, Alignment.f25072a.i()), f3), j4, composer2, 0, 0);
                if (str != null) {
                    composer2.a0(-825612793);
                    SpacerKt.a(SizeKt.A(companion, PrimitiveResources_androidKt.a(R.dimen.f95472f, composer2, 0)), composer2, 0);
                } else {
                    composer2.a0(-862254080);
                }
                composer2.U();
            }
            composer2.U();
            if (str == null) {
                composer2.a0(1866096738);
            } else {
                composer2.a0(1866096739);
                androidx.compose.material.TextKt.c(str, Button.d(Modifier.b8, Alignment.f25072a.i()), j3, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.a(), false, 1, 0, null, textStyle, composer, 0, 3120, 55288);
                composer2 = composer;
            }
            composer2.U();
            if (z2) {
                composer2.a0(1866490873);
                final boolean z3 = composer2.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b;
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer2, 6);
                String strB2 = StringResources_androidKt.b(R.string.Yf, composer2, 0);
                ColorFilter colorFilterC = ColorFilter.Companion.c(ColorFilter.f25730b, j3, 0, 2, null);
                Modifier modifierV = SizeKt.v(Modifier.b8, Dp.g(24));
                boolean zB = composer2.b(z3);
                Object objG = composer2.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.e3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ComposeButtonsKt.W(z3, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.w(objG);
                }
                androidx.compose.foundation.ImageKt.b(imageVectorB, strB2, GraphicsLayerModifierKt.a(modifierV, (Function1) objG), null, null, 0.0f, colorFilterC, composer2, 0, 56);
            } else {
                composer2.a0(1829302343);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(boolean z2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z2) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Modifier modifier, ImageVector imageVector, String str, long j3, long j4, long j5, Color color, boolean z2, ButtonElevation buttonElevation, Dp dp, RoundButtonSize roundButtonSize, boolean z3, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        T(modifier, imageVector, str, j3, j4, j5, color, z2, buttonElevation, dp, roundButtonSize, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void Y(androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.vector.ImageVector r25, final long r26, final long r28, final androidx.compose.ui.graphics.Color r30, final androidx.compose.material.ButtonElevation r31, final kotlin.jvm.functions.Function0 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.Y(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, long, long, androidx.compose.ui.graphics.Color, androidx.compose.material.ButtonElevation, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(ImageVector imageVector, long j3, RowScope Button, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(Button) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1977078629, i4, -1, "cz.mobilesoft.coreblock.view.compose.ButtonSquared.<anonymous> (ComposeButtons.kt:1070)");
            }
            if (imageVector == null) {
                composer.a0(-2032026797);
            } else {
                composer.a0(-2032026796);
                IconKt.b(imageVector, StringResources_androidKt.b(R.string.Yf, composer, 0), SizeKt.v(Button.d(Modifier.b8, Alignment.f25072a.i()), Dp.g(24)), j3, composer, 0, 0);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Modifier modifier, ImageVector imageVector, long j3, long j4, Color color, ButtonElevation buttonElevation, Function0 function0, int i3, int i4, Composer composer, int i5) {
        Y(modifier, imageVector, j3, j4, color, buttonElevation, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c0(final java.lang.String r35, androidx.compose.ui.Modifier r36, boolean r37, long r38, androidx.compose.ui.text.TextStyle r40, float r41, kotlin.jvm.functions.Function0 r42, final kotlin.jvm.functions.Function0 r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.c0(java.lang.String, androidx.compose.ui.Modifier, boolean, long, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean d0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(boolean z2, Function0 function0, Function0 function02, CoroutineScope coroutineScope, MutableState mutableState) {
        if (d0(mutableState)) {
            e0(mutableState, false);
            if (z2) {
                function0.invoke();
            } else if (function02 != null) {
                function02.invoke();
            }
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ComposeButtonsKt$ButtonText$1$1$1(mutableState, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(String str, long j3, TextStyle textStyle, RowScope Button, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(Button) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1447693105, i4, -1, "cz.mobilesoft.coreblock.view.compose.ButtonText.<anonymous> (ComposeButtons.kt:714)");
            }
            androidx.compose.material.TextKt.c(str, Button.d(Modifier.b8, Alignment.f25072a.i()), j3, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, textStyle, composer, 0, 3120, 55288);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(String str, Modifier modifier, boolean z2, long j3, TextStyle textStyle, float f3, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        c0(str, modifier, z2, j3, textStyle, f3, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void i0(Modifier modifier, final ButtonType buttonType, final ButtonColor buttonColor, final Function0 onClick, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        long jF;
        float fG;
        Modifier modifier4;
        Composer composer2;
        long j3;
        long jB;
        Composer composer3;
        long jB2;
        Composer composer4;
        long jB3;
        Composer composer5;
        long jB4;
        int i6;
        Composer composer6;
        long jB5;
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(buttonColor, "buttonColor");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-182974518);
        int i7 = i4 & 1;
        if (i7 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(buttonType) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(buttonColor) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onClick) ? 2048 : 1024;
        }
        int i8 = i5;
        if (composerK.r((i8 & 1171) != 1170, i8 & 1)) {
            Modifier modifier5 = i7 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-182974518, i8, -1, "cz.mobilesoft.coreblock.view.compose.ButtonThemed (ComposeButtons.kt:364)");
            }
            if (buttonColor.e()) {
                composerK.a0(255154131);
                jF = buttonColor.f(composerK, (i8 >> 6) & 14);
            } else {
                composerK.a0(255155347);
                jF = new ButtonColor.Disabled(false, null, false, null, 15, null).f(composerK, 0);
            }
            composerK.U();
            long j4 = jF;
            int i9 = i8 >> 6;
            long jA = buttonColor.a(composerK, i9 & 14);
            boolean zE = buttonColor.e();
            if (buttonColor.d()) {
                composerK.a0(-679956951);
                Dp dpC = buttonColor.c();
                if (dpC == null) {
                    composerK.a0(255161530);
                    fG = PrimitiveResources_androidKt.a(R.dimen.f95469c, composerK, 0);
                    composerK.U();
                } else {
                    composerK.a0(255160569);
                    composerK.U();
                    fG = dpC.l();
                }
                composerK.U();
            } else {
                composerK.a0(255163468);
                composerK.U();
                fG = Dp.g(0);
            }
            float f3 = fG;
            ButtonElevation buttonElevationB = ButtonDefaults.f12323a.b(f3, f3, 0.0f, 0.0f, 0.0f, composerK, ButtonDefaults.f12334l << 15, 28);
            if (buttonType instanceof ButtonType.Big) {
                composerK.a0(-679639387);
                ButtonType.Big big = (ButtonType.Big) buttonType;
                ImageVector imageVectorC = big.c();
                String strD = big.d();
                Color colorB = big.b();
                Modifier modifier6 = modifier5;
                M(strD, modifier6, imageVectorC, j4, colorB != null ? colorB.B() : j4, jA, buttonColor.b(), zE, buttonElevationB, null, big.a(), onClick, composerK, (i8 << 3) & 112, i9 & 112, 512);
                modifier4 = modifier6;
                composerK = composerK;
                composerK.U();
            } else {
                modifier4 = modifier5;
                if (buttonType instanceof ButtonType.BigRound) {
                    composerK.a0(-679004352);
                    ButtonType.BigRound bigRound = (ButtonType.BigRound) buttonType;
                    ImageVector imageVectorB = bigRound.b();
                    String strC = bigRound.c();
                    Color colorA = bigRound.a();
                    if (colorA != null) {
                        composer6 = composerK;
                        i6 = i8;
                        jB5 = colorA.B();
                    } else {
                        i6 = i8;
                        composer6 = composerK;
                        jB5 = j4;
                    }
                    T(modifier4, imageVectorB, strC, j4, jB5, jA, buttonColor.b(), false, buttonElevationB, null, RoundButtonSize.Big, zE, onClick, composer6, i6 & 14, ((i6 >> 3) & 896) | 6, 640);
                    composerK = composer6;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.Small) {
                    composerK.a0(-678359893);
                    ButtonType.Small small = (ButtonType.Small) buttonType;
                    ImageVector imageVectorB2 = small.b();
                    String strC2 = small.c();
                    Color colorA2 = small.a();
                    M(strC2, modifier4, imageVectorB2, j4, colorA2 != null ? colorA2.B() : j4, jA, buttonColor.b(), zE, buttonElevationB, PaddingKt.b(PrimitiveResources_androidKt.a(R.dimen.f95473g, composerK, 0), Dp.g(4)), Dp.g(40), onClick, composerK, (i8 << 3) & 112, (i9 & 112) | 6, 0);
                    modifier4 = modifier4;
                    composerK = composerK;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.SmallRound) {
                    composerK.a0(-677588024);
                    ButtonType.SmallRound smallRound = (ButtonType.SmallRound) buttonType;
                    ImageVector imageVectorC2 = smallRound.c();
                    String strE = smallRound.e();
                    Color colorB2 = smallRound.b();
                    if (colorB2 != null) {
                        composer5 = composerK;
                        jB4 = colorB2.B();
                    } else {
                        composer5 = composerK;
                        jB4 = j4;
                    }
                    T(modifier4, imageVectorC2, strE, j4, jB4, jA, buttonColor.b(), smallRound.d(), buttonElevationB, smallRound.a(), RoundButtonSize.Small, zE, onClick, composer5, i8 & 14, ((i8 >> 3) & 896) | 6, 0);
                    composerK = composer5;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.MediumRound) {
                    composerK.a0(-676812249);
                    ButtonType.MediumRound mediumRound = (ButtonType.MediumRound) buttonType;
                    ImageVector imageVectorC3 = mediumRound.c();
                    String strE2 = mediumRound.e();
                    Color colorB3 = mediumRound.b();
                    if (colorB3 != null) {
                        composer4 = composerK;
                        jB3 = colorB3.B();
                    } else {
                        composer4 = composerK;
                        jB3 = j4;
                    }
                    T(modifier4, imageVectorC3, strE2, j4, jB3, jA, buttonColor.b(), mediumRound.d(), buttonElevationB, mediumRound.a(), RoundButtonSize.Medium, zE, onClick, composer4, i8 & 14, ((i8 >> 3) & 896) | 6, 0);
                    composerK = composer4;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.TinyRound) {
                    composerK.a0(-676055105);
                    ButtonType.TinyRound tinyRound = (ButtonType.TinyRound) buttonType;
                    ImageVector imageVectorB3 = tinyRound.b();
                    String strC3 = tinyRound.c();
                    Color colorA3 = tinyRound.a();
                    if (colorA3 != null) {
                        composer3 = composerK;
                        jB2 = colorA3.B();
                    } else {
                        composer3 = composerK;
                        jB2 = j4;
                    }
                    T(modifier4, imageVectorB3, strC3, j4, jB2, jA, buttonColor.b(), false, buttonElevationB, null, RoundButtonSize.Tiny, zE, onClick, composer3, i8 & 14, ((i8 >> 3) & 896) | 6, 640);
                    composerK = composer3;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.Squared) {
                    composerK.a0(-675431323);
                    Y(modifier4, ((ButtonType.Squared) buttonType).a(), ComposeColorsKt.j(composerK, 0).b(), jA, buttonColor.b(), buttonElevationB, onClick, composerK, (i8 & 14) | (3670016 & (i8 << 9)), 0);
                    composerK = composerK;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.NavigationButton) {
                    composerK.a0(-674977762);
                    ButtonType.NavigationButton navigationButton = (ButtonType.NavigationButton) buttonType;
                    String strE3 = navigationButton.e();
                    ImageVector imageVectorD = navigationButton.d();
                    Color colorA4 = navigationButton.a();
                    boolean zB = navigationButton.b();
                    boolean zC = navigationButton.c();
                    Color colorA5 = navigationButton.a();
                    if (colorA5 != null) {
                        composer2 = composerK;
                        j3 = jA;
                        jB = colorA5.B();
                    } else {
                        composer2 = composerK;
                        j3 = jA;
                        jB = j4;
                    }
                    Composer composer7 = composer2;
                    w0(modifier4, strE3, imageVectorD, colorA4, zB, zC, jB, j3, buttonColor.b(), buttonElevationB, null, zE, onClick, composer7, i8 & 14, (i8 >> 3) & 896, 1024);
                    composerK = composer7;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.ProgressButton) {
                    composerK.a0(-674180256);
                    ButtonType.ProgressButton progressButton = (ButtonType.ProgressButton) buttonType;
                    D0(progressButton.b(), progressButton.c(), modifier4, progressButton.a(), j4, zE, onClick, composerK, ((i8 << 6) & 896) | (3670016 & (i8 << 9)), 0);
                    modifier4 = modifier4;
                    composerK = composerK;
                    composerK.U();
                } else if (buttonType instanceof ButtonType.EmptyWrapperBig) {
                    composerK.a0(-673782991);
                    ButtonType.EmptyWrapperBig emptyWrapperBig = (ButtonType.EmptyWrapperBig) buttonType;
                    P(modifier4, j4, jA, buttonColor.b(), buttonElevationB, emptyWrapperBig.b(), 0.0f, zE, onClick, emptyWrapperBig.a(), composerK, (i8 & 14) | (234881024 & (i8 << 15)), 64);
                    composerK = composerK;
                    composerK.U();
                } else {
                    if (!(buttonType instanceof ButtonType.EmptyWrapperSmall)) {
                        composerK.a0(255175235);
                        composerK.U();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerK.a0(-673241886);
                    ButtonType.EmptyWrapperSmall emptyWrapperSmall = (ButtonType.EmptyWrapperSmall) buttonType;
                    P(modifier4, j4, jA, buttonColor.b(), buttonElevationB, emptyWrapperSmall.b(), Dp.g(40), zE, onClick, emptyWrapperSmall.a(), composerK, (i8 & 14) | 1572864 | (234881024 & (i8 << 15)), 0);
                    composerK = composerK;
                    composerK.U();
                }
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.i3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeButtonsKt.j0(modifier3, buttonType, buttonColor, onClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Modifier modifier, ButtonType buttonType, ButtonColor buttonColor, Function0 function0, int i3, int i4, Composer composer, int i5) {
        i0(modifier, buttonType, buttonColor, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k0(final float r25, float r26, final androidx.compose.ui.graphics.vector.ImageVector r27, final long r28, final long r30, androidx.compose.ui.Modifier r32, final kotlin.jvm.functions.Function0 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.k0(float, float, androidx.compose.ui.graphics.vector.ImageVector, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(final Function0 function0, long j3, float f3, Modifier modifier, ImageVector imageVector, long j4, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-442971791, i3, -1, "cz.mobilesoft.coreblock.view.compose.CircleIconButtonWithShadow.<anonymous>.<anonymous> (ComposeButtons.kt:577)");
            }
            Modifier.Companion companion = Modifier.b8;
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.c3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeButtonsKt.m0(function0);
                    }
                };
                composer.w(objG);
            }
            Modifier modifierD = BackgroundKt.d(ClickableKt.f(companion, false, null, null, (Function0) objG, 7, null), j3, null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IconKt.b(imageVector, "", PaddingKt.i(companion, f3).then(modifier), j4, composer, 48, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(float f3, float f4, ImageVector imageVector, long j3, long j4, Modifier modifier, Function0 function0, int i3, int i4, Composer composer, int i5) {
        k0(f3, f4, imageVector, j3, j4, modifier, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void o0(androidx.compose.ui.Modifier r20, androidx.compose.foundation.layout.PaddingValues r21, int r22, final kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.o0(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, int, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Modifier modifier, PaddingValues paddingValues, int i3, Function0 function0, int i4, int i5, Composer composer, int i6) {
        o0(modifier, paddingValues, i3, function0, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q0(androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.vector.ImageVector r25, androidx.compose.ui.graphics.painter.Painter r26, boolean r27, float r28, float r29, long r30, java.lang.String r32, final kotlin.jvm.functions.Function0 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.q0(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.ui.graphics.painter.Painter, boolean, float, float, long, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean r0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(boolean z2, Function0 function0, CoroutineScope coroutineScope, MutableState mutableState) {
        if (z2 && r0(mutableState)) {
            s0(mutableState, false);
            function0.invoke();
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ComposeButtonsKt$IconButton$1$1$1(mutableState, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(ImageVector imageVector, float f3, String str, long j3, Painter painter, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(373013900, i3, -1, "cz.mobilesoft.coreblock.view.compose.IconButton.<anonymous> (ComposeButtons.kt:641)");
            }
            if (imageVector != null) {
                composer.a0(1376778115);
                IconKt.b(imageVector, str, SizeKt.v(Modifier.b8, f3), j3, composer, 0, 0);
                composer.U();
            } else {
                if (painter != null) {
                    composer.a0(1377114155);
                    IconKt.a(painter, str, SizeKt.v(Modifier.b8, f3), j3, composer, 0, 0);
                } else {
                    composer.a0(1354183734);
                }
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Modifier modifier, ImageVector imageVector, Painter painter, boolean z2, float f3, float f4, long j3, String str, Function0 function0, int i3, int i4, Composer composer, int i5) {
        q0(modifier, imageVector, painter, z2, f3, f4, j3, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void w0(androidx.compose.ui.Modifier r31, java.lang.String r32, androidx.compose.ui.graphics.vector.ImageVector r33, androidx.compose.ui.graphics.Color r34, final boolean r35, final boolean r36, final long r37, final long r39, final androidx.compose.ui.graphics.Color r41, final androidx.compose.material.ButtonElevation r42, androidx.compose.foundation.layout.PaddingValues r43, final boolean r44, final kotlin.jvm.functions.Function0 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 719
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.w0(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.ui.graphics.Color, boolean, boolean, long, long, androidx.compose.ui.graphics.Color, androidx.compose.material.ButtonElevation, androidx.compose.foundation.layout.PaddingValues, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(ImageVector imageVector, boolean z2, String str, long j3, boolean z3, Color color, RowScope Button, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        ImageVector imageVectorB;
        long jB;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(Button) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-590990311, i4, -1, "cz.mobilesoft.coreblock.view.compose.NavigationButton.<anonymous> (ComposeButtons.kt:1116)");
            }
            boolean z4 = composer2.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b;
            if (imageVector != null) {
                imageVectorB = imageVector;
            } else if (z2) {
                composer2.a0(-1121274031);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95577x1, composer2, 6);
                composer2.U();
            } else {
                composer2.a0(-1121183388);
                composer2.U();
                imageVectorB = null;
            }
            if (imageVectorB == null) {
                composer2.a0(-1121153535);
            } else {
                composer2.a0(-1121153534);
                if (color != null) {
                    jB = color.B();
                } else {
                    if (z2) {
                        composer2.a0(1419982189);
                        jB = ComposeColorsKt.j(composer2, 0).s();
                    } else {
                        composer2.a0(1419983014);
                        jB = ComposeColorsKt.j(composer2, 0).b();
                    }
                    composer2.U();
                }
                long j4 = jB;
                String strB = StringResources_androidKt.b(R.string.Yf, composer2, 0);
                ColorFilter colorFilterC = ColorFilter.Companion.c(ColorFilter.f25730b, j4, 0, 2, null);
                Modifier modifierV = SizeKt.v(PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), Dp.g(24));
                boolean z5 = z2 && z4;
                Object objG = composer2.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.b3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ComposeButtonsKt.z0((Modifier) obj);
                        }
                    };
                    composer2.w(objG);
                }
                androidx.compose.foundation.ImageKt.b(imageVectorB, strB, ComposableExtKt.r(modifierV, z5, (Function1) objG), null, null, 0.0f, colorFilterC, composer, 0, 56);
                composer2 = composer;
            }
            composer2.U();
            String str2 = str == null ? "" : str;
            TextStyle textStyleI = ComposeTypographyKt.g(composer2, 0).i();
            Modifier.Companion companion = Modifier.b8;
            final boolean z6 = z4;
            androidx.compose.material.TextKt.c(str2, PaddingKt.m(RowScope.c(Button, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleI, composer, 0, 0, 65528);
            if (z3) {
                composer.a0(-1120126535);
                ImageVector imageVectorB2 = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer, 6);
                String strB2 = StringResources_androidKt.b(R.string.Yf, composer, 0);
                ColorFilter colorFilterC2 = ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composer, 0).s(), 0, 2, null);
                Modifier modifierV2 = SizeKt.v(companion, Dp.g(24));
                boolean zB = composer.b(z6);
                Object objG2 = composer.G();
                if (zB || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.d3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ComposeButtonsKt.B0(z6, (GraphicsLayerScope) obj);
                        }
                    };
                    composer.w(objG2);
                }
                androidx.compose.foundation.ImageKt.b(imageVectorB2, strB2, GraphicsLayerModifierKt.a(modifierV2, (Function1) objG2), null, null, 0.0f, colorFilterC2, composer, 0, 56);
            } else {
                composer.a0(-1161417047);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier z0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return GraphicsLayerModifierKt.a(applyIf, new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.f3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeButtonsKt.A0((GraphicsLayerScope) obj);
            }
        });
    }
}
