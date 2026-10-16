package com.google.android.libraries.places.api.model;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzj extends AutocompletePrediction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f75360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f75361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75362d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f75363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f75364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f75365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f75366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f75367j;

    zzj(String str, Integer num, List list, String str2, String str3, String str4, List list2, List list3, List list4) {
        if (str == null) {
            throw new NullPointerException("Null placeId");
        }
        this.f75359a = str;
        this.f75360b = num;
        if (list == null) {
            throw new NullPointerException("Null types");
        }
        this.f75361c = list;
        if (str2 == null) {
            throw new NullPointerException("Null fullText");
        }
        this.f75362d = str2;
        if (str3 == null) {
            throw new NullPointerException("Null primaryText");
        }
        this.f75363f = str3;
        if (str4 == null) {
            throw new NullPointerException("Null secondaryText");
        }
        this.f75364g = str4;
        if (list2 == null) {
            throw new NullPointerException("Null fullTextMatchedSubstrings");
        }
        this.f75365h = list2;
        if (list3 == null) {
            throw new NullPointerException("Null primaryTextMatchedSubstrings");
        }
        this.f75366i = list3;
        if (list4 == null) {
            throw new NullPointerException("Null secondaryTextMatchedSubstrings");
        }
        this.f75367j = list4;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    public Integer c() {
        return this.f75360b;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    public String d() {
        return this.f75359a;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompletePrediction) {
            AutocompletePrediction autocompletePrediction = (AutocompletePrediction) obj;
            if (this.f75359a.equals(autocompletePrediction.d()) && ((num = this.f75360b) != null ? num.equals(autocompletePrediction.c()) : autocompletePrediction.c() == null) && this.f75361c.equals(autocompletePrediction.g()) && this.f75362d.equals(autocompletePrediction.h()) && this.f75363f.equals(autocompletePrediction.i()) && this.f75364g.equals(autocompletePrediction.j()) && this.f75365h.equals(autocompletePrediction.k()) && this.f75366i.equals(autocompletePrediction.l()) && this.f75367j.equals(autocompletePrediction.m())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    public List g() {
        return this.f75361c;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    final String h() {
        return this.f75362d;
    }

    public final int hashCode() {
        int iHashCode = this.f75359a.hashCode() ^ 1000003;
        Integer num = this.f75360b;
        return (((((((((((((((iHashCode * 1000003) ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f75361c.hashCode()) * 1000003) ^ this.f75362d.hashCode()) * 1000003) ^ this.f75363f.hashCode()) * 1000003) ^ this.f75364g.hashCode()) * 1000003) ^ this.f75365h.hashCode()) * 1000003) ^ this.f75366i.hashCode()) * 1000003) ^ this.f75367j.hashCode();
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    final String i() {
        return this.f75363f;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    final String j() {
        return this.f75364g;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    final List k() {
        return this.f75365h;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    final List l() {
        return this.f75366i;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction
    final List m() {
        return this.f75367j;
    }

    public final String toString() {
        List list = this.f75367j;
        List list2 = this.f75366i;
        List list3 = this.f75365h;
        String string = this.f75361c.toString();
        String string2 = list3.toString();
        String string3 = list2.toString();
        String string4 = list.toString();
        Integer num = this.f75360b;
        int length = String.valueOf(num).length();
        int length2 = string.length();
        int length3 = string2.length();
        int length4 = string3.length();
        int length5 = string4.length();
        String str = this.f75359a;
        int length6 = str.length() + 48 + length + 8 + length2;
        String str2 = this.f75362d;
        int length7 = length6 + 11 + str2.length();
        String str3 = this.f75363f;
        int length8 = length7 + 14 + str3.length();
        String str4 = this.f75364g;
        StringBuilder sb = new StringBuilder(length8 + 16 + str4.length() + 28 + length3 + 31 + length4 + 33 + length5 + 1);
        sb.append("AutocompletePrediction{placeId=");
        sb.append(str);
        sb.append(", distanceMeters=");
        sb.append(num);
        sb.append(", types=");
        sb.append(string);
        sb.append(", fullText=");
        sb.append(str2);
        sb.append(", primaryText=");
        sb.append(str3);
        sb.append(", secondaryText=");
        sb.append(str4);
        sb.append(", fullTextMatchedSubstrings=");
        sb.append(string2);
        sb.append(", primaryTextMatchedSubstrings=");
        sb.append(string3);
        sb.append(rnFwbPAQmQTnL.flAJzFFW);
        sb.append(string4);
        sb.append("}");
        return sb.toString();
    }
}
