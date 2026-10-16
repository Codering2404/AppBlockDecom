package cz.mobilesoft.coreblock.scene.more.help.restorepurchase;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.util.DataState;
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
public final class RestorePurchaseViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataState f107842a;

    public RestorePurchaseViewState(DataState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.f107842a = state;
    }

    public final RestorePurchaseViewState a(DataState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new RestorePurchaseViewState(state);
    }

    public final DataState b() {
        return this.f107842a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RestorePurchaseViewState) && Intrinsics.areEqual(this.f107842a, ((RestorePurchaseViewState) obj).f107842a);
    }

    public int hashCode() {
        return this.f107842a.hashCode();
    }

    public String toString() {
        return "RestorePurchaseViewState(state=" + this.f107842a + ")";
    }
}
