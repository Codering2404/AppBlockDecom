package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

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
public final class ExposedDropdownMenu_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f17632a = Dp.g(16);

    /* JADX WARN: Removed duplicated region for block: B:104:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final boolean r28, final kotlin.jvm.functions.Function1 r29, androidx.compose.ui.Modifier r30, final kotlin.jvm.functions.Function3 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenu_androidKt.a(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates b(MutableState mutableState) {
        return (LayoutCoordinates) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final View view, final Density density, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1319522472);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(view) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(density) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1319522472, i4, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:237)");
            }
            boolean zI = composerK.I(view) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(view, function0);
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.a();
                            }
                        };
                    }
                };
                composerK.w(objG);
            }
            EffectsKt.b(view, density, (Function1) objG, composerK, i4 & 126);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$2
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
                    ExposedDropdownMenu_androidKt.h(view, density, function0, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(Rect rect, Rect rect2, int i3) {
        if (rect2 == null) {
            return 0;
        }
        float f3 = i3;
        float fR = rect.r() + f3;
        float fI = rect.i() - f3;
        return Math.max((rect2.r() > rect.i() || rect2.i() < rect.r()) ? MathKt.d(fI - fR) : MathKt.d(Math.max(rect2.r() - fR, fI - rect2.i())), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect u(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates == null ? Rect.f25601e.a() : RectKt.c(LayoutCoordinatesKt.g(layoutCoordinates), IntSizeKt.e(layoutCoordinates.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect v(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.e(rect);
    }
}
