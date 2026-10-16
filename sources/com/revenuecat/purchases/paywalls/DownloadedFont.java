package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import java.io.File;
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
public final class DownloadedFont {
    private final File file;
    private final FontStyle style;
    private final int weight;

    public DownloadedFont(int i3, FontStyle style, File file) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(file, "file");
        this.weight = i3;
        this.style = style;
        this.file = file;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadedFont)) {
            return false;
        }
        DownloadedFont downloadedFont = (DownloadedFont) obj;
        return this.weight == downloadedFont.weight && this.style == downloadedFont.style && Intrinsics.areEqual(this.file, downloadedFont.file);
    }

    public final /* synthetic */ File getFile() {
        return this.file;
    }

    public final /* synthetic */ FontStyle getStyle() {
        return this.style;
    }

    public final /* synthetic */ int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((this.weight * 31) + this.style.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "DownloadedFont(weight=" + this.weight + ", style=" + this.style + ", file=" + this.file + ')';
    }
}
