package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimatedVisibilityKt {
    public static final void a(final Transition transition, final Function1 function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function2 function2, OnLookaheadMeasured onLookaheadMeasured, final Function3 function3, Composer composer, final int i3, final int i4) {
        int i5;
        ExitTransition exitTransition2;
        final OnLookaheadMeasured onLookaheadMeasured2;
        EnterExitState enterExitState;
        int i6;
        Modifier modifierA;
        OnLookaheadMeasured onLookaheadMeasured3 = onLookaheadMeasured;
        Composer composerK = composer.k(-891967166);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(transition) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(enterTransition) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
            exitTransition2 = exitTransition;
        } else {
            exitTransition2 = exitTransition;
            if ((i3 & 24576) == 0) {
                i5 |= composerK.Z(exitTransition2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
        }
        if ((i4 & 32) != 0) {
            i5 |= 196608;
        } else if ((i3 & 196608) == 0) {
            i5 |= composerK.I(function2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i7 = i4 & 64;
        int i8 = 1572864;
        if (i7 != 0) {
            i5 |= i8;
        } else if ((i3 & 1572864) == 0) {
            i8 = (i3 & 2097152) == 0 ? composerK.Z(onLookaheadMeasured3) : composerK.I(onLookaheadMeasured3) ? 1048576 : 524288;
            i5 |= i8;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i5 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            i5 |= composerK.I(function3) ? 8388608 : 4194304;
        }
        int i9 = i5;
        int i10 = 1;
        if (composerK.r((4793491 & i9) != 4793490, i9 & 1)) {
            if (i7 != 0) {
                onLookaheadMeasured3 = null;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-891967166, i9, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:718)");
            }
            if (((Boolean) function1.invoke(transition.q())).booleanValue() || ((Boolean) function1.invoke(transition.i())).booleanValue() || transition.w() || transition.j()) {
                composerK.a0(1788522886);
                int i11 = i9 & 14;
                int i12 = i11 | 48;
                int i13 = i12 & 14;
                OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured3;
                boolean z2 = ((i13 ^ 6) > 4 && composerK.Z(transition)) || (i12 & 6) == 4;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = transition.i();
                    composerK.w(objG);
                }
                if (transition.w()) {
                    objG = transition.i();
                }
                composerK.a0(-466616829);
                if (ComposerKt.M()) {
                    ComposerKt.U(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:727)");
                }
                int i14 = i9 & 126;
                EnterExitState enterExitStateO = o(transition, function1, objG, composerK, i14);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composerK.U();
                Object objQ = transition.q();
                composerK.a0(-466616829);
                if (ComposerKt.M()) {
                    enterExitState = enterExitStateO;
                    i6 = 0;
                    ComposerKt.U(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:727)");
                } else {
                    enterExitState = enterExitStateO;
                    i6 = 0;
                }
                EnterExitState enterExitStateO2 = o(transition, function1, objQ, composerK, i14);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composerK.U();
                int i15 = i6;
                onLookaheadMeasured2 = onLookaheadMeasured4;
                Transition transitionD = androidx.compose.animation.core.TransitionKt.d(transition, enterExitState, enterExitStateO2, "EnterExitTransition", composerK, i13 | 3072);
                State stateP = SnapshotStateKt.p(function2, composerK, (i9 >> 15) & 14);
                Object objInvoke = function2.invoke(transitionD.i(), transitionD.q());
                boolean Z = composerK.Z(transitionD) | composerK.Z(stateP);
                Object objG2 = composerK.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(transitionD, stateP, null);
                    composerK.w(objG2);
                }
                State stateM = SnapshotStateKt.m(objInvoke, (Function2) objG2, composerK, i15);
                if (n(transitionD) && c(stateM)) {
                    composerK.a0(1790688794);
                    composerK.U();
                } else {
                    composerK.a0(1789551931);
                    int i16 = i11 == 4 ? 1 : i15;
                    Object objG3 = composerK.G();
                    if (i16 != 0 || objG3 == Composer.f23746a.a()) {
                        objG3 = new AnimatedVisibilityScopeImpl(transitionD);
                        composerK.w(objG3);
                    }
                    AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objG3;
                    int i17 = i9 >> 6;
                    Modifier modifierG = EnterExitTransitionKt.g(transitionD, enterTransition, exitTransition2, null, "Built-in", composerK, (i17 & 112) | 24576 | (i17 & 896), 4);
                    if (onLookaheadMeasured2 != null) {
                        composerK.a0(1789971299);
                        Modifier.Companion companion = Modifier.b8;
                        if ((3670016 & i9) != 1048576 && ((i9 & 2097152) == 0 || !composerK.I(onLookaheadMeasured2))) {
                            i10 = i15;
                        }
                        Object objG4 = composerK.G();
                        if (i10 != 0 || objG4 == Composer.f23746a.a()) {
                            objG4 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return m12invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
                                }

                                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m12invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                                    final Placeable placeableN0 = measurable.n0(j3);
                                    OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured2;
                                    if (measureScope.q0()) {
                                        onLookaheadMeasured5.a(IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L)));
                                    }
                                    return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.f139807a;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            };
                            composerK.w(objG4);
                        }
                        modifierA = LayoutModifierKt.a(companion, (Function3) objG4);
                        composerK.U();
                    } else {
                        composerK.a0(1581779440);
                        composerK.U();
                        modifierA = Modifier.b8;
                    }
                    Modifier modifierThen = modifier.then(modifierG.then(modifierA));
                    Object objG5 = composerK.G();
                    if (objG5 == Composer.f23746a.a()) {
                        objG5 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        composerK.w(objG5);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objG5;
                    int iA = ComposablesKt.a(composerK, i15);
                    CompositionLocalMap compositionLocalMapU = composerK.u();
                    Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
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
                    Updater.e(composerA, animatedEnterExitMeasurePolicy, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    function3.invoke(animatedVisibilityScopeImpl, composerK, Integer.valueOf((i9 >> 18) & 112));
                    composerK.y();
                    composerK.U();
                }
                composerK.U();
            } else {
                composerK.a0(1790694746);
                composerK.U();
                onLookaheadMeasured2 = onLookaheadMeasured3;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            onLookaheadMeasured2 = onLookaheadMeasured3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i18) {
                    AnimatedVisibilityKt.a(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured5, function3, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2 b(State state) {
        return (Function2) state.getValue();
    }

    private static final boolean c(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final androidx.compose.animation.core.MutableTransitionState r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, final kotlin.jvm.functions.Function3 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.d(androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final androidx.compose.animation.core.Transition r21, final kotlin.jvm.functions.Function1 r22, androidx.compose.ui.Modifier r23, androidx.compose.animation.EnterTransition r24, androidx.compose.animation.ExitTransition r25, final kotlin.jvm.functions.Function3 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.e(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(final androidx.compose.foundation.layout.ColumnScope r23, final androidx.compose.animation.core.MutableTransitionState r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.f(androidx.compose.foundation.layout.ColumnScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final androidx.compose.foundation.layout.ColumnScope r23, boolean r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.g(androidx.compose.foundation.layout.ColumnScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final androidx.compose.foundation.layout.RowScope r23, final androidx.compose.animation.core.MutableTransitionState r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.h(androidx.compose.foundation.layout.RowScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(final androidx.compose.foundation.layout.RowScope r23, boolean r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.i(androidx.compose.foundation.layout.RowScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, final kotlin.jvm.functions.Function3 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.j(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void k(final Transition transition, final Function1 function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3 function3, Composer composer, final int i3) {
        int i4;
        ExitTransition exitTransition2;
        Composer composerK = composer.k(429978603);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(transition) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(enterTransition) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            exitTransition2 = exitTransition;
            i4 |= composerK.Z(exitTransition2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            exitTransition2 = exitTransition;
        }
        if ((i3 & 196608) == 0) {
            i4 |= composerK.I(function3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(429978603, i4, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:677)");
            }
            int i5 = i4 & 112;
            int i6 = i4 & 14;
            boolean z2 = (i5 == 32) | (i6 == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m13invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m13invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                        long jC;
                        final Placeable placeableN0 = measurable.n0(j3);
                        if (!measureScope.q0() || ((Boolean) function1.invoke(transition.q())).booleanValue()) {
                            jC = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
                        } else {
                            jC = IntSize.f29998b.a();
                        }
                        return MeasureScope.B0(measureScope, (int) (jC >> 32), (int) (jC & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            a(transition, function1, LayoutModifierKt.a(modifier, (Function3) objG), enterTransition, exitTransition2, new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$2
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                    return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.f3477c);
                }
            }, null, function3, composerK, i5 | i6 | 196608 | (i4 & 7168) | (57344 & i4) | ((i4 << 6) & 29360128), 64);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$3
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
                    AnimatedVisibilityKt.k(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(Transition transition) {
        Object objI = transition.i();
        EnterExitState enterExitState = EnterExitState.f3477c;
        return objI == enterExitState && transition.q() == enterExitState;
    }

    private static final EnterExitState o(Transition transition, Function1 function1, Object obj, Composer composer, int i3) {
        EnterExitState enterExitState;
        if (ComposerKt.M()) {
            ComposerKt.U(361571134, i3, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:836)");
        }
        composer.K(-902032957, transition);
        if (transition.w()) {
            composer.a0(2101770115);
            composer.U();
            enterExitState = ((Boolean) function1.invoke(obj)).booleanValue() ? EnterExitState.f3476b : ((Boolean) function1.invoke(transition.i())).booleanValue() ? EnterExitState.f3477c : EnterExitState.f3475a;
        } else {
            composer.a0(2102044248);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            if (((Boolean) function1.invoke(transition.i())).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            enterExitState = ((Boolean) function1.invoke(obj)).booleanValue() ? EnterExitState.f3476b : ((Boolean) mutableState.getValue()).booleanValue() ? EnterExitState.f3477c : EnterExitState.f3475a;
            composer.U();
        }
        composer.X();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return enterExitState;
    }
}
