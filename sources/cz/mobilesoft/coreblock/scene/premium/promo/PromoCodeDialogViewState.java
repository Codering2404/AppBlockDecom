package cz.mobilesoft.coreblock.scene.premium.promo;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PromoCodeDTO;
import cz.mobilesoft.coreblock.util.ViewModelState;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PromoCodeDialogViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f113770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewModelState f113771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PromoCodeDTO f113772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f113773d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoCodeDialogViewState)) {
            return false;
        }
        PromoCodeDialogViewState promoCodeDialogViewState = (PromoCodeDialogViewState) obj;
        return Intrinsics.areEqual(this.f113770a, promoCodeDialogViewState.f113770a) && Intrinsics.areEqual(this.f113771b, promoCodeDialogViewState.f113771b) && Intrinsics.areEqual(this.f113772c, promoCodeDialogViewState.f113772c) && this.f113773d == promoCodeDialogViewState.f113773d;
    }

    public int hashCode() {
        int iHashCode = this.f113770a.hashCode() * 31;
        ViewModelState viewModelState = this.f113771b;
        int iHashCode2 = (iHashCode + (viewModelState == null ? 0 : viewModelState.hashCode())) * 31;
        PromoCodeDTO promoCodeDTO = this.f113772c;
        return ((iHashCode2 + (promoCodeDTO != null ? promoCodeDTO.hashCode() : 0)) * 31) + Boolean.hashCode(this.f113773d);
    }

    public String toString() {
        return "PromoCodeDialogViewState(promoCode=" + this.f113770a + ", state=" + this.f113771b + ", resolvedPromoCodeDTO=" + this.f113772c + ", isPremiumCodeActive=" + this.f113773d + ")";
    }
}
