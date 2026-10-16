package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.facebook.LegacyTokenHelper;
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
public final class LongNavType extends NavType<Long> {
    public LongNavType() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return LegacyTokenHelper.TYPE_LONG;
    }

    @Override // androidx.navigation.NavType
    public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
        m(bundle, str, ((Number) obj).longValue());
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Long a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return Long.valueOf(SavedStateReader.w(SavedStateReader.a(bundle), key));
    }

    @Override // androidx.navigation.NavType
    public Long l(String value) {
        String strSubstring;
        long j3;
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.E(value, "L", false, 2, null)) {
            strSubstring = value.substring(0, value.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = value;
        }
        if (StringsKt.U(value, "0x", false, 2, null)) {
            String strSubstring2 = strSubstring.substring(2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            j3 = Long.parseLong(strSubstring2, CharsKt.checkRadix(16));
        } else {
            j3 = Long.parseLong(strSubstring);
        }
        return Long.valueOf(j3);
    }

    public void m(Bundle bundle, String key, long j3) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        SavedStateWriter.u(SavedStateWriter.a(bundle), key, j3);
    }
}
