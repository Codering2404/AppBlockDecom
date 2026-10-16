package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PresentedOverride<T extends PresentedPartial<T>> {
    public static final int $stable = 8;
    private final List<ComponentOverride.Condition> conditions;
    private final T properties;

    /* JADX WARN: Multi-variable type inference failed */
    public PresentedOverride(List<? extends ComponentOverride.Condition> conditions, T properties) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.conditions = conditions;
        this.properties = properties;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedOverride)) {
            return false;
        }
        PresentedOverride presentedOverride = (PresentedOverride) obj;
        return Intrinsics.areEqual(this.conditions, presentedOverride.conditions) && Intrinsics.areEqual(this.properties, presentedOverride.properties);
    }

    public final /* synthetic */ List getConditions() {
        return this.conditions;
    }

    public final /* synthetic */ PresentedPartial getProperties() {
        return this.properties;
    }

    public int hashCode() {
        return (this.conditions.hashCode() * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "PresentedOverride(conditions=" + this.conditions + ", properties=" + this.properties + ')';
    }
}
