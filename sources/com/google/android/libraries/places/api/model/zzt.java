package com.google.android.libraries.places.api.model;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzt extends ConsumerAlertDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f75400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Uri f75401d;

    zzt(String str, String str2, String str3, Uri uri) {
        this.f75398a = str;
        this.f75399b = str2;
        this.f75400c = str3;
        this.f75401d = uri;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails
    public String d() {
        return this.f75400c;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails
    public Uri e() {
        return this.f75401d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConsumerAlertDetails) {
            ConsumerAlertDetails consumerAlertDetails = (ConsumerAlertDetails) obj;
            String str = this.f75398a;
            if (str != null ? str.equals(consumerAlertDetails.g()) : consumerAlertDetails.g() == null) {
                String str2 = this.f75399b;
                if (str2 != null ? str2.equals(consumerAlertDetails.f()) : consumerAlertDetails.f() == null) {
                    String str3 = this.f75400c;
                    if (str3 != null ? str3.equals(consumerAlertDetails.d()) : consumerAlertDetails.d() == null) {
                        Uri uri = this.f75401d;
                        if (uri != null ? uri.equals(consumerAlertDetails.e()) : consumerAlertDetails.e() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails
    public String f() {
        return this.f75399b;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails
    public String g() {
        return this.f75398a;
    }

    public final int hashCode() {
        String str = this.f75398a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75399b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        int i3 = iHashCode ^ 1000003;
        String str3 = this.f75400c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Uri uri = this.f75401d;
        return iHashCode3 ^ (uri != null ? uri.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f75401d);
        String str = this.f75398a;
        int length = String.valueOf(str).length();
        String str2 = this.f75399b;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f75400c;
        StringBuilder sb = new StringBuilder(length + 41 + length2 + 17 + String.valueOf(str3).length() + 15 + strValueOf.length() + 1);
        sb.append("ConsumerAlertDetails{title=");
        sb.append(str);
        sb.append(", description=");
        sb.append(str2);
        sb.append(", aboutLinkTitle=");
        sb.append(str3);
        sb.append(", aboutLinkUri=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
