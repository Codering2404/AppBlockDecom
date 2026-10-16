package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TabControlButtonComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Size size;
    private final StackComponentStyle stack;
    private final String tabButtonName;
    private final Map<String, String> tabContextNamesById;
    private final String tabId;
    private final List<String> tabIdsOrdered;
    private final int tabIndex;
    private final String tabsComponentName;
    private final int tabsDefaultTabIndex;
    private final boolean visible;

    public TabControlButtonComponentStyle(int i3, String tabId, StackComponentStyle stack, String str, String str2, List<String> tabIdsOrdered, Map<String, String> tabContextNamesById, int i4) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(tabIdsOrdered, "tabIdsOrdered");
        Intrinsics.checkNotNullParameter(tabContextNamesById, "tabContextNamesById");
        this.tabIndex = i3;
        this.tabId = tabId;
        this.stack = stack;
        this.tabsComponentName = str;
        this.tabButtonName = str2;
        this.tabIdsOrdered = tabIdsOrdered;
        this.tabContextNamesById = tabContextNamesById;
        this.tabsDefaultTabIndex = i4;
        this.visible = stack.getVisible();
        this.size = stack.getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabControlButtonComponentStyle copy$default(TabControlButtonComponentStyle tabControlButtonComponentStyle, int i3, String str, StackComponentStyle stackComponentStyle, String str2, String str3, List list, Map map, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = tabControlButtonComponentStyle.tabIndex;
        }
        if ((i5 & 2) != 0) {
            str = tabControlButtonComponentStyle.tabId;
        }
        if ((i5 & 4) != 0) {
            stackComponentStyle = tabControlButtonComponentStyle.stack;
        }
        if ((i5 & 8) != 0) {
            str2 = tabControlButtonComponentStyle.tabsComponentName;
        }
        if ((i5 & 16) != 0) {
            str3 = tabControlButtonComponentStyle.tabButtonName;
        }
        if ((i5 & 32) != 0) {
            list = tabControlButtonComponentStyle.tabIdsOrdered;
        }
        if ((i5 & 64) != 0) {
            map = tabControlButtonComponentStyle.tabContextNamesById;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i4 = tabControlButtonComponentStyle.tabsDefaultTabIndex;
        }
        Map map2 = map;
        int i6 = i4;
        String str4 = str3;
        List list2 = list;
        return tabControlButtonComponentStyle.copy(i3, str, stackComponentStyle, str2, str4, list2, map2, i6);
    }

    public final int component1() {
        return this.tabIndex;
    }

    public final String component2() {
        return this.tabId;
    }

    public final StackComponentStyle component3() {
        return this.stack;
    }

    public final String component4() {
        return this.tabsComponentName;
    }

    public final String component5() {
        return this.tabButtonName;
    }

    public final List<String> component6() {
        return this.tabIdsOrdered;
    }

    public final Map<String, String> component7() {
        return this.tabContextNamesById;
    }

    public final int component8() {
        return this.tabsDefaultTabIndex;
    }

    public final TabControlButtonComponentStyle copy(int i3, String tabId, StackComponentStyle stack, String str, String str2, List<String> tabIdsOrdered, Map<String, String> tabContextNamesById, int i4) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(tabIdsOrdered, "tabIdsOrdered");
        Intrinsics.checkNotNullParameter(tabContextNamesById, "tabContextNamesById");
        return new TabControlButtonComponentStyle(i3, tabId, stack, str, str2, tabIdsOrdered, tabContextNamesById, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlButtonComponentStyle)) {
            return false;
        }
        TabControlButtonComponentStyle tabControlButtonComponentStyle = (TabControlButtonComponentStyle) obj;
        return this.tabIndex == tabControlButtonComponentStyle.tabIndex && Intrinsics.areEqual(this.tabId, tabControlButtonComponentStyle.tabId) && Intrinsics.areEqual(this.stack, tabControlButtonComponentStyle.stack) && Intrinsics.areEqual(this.tabsComponentName, tabControlButtonComponentStyle.tabsComponentName) && Intrinsics.areEqual(this.tabButtonName, tabControlButtonComponentStyle.tabButtonName) && Intrinsics.areEqual(this.tabIdsOrdered, tabControlButtonComponentStyle.tabIdsOrdered) && Intrinsics.areEqual(this.tabContextNamesById, tabControlButtonComponentStyle.tabContextNamesById) && this.tabsDefaultTabIndex == tabControlButtonComponentStyle.tabsDefaultTabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ StackComponentStyle getStack() {
        return this.stack;
    }

    public final /* synthetic */ String getTabButtonName() {
        return this.tabButtonName;
    }

    public final /* synthetic */ Map getTabContextNamesById() {
        return this.tabContextNamesById;
    }

    public final /* synthetic */ String getTabId() {
        return this.tabId;
    }

    public final /* synthetic */ List getTabIdsOrdered() {
        return this.tabIdsOrdered;
    }

    public final /* synthetic */ int getTabIndex() {
        return this.tabIndex;
    }

    public final /* synthetic */ String getTabsComponentName() {
        return this.tabsComponentName;
    }

    public final /* synthetic */ int getTabsDefaultTabIndex() {
        return this.tabsDefaultTabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.tabIndex) * 31) + this.tabId.hashCode()) * 31) + this.stack.hashCode()) * 31;
        String str = this.tabsComponentName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tabButtonName;
        return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.tabIdsOrdered.hashCode()) * 31) + this.tabContextNamesById.hashCode()) * 31) + Integer.hashCode(this.tabsDefaultTabIndex);
    }

    public String toString() {
        return "TabControlButtonComponentStyle(tabIndex=" + this.tabIndex + ", tabId=" + this.tabId + ", stack=" + this.stack + ", tabsComponentName=" + this.tabsComponentName + ", tabButtonName=" + this.tabButtonName + ", tabIdsOrdered=" + this.tabIdsOrdered + ", tabContextNamesById=" + this.tabContextNamesById + ", tabsDefaultTabIndex=" + this.tabsDefaultTabIndex + ')';
    }

    public /* synthetic */ TabControlButtonComponentStyle(int i3, String str, StackComponentStyle stackComponentStyle, String str2, String str3, List list, Map map, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, stackComponentStyle, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? null : str3, (i5 & 32) != 0 ? CollectionsKt.emptyList() : list, (i5 & 64) != 0 ? MapsKt.emptyMap() : map, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i4);
    }
}
