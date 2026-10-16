package cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist;

import cz.mobilesoft.coreblock.base.ViewState;
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
public final class BrowsersListViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f109051a;

    public BrowsersListViewState(ImmutableList browsers) {
        Intrinsics.checkNotNullParameter(browsers, "browsers");
        this.f109051a = browsers;
    }

    public final BrowsersListViewState a(ImmutableList browsers) {
        Intrinsics.checkNotNullParameter(browsers, "browsers");
        return new BrowsersListViewState(browsers);
    }

    public final ImmutableList b() {
        return this.f109051a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrowsersListViewState) && Intrinsics.areEqual(this.f109051a, ((BrowsersListViewState) obj).f109051a);
    }

    public int hashCode() {
        return this.f109051a.hashCode();
    }

    public String toString() {
        return "BrowsersListViewState(browsers=" + this.f109051a + ")";
    }

    public /* synthetic */ BrowsersListViewState(ImmutableList immutableList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ExtensionsKt.a() : immutableList);
    }
}
