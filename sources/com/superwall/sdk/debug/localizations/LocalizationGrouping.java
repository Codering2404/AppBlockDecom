package com.superwall.sdk.debug.localizations;

import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalizationGrouping {
    private final List<LocalizationOption> localizations;
    private final String title;

    public LocalizationGrouping(List<LocalizationOption> localizations, String title) {
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(title, "title");
        this.localizations = localizations;
        this.title = title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalizationGrouping copy$default(LocalizationGrouping localizationGrouping, List list, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = localizationGrouping.localizations;
        }
        if ((i3 & 2) != 0) {
            str = localizationGrouping.title;
        }
        return localizationGrouping.copy(list, str);
    }

    public final List<LocalizationOption> component1() {
        return this.localizations;
    }

    public final String component2() {
        return this.title;
    }

    public final LocalizationGrouping copy(List<LocalizationOption> localizations, String title) {
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(title, "title");
        return new LocalizationGrouping(localizations, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalizationGrouping)) {
            return false;
        }
        LocalizationGrouping localizationGrouping = (LocalizationGrouping) obj;
        return Intrinsics.areEqual(this.localizations, localizationGrouping.localizations) && Intrinsics.areEqual(this.title, localizationGrouping.title);
    }

    public final List<LocalizationOption> getLocalizations() {
        return this.localizations;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.localizations.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "LocalizationGrouping(localizations=" + this.localizations + ", title=" + this.title + ")";
    }
}
