package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zznb;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzah extends ListAdapter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzai f79035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f79036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f79037m;

    public zzah(zzai zzaiVar) {
        super(new zzag(null));
        this.f79037m = true;
        this.f79035k = zzaiVar;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public final void i(List list) throws Throwable {
        try {
            int size = 0;
            this.f79037m = (this.f79036l != 0 || list == null || list.isEmpty()) ? false : true;
            if (list != null) {
                size = list.size();
            }
            this.f79036l = size;
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
    public final zzak onCreateViewHolder(ViewGroup viewGroup, int i3) {
        try {
            return new zzak(this.f79035k, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.A, viewGroup, false));
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(zzak zzakVar, int i3) {
        try {
            zzakVar.b((AutocompletePrediction) g(i3), this.f79037m);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }
}
