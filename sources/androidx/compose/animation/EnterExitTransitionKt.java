package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class EnterExitTransitionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TwoWayConverter f3488a = VectorConvertersKt.a(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        public final AnimationVector2D c(long j3) {
            return new AnimationVector2D(TransformOrigin.f(j3), TransformOrigin.g(j3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((TransformOrigin) obj).j());
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        public final long c(AnimationVector2D animationVector2D) {
            return TransformOriginKt.a(animationVector2D.f(), animationVector2D.g());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return TransformOrigin.b(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SpringSpec f3489b = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SpringSpec f3490c = AnimationSpecKt.l(0.0f, 400.0f, IntOffset.c(VisibilityThresholdsKt.e(IntOffset.f29988b)), 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SpringSpec f3491d = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);

    public static /* synthetic */ ExitTransition A(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            vertical = Alignment.f25072a.a();
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int i4) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return z(finiteAnimationSpec, vertical, z2, function1);
    }

    public static final EnterTransition B(FiniteAnimationSpec finiteAnimationSpec, Function1 function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static final EnterTransition C(FiniteAnimationSpec finiteAnimationSpec, final Function1 function1) {
        return B(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(m14invokemHKZG7I(((IntSize) obj).j()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m14invokemHKZG7I(long j3) {
                return IntOffset.f((((long) ((Number) function1.invoke(Integer.valueOf((int) (j3 >> 32)))).intValue()) << 32) | (((long) 0) & 4294967295L));
            }
        });
    }

    public static /* synthetic */ EnterTransition D(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntOffset.c(VisibilityThresholdsKt.e(IntOffset.f29988b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1
                public final Integer invoke(int i4) {
                    return Integer.valueOf((-i4) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return C(finiteAnimationSpec, function1);
    }

    public static final EnterTransition E(FiniteAnimationSpec finiteAnimationSpec, final Function1 function1) {
        return B(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(m15invokemHKZG7I(((IntSize) obj).j()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m15invokemHKZG7I(long j3) {
                return IntOffset.f((((long) ((Number) function1.invoke(Integer.valueOf((int) (j3 & 4294967295L)))).intValue()) & 4294967295L) | (((long) 0) << 32));
            }
        });
    }

    public static /* synthetic */ EnterTransition F(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntOffset.c(VisibilityThresholdsKt.e(IntOffset.f29988b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1
                public final Integer invoke(int i4) {
                    return Integer.valueOf((-i4) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return E(finiteAnimationSpec, function1);
    }

    public static final ExitTransition G(FiniteAnimationSpec finiteAnimationSpec, Function1 function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static final ExitTransition H(FiniteAnimationSpec finiteAnimationSpec, final Function1 function1) {
        return G(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(m16invokemHKZG7I(((IntSize) obj).j()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m16invokemHKZG7I(long j3) {
                return IntOffset.f((((long) ((Number) function1.invoke(Integer.valueOf((int) (j3 >> 32)))).intValue()) << 32) | (((long) 0) & 4294967295L));
            }
        });
    }

    public static /* synthetic */ ExitTransition I(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntOffset.c(VisibilityThresholdsKt.e(IntOffset.f29988b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1
                public final Integer invoke(int i4) {
                    return Integer.valueOf((-i4) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return H(finiteAnimationSpec, function1);
    }

    public static final ExitTransition J(FiniteAnimationSpec finiteAnimationSpec, final Function1 function1) {
        return G(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(m17invokemHKZG7I(((IntSize) obj).j()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m17invokemHKZG7I(long j3) {
                return IntOffset.f((((long) ((Number) function1.invoke(Integer.valueOf((int) (j3 & 4294967295L)))).intValue()) & 4294967295L) | (((long) 0) << 32));
            }
        });
    }

    public static /* synthetic */ ExitTransition K(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntOffset.c(VisibilityThresholdsKt.e(IntOffset.f29988b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                public final Integer invoke(int i4) {
                    return Integer.valueOf((-i4) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return J(finiteAnimationSpec, function1);
    }

    private static final Alignment L(Alignment.Horizontal horizontal) {
        Alignment.Companion companion = Alignment.f25072a;
        return Intrinsics.areEqual(horizontal, companion.k()) ? companion.h() : Intrinsics.areEqual(horizontal, companion.j()) ? companion.f() : companion.e();
    }

    private static final Alignment M(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.f25072a;
        return Intrinsics.areEqual(vertical, companion.l()) ? companion.m() : Intrinsics.areEqual(vertical, companion.a()) ? companion.b() : companion.e();
    }

    public static final EnterTransition N(Transition transition, EnterTransition enterTransition, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(21614502, i3, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:908)");
        }
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(transition)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(enterTransition, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        if (transition.i() == transition.q() && transition.i() == EnterExitState.f3476b) {
            if (transition.w()) {
                P(mutableState, enterTransition);
            } else {
                P(mutableState, EnterTransition.f3563a.a());
            }
        } else if (transition.q() == EnterExitState.f3476b) {
            P(mutableState, O(mutableState).c(enterTransition));
        }
        EnterTransition enterTransitionO = O(mutableState);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return enterTransitionO;
    }

    private static final EnterTransition O(MutableState mutableState) {
        return (EnterTransition) mutableState.getValue();
    }

    private static final void P(MutableState mutableState, EnterTransition enterTransition) {
        mutableState.setValue(enterTransition);
    }

    public static final ExitTransition Q(Transition transition, ExitTransition exitTransition, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1363864804, i3, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:928)");
        }
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(transition)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(exitTransition, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        if (transition.i() == transition.q() && transition.i() == EnterExitState.f3476b) {
            if (transition.w()) {
                S(mutableState, exitTransition);
            } else {
                S(mutableState, ExitTransition.f3566a.a());
            }
        } else if (transition.q() != EnterExitState.f3476b) {
            S(mutableState, R(mutableState).c(exitTransition));
        }
        ExitTransition exitTransitionR = R(mutableState);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return exitTransitionR;
    }

    private static final ExitTransition R(MutableState mutableState) {
        return (ExitTransition) mutableState.getValue();
    }

    private static final void S(MutableState mutableState, ExitTransition exitTransition) {
        mutableState.setValue(exitTransition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.jvm.functions.Function1 f(androidx.compose.animation.core.Transition.DeferredAnimation r3, androidx.compose.animation.core.Transition.DeferredAnimation r4, androidx.compose.animation.core.Transition r5, final androidx.compose.animation.EnterTransition r6, final androidx.compose.animation.ExitTransition r7, androidx.compose.animation.core.Transition.DeferredAnimation r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L12
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            r1.<init>()
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2
            r2.<init>()
            androidx.compose.runtime.State r3 = r3.a(r1, r2)
            goto L13
        L12:
            r3 = r0
        L13:
            if (r4 == 0) goto L24
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            r1.<init>()
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2
            r2.<init>()
            androidx.compose.runtime.State r4 = r4.a(r1, r2)
            goto L25
        L24:
            r4 = r0
        L25:
            java.lang.Object r5 = r5.i()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.f3475a
            if (r5 != r1) goto L4d
            androidx.compose.animation.TransitionData r5 = r6.b()
            androidx.compose.animation.Scale r5 = r5.e()
            if (r5 == 0) goto L40
        L37:
            long r1 = r5.c()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.b(r1)
            goto L6b
        L40:
            androidx.compose.animation.TransitionData r5 = r7.b()
            androidx.compose.animation.Scale r5 = r5.e()
            if (r5 == 0) goto L4b
            goto L37
        L4b:
            r5 = r0
            goto L6b
        L4d:
            androidx.compose.animation.TransitionData r5 = r7.b()
            androidx.compose.animation.Scale r5 = r5.e()
            if (r5 == 0) goto L60
        L57:
            long r1 = r5.c()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.b(r1)
            goto L6b
        L60:
            androidx.compose.animation.TransitionData r5 = r6.b()
            androidx.compose.animation.Scale r5 = r5.e()
            if (r5 == 0) goto L4b
            goto L57
        L6b:
            if (r8 == 0) goto L78
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState>, androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                static {
                    /*
                        androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1) androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.a androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final androidx.compose.animation.core.FiniteAnimationSpec invoke(androidx.compose.animation.core.Transition.Segment r3) {
                    /*
                        r2 = this;
                        r3 = 0
                        r0 = 7
                        r1 = 0
                        androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.core.AnimationSpecKt.l(r1, r1, r3, r0, r3)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.invoke(androidx.compose.animation.core.Transition$Segment):androidx.compose.animation.core.FiniteAnimationSpec");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.animation.core.Transition$Segment r1 = (androidx.compose.animation.core.Transition.Segment) r1
                        androidx.compose.animation.core.FiniteAnimationSpec r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2
            r1.<init>()
            androidx.compose.runtime.State r0 = r8.a(r0, r1)
        L78:
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1 r5 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.f(androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, androidx.compose.animation.core.Transition$DeferredAnimation):kotlin.jvm.functions.Function1");
    }

    public static final Modifier g(Transition transition, EnterTransition enterTransition, ExitTransition exitTransition, Function0 function0, String str, Composer composer, int i3, int i4) {
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        ChangeSize changeSizeA;
        final Function0 function02 = (i4 & 4) != 0 ? new Function0<Boolean>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        } : function0;
        if (ComposerKt.M()) {
            ComposerKt.U(28261782, i3, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:860)");
        }
        int i5 = i3 & 14;
        EnterTransition enterTransitionN = N(transition, enterTransition, composer, i3 & 126);
        int i6 = i3 >> 3;
        ExitTransition exitTransitionQ = Q(transition, exitTransition, composer, (i6 & 112) | i5);
        boolean z2 = true;
        boolean z3 = (enterTransitionN.b().f() == null && exitTransitionQ.b().f() == null) ? false : true;
        boolean z4 = (enterTransitionN.b().a() == null && exitTransitionQ.b().a() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimationE = null;
        if (z3) {
            composer.a0(-821159459);
            TwoWayConverter twoWayConverterG = VectorConvertersKt.g(IntOffset.f29988b);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = str + " slide";
                composer.w(objG);
            }
            Transition.DeferredAnimation deferredAnimationE2 = androidx.compose.animation.core.TransitionKt.e(transition, twoWayConverterG, (String) objG, composer, i5 | 384, 0);
            composer.U();
            deferredAnimation = deferredAnimationE2;
        } else {
            composer.a0(-821053656);
            composer.U();
            deferredAnimation = null;
        }
        if (z4) {
            composer.a0(-820961865);
            TwoWayConverter twoWayConverterH = VectorConvertersKt.h(IntSize.f29998b);
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = str + " shrink/expand";
                composer.w(objG2);
            }
            Transition.DeferredAnimation deferredAnimationE3 = androidx.compose.animation.core.TransitionKt.e(transition, twoWayConverterH, (String) objG2, composer, i5 | 384, 0);
            composer.U();
            deferredAnimation2 = deferredAnimationE3;
        } else {
            composer.a0(-820851041);
            composer.U();
            deferredAnimation2 = null;
        }
        if (z4) {
            composer.a0(-820777446);
            TwoWayConverter twoWayConverterG2 = VectorConvertersKt.g(IntOffset.f29988b);
            Object objG3 = composer.G();
            if (objG3 == Composer.f23746a.a()) {
                objG3 = str + " InterruptionHandlingOffset";
                composer.w(objG3);
            }
            deferredAnimationE = androidx.compose.animation.core.TransitionKt.e(transition, twoWayConverterG2, (String) objG3, composer, i5 | 384, 0);
            composer.U();
        } else {
            composer.a0(-820608001);
            composer.U();
        }
        ChangeSize changeSizeA2 = enterTransitionN.b().a();
        final boolean z5 = ((changeSizeA2 == null || changeSizeA2.c()) && ((changeSizeA = exitTransitionQ.b().a()) == null || changeSizeA.c()) && z4) ? false : true;
        GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExitE = e(transition, enterTransitionN, exitTransitionQ, str, composer, i5 | (i6 & 7168));
        Modifier.Companion companion = Modifier.b8;
        boolean zB = composer.b(z5);
        if ((((i3 & 7168) ^ 3072) <= 2048 || !composer.Z(function02)) && (i3 & 3072) != 2048) {
            z2 = false;
        }
        boolean z6 = zB | z2;
        Object objG4 = composer.G();
        if (z6 || objG4 == Composer.f23746a.a()) {
            objG4 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
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
                    graphicsLayerScope.B(!z5 && ((Boolean) function02.invoke()).booleanValue());
                }
            };
            composer.w(objG4);
        }
        Modifier modifierThen = GraphicsLayerModifierKt.a(companion, (Function1) objG4).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimationE, deferredAnimation, enterTransitionN, exitTransitionQ, function02, graphicsLayerBlockForEnterExitE));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modifierThen;
    }

    public static final EnterTransition h(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z2, final Function1 function1) {
        return j(finiteAnimationSpec, L(horizontal), z2, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            {
                super(1);
            }

            public final long c(long j3) {
                int iIntValue = ((Number) function1.invoke(Integer.valueOf((int) (j3 >> 32)))).intValue();
                return IntSize.c((((long) ((int) (j3 & 4294967295L))) & 4294967295L) | (((long) iIntValue) << 32));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.b(c(((IntSize) obj).j()));
            }
        });
    }

    public static /* synthetic */ EnterTransition i(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            horizontal = Alignment.f25072a.j();
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                public final Integer invoke(int i4) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return h(finiteAnimationSpec, horizontal, z2, function1);
    }

    public static final EnterTransition j(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z2, Function1 function1) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z2), null, false, null, 59, null));
    }

    public static /* synthetic */ EnterTransition k(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            alignment = Alignment.f25072a.c();
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
                public final long c(long j3) {
                    long j4 = 0;
                    return IntSize.c((j4 & 4294967295L) | (j4 << 32));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return IntSize.b(c(((IntSize) obj2).j()));
                }
            };
        }
        return j(finiteAnimationSpec, alignment, z2, function1);
    }

    public static final EnterTransition l(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z2, final Function1 function1) {
        return j(finiteAnimationSpec, M(vertical), z2, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            {
                super(1);
            }

            public final long c(long j3) {
                int i3 = (int) (j3 >> 32);
                return IntSize.c((((long) ((Number) function1.invoke(Integer.valueOf((int) (j3 & 4294967295L)))).intValue()) & 4294967295L) | (((long) i3) << 32));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.b(c(((IntSize) obj).j()));
            }
        });
    }

    public static /* synthetic */ EnterTransition m(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            vertical = Alignment.f25072a.a();
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int i4) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return l(finiteAnimationSpec, vertical, z2, function1);
    }

    public static final EnterTransition n(FiniteAnimationSpec finiteAnimationSpec, float f3) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f3, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ EnterTransition o(FiniteAnimationSpec finiteAnimationSpec, float f3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);
        }
        if ((i3 & 2) != 0) {
            f3 = 0.0f;
        }
        return n(finiteAnimationSpec, f3);
    }

    public static final ExitTransition p(FiniteAnimationSpec finiteAnimationSpec, float f3) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f3, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ ExitTransition q(FiniteAnimationSpec finiteAnimationSpec, float f3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);
        }
        if ((i3 & 2) != 0) {
            f3 = 0.0f;
        }
        return p(finiteAnimationSpec, f3);
    }

    public static final EnterTransition r(FiniteAnimationSpec finiteAnimationSpec, float f3, long j3) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f3, j3, finiteAnimationSpec, null), false, null, 55, null));
    }

    public static /* synthetic */ EnterTransition s(FiniteAnimationSpec finiteAnimationSpec, float f3, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);
        }
        if ((i3 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            j3 = TransformOrigin.f25955b.a();
        }
        return r(finiteAnimationSpec, f3, j3);
    }

    public static final ExitTransition t(FiniteAnimationSpec finiteAnimationSpec, float f3, long j3) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f3, j3, finiteAnimationSpec, null), false, null, 55, null));
    }

    public static /* synthetic */ ExitTransition u(FiniteAnimationSpec finiteAnimationSpec, float f3, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);
        }
        if ((i3 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            j3 = TransformOrigin.f25955b.a();
        }
        return t(finiteAnimationSpec, f3, j3);
    }

    public static final ExitTransition v(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z2, final Function1 function1) {
        return x(finiteAnimationSpec, L(horizontal), z2, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2
            {
                super(1);
            }

            public final long c(long j3) {
                int iIntValue = ((Number) function1.invoke(Integer.valueOf((int) (j3 >> 32)))).intValue();
                return IntSize.c((((long) ((int) (j3 & 4294967295L))) & 4294967295L) | (((long) iIntValue) << 32));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.b(c(((IntSize) obj).j()));
            }
        });
    }

    public static /* synthetic */ ExitTransition w(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            horizontal = Alignment.f25072a.j();
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1
                public final Integer invoke(int i4) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return v(finiteAnimationSpec, horizontal, z2, function1);
    }

    public static final ExitTransition x(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z2, Function1 function1) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z2), null, false, null, 59, null));
    }

    public static /* synthetic */ ExitTransition y(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            alignment = Alignment.f25072a.c();
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                public final long c(long j3) {
                    long j4 = 0;
                    return IntSize.c((j4 & 4294967295L) | (j4 << 32));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return IntSize.b(c(((IntSize) obj2).j()));
                }
            };
        }
        return x(finiteAnimationSpec, alignment, z2, function1);
    }

    public static final ExitTransition z(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z2, final Function1 function1) {
        return x(finiteAnimationSpec, M(vertical), z2, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            {
                super(1);
            }

            public final long c(long j3) {
                int i3 = (int) (j3 >> 32);
                return IntSize.c((((long) ((Number) function1.invoke(Integer.valueOf((int) (j3 & 4294967295L)))).intValue()) & 4294967295L) | (((long) i3) << 32));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.b(c(((IntSize) obj).j()));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x011f A[PHI: r1
      0x011f: PHI (r1v11 androidx.compose.animation.EnterTransition) = (r1v9 androidx.compose.animation.EnterTransition), (r1v12 androidx.compose.animation.EnterTransition) binds: [B:42:0x011d, B:38:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a A[PHI: r2
      0x013a: PHI (r2v10 androidx.compose.animation.ExitTransition) = (r2v8 androidx.compose.animation.ExitTransition), (r2v11 androidx.compose.animation.ExitTransition) binds: [B:52:0x0138, B:48:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.animation.GraphicsLayerBlockForEnterExit e(final androidx.compose.animation.core.Transition r19, androidx.compose.animation.EnterTransition r20, androidx.compose.animation.ExitTransition r21, java.lang.String r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.e(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.animation.GraphicsLayerBlockForEnterExit");
    }
}
