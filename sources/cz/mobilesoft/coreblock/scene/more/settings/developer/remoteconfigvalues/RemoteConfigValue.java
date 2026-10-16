package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

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
public final class RemoteConfigValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f109277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f109278b;

    public RemoteConfigValue(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f109277a = key;
        this.f109278b = value;
    }

    public final String a() {
        return this.f109277a;
    }

    public final String b() {
        return this.f109278b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfigValue)) {
            return false;
        }
        RemoteConfigValue remoteConfigValue = (RemoteConfigValue) obj;
        return Intrinsics.areEqual(this.f109277a, remoteConfigValue.f109277a) && Intrinsics.areEqual(this.f109278b, remoteConfigValue.f109278b);
    }

    public int hashCode() {
        return (this.f109277a.hashCode() * 31) + this.f109278b.hashCode();
    }

    public String toString() {
        return "RemoteConfigValue(key=" + this.f109277a + ", value=" + this.f109278b + ")";
    }
}
