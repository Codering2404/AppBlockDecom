package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class SwitchKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f14420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f14421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f14422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f14423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f14424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f14425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f14426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f14427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final TweenSpec f14428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f14429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f14430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f14431l;

    static {
        float fG = Dp.g(34);
        f14420a = fG;
        f14421b = Dp.g(14);
        float fG2 = Dp.g(20);
        f14422c = fG2;
        f14423d = Dp.g(24);
        f14424e = Dp.g(2);
        f14425f = fG;
        f14426g = fG2;
        f14427h = Dp.g(fG - fG2);
        f14428i = new TweenSpec(100, 0, null, 6, null);
        f14429j = Dp.g(1);
        f14430k = Dp.g(6);
        f14431l = Dp.g(125);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final boolean r36, final kotlin.jvm.functions.Function1 r37, androidx.compose.ui.Modifier r38, boolean r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, androidx.compose.material.SwitchColors r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.a(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 d(State state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final BoxScope boxScope, final boolean z2, final boolean z3, final SwitchColors switchColors, final Function0 function0, final InteractionSource interactionSource, Composer composer, final int i3) {
        int i4;
        Modifier.Companion companion;
        boolean z4;
        long jH;
        Composer composerK = composer.k(70908914);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(switchColors) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(interactionSource) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if ((74899 & i5) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(70908914, i5, -1, "androidx.compose.material.SwitchImpl (Switch.kt:220)");
            }
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = SnapshotStateKt.f();
                composerK.w(objG);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
            boolean z5 = (458752 & i5) == 131072;
            Object objG2 = composerK.G();
            if (z5 || objG2 == companion2.a()) {
                objG2 = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerK.w(objG2);
            }
            EffectsKt.g(interactionSource, (Function2) objG2, composerK, (i5 >> 15) & 14);
            float f3 = !snapshotStateList.isEmpty() ? f14430k : f14429j;
            int i6 = ((i5 >> 6) & 14) | (i5 & 112) | ((i5 >> 3) & 896);
            final State stateA = switchColors.a(z3, z2, composerK, i6);
            Modifier.Companion companion3 = Modifier.b8;
            Alignment.Companion companion4 = Alignment.f25072a;
            Modifier modifierF = SizeKt.f(boxScope.f(companion3, companion4.e()), 0.0f, 1, null);
            boolean Z = composerK.Z(stateA);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion2.a()) {
                objG3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        SwitchKt.q(drawScope, SwitchKt.g(stateA), drawScope.M1(SwitchKt.s()), drawScope.M1(SwitchKt.r()));
                    }
                };
                composerK.w(objG3);
            }
            CanvasKt.b(modifierF, (Function1) objG3, composerK, 0);
            State stateB = switchColors.b(z3, z2, composerK, i6);
            ElevationOverlay elevationOverlay = (ElevationOverlay) composerK.q(ElevationOverlayKt.d());
            float fG = Dp.g(((Dp) composerK.q(ElevationOverlayKt.c())).l() + f3);
            if (!Color.t(h(stateB), MaterialTheme.f13091a.a(composerK, 6).n()) || elevationOverlay == null) {
                companion = companion3;
                z4 = true;
                composerK.a0(1478489190);
                composerK.U();
                jH = h(stateB);
            } else {
                composerK.a0(1478408187);
                companion = companion3;
                z4 = true;
                jH = elevationOverlay.a(h(stateB), fG, composerK, 0);
                composerK.U();
            }
            State stateA2 = SingleValueAnimationKt.a(jH, null, null, null, composerK, 0, 14);
            composerK = composerK;
            Modifier modifierF2 = boxScope.f(companion, companion4.h());
            boolean z6 = (i5 & 57344) == 16384 ? z4 : false;
            Object objG4 = composerK.G();
            if (z6 || objG4 == companion2.a()) {
                objG4 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    {
                        super(1);
                    }

                    public final long c(Density density) {
                        return IntOffsetKt.a(MathKt.d(((Number) function0.invoke()).floatValue()), 0);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.c(c((Density) obj));
                    }
                };
                composerK.w(objG4);
            }
            SpacerKt.a(BackgroundKt.c(ShadowKt.b(SizeKt.o(IndicationKt.b(OffsetKt.b(modifierF2, (Function1) objG4), interactionSource, RippleKt.f(false, f14423d, 0L, composerK, 54, 4)), f14422c), f3, RoundedCornerShapeKt.g(), false, 0L, 0L, 24, null), i(stateA2), RoundedCornerShapeKt.g()), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    SwitchKt.f(boxScope, z2, z3, switchColors, function0, interactionSource, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(State state) {
        return ((Color) state.getValue()).B();
    }

    private static final long h(State state) {
        return ((Color) state.getValue()).B();
    }

    private static final long i(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DrawScope drawScope, long j3, float f3, float f4) {
        float f5 = f4 / 2;
        DrawScope.L0(drawScope, j3, androidx.compose.ui.geometry.OffsetKt.a(f5, Offset.n(drawScope.V1())), androidx.compose.ui.geometry.OffsetKt.a(f3 - f5, Offset.n(drawScope.V1())), f4, StrokeCap.f25935b.b(), null, 0.0f, null, 0, 480, null);
    }

    public static final float r() {
        return f14421b;
    }

    public static final float s() {
        return f14420a;
    }
}
