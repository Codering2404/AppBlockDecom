package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.o2;
import com.applovin.impl.u;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements o2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f64003h = new u(null, new a[0], 0, -9223372036854775807L, 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a f64004i = new a(0).c(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o2.a f64005j = new o2.a() { // from class: com.applovin.impl.z50
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return u.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f64006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f64008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f64009d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f64010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a[] f64011g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a implements o2 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final o2.a f64012i = new o2.a() { // from class: com.applovin.impl.a60
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return u.a.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f64013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri[] f64015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f64016d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long[] f64017f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f64018g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f64019h;

        public a(long j3) {
            this(j3, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        private static long[] a(long[] jArr, int i3) {
            int length = jArr.length;
            int iMax = Math.max(i3, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        public boolean c() {
            return this.f64014b == -1 || a() < this.f64014b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f64013a == aVar.f64013a && this.f64014b == aVar.f64014b && Arrays.equals(this.f64015c, aVar.f64015c) && Arrays.equals(this.f64016d, aVar.f64016d) && Arrays.equals(this.f64017f, aVar.f64017f) && this.f64018g == aVar.f64018g && this.f64019h == aVar.f64019h) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i3 = this.f64014b * 31;
            long j3 = this.f64013a;
            int iHashCode = (((((((i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f64015c)) * 31) + Arrays.hashCode(this.f64016d)) * 31) + Arrays.hashCode(this.f64017f)) * 31;
            long j4 = this.f64018g;
            return ((iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f64019h ? 1 : 0);
        }

        private a(long j3, int i3, int[] iArr, Uri[] uriArr, long[] jArr, long j4, boolean z2) {
            b1.a(iArr.length == uriArr.length);
            this.f64013a = j3;
            this.f64014b = i3;
            this.f64016d = iArr;
            this.f64015c = uriArr;
            this.f64017f = jArr;
            this.f64018g = j4;
            this.f64019h = z2;
        }

        public boolean b() {
            if (this.f64014b == -1) {
                return true;
            }
            for (int i3 = 0; i3 < this.f64014b; i3++) {
                int i4 = this.f64016d[i3];
                if (i4 == 0 || i4 == 1) {
                    return true;
                }
            }
            return false;
        }

        public a c(int i3) {
            int[] iArrA = a(this.f64016d, i3);
            long[] jArrA = a(this.f64017f, i3);
            return new a(this.f64013a, i3, iArrA, (Uri[]) Arrays.copyOf(this.f64015c, i3), jArrA, this.f64018g, this.f64019h);
        }

        private static int[] a(int[] iArr, int i3) {
            int length = iArr.length;
            int iMax = Math.max(i3, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        private static String b(int i3) {
            return Integer.toString(i3, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a a(Bundle bundle) {
            long j3 = bundle.getLong(b(0));
            int i3 = bundle.getInt(b(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(b(2));
            int[] intArray = bundle.getIntArray(b(3));
            long[] longArray = bundle.getLongArray(b(4));
            long j4 = bundle.getLong(b(5));
            boolean z2 = bundle.getBoolean(b(6));
            int[] iArr = intArray;
            if (iArr == null) {
                iArr = new int[0];
            }
            Uri[] uriArr = parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]);
            if (longArray == null) {
                longArray = new long[0];
            }
            return new a(j3, i3, iArr, uriArr, longArray, j4, z2);
        }

        public int a() {
            return a(-1);
        }

        public int a(int i3) {
            int i4;
            int i5 = i3 + 1;
            while (true) {
                int[] iArr = this.f64016d;
                if (i5 >= iArr.length || this.f64019h || (i4 = iArr[i5]) == 0 || i4 == 1) {
                    break;
                }
                i5++;
            }
            return i5;
        }
    }

    private u(Object obj, a[] aVarArr, long j3, long j4, int i3) {
        this.f64006a = obj;
        this.f64008c = j3;
        this.f64009d = j4;
        this.f64007b = aVarArr.length + i3;
        this.f64011g = aVarArr;
        this.f64010f = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static u a(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(b(1));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                aVarArr2[i3] = (a) a.f64012i.a((Bundle) parcelableArrayList.get(i3));
            }
            aVarArr = aVarArr2;
        }
        return new u(null, aVarArr, bundle.getLong(b(2), 0L), bundle.getLong(b(3), -9223372036854775807L), bundle.getInt(b(4)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u.class == obj.getClass()) {
            u uVar = (u) obj;
            if (xp.a(this.f64006a, uVar.f64006a) && this.f64007b == uVar.f64007b && this.f64008c == uVar.f64008c && this.f64009d == uVar.f64009d && this.f64010f == uVar.f64010f && Arrays.equals(this.f64011g, uVar.f64011g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f64007b * 31;
        Object obj = this.f64006a;
        return ((((((((i3 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f64008c)) * 31) + ((int) this.f64009d)) * 31) + this.f64010f) * 31) + Arrays.hashCode(this.f64011g);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f64006a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f64008c);
        sb.append(", adGroups=[");
        for (int i3 = 0; i3 < this.f64011g.length; i3++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f64011g[i3].f64013a);
            sb.append(", ads=[");
            for (int i4 = 0; i4 < this.f64011g[i3].f64016d.length; i4++) {
                sb.append("ad(state=");
                int i5 = this.f64011g[i3].f64016d[i4];
                if (i5 == 0) {
                    sb.append('_');
                } else if (i5 == 1) {
                    sb.append('R');
                } else if (i5 == 2) {
                    sb.append('S');
                } else if (i5 == 3) {
                    sb.append('P');
                } else if (i5 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f64011g[i3].f64017f[i4]);
                sb.append(')');
                if (i4 < this.f64011g[i3].f64016d.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i3 < this.f64011g.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    public int b(long j3, long j4) {
        int i3 = this.f64007b - 1;
        while (i3 >= 0) {
            long j5 = j3;
            long j6 = j4;
            if (!a(j5, j6, i3)) {
                break;
            }
            i3--;
            j3 = j5;
            j4 = j6;
        }
        if (i3 < 0 || !a(i3).b()) {
            return -1;
        }
        return i3;
    }

    private static String b(int i3) {
        return Integer.toString(i3, 36);
    }

    public a a(int i3) {
        int i4 = this.f64010f;
        if (i3 < i4) {
            return f64004i;
        }
        return this.f64011g[i3 - i4];
    }

    public int a(long j3, long j4) {
        if (j3 != Long.MIN_VALUE && (j4 == -9223372036854775807L || j3 < j4)) {
            int i3 = this.f64010f;
            while (i3 < this.f64007b && ((a(i3).f64013a != Long.MIN_VALUE && a(i3).f64013a <= j3) || !a(i3).c())) {
                i3++;
            }
            if (i3 < this.f64007b) {
                return i3;
            }
        }
        return -1;
    }

    private boolean a(long j3, long j4, int i3) {
        if (j3 == Long.MIN_VALUE) {
            return false;
        }
        long j5 = a(i3).f64013a;
        return j5 == Long.MIN_VALUE ? j4 == -9223372036854775807L || j3 < j4 : j3 < j5;
    }
}
