package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Size;
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
public final class StickyFooterComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Size size;
    private final StackComponentStyle stackComponentStyle;
    private final boolean visible;

    public StickyFooterComponentStyle(StackComponentStyle stackComponentStyle) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        this.stackComponentStyle = stackComponentStyle;
        this.visible = stackComponentStyle.getVisible();
        this.size = stackComponentStyle.getSize();
    }

    public static /* synthetic */ StickyFooterComponentStyle copy$default(StickyFooterComponentStyle stickyFooterComponentStyle, StackComponentStyle stackComponentStyle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            stackComponentStyle = stickyFooterComponentStyle.stackComponentStyle;
        }
        return stickyFooterComponentStyle.copy(stackComponentStyle);
    }

    public final StackComponentStyle component1() {
        return this.stackComponentStyle;
    }

    public final StickyFooterComponentStyle copy(StackComponentStyle stackComponentStyle) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        return new StickyFooterComponentStyle(stackComponentStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StickyFooterComponentStyle) && Intrinsics.areEqual(this.stackComponentStyle, ((StickyFooterComponentStyle) obj).stackComponentStyle);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return this.stackComponentStyle.hashCode();
    }

    public String toString() {
        return "StickyFooterComponentStyle(stackComponentStyle=" + this.stackComponentStyle + ')';
    }
}
