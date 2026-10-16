package androidx.media3.extractor.metadata.icy;

import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import com.facebook.appevents.AppEventsConstants;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class IcyHeaders implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f46442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f46443f;

    public IcyHeaders(int i3, String str, String str2, String str3, boolean z2, int i4) {
        Assertions.a(i4 == -1 || i4 > 0);
        this.f46438a = i3;
        this.f46439b = str;
        this.f46440c = str2;
        this.f46441d = str3;
        this.f46442e = z2;
        this.f46443f = i4;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void b(MediaMetadata.Builder builder) {
        String str = this.f46440c;
        if (str != null) {
            builder.n0(str);
        }
        String str2 = this.f46439b;
        if (str2 != null) {
            builder.c0(str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IcyHeaders.class == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            if (this.f46438a == icyHeaders.f46438a && Objects.equals(this.f46439b, icyHeaders.f46439b) && Objects.equals(this.f46440c, icyHeaders.f46440c) && Objects.equals(this.f46441d, icyHeaders.f46441d) && this.f46442e == icyHeaders.f46442e && this.f46443f == icyHeaders.f46443f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (527 + this.f46438a) * 31;
        String str = this.f46439b;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f46440c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f46441d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f46442e ? 1 : 0)) * 31) + this.f46443f;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f46440c + "\", genre=\"" + this.f46439b + "\", bitrate=" + this.f46438a + ", metadataInterval=" + this.f46443f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IcyHeaders d(Map map) {
        boolean z2;
        int i3;
        IcyHeaders icyHeaders;
        String str;
        String str2;
        boolean zEquals;
        int i4;
        List list = (List) map.get("icy-br");
        boolean z3 = true;
        int i5 = -1;
        if (list != null) {
            String str3 = (String) list.get(0);
            try {
                i4 = Integer.parseInt(str3) * 1000;
                if (i4 > 0) {
                    z2 = true;
                } else {
                    try {
                        Log.i("IcyHeaders", "Invalid bitrate: " + str3);
                        z2 = false;
                        i4 = -1;
                    } catch (NumberFormatException unused) {
                        Log.i("IcyHeaders", "Invalid bitrate header: " + str3);
                        z2 = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i4 = -1;
            }
            i3 = i4;
        } else {
            z2 = false;
            i3 = -1;
        }
        List list2 = (List) map.get("icy-genre");
        String str4 = null;
        if (list2 != null) {
            String str5 = (String) list2.get(0);
            icyHeaders = null;
            str4 = str5;
            z2 = true;
        } else {
            icyHeaders = null;
        }
        List list3 = (List) map.get("icy-name");
        if (list3 != null) {
            str = (String) list3.get(0);
            z2 = true;
        } else {
            str = icyHeaders;
        }
        List list4 = (List) map.get(QgXempTBEfV.wcJJBUBIqzjjcBF);
        if (list4 != null) {
            str2 = (String) list4.get(0);
            z2 = true;
        } else {
            str2 = icyHeaders;
        }
        List list5 = (List) map.get("icy-pub");
        if (list5 != null) {
            zEquals = ((String) list5.get(0)).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            z2 = true;
        } else {
            zEquals = false;
        }
        List list6 = (List) map.get("icy-metaint");
        if (list6 != null) {
            String str6 = (String) list6.get(0);
            try {
                int i6 = Integer.parseInt(str6);
                if (i6 > 0) {
                    i5 = i6;
                } else {
                    try {
                        Log.i("IcyHeaders", "Invalid metadata interval: " + str6);
                        z3 = z2;
                    } catch (NumberFormatException unused3) {
                        i5 = i6;
                        Log.i("IcyHeaders", "Invalid metadata interval: " + str6);
                    }
                }
                z2 = z3;
            } catch (NumberFormatException unused4) {
            }
        }
        int i7 = i5;
        if (z2) {
            icyHeaders = new IcyHeaders(i3, str4, str, str2, zEquals, i7);
        }
        return icyHeaders;
    }
}
