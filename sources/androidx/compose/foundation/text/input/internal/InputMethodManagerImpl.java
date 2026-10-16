package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class InputMethodManagerImpl implements InputMethodManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f10356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f10357b = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<android.view.inputmethod.InputMethodManager>() { // from class: androidx.compose.foundation.text.input.internal.InputMethodManagerImpl$imm$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final android.view.inputmethod.InputMethodManager invoke() {
            Object systemService = this.f10359a.f10356a.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            return (android.view.inputmethod.InputMethodManager) systemService;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SoftwareKeyboardControllerCompat f10358c;

    public InputMethodManagerImpl(View view) {
        this.f10356a = view;
        this.f10358c = new SoftwareKeyboardControllerCompat(view);
    }

    private final android.view.inputmethod.InputMethodManager e() {
        return (android.view.inputmethod.InputMethodManager) this.f10357b.getValue();
    }

    @Override // androidx.compose.foundation.text.input.internal.InputMethodManager
    public void a(int i3, int i4, int i5, int i6) {
        e().updateSelection(this.f10356a, i3, i4, i5, i6);
    }

    @Override // androidx.compose.foundation.text.input.internal.InputMethodManager
    public void b() {
        e().restartInput(this.f10356a);
    }

    @Override // androidx.compose.foundation.text.input.internal.InputMethodManager
    public void c() {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34StartStylusHandwriting.f10240a.a(e(), this.f10356a);
        }
    }

    @Override // androidx.compose.foundation.text.input.internal.InputMethodManager
    public boolean isActive() {
        return e().isActive(this.f10356a);
    }

    @Override // androidx.compose.foundation.text.input.internal.InputMethodManager
    public void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        e().updateCursorAnchorInfo(this.f10356a, cursorAnchorInfo);
    }

    @Override // androidx.compose.foundation.text.input.internal.InputMethodManager
    public void updateExtractedText(int i3, ExtractedText extractedText) {
        e().updateExtractedText(this.f10356a, i3, extractedText);
    }
}
