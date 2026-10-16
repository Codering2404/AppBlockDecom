package cz.mobilesoft.coreblock.scene.whats_new;

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
public final class WhatsNewFullScreenViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f123063a;

    public WhatsNewFullScreenViewState(List pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.f123063a = pages;
    }

    public final WhatsNewFullScreenViewState a(List pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new WhatsNewFullScreenViewState(pages);
    }

    public final int b() {
        return this.f123063a.size();
    }

    public final List c() {
        return this.f123063a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WhatsNewFullScreenViewState) && Intrinsics.areEqual(this.f123063a, ((WhatsNewFullScreenViewState) obj).f123063a);
    }

    public int hashCode() {
        return this.f123063a.hashCode();
    }

    public String toString() {
        return "WhatsNewFullScreenViewState(pages=" + this.f123063a + ")";
    }

    public /* synthetic */ WhatsNewFullScreenViewState(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
