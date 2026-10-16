package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.KeyEvent;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 implements TextInputSession, ImeEditCommandScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DefaultImeEditCommandScope f10228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TransformedTextFieldState f10229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ComposeInputMethodManager f10230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f10231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ReceiveContentConfiguration f10232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CursorAnchorInfoController f10233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TextLayoutState f10234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f10235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ViewConfiguration f10236i;

    AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1(DefaultImeEditCommandScope defaultImeEditCommandScope, TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Function1 function1, ReceiveContentConfiguration receiveContentConfiguration, CursorAnchorInfoController cursorAnchorInfoController, TextLayoutState textLayoutState, Function0 function0, ViewConfiguration viewConfiguration) {
        this.f10229b = transformedTextFieldState;
        this.f10230c = composeInputMethodManager;
        this.f10231d = function1;
        this.f10232e = receiveContentConfiguration;
        this.f10233f = cursorAnchorInfoController;
        this.f10234g = textLayoutState;
        this.f10235h = function0;
        this.f10236i = viewConfiguration;
        this.f10228a = defaultImeEditCommandScope;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public void a(int i3) {
        Function1 function1 = this.f10231d;
        if (function1 != null) {
            function1.invoke(ImeAction.j(i3));
        }
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public void b(Function1 function1) {
        this.f10228a.b(function1);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean beginBatchEdit() {
        return this.f10228a.beginBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public int c(HandwritingGesture handwritingGesture) {
        if (Build.VERSION.SDK_INT >= 34) {
            return HandwritingGestureApi34.f10329a.m(this.f10229b, handwritingGesture, this.f10234g, this.f10235h, this.f10236i);
        }
        return 2;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public long d(long j3) {
        return this.f10228a.d(j3);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public long e(long j3) {
        return this.f10228a.e(j3);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean endBatchEdit() {
        return this.f10228a.endBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public boolean f(TransferableContent transferableContent) {
        ReceiveContentConfiguration receiveContentConfiguration = this.f10232e;
        if (receiveContentConfiguration != null) {
            return receiveContentConfiguration.b(transferableContent);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public TextFieldCharSequence getText() {
        return this.f10229b.o();
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (Build.VERSION.SDK_INT >= 34) {
            return HandwritingGestureApi34.f10329a.E(this.f10229b, previewableHandwritingGesture, this.f10234g, cancellationSignal);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public void requestCursorUpdates(int i3) {
        this.f10233f.d(i3);
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public void sendKeyEvent(KeyEvent keyEvent) {
        this.f10230c.sendKeyEvent(keyEvent);
    }
}
