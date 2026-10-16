package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTabsPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
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
public final class TabsComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final BackgroundStyles background;
    private final BorderStyles border;
    private final TabControlStyle control;
    private final PaddingValues margin;
    private final List<PresentedOverride<PresentedTabsPartial>> overrides;
    private final PaddingValues padding;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final NonEmptyList<Tab> tabs;
    private final boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Tab {
        public static final int $stable = 0;
        private final StackComponentStyle stack;

        public Tab(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.stack = stack;
        }

        public static /* synthetic */ Tab copy$default(Tab tab, StackComponentStyle stackComponentStyle, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                stackComponentStyle = tab.stack;
            }
            return tab.copy(stackComponentStyle);
        }

        public final StackComponentStyle component1() {
            return this.stack;
        }

        public final Tab copy(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            return new Tab(stack);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tab) && Intrinsics.areEqual(this.stack, ((Tab) obj).stack);
        }

        public final /* synthetic */ StackComponentStyle getStack() {
            return this.stack;
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Tab(stack=" + this.stack + ')';
        }
    }

    public TabsComponentStyle(boolean z2, Size size, PaddingValues padding, PaddingValues margin, BackgroundStyles backgroundStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, TabControlStyle control, NonEmptyList<Tab> tabs, List<PresentedOverride<PresentedTabsPartial>> overrides) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(control, "control");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.visible = z2;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.background = backgroundStyles;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.control = control;
        this.tabs = tabs;
        this.overrides = overrides;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabsComponentStyle copy$default(TabsComponentStyle tabsComponentStyle, boolean z2, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, BackgroundStyles backgroundStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, TabControlStyle tabControlStyle, NonEmptyList nonEmptyList, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = tabsComponentStyle.visible;
        }
        if ((i3 & 2) != 0) {
            size = tabsComponentStyle.size;
        }
        if ((i3 & 4) != 0) {
            paddingValues = tabsComponentStyle.padding;
        }
        if ((i3 & 8) != 0) {
            paddingValues2 = tabsComponentStyle.margin;
        }
        if ((i3 & 16) != 0) {
            backgroundStyles = tabsComponentStyle.background;
        }
        if ((i3 & 32) != 0) {
            shape = tabsComponentStyle.shape;
        }
        if ((i3 & 64) != 0) {
            borderStyles = tabsComponentStyle.border;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            shadowStyles = tabsComponentStyle.shadow;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            tabControlStyle = tabsComponentStyle.control;
        }
        if ((i3 & 512) != 0) {
            nonEmptyList = tabsComponentStyle.tabs;
        }
        if ((i3 & 1024) != 0) {
            list = tabsComponentStyle.overrides;
        }
        NonEmptyList nonEmptyList2 = nonEmptyList;
        List list2 = list;
        ShadowStyles shadowStyles2 = shadowStyles;
        TabControlStyle tabControlStyle2 = tabControlStyle;
        Shape shape2 = shape;
        BorderStyles borderStyles2 = borderStyles;
        BackgroundStyles backgroundStyles2 = backgroundStyles;
        PaddingValues paddingValues3 = paddingValues;
        return tabsComponentStyle.copy(z2, size, paddingValues3, paddingValues2, backgroundStyles2, shape2, borderStyles2, shadowStyles2, tabControlStyle2, nonEmptyList2, list2);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final NonEmptyList<Tab> component10() {
        return this.tabs;
    }

    public final List<PresentedOverride<PresentedTabsPartial>> component11() {
        return this.overrides;
    }

    public final Size component2() {
        return this.size;
    }

    public final PaddingValues component3() {
        return this.padding;
    }

    public final PaddingValues component4() {
        return this.margin;
    }

    public final BackgroundStyles component5() {
        return this.background;
    }

    public final Shape component6() {
        return this.shape;
    }

    public final BorderStyles component7() {
        return this.border;
    }

    public final ShadowStyles component8() {
        return this.shadow;
    }

    public final TabControlStyle component9() {
        return this.control;
    }

    public final TabsComponentStyle copy(boolean z2, Size size, PaddingValues padding, PaddingValues margin, BackgroundStyles backgroundStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, TabControlStyle control, NonEmptyList<Tab> tabs, List<PresentedOverride<PresentedTabsPartial>> overrides) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(control, "control");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new TabsComponentStyle(z2, size, padding, margin, backgroundStyles, shape, borderStyles, shadowStyles, control, tabs, overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabsComponentStyle)) {
            return false;
        }
        TabsComponentStyle tabsComponentStyle = (TabsComponentStyle) obj;
        return this.visible == tabsComponentStyle.visible && Intrinsics.areEqual(this.size, tabsComponentStyle.size) && Intrinsics.areEqual(this.padding, tabsComponentStyle.padding) && Intrinsics.areEqual(this.margin, tabsComponentStyle.margin) && Intrinsics.areEqual(this.background, tabsComponentStyle.background) && Intrinsics.areEqual(this.shape, tabsComponentStyle.shape) && Intrinsics.areEqual(this.border, tabsComponentStyle.border) && Intrinsics.areEqual(this.shadow, tabsComponentStyle.shadow) && Intrinsics.areEqual(this.control, tabsComponentStyle.control) && Intrinsics.areEqual(this.tabs, tabsComponentStyle.tabs) && Intrinsics.areEqual(this.overrides, tabsComponentStyle.overrides);
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return this.background;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ TabControlStyle getControl() {
        return this.control;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ NonEmptyList getTabs() {
        return this.tabs;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.visible) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        BackgroundStyles backgroundStyles = this.background;
        int iHashCode2 = (((iHashCode + (backgroundStyles == null ? 0 : backgroundStyles.hashCode())) * 31) + this.shape.hashCode()) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        return ((((((iHashCode3 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.control.hashCode()) * 31) + this.tabs.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TabsComponentStyle(visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", background=" + this.background + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", control=" + this.control + ", tabs=" + this.tabs + ", overrides=" + this.overrides + ')';
    }
}
