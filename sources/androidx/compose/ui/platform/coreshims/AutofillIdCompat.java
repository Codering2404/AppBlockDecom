package androidx.compose.ui.platform.coreshims;

import android.view.autofill.AutofillId;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AutofillIdCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f28361a;

    private AutofillIdCompat(AutofillId autofillId) {
        this.f28361a = autofillId;
    }

    public static AutofillIdCompat b(AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    public AutofillId a() {
        return (AutofillId) this.f28361a;
    }
}
