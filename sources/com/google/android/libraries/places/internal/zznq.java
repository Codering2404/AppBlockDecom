package com.google.android.libraries.places.internal;

import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zznq implements Parcelable {
    public static zznp u(AutocompleteActivityMode autocompleteActivityMode, List list, zzor zzorVar) {
        zznj zznjVar = new zznj();
        zznjVar.k(new ArrayList());
        zznjVar.f(new ArrayList());
        zznjVar.b(autocompleteActivityMode);
        zznjVar.c(list);
        zznjVar.d(zzorVar);
        zznjVar.g(0);
        zznjVar.h(0);
        zznjVar.i(false);
        zznjVar.a(zzow.PABLO);
        return zznjVar;
    }

    public abstract zzow c();

    public abstract AutocompleteActivityMode d();

    public abstract ImmutableList e();

    public abstract zzor f();

    public abstract LatLng g();

    public abstract String h();

    public abstract String i();

    public abstract LocationBias j();

    public abstract LocationRestriction k();

    public abstract ImmutableList l();

    public abstract ImmutableList m();

    public abstract int n();

    public abstract int o();

    public abstract String p();

    public abstract AutocompleteUiCustomization q();

    public abstract boolean r();

    public abstract AutocompleteSessionToken s();

    public abstract zznp t();
}
