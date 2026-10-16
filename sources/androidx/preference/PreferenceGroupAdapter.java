package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PreferenceGroup f50909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f50910j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f50911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f50912l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Runnable f50914n = new Runnable() { // from class: androidx.preference.PreferenceGroupAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            PreferenceGroupAdapter.this.n();
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Handler f50913m = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PreferenceResourceDescriptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f50923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f50924c;

        PreferenceResourceDescriptor(Preference preference) {
            this.f50924c = preference.getClass().getName();
            this.f50922a = preference.p();
            this.f50923b = preference.A();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            return this.f50922a == preferenceResourceDescriptor.f50922a && this.f50923b == preferenceResourceDescriptor.f50923b && TextUtils.equals(this.f50924c, preferenceResourceDescriptor.f50924c);
        }

        public int hashCode() {
            return ((((527 + this.f50922a) * 31) + this.f50923b) * 31) + this.f50924c.hashCode();
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.f50909i = preferenceGroup;
        preferenceGroup.p0(this);
        this.f50910j = new ArrayList();
        this.f50911k = new ArrayList();
        this.f50912l = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).O0());
        } else {
            setHasStableIds(true);
        }
        n();
    }

    private ExpandButton g(final PreferenceGroup preferenceGroup, List list) {
        ExpandButton expandButton = new ExpandButton(preferenceGroup.h(), list, preferenceGroup.m());
        expandButton.q0(new Preference.OnPreferenceClickListener() { // from class: androidx.preference.PreferenceGroupAdapter.3
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public boolean a(Preference preference) {
                preferenceGroup.M0(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                PreferenceGroupAdapter.this.d(preference);
                PreferenceGroup.OnExpandButtonClickListener onExpandButtonClickListenerG0 = preferenceGroup.G0();
                if (onExpandButtonClickListenerG0 == null) {
                    return true;
                }
                onExpandButtonClickListenerG0.a();
                return true;
            }
        });
        return expandButton;
    }

    private List h(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iI0 = preferenceGroup.I0();
        int i3 = 0;
        for (int i4 = 0; i4 < iI0; i4++) {
            Preference preferenceH0 = preferenceGroup.H0(i4);
            if (preferenceH0.G()) {
                if (!k(preferenceGroup) || i3 < preferenceGroup.F0()) {
                    arrayList.add(preferenceH0);
                } else {
                    arrayList2.add(preferenceH0);
                }
                if (preferenceH0 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceH0;
                    if (!preferenceGroup2.J0()) {
                        continue;
                    } else {
                        if (k(preferenceGroup) && k(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : h(preferenceGroup2)) {
                            if (!k(preferenceGroup) || i3 < preferenceGroup.F0()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i3++;
                        }
                    }
                } else {
                    i3++;
                }
            }
        }
        if (k(preferenceGroup) && i3 > preferenceGroup.F0()) {
            arrayList.add(g(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void i(List list, PreferenceGroup preferenceGroup) {
        preferenceGroup.N0();
        int iI0 = preferenceGroup.I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            Preference preferenceH0 = preferenceGroup.H0(i3);
            list.add(preferenceH0);
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(preferenceH0);
            if (!this.f50912l.contains(preferenceResourceDescriptor)) {
                this.f50912l.add(preferenceResourceDescriptor);
            }
            if (preferenceH0 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceH0;
                if (preferenceGroup2.J0()) {
                    i(list, preferenceGroup2);
                }
            }
            preferenceH0.p0(this);
        }
    }

    private boolean k(PreferenceGroup preferenceGroup) {
        return preferenceGroup.F0() != Integer.MAX_VALUE;
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int b(Preference preference) {
        int size = this.f50911k.size();
        for (int i3 = 0; i3 < size; i3++) {
            Preference preference2 = (Preference) this.f50911k.get(i3);
            if (preference2 != null && preference2.equals(preference)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void c(Preference preference) {
        int iIndexOf = this.f50911k.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void d(Preference preference) {
        this.f50913m.removeCallbacks(this.f50914n);
        this.f50913m.post(this.f50914n);
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int f(String str) {
        int size = this.f50911k.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(str, ((Preference) this.f50911k.get(i3)).o())) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50911k.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (hasStableIds()) {
            return j(i3).m();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(j(i3));
        int iIndexOf = this.f50912l.indexOf(preferenceResourceDescriptor);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.f50912l.size();
        this.f50912l.add(preferenceResourceDescriptor);
        return size;
    }

    public Preference j(int i3) {
        if (i3 < 0 || i3 >= getItemCount()) {
            return null;
        }
        return (Preference) this.f50911k.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, int i3) {
        Preference preferenceJ = j(i3);
        preferenceViewHolder.e();
        preferenceJ.Q(preferenceViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) this.f50912l.get(i3);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.f50993a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.f50996b);
        if (drawable == null) {
            drawable = AppCompatResources.b(viewGroup.getContext(), android.R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(preferenceResourceDescriptor.f50922a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            ViewCompat.q0(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(android.R.id.widget_frame);
        if (viewGroup2 != null) {
            int i4 = preferenceResourceDescriptor.f50923b;
            if (i4 != 0) {
                layoutInflaterFrom.inflate(i4, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(viewInflate);
    }

    void n() {
        Iterator it = this.f50910j.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).p0(null);
        }
        ArrayList arrayList = new ArrayList(this.f50910j.size());
        this.f50910j = arrayList;
        i(arrayList, this.f50909i);
        final List list = this.f50911k;
        final List listH = h(this.f50909i);
        this.f50911k = listH;
        PreferenceManager preferenceManagerW = this.f50909i.w();
        if (preferenceManagerW == null || preferenceManagerW.h() == null) {
            notifyDataSetChanged();
        } else {
            final PreferenceManager.PreferenceComparisonCallback preferenceComparisonCallbackH = preferenceManagerW.h();
            DiffUtil.b(new DiffUtil.Callback() { // from class: androidx.preference.PreferenceGroupAdapter.2
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean a(int i3, int i4) {
                    return preferenceComparisonCallbackH.a((Preference) list.get(i3), (Preference) listH.get(i4));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean b(int i3, int i4) {
                    return preferenceComparisonCallbackH.b((Preference) list.get(i3), (Preference) listH.get(i4));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int d() {
                    return listH.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int e() {
                    return list.size();
                }
            }).d(this);
        }
        Iterator it2 = this.f50910j.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).c();
        }
    }
}
