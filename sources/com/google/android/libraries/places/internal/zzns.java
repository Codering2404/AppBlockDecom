package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzns {
    public static zzns h() {
        return t(1).g();
    }

    public static zzns i() {
        return t(2).g();
    }

    public static zzns j() {
        return t(3).g();
    }

    public static zzns k() {
        return t(4).g();
    }

    public static zzns l(List list) {
        Preconditions.t(list);
        zznr zznrVarT = t(5);
        zznrVarT.b(list);
        return zznrVarT.g();
    }

    public static zzns m(String str) {
        Preconditions.t(str);
        zznr zznrVarT = t(6);
        zznrVarT.a(str);
        return zznrVarT.g();
    }

    public static zzns n(String str, Status status) {
        Preconditions.t(str);
        Preconditions.t(status);
        zznr zznrVarT = t(7);
        zznrVarT.a(str);
        zznrVarT.f(status);
        return zznrVarT.g();
    }

    public static zzns o(Place place) {
        Preconditions.t(place);
        zznr zznrVarT = t(8);
        zznrVarT.c(place);
        return zznrVarT.g();
    }

    public static zzns p(AutocompletePrediction autocompletePrediction, AutocompleteSessionToken autocompleteSessionToken) {
        Preconditions.t(autocompletePrediction);
        Preconditions.t(autocompleteSessionToken);
        zznr zznrVarT = t(8);
        zznrVarT.d(autocompletePrediction);
        zznrVarT.e(autocompleteSessionToken);
        return zznrVarT.g();
    }

    public static zzns q(AutocompletePrediction autocompletePrediction, Status status) {
        Preconditions.t(autocompletePrediction);
        Preconditions.t(status);
        zznr zznrVarT = t(9);
        zznrVarT.d(autocompletePrediction);
        zznrVarT.f(status);
        return zznrVarT.g();
    }

    public static zzns r() {
        zznr zznrVarT = t(10);
        zznrVarT.f(new Status(16));
        return zznrVarT.g();
    }

    public static zzns s(Status status) {
        Preconditions.t(status);
        zznr zznrVarT = t(10);
        zznrVarT.f(status);
        return zznrVarT.g();
    }

    private static zznr t(int i3) {
        zznn zznnVar = new zznn();
        zznnVar.h(i3);
        return zznnVar;
    }

    public abstract String a();

    public abstract ImmutableList b();

    public abstract Place c();

    public abstract AutocompletePrediction d();

    public abstract AutocompleteSessionToken e();

    public abstract Status f();

    public abstract int g();
}
