package androidx.navigation;

import android.os.Bundle;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.facebook.LegacyTokenHelper;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StringNavType extends NavType<String> {
    public StringNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return LegacyTokenHelper.TYPE_STRING;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public String a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateReader.a(bundle);
        if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
            return null;
        }
        return SavedStateReader.J(bundleA, key);
    }

    @Override // androidx.navigation.NavType
    public String l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "null")) {
            return null;
        }
        return value;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public String i(String str) {
        String strC;
        return (str == null || (strC = NavUriUtils.c(NavUriUtils.f48980a, str, null, 2, null)) == null) ? "null" : strC;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void h(Bundle bundle, String key, String str) {
        Intrinsics.checkNotNullParameter(bundle, CbYNFSEGaQj.NuskaLNDpm);
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateWriter.a(bundle);
        if (str != null) {
            SavedStateWriter.F(bundleA, key, str);
        } else {
            SavedStateWriter.w(bundleA, key);
        }
    }
}
