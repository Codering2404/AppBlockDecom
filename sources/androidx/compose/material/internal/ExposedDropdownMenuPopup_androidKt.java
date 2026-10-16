package androidx.compose.material.internal;

import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
public final class ExposedDropdownMenuPopup_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f15186a = CompositionLocalKt.e(null, new Function0<String>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);

    public static final void a(Function0 function0, PopupPositionProvider popupPositionProvider, final Function2 function2, Composer composer, final int i3, final int i4) {
        Function0 function02;
        int i5;
        final Function0 function03;
        int i6;
        int i7;
        final PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composerK = composer.k(-707851182);
        int i8 = i4 & 1;
        if (i8 != 0) {
            i5 = i3 | 6;
            function02 = function0;
        } else if ((i3 & 6) == 0) {
            function02 = function0;
            i5 = (composerK.I(function02) ? 4 : 2) | i3;
        } else {
            function02 = function0;
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(popupPositionProvider2) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
            function03 = function02;
        } else {
            function03 = i8 != 0 ? null : function02;
            if (ComposerKt.M()) {
                ComposerKt.U(-707851182, i5, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.android.kt:83)");
            }
            View view = (View) composerK.q(AndroidCompositionLocals_androidKt.j());
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            final String str = (String) composerK.q(f15186a);
            final LayoutDirection layoutDirection = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
            CompositionContext compositionContextD = ComposablesKt.d(composerK, 0);
            final State stateP = SnapshotStateKt.p(function2, composerK, (i5 >> 6) & 14);
            UUID uuid = (UUID) RememberSaveableKt.e(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupId$1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, composerK, 3072, 6);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                i6 = 4;
                i7 = i5;
                final PopupLayout popupLayout = new PopupLayout(function03, str, view, density, popupPositionProvider2, uuid);
                str = str;
                popupPositionProvider2 = popupPositionProvider2;
                popupLayout.i(compositionContextD, ComposableLambdaKt.c(580081703, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(580081703, i9, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.android.kt:101)");
                        }
                        Modifier modifierF = SemanticsModifierKt.f(Modifier.b8, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.R(semanticsPropertyReceiver);
                            }
                        }, 1, null);
                        boolean zI = composer2.I(popupLayout);
                        final PopupLayout popupLayout2 = popupLayout;
                        Object objG2 = composer2.G();
                        if (zI || objG2 == Composer.f23746a.a()) {
                            objG2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    m140invokeozmzZPI(((IntSize) obj).j());
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m140invokeozmzZPI(long j3) {
                                    popupLayout2.m142setPopupContentSizefhxjrPA(IntSize.b(j3));
                                    popupLayout2.o();
                                }
                            };
                            composer2.w(objG2);
                        }
                        Modifier modifierA = AlphaKt.a(OnRemeasuredModifierKt.a(modifierF, (Function1) objG2), popupLayout.getCanCalculatePosition() ? 1.0f : 0.0f);
                        final State state = stateP;
                        ComposableLambda composableLambdaE = ComposableLambdaKt.e(1347607057, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer3, int i10) {
                                if ((i10 & 3) == 2 && composer3.l()) {
                                    composer3.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(1347607057, i10, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.android.kt:112)");
                                }
                                ExposedDropdownMenuPopup_androidKt.b(state).invoke(composer3, 0);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer2, 54);
                        ExposedDropdownMenuPopup_androidKt$SimpleStack$1 exposedDropdownMenuPopup_androidKt$SimpleStack$1 = new MeasurePolicy() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                                int i10;
                                int i11;
                                int size = list.size();
                                if (size == 0) {
                                    return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1.1
                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.f139807a;
                                        }
                                    }, 4, null);
                                }
                                int i12 = 0;
                                if (size == 1) {
                                    final Placeable placeableN0 = ((Measurable) list.get(0)).n0(j3);
                                    return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1.2
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
                                        }
                                    }, 4, null);
                                }
                                final ArrayList arrayList = new ArrayList(list.size());
                                int size2 = list.size();
                                for (int i13 = 0; i13 < size2; i13++) {
                                    arrayList.add(((Measurable) list.get(i13)).n0(j3));
                                }
                                int lastIndex = CollectionsKt.getLastIndex(arrayList);
                                if (lastIndex >= 0) {
                                    int iMax = 0;
                                    int iMax2 = 0;
                                    while (true) {
                                        Placeable placeable = (Placeable) arrayList.get(i12);
                                        iMax = Math.max(iMax, placeable.X0());
                                        iMax2 = Math.max(iMax2, placeable.O0());
                                        if (i12 == lastIndex) {
                                            break;
                                        }
                                        i12++;
                                    }
                                    i10 = iMax;
                                    i11 = iMax2;
                                } else {
                                    i10 = 0;
                                    i11 = 0;
                                }
                                return MeasureScope.B0(measureScope, i10, i11, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1.3
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
                                        int lastIndex2 = CollectionsKt.getLastIndex(arrayList);
                                        if (lastIndex2 < 0) {
                                            return;
                                        }
                                        int i14 = 0;
                                        while (true) {
                                            Placeable.PlacementScope placementScope2 = placementScope;
                                            Placeable.PlacementScope.m(placementScope2, (Placeable) arrayList.get(i14), 0, 0, 0.0f, 4, null);
                                            if (i14 == lastIndex2) {
                                                return;
                                            }
                                            i14++;
                                            placementScope = placementScope2;
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        int iA = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU = composer2.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierA);
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
                        Updater.e(composerA, exposedDropdownMenuPopup_androidKt$SimpleStack$1, companion2.e());
                        Updater.e(composerA, compositionLocalMapU, companion2.g());
                        Function2 function2B = companion2.b();
                        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                            composerA.w(Integer.valueOf(iA));
                            composerA.p(Integer.valueOf(iA), function2B);
                        }
                        Updater.e(composerA, modifierF2, companion2.f());
                        composableLambdaE.invoke(composer2, 6);
                        composer2.y();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }));
                composerK.w(popupLayout);
                objG = popupLayout;
            } else {
                i6 = 4;
                i7 = i5;
            }
            final PopupLayout popupLayout2 = (PopupLayout) objG;
            int i9 = i7 & 14;
            boolean zI = composerK.I(popupLayout2) | (i9 == i6) | composerK.Z(str) | composerK.Z(layoutDirection);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        popupLayout2.k();
                        popupLayout2.n(function03, str, layoutDirection);
                        final PopupLayout popupLayout3 = popupLayout2;
                        return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                popupLayout3.disposeComposition();
                                popupLayout3.dismiss();
                            }
                        };
                    }
                };
                composerK.w(objG2);
            }
            EffectsKt.c(popupLayout2, (Function1) objG2, composerK, 0);
            boolean zI2 = composerK.I(popupLayout2) | (i9 == i6) | composerK.Z(str) | composerK.Z(layoutDirection);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == companion.a()) {
                objG3 = new Function0<Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m139invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m139invoke() {
                        popupLayout2.n(function03, str, layoutDirection);
                    }
                };
                composerK.w(objG3);
            }
            EffectsKt.j((Function0) objG3, composerK, 0);
            boolean zI3 = composerK.I(popupLayout2) | ((i7 & 112) == 32);
            Object objG4 = composerK.G();
            if (zI3 || objG4 == companion.a()) {
                objG4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        popupLayout2.setPositionProvider(popupPositionProvider2);
                        popupLayout2.o();
                        return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                composerK.w(objG4);
            }
            EffectsKt.c(popupPositionProvider2, (Function1) objG4, composerK, (i7 >> 3) & 14);
            Modifier.Companion companion2 = Modifier.b8;
            boolean zI4 = composerK.I(popupLayout2);
            Object objG5 = composerK.G();
            if (zI4 || objG5 == companion.a()) {
                objG5 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$5$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((LayoutCoordinates) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                        LayoutCoordinates layoutCoordinatesR0 = layoutCoordinates.r0();
                        Intrinsics.checkNotNull(layoutCoordinatesR0);
                        long jA = layoutCoordinatesR0.a();
                        long jG = LayoutCoordinatesKt.g(layoutCoordinatesR0);
                        popupLayout2.j(IntRectKt.a(IntOffsetKt.a(MathKt.d(Offset.m(jG)), MathKt.d(Offset.n(jG))), jA));
                        popupLayout2.o();
                    }
                };
                composerK.w(objG5);
            }
            Modifier modifierA = OnGloballyPositionedModifierKt.a(companion2, (Function1) objG5);
            boolean zI5 = composerK.I(popupLayout2) | composerK.Z(layoutDirection);
            Object objG6 = composerK.G();
            if (zI5 || objG6 == companion.a()) {
                objG6 = new MeasurePolicy() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                        popupLayout2.setParentLayoutDirection(layoutDirection);
                        return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1.1
                            public final void invoke(Placeable.PlacementScope placementScope) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG6);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG6;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA);
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
            Updater.e(composerA, measurePolicy, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    ExposedDropdownMenuPopup_androidKt.a(function03, popupPositionProvider2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2 b(State state) {
        return (Function2) state.getValue();
    }
}
