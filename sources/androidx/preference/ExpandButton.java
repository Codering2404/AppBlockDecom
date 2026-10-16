package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExpandButton extends Preference {
    private long Q;

    ExpandButton(Context context, List list, long j3) {
        super(context);
        E0();
        F0(list);
        this.Q = j3 + 1000000;
    }

    private void E0() {
        o0(R.layout.f50983a);
        m0(R.drawable.f50971a);
        u0(R.string.f50988b);
        r0(999);
    }

    private void F0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        CharSequence string = null;
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            CharSequence charSequenceZ = preference.z();
            boolean z2 = preference instanceof PreferenceGroup;
            if (z2 && !TextUtils.isEmpty(charSequenceZ)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.q())) {
                if (z2) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceZ)) {
                string = string == null ? charSequenceZ : h().getString(R.string.f50991e, string, charSequenceZ);
            }
        }
        s0(string);
    }

    @Override // androidx.preference.Preference
    public void Q(PreferenceViewHolder preferenceViewHolder) {
        super.Q(preferenceViewHolder);
        preferenceViewHolder.f(false);
    }

    @Override // androidx.preference.Preference
    long m() {
        return this.Q;
    }
}
