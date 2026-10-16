package androidx.constraintlayout.compose;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class MotionLayoutKt {
    public static final void a(final ConstraintSet constraintSet, final ConstraintSet constraintSet2, final Transition transition, final float f3, final LayoutInformationReceiver layoutInformationReceiver, final int i3, final boolean z2, final boolean z3, final boolean z4, final Modifier modifier, final MutableState mutableState, final Ref ref, final InvalidationStrategy invalidationStrategy, final Function3 function3, Composer composer, final int i4, final int i5) {
        int i6;
        ConstraintSet constraintSet3;
        int i7;
        int i8;
        TransitionImpl transitionImpl;
        Composer composer2;
        boolean z5;
        boolean z6;
        boolean z7;
        Composer composerK = composer.k(-657259923);
        if ((i4 & 6) == 0) {
            i6 = (composerK.Z(constraintSet) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            constraintSet3 = constraintSet2;
            i6 |= composerK.Z(constraintSet3) ? 32 : 16;
        } else {
            constraintSet3 = constraintSet2;
        }
        int i9 = i4 & 384;
        int i10 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i9 == 0) {
            i6 |= composerK.Z(transition) ? Function.MAX_NARGS : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= (32768 & i4) == 0 ? composerK.Z(layoutInformationReceiver) : composerK.I(layoutInformationReceiver) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i7 = i3;
            i6 |= composerK.e(i7) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            i7 = i3;
        }
        if ((i4 & 1572864) == 0) {
            i6 |= composerK.b(z2) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i6 |= composerK.b(z3) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerK.b(z4) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= composerK.Z(modifier) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i8 = i5 | (composerK.Z(mutableState) ? 4 : 2);
        } else {
            i8 = i5;
        }
        if ((i5 & 48) == 0) {
            i8 |= (i5 & 64) == 0 ? composerK.Z(ref) : composerK.I(ref) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            if (composerK.I(invalidationStrategy)) {
                i10 = Function.MAX_NARGS;
            }
            i8 |= i10;
        }
        if ((i5 & 3072) == 0) {
            i8 |= composerK.I(function3) ? 2048 : 1024;
        }
        int i11 = i8;
        if ((i6 & 306783379) == 306783378 && (i11 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-657259923, i6, i11, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:575)");
            }
            int i12 = i6 >> 9;
            MutableFloatState mutableFloatStateQ = q(f3, composerK, i12 & 14);
            TransitionImpl transitionImplA = transition instanceof TransitionImpl ? (TransitionImpl) transition : null;
            if (transitionImplA == null) {
                transitionImplA = TransitionImpl.f30993b.a();
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotLongStateKt.a(0L);
                composerK.w(objG);
            }
            MutableLongState mutableLongState = (MutableLongState) objG;
            mutableLongState.d();
            if (layoutInformationReceiver != null) {
                layoutInformationReceiver.s(mutableLongState);
            }
            j(mutableFloatStateQ, layoutInformationReceiver, composerK, i12 & 112);
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            LayoutDirection layoutDirection = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new MotionMeasurer(density);
                composerK.w(objG2);
            }
            final MotionMeasurer motionMeasurer = (MotionMeasurer) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new MotionLayoutScope(motionMeasurer, mutableFloatStateQ);
                composerK.w(objG3);
            }
            final MotionLayoutScope motionLayoutScope = (MotionLayoutScope) objG3;
            boolean z8 = ((i6 & 14) == 4) | ((i6 & 112) == 32) | ((i6 & 896) == 256);
            Object objG4 = composerK.G();
            if (z8 || objG4 == companion.a()) {
                transitionImpl = transitionImplA;
                motionMeasurer.H(constraintSet, constraintSet3, layoutDirection, transitionImpl, mutableFloatStateQ.c());
                objG4 = Boolean.TRUE;
                composerK.w(objG4);
            } else {
                transitionImpl = transitionImplA;
            }
            ((Boolean) objG4).getClass();
            composerK.a0(-487866413);
            if (invalidationStrategy.d() != null) {
                Snapshot.Companion companion2 = Snapshot.f24914e;
                boolean z9 = ((i11 & 14) == 4) | ((i11 & 112) == 32 || ((i11 & 64) != 0 && composerK.I(ref)));
                Object objG5 = composerK.G();
                if (z9 || objG5 == companion.a()) {
                    objG5 = new Function1<Object, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void c(Object obj) {
                            mutableState.setValue(Unit.f139807a);
                            if (ref.a() == CompositionSource.Unknown) {
                                ref.b(CompositionSource.Content);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c(obj);
                            return Unit.f139807a;
                        }
                    };
                    composerK.w(objG5);
                }
                Snapshot.Companion.h(companion2, (Function1) objG5, null, invalidationStrategy.d(), 2, null);
            }
            composerK.U();
            composer2 = composerK;
            MeasurePolicy measurePolicyS = s(mutableState, ref, constraintSet, constraintSet2, transitionImpl, mutableFloatStateQ, motionMeasurer, i7, invalidationStrategy);
            motionMeasurer.c(layoutInformationReceiver);
            MotionLayoutDebugFlags motionLayoutDebugFlagsD = layoutInformationReceiver != null ? layoutInformationReceiver.d() : null;
            float fL = motionMeasurer.l();
            if (motionLayoutDebugFlagsD == null || motionLayoutDebugFlagsD == MotionLayoutDebugFlags.UNKNOWN) {
                z5 = z2;
                z6 = z3;
                z7 = z4;
            } else {
                z5 = motionLayoutDebugFlagsD == MotionLayoutDebugFlags.SHOW_ALL;
                z6 = z5;
                z7 = z6;
            }
            composer2.a0(-487808243);
            boolean z10 = Build.VERSION.SDK_INT >= 30 && Api30Impl.a((View) composer2.q(AndroidCompositionLocals_androidKt.j()));
            composer2.U();
            Modifier modifierC = MotionDragHandlerKt.c(r(modifier, motionMeasurer, fL, z10 ? true : z5, z6, z7), transition == null ? TransitionImpl.f30993b.a() : transition, mutableFloatStateQ, motionMeasurer);
            boolean zI = composer2.I(motionMeasurer);
            Object objG6 = composer2.G();
            if (zI || objG6 == companion.a()) {
                objG6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.a(semanticsPropertyReceiver, motionMeasurer);
                    }
                };
                composer2.w(objG6);
            }
            LayoutKt.a(SemanticsModifierKt.f(modifierC, false, (Function1) objG6, 1, null), ComposableLambdaKt.e(1008059664, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10
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
                        ComposerKt.U(1008059664, i13, -1, "androidx.constraintlayout.compose.MotionLayoutCore.<anonymous> (MotionLayout.kt:675)");
                    }
                    function3.invoke(motionLayoutScope, composer3, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), measurePolicyS, composer2, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$11
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
                    MotionLayoutKt.a(constraintSet, constraintSet2, transition, f3, layoutInformationReceiver, i3, z2, z3, z4, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    public static final void b(final MotionScene motionScene, final float f3, final String str, final int i3, final int i4, final Modifier modifier, final MutableState mutableState, final Ref ref, final InvalidationStrategy invalidationStrategy, final Function3 function3, Composer composer, final int i5) {
        int i6;
        float f4;
        int i7;
        int i8;
        Function3 function32;
        String strA;
        String strB;
        Composer composer2;
        Composer composerK = composer.k(1160212844);
        if ((i5 & 6) == 0) {
            i6 = (composerK.Z(motionScene) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            f4 = f3;
            i6 |= composerK.c(f4) ? 32 : 16;
        } else {
            f4 = f3;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i7 = i3;
            i6 |= composerK.e(i7) ? 2048 : 1024;
        } else {
            i7 = i3;
        }
        if ((i5 & 24576) == 0) {
            i8 = i4;
            i6 |= composerK.e(i8) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            i8 = i4;
        }
        if ((196608 & i5) == 0) {
            i6 |= composerK.Z(modifier) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i5) == 0) {
            i6 |= composerK.Z(mutableState) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= (16777216 & i5) == 0 ? composerK.Z(ref) : composerK.I(ref) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= composerK.I(invalidationStrategy) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            function32 = function3;
            i6 |= composerK.I(function32) ? 536870912 : 268435456;
        } else {
            function32 = function3;
        }
        if ((i6 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1160212844, i6, -1, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:521)");
            }
            int i9 = i6 & 14;
            boolean z2 = ((i6 & 896) == 256) | (i9 == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = motionScene.k(str);
                composerK.w(objG);
            }
            Transition transition = (Transition) objG;
            boolean Z = (i9 == 4) | composerK.Z(transition);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                if (transition == null || (strA = transition.a()) == null) {
                    strA = "start";
                }
                objG2 = motionScene.c(strA);
                composerK.w(objG2);
            }
            ConstraintSet constraintSet = (ConstraintSet) objG2;
            boolean Z2 = (i9 == 4) | composerK.Z(transition);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                if (transition == null || (strB = transition.b()) == null) {
                    strB = "end";
                }
                objG3 = motionScene.c(strB);
                composerK.w(objG3);
            }
            ConstraintSet constraintSet2 = (ConstraintSet) objG3;
            if (constraintSet == null || constraintSet2 == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer3, int i10) {
                            MotionLayoutKt.b(motionScene, f3, str, i3, i4, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.a(i5 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            composer2 = composerK;
            int i10 = ((i6 << 6) & 465920) | ((i6 << 12) & 1879048192);
            int i11 = i6 >> 18;
            a(constraintSet, constraintSet2, transition, f4, motionScene instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) motionScene : null, i7, DebugFlags.d(i8), DebugFlags.f(i4), DebugFlags.e(i4), modifier, mutableState, ref, invalidationStrategy, function32, composer2, i10, (i11 & 14) | (Ref.f27633b << 3) | (i11 & 112) | (i11 & 896) | (i11 & 7168));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composer2.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i12) {
                    MotionLayoutKt.b(motionScene, f3, str, i3, i4, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.a(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final androidx.constraintlayout.compose.MotionScene r25, final java.lang.String r26, final androidx.compose.animation.core.AnimationSpec r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function0 r29, int r30, int r31, final androidx.compose.runtime.MutableState r32, final androidx.compose.ui.node.Ref r33, final androidx.constraintlayout.compose.InvalidationStrategy r34, final kotlin.jvm.functions.Function3 r35, androidx.compose.runtime.Composer r36, final int r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 1132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.c(androidx.constraintlayout.compose.MotionScene, java.lang.String, androidx.compose.animation.core.AnimationSpec, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, int, int, androidx.compose.runtime.MutableState, androidx.compose.ui.node.Ref, androidx.constraintlayout.compose.InvalidationStrategy, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet d(MutableState mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableState mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet f(MutableState mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MutableState mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    public static final void j(final MutableFloatState mutableFloatState, final LayoutInformationReceiver layoutInformationReceiver, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1501096015);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(mutableFloatState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(layoutInformationReceiver) : composerK.I(layoutInformationReceiver) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1501096015, i4, -1, "androidx.constraintlayout.compose.UpdateWithForcedIfNoUserChange (MotionLayout.kt:1011)");
            }
            if (layoutInformationReceiver == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$UpdateWithForcedIfNoUserChange$1
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
                            MotionLayoutKt.j(mutableFloatState, layoutInformationReceiver, composer2, RecomposeScopeImplKt.a(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            float fC = mutableFloatState.c();
            float fE = layoutInformationReceiver.e();
            Object objG = composerK.G();
            Object obj = objG;
            if (objG == Composer.f23746a.a()) {
                Ref ref = new Ref();
                ref.b(Float.valueOf(fC));
                composerK.w(ref);
                obj = ref;
            }
            Ref ref2 = (Ref) obj;
            if (Float.isNaN(fE) || !Intrinsics.areEqual((Float) ref2.a(), fC)) {
                layoutInformationReceiver.n();
            } else {
                mutableFloatState.s(fE);
            }
            ref2.b(Float.valueOf(fC));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$UpdateWithForcedIfNoUserChange$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    MotionLayoutKt.j(mutableFloatState, layoutInformationReceiver, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final MutableFloatState q(float f3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1721363510, i3, -1, "androidx.constraintlayout.compose.createAndUpdateMotionProgress (MotionLayout.kt:1038)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = PrimitiveSnapshotStateKt.a(f3);
            composer.w(objG);
        }
        MutableFloatState mutableFloatState = (MutableFloatState) objG;
        Object objG2 = composer.G();
        Object obj = objG2;
        if (objG2 == companion.a()) {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.f140141a = f3;
            composer.w(floatRef);
            obj = floatRef;
        }
        Ref.FloatRef floatRef2 = (Ref.FloatRef) obj;
        if (floatRef2.f140141a != f3) {
            floatRef2.f140141a = f3;
            mutableFloatState.s(f3);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableFloatState;
    }

    public static final Modifier r(Modifier modifier, final MotionMeasurer motionMeasurer, float f3, final boolean z2, final boolean z3, final boolean z4) {
        if (!Float.isNaN(f3)) {
            modifier = ScaleKt.a(modifier, f3);
        }
        return (z2 || z4 || z3) ? DrawModifierKt.b(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$motionDebug$1
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
                motionMeasurer.B(drawScope, z2, z3, z4);
            }
        }) : modifier;
    }

    public static final MeasurePolicy s(final androidx.compose.runtime.State state, final androidx.compose.ui.node.Ref ref, final ConstraintSet constraintSet, final ConstraintSet constraintSet2, final TransitionImpl transitionImpl, final MutableFloatState mutableFloatState, final MotionMeasurer motionMeasurer, final int i3, final InvalidationStrategy invalidationStrategy) {
        return new MeasurePolicy() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$motionLayoutMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, final List list, long j3) {
                state.getValue();
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                ConstraintSet constraintSet3 = constraintSet;
                ConstraintSet constraintSet4 = constraintSet2;
                TransitionImpl transitionImpl2 = transitionImpl;
                int i4 = i3;
                float fC = mutableFloatState.c();
                CompositionSource compositionSource = (CompositionSource) ref.a();
                if (compositionSource == null) {
                    compositionSource = CompositionSource.Unknown;
                }
                long jK = motionMeasurer2.K(j3, layoutDirection, constraintSet3, constraintSet4, transitionImpl2, list, i4, fC, compositionSource, invalidationStrategy.e());
                ref.b(CompositionSource.Unknown);
                int iG = IntSize.g(jK);
                int iF = IntSize.f(jK);
                final MotionMeasurer motionMeasurer3 = motionMeasurer;
                return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$motionLayoutMeasurePolicy$1.1
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
                        motionMeasurer3.w(placementScope, list);
                    }
                }, 4, null);
            }
        };
    }
}
