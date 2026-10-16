package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.base.ViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class RatingDialogState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f96083a;

    public RatingDialogState(boolean z2) {
        this.f96083a = z2;
    }

    public final RatingDialogState a(boolean z2) {
        return new RatingDialogState(z2);
    }

    public final boolean b() {
        return this.f96083a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RatingDialogState) && this.f96083a == ((RatingDialogState) obj).f96083a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f96083a);
    }

    public String toString() {
        return "RatingDialogState(isContentReady=" + this.f96083a + ")";
    }

    public /* synthetic */ RatingDialogState(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2);
    }
}
