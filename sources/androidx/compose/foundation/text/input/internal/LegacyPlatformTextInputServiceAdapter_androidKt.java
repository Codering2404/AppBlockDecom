package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class LegacyPlatformTextInputServiceAdapter_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Function1 f10388a = LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1.f10389a;

    public static final LegacyPlatformTextInputServiceAdapter b() {
        return new AndroidLegacyPlatformTextInputServiceAdapter();
    }

    public static final Function1 c() {
        return f10388a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EditorInfo editorInfo) {
        if (EmojiCompat.k()) {
            EmojiCompat.c().x(editorInfo);
        }
    }
}
