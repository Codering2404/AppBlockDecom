package androidx.profileinstaller;

import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ProfileTranscoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f51406a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f51407b = {112, 114, 109, 0};

    private static void A(byte[] bArr, int i3, int i4, DexProfileData dexProfileData) {
        int iM = m(i3, i4, dexProfileData.f51393g);
        int i5 = iM / 8;
        bArr[i5] = (byte) ((1 << (iM % 8)) | bArr[i5]);
    }

    private static void B(InputStream inputStream) {
        Encoding.h(inputStream);
        int iJ = Encoding.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            Encoding.j(inputStream);
            for (int iJ2 = Encoding.j(inputStream); iJ2 > 0; iJ2--) {
                Encoding.h(inputStream);
            }
            iJ--;
        }
    }

    static boolean C(OutputStream outputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f51419a)) {
            P(outputStream, dexProfileDataArr);
            return true;
        }
        if (Arrays.equals(bArr, ProfileVersion.f51420b)) {
            O(outputStream, dexProfileDataArr);
            return true;
        }
        if (Arrays.equals(bArr, ProfileVersion.f51422d)) {
            M(outputStream, dexProfileDataArr);
            return true;
        }
        if (Arrays.equals(bArr, ProfileVersion.f51421c)) {
            N(outputStream, dexProfileDataArr);
            return true;
        }
        if (!Arrays.equals(bArr, ProfileVersion.f51423e)) {
            return false;
        }
        L(outputStream, dexProfileDataArr);
        return true;
    }

    private static void D(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        int[] iArr = dexProfileData.f51394h;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            Encoding.p(outputStream, i5 - i4);
            i3++;
            i4 = i5;
        }
    }

    private static WritableFileSection E(DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.p(byteArrayOutputStream, dexProfileDataArr.length);
            int i3 = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.q(byteArrayOutputStream, dexProfileData.f51389c);
                Encoding.q(byteArrayOutputStream, dexProfileData.f51390d);
                Encoding.q(byteArrayOutputStream, dexProfileData.f51393g);
                String strJ = j(dexProfileData.f51387a, dexProfileData.f51388b, ProfileVersion.f51419a);
                int iK = Encoding.k(strJ);
                Encoding.p(byteArrayOutputStream, iK);
                i3 = i3 + 14 + iK;
                Encoding.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i3 == byteArray.length) {
                WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i3, byteArray, false);
                byteArrayOutputStream.close();
                return writableFileSection;
            }
            throw Encoding.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static void F(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f51406a);
        outputStream.write(bArr);
    }

    private static void G(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        K(outputStream, dexProfileData);
        D(outputStream, dexProfileData);
        I(outputStream, dexProfileData);
    }

    private static void H(OutputStream outputStream, DexProfileData dexProfileData, String str) throws IOException {
        Encoding.p(outputStream, Encoding.k(str));
        Encoding.p(outputStream, dexProfileData.f51391e);
        Encoding.q(outputStream, dexProfileData.f51392f);
        Encoding.q(outputStream, dexProfileData.f51389c);
        Encoding.q(outputStream, dexProfileData.f51393g);
        Encoding.n(outputStream, str);
    }

    private static void I(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[k(dexProfileData.f51393g)];
        for (Map.Entry entry : dexProfileData.f51395i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                A(bArr, 2, iIntValue, dexProfileData);
            }
            if ((iIntValue2 & 4) != 0) {
                A(bArr, 4, iIntValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    private static void J(OutputStream outputStream, int i3, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[l(i3, dexProfileData.f51393g)];
        for (Map.Entry entry : dexProfileData.f51395i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i4 = 0;
            for (int i5 = 1; i5 <= 4; i5 <<= 1) {
                if (i5 != 1 && (i5 & i3) != 0) {
                    if ((i5 & iIntValue2) == i5) {
                        int i6 = (dexProfileData.f51393g * i4) + iIntValue;
                        int i7 = i6 / 8;
                        bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
                    }
                    i4++;
                }
            }
        }
        outputStream.write(bArr);
    }

    private static void K(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        int i3 = 0;
        for (Map.Entry entry : dexProfileData.f51395i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                Encoding.p(outputStream, iIntValue - i3);
                Encoding.p(outputStream, 0);
                i3 = iIntValue;
            }
        }
    }

    private static void L(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.p(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String strJ = j(dexProfileData.f51387a, dexProfileData.f51388b, ProfileVersion.f51423e);
            Encoding.p(outputStream, Encoding.k(strJ));
            Encoding.p(outputStream, dexProfileData.f51395i.size());
            Encoding.p(outputStream, dexProfileData.f51394h.length);
            Encoding.q(outputStream, dexProfileData.f51389c);
            Encoding.n(outputStream, strJ);
            Iterator it = dexProfileData.f51395i.keySet().iterator();
            while (it.hasNext()) {
                Encoding.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i3 : dexProfileData.f51394h) {
                Encoding.p(outputStream, i3);
            }
        }
    }

    private static void M(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.r(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            int size = dexProfileData.f51395i.size() * 4;
            String strJ = j(dexProfileData.f51387a, dexProfileData.f51388b, ProfileVersion.f51422d);
            Encoding.p(outputStream, Encoding.k(strJ));
            Encoding.p(outputStream, dexProfileData.f51394h.length);
            Encoding.q(outputStream, size);
            Encoding.q(outputStream, dexProfileData.f51389c);
            Encoding.n(outputStream, strJ);
            Iterator it = dexProfileData.f51395i.keySet().iterator();
            while (it.hasNext()) {
                Encoding.p(outputStream, ((Integer) it.next()).intValue());
                Encoding.p(outputStream, 0);
            }
            for (int i3 : dexProfileData.f51394h) {
                Encoding.p(outputStream, i3);
            }
        }
    }

    private static void N(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArrB = b(dexProfileDataArr, ProfileVersion.f51421c);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, bArrB);
    }

    private static void O(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArrB = b(dexProfileDataArr, ProfileVersion.f51420b);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, bArrB);
    }

    private static void P(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        Q(outputStream, dexProfileDataArr);
    }

    private static void Q(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(E(dexProfileDataArr));
        arrayList.add(c(dexProfileDataArr));
        arrayList.add(d(dexProfileDataArr));
        long length2 = ((long) ProfileVersion.f51419a.length) + ((long) f51406a.length) + 4 + ((long) (arrayList.size() * 16));
        Encoding.q(outputStream, arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i3);
            Encoding.q(outputStream, writableFileSection.f51426a.b());
            Encoding.q(outputStream, length2);
            if (writableFileSection.f51429d) {
                byte[] bArr = writableFileSection.f51428c;
                long length3 = bArr.length;
                byte[] bArrB = Encoding.b(bArr);
                arrayList2.add(bArrB);
                Encoding.q(outputStream, bArrB.length);
                Encoding.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(writableFileSection.f51428c);
                Encoding.q(outputStream, writableFileSection.f51428c.length);
                Encoding.q(outputStream, 0L);
                length = writableFileSection.f51428c.length;
            }
            length2 += (long) length;
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            outputStream.write((byte[]) arrayList2.get(i4));
        }
    }

    private static int a(DexProfileData dexProfileData) {
        Iterator it = dexProfileData.f51395i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    private static byte[] b(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int i3 = 0;
        int iK = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            iK += Encoding.k(j(dexProfileData.f51387a, dexProfileData.f51388b, bArr)) + 16 + (dexProfileData.f51391e * 2) + dexProfileData.f51392f + k(dexProfileData.f51393g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, ProfileVersion.f51421c)) {
            int length = dexProfileDataArr.length;
            while (i3 < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i3];
                H(byteArrayOutputStream, dexProfileData2, j(dexProfileData2.f51387a, dexProfileData2.f51388b, bArr));
                G(byteArrayOutputStream, dexProfileData2);
                i3++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                H(byteArrayOutputStream, dexProfileData3, j(dexProfileData3.f51387a, dexProfileData3.f51388b, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i3 < length2) {
                G(byteArrayOutputStream, dexProfileDataArr[i3]);
                i3++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    private static WritableFileSection c(DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (int i4 = 0; i4 < dexProfileDataArr.length; i4++) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i4];
                Encoding.p(byteArrayOutputStream, i4);
                Encoding.p(byteArrayOutputStream, dexProfileData.f51391e);
                i3 = i3 + 4 + (dexProfileData.f51391e * 2);
                D(byteArrayOutputStream, dexProfileData);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i3, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
    }

    private static WritableFileSection d(DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (int i4 = 0; i4 < dexProfileDataArr.length; i4++) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i4];
                int iA = a(dexProfileData);
                byte[] bArrE = e(iA, dexProfileData);
                byte[] bArrF = f(dexProfileData);
                Encoding.p(byteArrayOutputStream, i4);
                int length = bArrE.length + 2 + bArrF.length;
                Encoding.q(byteArrayOutputStream, length);
                Encoding.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i3 = i3 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i3, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(int i3, DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            J(byteArrayOutputStream, i3, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            K(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "!") : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR.equals(str2) ? str.replace("!", Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) : str;
    }

    private static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    private static DexProfileData i(DexProfileData[] dexProfileDataArr, String str) {
        if (dexProfileDataArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i3 = 0; i3 < dexProfileDataArr.length; i3++) {
            if (dexProfileDataArr[i3].f51388b.equals(strH)) {
                return dexProfileDataArr[i3];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String strA = ProfileVersion.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + ProfileVersion.a(bArr) + str2;
    }

    private static int k(int i3) {
        return z(i3 * 2) / 8;
    }

    private static int l(int i3, int i4) {
        return z(Integer.bitCount(i3 & (-2)) * i4) / 8;
    }

    private static int m(int i3, int i4, int i5) {
        if (i3 == 1) {
            throw Encoding.c("HOT methods are not stored in the bitmap");
        }
        if (i3 == 2) {
            return i4;
        }
        if (i3 == 4) {
            return i4 + i5;
        }
        throw Encoding.c("Unexpected flag: " + i3);
    }

    private static int[] n(InputStream inputStream, int i3) {
        int[] iArr = new int[i3];
        int iH = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iH += Encoding.h(inputStream);
            iArr[i4] = iH;
        }
        return iArr;
    }

    private static int o(BitSet bitSet, int i3, int i4) {
        int i5 = bitSet.get(m(2, i3, i4)) ? 2 : 0;
        return bitSet.get(m(4, i3, i4)) ? i5 | 4 : i5;
    }

    static byte[] p(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, Encoding.d(inputStream, bArr.length))) {
            return Encoding.d(inputStream, ProfileVersion.f51420b.length);
        }
        throw Encoding.c("Invalid magic");
    }

    private static void q(InputStream inputStream, DexProfileData dexProfileData) {
        int iAvailable = inputStream.available() - dexProfileData.f51392f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += Encoding.h(inputStream);
            dexProfileData.f51395i.put(Integer.valueOf(iH), 1);
            for (int iH2 = Encoding.h(inputStream); iH2 > 0; iH2--) {
                B(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw Encoding.c("Read too much data during profile line parse");
        }
    }

    static DexProfileData[] r(InputStream inputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) {
        if (Arrays.equals(bArr, ProfileVersion.f51424f)) {
            if (Arrays.equals(ProfileVersion.f51419a, bArr2)) {
                throw Encoding.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return s(inputStream, bArr, dexProfileDataArr);
        }
        if (Arrays.equals(bArr, ProfileVersion.f51425g)) {
            return u(inputStream, bArr2, dexProfileDataArr);
        }
        throw Encoding.c("Unsupported meta version");
    }

    static DexProfileData[] s(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (!Arrays.equals(bArr, ProfileVersion.f51424f)) {
            throw Encoding.c("Unsupported meta version");
        }
        int iJ = Encoding.j(inputStream);
        byte[] bArrE = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            DexProfileData[] dexProfileDataArrT = t(byteArrayInputStream, iJ, dexProfileDataArr);
            byteArrayInputStream.close();
            return dexProfileDataArrT;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static DexProfileData[] t(InputStream inputStream, int i3, DexProfileData[] dexProfileDataArr) {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i3 != dexProfileDataArr.length) {
            throw Encoding.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i3];
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int iH = Encoding.h(inputStream);
            iArr[i4] = Encoding.h(inputStream);
            strArr[i4] = Encoding.f(inputStream, iH);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            DexProfileData dexProfileData = dexProfileDataArr[i5];
            if (!dexProfileData.f51388b.equals(strArr[i5])) {
                throw Encoding.c("Order of dexfiles in metadata did not match baseline");
            }
            int i6 = iArr[i5];
            dexProfileData.f51391e = i6;
            dexProfileData.f51394h = n(inputStream, i6);
        }
        return dexProfileDataArr;
    }

    static DexProfileData[] u(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int iH = Encoding.h(inputStream);
        byte[] bArrE = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            DexProfileData[] dexProfileDataArrV = v(byteArrayInputStream, bArr, iH, dexProfileDataArr);
            byteArrayInputStream.close();
            return dexProfileDataArrV;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static DexProfileData[] v(InputStream inputStream, byte[] bArr, int i3, DexProfileData[] dexProfileDataArr) {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i3 != dexProfileDataArr.length) {
            throw Encoding.c("Mismatched number of dex files found in metadata");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            Encoding.h(inputStream);
            String strF = Encoding.f(inputStream, Encoding.h(inputStream));
            long jI = Encoding.i(inputStream);
            int iH = Encoding.h(inputStream);
            DexProfileData dexProfileDataI = i(dexProfileDataArr, strF);
            if (dexProfileDataI == null) {
                throw Encoding.c("Missing profile key: " + strF);
            }
            dexProfileDataI.f51390d = jI;
            int[] iArrN = n(inputStream, iH);
            if (Arrays.equals(bArr, ProfileVersion.f51423e)) {
                dexProfileDataI.f51391e = iH;
                dexProfileDataI.f51394h = iArrN;
            }
        }
        return dexProfileDataArr;
    }

    private static void w(InputStream inputStream, DexProfileData dexProfileData) {
        BitSet bitSetValueOf = BitSet.valueOf(Encoding.d(inputStream, Encoding.a(dexProfileData.f51393g * 2)));
        int i3 = 0;
        while (true) {
            int i4 = dexProfileData.f51393g;
            if (i3 >= i4) {
                return;
            }
            int iO = o(bitSetValueOf, i3, i4);
            if (iO != 0) {
                Integer num = (Integer) dexProfileData.f51395i.get(Integer.valueOf(i3));
                if (num == null) {
                    num = 0;
                }
                dexProfileData.f51395i.put(Integer.valueOf(i3), Integer.valueOf(iO | num.intValue()));
            }
            i3++;
        }
    }

    static DexProfileData[] x(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, ProfileVersion.f51420b)) {
            throw Encoding.c("Unsupported version");
        }
        int iJ = Encoding.j(inputStream);
        byte[] bArrE = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            DexProfileData[] dexProfileDataArrY = y(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return dexProfileDataArrY;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static DexProfileData[] y(InputStream inputStream, String str, int i3) {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int iH = Encoding.h(inputStream);
            int iH2 = Encoding.h(inputStream);
            dexProfileDataArr[i4] = new DexProfileData(str, Encoding.f(inputStream, iH), Encoding.i(inputStream), 0L, iH2, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i5 = 0; i5 < i3; i5++) {
            DexProfileData dexProfileData = dexProfileDataArr[i5];
            q(inputStream, dexProfileData);
            dexProfileData.f51394h = n(inputStream, dexProfileData.f51391e);
            w(inputStream, dexProfileData);
        }
        return dexProfileDataArr;
    }

    private static int z(int i3) {
        return (i3 + 7) & (-8);
    }
}
