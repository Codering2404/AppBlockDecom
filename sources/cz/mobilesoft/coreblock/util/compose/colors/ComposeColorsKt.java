package cz.mobilesoft.coreblock.util.compose.colors;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.CheckboxColors;
import androidx.compose.material.CheckboxDefaults;
import androidx.compose.material.SwitchColors;
import androidx.compose.material.SwitchDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public final class ComposeColorsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f128413a = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.compose.colors.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ComposeColorsKt.d();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f128414b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.compose.colors.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ComposeColorsKt.c();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockColorPaletteDark c() {
        return new AppBlockColorPaletteDark();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockColorPalette d() {
        return new AppBlockColorPalette();
    }

    public static final AppBlockColorPaletteDark e() {
        return (AppBlockColorPaletteDark) f128414b.getValue();
    }

    public static final AppBlockColorPalette f() {
        return (AppBlockColorPalette) f128413a.getValue();
    }

    public static final CheckboxColors g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2139058019, i3, -1, "cz.mobilesoft.coreblock.util.compose.colors.<get-checkboxColors> (ComposeColors.kt:31)");
        }
        CheckboxColors checkboxColorsA = CheckboxDefaults.f12358a.a(j(composer, 0).b(), j(composer, 0).O(), j(composer, 0).l0(), j(composer, 0).M(), 0L, composer, CheckboxDefaults.f12359b << 15, 16);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return checkboxColorsA;
    }

    public static final androidx.compose.material3.CheckboxColors h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1894167451, i3, -1, "cz.mobilesoft.coreblock.util.compose.colors.<get-checkboxColorsMaterial3> (ComposeColors.kt:40)");
        }
        androidx.compose.material3.CheckboxColors checkboxColorsB = androidx.compose.material3.CheckboxDefaults.f16275a.b(j(composer, 0).b(), j(composer, 0).O(), j(composer, 0).l0(), j(composer, 0).M(), 0L, 0L, composer, androidx.compose.material3.CheckboxDefaults.f16276b << 18, 48);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return checkboxColorsB;
    }

    public static final SwitchColors i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1345206346, i3, -1, "cz.mobilesoft.coreblock.util.compose.colors.<get-clickableDisabledSwitchColors> (ComposeColors.kt:62)");
        }
        SwitchColors switchColorsA = SwitchDefaults.f14418a.a(ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), 0.0f, ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), 0.0f, ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), composer, 0, SwitchDefaults.f14419b, 36);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return switchColorsA;
    }

    public static final AppBlockColorPalette j(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(184825004, i3, -1, "cz.mobilesoft.coreblock.util.compose.colors.<get-colors> (ComposeColors.kt:27)");
        }
        AppBlockColorPalette appBlockColorPaletteE = DarkThemeKt.a(composer, 0) ? e() : f();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return appBlockColorPaletteE;
    }

    public static final Brush k(AppBlockColorPalette appBlockColorPalette) {
        Intrinsics.checkNotNullParameter(appBlockColorPalette, "<this>");
        return Brush.Companion.n(Brush.Companion, new Pair[]{TuplesKt.a(Float.valueOf(0.0f), Color.n(Color.r(appBlockColorPalette.V(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.a(Float.valueOf(0.19f), Color.n(Color.r(appBlockColorPalette.V(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.a(Float.valueOf(0.44f), Color.n(appBlockColorPalette.e())), TuplesKt.a(Float.valueOf(1.0f), Color.n(appBlockColorPalette.e()))}, 0.0f, 0.0f, 0, 14, null);
    }

    public static final Brush l(AppBlockColorPalette appBlockColorPalette) {
        Intrinsics.checkNotNullParameter(appBlockColorPalette, "<this>");
        return Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(appBlockColorPalette.i0()), Color.n(appBlockColorPalette.h0())}), 0.0f, 0.0f, 0, 14, null);
    }

    public static final SwitchColors m(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1545623948, i3, -1, "cz.mobilesoft.coreblock.util.compose.colors.<get-switchColors> (ComposeColors.kt:49)");
        }
        SwitchColors switchColorsA = SwitchDefaults.f14418a.a(j(composer, 0).b(), Color.r(j(composer, 0).b(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, Color.f25715b.l(), j(composer, 0).M(), 0.0f, ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), composer, 3072, SwitchDefaults.f14419b, 36);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return switchColorsA;
    }

    public static final SwitchColors n(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(934176616, i3, -1, "cz.mobilesoft.coreblock.util.compose.colors.<get-switchWaringColors> (ComposeColors.kt:75)");
        }
        SwitchDefaults switchDefaults = SwitchDefaults.f14418a;
        Color.Companion companion = Color.f25715b;
        SwitchColors switchColorsA = switchDefaults.a(companion.l(), j(composer, 0).c0(), 0.0f, companion.l(), j(composer, 0).M(), 0.0f, ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), ColorKt.h(j(composer, 0).M(), j(composer, 0).l0()), j(composer, 0).N(), composer, 3078, SwitchDefaults.f14419b, 36);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return switchColorsA;
    }
}
