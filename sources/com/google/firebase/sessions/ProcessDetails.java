package com.google.firebase.sessions;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ProcessDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f90006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f90007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f90008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f90009d;

    public ProcessDetails(String processName, int i3, int i4, boolean z2) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        this.f90006a = processName;
        this.f90007b = i3;
        this.f90008c = i4;
        this.f90009d = z2;
    }

    public final int a() {
        return this.f90008c;
    }

    public final int b() {
        return this.f90007b;
    }

    public final String c() {
        return this.f90006a;
    }

    public final boolean d() {
        return this.f90009d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return Intrinsics.areEqual(this.f90006a, processDetails.f90006a) && this.f90007b == processDetails.f90007b && this.f90008c == processDetails.f90008c && this.f90009d == processDetails.f90009d;
    }

    public int hashCode() {
        return (((((this.f90006a.hashCode() * 31) + Integer.hashCode(this.f90007b)) * 31) + Integer.hashCode(this.f90008c)) * 31) + Boolean.hashCode(this.f90009d);
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f90006a + ", pid=" + this.f90007b + ", importance=" + this.f90008c + ", isDefaultProcess=" + this.f90009d + ')';
    }
}
