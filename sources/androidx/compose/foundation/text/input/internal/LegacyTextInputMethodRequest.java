package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f10390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputMethodManager f10391b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LegacyTextFieldState f10394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextFieldSelectionManager f10395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewConfiguration f10396g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Rect f10401l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LegacyCursorAnchorInfoController f10402m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f10392c = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onEditCommand$1
        public final void invoke(List list) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f10393d = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onImeActionPerformed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c(((ImeAction) obj).p());
            return Unit.f139807a;
        }

        public final void c(int i3) {
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextFieldValue f10397h = new TextFieldValue("", TextRange.f28921b.a(), (TextRange) null, 4, (DefaultConstructorMarker) null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImeOptions f10398i = ImeOptions.f29359h.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f10399j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f10400k = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BaseInputConnection>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$baseInputConnection$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final BaseInputConnection invoke() {
            return new BaseInputConnection(this.f10403a.i(), false);
        }
    });

    public LegacyTextInputMethodRequest(View view, Function1 function1, InputMethodManager inputMethodManager) {
        this.f10390a = view;
        this.f10391b = inputMethodManager;
        this.f10402m = new LegacyCursorAnchorInfoController(function1, inputMethodManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection h() {
        return (BaseInputConnection) this.f10400k.getValue();
    }

    private final void k() {
        this.f10391b.b();
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public RecordingInputConnection a(EditorInfo editorInfo) {
        EditorInfo_androidKt.c(editorInfo, this.f10397h.i(), this.f10397h.h(), this.f10398i, null, 8, null);
        LegacyPlatformTextInputServiceAdapter_androidKt.d(editorInfo);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.f10397h, new InputEventCallback2() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$createInputConnection$1
            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void a(int i3) {
                this.f10404a.f10393d.invoke(ImeAction.j(i3));
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void b(KeyEvent keyEvent) {
                this.f10404a.h().sendKeyEvent(keyEvent);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void c(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
                this.f10404a.f10402m.b(z2, z3, z4, z5, z6, z7);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void d(List list) {
                this.f10404a.f10392c.invoke(list);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void e(RecordingInputConnection recordingInputConnection2) {
                int size = this.f10404a.f10399j.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (Intrinsics.areEqual(((WeakReference) this.f10404a.f10399j.get(i3)).get(), recordingInputConnection2)) {
                        this.f10404a.f10399j.remove(i3);
                        return;
                    }
                }
            }
        }, this.f10398i.b(), this.f10394e, this.f10395f, this.f10396g);
        this.f10399j.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }

    public final View i() {
        return this.f10390a;
    }

    public final void j(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.f10401l = new Rect(MathKt.d(rect.o()), MathKt.d(rect.r()), MathKt.d(rect.p()), MathKt.d(rect.i()));
        if (!this.f10399j.isEmpty() || (rect2 = this.f10401l) == null) {
            return;
        }
        this.f10390a.requestRectangleOnScreen(new Rect(rect2));
    }

    public final void l(TextFieldValue textFieldValue, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, ImeOptions imeOptions, Function1 function1, Function1 function12) {
        this.f10397h = textFieldValue;
        this.f10398i = imeOptions;
        this.f10392c = function1;
        this.f10393d = function12;
        this.f10394e = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.c2() : null;
        this.f10395f = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.t1() : null;
        this.f10396g = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.getViewConfiguration() : null;
    }

    public final void m(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z2 = (TextRange.g(this.f10397h.h(), textFieldValue2.h()) && Intrinsics.areEqual(this.f10397h.g(), textFieldValue2.g())) ? false : true;
        this.f10397h = textFieldValue2;
        int size = this.f10399j.size();
        for (int i3 = 0; i3 < size; i3++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) this.f10399j.get(i3)).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.g(textFieldValue2);
            }
        }
        this.f10402m.a();
        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            if (z2) {
                InputMethodManager inputMethodManager = this.f10391b;
                int iL = TextRange.l(textFieldValue2.h());
                int iK = TextRange.k(textFieldValue2.h());
                TextRange textRangeG = this.f10397h.g();
                int iL2 = textRangeG != null ? TextRange.l(textRangeG.r()) : -1;
                TextRange textRangeG2 = this.f10397h.g();
                inputMethodManager.a(iL, iK, iL2, textRangeG2 != null ? TextRange.k(textRangeG2.r()) : -1);
                return;
            }
            return;
        }
        if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.i(), textFieldValue2.i()) || (TextRange.g(textFieldValue.h(), textFieldValue2.h()) && !Intrinsics.areEqual(textFieldValue.g(), textFieldValue2.g())))) {
            k();
            return;
        }
        int size2 = this.f10399j.size();
        for (int i4 = 0; i4 < size2; i4++) {
            RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) this.f10399j.get(i4)).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.h(this.f10397h, this.f10391b);
            }
        }
    }

    public final void n(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        this.f10402m.d(textFieldValue, offsetMapping, textLayoutResult, rect, rect2);
    }
}
