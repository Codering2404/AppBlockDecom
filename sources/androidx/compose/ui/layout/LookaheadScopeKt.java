package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
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
public final class LookaheadScopeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function2 f27149a = new Function2<Placeable.PlacementScope, LayoutCoordinates, Boolean>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$defaultPlacementApproachInProgress$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
            return Boolean.FALSE;
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final Function3 function3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1078066484);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        int i5 = 1;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1078066484, i4, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:48)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new LookaheadScopeImpl(null, i5, 0 == true ? 1 : 0);
                composerK.w(objG);
            }
            LookaheadScopeImpl lookaheadScopeImpl = (LookaheadScopeImpl) objG;
            LookaheadScopeKt$LookaheadScope$1 lookaheadScopeKt$LookaheadScope$1 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LayoutNode invoke() {
                    return new LayoutNode(true, 0, 2, null);
                }
            };
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(lookaheadScopeKt$LookaheadScope$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.d(composerA, new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$1
                public final void c(LayoutNode layoutNode) {
                    layoutNode.a2(true);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((LayoutNode) obj);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, lookaheadScopeImpl, new Function2<LayoutNode, LookaheadScopeImpl, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$2
                public final void c(final LayoutNode layoutNode, LookaheadScopeImpl lookaheadScopeImpl2) {
                    lookaheadScopeImpl2.a(new Function0<LayoutCoordinates>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final LayoutCoordinates invoke() {
                            LayoutNode layoutNodeB0 = layoutNode.B0();
                            Intrinsics.checkNotNull(layoutNodeB0);
                            return layoutNodeB0.Z().u1();
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((LayoutNode) obj, (LookaheadScopeImpl) obj2);
                    return Unit.f139807a;
                }
            });
            function3.invoke(lookaheadScopeImpl, composerK, Integer.valueOf((i4 << 3) & 112));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$4
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
                    LookaheadScopeKt.a(function3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final long b(LookaheadScope lookaheadScope, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j3, boolean z2) {
        LayoutCoordinates layoutCoordinatesX = lookaheadScope.x(layoutCoordinates);
        LayoutCoordinates layoutCoordinatesX2 = lookaheadScope.x(layoutCoordinates2);
        return layoutCoordinatesX instanceof LookaheadLayoutCoordinates ? layoutCoordinatesX.Q(layoutCoordinatesX2, j3, z2) : layoutCoordinatesX2 instanceof LookaheadLayoutCoordinates ? Offset.e(layoutCoordinatesX2.Q(layoutCoordinatesX, j3, z2) ^ (-9223372034707292160L)) : layoutCoordinatesX.Q(layoutCoordinatesX, j3, z2);
    }
}
