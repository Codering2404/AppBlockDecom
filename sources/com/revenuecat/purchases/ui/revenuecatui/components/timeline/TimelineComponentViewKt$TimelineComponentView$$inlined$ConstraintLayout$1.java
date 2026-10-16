package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.LayoutReference;
import androidx.constraintlayout.compose.RawConstraintSet;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ MutableState $end;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ MutableState $start;
    final /* synthetic */ PaywallState.Loaded.Components $state$inlined;
    final /* synthetic */ TimelineComponentState $timelineState$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1(MutableState mutableState, Ref ref, ConstraintLayoutScope constraintLayoutScope, Channel channel, MutableState mutableState2, MutableState mutableState3, TimelineComponentState timelineComponentState, PaywallState.Loaded.Components components) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
        this.$timelineState$inlined = timelineComponentState;
        this.$state$inlined = components;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(Composer composer, int i3) {
        boolean z2;
        int i4;
        SizeConstraint.Fixed fixed;
        float fG;
        Iterator it;
        PaddingValues paddingValuesA;
        int i5;
        ArrayList arrayList;
        boolean z3;
        int i6;
        SizeConstraint.Fixed fixed2;
        IconComponentStyle icon;
        Size size;
        SizeConstraint height;
        Dp dpDpOrNull;
        ConstrainedLayoutReference constrainedLayoutReference;
        Composer composer2 = composer;
        int i7 = 2;
        if ((i3 & 3) == 2 && composer2.l()) {
            composer2.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-74958949, i3, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
        }
        this.$contentTracker.setValue(Unit.f139807a);
        if (this.$compositionSource.a() == CompositionSource.Unknown) {
            this.$compositionSource.b(CompositionSource.Content);
        }
        this.$scope.j();
        ConstraintLayoutScope constraintLayoutScope = this.$scope;
        composer2.a0(-425492318);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        composer2.a0(-290820944);
        Object objG = composer2.G();
        if (objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt.e(new TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1(this.$timelineState$inlined));
            composer2.w(objG);
        }
        State state = (State) objG;
        composer2.U();
        composer2.a0(-290812056);
        Iterator it2 = this.$timelineState$inlined.getItems().iterator();
        Composer composer3 = composer2;
        while (true) {
            z2 = false;
            i4 = 1;
            fixed = null;
            if (!it2.hasNext()) {
                break;
            }
            TimelineComponentState.ItemState itemState = (TimelineComponentState.ItemState) it2.next();
            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesN = constraintLayoutScope.n();
            ConstrainedLayoutReference constrainedLayoutReferenceA = constrainedLayoutReferencesN.a();
            ConstrainedLayoutReference constrainedLayoutReferenceB = constrainedLayoutReferencesN.b();
            ConstrainedLayoutReference constrainedLayoutReferenceC = constrainedLayoutReferencesN.c();
            ConstrainedLayoutReference constrainedLayoutReferenceD = constrainedLayoutReferencesN.d();
            LayoutReference[] layoutReferenceArr = new LayoutReference[3];
            layoutReferenceArr[0] = constrainedLayoutReferenceA;
            layoutReferenceArr[1] = constrainedLayoutReferenceB;
            layoutReferenceArr[i7] = constrainedLayoutReferenceC;
            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorD = ConstraintLayoutBaseScope.d(constraintLayoutScope, layoutReferenceArr, 0.0f, i7, null);
            ConstraintLayoutBaseScope.VerticalAnchor verticalAnchorE = constraintLayoutScope.e(new LayoutReference[]{constrainedLayoutReferenceA}, Dp.g(this.$timelineState$inlined.getColumnGutter()));
            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor = (ConstraintLayoutBaseScope.HorizontalAnchor) CollectionsKt.lastOrNull((List) arrayList2);
            arrayList3.add(constrainedLayoutReferenceA);
            arrayList2.add(ConstraintLayoutBaseScope.d(constraintLayoutScope, new LayoutReference[]{constrainedLayoutReferenceD}, 0.0f, i7, null));
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(companion, Dp.g(this.$timelineState$inlined.getItemSpacing()));
            composer3.a0(-290795278);
            boolean Z = composer3.Z(horizontalAnchorD);
            Object objG2 = composer3.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new TimelineComponentViewKt$TimelineComponentView$2$1$1(horizontalAnchorD);
                composer3.w(objG2);
            }
            composer3.U();
            SpacerKt.a(constraintLayoutScope.l(modifierI, constrainedLayoutReferenceD, (Function1) objG2), composer3, 0);
            composer3.a0(-290789187);
            boolean Z2 = composer3.Z(this.$timelineState$inlined) | composer3.Z(horizontalAnchor) | composer3.Z(constrainedLayoutReferenceB) | composer3.Z(constrainedLayoutReferenceC);
            Object objG3 = composer3.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                Object timelineComponentViewKt$TimelineComponentView$2$2$1 = new TimelineComponentViewKt$TimelineComponentView$2$2$1(this.$timelineState$inlined, horizontalAnchor, constrainedLayoutReferenceB, constrainedLayoutReferenceC, state);
                constrainedLayoutReference = constrainedLayoutReferenceC;
                composer3.w(timelineComponentViewKt$TimelineComponentView$2$2$1);
                objG3 = timelineComponentViewKt$TimelineComponentView$2$2$1;
            } else {
                constrainedLayoutReference = constrainedLayoutReferenceC;
            }
            composer3.U();
            Modifier modifierL = constraintLayoutScope.l(companion, constrainedLayoutReferenceA, (Function1) objG3);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU = composer3.u();
            Modifier modifierF = ComposedModifierKt.f(composer3, modifierL);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A);
            } else {
                composer3.v();
            }
            Composer composerA = Updater.a(composer3);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            IconComponentViewKt.IconComponentView(itemState.getIcon(), this.$state$inlined, BoxScopeInstance.f6642a.f(companion, companion2.m()), composer, 0, 0);
            Composer composer4 = composer;
            composer4.y();
            TextComponentStyle title = itemState.getTitle();
            PaywallState.Loaded.Components components = this.$state$inlined;
            composer4.a0(-290754551);
            boolean Z3 = composer4.Z(this.$timelineState$inlined) | composer4.Z(constrainedLayoutReferenceA) | composer4.Z(horizontalAnchor) | composer4.Z(verticalAnchorE);
            Object objG4 = composer4.G();
            if (Z3 || objG4 == Composer.f23746a.a()) {
                objG4 = new TimelineComponentViewKt$TimelineComponentView$2$4$1(this.$timelineState$inlined, constrainedLayoutReferenceA, horizontalAnchor, verticalAnchorE);
                composer4.w(objG4);
            }
            composer4.U();
            TextComponentViewKt.TextComponentView(title, components, constraintLayoutScope.l(companion, constrainedLayoutReferenceB, (Function1) objG4), null, composer4, 0, 8);
            TextComponentStyle description = itemState.getDescription();
            composer4.a0(-290731404);
            if (description != null) {
                PaywallState.Loaded.Components components2 = this.$state$inlined;
                composer4.a0(149597858);
                boolean Z4 = composer4.Z(constrainedLayoutReferenceB) | composer4.Z(this.$timelineState$inlined);
                Object objG5 = composer4.G();
                if (Z4 || objG5 == Composer.f23746a.a()) {
                    objG5 = new TimelineComponentViewKt$TimelineComponentView$2$5$1$1(constrainedLayoutReferenceB, this.$timelineState$inlined);
                    composer4.w(objG5);
                }
                composer4.U();
                TextComponentViewKt.TextComponentView(description, components2, constraintLayoutScope.l(companion, constrainedLayoutReference, (Function1) objG5), null, composer4, 0, 8);
                Unit unit = Unit.f139807a;
            }
            composer4.U();
            i7 = 2;
            composer3 = composer4;
        }
        composer3.U();
        composer3.a0(-290709150);
        Iterator it3 = this.$timelineState$inlined.getItems().iterator();
        int i8 = 0;
        while (it3.hasNext()) {
            int i9 = i8 + 1;
            TimelineComponentState.ItemState itemState2 = (TimelineComponentState.ItemState) it3.next();
            boolean z4 = i8 == this.$timelineState$inlined.getItems().size() - i4 ? i4 : 0;
            ConstrainedLayoutReference constrainedLayoutReference2 = (ConstrainedLayoutReference) arrayList3.get(i8);
            ConstrainedLayoutReference constrainedLayoutReference3 = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList3, i9);
            TimelineComponentStyle.ConnectorStyle connector = itemState2.getConnector();
            composer3.a0(-290701069);
            if (connector == null) {
                it = it3;
                i5 = i9;
                arrayList = arrayList3;
                i6 = i4;
                fixed2 = fixed;
                z3 = z2;
            } else {
                ConstrainedLayoutReference constrainedLayoutReferenceM = constraintLayoutScope.m();
                Object size2 = itemState2.getIcon().getSize();
                composer3.a0(149624325);
                boolean Z5 = composer3.Z(size2) | composer3.Z(constrainedLayoutReferenceM);
                Object objG6 = composer3.G();
                if (Z5 || objG6 == Composer.f23746a.a()) {
                    SizeConstraint height2 = itemState2.getIcon().getSize().getHeight();
                    float fG2 = (height2 instanceof SizeConstraint.Fixed ? (SizeConstraint.Fixed) height2 : fixed) != null ? Dp.g(Dp.g(r2.m662getValuepVg5ArA()) / 2) : Dp.g(0);
                    Dp dpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(state);
                    if (dpTimelineComponentView$lambda$13$lambda$1 != null) {
                        int iL = (int) dpTimelineComponentView$lambda$13$lambda$1.l();
                        fG = Dp.g(Dp.g(iL - (itemState2.getConnector() != null ? r15.getWidth() : 0)) / 2);
                    } else {
                        fG = Dp.g(0);
                    }
                    objG6 = TuplesKt.a(Dp.d(fG), Dp.d(fG2));
                    composer3.w(objG6);
                }
                Pair pair = (Pair) objG6;
                composer3.U();
                TimelineComponentState.ItemState itemState3 = (TimelineComponentState.ItemState) CollectionsKt.getOrNull(this.$timelineState$inlined.getItems(), i9);
                float fG3 = Dp.g(((itemState3 == null || (icon = itemState3.getIcon()) == null || (size = icon.getSize()) == null || (height = size.getHeight()) == null || (dpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(height)) == null) ? Dp.g(0) : dpDpOrNull.l()) / 2);
                Modifier.Companion companion4 = Modifier.b8;
                TimelineComponentStyle.ConnectorStyle connector2 = itemState2.getConnector();
                if (connector2 == null || (paddingValuesA = connector2.getMargin()) == null) {
                    it = it3;
                    paddingValuesA = PaddingKt.a(Dp.g(0));
                } else {
                    it = it3;
                }
                i5 = i9;
                arrayList = arrayList3;
                z3 = false;
                i6 = 1;
                Modifier modifierA = ZIndexModifierKt.a(OffsetKt.d(PaddingKt.h(companion4, paddingValuesA), 0.0f, ((Dp) pair.f()).l(), 1, null), -1.0f);
                composer3.a0(149657484);
                boolean Z6 = composer3.Z(pair) | composer3.Z(itemState2) | composer3.Z(constrainedLayoutReference2) | composer3.b(z4) | composer3.Z(constrainedLayoutReference3) | composer3.c(fG3);
                Object objG7 = composer3.G();
                if (Z6 || objG7 == Composer.f23746a.a()) {
                    objG7 = new TimelineComponentViewKt$TimelineComponentView$2$6$1$1(pair, itemState2, constrainedLayoutReference2, z4, constrainedLayoutReference3, fG3);
                    composer3.w(objG7);
                }
                composer3.U();
                fixed2 = null;
                BoxKt.a(OverlayKt.overlay$default(constraintLayoutScope.l(modifierA, constrainedLayoutReferenceM, (Function1) objG7), ColorStyleKt.getForCurrentTheme(connector.getColor(), composer3, 0), null, 2, null), composer3, 0);
                Unit unit2 = Unit.f139807a;
            }
            composer3.U();
            z2 = z3;
            i4 = i6;
            fixed = fixed2;
            i8 = i5;
            arrayList3 = arrayList;
            it3 = it;
        }
        composer3.U();
        composer3.U();
        boolean zI = composer3.I(this.$scope) | composer3.I(this.$channel);
        final ConstraintLayoutScope constraintLayoutScope2 = this.$scope;
        final MutableState mutableState = this.$start;
        final MutableState mutableState2 = this.$end;
        final Channel channel = this.$channel;
        Object objG8 = composer3.G();
        if (zI || objG8 == Composer.f23746a.a()) {
            objG8 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m858invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m858invoke() {
                    RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope2.h().a());
                    if (mutableState.getValue() != null && mutableState2.getValue() != null) {
                        channel.h(rawConstraintSet);
                    } else {
                        mutableState.setValue(rawConstraintSet);
                        mutableState2.setValue(mutableState.getValue());
                    }
                }
            };
            composer3.w(objG8);
        }
        EffectsKt.j((Function0) objG8, composer3, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
