package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Strings_androidKt {
    public static final String a(int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-726638443, i4, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.q(AndroidCompositionLocals_androidKt.f());
        Resources resources = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getResources();
        Strings.Companion companion = Strings.f14174b;
        String string = Strings.j(i3, companion.e()) ? resources.getString(androidx.compose.ui.R.string.f25161h) : Strings.j(i3, companion.a()) ? resources.getString(androidx.compose.ui.R.string.f25154a) : Strings.j(i3, companion.b()) ? resources.getString(androidx.compose.ui.R.string.f25155b) : Strings.j(i3, companion.c()) ? resources.getString(androidx.compose.ui.R.string.f25156c) : Strings.j(i3, companion.d()) ? resources.getString(androidx.compose.ui.R.string.f25158e) : Strings.j(i3, companion.g()) ? resources.getString(androidx.compose.ui.R.string.f25164k) : Strings.j(i3, companion.f()) ? resources.getString(androidx.compose.ui.R.string.f25163j) : "";
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return string;
    }
}
