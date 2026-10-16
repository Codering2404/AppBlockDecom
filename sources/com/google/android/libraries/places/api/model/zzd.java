package com.google.android.libraries.places.api.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzd extends AddressComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f75337c;

    zzd(String str, String str2, List list) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f75335a = str;
        this.f75336b = str2;
        if (list == null) {
            throw new NullPointerException("Null types");
        }
        this.f75337c = list;
    }

    @Override // com.google.android.libraries.places.api.model.AddressComponent
    public final String c() {
        return this.f75336b;
    }

    @Override // com.google.android.libraries.places.api.model.AddressComponent
    public final List d() {
        return this.f75337c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddressComponent) {
            AddressComponent addressComponent = (AddressComponent) obj;
            if (this.f75335a.equals(addressComponent.getName()) && ((str = this.f75336b) != null ? str.equals(addressComponent.c()) : addressComponent.c() == null) && this.f75337c.equals(addressComponent.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.AddressComponent
    public final String getName() {
        return this.f75335a;
    }

    public final int hashCode() {
        int iHashCode = this.f75335a.hashCode() ^ 1000003;
        String str = this.f75336b;
        return (((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f75337c.hashCode();
    }

    public final String toString() {
        String string = this.f75337c.toString();
        String str = this.f75336b;
        int length = String.valueOf(str).length();
        int length2 = string.length();
        String str2 = this.f75335a;
        StringBuilder sb = new StringBuilder(str2.length() + 34 + length + 8 + length2 + 1);
        sb.append("AddressComponent{name=");
        sb.append(str2);
        sb.append(", shortName=");
        sb.append(str);
        sb.append(", types=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
