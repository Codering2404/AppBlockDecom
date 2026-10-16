package com.revenuecat.purchases.ui.revenuecatui.components.button;

import kotlin.Metadata;
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
public final class ButtonComponentInteraction {
    public static final int $stable = 0;
    private final String url;
    private final String value;

    public ButtonComponentInteraction(String value, String str) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.url = str;
    }

    public static /* synthetic */ ButtonComponentInteraction copy$default(ButtonComponentInteraction buttonComponentInteraction, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = buttonComponentInteraction.value;
        }
        if ((i3 & 2) != 0) {
            str2 = buttonComponentInteraction.url;
        }
        return buttonComponentInteraction.copy(str, str2);
    }

    public final String component1() {
        return this.value;
    }

    public final String component2() {
        return this.url;
    }

    public final ButtonComponentInteraction copy(String value, String str) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ButtonComponentInteraction(value, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponentInteraction)) {
            return false;
        }
        ButtonComponentInteraction buttonComponentInteraction = (ButtonComponentInteraction) obj;
        return Intrinsics.areEqual(this.value, buttonComponentInteraction.value) && Intrinsics.areEqual(this.url, buttonComponentInteraction.url);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.value.hashCode() * 31;
        String str = this.url;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ButtonComponentInteraction(value=" + this.value + ", url=" + this.url + ')';
    }

    public /* synthetic */ ButtonComponentInteraction(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2);
    }
}
