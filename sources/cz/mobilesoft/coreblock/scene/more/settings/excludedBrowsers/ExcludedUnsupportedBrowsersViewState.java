package cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers;

import cz.mobilesoft.coreblock.base.ViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ExcludedUnsupportedBrowsersViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f109664a;

    public ExcludedUnsupportedBrowsersViewState(List unsupportedBrowsers) {
        Intrinsics.checkNotNullParameter(unsupportedBrowsers, "unsupportedBrowsers");
        this.f109664a = unsupportedBrowsers;
    }

    public final ExcludedUnsupportedBrowsersViewState a(List unsupportedBrowsers) {
        Intrinsics.checkNotNullParameter(unsupportedBrowsers, "unsupportedBrowsers");
        return new ExcludedUnsupportedBrowsersViewState(unsupportedBrowsers);
    }

    public final List b() {
        return this.f109664a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExcludedUnsupportedBrowsersViewState) && Intrinsics.areEqual(this.f109664a, ((ExcludedUnsupportedBrowsersViewState) obj).f109664a);
    }

    public int hashCode() {
        return this.f109664a.hashCode();
    }

    public String toString() {
        return "ExcludedUnsupportedBrowsersViewState(unsupportedBrowsers=" + this.f109664a + ")";
    }

    public /* synthetic */ ExcludedUnsupportedBrowsersViewState(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
