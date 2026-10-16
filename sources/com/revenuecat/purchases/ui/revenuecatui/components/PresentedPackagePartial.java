package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PresentedPackagePartial implements PresentedPartial<PresentedPackagePartial> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final PartialPackageComponent partial;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialPackageComponent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            return new Result.Success(new PresentedPackagePartial(from));
        }

        private Companion() {
        }
    }

    public PresentedPackagePartial(PartialPackageComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.partial = partial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PresentedPackagePartial) && Intrinsics.areEqual(this.partial, ((PresentedPackagePartial) obj).partial);
    }

    public final /* synthetic */ PartialPackageComponent getPartial() {
        return this.partial;
    }

    public int hashCode() {
        return this.partial.hashCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedPackagePartial combine(PresentedPackagePartial presentedPackagePartial) {
        Boolean visible;
        PartialPackageComponent partialPackageComponent = presentedPackagePartial != null ? presentedPackagePartial.partial : null;
        if (partialPackageComponent == null || (visible = partialPackageComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        return new PresentedPackagePartial(new PartialPackageComponent(visible));
    }

    public String toString() {
        return YgVrd.NczTuZZT + this.partial + ')';
    }
}
