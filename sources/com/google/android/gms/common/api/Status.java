package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f71544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PendingIntent f71546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConnectionResult f71547d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f71536f = new Status(-1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f71537g = new Status(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f71538h = new Status(14);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f71539i = new Status(8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Status f71540j = new Status(15);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f71541k = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f71542l = new Status(17);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Status f71543m = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zze();

    Status(int i3, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f71544a = i3;
        this.f71545b = str;
        this.f71546c = pendingIntent;
        this.f71547d = connectionResult;
    }

    public boolean C() {
        return this.f71544a == 16;
    }

    public ConnectionResult M() {
        return this.f71547d;
    }

    public PendingIntent N() {
        return this.f71546c;
    }

    public int O() {
        return this.f71544a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f71544a == status.f71544a && Objects.b(this.f71545b, status.f71545b) && Objects.b(this.f71546c, status.f71546c) && Objects.b(this.f71547d, status.f71547d);
    }

    public String g0() {
        return this.f71545b;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f71544a), this.f71545b, this.f71546c, this.f71547d);
    }

    public boolean j0() {
        return this.f71546c != null;
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperD = Objects.d(this);
        toStringHelperD.a("statusCode", zza());
        toStringHelperD.a("resolution", this.f71546c);
        return toStringHelperD.toString();
    }

    public boolean w0() {
        return this.f71544a <= 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, O());
        SafeParcelWriter.G(parcel, 2, g0(), false);
        SafeParcelWriter.E(parcel, 3, this.f71546c, i3, false);
        SafeParcelWriter.E(parcel, 4, M(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public void z0(Activity activity, int i3) throws IntentSender.SendIntentException {
        if (j0()) {
            Bundle bundle = PlatformVersion.j() ? ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle() : null;
            PendingIntent pendingIntent = this.f71546c;
            Preconditions.m(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i3, null, 0, 0, 0, bundle);
        }
    }

    public final String zza() {
        String str = this.f71545b;
        return str != null ? str : CommonStatusCodes.a(this.f71544a);
    }

    public Status(int i3) {
        this(i3, (String) null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public Status(int i3, String str) {
        this(i3, str, (PendingIntent) null);
    }

    public Status(ConnectionResult connectionResult, String str, int i3) {
        this(i3, str, connectionResult.g0(), connectionResult);
    }

    public Status(int i3, String str, PendingIntent pendingIntent) {
        this(i3, str, pendingIntent, null);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }
}
