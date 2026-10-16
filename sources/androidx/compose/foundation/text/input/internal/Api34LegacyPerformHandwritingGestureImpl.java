package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
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
final class Api34LegacyPerformHandwritingGestureImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api34LegacyPerformHandwritingGestureImpl f10238a = new Api34LegacyPerformHandwritingGestureImpl();

    private Api34LegacyPerformHandwritingGestureImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(IntConsumer intConsumer, int i3) {
        intConsumer.accept(i3);
    }

    public final void b(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, HandwritingGesture handwritingGesture, ViewConfiguration viewConfiguration, Executor executor, final IntConsumer intConsumer, Function1 function1) {
        final int iL = legacyTextFieldState != null ? HandwritingGestureApi34.f10329a.l(legacyTextFieldState, handwritingGesture, textFieldSelectionManager, viewConfiguration, function1) : 3;
        if (intConsumer == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new Runnable() { // from class: androidx.compose.foundation.text.input.internal.c
                @Override // java.lang.Runnable
                public final void run() {
                    Api34LegacyPerformHandwritingGestureImpl.c(intConsumer, iL);
                }
            });
        } else {
            intConsumer.accept(iL);
        }
    }

    public final boolean d(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (legacyTextFieldState != null) {
            return HandwritingGestureApi34.f10329a.D(legacyTextFieldState, previewableHandwritingGesture, textFieldSelectionManager, cancellationSignal);
        }
        return false;
    }
}
