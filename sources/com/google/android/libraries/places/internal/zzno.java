package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzno extends zzns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f78293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Place f78294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AutocompletePrediction f78295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AutocompleteSessionToken f78296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Status f78297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f78298g;

    /* synthetic */ zzno(int i3, String str, ImmutableList immutableList, Place place, AutocompletePrediction autocompletePrediction, AutocompleteSessionToken autocompleteSessionToken, Status status, byte[] bArr) {
        this.f78298g = i3;
        this.f78292a = str;
        this.f78293b = immutableList;
        this.f78294c = place;
        this.f78295d = autocompletePrediction;
        this.f78296e = autocompleteSessionToken;
        this.f78297f = status;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final String a() {
        return this.f78292a;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final ImmutableList b() {
        return this.f78293b;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final Place c() {
        return this.f78294c;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final AutocompletePrediction d() {
        return this.f78295d;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final AutocompleteSessionToken e() {
        return this.f78296e;
    }

    public final boolean equals(Object obj) {
        String str;
        ImmutableList immutableList;
        Place place;
        AutocompletePrediction autocompletePrediction;
        AutocompleteSessionToken autocompleteSessionToken;
        Status status;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzns) {
            zzns zznsVar = (zzns) obj;
            if (this.f78298g == zznsVar.g() && ((str = this.f78292a) != null ? str.equals(zznsVar.a()) : zznsVar.a() == null) && ((immutableList = this.f78293b) != null ? immutableList.equals(zznsVar.b()) : zznsVar.b() == null) && ((place = this.f78294c) != null ? place.equals(zznsVar.c()) : zznsVar.c() == null) && ((autocompletePrediction = this.f78295d) != null ? autocompletePrediction.equals(zznsVar.d()) : zznsVar.d() == null) && ((autocompleteSessionToken = this.f78296e) != null ? autocompleteSessionToken.equals(zznsVar.e()) : zznsVar.e() == null) && ((status = this.f78297f) != null ? status.equals(zznsVar.f()) : zznsVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final Status f() {
        return this.f78297f;
    }

    @Override // com.google.android.libraries.places.internal.zzns
    public final int g() {
        return this.f78298g;
    }

    public final int hashCode() {
        String str = this.f78292a;
        int iHashCode = str == null ? 0 : str.hashCode();
        int i3 = this.f78298g;
        ImmutableList immutableList = this.f78293b;
        int iHashCode2 = immutableList == null ? 0 : immutableList.hashCode();
        int i4 = iHashCode ^ ((i3 ^ 1000003) * 1000003);
        Place place = this.f78294c;
        int iHashCode3 = ((((i4 * 1000003) ^ iHashCode2) * 1000003) ^ (place == null ? 0 : place.hashCode())) * 1000003;
        AutocompletePrediction autocompletePrediction = this.f78295d;
        int iHashCode4 = (iHashCode3 ^ (autocompletePrediction == null ? 0 : autocompletePrediction.hashCode())) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.f78296e;
        int iHashCode5 = (iHashCode4 ^ (autocompleteSessionToken == null ? 0 : autocompleteSessionToken.hashCode())) * 1000003;
        Status status = this.f78297f;
        return iHashCode5 ^ (status != null ? status.hashCode() : 0);
    }

    public final String toString() {
        String str;
        switch (this.f78298g) {
            case 1:
                str = "START";
                break;
            case 2:
                str = "RESET";
                break;
            case 3:
                str = "LOADING";
                break;
            case 4:
                str = "TRY_AGAIN_PROGRESS_LOADING";
                break;
            case 5:
                str = "SUCCESS_PREDICTIONS";
                break;
            case 6:
                str = "FAILURE_NO_PREDICTIONS";
                break;
            case 7:
                str = "FAILURE_PREDICTIONS";
                break;
            case 8:
                str = "SUCCESS_SELECTION";
                break;
            case 9:
                str = "FAILURE_SELECTION";
                break;
            default:
                str = "FAILURE_UNRESOLVABLE";
                break;
        }
        String str2 = this.f78292a;
        ImmutableList immutableList = this.f78293b;
        Place place = this.f78294c;
        AutocompletePrediction autocompletePrediction = this.f78295d;
        AutocompleteSessionToken autocompleteSessionToken = this.f78296e;
        Status status = this.f78297f;
        int length = str.length();
        String strValueOf = String.valueOf(immutableList);
        String strValueOf2 = String.valueOf(place);
        String strValueOf3 = String.valueOf(autocompletePrediction);
        String strValueOf4 = String.valueOf(autocompleteSessionToken);
        String strValueOf5 = String.valueOf(status);
        StringBuilder sb = new StringBuilder(length + 31 + String.valueOf(str2).length() + 14 + strValueOf.length() + 8 + strValueOf2.length() + 13 + strValueOf3.length() + 15 + strValueOf4.length() + 9 + strValueOf5.length() + 1);
        sb.append("AutocompleteState{type=");
        sb.append(str);
        sb.append(", query=");
        sb.append(str2);
        sb.append(", predictions=");
        sb.append(strValueOf);
        sb.append(", place=");
        sb.append(strValueOf2);
        sb.append(", prediction=");
        sb.append(strValueOf3);
        sb.append(", sessionToken=");
        sb.append(strValueOf4);
        sb.append(", status=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }
}
