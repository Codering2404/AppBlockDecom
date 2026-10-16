package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TabKt;
import androidx.compose.material.TabPosition;
import androidx.compose.material.TabRowDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class ChipKt {
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(final androidx.compose.foundation.layout.RowScope r27, final java.lang.String r28, final boolean r29, kotlin.jvm.functions.Function0 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ChipKt.j(androidx.compose.foundation.layout.RowScope, java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    private static final long l(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(boolean z2, String str, RowScope Chip, Composer composer, int i3) {
        long jP;
        Intrinsics.checkNotNullParameter(Chip, "$this$Chip");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(388849388, i3, -1, "cz.mobilesoft.coreblock.view.compose.Chip.<anonymous> (Chip.kt:63)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            int iA = TextAlign.f29616b.a();
            TextStyle textStyleJ = ComposeTypographyKt.g(composer, 0).j();
            int iB = TextOverflow.f29661b.b();
            if (z2) {
                composer.a0(22117809);
                jP = ComposeColorsKt.j(composer, 0).q0();
            } else {
                composer.a0(22118392);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            androidx.compose.material.TextKt.c(str, modifierH, jP, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, iB, false, 1, 0, null, textStyleJ, composer, 48, 3120, 54776);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(RowScope rowScope, String str, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        j(rowScope, str, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void o(androidx.compose.ui.Modifier r27, boolean r28, float r29, final java.util.List r30, final int r31, long r32, final kotlin.jvm.functions.Function2 r34, kotlin.jvm.functions.Function2 r35, final kotlin.jvm.functions.Function3 r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ChipKt.o(androidx.compose.ui.Modifier, boolean, float, java.util.List, int, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i3, Object obj) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i3, float f3, List list, List tabPositions, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        if (ComposerKt.M()) {
            ComposerKt.U(1915710225, i4, -1, "cz.mobilesoft.coreblock.view.compose.SelectableChipRow.<anonymous> (Chip.kt:105)");
        }
        Modifier modifierE = TabRowDefaults.f14549a.e(Modifier.b8, (TabPosition) tabPositions.get(i3));
        float fG = i3 == 0 ? Dp.g(0) : f3;
        if (i3 == list.size() - 1) {
            f3 = Dp.g(0);
        }
        BoxKt.a(BackgroundKt.c(SizeKt.f(PaddingKt.m(modifierE, fG, 0.0f, f3, 0.0f, 10, null), 0.0f, 1, null), ComposeColorsKt.j(composer, 0).b(), RoundedCornerShapeKt.a(50)), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(List list, int i3, float f3, final boolean z2, final Function2 function2, final Function2 function22, final Function3 function3, Composer composer, int i4) {
        Composer composer2 = composer;
        if (composer2.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1874140433, i4, -1, "cz.mobilesoft.coreblock.view.compose.SelectableChipRow.<anonymous> (Chip.kt:120)");
            }
            final int i5 = 0;
            for (final Object obj : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final boolean z3 = i5 == i3;
                Modifier modifierA = ClipKt.a(PaddingKt.m(ZIndexModifierKt.a(Modifier.b8, 1.0f), i5 == 0 ? Dp.g(0) : f3, 0.0f, i5 == list.size() - 1 ? Dp.g(0) : f3, 0.0f, 10, null), RoundedCornerShapeKt.a(50));
                boolean zB = composer2.b(z2) | composer2.Z(function2) | composer2.e(i5) | composer2.I(obj) | composer2.Z(function22);
                Object objG = composer2.G();
                if (zB || objG == Composer.f23746a.a()) {
                    Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChipKt.s(z2, function2, i5, obj, function22);
                        }
                    };
                    composer2.w(function0);
                    objG = function0;
                }
                TabKt.c(z3, (Function0) objG, modifierA, false, null, 0L, 0L, ComposableLambdaKt.e(-1091557807, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return ChipKt.t(function3, obj, z3, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, 12582912, 120);
                composer2 = composer;
                i5 = i6;
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
    public static final Unit s(boolean z2, Function2 function2, int i3, Object obj, Function2 function22) {
        if (z2) {
            function2.invoke(Integer.valueOf(i3), obj);
        } else {
            function22.invoke(Integer.valueOf(i3), obj);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function3 function3, Object obj, boolean z2, ColumnScope Tab, Composer composer, int i3) {
        long jP;
        Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1091557807, i3, -1, "cz.mobilesoft.coreblock.view.compose.SelectableChipRow.<anonymous>.<anonymous>.<anonymous> (Chip.kt:139)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            String str = (String) function3.invoke(obj, composer, 0);
            int iA = TextAlign.f29616b.a();
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            int iB = TextOverflow.f29661b.b();
            if (z2) {
                composer.a0(-1015019050);
                jP = ComposeColorsKt.j(composer, 0).q0();
            } else {
                composer.a0(-1015018467);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            androidx.compose.material.TextKt.c(str, modifierH, jP, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, iB, false, 1, 0, null, textStyleI, composer, 48, 3120, 54776);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Modifier modifier, boolean z2, float f3, List list, int i3, long j3, Function2 function2, Function2 function22, Function3 function3, int i4, int i5, Composer composer, int i6) {
        o(modifier, z2, f3, list, i3, j3, function2, function22, function3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }
}
