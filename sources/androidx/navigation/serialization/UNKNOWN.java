package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class UNKNOWN extends NavType<String> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final UNKNOWN f49478t = new UNKNOWN();

    private UNKNOWN() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return "unknown";
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public String a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // androidx.navigation.NavType
    public String l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return "null";
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void h(Bundle bundle, String key, String value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }
}
