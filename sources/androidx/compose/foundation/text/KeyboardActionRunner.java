package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class KeyboardActionRunner implements KeyboardActionScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SoftwareKeyboardController f9753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KeyboardActions f9754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FocusManager f9755c;

    public KeyboardActionRunner(SoftwareKeyboardController softwareKeyboardController) {
        this.f9753a = softwareKeyboardController;
    }

    public void a(int i3) {
        ImeAction.Companion companion = ImeAction.f29348b;
        if (ImeAction.m(i3, companion.d())) {
            b().e(FocusDirection.f25444b.e());
            return;
        }
        if (ImeAction.m(i3, companion.f())) {
            b().e(FocusDirection.f25444b.f());
            return;
        }
        if (!ImeAction.m(i3, companion.b())) {
            if (ImeAction.m(i3, companion.c()) ? true : ImeAction.m(i3, companion.g()) ? true : ImeAction.m(i3, companion.h()) ? true : ImeAction.m(i3, companion.a())) {
                return;
            }
            ImeAction.m(i3, companion.e());
        } else {
            SoftwareKeyboardController softwareKeyboardController = this.f9753a;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.a();
            }
        }
    }

    public final FocusManager b() {
        FocusManager focusManager = this.f9755c;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final KeyboardActions c() {
        KeyboardActions keyboardActions = this.f9754b;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void d(int i3) {
        Function1 function1G;
        ImeAction.Companion companion = ImeAction.f29348b;
        Unit unit = null;
        if (ImeAction.m(i3, companion.b())) {
            function1G = c().b();
        } else if (ImeAction.m(i3, companion.c())) {
            function1G = c().c();
        } else if (ImeAction.m(i3, companion.d())) {
            function1G = c().d();
        } else if (ImeAction.m(i3, companion.f())) {
            function1G = c().e();
        } else if (ImeAction.m(i3, companion.g())) {
            function1G = c().f();
        } else if (ImeAction.m(i3, companion.h())) {
            function1G = c().g();
        } else {
            if (!(ImeAction.m(i3, companion.a()) ? true : ImeAction.m(i3, companion.e()))) {
                throw new IllegalStateException("invalid ImeAction");
            }
            function1G = null;
        }
        if (function1G != null) {
            function1G.invoke(this);
            unit = Unit.f139807a;
        }
        if (unit == null) {
            a(i3);
        }
    }

    public final void e(FocusManager focusManager) {
        this.f9755c = focusManager;
    }

    public final void f(KeyboardActions keyboardActions) {
        this.f9754b = keyboardActions;
    }
}
