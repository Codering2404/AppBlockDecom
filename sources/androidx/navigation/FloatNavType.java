package androidx.navigation;

import android.os.Bundle;
import androidx.legacy.content.Werj.QgXempTBEfV;
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
public final class FloatNavType extends NavType<Float> {
    public FloatNavType() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return LegacyTokenHelper.TYPE_FLOAT;
    }

    @Override // androidx.navigation.NavType
    public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
        m(bundle, str, ((Number) obj).floatValue());
    }

    @Override // androidx.navigation.NavType
    public Float l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Float.valueOf(Float.parseFloat(value));
    }

    public void m(Bundle bundle, String key, float f3) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        SavedStateWriter.o(SavedStateWriter.a(bundle), key, f3);
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Float a(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, QgXempTBEfV.TrkKPdtrKUJvE);
        return Float.valueOf(SavedStateReader.q(SavedStateReader.a(bundle), str));
    }
}
