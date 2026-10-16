package com.google.android.libraries.places.api.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzv extends ContentBlock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f75408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f75409d;

    zzv(String str, String str2, List list, List list2) {
        this.f75406a = str;
        this.f75407b = str2;
        this.f75408c = list;
        this.f75409d = list2;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock
    public final String d() {
        return this.f75406a;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock
    public final String e() {
        return this.f75407b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ContentBlock) {
            ContentBlock contentBlock = (ContentBlock) obj;
            String str = this.f75406a;
            if (str != null ? str.equals(contentBlock.d()) : contentBlock.d() == null) {
                String str2 = this.f75407b;
                if (str2 != null ? str2.equals(contentBlock.e()) : contentBlock.e() == null) {
                    List list = this.f75408c;
                    if (list != null ? list.equals(contentBlock.g()) : contentBlock.g() == null) {
                        List list2 = this.f75409d;
                        if (list2 != null ? list2.equals(contentBlock.f()) : contentBlock.f() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock
    public final List f() {
        return this.f75409d;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock
    public final List g() {
        return this.f75408c;
    }

    public final int hashCode() {
        String str = this.f75406a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75407b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        int i3 = iHashCode ^ 1000003;
        List list = this.f75408c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f75409d;
        return iHashCode3 ^ (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        List list = this.f75409d;
        String strValueOf = String.valueOf(this.f75408c);
        String strValueOf2 = String.valueOf(list);
        String str = this.f75406a;
        int length = String.valueOf(str).length();
        String str2 = this.f75407b;
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 43 + length2 + 31 + strValueOf.length() + 21 + strValueOf2.length() + 1);
        sb.append("ContentBlock{content=");
        sb.append(str);
        sb.append(", contentLanguageCode=");
        sb.append(str2);
        sb.append(", referencedPlaceResourceNames=");
        sb.append(strValueOf);
        sb.append(", referencedPlaceIds=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
