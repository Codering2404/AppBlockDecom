package androidx.compose.ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;

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
public final class AndroidAutofill_androidKt {
    public static final void a(AndroidAutofill androidAutofill, SparseArray sparseArray) {
        if (androidAutofill.b().a().isEmpty()) {
            return;
        }
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iKeyAt = sparseArray.keyAt(i3);
            AutofillValue autofillValue = (AutofillValue) sparseArray.get(iKeyAt);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.f25213a;
            if (autofillApi26Helper.e(autofillValue)) {
                androidAutofill.b().b(iKeyAt, autofillApi26Helper.B(autofillValue).toString());
            } else {
                if (autofillApi26Helper.c(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (autofillApi26Helper.d(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (autofillApi26Helper.f(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    public static final void b(AndroidAutofill androidAutofill, ViewStructure viewStructure) {
        if (androidAutofill.b().a().isEmpty()) {
            return;
        }
        int iA = AutofillApi26Helper.f25213a.a(viewStructure, androidAutofill.b().a().size());
        for (Map.Entry entry : androidAutofill.b().a().entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            AutofillNode autofillNode = (AutofillNode) entry.getValue();
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.f25213a;
            ViewStructure viewStructureG = autofillApi26Helper.g(viewStructure, iA);
            autofillApi26Helper.i(viewStructureG, androidAutofill.c(), iIntValue);
            autofillApi26Helper.v(viewStructureG, iIntValue, androidAutofill.d().getContext().getPackageName(), null, null);
            autofillApi26Helper.j(viewStructureG, ContentDataType_androidKt.b(ContentDataType.f25250a.a()));
            List listA = autofillNode.a();
            ArrayList arrayList = new ArrayList(listA.size());
            int size = listA.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(AndroidAutofillType_androidKt.a((AutofillType) listA.get(i3)));
            }
            autofillApi26Helper.h(viewStructureG, (String[]) arrayList.toArray(new String[0]));
            Rect rectB = autofillNode.b();
            if (rectB == null) {
                Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
            } else {
                int iRound = Math.round(rectB.o());
                int iRound2 = Math.round(rectB.r());
                int iRound3 = Math.round(rectB.p());
                AutofillApi26Helper.f25213a.r(viewStructureG, iRound, iRound2, 0, 0, iRound3 - iRound, Math.round(rectB.i()) - iRound2);
            }
            iA++;
        }
    }
}
