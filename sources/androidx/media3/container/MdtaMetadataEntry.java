package androidx.media3.container;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f41659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41661d;

    public MdtaMetadataEntry(String str, byte[] bArr, int i3) {
        this(str, bArr, 0, i3);
    }

    private static String e(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("track types = ");
        Joiner.h(',').c(sb, list);
        return sb.toString();
    }

    private static void f(String str, byte[] bArr, int i3) {
        boolean z2;
        byte b3;
        str.getClass();
        switch (str) {
            case "com.android.capture.fps":
                if (i3 == 23 && bArr.length == 4) {
                    z2 = true;
                }
                Assertions.a(z2);
                break;
            case "auxiliary.tracks.interleaved":
                if (i3 == 75 && bArr.length == 1 && ((b3 = bArr[0]) == 0 || b3 == 1)) {
                    z2 = true;
                }
                Assertions.a(z2);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i3 == 78 && bArr.length == 8) {
                    z2 = true;
                }
                Assertions.a(z2);
                break;
            case "auxiliary.tracks.map":
                Assertions.a(i3 == 0);
                break;
        }
    }

    public List d() {
        Assertions.h(this.f41658a.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte b3 = this.f41659b[1];
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < b3; i3++) {
            arrayList.add(Integer.valueOf(this.f41659b[i3 + 2]));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MdtaMetadataEntry.class == obj.getClass()) {
            MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
            if (this.f41658a.equals(mdtaMetadataEntry.f41658a) && Arrays.equals(this.f41659b, mdtaMetadataEntry.f41659b) && this.f41660c == mdtaMetadataEntry.f41660c && this.f41661d == mdtaMetadataEntry.f41661d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f41658a.hashCode()) * 31) + Arrays.hashCode(this.f41659b)) * 31) + this.f41660c) * 31) + this.f41661d;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            int r0 = r3.f41661d
            if (r0 == 0) goto L57
            r1 = 1
            if (r0 == r1) goto L50
            r1 = 23
            if (r0 == r1) goto L41
            r1 = 67
            if (r0 == r1) goto L36
            r1 = 75
            if (r0 == r1) goto L28
            r1 = 78
            if (r0 == r1) goto L18
            goto L6a
        L18:
            androidx.media3.common.util.ParsableByteArray r0 = new androidx.media3.common.util.ParsableByteArray
            byte[] r1 = r3.f41659b
            r0.<init>(r1)
            long r0 = r0.O()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L28:
            byte[] r0 = r3.f41659b
            r1 = 0
            r0 = r0[r1]
            int r0 = java.lang.Byte.toUnsignedInt(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L36:
            byte[] r0 = r3.f41659b
            int r0 = com.google.common.primitives.Ints.g(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L41:
            byte[] r0 = r3.f41659b
            int r0 = com.google.common.primitives.Ints.g(r0)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L50:
            byte[] r0 = r3.f41659b
            java.lang.String r0 = androidx.media3.common.util.Util.K(r0)
            goto L70
        L57:
            java.lang.String r0 = r3.f41658a
            java.lang.String r1 = "auxiliary.tracks.map"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6a
            java.util.List r0 = r3.d()
            java.lang.String r0 = e(r0)
            goto L70
        L6a:
            byte[] r0 = r3.f41659b
            java.lang.String r0 = androidx.media3.common.util.Util.o1(r0)
        L70:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "mdta: key="
            r1.append(r2)
            java.lang.String r2 = r3.f41658a
            r1.append(r2)
            java.lang.String r2 = ", value="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.MdtaMetadataEntry.toString():java.lang.String");
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i3, int i4) {
        f(str, bArr, i4);
        this.f41658a = str;
        this.f41659b = bArr;
        this.f41660c = i3;
        this.f41661d = i4;
    }
}
