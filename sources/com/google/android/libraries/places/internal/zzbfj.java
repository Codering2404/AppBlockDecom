package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfj implements zzbeu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbex f76150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f76152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f76153d;

    zzbfj(zzbex zzbexVar, String str, Object[] objArr) {
        this.f76150a = zzbexVar;
        this.f76151b = str;
        this.f76152c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f76153d = cCharAt;
            return;
        }
        int i3 = cCharAt & 8191;
        int i4 = 1;
        int i5 = 13;
        while (true) {
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f76153d = i3 | (cCharAt2 << i5);
                return;
            } else {
                i3 |= (cCharAt2 & 8191) << i5;
                i5 += 13;
                i4 = i6;
            }
        }
    }

    final String a() {
        return this.f76151b;
    }

    final Object[] b() {
        return this.f76152c;
    }

    @Override // com.google.android.libraries.places.internal.zzbeu
    public final boolean zza() {
        return (this.f76153d & 2) == 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbeu
    public final zzbex zzb() {
        return this.f76150a;
    }

    @Override // com.google.android.libraries.places.internal.zzbeu
    public final int zzc() {
        int i3 = this.f76153d;
        if ((i3 & 1) != 0) {
            return 1;
        }
        return (i3 & 4) == 4 ? 3 : 2;
    }
}
