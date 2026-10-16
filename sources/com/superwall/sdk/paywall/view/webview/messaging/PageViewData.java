package com.superwall.sdk.paywall.view.webview.messaging;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PageViewData {
    private final int flowPosition;
    private final String navigationNodeId;
    private final String navigationType;
    private final String pageName;
    private final String pageNodeId;
    private final Integer previousFlowPosition;
    private final String previousPageNodeId;
    private final Integer timeOnPreviousPageMs;

    public PageViewData(String pageNodeId, int i3, String pageName, String navigationNodeId, String str, Integer num, String navigationType, Integer num2) {
        Intrinsics.checkNotNullParameter(pageNodeId, "pageNodeId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(navigationNodeId, "navigationNodeId");
        Intrinsics.checkNotNullParameter(navigationType, "navigationType");
        this.pageNodeId = pageNodeId;
        this.flowPosition = i3;
        this.pageName = pageName;
        this.navigationNodeId = navigationNodeId;
        this.previousPageNodeId = str;
        this.previousFlowPosition = num;
        this.navigationType = navigationType;
        this.timeOnPreviousPageMs = num2;
    }

    public static /* synthetic */ PageViewData copy$default(PageViewData pageViewData, String str, int i3, String str2, String str3, String str4, Integer num, String str5, Integer num2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = pageViewData.pageNodeId;
        }
        if ((i4 & 2) != 0) {
            i3 = pageViewData.flowPosition;
        }
        if ((i4 & 4) != 0) {
            str2 = pageViewData.pageName;
        }
        if ((i4 & 8) != 0) {
            str3 = pageViewData.navigationNodeId;
        }
        if ((i4 & 16) != 0) {
            str4 = pageViewData.previousPageNodeId;
        }
        if ((i4 & 32) != 0) {
            num = pageViewData.previousFlowPosition;
        }
        if ((i4 & 64) != 0) {
            str5 = pageViewData.navigationType;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            num2 = pageViewData.timeOnPreviousPageMs;
        }
        String str6 = str5;
        Integer num3 = num2;
        String str7 = str4;
        Integer num4 = num;
        return pageViewData.copy(str, i3, str2, str3, str7, num4, str6, num3);
    }

    public final String component1() {
        return this.pageNodeId;
    }

    public final int component2() {
        return this.flowPosition;
    }

    public final String component3() {
        return this.pageName;
    }

    public final String component4() {
        return this.navigationNodeId;
    }

    public final String component5() {
        return this.previousPageNodeId;
    }

    public final Integer component6() {
        return this.previousFlowPosition;
    }

    public final String component7() {
        return this.navigationType;
    }

    public final Integer component8() {
        return this.timeOnPreviousPageMs;
    }

    public final PageViewData copy(String pageNodeId, int i3, String pageName, String navigationNodeId, String str, Integer num, String navigationType, Integer num2) {
        Intrinsics.checkNotNullParameter(pageNodeId, "pageNodeId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(navigationNodeId, "navigationNodeId");
        Intrinsics.checkNotNullParameter(navigationType, "navigationType");
        return new PageViewData(pageNodeId, i3, pageName, navigationNodeId, str, num, navigationType, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageViewData)) {
            return false;
        }
        PageViewData pageViewData = (PageViewData) obj;
        return Intrinsics.areEqual(this.pageNodeId, pageViewData.pageNodeId) && this.flowPosition == pageViewData.flowPosition && Intrinsics.areEqual(this.pageName, pageViewData.pageName) && Intrinsics.areEqual(this.navigationNodeId, pageViewData.navigationNodeId) && Intrinsics.areEqual(this.previousPageNodeId, pageViewData.previousPageNodeId) && Intrinsics.areEqual(this.previousFlowPosition, pageViewData.previousFlowPosition) && Intrinsics.areEqual(this.navigationType, pageViewData.navigationType) && Intrinsics.areEqual(this.timeOnPreviousPageMs, pageViewData.timeOnPreviousPageMs);
    }

    public final int getFlowPosition() {
        return this.flowPosition;
    }

    public final String getNavigationNodeId() {
        return this.navigationNodeId;
    }

    public final String getNavigationType() {
        return this.navigationType;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPageNodeId() {
        return this.pageNodeId;
    }

    public final Integer getPreviousFlowPosition() {
        return this.previousFlowPosition;
    }

    public final String getPreviousPageNodeId() {
        return this.previousPageNodeId;
    }

    public final Integer getTimeOnPreviousPageMs() {
        return this.timeOnPreviousPageMs;
    }

    public int hashCode() {
        int iHashCode = ((((((this.pageNodeId.hashCode() * 31) + Integer.hashCode(this.flowPosition)) * 31) + this.pageName.hashCode()) * 31) + this.navigationNodeId.hashCode()) * 31;
        String str = this.previousPageNodeId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.previousFlowPosition;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.navigationType.hashCode()) * 31;
        Integer num2 = this.timeOnPreviousPageMs;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "PageViewData(pageNodeId=" + this.pageNodeId + ", flowPosition=" + this.flowPosition + ", pageName=" + this.pageName + ", navigationNodeId=" + this.navigationNodeId + ", previousPageNodeId=" + this.previousPageNodeId + ", previousFlowPosition=" + this.previousFlowPosition + ", navigationType=" + this.navigationType + ", timeOnPreviousPageMs=" + this.timeOnPreviousPageMs + ")";
    }
}
