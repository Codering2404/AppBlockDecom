package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import kotlin.Metadata;

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
public final class AspectRatio {
    public static final int $stable = 0;
    private final boolean matchHeightConstraintsFirst;
    private final float ratio;

    public AspectRatio(float f3, boolean z2) {
        this.ratio = f3;
        this.matchHeightConstraintsFirst = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AspectRatio)) {
            return false;
        }
        AspectRatio aspectRatio = (AspectRatio) obj;
        return Float.compare(this.ratio, aspectRatio.ratio) == 0 && this.matchHeightConstraintsFirst == aspectRatio.matchHeightConstraintsFirst;
    }

    public final /* synthetic */ boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final /* synthetic */ float getRatio() {
        return this.ratio;
    }

    public int hashCode() {
        return (Float.hashCode(this.ratio) * 31) + Boolean.hashCode(this.matchHeightConstraintsFirst);
    }

    public String toString() {
        return "AspectRatio(ratio=" + this.ratio + ", matchHeightConstraintsFirst=" + this.matchHeightConstraintsFirst + ')';
    }
}
