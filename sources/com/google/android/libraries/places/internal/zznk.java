package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zznk extends zznq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzow f78268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AutocompleteActivityMode f78269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f78270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzor f78271d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LatLng f78272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f78273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f78274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LocationBias f78275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LocationRestriction f78276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ImmutableList f78277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ImmutableList f78278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f78279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f78280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f78281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AutocompleteUiCustomization f78282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f78283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AutocompleteSessionToken f78284r;

    zznk(zzow zzowVar, AutocompleteActivityMode autocompleteActivityMode, ImmutableList immutableList, zzor zzorVar, LatLng latLng, String str, String str2, LocationBias locationBias, LocationRestriction locationRestriction, ImmutableList immutableList2, ImmutableList immutableList3, int i3, int i4, String str3, AutocompleteUiCustomization autocompleteUiCustomization, boolean z2, AutocompleteSessionToken autocompleteSessionToken) {
        if (zzowVar == null) {
            throw new NullPointerException("Null widgetBackend");
        }
        this.f78268a = zzowVar;
        if (autocompleteActivityMode == null) {
            throw new NullPointerException("Null mode");
        }
        this.f78269b = autocompleteActivityMode;
        if (immutableList == null) {
            throw new NullPointerException("Null placeFields");
        }
        this.f78270c = immutableList;
        if (zzorVar == null) {
            throw new NullPointerException("Null activityOrigin");
        }
        this.f78271d = zzorVar;
        this.f78272f = latLng;
        this.f78273g = str;
        this.f78274h = str2;
        this.f78275i = locationBias;
        this.f78276j = locationRestriction;
        if (immutableList2 == null) {
            throw new NullPointerException("Null countries");
        }
        this.f78277k = immutableList2;
        if (immutableList3 == null) {
            throw new NullPointerException("Null typesFilter");
        }
        this.f78278l = immutableList3;
        this.f78279m = i3;
        this.f78280n = i4;
        this.f78281o = str3;
        this.f78282p = autocompleteUiCustomization;
        this.f78283q = z2;
        this.f78284r = autocompleteSessionToken;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final zzow c() {
        return this.f78268a;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final AutocompleteActivityMode d() {
        return this.f78269b;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final ImmutableList e() {
        return this.f78270c;
    }

    public final boolean equals(Object obj) {
        LatLng latLng;
        String str;
        String str2;
        LocationBias locationBias;
        LocationRestriction locationRestriction;
        String str3;
        AutocompleteUiCustomization autocompleteUiCustomization;
        AutocompleteSessionToken autocompleteSessionToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zznq) {
            zznq zznqVar = (zznq) obj;
            if (this.f78268a.equals(zznqVar.c()) && this.f78269b.equals(zznqVar.d()) && this.f78270c.equals(zznqVar.e()) && this.f78271d.equals(zznqVar.f()) && ((latLng = this.f78272f) != null ? latLng.equals(zznqVar.g()) : zznqVar.g() == null) && ((str = this.f78273g) != null ? str.equals(zznqVar.h()) : zznqVar.h() == null) && ((str2 = this.f78274h) != null ? str2.equals(zznqVar.i()) : zznqVar.i() == null) && ((locationBias = this.f78275i) != null ? locationBias.equals(zznqVar.j()) : zznqVar.j() == null) && ((locationRestriction = this.f78276j) != null ? locationRestriction.equals(zznqVar.k()) : zznqVar.k() == null) && this.f78277k.equals(zznqVar.l()) && this.f78278l.equals(zznqVar.m()) && this.f78279m == zznqVar.n() && this.f78280n == zznqVar.o() && ((str3 = this.f78281o) != null ? str3.equals(zznqVar.p()) : zznqVar.p() == null) && ((autocompleteUiCustomization = this.f78282p) != null ? autocompleteUiCustomization.equals(zznqVar.q()) : zznqVar.q() == null) && this.f78283q == zznqVar.r() && ((autocompleteSessionToken = this.f78284r) != null ? autocompleteSessionToken.equals(zznqVar.s()) : zznqVar.s() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final zzor f() {
        return this.f78271d;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final LatLng g() {
        return this.f78272f;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final String h() {
        return this.f78273g;
    }

    public final int hashCode() {
        int iHashCode = ((((((this.f78268a.hashCode() ^ 1000003) * 1000003) ^ this.f78269b.hashCode()) * 1000003) ^ this.f78270c.hashCode()) * 1000003) ^ this.f78271d.hashCode();
        LatLng latLng = this.f78272f;
        int iHashCode2 = ((iHashCode * 1000003) ^ (latLng == null ? 0 : latLng.hashCode())) * 1000003;
        String str = this.f78273g;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f78274h;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        LocationBias locationBias = this.f78275i;
        int iHashCode5 = (iHashCode4 ^ (locationBias == null ? 0 : locationBias.hashCode())) * 1000003;
        LocationRestriction locationRestriction = this.f78276j;
        int iHashCode6 = (((((((((iHashCode5 ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003) ^ this.f78277k.hashCode()) * 1000003) ^ this.f78278l.hashCode()) * 1000003) ^ this.f78279m) * 1000003) ^ this.f78280n) * 1000003;
        String str3 = this.f78281o;
        int iHashCode7 = (iHashCode6 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AutocompleteUiCustomization autocompleteUiCustomization = this.f78282p;
        int iHashCode8 = (((iHashCode7 ^ (autocompleteUiCustomization == null ? 0 : autocompleteUiCustomization.hashCode())) * 1000003) ^ (true != this.f78283q ? 1237 : 1231)) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.f78284r;
        return iHashCode8 ^ (autocompleteSessionToken != null ? autocompleteSessionToken.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final String i() {
        return this.f78274h;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final LocationBias j() {
        return this.f78275i;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final LocationRestriction k() {
        return this.f78276j;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final ImmutableList l() {
        return this.f78277k;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final ImmutableList m() {
        return this.f78278l;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final int n() {
        return this.f78279m;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final int o() {
        return this.f78280n;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final String p() {
        return this.f78281o;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final AutocompleteUiCustomization q() {
        return this.f78282p;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final boolean r() {
        return this.f78283q;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final AutocompleteSessionToken s() {
        return this.f78284r;
    }

    @Override // com.google.android.libraries.places.internal.zznq
    public final zznp t() {
        return new zznj(this);
    }

    public final String toString() {
        String string = this.f78268a.toString();
        int length = string.length();
        String string2 = this.f78269b.toString();
        int length2 = string2.length();
        String string3 = this.f78270c.toString();
        int length3 = string3.length();
        String string4 = this.f78271d.toString();
        int length4 = string4.length();
        AutocompleteSessionToken autocompleteSessionToken = this.f78284r;
        AutocompleteUiCustomization autocompleteUiCustomization = this.f78282p;
        ImmutableList immutableList = this.f78278l;
        ImmutableList immutableList2 = this.f78277k;
        LocationRestriction locationRestriction = this.f78276j;
        LocationBias locationBias = this.f78275i;
        String strValueOf = String.valueOf(this.f78272f);
        String strValueOf2 = String.valueOf(locationBias);
        String strValueOf3 = String.valueOf(locationRestriction);
        String string5 = immutableList2.toString();
        String string6 = immutableList.toString();
        String strValueOf4 = String.valueOf(autocompleteUiCustomization);
        String strValueOf5 = String.valueOf(autocompleteSessionToken);
        int length5 = strValueOf.length();
        String str = this.f78273g;
        int length6 = String.valueOf(str).length();
        String str2 = this.f78274h;
        int length7 = String.valueOf(str2).length();
        int length8 = strValueOf2.length();
        int length9 = strValueOf3.length();
        int length10 = string5.length();
        int length11 = string6.length();
        int i3 = this.f78279m;
        int length12 = String.valueOf(i3).length();
        int i4 = this.f78280n;
        int length13 = String.valueOf(i4).length();
        String str3 = this.f78281o;
        int length14 = String.valueOf(str3).length();
        int length15 = strValueOf4.length();
        boolean z2 = this.f78283q;
        StringBuilder sb = new StringBuilder(length + 41 + length2 + 14 + length3 + 17 + length4 + 9 + length5 + 15 + length6 + 7 + length7 + 15 + length8 + 22 + length9 + 12 + length10 + 14 + length11 + 15 + length12 + 19 + length13 + 13 + length14 + 30 + length15 + 36 + String.valueOf(z2).length() + 27 + strValueOf5.length() + 1);
        sb.append("AutocompleteOptions{widgetBackend=");
        sb.append(string);
        sb.append(", mode=");
        sb.append(string2);
        sb.append(", placeFields=");
        sb.append(string3);
        sb.append(", activityOrigin=");
        sb.append(string4);
        sb.append(", origin=");
        sb.append(strValueOf);
        sb.append(", initialQuery=");
        sb.append(str);
        sb.append(", hint=");
        sb.append(str2);
        sb.append(", locationBias=");
        sb.append(strValueOf2);
        sb.append(", locationRestriction=");
        sb.append(strValueOf3);
        sb.append(", countries=");
        sb.append(string5);
        sb.append(", typesFilter=");
        sb.append(string6);
        sb.append(", primaryColor=");
        sb.append(i3);
        sb.append(", primaryColorDark=");
        sb.append(i4);
        sb.append(", regionCode=");
        sb.append(str3);
        sb.append(", autocompleteUiCustomization=");
        sb.append(strValueOf4);
        sb.append(", pureServiceAreaBusinessesIncluded=");
        sb.append(z2);
        sb.append(", autocompleteSessionToken=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }
}
