package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import java.io.Serializable;
import kotlin.Metadata;
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
public final class WifiNetwork implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126524c;

    public WifiNetwork(long j3, long j4, String ssid) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        this.f126522a = j3;
        this.f126523b = j4;
        this.f126524c = ssid;
    }

    public final long a() {
        return this.f126522a;
    }

    public final long b() {
        return this.f126523b;
    }

    public final String c() {
        return this.f126524c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiNetwork)) {
            return false;
        }
        WifiNetwork wifiNetwork = (WifiNetwork) obj;
        return this.f126522a == wifiNetwork.f126522a && this.f126523b == wifiNetwork.f126523b && Intrinsics.areEqual(this.f126524c, wifiNetwork.f126524c);
    }

    public int hashCode() {
        return (((Long.hashCode(this.f126522a) * 31) + Long.hashCode(this.f126523b)) * 31) + this.f126524c.hashCode();
    }

    public String toString() {
        return "WifiNetwork(id=" + this.f126522a + ", profileId=" + this.f126523b + ", ssid=" + this.f126524c + ")";
    }

    public /* synthetic */ WifiNetwork(long j3, long j4, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, str);
    }
}
