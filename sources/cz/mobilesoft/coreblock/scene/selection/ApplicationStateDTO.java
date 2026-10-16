package cz.mobilesoft.coreblock.scene.selection;

import cz.mobilesoft.coreblock.dto.ApplicationDTO;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ApplicationStateDTO {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f118052c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ApplicationDTO f118053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f118054b;

    public ApplicationStateDTO(ApplicationDTO parentApp, List subApps) {
        Intrinsics.checkNotNullParameter(parentApp, "parentApp");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        this.f118053a = parentApp;
        this.f118054b = subApps;
    }

    public static /* synthetic */ ApplicationStateDTO b(ApplicationStateDTO applicationStateDTO, ApplicationDTO applicationDTO, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            applicationDTO = applicationStateDTO.f118053a;
        }
        if ((i3 & 2) != 0) {
            list = applicationStateDTO.f118054b;
        }
        return applicationStateDTO.a(applicationDTO, list);
    }

    public final ApplicationStateDTO a(ApplicationDTO parentApp, List subApps) {
        Intrinsics.checkNotNullParameter(parentApp, "parentApp");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        return new ApplicationStateDTO(parentApp, subApps);
    }

    public final ApplicationDTO c() {
        return this.f118053a;
    }

    public final List d() {
        return this.f118054b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationStateDTO)) {
            return false;
        }
        ApplicationStateDTO applicationStateDTO = (ApplicationStateDTO) obj;
        return Intrinsics.areEqual(this.f118053a, applicationStateDTO.f118053a) && Intrinsics.areEqual(this.f118054b, applicationStateDTO.f118054b);
    }

    public int hashCode() {
        return (this.f118053a.hashCode() * 31) + this.f118054b.hashCode();
    }

    public String toString() {
        return "ApplicationStateDTO(parentApp=" + this.f118053a + ", subApps=" + this.f118054b + ")";
    }
}
