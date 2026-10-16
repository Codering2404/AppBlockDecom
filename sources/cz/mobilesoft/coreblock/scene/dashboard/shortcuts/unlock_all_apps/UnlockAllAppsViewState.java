package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.BlockingState;
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
public final class UnlockAllAppsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingState f101518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f101519b;

    public UnlockAllAppsViewState(BlockingState blockingState, boolean z2) {
        Intrinsics.checkNotNullParameter(blockingState, "blockingState");
        this.f101518a = blockingState;
        this.f101519b = z2;
    }

    public static /* synthetic */ UnlockAllAppsViewState b(UnlockAllAppsViewState unlockAllAppsViewState, BlockingState blockingState, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            blockingState = unlockAllAppsViewState.f101518a;
        }
        if ((i3 & 2) != 0) {
            z2 = unlockAllAppsViewState.f101519b;
        }
        return unlockAllAppsViewState.a(blockingState, z2);
    }

    public final UnlockAllAppsViewState a(BlockingState blockingState, boolean z2) {
        Intrinsics.checkNotNullParameter(blockingState, "blockingState");
        return new UnlockAllAppsViewState(blockingState, z2);
    }

    public final BlockingState c() {
        return this.f101518a;
    }

    public final boolean d() {
        return this.f101519b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnlockAllAppsViewState)) {
            return false;
        }
        UnlockAllAppsViewState unlockAllAppsViewState = (UnlockAllAppsViewState) obj;
        return Intrinsics.areEqual(this.f101518a, unlockAllAppsViewState.f101518a) && this.f101519b == unlockAllAppsViewState.f101519b;
    }

    public int hashCode() {
        return (this.f101518a.hashCode() * 31) + Boolean.hashCode(this.f101519b);
    }

    public String toString() {
        return "UnlockAllAppsViewState(blockingState=" + this.f101518a + ", showUnlockSuccess=" + this.f101519b + ")";
    }

    public /* synthetic */ UnlockAllAppsViewState(BlockingState blockingState, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? BlockingState.Loading.f101480a : blockingState, (i3 & 2) != 0 ? false : z2);
    }
}
