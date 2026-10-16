package com.google.android.libraries.places.internal;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zztl extends zztm {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f78595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f78596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f78597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f78598f;

    @Override // com.google.android.libraries.places.internal.zztm
    public final String a() {
        return this.f78594b.replace('/', '.');
    }

    @Override // com.google.android.libraries.places.internal.zztm
    public final String b() {
        return this.f78595c;
    }

    @Override // com.google.android.libraries.places.internal.zztm
    public final int c() {
        return (char) this.f78596d;
    }

    @Override // com.google.android.libraries.places.internal.zztm
    public final String d() {
        String str = this.f78597e;
        return str.substring(str.lastIndexOf(File.separatorChar) + 1);
    }

    @Override // com.google.android.libraries.places.internal.zztm
    public final String e() {
        return this.f78597e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zztl) {
            zztl zztlVar = (zztl) obj;
            if (this.f78595c.equals(zztlVar.f78595c) && this.f78596d == zztlVar.f78596d) {
                String str = this.f78594b;
                String str2 = zztlVar.f78594b;
                if (str != str2) {
                    if (str.length() == str2.length()) {
                        for (int i3 = 0; i3 < str.length(); i3++) {
                            char cCharAt = str.charAt(i3);
                            char cCharAt2 = str2.charAt(i3);
                            if (cCharAt == cCharAt2 || ((cCharAt & (-2)) == 46 && (cCharAt ^ cCharAt2) == 1)) {
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.f78598f;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = ((this.f78595c.hashCode() + 4867) * 31) + this.f78596d;
        this.f78598f = iHashCode;
        return iHashCode;
    }
}
