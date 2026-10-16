package androidx.compose.ui.input.key;

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
public final class KeyEvent_androidKt {
    public static final long a(android.view.KeyEvent keyEvent) {
        return Key_androidKt.a(keyEvent.getKeyCode());
    }

    public static final int b(android.view.KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        return action != 0 ? action != 1 ? KeyEventType.f26731b.c() : KeyEventType.f26731b.b() : KeyEventType.f26731b.a();
    }

    public static final int c(android.view.KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar();
    }

    public static final boolean d(android.view.KeyEvent keyEvent) {
        return keyEvent.isAltPressed();
    }

    public static final boolean e(android.view.KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    public static final boolean f(android.view.KeyEvent keyEvent) {
        return keyEvent.isShiftPressed();
    }
}
