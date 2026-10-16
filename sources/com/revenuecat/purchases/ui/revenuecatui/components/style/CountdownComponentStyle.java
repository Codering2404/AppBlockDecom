package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import java.util.Date;
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
public final class CountdownComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final CountdownComponent.CountFrom countFrom;
    private final StackComponentStyle countdownStackComponentStyle;
    private final Date date;
    private final StackComponentStyle endStackComponentStyle;
    private final StackComponentStyle fallbackStackComponentStyle;
    private final Size size;
    private final boolean visible;

    public CountdownComponentStyle(Date date, CountdownComponent.CountFrom countFrom, StackComponentStyle countdownStackComponentStyle, StackComponentStyle stackComponentStyle, StackComponentStyle stackComponentStyle2) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(countdownStackComponentStyle, "countdownStackComponentStyle");
        this.date = date;
        this.countFrom = countFrom;
        this.countdownStackComponentStyle = countdownStackComponentStyle;
        this.endStackComponentStyle = stackComponentStyle;
        this.fallbackStackComponentStyle = stackComponentStyle2;
        this.visible = countdownStackComponentStyle.getVisible();
        this.size = countdownStackComponentStyle.getSize();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountdownComponentStyle)) {
            return false;
        }
        CountdownComponentStyle countdownComponentStyle = (CountdownComponentStyle) obj;
        return Intrinsics.areEqual(this.date, countdownComponentStyle.date) && this.countFrom == countdownComponentStyle.countFrom && Intrinsics.areEqual(this.countdownStackComponentStyle, countdownComponentStyle.countdownStackComponentStyle) && Intrinsics.areEqual(this.endStackComponentStyle, countdownComponentStyle.endStackComponentStyle) && Intrinsics.areEqual(this.fallbackStackComponentStyle, countdownComponentStyle.fallbackStackComponentStyle);
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ StackComponentStyle getCountdownStackComponentStyle() {
        return this.countdownStackComponentStyle;
    }

    public final /* synthetic */ Date getDate() {
        return this.date;
    }

    public final /* synthetic */ StackComponentStyle getEndStackComponentStyle() {
        return this.endStackComponentStyle;
    }

    public final /* synthetic */ StackComponentStyle getFallbackStackComponentStyle() {
        return this.fallbackStackComponentStyle;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((this.date.hashCode() * 31) + this.countFrom.hashCode()) * 31) + this.countdownStackComponentStyle.hashCode()) * 31;
        StackComponentStyle stackComponentStyle = this.endStackComponentStyle;
        int iHashCode2 = (iHashCode + (stackComponentStyle == null ? 0 : stackComponentStyle.hashCode())) * 31;
        StackComponentStyle stackComponentStyle2 = this.fallbackStackComponentStyle;
        return iHashCode2 + (stackComponentStyle2 != null ? stackComponentStyle2.hashCode() : 0);
    }

    public String toString() {
        return "CountdownComponentStyle(date=" + this.date + ", countFrom=" + this.countFrom + ", countdownStackComponentStyle=" + this.countdownStackComponentStyle + ", endStackComponentStyle=" + this.endStackComponentStyle + ", fallbackStackComponentStyle=" + this.fallbackStackComponentStyle + ')';
    }
}
