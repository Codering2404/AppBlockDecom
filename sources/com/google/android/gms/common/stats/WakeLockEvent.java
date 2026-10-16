package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f72251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f72253d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f72254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f72255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f72256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f72257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f72258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f72259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f72260l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f72261m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f72262n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f72263o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f72264p;

    WakeLockEvent(int i3, long j3, int i4, String str, int i5, List list, String str2, long j4, int i6, String str3, String str4, float f3, long j5, String str5, boolean z2) {
        this.f72250a = i3;
        this.f72251b = j3;
        this.f72252c = i4;
        this.f72253d = str;
        this.f72254f = str3;
        this.f72255g = str5;
        this.f72256h = i5;
        this.f72257i = list;
        this.f72258j = str2;
        this.f72259k = j4;
        this.f72260l = i6;
        this.f72261m = str4;
        this.f72262n = f3;
        this.f72263o = j5;
        this.f72264p = z2;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int M() {
        return this.f72252c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f72250a);
        SafeParcelWriter.z(parcel, 2, this.f72251b);
        SafeParcelWriter.G(parcel, 4, this.f72253d, false);
        SafeParcelWriter.u(parcel, 5, this.f72256h);
        SafeParcelWriter.I(parcel, 6, this.f72257i, false);
        SafeParcelWriter.z(parcel, 8, this.f72259k);
        SafeParcelWriter.G(parcel, 10, this.f72254f, false);
        SafeParcelWriter.u(parcel, 11, this.f72252c);
        SafeParcelWriter.G(parcel, 12, this.f72258j, false);
        SafeParcelWriter.G(parcel, 13, this.f72261m, false);
        SafeParcelWriter.u(parcel, 14, this.f72260l);
        SafeParcelWriter.q(parcel, 15, this.f72262n);
        SafeParcelWriter.z(parcel, 16, this.f72263o);
        SafeParcelWriter.G(parcel, 17, this.f72255g, false);
        SafeParcelWriter.g(parcel, 18, this.f72264p);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zza() {
        return this.f72251b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzc() {
        List list = this.f72257i;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i3 = this.f72260l;
        String str = this.f72254f;
        String str2 = this.f72261m;
        float f3 = this.f72262n;
        String str3 = this.f72255g;
        int i4 = this.f72256h;
        String str4 = this.f72253d;
        boolean z2 = this.f72264p;
        int length = String.valueOf(str4).length() + 2 + String.valueOf(i4).length() + 1 + String.valueOf(strJoin).length() + 1 + String.valueOf(i3).length();
        if (str == null) {
            str = "";
        }
        int length2 = length + 1 + str.length() + 1;
        if (str2 == null) {
            str2 = "";
        }
        int length3 = length2 + str2.length() + 1 + String.valueOf(f3).length() + 1;
        String str5 = str3 != null ? str3 : "";
        StringBuilder sb = new StringBuilder(length3 + str5.length() + 1 + String.valueOf(z2).length());
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(i4);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(f3);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z2);
        return sb.toString();
    }
}
