package cz.mobilesoft.coreblock.scene.premium;

import android.content.Context;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.components.PremiumTrialTimelineKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumScreenKt {
    private static final void A(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Density density, MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        w(mutableState, density.F((int) (coordinates.a() & 4294967295L)));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void C(boolean r22, int r23, boolean r24, boolean r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt.C(boolean, int, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(int i3, boolean z2, Composer composer, int i4) {
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(550397090, i4, -1, "cz.mobilesoft.coreblock.scene.premium.TrialContent.<anonymous> (PremiumScreen.kt:225)");
            }
            PremiumTrialTimelineKt.k(PaddingKt.k(Modifier.b8, 0.0f, Dp.g(16), 1, null), ComposeColorsKt.j(composer, 0).l0(), i3, true, z2, false, composer, 3078, 32);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(boolean z2, int i3, boolean z3, boolean z4, int i4, int i5, Composer composer, int i6) {
        C(z2, i3, z3, z4, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final kotlin.jvm.functions.Function1 r22, java.lang.String r23, java.lang.String r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt.k(kotlin.jvm.functions.Function1, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1) {
        function1.invoke(PremiumScreenViewEvent.OnTryAgain.f112363a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1, String str, String str2, int i3, int i4, Composer composer, int i5) {
        k(function1, str, str2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(final androidx.compose.foundation.layout.PaddingValues r32, kotlin.jvm.functions.Function2 r33, final kotlin.jvm.functions.Function3 r34, final kotlin.jvm.functions.Function2 r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt.n(androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(PaddingValues paddingValues, Function2 function2, Function3 function3, Function2 function22, int i3, int i4, Composer composer, int i5) {
        n(paddingValues, function2, function3, function22, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void p(final ColumnScope columnScope, final PremiumScreenViewState viewState, final Function1 onEvent, Function3 function3, final Function3 mainContent, Composer composer, final int i3, final int i4) {
        int i5;
        final Function3 function32;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(mainContent, "mainContent");
        Composer composerK = composer.k(-75034253);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(mainContent) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            Function3 function3D = i6 != 0 ? ComposableSingletons$PremiumScreenKt.f112338a.d() : function3;
            if (ComposerKt.M()) {
                ComposerKt.U(-75034253, i5, -1, "cz.mobilesoft.coreblock.scene.premium.PremiumScreenContent (PremiumScreen.kt:186)");
            }
            int i7 = i5 & 14;
            int i8 = i5 >> 6;
            function3D.invoke(columnScope, composerK, Integer.valueOf((i8 & 112) | i7));
            if (viewState.E()) {
                composerK.a0(-1962138051);
                Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
                k(onEvent, viewState.k(context), viewState.i(context), composerK, i8 & 14, 0);
                composerK.U();
            } else if (viewState.H()) {
                composerK.a0(-1961832515);
                SchedulesSectionKt.D(0.0f, 0, composerK, 0, 3);
                composerK.U();
            } else {
                if (viewState.G()) {
                    composerK.a0(-1961651382);
                    mainContent.invoke(columnScope, composerK, Integer.valueOf(((i5 >> 9) & 112) | i7));
                } else {
                    composerK.a0(-1969389137);
                }
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function32 = function3D;
        } else {
            composerK.Q();
            function32 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumScreenKt.q(columnScope, viewState, onEvent, function32, mainContent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(ColumnScope columnScope, PremiumScreenViewState premiumScreenViewState, Function1 function1, Function3 function3, Function3 function32, int i3, int i4, Composer composer, int i5) {
        p(columnScope, premiumScreenViewState, function1, function3, function32, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(final androidx.compose.foundation.layout.PaddingValues r36, kotlin.jvm.functions.Function2 r37, final kotlin.jvm.functions.Function3 r38, final kotlin.jvm.functions.Function3 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt.r(androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float s(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Density density, MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        A(mutableState, density.F((int) (coordinates.a() & 4294967295L)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Density density, MutableState mutableState, float f3, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        float f4 = 0;
        if (Dp.i(x(mutableState), Dp.g(f4)) && ((int) (coordinates.a() & 4294967295L)) > 0) {
            y(mutableState, ((Dp) RangesKt.h(Dp.d(Dp.g(Dp.g(density.F((int) (coordinates.a() & 4294967295L)) - Dp.g(16)) - Dp.g(f3 * 1.5f))), Dp.d(Dp.g(f4)))).l());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(PaddingValues paddingValues, Function2 function2, Function3 function3, Function3 function32, int i3, int i4, Composer composer, int i5) {
        r(paddingValues, function2, function3, function32, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void w(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float x(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    private static final void y(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float z(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }
}
