package com.revenuecat.purchases.ui.revenuecatui.helpers;

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
public final class CarouselPageChangeInteraction {
    public static final int $stable = 0;
    private final String componentName;
    private final int defaultPageIndex;
    private final String destinationContextName;
    private final int destinationPageIndex;
    private final String originContextName;
    private final int originPageIndex;

    public CarouselPageChangeInteraction(String str, int i3, int i4, int i5, String str2, String str3) {
        this.componentName = str;
        this.destinationPageIndex = i3;
        this.originPageIndex = i4;
        this.defaultPageIndex = i5;
        this.originContextName = str2;
        this.destinationContextName = str3;
    }

    public static /* synthetic */ CarouselPageChangeInteraction copy$default(CarouselPageChangeInteraction carouselPageChangeInteraction, String str, int i3, int i4, int i5, String str2, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = carouselPageChangeInteraction.componentName;
        }
        if ((i6 & 2) != 0) {
            i3 = carouselPageChangeInteraction.destinationPageIndex;
        }
        if ((i6 & 4) != 0) {
            i4 = carouselPageChangeInteraction.originPageIndex;
        }
        if ((i6 & 8) != 0) {
            i5 = carouselPageChangeInteraction.defaultPageIndex;
        }
        if ((i6 & 16) != 0) {
            str2 = carouselPageChangeInteraction.originContextName;
        }
        if ((i6 & 32) != 0) {
            str3 = carouselPageChangeInteraction.destinationContextName;
        }
        String str4 = str2;
        String str5 = str3;
        return carouselPageChangeInteraction.copy(str, i3, i4, i5, str4, str5);
    }

    public final String component1() {
        return this.componentName;
    }

    public final int component2() {
        return this.destinationPageIndex;
    }

    public final int component3() {
        return this.originPageIndex;
    }

    public final int component4() {
        return this.defaultPageIndex;
    }

    public final String component5() {
        return this.originContextName;
    }

    public final String component6() {
        return this.destinationContextName;
    }

    public final CarouselPageChangeInteraction copy(String str, int i3, int i4, int i5, String str2, String str3) {
        return new CarouselPageChangeInteraction(str, i3, i4, i5, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselPageChangeInteraction)) {
            return false;
        }
        CarouselPageChangeInteraction carouselPageChangeInteraction = (CarouselPageChangeInteraction) obj;
        return Intrinsics.areEqual(this.componentName, carouselPageChangeInteraction.componentName) && this.destinationPageIndex == carouselPageChangeInteraction.destinationPageIndex && this.originPageIndex == carouselPageChangeInteraction.originPageIndex && this.defaultPageIndex == carouselPageChangeInteraction.defaultPageIndex && Intrinsics.areEqual(this.originContextName, carouselPageChangeInteraction.originContextName) && Intrinsics.areEqual(this.destinationContextName, carouselPageChangeInteraction.destinationContextName);
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final int getDefaultPageIndex() {
        return this.defaultPageIndex;
    }

    public final String getDestinationContextName() {
        return this.destinationContextName;
    }

    public final int getDestinationPageIndex() {
        return this.destinationPageIndex;
    }

    public final String getOriginContextName() {
        return this.originContextName;
    }

    public final int getOriginPageIndex() {
        return this.originPageIndex;
    }

    public int hashCode() {
        String str = this.componentName;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.destinationPageIndex)) * 31) + Integer.hashCode(this.originPageIndex)) * 31) + Integer.hashCode(this.defaultPageIndex)) * 31;
        String str2 = this.originContextName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.destinationContextName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "CarouselPageChangeInteraction(componentName=" + this.componentName + ", destinationPageIndex=" + this.destinationPageIndex + ", originPageIndex=" + this.originPageIndex + ", defaultPageIndex=" + this.defaultPageIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ')';
    }
}
