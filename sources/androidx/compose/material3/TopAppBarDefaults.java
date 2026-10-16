package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class TopAppBarDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TopAppBarDefaults f21543a = new TopAppBarDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f21544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f21545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f21546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f21547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f21548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21549g = 0;

    static {
        TopAppBarSmallTokens topAppBarSmallTokens = TopAppBarSmallTokens.f23609a;
        f21544b = topAppBarSmallTokens.b();
        f21545c = topAppBarSmallTokens.b();
        f21546d = TopAppBarMediumTokens.f23581a.b();
        f21547e = topAppBarSmallTokens.b();
        f21548f = TopAppBarLargeTokens.f23569a.b();
    }

    private TopAppBarDefaults() {
    }

    public final TopAppBarColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(513940029, i3, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1035)");
        }
        TopAppBarColors topAppBarColorsC = c(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return topAppBarColorsC;
    }

    public final TopAppBarScrollBehavior b(TopAppBarState topAppBarState, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Composer composer, int i3, int i4) {
        Composer composer2;
        if ((i4 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.C(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i4 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.TopAppBarDefaults$exitUntilCollapsedScrollBehavior$1
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            };
        }
        if ((i4 & 4) != 0) {
            animationSpec = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);
        }
        if ((i4 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.b(composer2, 0);
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1757023234, i3, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1252)");
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return exitUntilCollapsedScrollBehavior;
    }

    public final TopAppBarColors c(ColorScheme colorScheme) {
        TopAppBarColors topAppBarColorsG = colorScheme.g();
        if (topAppBarColorsG != null) {
            return topAppBarColorsG;
        }
        TopAppBarSmallCenteredTokens topAppBarSmallCenteredTokens = TopAppBarSmallCenteredTokens.f23593a;
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.g(colorScheme, topAppBarSmallCenteredTokens.a()), ColorSchemeKt.g(colorScheme, topAppBarSmallCenteredTokens.d()), ColorSchemeKt.g(colorScheme, topAppBarSmallCenteredTokens.c()), ColorSchemeKt.g(colorScheme, topAppBarSmallCenteredTokens.b()), ColorSchemeKt.g(colorScheme, topAppBarSmallCenteredTokens.e()), null);
        colorScheme.D0(topAppBarColors);
        return topAppBarColors;
    }

    public final TopAppBarColors d(ColorScheme colorScheme) {
        TopAppBarColors topAppBarColorsY = colorScheme.y();
        if (topAppBarColorsY != null) {
            return topAppBarColorsY;
        }
        TopAppBarLargeTokens topAppBarLargeTokens = TopAppBarLargeTokens.f23569a;
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.g(colorScheme, topAppBarLargeTokens.a()), ColorSchemeKt.g(colorScheme, TopAppBarSmallTokens.f23609a.f()), ColorSchemeKt.g(colorScheme, topAppBarLargeTokens.e()), ColorSchemeKt.g(colorScheme, topAppBarLargeTokens.c()), ColorSchemeKt.g(colorScheme, topAppBarLargeTokens.f()), null);
        colorScheme.V0(topAppBarColors);
        return topAppBarColors;
    }

    public final TopAppBarColors e(ColorScheme colorScheme) {
        TopAppBarColors topAppBarColorsZ = colorScheme.z();
        if (topAppBarColorsZ != null) {
            return topAppBarColorsZ;
        }
        TopAppBarMediumTokens topAppBarMediumTokens = TopAppBarMediumTokens.f23581a;
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.g(colorScheme, topAppBarMediumTokens.a()), ColorSchemeKt.g(colorScheme, TopAppBarSmallTokens.f23609a.f()), ColorSchemeKt.g(colorScheme, topAppBarMediumTokens.e()), ColorSchemeKt.g(colorScheme, topAppBarMediumTokens.c()), ColorSchemeKt.g(colorScheme, topAppBarMediumTokens.f()), null);
        colorScheme.W0(topAppBarColors);
        return topAppBarColors;
    }

    public final TopAppBarColors f(ColorScheme colorScheme) {
        TopAppBarColors topAppBarColorsQ = colorScheme.Q();
        if (topAppBarColorsQ != null) {
            return topAppBarColorsQ;
        }
        TopAppBarSmallTokens topAppBarSmallTokens = TopAppBarSmallTokens.f23609a;
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.g(colorScheme, topAppBarSmallTokens.a()), ColorSchemeKt.g(colorScheme, topAppBarSmallTokens.f()), ColorSchemeKt.g(colorScheme, topAppBarSmallTokens.e()), ColorSchemeKt.g(colorScheme, topAppBarSmallTokens.c()), ColorSchemeKt.g(colorScheme, topAppBarSmallTokens.g()), null);
        colorScheme.o1(topAppBarColors);
        return topAppBarColors;
    }

    public final float g() {
        return f21547e;
    }

    public final float h() {
        return f21548f;
    }

    public final float i() {
        return f21545c;
    }

    public final float j() {
        return f21546d;
    }

    public final float k() {
        return f21544b;
    }

    public final WindowInsets l(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2143182847, i3, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1025)");
        }
        WindowInsets windowInsetsA = SystemBarsDefaultInsets_androidKt.a(WindowInsets.f7172a, composer, 6);
        WindowInsetsSides.Companion companion = WindowInsetsSides.f7284b;
        WindowInsets windowInsetsI = WindowInsetsKt.i(windowInsetsA, WindowInsetsSides.r(companion.g(), companion.k()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowInsetsI;
    }

    public final TopAppBarColors m(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1744932393, i3, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1135)");
        }
        TopAppBarColors topAppBarColorsD = d(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return topAppBarColorsD;
    }

    public final TopAppBarColors n(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1268886463, i3, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1085)");
        }
        TopAppBarColors topAppBarColorsE = e(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return topAppBarColorsE;
    }

    public final TopAppBarColors o(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1388520854, i3, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:977)");
        }
        TopAppBarColors topAppBarColorsF = f(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return topAppBarColorsF;
    }

    public final TopAppBarColors p(long j3, long j4, long j5, long j6, long j7, Composer composer, int i3, int i4) {
        long jK = (i4 & 1) != 0 ? Color.f25715b.k() : j3;
        long jK2 = (i4 & 2) != 0 ? Color.f25715b.k() : j4;
        long jK3 = (i4 & 4) != 0 ? Color.f25715b.k() : j5;
        long jK4 = (i4 & 8) != 0 ? Color.f25715b.k() : j6;
        long jK5 = (i4 & 16) != 0 ? Color.f25715b.k() : j7;
        if (ComposerKt.M()) {
            ComposerKt.U(2142919275, i3, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:998)");
        }
        TopAppBarColors topAppBarColorsB = f(MaterialTheme.f18110a.a(composer, 6)).b(jK, jK2, jK3, jK4, jK5);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return topAppBarColorsB;
    }
}
