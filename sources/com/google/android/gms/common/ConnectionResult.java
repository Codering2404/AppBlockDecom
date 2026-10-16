package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PendingIntent f71436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f71437d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f71438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConnectionResult f71433g = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zza();

    ConnectionResult(int i3, int i4, PendingIntent pendingIntent, String str, Integer num) {
        this.f71434a = i3;
        this.f71435b = i4;
        this.f71436c = pendingIntent;
        this.f71437d = str;
        this.f71438f = num;
    }

    static String z0(int i3) {
        if (i3 == 99) {
            return "UNFINISHED";
        }
        if (i3 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i3) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i3) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 20);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i3);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public Integer M() {
        return this.f71438f;
    }

    public int N() {
        return this.f71435b;
    }

    public String O() {
        return this.f71437d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f71435b == connectionResult.f71435b && Objects.b(this.f71436c, connectionResult.f71436c) && Objects.b(this.f71437d, connectionResult.f71437d) && Objects.b(this.f71438f, connectionResult.f71438f);
    }

    public PendingIntent g0() {
        return this.f71436c;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f71435b), this.f71436c, this.f71437d, this.f71438f);
    }

    public boolean j0() {
        return (this.f71435b == 0 || this.f71436c == null) ? false : true;
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperD = Objects.d(this);
        toStringHelperD.a("statusCode", z0(this.f71435b));
        toStringHelperD.a("resolution", this.f71436c);
        toStringHelperD.a("message", this.f71437d);
        toStringHelperD.a("clientMethodKey", this.f71438f);
        return toStringHelperD.toString();
    }

    public boolean w0() {
        return this.f71435b == 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f71434a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.E(parcel, 3, g0(), i3, false);
        SafeParcelWriter.G(parcel, 4, O(), false);
        SafeParcelWriter.x(parcel, 5, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public ConnectionResult(int i3) {
        this(i3, null, null);
    }

    public ConnectionResult(int i3, PendingIntent pendingIntent) {
        this(i3, pendingIntent, null);
    }

    public ConnectionResult(int i3, PendingIntent pendingIntent, String str) {
        this(1, i3, pendingIntent, str, null);
    }
}
