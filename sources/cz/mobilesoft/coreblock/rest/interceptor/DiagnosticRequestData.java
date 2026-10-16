package cz.mobilesoft.coreblock.rest.interceptor;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
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
public final class DiagnosticRequestData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f98513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f98514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f98515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f98516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f98517e;

    public DiagnosticRequestData(long j3, String url, String method, String headers, String requestBody) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        this.f98513a = j3;
        this.f98514b = url;
        this.f98515c = method;
        this.f98516d = headers;
        this.f98517e = requestBody;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiagnosticRequestData)) {
            return false;
        }
        DiagnosticRequestData diagnosticRequestData = (DiagnosticRequestData) obj;
        return this.f98513a == diagnosticRequestData.f98513a && Intrinsics.areEqual(this.f98514b, diagnosticRequestData.f98514b) && Intrinsics.areEqual(this.f98515c, diagnosticRequestData.f98515c) && Intrinsics.areEqual(this.f98516d, diagnosticRequestData.f98516d) && Intrinsics.areEqual(this.f98517e, diagnosticRequestData.f98517e);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f98513a) * 31) + this.f98514b.hashCode()) * 31) + this.f98515c.hashCode()) * 31) + this.f98516d.hashCode()) * 31) + this.f98517e.hashCode();
    }

    public String toString() {
        return "DiagnosticRequestData(timestamp=" + this.f98513a + ", url=" + this.f98514b + ", method=" + this.f98515c + ", headers=" + this.f98516d + ", requestBody=" + this.f98517e + QaXmqxvjHhxVy.mzdrjIDd;
    }
}
