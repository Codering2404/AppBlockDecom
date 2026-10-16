package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
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
public final class KeyMapping_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final KeyMapping f9752a = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        public KeyCommand a(KeyEvent keyEvent) {
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.f(keyEvent) && KeyEvent_androidKt.d(keyEvent)) {
                long jA = KeyEvent_androidKt.a(keyEvent);
                MappedKeys mappedKeys = MappedKeys.f9835a;
                if (Key.p(jA, mappedKeys.i())) {
                    keyCommand = KeyCommand.Q;
                } else if (Key.p(jA, mappedKeys.j())) {
                    keyCommand = KeyCommand.R;
                } else if (Key.p(jA, mappedKeys.k())) {
                    keyCommand = KeyCommand.I;
                } else if (Key.p(jA, mappedKeys.h())) {
                    keyCommand = KeyCommand.J;
                }
            } else if (KeyEvent_androidKt.d(keyEvent)) {
                long jA2 = KeyEvent_androidKt.a(keyEvent);
                MappedKeys mappedKeys2 = MappedKeys.f9835a;
                if (Key.p(jA2, mappedKeys2.i())) {
                    keyCommand = KeyCommand.f9731k;
                } else if (Key.p(jA2, mappedKeys2.j())) {
                    keyCommand = KeyCommand.f9732l;
                } else if (Key.p(jA2, mappedKeys2.k())) {
                    keyCommand = KeyCommand.f9737q;
                } else if (Key.p(jA2, mappedKeys2.h())) {
                    keyCommand = KeyCommand.f9738r;
                }
            }
            return keyCommand == null ? KeyMappingKt.b().a(keyEvent) : keyCommand;
        }
    };

    public static final KeyMapping a() {
        return f9752a;
    }
}
