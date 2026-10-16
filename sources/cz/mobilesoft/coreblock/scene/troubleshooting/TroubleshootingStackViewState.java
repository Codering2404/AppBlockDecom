package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
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
public final class TroubleshootingStackViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelState f123013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f123014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f123015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f123016d;

    public TroubleshootingStackViewState(ViewModelState state, String title, String description, ImmutableList items) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f123013a = state;
        this.f123014b = title;
        this.f123015c = description;
        this.f123016d = items;
    }

    public static /* synthetic */ TroubleshootingStackViewState b(TroubleshootingStackViewState troubleshootingStackViewState, ViewModelState viewModelState, String str, String str2, ImmutableList immutableList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            viewModelState = troubleshootingStackViewState.f123013a;
        }
        if ((i3 & 2) != 0) {
            str = troubleshootingStackViewState.f123014b;
        }
        if ((i3 & 4) != 0) {
            str2 = troubleshootingStackViewState.f123015c;
        }
        if ((i3 & 8) != 0) {
            immutableList = troubleshootingStackViewState.f123016d;
        }
        return troubleshootingStackViewState.a(viewModelState, str, str2, immutableList);
    }

    public final TroubleshootingStackViewState a(ViewModelState state, String title, String description, ImmutableList items) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(items, "items");
        return new TroubleshootingStackViewState(state, title, description, items);
    }

    public final ImmutableList c() {
        return this.f123016d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TroubleshootingStackViewState)) {
            return false;
        }
        TroubleshootingStackViewState troubleshootingStackViewState = (TroubleshootingStackViewState) obj;
        return Intrinsics.areEqual(this.f123013a, troubleshootingStackViewState.f123013a) && Intrinsics.areEqual(this.f123014b, troubleshootingStackViewState.f123014b) && Intrinsics.areEqual(this.f123015c, troubleshootingStackViewState.f123015c) && Intrinsics.areEqual(this.f123016d, troubleshootingStackViewState.f123016d);
    }

    public int hashCode() {
        return (((((this.f123013a.hashCode() * 31) + this.f123014b.hashCode()) * 31) + this.f123015c.hashCode()) * 31) + this.f123016d.hashCode();
    }

    public String toString() {
        return "TroubleshootingStackViewState(state=" + this.f123013a + ", title=" + this.f123014b + ", description=" + this.f123015c + ", items=" + this.f123016d + ")";
    }

    public /* synthetic */ TroubleshootingStackViewState(ViewModelState viewModelState, String str, String str2, ImmutableList immutableList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Loading.f127895a : viewModelState, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? ExtensionsKt.a() : immutableList);
    }
}
