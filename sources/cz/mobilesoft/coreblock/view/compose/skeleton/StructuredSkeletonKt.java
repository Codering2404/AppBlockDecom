package cz.mobilesoft.coreblock.view.compose.skeleton;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonSlot;
import cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StructuredSkeletonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(float f3, Shimmer shimmer, Composer composer, final int i3) {
        int i4;
        final float f4;
        final Shimmer shimmer2;
        Composer composerK = composer.k(1631603575);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1631603575, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonRoundedItem (StructuredSkeleton.kt:464)");
            }
            f4 = f3;
            shimmer2 = shimmer;
            SkeletonItemKt.g(f4, null, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0)), 0L, shimmer2, composerK, (i4 & 14) | (Shimmer.f93784d << 12) | ((i4 << 9) & 57344), 10);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            f4 = f3;
            shimmer2 = shimmer;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.B(f4, shimmer2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(float f3, Shimmer shimmer, int i3, Composer composer, int i4) {
        A(f3, shimmer, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void C(final List list, final Arrangement.Horizontal horizontal, final Shimmer shimmer, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1711555404);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(horizontal) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1711555404, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonRowContent (StructuredSkeleton.kt:498)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontal, Alignment.f25072a.i(), composerK, ((((i4 & 112) | 390) >> 3) & 14) | 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(286808786);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                q((SkeletonSlot) it.next(), shimmer, composerK, (Shimmer.f93784d << 3) | ((i4 >> 3) & 112));
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.D(list, horizontal, shimmer, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(List list, Arrangement.Horizontal horizontal, Shimmer shimmer, int i3, Composer composer, int i4) {
        C(list, horizontal, shimmer, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void E(final boolean r16, final java.util.List r17, androidx.compose.ui.Modifier r18, boolean r19, com.valentinilk.shimmer.Shimmer r20, final kotlin.jvm.functions.Function2 r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt.E(boolean, java.util.List, androidx.compose.ui.Modifier, boolean, com.valentinilk.shimmer.Shimmer, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(List list, Shimmer shimmer, Modifier modifier, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1861429194, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonColumn.<anonymous> (StructuredSkeleton.kt:141)");
            }
            y(list, shimmer, modifier, composer, Shimmer.f93784d << 3, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(boolean z2, List list, Modifier modifier, boolean z3, Shimmer shimmer, Function2 function2, int i3, int i4, Composer composer, int i5) {
        E(z2, list, modifier, z3, shimmer, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m(final boolean r23, final boolean r24, final kotlin.jvm.functions.Function2 r25, final kotlin.jvm.functions.Function2 r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt.m(boolean, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(1489099882, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.CrossfadeContent.<anonymous>.<anonymous> (StructuredSkeleton.kt:525)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-736820767, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.CrossfadeContent.<anonymous>.<anonymous> (StructuredSkeleton.kt:533)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z2, boolean z3, Function2 function2, Function2 function22, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        m(z2, z3, function2, function22, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void q(final SkeletonSlot skeletonSlot, Shimmer shimmer, Composer composer, final int i3) {
        final Shimmer shimmer2;
        Composer composerK = composer.k(288605868);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(skeletonSlot) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(288605868, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.RenderSkeletonSlot (StructuredSkeleton.kt:323)");
            }
            TextStyle textStyleB = MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).b();
            if (skeletonSlot instanceof SkeletonSlot.TextSlot) {
                composerK.a0(-666893336);
                SkeletonSlot.TextSlot textSlot = (SkeletonSlot.TextSlot) skeletonSlot;
                if (textSlot.a() == 1) {
                    composerK.a0(-666867141);
                    shimmer2 = shimmer;
                    SkeletonItemKt.o(textSlot.b(), null, textStyleB, 0L, shimmer2, composerK, (Shimmer.f93784d << 12) | ((i4 << 9) & 57344), 10);
                    composerK.U();
                } else {
                    composerK.a0(-666643786);
                    SkeletonItemKt.p(textSlot.a(), null, textStyleB, 0.0f, 0L, shimmer, composerK, (Shimmer.f93784d << 15) | ((i4 << 12) & 458752), 26);
                    shimmer2 = shimmer;
                    composerK = composerK;
                    composerK.U();
                }
                composerK.U();
            } else {
                shimmer2 = shimmer;
                if (skeletonSlot instanceof SkeletonSlot.CardSlot) {
                    composerK.a0(-1822611365);
                    SkeletonItemKt.g(((SkeletonSlot.CardSlot) skeletonSlot).a(), null, null, 0L, shimmer2, composerK, (Shimmer.f93784d << 12) | ((i4 << 9) & 57344), 14);
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.CircleSlot) {
                    composerK.a0(-1822606535);
                    SkeletonItemKt.i(((SkeletonSlot.CircleSlot) skeletonSlot).a(), null, 0L, shimmer2, composerK, (Shimmer.f93784d << 9) | ((i4 << 6) & 7168), 6);
                    composerK = composerK;
                    shimmer2 = shimmer2;
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.CenteredCircleSlot) {
                    composerK.a0(-1822601503);
                    u(((SkeletonSlot.CenteredCircleSlot) skeletonSlot).a(), shimmer2, composerK, (i4 & 112) | (Shimmer.f93784d << 3));
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.ListItemSlot) {
                    composerK.a0(-1822596303);
                    SkeletonSlot.ListItemSlot listItemSlot = (SkeletonSlot.ListItemSlot) skeletonSlot;
                    SkeletonItemKt.k(listItemSlot.a(), null, listItemSlot.b(), listItemSlot.c(), 0L, shimmer2, composerK, (Shimmer.f93784d << 15) | ((i4 << 12) & 458752), 18);
                    shimmer2 = shimmer2;
                    composerK = composerK;
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.RectangleSlot) {
                    composerK.a0(-1822587658);
                    SkeletonSlot.RectangleSlot rectangleSlot = (SkeletonSlot.RectangleSlot) skeletonSlot;
                    Dp dpB = rectangleSlot.b();
                    SkeletonItemKt.m(dpB != null ? dpB.l() : Dp.f29970b.c(), rectangleSlot.a(), null, null, 0L, shimmer2, composerK, (Shimmer.f93784d << 15) | ((i4 << 12) & 458752), 28);
                    shimmer2 = shimmer2;
                    composerK = composerK;
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.RectanglePercentSlot) {
                    composerK.a0(-665423998);
                    SkeletonSlot.RectanglePercentSlot rectanglePercentSlot = (SkeletonSlot.RectanglePercentSlot) skeletonSlot;
                    SkeletonItemKt.g(rectanglePercentSlot.a(), SizeKt.g(Modifier.b8, rectanglePercentSlot.b()), null, 0L, shimmer2, composerK, (Shimmer.f93784d << 12) | ((i4 << 9) & 57344), 12);
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.SpacerSlot) {
                    composerK.a0(-1822573701);
                    SpacerKt.a(SizeKt.i(Modifier.b8, ((SkeletonSlot.SpacerSlot) skeletonSlot).a()), composerK, 0);
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.RowSlot) {
                    composerK.a0(-1822570877);
                    SkeletonSlot.RowSlot rowSlot = (SkeletonSlot.RowSlot) skeletonSlot;
                    C(rowSlot.b(), rowSlot.a(), shimmer2, composerK, ((i4 << 3) & 896) | (Shimmer.f93784d << 6));
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.RepeatSlot) {
                    composerK.a0(-664903260);
                    SkeletonSlot.RepeatSlot repeatSlot = (SkeletonSlot.RepeatSlot) skeletonSlot;
                    int iA = repeatSlot.a();
                    for (int i5 = 0; i5 < iA; i5++) {
                        q(repeatSlot.b(), shimmer2, composerK, (Shimmer.f93784d << 3) | (i4 & 112));
                    }
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.RepeatWithSpacerSlot) {
                    composerK.a0(-664736387);
                    SkeletonSlot.RepeatWithSpacerSlot repeatWithSpacerSlot = (SkeletonSlot.RepeatWithSpacerSlot) skeletonSlot;
                    int iA2 = repeatWithSpacerSlot.a();
                    for (int i6 = 0; i6 < iA2; i6++) {
                        q(repeatWithSpacerSlot.b(), shimmer2, composerK, (Shimmer.f93784d << 3) | (i4 & 112));
                        if (i6 < repeatWithSpacerSlot.a() - 1) {
                            composerK.a0(1298415630);
                            SpacerKt.a(SizeKt.i(Modifier.b8, repeatWithSpacerSlot.c()), composerK, 0);
                        } else {
                            composerK.a0(1282942755);
                        }
                        composerK.U();
                    }
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.CustomSlot) {
                    composerK.a0(-1822549244);
                    ((SkeletonSlot.CustomSlot) skeletonSlot).a().invoke(shimmer2, composerK, Integer.valueOf(((i4 >> 3) & 14) | Shimmer.f93784d));
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.BarChartSlot) {
                    composerK.a0(-1822546947);
                    SkeletonSlot.BarChartSlot barChartSlot = (SkeletonSlot.BarChartSlot) skeletonSlot;
                    s(barChartSlot.a(), barChartSlot.b(), barChartSlot.c(), shimmer2, composerK, (Shimmer.f93784d << 9) | ((i4 << 6) & 7168));
                    shimmer2 = shimmer2;
                    composerK.U();
                } else if (skeletonSlot instanceof SkeletonSlot.RoundedItemSlot) {
                    composerK.a0(-1822538910);
                    A(((SkeletonSlot.RoundedItemSlot) skeletonSlot).a(), shimmer2, composerK, (i4 & 112) | (Shimmer.f93784d << 3));
                    composerK.U();
                } else {
                    if (!(skeletonSlot instanceof SkeletonSlot.CenteredItemSlot)) {
                        composerK.a0(-1822626915);
                        composerK.U();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerK.a0(-1822533611);
                    SkeletonSlot.CenteredItemSlot centeredItemSlot = (SkeletonSlot.CenteredItemSlot) skeletonSlot;
                    w(centeredItemSlot.b(), centeredItemSlot.a(), shimmer2, composerK, ((i4 << 3) & 896) | (Shimmer.f93784d << 6));
                    composerK.U();
                }
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            shimmer2 = shimmer;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.r(skeletonSlot, shimmer2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(SkeletonSlot skeletonSlot, Shimmer shimmer, int i3, Composer composer, int i4) {
        q(skeletonSlot, shimmer, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void s(final int i3, final float f3, final float f4, final Shimmer shimmer, Composer composer, final int i4) {
        int i5;
        float f5;
        Shimmer shimmer2 = shimmer;
        Composer composerK = composer.k(1599936821);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            f5 = f3;
            i5 |= composerK.c(f5) ? 32 : 16;
        } else {
            f5 = f3;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= (i4 & 4096) == 0 ? composerK.Z(shimmer2) : composerK.I(shimmer2) ? 2048 : 1024;
        }
        int i6 = i5;
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1599936821, i6, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonBarChart (StructuredSkeleton.kt:424)");
            }
            Modifier modifierI = SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), f4);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.f(), Alignment.f25072a.a(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(787166867);
            int i7 = 0;
            while (i7 < i3) {
                SkeletonItemKt.m(f5, Dp.g(0.9f * f4), null, RoundedCornerShapeKt.d(Dp.g(8)), 0L, shimmer2, composerK, ((i6 >> 3) & 14) | (Shimmer.f93784d << 15) | (458752 & (i6 << 6)), 20);
                i7++;
                f5 = f3;
                shimmer2 = shimmer;
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.t(i3, f3, f4, shimmer, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i3, float f3, float f4, Shimmer shimmer, int i4, Composer composer, int i5) {
        s(i3, f3, f4, shimmer, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void u(float f3, Shimmer shimmer, Composer composer, final int i3) {
        int i4;
        final float f4;
        final Shimmer shimmer2;
        Composer composerK = composer.k(2122708381);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2122708381, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonCenteredCircle (StructuredSkeleton.kt:448)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            f4 = f3;
            shimmer2 = shimmer;
            SkeletonItemKt.i(f4, null, 0L, shimmer2, composerK, (i4 & 14) | (Shimmer.f93784d << 9) | ((i4 << 6) & 7168), 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            f4 = f3;
            shimmer2 = shimmer;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.v(f4, shimmer2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(float f3, Shimmer shimmer, int i3, Composer composer, int i4) {
        u(f3, shimmer, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void w(final float f3, float f4, Shimmer shimmer, Composer composer, final int i3) {
        int i4;
        final float f5;
        final Shimmer shimmer2;
        Composer composerK = composer.k(-307938454);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-307938454, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonCenteredItem (StructuredSkeleton.kt:478)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            f5 = f4;
            shimmer2 = shimmer;
            SkeletonItemKt.m(Dp.f29970b.c(), f5, SizeKt.g(companion, f3), RoundedCornerShapeKt.d(Dp.g(16)), 0L, shimmer2, composerK, (i4 & 112) | 6 | (Shimmer.f93784d << 15) | ((i4 << 9) & 458752), 16);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            f5 = f4;
            shimmer2 = shimmer;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.x(f3, f5, shimmer2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(float f3, float f4, Shimmer shimmer, int i3, Composer composer, int i4) {
        w(f3, f4, shimmer, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void y(final List list, final Shimmer shimmer, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-1808508061);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= (i3 & 64) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1808508061, i5, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonColumnContent (StructuredSkeleton.kt:309)");
            }
            Modifier modifierH = SizeKt.h(modifier, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(1470523139);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                q((SkeletonSlot) it.next(), shimmer, composerK, (Shimmer.f93784d << 3) | (i5 & 112));
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j2.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StructuredSkeletonKt.z(list, shimmer, modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(List list, Shimmer shimmer, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        y(list, shimmer, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
