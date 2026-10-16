package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import com.facebook.internal.Utility;
import java.util.concurrent.Executor;
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
public final class TextInputServiceAndroid_androidKt {
    public static final Executor d(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.d
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.e(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.e
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j3) {
                TextInputServiceAndroid_androidKt.f(runnable, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Runnable runnable, long j3) {
        runnable.run();
    }

    private static final boolean g(int i3, int i4) {
        return (i3 & i4) == i4;
    }

    public static final void h(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String strA;
        int iE = imeOptions.e();
        ImeAction.Companion companion = ImeAction.f29348b;
        int i3 = 6;
        if (ImeAction.m(iE, companion.a())) {
            if (!imeOptions.h()) {
                i3 = 0;
            }
        } else if (ImeAction.m(iE, companion.e())) {
            i3 = 1;
        } else if (ImeAction.m(iE, companion.c())) {
            i3 = 2;
        } else if (ImeAction.m(iE, companion.d())) {
            i3 = 5;
        } else if (ImeAction.m(iE, companion.f())) {
            i3 = 7;
        } else if (ImeAction.m(iE, companion.g())) {
            i3 = 3;
        } else if (ImeAction.m(iE, companion.h())) {
            i3 = 4;
        } else if (!ImeAction.m(iE, companion.b())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i3;
        PlatformImeOptions platformImeOptionsG = imeOptions.g();
        if (platformImeOptionsG != null && (strA = platformImeOptionsG.a()) != null) {
            editorInfo.privateImeOptions = strA;
        }
        int iF = imeOptions.f();
        KeyboardType.Companion companion2 = KeyboardType.f29379b;
        if (KeyboardType.n(iF, companion2.h())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.n(iF, companion2.a())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.n(iF, companion2.d())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.n(iF, companion2.g())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.n(iF, companion2.j())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.n(iF, companion2.c())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.n(iF, companion2.f())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.n(iF, companion2.e())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.n(iF, companion2.b())) {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.h() && g(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m(imeOptions.e(), companion.a())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (g(editorInfo.inputType, 1)) {
            int iC = imeOptions.c();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.f29372b;
            if (KeyboardCapitalization.i(iC, companion3.a())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.i(iC, companion3.e())) {
                editorInfo.inputType |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            } else if (KeyboardCapitalization.i(iC, companion3.c())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.b()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.n(textFieldValue.h());
        editorInfo.initialSelEnd = TextRange.i(textFieldValue.h());
        EditorInfoCompat.e(editorInfo, textFieldValue.i());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EditorInfo editorInfo) {
        if (EmojiCompat.k()) {
            EmojiCompat.c().x(editorInfo);
        }
    }
}
