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
public final class SessionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f90058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f90059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f90060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f90061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataCollectionStatus f90062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f90063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f90064g;

    public SessionInfo(String sessionId, String firstSessionId, int i3, long j3, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        Intrinsics.checkNotNullParameter(dataCollectionStatus, "dataCollectionStatus");
        Intrinsics.checkNotNullParameter(firebaseInstallationId, "firebaseInstallationId");
        Intrinsics.checkNotNullParameter(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f90058a = sessionId;
        this.f90059b = firstSessionId;
        this.f90060c = i3;
        this.f90061d = j3;
        this.f90062e = dataCollectionStatus;
        this.f90063f = firebaseInstallationId;
        this.f90064g = firebaseAuthenticationToken;
    }

    public final DataCollectionStatus a() {
        return this.f90062e;
    }

    public final long b() {
        return this.f90061d;
    }

    public final String c() {
        return this.f90064g;
    }

    public final String d() {
        return this.f90063f;
    }

    public final String e() {
        return this.f90059b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return Intrinsics.areEqual(this.f90058a, sessionInfo.f90058a) && Intrinsics.areEqual(this.f90059b, sessionInfo.f90059b) && this.f90060c == sessionInfo.f90060c && this.f90061d == sessionInfo.f90061d && Intrinsics.areEqual(this.f90062e, sessionInfo.f90062e) && Intrinsics.areEqual(this.f90063f, sessionInfo.f90063f) && Intrinsics.areEqual(this.f90064g, sessionInfo.f90064g);
    }

    public final String f() {
        return this.f90058a;
    }

    public final int g() {
        return this.f90060c;
    }

    public int hashCode() {
        return (((((((((((this.f90058a.hashCode() * 31) + this.f90059b.hashCode()) * 31) + Integer.hashCode(this.f90060c)) * 31) + Long.hashCode(this.f90061d)) * 31) + this.f90062e.hashCode()) * 31) + this.f90063f.hashCode()) * 31) + this.f90064g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f90058a + ", firstSessionId=" + this.f90059b + ", sessionIndex=" + this.f90060c + ", eventTimestampUs=" + this.f90061d + ", dataCollectionStatus=" + this.f90062e + ", firebaseInstallationId=" + this.f90063f + ", firebaseAuthenticationToken=" + this.f90064g + ')';
    }
}
