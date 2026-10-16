package com.google.firebase.crashlytics.internal.common;

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
public final class FirebaseInstallationId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88437b;

    public FirebaseInstallationId(String str, String str2) {
        this.f88436a = str;
        this.f88437b = str2;
    }

    public final String a() {
        return this.f88437b;
    }

    public final String b() {
        return this.f88436a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirebaseInstallationId)) {
            return false;
        }
        FirebaseInstallationId firebaseInstallationId = (FirebaseInstallationId) obj;
        return Intrinsics.areEqual(this.f88436a, firebaseInstallationId.f88436a) && Intrinsics.areEqual(this.f88437b, firebaseInstallationId.f88437b);
    }

    public int hashCode() {
        String str = this.f88436a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f88437b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f88436a + ", authToken=" + this.f88437b + ')';
    }
}
