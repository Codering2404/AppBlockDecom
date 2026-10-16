package cz.mobilesoft.coreblock.view.badge;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.FixedScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.GradientTextKt;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class PremiumExpiringCardKt {
    public static final void j(final BoxScope boxScope, final Function0 onCloseClicked, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(427405018);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(427405018, i4, -1, "cz.mobilesoft.coreblock.view.badge.CloseIconButton (PremiumExpiringCard.kt:229)");
            }
            float f3 = 8;
            ComposeButtonsKt.q0(boxScope.f(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(f3), Dp.g(f3), 0.0f, 9, null), Alignment.f25072a.n()), VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composerK, 6), null, false, Dp.g(16), 0.0f, ComposeColorsKt.j(composerK, 0).q0(), StringResources_androidKt.b(R.string.Re, composerK, 0), onCloseClicked, composerK, ((i4 << 21) & 234881024) | 24576, 44);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringCardKt.k(boxScope, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(BoxScope boxScope, Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        j(boxScope, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void l(Modifier modifier, int i3, final Function3 content, Composer composer, final int i4, final int i5) {
        Modifier modifier2;
        int i6;
        int i7;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(587243539);
        int i8 = i5 & 1;
        if (i8 != 0) {
            i6 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerK.Z(modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            if ((i5 & 2) == 0) {
                i7 = i3;
                int i9 = composerK.e(i7) ? 32 : 16;
                i6 |= i9;
            } else {
                i7 = i3;
            }
            i6 |= i9;
        } else {
            i7 = i3;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.I(content) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i6 & 147) != 146, i6 & 1)) {
            composerK.J();
            if ((i4 & 1) == 0 || composerK.S()) {
                modifier3 = i8 != 0 ? Modifier.b8 : modifier2;
                if ((i5 & 2) != 0) {
                    i6 &= -113;
                    i7 = R.drawable.f95529k;
                }
            } else {
                composerK.Q();
                if ((i5 & 2) != 0) {
                    i6 &= -113;
                }
                modifier3 = modifier2;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(587243539, i6, -1, "cz.mobilesoft.coreblock.view.badge.GradientBox (PremiumExpiringCard.kt:211)");
            }
            Modifier modifierH = SizeKt.h(modifier3, 0.0f, 1, null);
            int i10 = i6 >> 3;
            Painter painterC = PainterResources_androidKt.c(i7, composerK, i10 & 14);
            ContentScale contentScaleB = ContentScale.f27054a.b();
            Alignment.Companion companion = Alignment.f25072a;
            Modifier modifierB = PainterModifierKt.b(modifierH, painterC, false, companion.e(), contentScaleB, 0.0f, null, 48, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            content.invoke(BoxScopeInstance.f6642a, composerK, Integer.valueOf((i10 & 112) | 6));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Modifier modifier4 = modifier3;
            final int i11 = i7;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringCardKt.m(modifier4, i11, content, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Modifier modifier, int i3, Function3 function3, int i4, int i5, Composer composer, int i6) {
        l(modifier, i3, function3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(androidx.compose.ui.Modifier r17, final java.lang.Integer r18, final kotlin.jvm.functions.Function0 r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardKt.n(androidx.compose.ui.Modifier, java.lang.Integer, kotlin.jvm.functions.Function0, java.lang.String, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(final String str, final Integer num, final String str2, final Function0 function0, final String str3, ColumnScope Card, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1101886879, i3, -1, "cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardLarge.<anonymous> (PremiumExpiringCard.kt:161)");
            }
            l(SizeKt.f(Modifier.b8, 0.0f, 1, null), R.drawable.f95533l, ComposableLambdaKt.e(1895671786, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.badge.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumExpiringCardKt.p(str, num, str2, function0, str3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 390, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, Integer num, String str2, Function0 function0, String str3, BoxScope GradientBox, Composer composer, int i3) {
        String strC;
        int i4;
        String lowerCase;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1895671786, i3, -1, "cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardLarge.<anonymous>.<anonymous> (PremiumExpiringCard.kt:165)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.i(companion, Dp.g(16)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion, Dp.g(6)), composer, 6);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.H7, composer, 0), "", null, null, null, 0.0f, null, composer, 48, 124);
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
            if (str == null) {
                if (num != null) {
                    composer.a0(937485854);
                    strC = StringResources_androidKt.b(R.string.op, composer, 0);
                } else {
                    composer.a0(937487426);
                    strC = StringResources_androidKt.c(R.string.IH, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer, 0)}, composer, 0);
                }
                composer.U();
            } else {
                strC = str;
            }
            String str4 = null;
            TextKt.c(strC, null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer, 6);
            if (str2 == null) {
                composer.a0(-1002293979);
                if (num == null) {
                    composer.a0(-1002293980);
                    composer.U();
                    i4 = 0;
                } else {
                    composer.a0(-1002293979);
                    i4 = 0;
                    String strT = ComposableExtKt.t(R.plurals.f95750k, num.intValue(), new Object[]{num}, composer, 0);
                    composer.U();
                    str4 = strT;
                }
                composer.U();
            } else {
                i4 = 0;
                composer.a0(937497401);
                composer.U();
                str4 = str2;
            }
            if (str4 == null) {
                composer.a0(937503743);
                lowerCase = StringResources_androidKt.b(R.string.ae, composer, i4).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                composer.U();
            } else {
                composer.a0(937497481);
                composer.U();
                lowerCase = str4;
            }
            GradientTextKt.e(lowerCase, 0.0f, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, i4).g()), composer, 0, 2);
            SpacerKt.a(SizeKt.i(companion, Dp.g(20)), composer, 6);
            v(function0, str3, composer, i4, i4);
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
    public static final Unit q(Modifier modifier, Integer num, Function0 function0, String str, String str2, String str3, int i3, int i4, Composer composer, int i5) {
        n(modifier, num, function0, str, str2, str3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(androidx.compose.ui.Modifier r18, final java.lang.Integer r19, final kotlin.jvm.functions.Function0 r20, final kotlin.jvm.functions.Function0 r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardKt.r(androidx.compose.ui.Modifier, java.lang.Integer, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, java.lang.String, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(final Function0 function0, final String str, final Integer num, final String str2, final Function0 function02, final String str3, ColumnScope Card, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1927597407, i3, -1, "cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardSmall.<anonymous> (PremiumExpiringCard.kt:80)");
            }
            l(SizeKt.f(Modifier.b8, 0.0f, 1, null), R.drawable.f95537m, ComposableLambdaKt.e(-1129727766, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.badge.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumExpiringCardKt.t(function0, str, num, str2, function02, str3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 390, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function0 function0, String str, Integer num, String str2, Function0 function02, String str3, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        String strB;
        int i5;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(GradientBox) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1129727766, i4, -1, "cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardSmall.<anonymous>.<anonymous> (PremiumExpiringCard.kt:84)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(RotateKt.a(companion, -22.0f), 0.0f, 0.0f, Dp.g(60), 0.0f, 11, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierD = OffsetKt.d(GradientBox.f(modifierM, companion2.n()), 0.0f, Dp.g(-16), 1, null);
            int i6 = R.drawable.H7;
            ImageKt.a(PainterResources_androidKt.c(i6, composer, 0), "", modifierD, null, new FixedScale(1.1f), 0.0f, null, composer, 24624, 104);
            ImageKt.a(PainterResources_androidKt.c(i6, composer, 0), "", GradientBox.f(PaddingKt.m(RotateKt.a(companion, 22.0f), 0.0f, Dp.g(44), Dp.g(20), 0.0f, 9, null), companion2.n()), null, new FixedScale(1.1f), 0.0f, null, composer, 24624, 104);
            ImageKt.a(PainterResources_androidKt.c(i6, composer, 0), "", GradientBox.f(PaddingKt.m(RotateKt.a(companion, -18.0f), 0.0f, Dp.g(50), Dp.g(80), 0.0f, 9, null), companion2.n()), null, new FixedScale(0.6f), 0.0f, null, composer, 24624, 104);
            j(GradientBox, function0, composer, i4 & 14);
            Modifier modifierF = SizeKt.f(PaddingKt.i(companion, Dp.g(16)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), companion2.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (str == null) {
                composer.a0(1939339292);
                strB = StringResources_androidKt.b(num != null ? R.string.op : R.string.mE, composer, 0);
                composer.U();
            } else {
                composer.a0(1939338889);
                composer.U();
                strB = str;
            }
            String str4 = null;
            TextKt.c(strB, null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            float f3 = 4;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            if (str2 == null) {
                composer.a0(-9632219);
                if (num == null) {
                    composer.a0(-9632220);
                    composer.U();
                    i5 = 0;
                } else {
                    composer.a0(-9632219);
                    i5 = 0;
                    String strT = ComposableExtKt.t(R.plurals.f95750k, num.intValue(), new Object[]{num}, composer, 0);
                    composer.U();
                    str4 = strT;
                }
                composer.U();
            } else {
                i5 = 0;
                composer.a0(1939350073);
                composer.U();
                str4 = str2;
            }
            if (str4 == null) {
                composer.a0(1939356415);
                String lowerCase = StringResources_androidKt.b(R.string.ae, composer, i5).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                composer.U();
                str4 = lowerCase;
            } else {
                composer.a0(1939350153);
                composer.U();
            }
            GradientTextKt.e(str4, Dp.g(f3), cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, i5).g()), composer, 48, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
            v(function02, str3, composer, i5, i5);
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
    public static final Unit u(Modifier modifier, Integer num, Function0 function0, Function0 function02, String str, String str2, String str3, int i3, int i4, Composer composer, int i5) {
        r(modifier, num, function0, function02, str, str2, str3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void v(final kotlin.jvm.functions.Function0 r19, java.lang.String r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            r3 = r19
            r7 = r22
            r8 = r23
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1510578554(0x5a09997a, float:9.682705E15)
            r1 = r21
            androidx.compose.runtime.Composer r4 = r1.k(r0)
            r1 = r7 & 6
            if (r1 != 0) goto L23
            boolean r1 = r4.I(r3)
            if (r1 == 0) goto L20
            r1 = 4
            goto L21
        L20:
            r1 = 2
        L21:
            r1 = r1 | r7
            goto L24
        L23:
            r1 = r7
        L24:
            r2 = r8 & 2
            if (r2 == 0) goto L2d
            r1 = r1 | 48
        L2a:
            r5 = r20
            goto L3f
        L2d:
            r5 = r7 & 48
            if (r5 != 0) goto L2a
            r5 = r20
            boolean r6 = r4.Z(r5)
            if (r6 == 0) goto L3c
            r6 = 32
            goto L3e
        L3c:
            r6 = 16
        L3e:
            r1 = r1 | r6
        L3f:
            r6 = r1 & 19
            r9 = 18
            r10 = 0
            if (r6 == r9) goto L48
            r6 = 1
            goto L49
        L48:
            r6 = r10
        L49:
            r9 = r1 & 1
            boolean r6 = r4.r(r6, r9)
            if (r6 == 0) goto Lb6
            if (r2 == 0) goto L56
            r2 = 0
            r9 = r2
            goto L57
        L56:
            r9 = r5
        L57:
            boolean r2 = androidx.compose.runtime.ComposerKt.M()
            if (r2 == 0) goto L63
            r2 = -1
            java.lang.String r5 = "cz.mobilesoft.coreblock.view.badge.RenewButton (PremiumExpiringCard.kt:249)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r2, r5)
        L63:
            cz.mobilesoft.coreblock.view.compose.ButtonType$Big r11 = new cz.mobilesoft.coreblock.view.compose.ButtonType$Big
            if (r9 != 0) goto L78
            r0 = -32950048(0xfffffffffe0938e0, float:-4.5599887E37)
            r4.a0(r0)
            int r0 = cz.mobilesoft.coreblock.R.string.ts
            java.lang.String r0 = androidx.compose.ui.res.StringResources_androidKt.b(r0, r4, r10)
            r4.U()
            r14 = r0
            goto L82
        L78:
            r0 = -32950296(0xfffffffffe0937e8, float:-4.559863E37)
            r4.a0(r0)
            r4.U()
            r14 = r9
        L82:
            r0 = 40
            float r0 = (float) r0
            float r15 = androidx.compose.ui.unit.Dp.g(r0)
            r16 = 3
            r17 = 0
            r12 = 0
            r13 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            cz.mobilesoft.coreblock.view.compose.ButtonColor$Accent r12 = new cz.mobilesoft.coreblock.view.compose.ButtonColor$Accent
            r17 = 11
            r18 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r12.<init>(r13, r14, r15, r16, r17, r18)
            int r0 = r1 << 9
            r5 = r0 & 7168(0x1c00, float:1.0045E-41)
            r6 = 1
            r0 = 0
            r1 = r11
            r2 = r12
            cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt.i0(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto Lb4
            androidx.compose.runtime.ComposerKt.T()
        Lb4:
            r5 = r9
            goto Lb9
        Lb6:
            r4.Q()
        Lb9:
            androidx.compose.runtime.ScopeUpdateScope r0 = r4.n()
            if (r0 == 0) goto Lc7
            cz.mobilesoft.coreblock.view.badge.x r1 = new cz.mobilesoft.coreblock.view.badge.x
            r1.<init>()
            r0.a(r1)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardKt.v(kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0, String str, int i3, int i4, Composer composer, int i5) {
        v(function0, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
