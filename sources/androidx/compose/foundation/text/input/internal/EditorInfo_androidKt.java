package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.facebook.internal.Utility;
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
public final class EditorInfo_androidKt {
    private static final boolean a(int i3, int i4) {
        return (i3 & i4) == i4;
    }

    public static final void b(EditorInfo editorInfo, CharSequence charSequence, long j3, ImeOptions imeOptions, String[] strArr) {
        String strA;
        int iE = imeOptions.e();
        ImeAction.Companion companion = ImeAction.f29348b;
        int i3 = 3;
        int i4 = 6;
        if (ImeAction.m(iE, companion.a())) {
            if (!imeOptions.h()) {
                i4 = 0;
            }
        } else if (ImeAction.m(iE, companion.e())) {
            i4 = 1;
        } else if (ImeAction.m(iE, companion.c())) {
            i4 = 2;
        } else if (ImeAction.m(iE, companion.d())) {
            i4 = 5;
        } else if (ImeAction.m(iE, companion.f())) {
            i4 = 7;
        } else if (ImeAction.m(iE, companion.g())) {
            i4 = 3;
        } else if (ImeAction.m(iE, companion.h())) {
            i4 = 4;
        } else if (!ImeAction.m(iE, companion.b())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i4;
        PlatformImeOptions platformImeOptionsG = imeOptions.g();
        if (platformImeOptionsG != null && (strA = platformImeOptionsG.a()) != null) {
            editorInfo.privateImeOptions = strA;
        }
        LocaleListHelper.f10407a.a(editorInfo, imeOptions.d());
        int iF = imeOptions.f();
        KeyboardType.Companion companion2 = KeyboardType.f29379b;
        if (KeyboardType.n(iF, companion2.h())) {
            i3 = 1;
        } else if (KeyboardType.n(iF, companion2.a())) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i3 = 1;
        } else if (KeyboardType.n(iF, companion2.d())) {
            i3 = 2;
        } else if (!KeyboardType.n(iF, companion2.g())) {
            if (KeyboardType.n(iF, companion2.j())) {
                i3 = 17;
            } else if (KeyboardType.n(iF, companion2.c())) {
                i3 = 33;
            } else if (KeyboardType.n(iF, companion2.f())) {
                i3 = 129;
            } else if (KeyboardType.n(iF, companion2.e())) {
                i3 = 18;
            } else {
                if (!KeyboardType.n(iF, companion2.b())) {
                    throw new IllegalStateException("Invalid Keyboard Type");
                }
                i3 = 8194;
            }
        }
        editorInfo.inputType = i3;
        if (!imeOptions.h() && a(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m(imeOptions.e(), companion.a())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (a(editorInfo.inputType, 1)) {
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
        editorInfo.initialSelStart = TextRange.n(j3);
        editorInfo.initialSelEnd = TextRange.i(j3);
        EditorInfoCompat.e(editorInfo, charSequence);
        if (strArr != null) {
            EditorInfoCompat.c(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.a() || KeyboardType.n(imeOptions.f(), companion2.f()) || KeyboardType.n(imeOptions.f(), companion2.e())) {
            EditorInfoCompat.f(editorInfo, false);
        } else {
            EditorInfoCompat.f(editorInfo, true);
            EditorInfoApi34.f10324a.a(editorInfo);
        }
    }

    public static /* synthetic */ void c(EditorInfo editorInfo, CharSequence charSequence, long j3, ImeOptions imeOptions, String[] strArr, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            strArr = null;
        }
        b(editorInfo, charSequence, j3, imeOptions, strArr);
    }
}
