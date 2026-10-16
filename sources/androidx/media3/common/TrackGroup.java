package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackGroup {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f41151f = Util.y0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f41152g = Util.y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Format[] f41156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f41157e;

    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }

    private static void c(String str, String str2, String str3, int i3) {
        Log.e("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i3 + ")"));
    }

    private static String d(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static int e(int i3) {
        return i3 | 16384;
    }

    private void f() {
        String strD = d(this.f41156d[0].f40621d);
        int iE = e(this.f41156d[0].f40623f);
        int i3 = 1;
        while (true) {
            Format[] formatArr = this.f41156d;
            if (i3 >= formatArr.length) {
                return;
            }
            if (!strD.equals(d(formatArr[i3].f40621d))) {
                Format[] formatArr2 = this.f41156d;
                c("languages", formatArr2[0].f40621d, formatArr2[i3].f40621d, i3);
                return;
            } else {
                if (iE != e(this.f41156d[i3].f40623f)) {
                    c("role flags", Integer.toBinaryString(this.f41156d[0].f40623f), Integer.toBinaryString(this.f41156d[i3].f40623f), i3);
                    return;
                }
                i3++;
            }
        }
    }

    public Format a(int i3) {
        return this.f41156d[i3];
    }

    public int b(Format format) {
        int i3 = 0;
        while (true) {
            Format[] formatArr = this.f41156d;
            if (i3 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i3]) {
                return i3;
            }
            i3++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroup.class == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            if (this.f41154b.equals(trackGroup.f41154b) && Arrays.equals(this.f41156d, trackGroup.f41156d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f41157e == 0) {
            this.f41157e = ((527 + this.f41154b.hashCode()) * 31) + Arrays.hashCode(this.f41156d);
        }
        return this.f41157e;
    }

    public String toString() {
        return this.f41154b + ": " + Arrays.toString(this.f41156d);
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.a(formatArr.length > 0);
        this.f41154b = str;
        this.f41156d = formatArr;
        this.f41153a = formatArr.length;
        int iK = MimeTypes.k(formatArr[0].f40632o);
        this.f41155c = iK == -1 ? MimeTypes.k(formatArr[0].f40631n) : iK;
        f();
    }
}
