package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznq;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzn extends ListAdapter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzp f79058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f79059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f79060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zznq f79061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f79062o;

    public zzn(zzp zzpVar, zznq zznqVar, int i3) {
        super(new zzm(null));
        this.f79060m = true;
        this.f79058k = zzpVar;
        this.f79061n = zznqVar;
        this.f79062o = i3;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public final void i(List list) throws Throwable {
        try {
            int size = 0;
            this.f79060m = (this.f79059l != 0 || list == null || list.isEmpty()) ? false : true;
            if (list != null) {
                size = list.size();
            }
            this.f79059l = size;
            super.i(list);
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final zzq onCreateViewHolder(ViewGroup viewGroup, int i3) {
        try {
            return new zzq(this.f79058k, LayoutInflater.from(viewGroup.getContext()).cloneInContext(new ContextThemeWrapper(viewGroup.getContext(), this.f79062o)).inflate(R.layout.f74794e, viewGroup, false), this.f79061n);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(zzq zzqVar, int i3) {
        try {
            zzqVar.b((AutocompletePrediction) g(i3), this.f79060m);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }
}
