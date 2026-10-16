package cz.mobilesoft.coreblock.scene.strictmode3.options;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class StrictModeOptionsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f122337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f122338b;

    public StrictModeOptionsViewState(ImmutableList selectedOptions, ImmutableList initialSelectedOptions) {
        Intrinsics.checkNotNullParameter(selectedOptions, "selectedOptions");
        Intrinsics.checkNotNullParameter(initialSelectedOptions, "initialSelectedOptions");
        this.f122337a = selectedOptions;
        this.f122338b = initialSelectedOptions;
    }

    public static /* synthetic */ StrictModeOptionsViewState b(StrictModeOptionsViewState strictModeOptionsViewState, ImmutableList immutableList, ImmutableList immutableList2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            immutableList = strictModeOptionsViewState.f122337a;
        }
        if ((i3 & 2) != 0) {
            immutableList2 = strictModeOptionsViewState.f122338b;
        }
        return strictModeOptionsViewState.a(immutableList, immutableList2);
    }

    public final StrictModeOptionsViewState a(ImmutableList selectedOptions, ImmutableList initialSelectedOptions) {
        Intrinsics.checkNotNullParameter(selectedOptions, "selectedOptions");
        Intrinsics.checkNotNullParameter(initialSelectedOptions, "initialSelectedOptions");
        return new StrictModeOptionsViewState(selectedOptions, initialSelectedOptions);
    }

    public final ImmutableList c() {
        return this.f122338b;
    }

    public final ImmutableList d() {
        return this.f122337a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeOptionsViewState)) {
            return false;
        }
        StrictModeOptionsViewState strictModeOptionsViewState = (StrictModeOptionsViewState) obj;
        return Intrinsics.areEqual(this.f122337a, strictModeOptionsViewState.f122337a) && Intrinsics.areEqual(this.f122338b, strictModeOptionsViewState.f122338b);
    }

    public int hashCode() {
        return (this.f122337a.hashCode() * 31) + this.f122338b.hashCode();
    }

    public String toString() {
        return "StrictModeOptionsViewState(selectedOptions=" + this.f122337a + ", initialSelectedOptions=" + this.f122338b + ")";
    }

    public /* synthetic */ StrictModeOptionsViewState(ImmutableList immutableList, ImmutableList immutableList2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ExtensionsKt.b(StrictModeOption.BlockEditing) : immutableList, (i3 & 2) != 0 ? ExtensionsKt.b(StrictModeOption.BlockEditing) : immutableList2);
    }
}
