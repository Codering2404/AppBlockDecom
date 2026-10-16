package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.core.view.SoftwareKeyboardControllerCompat;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
abstract class ComposeInputMethodManagerImpl implements ComposeInputMethodManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f10249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.view.inputmethod.InputMethodManager f10250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SoftwareKeyboardControllerCompat f10251c;

    public ComposeInputMethodManagerImpl(View view) {
        this.f10249a = view;
        this.f10251c = new SoftwareKeyboardControllerCompat(view);
    }

    private final android.view.inputmethod.InputMethodManager f() {
        Object systemService = this.f10249a.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (android.view.inputmethod.InputMethodManager) systemService;
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void a(int i3, int i4, int i5, int i6) {
        h().updateSelection(this.f10249a, i3, i4, i5, i6);
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void b() {
        h().restartInput(this.f10249a);
    }

    protected final View g() {
        return this.f10249a;
    }

    protected final android.view.inputmethod.InputMethodManager h() {
        android.view.inputmethod.InputMethodManager inputMethodManager = this.f10250b;
        if (inputMethodManager != null) {
            return inputMethodManager;
        }
        android.view.inputmethod.InputMethodManager inputMethodManagerF = f();
        this.f10250b = inputMethodManagerF;
        return inputMethodManagerF;
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        h().updateCursorAnchorInfo(this.f10249a, cursorAnchorInfo);
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void c() {
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void d() {
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void e() {
    }
}
