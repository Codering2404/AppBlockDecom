package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.facebook.ads.AdError;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

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
public final class DatePickerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DatePickerDefaults f16873a = new DatePickerDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final IntRange f16874b = new IntRange(1900, AdError.BROKEN_MEDIA_ERROR_CODE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f16875c = ElevationTokens.f22534a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SelectableDates f16876d = new SelectableDates() { // from class: androidx.compose.material3.DatePickerDefaults$AllDates$1
    };

    private DatePickerDefaults() {
    }

    public static /* synthetic */ DatePickerFormatter e(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "yMMMM";
        }
        if ((i3 & 2) != 0) {
            str2 = "yMMMd";
        }
        if ((i3 & 4) != 0) {
            str3 = "yMMMMEEEEd";
        }
        return datePickerDefaults.d(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final java.lang.Long r34, final int r35, final androidx.compose.material3.DatePickerFormatter r36, androidx.compose.ui.Modifier r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.a(java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(final int r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.b(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public final DatePickerColors c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-275219611, i3, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:432)");
        }
        DatePickerColors datePickerColorsG = g(MaterialTheme.f18110a.a(composer, 6), composer, (i3 << 3) & 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return datePickerColorsG;
    }

    public final DatePickerFormatter d(String str, String str2, String str3) {
        return new DatePickerFormatterImpl(str, str2, str3);
    }

    public final SelectableDates f() {
        return f16876d;
    }

    public final DatePickerColors g(ColorScheme colorScheme, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1180555308, i3, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:531)");
        }
        DatePickerColors datePickerColorsI = colorScheme.i();
        composer.a0(-653681037);
        if (datePickerColorsI == null) {
            DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.f22450a;
            DatePickerColors datePickerColors = new DatePickerColors(ColorSchemeKt.g(colorScheme, datePickerModalTokens.a()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.r()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.p()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.G()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.w()), colorScheme.e0(), ColorSchemeKt.g(colorScheme, datePickerModalTokens.F()), Color.r(ColorSchemeKt.g(colorScheme, datePickerModalTokens.F()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, datePickerModalTokens.m()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.D()), Color.r(ColorSchemeKt.g(colorScheme, datePickerModalTokens.D()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, datePickerModalTokens.C()), Color.r(ColorSchemeKt.g(colorScheme, datePickerModalTokens.C()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, datePickerModalTokens.n()), Color.r(ColorSchemeKt.g(colorScheme, datePickerModalTokens.n()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, datePickerModalTokens.h()), Color.r(ColorSchemeKt.g(colorScheme, datePickerModalTokens.h()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, datePickerModalTokens.g()), Color.r(ColorSchemeKt.g(colorScheme, datePickerModalTokens.g()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, datePickerModalTokens.m()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.k()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.t()), ColorSchemeKt.g(colorScheme, datePickerModalTokens.y()), ColorSchemeKt.g(colorScheme, DividerTokens.f22491a.a()), OutlinedTextFieldDefaults.f18898a.h(colorScheme, composer, (i3 & 14) | 48), null);
            colorScheme.F0(datePickerColors);
            datePickerColorsI = datePickerColors;
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return datePickerColorsI;
    }

    public final Shape h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(700927667, i3, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:734)");
        }
        Shape shapeE = ShapesKt.e(DatePickerModalTokens.f22450a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float i() {
        return f16875c;
    }

    public final IntRange j() {
        return f16874b;
    }

    public final FlingBehavior k(LazyListState lazyListState, DecayAnimationSpec decayAnimationSpec, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.c(0.0f, 0.0f, 3, null);
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-2036003494, i3, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:707)");
        }
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(lazyListState)) || (i3 & 6) == 4) | composer.Z(decayAnimationSpec);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            final SnapLayoutInfoProvider snapLayoutInfoProviderB = LazyListSnapLayoutInfoProviderKt.b(lazyListState, null, 2, null);
            objG = SnapFlingBehaviorKt.o(new SnapLayoutInfoProvider() { // from class: androidx.compose.material3.DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1
                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float a(float f3) {
                    return snapLayoutInfoProviderB.a(f3);
                }

                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float b(float f3, float f4) {
                    return 0.0f;
                }
            }, decayAnimationSpec, AnimationSpecKt.l(0.0f, 400.0f, null, 5, null));
            composer.w(objG);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return targetedFlingBehavior;
    }
}
