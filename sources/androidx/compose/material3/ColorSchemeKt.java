package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ColorSchemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f16667a = CompositionLocalKt.g(new Function0<ColorScheme>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ColorScheme invoke() {
            return ColorSchemeKt.k(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f16668b = CompositionLocalKt.g(new Function0<Boolean>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalTonalElevationEnabled$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16671a;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            f16671a = iArr;
        }
    }

    public static final long a(ColorScheme colorScheme, long j3, float f3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1610977682, i3, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        boolean zBooleanValue = ((Boolean) composer.q(f16668b)).booleanValue();
        if (Color.t(j3, colorScheme.o0()) && zBooleanValue) {
            j3 = l(colorScheme, f3);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return j3;
    }

    public static final long b(ColorScheme colorScheme, long j3) {
        return Color.t(j3, colorScheme.j0()) ? colorScheme.Z() : Color.t(j3, colorScheme.m0()) ? colorScheme.b0() : Color.t(j3, colorScheme.y0()) ? colorScheme.f0() : Color.t(j3, colorScheme.c()) ? colorScheme.W() : Color.t(j3, colorScheme.R()) ? colorScheme.X() : Color.t(j3, colorScheme.k0()) ? colorScheme.a0() : Color.t(j3, colorScheme.n0()) ? colorScheme.c0() : Color.t(j3, colorScheme.z0()) ? colorScheme.g0() : Color.t(j3, colorScheme.S()) ? colorScheme.Y() : Color.t(j3, colorScheme.V()) ? colorScheme.T() : Color.t(j3, colorScheme.o0()) ? colorScheme.d0() : Color.t(j3, colorScheme.x0()) ? colorScheme.e0() : Color.t(j3, colorScheme.p0()) ? colorScheme.d0() : Color.t(j3, colorScheme.q0()) ? colorScheme.d0() : Color.t(j3, colorScheme.r0()) ? colorScheme.d0() : Color.t(j3, colorScheme.s0()) ? colorScheme.d0() : Color.t(j3, colorScheme.t0()) ? colorScheme.d0() : Color.t(j3, colorScheme.u0()) ? colorScheme.d0() : Color.f25715b.k();
    }

    public static final long c(long j3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(509589638, i3, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.a0(-1680936624);
        long jB = b(MaterialTheme.f18110a.a(composer, 6), j3);
        if (jB == 16) {
            jB = ((Color) composer.q(ContentColorKt.a())).B();
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jB;
    }

    public static final ColorScheme d(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38) {
        return new ColorScheme(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j38, j33, j34, j35, j36, j37, null);
    }

    public static /* synthetic */ ColorScheme e(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, int i3, int i4, Object obj) {
        long jT = (i3 & 1) != 0 ? ColorDarkTokens.f22360a.t() : j3;
        long j39 = (i3 & 2) != 0 ? ColorDarkTokens.f22360a.j() : j4;
        long jU = (i3 & 4) != 0 ? ColorDarkTokens.f22360a.u() : j5;
        long jK = (i3 & 8) != 0 ? ColorDarkTokens.f22360a.k() : j6;
        long jE = (i3 & 16) != 0 ? ColorDarkTokens.f22360a.e() : j7;
        long jW = (i3 & 32) != 0 ? ColorDarkTokens.f22360a.w() : j8;
        long jL = (i3 & 64) != 0 ? ColorDarkTokens.f22360a.l() : j9;
        long jX = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ColorDarkTokens.f22360a.x() : j10;
        long j40 = jT;
        long jM = (i3 & Function.MAX_NARGS) != 0 ? ColorDarkTokens.f22360a.m() : j11;
        long jH = (i3 & 512) != 0 ? ColorDarkTokens.f22360a.H() : j12;
        long jP = (i3 & 1024) != 0 ? ColorDarkTokens.f22360a.p() : j13;
        long jI = (i3 & 2048) != 0 ? ColorDarkTokens.f22360a.I() : j14;
        long jQ = (i3 & 4096) != 0 ? ColorDarkTokens.f22360a.q() : j15;
        long jA = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? ColorDarkTokens.f22360a.a() : j16;
        long jG = (i3 & 16384) != 0 ? ColorDarkTokens.f22360a.g() : j17;
        long jY = (i3 & 32768) != 0 ? ColorDarkTokens.f22360a.y() : j18;
        long jN = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? ColorDarkTokens.f22360a.n() : j19;
        long jG2 = (i3 & 131072) != 0 ? ColorDarkTokens.f22360a.G() : j20;
        long jO = (i3 & 262144) != 0 ? ColorDarkTokens.f22360a.o() : j21;
        long j41 = (i3 & 524288) != 0 ? j40 : j22;
        long jF = (i3 & 1048576) != 0 ? ColorDarkTokens.f22360a.f() : j23;
        long jD = (i3 & 2097152) != 0 ? ColorDarkTokens.f22360a.d() : j24;
        long jB = (i3 & 4194304) != 0 ? ColorDarkTokens.f22360a.b() : j25;
        long jH2 = (i3 & 8388608) != 0 ? ColorDarkTokens.f22360a.h() : j26;
        long jC = (i3 & 16777216) != 0 ? ColorDarkTokens.f22360a.c() : j27;
        long jI2 = (i3 & 33554432) != 0 ? ColorDarkTokens.f22360a.i() : j28;
        long jR = (i3 & 67108864) != 0 ? ColorDarkTokens.f22360a.r() : j29;
        long jS = (i3 & 134217728) != 0 ? ColorDarkTokens.f22360a.s() : j30;
        long jV = (i3 & 268435456) != 0 ? ColorDarkTokens.f22360a.v() : j31;
        long jZ = (i3 & 536870912) != 0 ? ColorDarkTokens.f22360a.z() : j32;
        long jA2 = (i3 & 1073741824) != 0 ? ColorDarkTokens.f22360a.A() : j33;
        long jB2 = (i3 & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.f22360a.B() : j34;
        long jC2 = (i4 & 1) != 0 ? ColorDarkTokens.f22360a.C() : j35;
        long jD2 = (i4 & 2) != 0 ? ColorDarkTokens.f22360a.D() : j36;
        long jE2 = (i4 & 4) != 0 ? ColorDarkTokens.f22360a.E() : j37;
        if ((i4 & 8) != 0) {
            j38 = ColorDarkTokens.f22360a.F();
        }
        return d(j40, j39, jU, jK, jE, jW, jL, jX, jM, jH, jP, jI, jQ, jA, jG, jY, jN, jG2, jO, j41, jF, jD, jB, jH2, jC, jI2, jR, jS, jV, jZ, jA2, jB2, jC2, jD2, jE2, j38);
    }

    public static final ColorScheme f() {
        PaletteTokens paletteTokens = PaletteTokens.f23190a;
        return k(0L, 0L, 0L, paletteTokens.W(), 0L, 0L, 0L, 0L, paletteTokens.j0(), 0L, 0L, 0L, paletteTokens.j0(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -4361, 15, null);
    }

    public static final long g(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.f16671a[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.c();
            case 2:
                return colorScheme.R();
            case 3:
                return colorScheme.S();
            case 4:
                return colorScheme.T();
            case 5:
                return colorScheme.U();
            case 6:
                return colorScheme.V();
            case 7:
                return colorScheme.W();
            case 8:
                return colorScheme.X();
            case 9:
                return colorScheme.Y();
            case 10:
                return colorScheme.Z();
            case 11:
                return colorScheme.a0();
            case 12:
                return colorScheme.b0();
            case 13:
                return colorScheme.c0();
            case 14:
                return colorScheme.d0();
            case 15:
                return colorScheme.e0();
            case 16:
                return colorScheme.w0();
            case 17:
                return colorScheme.f0();
            case 18:
                return colorScheme.g0();
            case 19:
                return colorScheme.h0();
            case 20:
                return colorScheme.i0();
            case 21:
                return colorScheme.j0();
            case 22:
                return colorScheme.k0();
            case 23:
                return colorScheme.l0();
            case 24:
                return colorScheme.m0();
            case 25:
                return colorScheme.n0();
            case 26:
                return colorScheme.o0();
            case 27:
                return colorScheme.x0();
            case 28:
                return colorScheme.p0();
            case 29:
                return colorScheme.q0();
            case 30:
                return colorScheme.r0();
            case 31:
                return colorScheme.s0();
            case 32:
                return colorScheme.t0();
            case 33:
                return colorScheme.u0();
            case 34:
                return colorScheme.v0();
            case 35:
                return colorScheme.y0();
            case 36:
                return colorScheme.z0();
            default:
                return Color.f25715b.k();
        }
    }

    public static final ProvidableCompositionLocal h() {
        return f16667a;
    }

    public static final long i(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-810780884, i3, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long jG = g(MaterialTheme.f18110a.a(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jG;
    }

    public static final ColorScheme j(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38) {
        return new ColorScheme(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j38, j33, j34, j35, j36, j37, null);
    }

    public static /* synthetic */ ColorScheme k(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, int i3, int i4, Object obj) {
        long jT = (i3 & 1) != 0 ? ColorLightTokens.f22386a.t() : j3;
        long j39 = (i3 & 2) != 0 ? ColorLightTokens.f22386a.j() : j4;
        long jU = (i3 & 4) != 0 ? ColorLightTokens.f22386a.u() : j5;
        long jK = (i3 & 8) != 0 ? ColorLightTokens.f22386a.k() : j6;
        long jE = (i3 & 16) != 0 ? ColorLightTokens.f22386a.e() : j7;
        long jW = (i3 & 32) != 0 ? ColorLightTokens.f22386a.w() : j8;
        long jL = (i3 & 64) != 0 ? ColorLightTokens.f22386a.l() : j9;
        long jX = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ColorLightTokens.f22386a.x() : j10;
        long j40 = jT;
        long jM = (i3 & Function.MAX_NARGS) != 0 ? ColorLightTokens.f22386a.m() : j11;
        long jH = (i3 & 512) != 0 ? ColorLightTokens.f22386a.H() : j12;
        long jP = (i3 & 1024) != 0 ? ColorLightTokens.f22386a.p() : j13;
        long jI = (i3 & 2048) != 0 ? ColorLightTokens.f22386a.I() : j14;
        long jQ = (i3 & 4096) != 0 ? ColorLightTokens.f22386a.q() : j15;
        long jA = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? ColorLightTokens.f22386a.a() : j16;
        long jG = (i3 & 16384) != 0 ? ColorLightTokens.f22386a.g() : j17;
        long jY = (i3 & 32768) != 0 ? ColorLightTokens.f22386a.y() : j18;
        long jN = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? ColorLightTokens.f22386a.n() : j19;
        long jG2 = (i3 & 131072) != 0 ? ColorLightTokens.f22386a.G() : j20;
        long jO = (i3 & 262144) != 0 ? ColorLightTokens.f22386a.o() : j21;
        long j41 = (i3 & 524288) != 0 ? j40 : j22;
        long jF = (i3 & 1048576) != 0 ? ColorLightTokens.f22386a.f() : j23;
        long jD = (i3 & 2097152) != 0 ? ColorLightTokens.f22386a.d() : j24;
        long jB = (i3 & 4194304) != 0 ? ColorLightTokens.f22386a.b() : j25;
        long jH2 = (i3 & 8388608) != 0 ? ColorLightTokens.f22386a.h() : j26;
        long jC = (i3 & 16777216) != 0 ? ColorLightTokens.f22386a.c() : j27;
        long jI2 = (i3 & 33554432) != 0 ? ColorLightTokens.f22386a.i() : j28;
        long jR = (i3 & 67108864) != 0 ? ColorLightTokens.f22386a.r() : j29;
        long jS = (i3 & 134217728) != 0 ? ColorLightTokens.f22386a.s() : j30;
        long jV = (i3 & 268435456) != 0 ? ColorLightTokens.f22386a.v() : j31;
        long jZ = (i3 & 536870912) != 0 ? ColorLightTokens.f22386a.z() : j32;
        long jA2 = (i3 & 1073741824) != 0 ? ColorLightTokens.f22386a.A() : j33;
        long jB2 = (i3 & Integer.MIN_VALUE) != 0 ? ColorLightTokens.f22386a.B() : j34;
        long jC2 = (i4 & 1) != 0 ? ColorLightTokens.f22386a.C() : j35;
        long jD2 = (i4 & 2) != 0 ? ColorLightTokens.f22386a.D() : j36;
        long jE2 = (i4 & 4) != 0 ? ColorLightTokens.f22386a.E() : j37;
        if ((i4 & 8) != 0) {
            j38 = ColorLightTokens.f22386a.F();
        }
        return j(j40, j39, jU, jK, jE, jW, jL, jX, jM, jH, jP, jI, jQ, jA, jG, jY, jN, jG2, jO, j41, jF, jD, jB, jH2, jC, jI2, jR, jS, jV, jZ, jA2, jB2, jC2, jD2, jE2, j38);
    }

    public static final long l(ColorScheme colorScheme, float f3) {
        if (Dp.i(f3, Dp.g(0))) {
            return colorScheme.o0();
        }
        return ColorKt.h(Color.r(colorScheme.w0(), ((((float) Math.log(f3 + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0());
    }
}
