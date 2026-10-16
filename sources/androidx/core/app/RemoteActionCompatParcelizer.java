package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f33799a = (IconCompat) versionedParcel.v(remoteActionCompat.f33799a, 1);
        remoteActionCompat.f33800b = versionedParcel.l(remoteActionCompat.f33800b, 2);
        remoteActionCompat.f33801c = versionedParcel.l(remoteActionCompat.f33801c, 3);
        remoteActionCompat.f33802d = (PendingIntent) versionedParcel.r(remoteActionCompat.f33802d, 4);
        remoteActionCompat.f33803e = versionedParcel.h(remoteActionCompat.f33803e, 5);
        remoteActionCompat.f33804f = versionedParcel.h(remoteActionCompat.f33804f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f33799a, 1);
        versionedParcel.D(remoteActionCompat.f33800b, 2);
        versionedParcel.D(remoteActionCompat.f33801c, 3);
        versionedParcel.H(remoteActionCompat.f33802d, 4);
        versionedParcel.z(remoteActionCompat.f33803e, 5);
        versionedParcel.z(remoteActionCompat.f33804f, 6);
    }
}
