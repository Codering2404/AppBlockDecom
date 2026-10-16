package cz.mobilesoft.coreblock.scene.inappupdate;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
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
public final class InAppUpdateViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelState f102461a;

    public InAppUpdateViewState(ViewModelState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.f102461a = state;
    }

    public final InAppUpdateViewState a(ViewModelState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new InAppUpdateViewState(state);
    }

    public final ViewModelState b() {
        return this.f102461a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InAppUpdateViewState) && Intrinsics.areEqual(this.f102461a, ((InAppUpdateViewState) obj).f102461a);
    }

    public int hashCode() {
        return this.f102461a.hashCode();
    }

    public String toString() {
        return "InAppUpdateViewState(state=" + this.f102461a + ")";
    }

    public /* synthetic */ InAppUpdateViewState(ViewModelState viewModelState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Loading.f127895a : viewModelState);
    }
}
