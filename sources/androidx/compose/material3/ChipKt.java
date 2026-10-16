package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ChipKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f16340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PaddingValues f16341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PaddingValues f16342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PaddingValues f16343d;

    static {
        float fG = Dp.g(8);
        f16340a = fG;
        f16341b = PaddingKt.c(fG, 0.0f, 2, null);
        f16342c = PaddingKt.c(fG, 0.0f, 2, null);
        f16343d = PaddingKt.c(fG, 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function0 r35, final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.foundation.BorderStroke r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 791
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.a(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void b(final kotlin.jvm.functions.Function0 r35, final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.material3.ChipBorder r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.b(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final Modifier modifier, final Function0 function0, final boolean z2, final Function2 function2, final TextStyle textStyle, final long j3, final Function2 function22, final Function2 function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f3, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i3, final int i4) {
        int i5;
        Function2 function24;
        int i6;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Composer composerK = composer.k(1400504719);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        int i7 = i3 & 384;
        int i8 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i7 == 0) {
            i5 |= composerK.b(z2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            function24 = function2;
            i5 |= composerK.I(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        int i9 = i3 & 24576;
        int i10 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (i9 == 0) {
            i5 |= composerK.Z(textStyle) ? 16384 : 8192;
        }
        if ((i3 & 196608) == 0) {
            i5 |= composerK.f(j3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.I(function22) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.I(function23) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.Z(shape) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.Z(chipColors) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.Z(chipElevation) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.Z(borderStroke) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            if (composerK.c(f3)) {
                i8 = 256;
            }
            i6 |= i8;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.Z(paddingValues) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            if (composerK.Z(mutableInteractionSource2)) {
                i10 = 16384;
            }
            i6 |= i10;
        }
        int i11 = i6;
        if ((i5 & 306783379) == 306783378 && (i11 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1400504719, i5, i11, "androidx.compose.material3.Chip (Chip.kt:1963)");
            }
            composerK.a0(1985614987);
            if (mutableInteractionSource2 == null) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = InteractionSourceKt.a();
                    composerK.w(objG);
                }
                mutableInteractionSource2 = (MutableInteractionSource) objG;
            }
            composerK.U();
            Modifier modifierF = SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.a());
                }
            }, 1, null);
            long jA = chipColors.a(z2);
            composerK.a0(1985624506);
            State stateF = chipElevation != null ? chipElevation.f(z2, mutableInteractionSource2, composerK, ((i5 >> 6) & 14) | ((i11 << 6) & 896)) : null;
            composerK.U();
            composer2 = composerK;
            int i12 = i5;
            final Function2 function25 = function24;
            SurfaceKt.d(function0, modifierF, z2, shape, jA, 0L, 0.0f, stateF != null ? ((Dp) stateF.getValue()).l() : Dp.g(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.e(-1985962652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i13) {
                    if ((i13 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1985962652, i13, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1976)");
                    }
                    ChipKt.d(function25, textStyle, j3, function22, null, function23, chipColors.c(z2), chipColors.d(z2), f3, paddingValues, composer3, 24576);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer2, ((i12 >> 15) & 7168) | ((i12 >> 3) & 14) | (i12 & 896) | ((i11 << 21) & 234881024), 6, 96);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i13) {
                    ChipKt.c(modifier, function0, z2, function2, textStyle, j3, function22, function23, shape, chipColors, chipElevation, borderStroke, f3, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final Function2 function2, final TextStyle textStyle, final long j3, final Function2 function22, final Function2 function23, final Function2 function24, final long j4, final long j5, final float f3, final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Function2 function25;
        Function2 function26;
        Function2 function27;
        long j6;
        long j7;
        Composer composerK = composer.k(-782878228);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(textStyle) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function25 = function22;
            i4 |= composerK.I(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i3 & 24576) == 0) {
            function26 = function23;
            i4 |= composerK.I(function26) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function26 = function23;
        }
        if ((196608 & i3) == 0) {
            function27 = function24;
            i4 |= composerK.I(function27) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function27 = function24;
        }
        if ((1572864 & i3) == 0) {
            j6 = j4;
            i4 |= composerK.f(j6) ? 1048576 : 524288;
        } else {
            j6 = j4;
        }
        if ((12582912 & i3) == 0) {
            j7 = j5;
            i4 |= composerK.f(j7) ? 8388608 : 4194304;
        } else {
            j7 = j5;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.c(f3) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i4 |= composerK.Z(paddingValues) ? 536870912 : 268435456;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-782878228, i4, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
            }
            final Function2 function28 = function25;
            final Function2 function29 = function26;
            final Function2 function210 = function27;
            final long j8 = j6;
            final long j9 = j7;
            CompositionLocalKt.c(new ProvidedValue[]{ContentColorKt.a().d(Color.n(j3)), TextKt.f().d(textStyle)}, ComposableLambdaKt.e(1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1748799148, i5, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2056)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Modifier modifierH = PaddingKt.h(SizeKt.b(companion, 0.0f, f3, 1, null), paddingValues);
                    AnonymousClass1 anonymousClass1 = new MeasurePolicy() { // from class: androidx.compose.material3.ChipKt$ChipContent$1.1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j10) {
                            Object obj;
                            Object obj2;
                            int size = list.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size) {
                                    obj = null;
                                    break;
                                }
                                obj = list.get(i6);
                                if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "leadingIcon")) {
                                    break;
                                }
                                i6++;
                            }
                            Measurable measurable = (Measurable) obj;
                            final Placeable placeableN0 = measurable != null ? measurable.n0(Constraints.d(j10, 0, 0, 0, 0, 10, null)) : null;
                            final int iV = TextFieldImplKt.v(placeableN0);
                            final int iT = TextFieldImplKt.t(placeableN0);
                            int size2 = list.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size2) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = list.get(i7);
                                if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj2), "trailingIcon")) {
                                    break;
                                }
                                i7++;
                            }
                            Measurable measurable2 = (Measurable) obj2;
                            Placeable placeableN02 = measurable2 != null ? measurable2.n0(Constraints.d(j10, 0, 0, 0, 0, 10, null)) : null;
                            int iV2 = TextFieldImplKt.v(placeableN02);
                            final int iT2 = TextFieldImplKt.t(placeableN02);
                            int size3 = list.size();
                            for (int i8 = 0; i8 < size3; i8++) {
                                Measurable measurable3 = (Measurable) list.get(i8);
                                if (Intrinsics.areEqual(LayoutIdKt.a(measurable3), "label")) {
                                    final Placeable placeableN03 = measurable3.n0(ConstraintsKt.j(j10, -(iV + iV2), 0, 2, null));
                                    int iX0 = placeableN03.X0() + iV + iV2;
                                    final int iMax = Math.max(iT, Math.max(placeableN03.O0(), iT2));
                                    final Placeable placeable = placeableN02;
                                    return MeasureScope.B0(measureScope, iX0, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ChipKt.ChipContent.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                            invoke((Placeable.PlacementScope) obj3);
                                            return Unit.f139807a;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope placementScope2;
                                            Placeable placeable2 = placeableN0;
                                            if (placeable2 != null) {
                                                Placeable.PlacementScope.m(placementScope, placeable2, 0, Alignment.f25072a.i().a(iT, iMax), 0.0f, 4, null);
                                                placementScope2 = placementScope;
                                            } else {
                                                placementScope2 = placementScope;
                                            }
                                            Placeable.PlacementScope.m(placementScope2, placeableN03, iV, 0, 0.0f, 4, null);
                                            Placeable placeable3 = placeable;
                                            if (placeable3 != null) {
                                                Placeable.PlacementScope.m(placementScope2, placeable3, iV + placeableN03.X0(), Alignment.f25072a.i().a(iT2, iMax), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    };
                    Function2 function211 = function29;
                    Function2 function212 = function28;
                    Function2 function213 = function210;
                    long j10 = j8;
                    Function2 function214 = function2;
                    long j11 = j9;
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, anonymousClass1, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    composer2.a0(-1293169671);
                    if (function211 != null || function212 != null) {
                        Modifier modifierB = LayoutIdKt.b(companion, "leadingIcon");
                        MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                        int iA2 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU2 = composer2.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierB);
                        Function0 function0A2 = companion2.a();
                        if (composer2.m() == null) {
                            ComposablesKt.c();
                        }
                        composer2.L();
                        if (composer2.i()) {
                            composer2.P(function0A2);
                        } else {
                            composer2.v();
                        }
                        Composer composerA2 = Updater.a(composer2);
                        Updater.e(composerA2, measurePolicyG, companion2.e());
                        Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                        Function2 function2B2 = companion2.b();
                        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                            composerA2.w(Integer.valueOf(iA2));
                            composerA2.p(Integer.valueOf(iA2), function2B2);
                        }
                        Updater.e(composerA2, modifierF2, companion2.f());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                        if (function211 != null) {
                            composer2.a0(832680499);
                            function211.invoke(composer2, 0);
                            composer2.U();
                        } else if (function212 != null) {
                            composer2.a0(832788565);
                            CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j10)), function212, composer2, ProvidedValue.f24012i);
                            composer2.U();
                        } else {
                            composer2.a0(833040347);
                            composer2.U();
                        }
                        composer2.y();
                    }
                    composer2.U();
                    Modifier modifierJ = PaddingKt.j(LayoutIdKt.b(companion, "label"), ChipKt.f16340a, Dp.g(0));
                    Arrangement.Horizontal horizontalG = Arrangement.f6574a.g();
                    Alignment.Companion companion3 = Alignment.f25072a;
                    MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion3.i(), composer2, 54);
                    int iA3 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU3 = composer2.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierJ);
                    Function0 function0A3 = companion2.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A3);
                    } else {
                        composer2.v();
                    }
                    Composer composerA3 = Updater.a(composer2);
                    Updater.e(composerA3, measurePolicyB, companion2.e());
                    Updater.e(composerA3, compositionLocalMapU3, companion2.g());
                    Function2 function2B3 = companion2.b();
                    if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                        composerA3.w(Integer.valueOf(iA3));
                        composerA3.p(Integer.valueOf(iA3), function2B3);
                    }
                    Updater.e(composerA3, modifierF3, companion2.f());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    function214.invoke(composer2, 0);
                    composer2.y();
                    composer2.a0(-1293135324);
                    if (function213 != null) {
                        Modifier modifierB2 = LayoutIdKt.b(companion, "trailingIcon");
                        MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.e(), false);
                        int iA4 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU4 = composer2.u();
                        Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierB2);
                        Function0 function0A4 = companion2.a();
                        if (composer2.m() == null) {
                            ComposablesKt.c();
                        }
                        composer2.L();
                        if (composer2.i()) {
                            composer2.P(function0A4);
                        } else {
                            composer2.v();
                        }
                        Composer composerA4 = Updater.a(composer2);
                        Updater.e(composerA4, measurePolicyG2, companion2.e());
                        Updater.e(composerA4, compositionLocalMapU4, companion2.g());
                        Function2 function2B4 = companion2.b();
                        if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                            composerA4.w(Integer.valueOf(iA4));
                            composerA4.p(Integer.valueOf(iA4), function2B4);
                        }
                        Updater.e(composerA4, modifierF4, companion2.f());
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                        CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j11)), function213, composer2, ProvidedValue.f24012i);
                        composer2.y();
                    }
                    composer2.U();
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ChipKt.d(function2, textStyle, j3, function22, function23, function24, j4, j5, f3, paddingValues, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final kotlin.jvm.functions.Function0 r35, final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.foundation.BorderStroke r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 765
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.e(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void f(final kotlin.jvm.functions.Function0 r35, final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.material3.ChipBorder r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 809
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.f(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final boolean r36, final kotlin.jvm.functions.Function0 r37, final kotlin.jvm.functions.Function2 r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2 r41, kotlin.jvm.functions.Function2 r42, androidx.compose.ui.graphics.Shape r43, androidx.compose.material3.SelectableChipColors r44, androidx.compose.material3.SelectableChipElevation r45, androidx.compose.foundation.BorderStroke r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.g(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.h(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void i(final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 733
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.i(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(final boolean r41, final kotlin.jvm.functions.Function0 r42, final kotlin.jvm.functions.Function2 r43, androidx.compose.ui.Modifier r44, boolean r45, kotlin.jvm.functions.Function2 r46, kotlin.jvm.functions.Function2 r47, androidx.compose.ui.graphics.Shape r48, androidx.compose.material3.SelectableChipColors r49, androidx.compose.material3.SelectableChipElevation r50, androidx.compose.foundation.BorderStroke r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 863
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.j(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final boolean r42, final kotlin.jvm.functions.Function0 r43, final kotlin.jvm.functions.Function2 r44, androidx.compose.ui.Modifier r45, boolean r46, kotlin.jvm.functions.Function2 r47, kotlin.jvm.functions.Function2 r48, kotlin.jvm.functions.Function2 r49, androidx.compose.ui.graphics.Shape r50, androidx.compose.material3.SelectableChipColors r51, androidx.compose.material3.SelectableChipElevation r52, androidx.compose.foundation.BorderStroke r53, androidx.compose.foundation.interaction.MutableInteractionSource r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instruction units count: 964
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.k(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final boolean z2, final Modifier modifier, final Function0 function0, final boolean z3, final Function2 function2, final TextStyle textStyle, final Function2 function22, final Function2 function23, final Function2 function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f3, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        Composer composerK = composer.k(402951308);
        if ((i3 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        int i7 = i3 & 384;
        int i8 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i7 == 0) {
            i5 |= composerK.I(function0) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z3) ? 2048 : 1024;
        }
        int i9 = i3 & 24576;
        int i10 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (i9 == 0) {
            i5 |= composerK.I(function2) ? 16384 : 8192;
        }
        int i11 = i3 & 196608;
        int i12 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        if (i11 == 0) {
            i5 |= composerK.Z(textStyle) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.I(function22) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.I(function23) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.I(function24) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.Z(shape) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.Z(selectableChipColors) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.Z(selectableChipElevation) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            if (composerK.Z(borderStroke)) {
                i8 = 256;
            }
            i6 |= i8;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            if (composerK.Z(paddingValues)) {
                i10 = 16384;
            }
            i6 |= i10;
        }
        if ((i4 & 196608) == 0) {
            if (composerK.Z(mutableInteractionSource)) {
                i12 = 131072;
            }
            i6 |= i12;
        }
        int i13 = i6;
        if ((i5 & 306783379) == 306783378 && (74899 & i13) == 74898 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(402951308, i5, i13, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
            }
            composerK.a0(2072749057);
            if (mutableInteractionSource == null) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = InteractionSourceKt.a();
                    composerK.w(objG);
                }
                mutableInteractionSource2 = (MutableInteractionSource) objG;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
            }
            composerK.U();
            int i14 = i5;
            Modifier modifierF = SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.c());
                }
            }, 1, null);
            long jA = selectableChipColors.a(z3, z2);
            composerK.a0(2072762384);
            State stateF = selectableChipElevation != null ? selectableChipElevation.f(z3, mutableInteractionSource2, composerK, ((i14 >> 9) & 14) | ((i13 << 3) & 896)) : null;
            composerK.U();
            composer2 = composerK;
            SurfaceKt.b(z2, function0, modifierF, z3, shape, jA, 0L, 0.0f, stateF != null ? ((Dp) stateF.getValue()).l() : Dp.g(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.e(-577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i15) {
                    if ((i15 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-577614814, i15, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2024)");
                    }
                    ChipKt.d(function2, textStyle, selectableChipColors.b(z3, z2), function22, function23, function24, selectableChipColors.c(z3, z2), selectableChipColors.d(z3, z2), f3, paddingValues, composer3, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer2, (i14 & 14) | ((i14 >> 3) & 112) | (i14 & 7168) | ((i14 >> 15) & 57344) | ((i13 << 21) & 1879048192), 48, 192);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i15) {
                    ChipKt.l(z2, modifier, function0, z3, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f3, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.m(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void n(final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.n(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ChipColors s(ColorScheme colorScheme) {
        ChipColors chipColorsL = colorScheme.L();
        if (chipColorsL != null) {
            return chipColorsL;
        }
        Color.Companion companion = Color.f25715b;
        long j3 = companion.j();
        SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.f23441a;
        ChipColors chipColors = new ChipColors(j3, ColorSchemeKt.g(colorScheme, suggestionChipTokens.t()), ColorSchemeKt.g(colorScheme, suggestionChipTokens.v()), companion.k(), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, suggestionChipTokens.c()), suggestionChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, suggestionChipTokens.e()), suggestionChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), companion.k(), null);
        colorScheme.j1(chipColors);
        return chipColors;
    }

    private static final PaddingValues t(boolean z2, boolean z3, boolean z4) {
        return PaddingKt.e(Dp.g((z2 || !z3) ? 4 : 8), 0.0f, Dp.g(z4 ? 8 : 4), 0.0f, 10, null);
    }
}
