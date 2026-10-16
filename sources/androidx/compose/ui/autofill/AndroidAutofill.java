package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillId;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidAutofill implements Autofill {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f25191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AutofillTree f25192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final android.view.autofill.AutofillManager f25193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AutofillId f25194d;

    public final android.view.autofill.AutofillManager a() {
        return this.f25193c;
    }

    public final AutofillTree b() {
        return this.f25192b;
    }

    public final AutofillId c() {
        return this.f25194d;
    }

    public final View d() {
        return this.f25191a;
    }

    public AndroidAutofill(View view, AutofillTree autofillTree) {
        AutofillId autofillIdA;
        this.f25191a = view;
        this.f25192b = autofillTree;
        android.view.autofill.AutofillManager autofillManager = (android.view.autofill.AutofillManager) view.getContext().getSystemService(android.view.autofill.AutofillManager.class);
        if (autofillManager != null) {
            this.f25193c = autofillManager;
            view.setImportantForAutofill(1);
            AutofillIdCompat autofillIdCompatA = ViewCompatShims.a(view);
            if (autofillIdCompatA != null) {
                autofillIdA = autofillIdCompatA.a();
            } else {
                autofillIdA = null;
            }
            if (autofillIdA != null) {
                this.f25194d = autofillIdA;
                return;
            } else {
                InlineClassHelperKt.d(vgWWUoTKYyuC.ZWAh);
                throw new KotlinNothingValueException();
            }
        }
        throw new IllegalStateException("Autofill service could not be located.");
    }
}
