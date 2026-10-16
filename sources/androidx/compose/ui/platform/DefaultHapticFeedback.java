package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DefaultHapticFeedback implements HapticFeedback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f28015a;

    public DefaultHapticFeedback(View view) {
        this.f28015a = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    public void a(int i3) {
        HapticFeedbackType.Companion companion = HapticFeedbackType.f26611b;
        if (HapticFeedbackType.c(i3, companion.a())) {
            this.f28015a.performHapticFeedback(16);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.b())) {
            this.f28015a.performHapticFeedback(6);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.c())) {
            this.f28015a.performHapticFeedback(13);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.d())) {
            this.f28015a.performHapticFeedback(23);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.e())) {
            this.f28015a.performHapticFeedback(0);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.f())) {
            this.f28015a.performHapticFeedback(17);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.g())) {
            this.f28015a.performHapticFeedback(27);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.h())) {
            this.f28015a.performHapticFeedback(26);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.i())) {
            this.f28015a.performHapticFeedback(9);
            return;
        }
        if (HapticFeedbackType.c(i3, companion.j())) {
            this.f28015a.performHapticFeedback(22);
        } else if (HapticFeedbackType.c(i3, companion.k())) {
            this.f28015a.performHapticFeedback(21);
        } else if (HapticFeedbackType.c(i3, companion.l())) {
            this.f28015a.performHapticFeedback(1);
        }
    }
}
