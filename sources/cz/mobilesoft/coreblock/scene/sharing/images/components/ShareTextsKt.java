package cz.mobilesoft.coreblock.scene.sharing.images.components;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.sharing.images.components.ShareTextsKt;
import cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShareTextsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FontFamily f119428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final FontFamily f119429b;

    static {
        int i3 = R.font.f95586c;
        FontWeight.Companion companion = FontWeight.f29233b;
        f119428a = FontFamilyKt.c(FontKt.b(i3, companion.g(), 0, 0, 12, null), FontKt.b(R.font.f95585b, companion.b(), 0, 0, 12, null));
        f119429b = FontFamilyKt.c(FontKt.b(R.font.f95587d, companion.b(), 0, 0, 12, null));
    }

    public static final void f(Modifier modifier, final String text, long j3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        long jQ0;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        Modifier modifier4;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(1411412987);
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
            i5 |= composerK.Z(text) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                jQ0 = j3;
                if (composerK.f(jQ0)) {
                    i6 = Function.MAX_NARGS;
                }
                i5 |= i6;
            } else {
                jQ0 = j3;
            }
            i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            i5 |= i6;
        } else {
            jQ0 = j3;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
                if ((i4 & 4) != 0) {
                    jQ0 = ComposeColorsKt.j(composerK, 0).q0();
                    i5 &= -897;
                }
            } else {
                composerK.Q();
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                modifier4 = modifier2;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(1411412987, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.images.components.ShareCaptionText (ShareTexts.kt:93)");
            }
            int iA = TextAlign.f29616b.a();
            FontFamily fontFamily = f119428a;
            modifier3 = modifier4;
            composer2 = composerK;
            long j5 = jQ0;
            TextKt.c(text, modifier3, j5, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.i(43), FontWeight.f29233b.f(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.i(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.i(43), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null), composer2, ((i5 >> 3) & 14) | ((i5 << 3) & 112) | (i5 & 896), 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            j4 = j5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
            j4 = jQ0;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: q1.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShareTextsKt.g(modifier3, text, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, String str, long j3, int i3, int i4, Composer composer, int i5) {
        f(modifier, str, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void h(Modifier modifier, final String text, long j3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        long jQ0;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        Modifier modifier4;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(298358857);
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
            i5 |= composerK.Z(text) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                jQ0 = j3;
                if (composerK.f(jQ0)) {
                    i6 = Function.MAX_NARGS;
                }
                i5 |= i6;
            } else {
                jQ0 = j3;
            }
            i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            i5 |= i6;
        } else {
            jQ0 = j3;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
                if ((i4 & 4) != 0) {
                    jQ0 = ComposeColorsKt.j(composerK, 0).q0();
                    i5 &= -897;
                }
            } else {
                composerK.Q();
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                modifier4 = modifier2;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(298358857, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.images.components.ShareLabelText (ShareTexts.kt:114)");
            }
            int iA = TextAlign.f29616b.a();
            FontFamily fontFamily = f119428a;
            modifier3 = modifier4;
            composer2 = composerK;
            long j5 = jQ0;
            TextKt.c(text, modifier3, j5, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.g(30.6d), FontWeight.f29233b.h(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.i(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.g(39.6d), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null), composer2, ((i5 >> 3) & 14) | ((i5 << 3) & 112) | (i5 & 896), 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            j4 = j5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
            j4 = jQ0;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: q1.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShareTextsKt.i(modifier3, text, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Modifier modifier, String str, long j3, int i3, int i4, Composer composer, int i5) {
        h(modifier, str, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void j(Modifier modifier, final String text, long j3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        long jQ;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        Modifier modifier4;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(2031435025);
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
            i5 |= composerK.Z(text) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                jQ = j3;
                if (composerK.f(jQ)) {
                    i6 = Function.MAX_NARGS;
                }
                i5 |= i6;
            } else {
                jQ = j3;
            }
            i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            i5 |= i6;
        } else {
            jQ = j3;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
                if ((i4 & 4) != 0) {
                    jQ = new AppBlockColorPaletteDark().q();
                    i5 &= -897;
                }
            } else {
                composerK.Q();
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                modifier4 = modifier2;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(2031435025, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.images.components.ShareSubtitleSecondaryText (ShareTexts.kt:73)");
            }
            FontFamily fontFamily = f119428a;
            modifier3 = modifier4;
            composer2 = composerK;
            long j5 = jQ;
            TextKt.c(text, modifier3, j5, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.i(40), FontWeight.f29233b.f(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.i(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.i(40), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null), composer2, ((i5 >> 3) & 14) | ((i5 << 3) & 112) | (i5 & 896), 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            j4 = j5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
            j4 = jQ;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: q1.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShareTextsKt.k(modifier3, text, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Modifier modifier, String str, long j3, int i3, int i4, Composer composer, int i5) {
        j(modifier, str, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(androidx.compose.ui.Modifier r58, final java.lang.String r59, long r60, boolean r62, androidx.compose.runtime.Composer r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.sharing.images.components.ShareTextsKt.l(androidx.compose.ui.Modifier, java.lang.String, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Modifier modifier, String str, long j3, boolean z2, int i3, int i4, Composer composer, int i5) {
        l(modifier, str, j3, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void n(Modifier modifier, final String text, long j3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        long jQ0;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        Modifier modifier4;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(326749357);
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
            i5 |= composerK.Z(text) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                jQ0 = j3;
                if (composerK.f(jQ0)) {
                    i6 = Function.MAX_NARGS;
                }
                i5 |= i6;
            } else {
                jQ0 = j3;
            }
            i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            i5 |= i6;
        } else {
            jQ0 = j3;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
                if ((i4 & 4) != 0) {
                    jQ0 = ComposeColorsKt.j(composerK, 0).q0();
                    i5 &= -897;
                }
            } else {
                composerK.Q();
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                modifier4 = modifier2;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(326749357, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.images.components.ShareTitleText (ShareTexts.kt:30)");
            }
            int iA = TextAlign.f29616b.a();
            FontFamily fontFamily = f119429b;
            modifier3 = modifier4;
            composer2 = composerK;
            long j5 = jQ0;
            TextKt.c(text, modifier3, j5, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.i(162), FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.i(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.i(162), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null), composer2, ((i5 >> 3) & 14) | ((i5 << 3) & 112) | (i5 & 896), 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            j4 = j5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
            j4 = jQ0;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: q1.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShareTextsKt.o(modifier3, text, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Modifier modifier, String str, long j3, int i3, int i4, Composer composer, int i5) {
        n(modifier, str, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
