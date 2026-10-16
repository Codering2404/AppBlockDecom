package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
public final class BackdropScaffoldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f11909a = Dp.g(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f11910b = Dp.g(125);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f11911c = Dp.g(56);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BackdropValue backdropValue, final Function2 function2, final Function2 function22, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-950970976);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(backdropValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function22) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-950970976, i5, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:549)");
            }
            final State stateD = AnimateAsStateKt.d(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerK, 48, 28);
            final float fM1 = ((Density) composerK.q(CompositionLocalsKt.f())).M1(f11909a);
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            boolean Z = composerK.Z(stateD);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$1$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m114invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m114invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                        final float fB = BackdropScaffoldKt.b(stateD) - 1;
                        if (fB < 0.0f) {
                            fB = 0.0f;
                        }
                        if (fB > 1.0f) {
                            fB = 1.0f;
                        }
                        final Placeable placeableN0 = measurable.n0(j3);
                        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                placementScope.h(placeableN0, 0, 0, fB);
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierA = LayoutModifierKt.a(companion, (Function3) objG);
            boolean Z2 = composerK.Z(stateD) | composerK.c(fM1);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        float f3 = 1;
                        float fB = BackdropScaffoldKt.b(stateD) - f3;
                        if (fB < 0.0f) {
                            fB = 0.0f;
                        }
                        if (fB > 1.0f) {
                            fB = 1.0f;
                        }
                        graphicsLayerScope.c(fB);
                        graphicsLayerScope.d((f3 - fB) * fM1);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierA2 = GraphicsLayerModifierKt.a(modifierA, (Function1) objG2);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierA2);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            function2.invoke(composerK, Integer.valueOf((i5 >> 3) & 14));
            composerK.y();
            boolean Z3 = composerK.Z(stateD);
            Object objG3 = composerK.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$4$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m115invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m115invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                        final float fB = 1 - BackdropScaffoldKt.b(stateD);
                        if (fB < 0.0f) {
                            fB = 0.0f;
                        }
                        if (fB > 1.0f) {
                            fB = 1.0f;
                        }
                        final Placeable placeableN0 = measurable.n0(j3);
                        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$4$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                placementScope.h(placeableN0, 0, 0, fB);
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierA3 = LayoutModifierKt.a(companion, (Function3) objG3);
            boolean Z4 = composerK.Z(stateD) | composerK.c(fM1);
            Object objG4 = composerK.G();
            if (Z4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        float f3 = 1;
                        float fB = f3 - BackdropScaffoldKt.b(stateD);
                        if (fB < 0.0f) {
                            fB = 0.0f;
                        }
                        if (fB > 1.0f) {
                            fB = 1.0f;
                        }
                        graphicsLayerScope.c(fB);
                        graphicsLayerScope.d((f3 - fB) * fM1);
                    }
                };
                composerK.w(objG4);
            }
            Modifier modifierA4 = GraphicsLayerModifierKt.a(modifierA3, (Function1) objG4);
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierA4);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG3, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            function22.invoke(composerK, Integer.valueOf((i5 >> 6) & 14));
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    BackdropScaffoldKt.a(backdropValue, function2, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final kotlin.jvm.functions.Function2 r38, final kotlin.jvm.functions.Function2 r39, final kotlin.jvm.functions.Function2 r40, androidx.compose.ui.Modifier r41, androidx.compose.material.BackdropScaffoldState r42, kotlin.jvm.functions.Function3 r43, boolean r44, float r45, float r46, boolean r47, boolean r48, long r49, long r51, androidx.compose.ui.graphics.Shape r53, float r54, long r55, long r57, long r59, androidx.compose.runtime.Composer r61, final int r62, final int r63, final int r64) {
        /*
            Method dump skipped, instruction units count: 1311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.c(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, kotlin.jvm.functions.Function3, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final BackdropScaffoldState d(BackdropValue backdropValue, Density density, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState) {
        BackdropScaffoldState backdropScaffoldState = new BackdropScaffoldState(backdropValue, animationSpec, function1, snackbarHostState);
        backdropScaffoldState.l(density);
        return backdropScaffoldState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final Modifier modifier, final Function2 function2, final Function1 function1, final Function4 function4, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1248995194);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function4) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1248995194, i4, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:602)");
            }
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 896) == 256) | ((i4 & 7168) == 2048);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m118invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).r());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m118invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, final long j3) {
                        final Placeable placeableN0 = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.V(BackdropLayers.Back, function2))).n0(((Constraints) function1.invoke(Constraints.a(j3))).r());
                        final float fO0 = placeableN0.O0();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4 function42 = function4;
                        List listV = subcomposeMeasureScope.V(backdropLayers, ComposableLambdaKt.c(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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
                                    ComposerKt.U(-1222642649, i5, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:612)");
                                }
                                function42.invoke(Constraints.a(j3), Float.valueOf(fO0), composer2, 0);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }));
                        final ArrayList arrayList = new ArrayList(listV.size());
                        int size = listV.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            arrayList.add(((Measurable) listV.get(i5)).n0(j3));
                        }
                        int iMax = Math.max(Constraints.n(j3), placeableN0.X0());
                        int iMax2 = Math.max(Constraints.m(j3), placeableN0.O0());
                        int size2 = arrayList.size();
                        int iMax3 = iMax2;
                        int iMax4 = iMax;
                        for (int i6 = 0; i6 < size2; i6++) {
                            Placeable placeable = (Placeable) arrayList.get(i6);
                            iMax4 = Math.max(iMax4, placeable.X0());
                            iMax3 = Math.max(iMax3, placeable.O0());
                        }
                        return MeasureScope.B0(subcomposeMeasureScope, iMax4, iMax3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.m(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                                List list = arrayList;
                                int size3 = list.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list.get(i7), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            SubcomposeLayoutKt.a(modifier, (Function2) objG, composerK, i4 & 14, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$2
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
                    BackdropScaffoldKt.e(modifier, function2, function1, function4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final NestedScrollConnection f(AnchoredDraggableState anchoredDraggableState, Orientation orientation) {
        return new BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1(anchoredDraggableState, orientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final long j3, final Function0 function0, final boolean z2, Composer composer, final int i3) {
        int i4;
        Modifier modifierThen;
        Composer composerK = composer.k(-92141505);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-92141505, i4, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:518)");
            }
            if (j3 != 16) {
                composerK.a0(478604781);
                int i5 = i4;
                final State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerK, 48, 28);
                if (z2) {
                    composerK.a0(478778505);
                    Modifier.Companion companion = Modifier.b8;
                    Unit unit = Unit.f139807a;
                    boolean z3 = (i5 & 112) == 32;
                    Object objG = composerK.G();
                    if (z3 || objG == Composer.f23746a.a()) {
                        objG = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        composerK.w(objG);
                    }
                    modifierThen = companion.then(new SuspendPointerInputElement(unit, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG), 6, null));
                    composerK.U();
                } else {
                    composerK.a0(478870978);
                    composerK.U();
                    modifierThen = Modifier.b8;
                }
                Modifier modifierThen2 = SizeKt.f(Modifier.b8, 0.0f, 1, null).then(modifierThen);
                boolean Z = composerK.Z(stateD) | ((i5 & 14) == 4);
                Object objG2 = composerK.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DrawScope) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(DrawScope drawScope) {
                            DrawScope.L1(drawScope, j3, 0L, 0L, BackdropScaffoldKt.h(stateD), null, null, 0, 118, null);
                        }
                    };
                    composerK.w(objG2);
                }
                CanvasKt.b(modifierThen2, (Function1) objG2, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(479086242);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    BackdropScaffoldKt.g(j3, function0, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final BackdropScaffoldState p(final BackdropValue backdropValue, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = BackdropScaffoldDefaults.f11903a.a();
        }
        final AnimationSpec animationSpec2 = animationSpec;
        if ((i4 & 4) != 0) {
            function1 = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(BackdropValue backdropValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        final Function1 function12 = function1;
        if ((i4 & 8) != 0) {
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new SnackbarHostState();
                composer.w(objG);
            }
            snackbarHostState = (SnackbarHostState) objG;
        }
        final SnackbarHostState snackbarHostState2 = snackbarHostState;
        if (ComposerKt.M()) {
            ComposerKt.U(-862178912, i3, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:281)");
        }
        final Density density = (Density) composer.q(CompositionLocalsKt.f());
        Object[] objArr = {animationSpec2, function12, snackbarHostState2};
        Saver saverA = BackdropScaffoldState.f12057f.a(animationSpec2, function12, snackbarHostState2, density);
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(backdropValue)) || (i3 & 6) == 4) | composer.Z(density) | composer.I(animationSpec2) | ((((i3 & 896) ^ 384) > 256 && composer.Z(function12)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.Z(snackbarHostState2)) || (i3 & 3072) == 2048);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            Object obj = new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BackdropScaffoldState invoke() {
                    return BackdropScaffoldKt.d(backdropValue, density, animationSpec2, function12, snackbarHostState2);
                }
            };
            composer.w(obj);
            objG2 = obj;
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG2, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return backdropScaffoldState;
    }
}
