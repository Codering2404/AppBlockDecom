package cz.mobilesoft.coreblock.dto;

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
public final class InsightsBlockingSessions {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f96930c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f96931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f96932b;

    public InsightsBlockingSessions(int i3, List topApps) {
        Intrinsics.checkNotNullParameter(topApps, "topApps");
        this.f96931a = i3;
        this.f96932b = topApps;
    }

    public final List a() {
        return this.f96932b;
    }

    public final int b() {
        return this.f96931a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsightsBlockingSessions)) {
            return false;
        }
        InsightsBlockingSessions insightsBlockingSessions = (InsightsBlockingSessions) obj;
        return this.f96931a == insightsBlockingSessions.f96931a && Intrinsics.areEqual(this.f96932b, insightsBlockingSessions.f96932b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f96931a) * 31) + this.f96932b.hashCode();
    }

    public String toString() {
        return "InsightsBlockingSessions(totalCount=" + this.f96931a + ", topApps=" + this.f96932b + ")";
    }
}
