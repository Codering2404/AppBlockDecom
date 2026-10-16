package com.revenuecat.purchases.paywalls.fonts;

import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DownloadableFontInfo {
    private final String expectedMd5;
    private final String family;
    private final FontStyle style;
    private final String url;
    private final int weight;

    public DownloadableFontInfo(String url, String expectedMd5, String family, int i3, FontStyle style) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(expectedMd5, "expectedMd5");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(style, "style");
        this.url = url;
        this.expectedMd5 = expectedMd5;
        this.family = family;
        this.weight = i3;
        this.style = style;
    }

    public static /* synthetic */ DownloadableFontInfo copy$default(DownloadableFontInfo downloadableFontInfo, String str, String str2, String str3, int i3, FontStyle fontStyle, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = downloadableFontInfo.url;
        }
        if ((i4 & 2) != 0) {
            str2 = downloadableFontInfo.expectedMd5;
        }
        if ((i4 & 4) != 0) {
            str3 = downloadableFontInfo.family;
        }
        if ((i4 & 8) != 0) {
            i3 = downloadableFontInfo.weight;
        }
        if ((i4 & 16) != 0) {
            fontStyle = downloadableFontInfo.style;
        }
        FontStyle fontStyle2 = fontStyle;
        String str4 = str3;
        return downloadableFontInfo.copy(str, str2, str4, i3, fontStyle2);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.expectedMd5;
    }

    public final String component3() {
        return this.family;
    }

    public final int component4() {
        return this.weight;
    }

    public final FontStyle component5() {
        return this.style;
    }

    public final DownloadableFontInfo copy(String url, String expectedMd5, String family, int i3, FontStyle style) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(expectedMd5, "expectedMd5");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(style, "style");
        return new DownloadableFontInfo(url, expectedMd5, family, i3, style);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadableFontInfo)) {
            return false;
        }
        DownloadableFontInfo downloadableFontInfo = (DownloadableFontInfo) obj;
        return Intrinsics.areEqual(this.url, downloadableFontInfo.url) && Intrinsics.areEqual(this.expectedMd5, downloadableFontInfo.expectedMd5) && Intrinsics.areEqual(this.family, downloadableFontInfo.family) && this.weight == downloadableFontInfo.weight && this.style == downloadableFontInfo.style;
    }

    public final /* synthetic */ String getExpectedMd5() {
        return this.expectedMd5;
    }

    public final /* synthetic */ String getFamily() {
        return this.family;
    }

    public final /* synthetic */ FontStyle getStyle() {
        return this.style;
    }

    public final /* synthetic */ String getUrl() {
        return this.url;
    }

    public final /* synthetic */ int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.expectedMd5.hashCode()) * 31) + this.family.hashCode()) * 31) + Integer.hashCode(this.weight)) * 31) + this.style.hashCode();
    }

    public String toString() {
        return "DownloadableFontInfo(url=" + this.url + ", expectedMd5=" + this.expectedMd5 + ", family=" + this.family + ", weight=" + this.weight + ", style=" + this.style + ')';
    }
}
