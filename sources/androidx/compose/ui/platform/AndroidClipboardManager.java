package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
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
public final class AndroidClipboardManager implements ClipboardManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.content.ClipboardManager f27678a;

    public AndroidClipboardManager(android.content.ClipboardManager clipboardManager) {
        this.f27678a = clipboardManager;
    }

    public ClipEntry a() {
        ClipData primaryClip = this.f27678a.getPrimaryClip();
        if (primaryClip != null) {
            return new ClipEntry(primaryClip);
        }
        return null;
    }

    public boolean b() {
        ClipDescription primaryClipDescription = this.f27678a.getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    public void c(ClipEntry clipEntry) {
        if (clipEntry == null) {
            Api28ClipboardManagerClipClear.a(this.f27678a);
        } else {
            this.f27678a.setPrimaryClip(clipEntry.a());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AndroidClipboardManager(Context context) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this((android.content.ClipboardManager) systemService);
    }
}
