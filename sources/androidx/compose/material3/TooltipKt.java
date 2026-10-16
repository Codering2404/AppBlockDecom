package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

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
public final class TooltipKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f21448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f21449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f21450c = Dp.g(40);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f21451d = Dp.g(200);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f21452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f21453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final PaddingValues f21454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f21455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f21456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f21457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f21458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f21459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f21460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f21461n;

    static {
        float f3 = 4;
        f21448a = Dp.g(f3);
        float f4 = 24;
        f21449b = Dp.g(f4);
        float fG = Dp.g(f3);
        f21452e = fG;
        float f5 = 8;
        float fG2 = Dp.g(f5);
        f21453f = fG2;
        f21454g = PaddingKt.b(fG2, fG);
        f21455h = Dp.g(320);
        float f6 = 16;
        f21456i = Dp.g(f6);
        f21457j = Dp.g(28);
        f21458k = Dp.g(f4);
        f21459l = Dp.g(f6);
        f21460m = Dp.g(36);
        f21461n = Dp.g(f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.window.PopupPositionProvider r17, final kotlin.jvm.functions.Function3 r18, final androidx.compose.material3.TooltipState r19, androidx.compose.ui.Modifier r20, boolean r21, boolean r22, final kotlin.jvm.functions.Function2 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.a(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function3, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Modifier b(Modifier modifier, final Transition transition) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("animateTooltip");
                inspectorInfo.b().c("transition", transition);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2
            {
                super(3);
            }

            private static final float d(State state) {
                return ((Number) state.getValue()).floatValue();
            }

            private static final float e(State state) {
                return ((Number) state.getValue()).floatValue();
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-1498516085);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1498516085, i3, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:584)");
                }
                Transition transition2 = transition;
                TooltipKt$animateTooltip$2$scale$2 tooltipKt$animateTooltip$2$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer2, int i4) {
                        composer2.a0(386845748);
                        if (ComposerKt.M()) {
                            ComposerKt.U(386845748, i4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:587)");
                        }
                        TweenSpec tweenSpecN = segment.d(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.n(150, 0, EasingKt.f(), 2, null) : AnimationSpecKt.n(75, 0, EasingKt.f(), 2, null);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                        composer2.U();
                        return tweenSpecN;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                    }
                };
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.f140130a;
                TwoWayConverter twoWayConverterI = VectorConvertersKt.i(floatCompanionObject);
                boolean zBooleanValue = ((Boolean) transition2.i()).booleanValue();
                composer.a0(-1553362193);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:603)");
                }
                float f3 = zBooleanValue ? 1.0f : 0.8f;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                Float fValueOf = Float.valueOf(f3);
                boolean zBooleanValue2 = ((Boolean) transition2.q()).booleanValue();
                composer.a0(-1553362193);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:603)");
                }
                float f4 = zBooleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                State stateF = TransitionKt.f(transition2, fValueOf, Float.valueOf(f4), (FiniteAnimationSpec) tooltipKt$animateTooltip$2$scale$2.invoke(transition2.o(), composer, 0), twoWayConverterI, "tooltip transition: scaling", composer, 196608);
                Transition transition3 = transition;
                TooltipKt$animateTooltip$2$alpha$2 tooltipKt$animateTooltip$2$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer2, int i4) {
                        composer2.a0(-281714272);
                        if (ComposerKt.M()) {
                            ComposerKt.U(-281714272, i4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:609)");
                        }
                        TweenSpec tweenSpecN = segment.d(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.n(150, 0, EasingKt.e(), 2, null) : AnimationSpecKt.n(75, 0, EasingKt.e(), 2, null);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                        composer2.U();
                        return tweenSpecN;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                    }
                };
                TwoWayConverter twoWayConverterI2 = VectorConvertersKt.i(floatCompanionObject);
                boolean zBooleanValue3 = ((Boolean) transition3.i()).booleanValue();
                composer.a0(2073045083);
                if (ComposerKt.M()) {
                    ComposerKt.U(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:619)");
                }
                float f5 = zBooleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                Float fValueOf2 = Float.valueOf(f5);
                boolean zBooleanValue4 = ((Boolean) transition3.q()).booleanValue();
                composer.a0(2073045083);
                if (ComposerKt.M()) {
                    ComposerKt.U(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:619)");
                }
                float f6 = zBooleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                Modifier modifierC = GraphicsLayerModifierKt.c(modifier2, d(stateF), d(stateF), e(TransitionKt.f(transition3, fValueOf2, Float.valueOf(f6), (FiniteAnimationSpec) tooltipKt$animateTooltip$2$alpha$2.invoke(transition3.o(), composer, 0), twoWayConverterI2, "tooltip transition: alpha", composer, 196608)), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierC;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public static final float c() {
        return f21461n;
    }

    public static final float d() {
        return f21460m;
    }

    public static final float e() {
        return f21457j;
    }

    public static final PaddingValues f() {
        return f21454g;
    }

    public static final float g() {
        return f21451d;
    }

    public static final float h() {
        return f21456i;
    }

    public static final float i() {
        return f21455h;
    }

    public static final float j() {
        return f21448a;
    }

    public static final float k() {
        return f21449b;
    }

    public static final float l() {
        return f21450c;
    }

    public static final TooltipState m(boolean z2, boolean z3, MutatorMutex mutatorMutex, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            z2 = false;
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.f21892a.a();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1413230530, i3, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:436)");
        }
        boolean z4 = ((((i3 & 112) ^ 48) > 32 && composer.b(z3)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.Z(mutatorMutex)) || (i3 & 384) == 256);
        Object objG = composer.G();
        if (z4 || objG == Composer.f23746a.a()) {
            objG = new TooltipStateImpl(z2, z3, mutatorMutex);
            composer.w(objG);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return tooltipStateImpl;
    }

    public static final Modifier n(Modifier modifier, boolean z2, boolean z3) {
        return (z2 || z3) ? PaddingKt.m(AlignmentLineKt.h(modifier, f21458k, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, f21459l, 7, null) : PaddingKt.k(modifier, 0.0f, f21452e, 1, null);
    }
}
