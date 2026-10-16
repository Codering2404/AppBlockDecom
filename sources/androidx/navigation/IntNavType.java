package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

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
public final class IntNavType extends NavType<Integer> {
    public IntNavType() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return "integer";
    }

    @Override // androidx.navigation.NavType
    public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
        m(bundle, str, ((Number) obj).intValue());
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Integer a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return Integer.valueOf(SavedStateReader.s(SavedStateReader.a(bundle), key));
    }

    @Override // androidx.navigation.NavType
    public Integer l(String value) {
        int i3;
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.U(value, "0x", false, 2, null)) {
            String strSubstring = value.substring(2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            i3 = Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
        } else {
            i3 = Integer.parseInt(value);
        }
        return Integer.valueOf(i3);
    }

    public void m(Bundle bundle, String key, int i3) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        SavedStateWriter.q(SavedStateWriter.a(bundle), key, i3);
    }
}
