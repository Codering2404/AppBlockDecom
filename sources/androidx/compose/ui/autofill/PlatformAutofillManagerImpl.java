package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.view.View;
import android.view.autofill.AutofillValue;
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
public final class PlatformAutofillManagerImpl implements PlatformAutofillManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.view.autofill.AutofillManager f25284a;

    public PlatformAutofillManagerImpl(android.view.autofill.AutofillManager autofillManager) {
        this.f25284a = autofillManager;
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void a(View view, int i3, AutofillValue autofillValue) {
        this.f25284a.notifyValueChanged(view, i3, autofillValue);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void b(View view, int i3) {
        this.f25284a.notifyViewExited(view, i3);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void c(View view, int i3, Rect rect) {
        this.f25284a.requestAutofill(view, i3, rect);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void commit() {
        this.f25284a.commit();
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void d(View view, int i3, boolean z2) {
        AutofillApi27Helper.f25214a.a(view, this.f25284a, i3, z2);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void e(View view, int i3, Rect rect) {
        this.f25284a.notifyViewEntered(view, i3, rect);
    }
}
