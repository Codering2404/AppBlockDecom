package androidx.compose.material3.internal;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import d.qFm.sECyKyO;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class Strings_androidKt {
    public static final String a(int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-907677715, i4, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:30)");
        }
        composer.q(AndroidCompositionLocals_androidKt.f());
        String string = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getResources().getString(i3);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return string;
    }

    public static final String b(int i3, Object[] objArr, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1427268608, i4, -1, sECyKyO.rBeftTu);
        }
        String strA = a(i3, composer, i4 & 14);
        Locale localeD = ConfigurationCompat.a((Configuration) composer.q(AndroidCompositionLocals_androidKt.f())).d(0);
        if (localeD == null) {
            localeD = Locale.getDefault();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str = String.format(localeD, strA, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return str;
    }
}
