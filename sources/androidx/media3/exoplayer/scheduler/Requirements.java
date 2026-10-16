package androidx.media3.exoplayer.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.internal.AnalyticsEvents;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() { // from class: androidx.media3.exoplayer.scheduler.Requirements.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Requirements[] newArray(int i3) {
            return new Requirements[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f44529a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequirementFlags {
    }

    public Requirements(int i3) {
        this.f44529a = (i3 & 2) != 0 ? i3 | 1 : i3;
    }

    private int c(Context context) {
        if (!k()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.e(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && j(connectivityManager)) ? (n() && connectivityManager.isActiveNetworkMetered()) ? 2 : 0 : this.f44529a & 3;
    }

    private boolean g(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean h(Context context) {
        PowerManager powerManager = (PowerManager) Assertions.e(context.getSystemService("power"));
        return Util.f41609a >= 23 ? powerManager.isDeviceIdleMode() : !powerManager.isInteractive();
    }

    private static boolean j(ConnectivityManager connectivityManager) {
        if (Util.f41609a < 24) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException unused) {
            return true;
        }
    }

    private boolean l(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public Requirements a(int i3) {
        int i4 = this.f44529a;
        int i5 = i3 & i4;
        return i5 == i4 ? this : new Requirements(i5);
    }

    public int d(Context context) {
        int iC = c(context);
        if (f() && !g(context)) {
            iC |= 8;
        }
        if (i() && !h(context)) {
            iC |= 4;
        }
        return (!m() || l(context)) ? iC : iC | 16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f44529a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Requirements.class == obj.getClass() && this.f44529a == ((Requirements) obj).f44529a;
    }

    public boolean f() {
        return (this.f44529a & 8) != 0;
    }

    public int hashCode() {
        return this.f44529a;
    }

    public boolean i() {
        return (this.f44529a & 4) != 0;
    }

    public boolean k() {
        return (this.f44529a & 1) != 0;
    }

    public boolean m() {
        return (this.f44529a & 16) != 0;
    }

    public boolean n() {
        return (this.f44529a & 2) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f44529a);
    }
}
