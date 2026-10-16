package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zza();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f87711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f87712d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f87713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f87714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f87715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f87716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f87717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f87718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f87719l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f87720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f87721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f87722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f87723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f87724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f87725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f87726g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f87727h;

        private Builder() {
            this.f87725f = false;
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.f87709a = builder.f87720a;
        this.f87710b = builder.f87721b;
        this.f87711c = null;
        this.f87712d = builder.f87722c;
        this.f87713f = builder.f87723d;
        this.f87714g = builder.f87724e;
        this.f87715h = builder.f87725f;
        this.f87718k = builder.f87726g;
        this.f87719l = builder.f87727h;
    }

    public static ActionCodeSettings K2() {
        return new ActionCodeSettings(new Builder());
    }

    public final void J2(String str) {
        this.f87716i = str;
    }

    public boolean M() {
        return this.f87715h;
    }

    public boolean N() {
        return this.f87713f;
    }

    public String O() {
        return this.f87714g;
    }

    public String g0() {
        return this.f87712d;
    }

    public final void h1(int i3) {
        this.f87717j = i3;
    }

    public String j0() {
        return this.f87710b;
    }

    public String w0() {
        return this.f87719l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, z0(), false);
        SafeParcelWriter.G(parcel, 2, j0(), false);
        SafeParcelWriter.G(parcel, 3, this.f87711c, false);
        SafeParcelWriter.G(parcel, 4, g0(), false);
        SafeParcelWriter.g(parcel, 5, N());
        SafeParcelWriter.G(parcel, 6, O(), false);
        SafeParcelWriter.g(parcel, 7, M());
        SafeParcelWriter.G(parcel, 8, this.f87716i, false);
        SafeParcelWriter.u(parcel, 9, this.f87717j);
        SafeParcelWriter.G(parcel, 10, this.f87718k, false);
        SafeParcelWriter.G(parcel, 11, w0(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public String z0() {
        return this.f87709a;
    }

    public final int zza() {
        return this.f87717j;
    }

    public final String zzc() {
        return this.f87718k;
    }

    public final String zzd() {
        return this.f87711c;
    }

    public final String zze() {
        return this.f87716i;
    }

    ActionCodeSettings(String str, String str2, String str3, String str4, boolean z2, String str5, boolean z3, String str6, int i3, String str7, String str8) {
        this.f87709a = str;
        this.f87710b = str2;
        this.f87711c = str3;
        this.f87712d = str4;
        this.f87713f = z2;
        this.f87714g = str5;
        this.f87715h = z3;
        this.f87716i = str6;
        this.f87717j = i3;
        this.f87718k = str7;
        this.f87719l = str8;
    }
}
