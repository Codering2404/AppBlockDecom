package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
final class VerticalStackScopeImpl implements VerticalStackScope {
    private Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> columnContent;
    private final FlexDistribution distribution;
    private final Function3<Float, Composer, Integer, Unit> fillSpaceSpacer;
    private boolean hasAnyItemsWithFillHeight;
    private final SizeConstraint height;
    private final float spacing;

    public /* synthetic */ VerticalStackScopeImpl(FlexDistribution flexDistribution, float f3, Function3 function3, SizeConstraint sizeConstraint, DefaultConstructorMarker defaultConstructorMarker) {
        this(flexDistribution, f3, function3, sizeConstraint);
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getColumnContent() {
        return this.columnContent;
    }

    public final boolean getShouldApplyFillSpacers() {
        return (Intrinsics.areEqual(this.height, SizeConstraint.Fit.INSTANCE) || this.hasAnyItemsWithFillHeight) ? false : true;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackScope
    public void items(final List<? extends ComponentStyle> items, final Function5<? super ColumnScope, ? super Integer, ? super ComponentStyle, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        List<? extends ComponentStyle> list = items;
        boolean z2 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((ComponentStyle) it.next()).getSize().getHeight(), SizeConstraint.Fill.INSTANCE)) {
                    z2 = true;
                    break;
                }
            }
        }
        this.hasAnyItemsWithFillHeight = z2;
        this.columnContent = ComposableLambdaKt.c(552023703, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackScopeImpl.items.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(ColumnScope columnScope, Composer composer, int i3) {
                Intrinsics.checkNotNullParameter(columnScope, "$this$null");
                int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(columnScope) ? 4 : 2) : i3;
                if ((i4 & 19) == 18 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(552023703, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackScopeImpl.items.<anonymous> (VerticalStack.kt:96)");
                }
                List<ComponentStyle> list2 = items;
                Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit> function5 = itemContent;
                VerticalStackScopeImpl verticalStackScopeImpl = this;
                int i5 = 0;
                for (Object obj : list2) {
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ComponentStyle componentStyle = (ComponentStyle) obj;
                    boolean z3 = i5 == list2.size() - 1;
                    function5.invoke(columnScope, Integer.valueOf(i5), componentStyle, composer, Integer.valueOf(i4 & 14));
                    composer.a0(-1867284347);
                    if (StackComponentViewKt.getUsesAllAvailableSpace(verticalStackScopeImpl.distribution) && !z3) {
                        SpacerKt.a(SizeKt.k(Modifier.b8, verticalStackScopeImpl.spacing, 0.0f, 2, null), composer, 0);
                        if (verticalStackScopeImpl.getShouldApplyFillSpacers()) {
                            verticalStackScopeImpl.fillSpaceSpacer.invoke(Float.valueOf(verticalStackScopeImpl.distribution == FlexDistribution.SPACE_AROUND ? 2.0f : 1.0f), composer, 0);
                        }
                    }
                    composer.U();
                    i5 = i6;
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        });
    }

    public final void setColumnContent(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.columnContent = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VerticalStackScopeImpl(FlexDistribution distribution, float f3, Function3<? super Float, ? super Composer, ? super Integer, Unit> fillSpaceSpacer, SizeConstraint height) {
        Intrinsics.checkNotNullParameter(distribution, "distribution");
        Intrinsics.checkNotNullParameter(fillSpaceSpacer, "fillSpaceSpacer");
        Intrinsics.checkNotNullParameter(height, "height");
        this.distribution = distribution;
        this.spacing = f3;
        this.fillSpaceSpacer = fillSpaceSpacer;
        this.height = height;
        this.columnContent = ComposableSingletons$VerticalStackKt.INSTANCE.m806getLambda1$revenuecatui_defaultsBc8Release();
    }
}
