package androidx.compose.foundation.internal;

import android.content.ClipData;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.text.AnnotatedString;
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
public final class ClipboardUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClipboardUtils f6518a = new ClipboardUtils();

    private ClipboardUtils() {
    }

    public static final boolean a(ClipEntry clipEntry) {
        if (clipEntry == null) {
            return false;
        }
        return clipEntry.a().getDescription().hasMimeType("text/*");
    }

    public static final AnnotatedString b(ClipEntry clipEntry) {
        CharSequence text;
        ClipData.Item itemAt = clipEntry.a().getItemAt(0);
        if (itemAt == null || (text = itemAt.getText()) == null) {
            return null;
        }
        return ClipboardUtils_androidKt.a(text);
    }

    public static final String c(ClipEntry clipEntry) {
        CharSequence text;
        ClipData.Item itemAt = clipEntry.a().getItemAt(0);
        if (itemAt == null || (text = itemAt.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public static final ClipEntry d(AnnotatedString annotatedString) {
        if (annotatedString == null) {
            return null;
        }
        return new ClipEntry(ClipData.newPlainText("plain text", ClipboardUtils_androidKt.b(annotatedString)));
    }
}
