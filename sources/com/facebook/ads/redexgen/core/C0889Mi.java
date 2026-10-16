package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"NON_FINAL"}, value = "D54147219: For usage in Hero Simple Cache")
public final class C0889Mi {
    public static byte[] A06;
    public static String[] A07 = {"1eaMPdLcC8DbZCkn0iIyVPFCZSdDAanS", "Exaxr4PlErBkBzdiwoicKn", "2BC", "jQaYCx7PV0mXn8Zj7H8rC7xxlui6spsC", "wp2nCKHDQcjkZqDMhhhKbFGW7G", "lMJ", "SjVm96go47njO9ADG8uLls", "QdN"};
    public InterfaceC0888Mh A00;
    public InterfaceC0888Mh A01;
    public final SparseArray<String> A02;
    public final SparseBooleanArray A03;
    public final SparseBooleanArray A04;
    public final HashMap<String, C0887Mg> A05;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A06 = new byte[]{Ascii.DC4, Ascii.DLE, 6, 122, Ascii.SYN, Ascii.ETB, Ascii.SYN, 122, 5, Ascii.RS, Ascii.SYN, 6, 96, 5, Ascii.DC4, 17, 17, Ascii.FS, Ascii.ESC, Ascii.DC2, 32, Framer.ENTER_FRAME_PREFIX, 66, 101, 125, 106, 103, 98, 111, 43, 125, 106, 103, 126, 110, 43, Framer.EXIT_FRAME_PREFIX, 98, 113, 110, Framer.STDOUT_FRAME_PREFIX, 43, Ascii.DEL, 125, Ascii.DEL, 116, 121, Framer.EXIT_FRAME_PREFIX, 67, Ascii.DEL, 115, 114, 104, 121, 114, 104, 67, 117, 114, Framer.EXIT_FRAME_PREFIX, 121, 100, Framer.STDERR_FRAME_PREFIX, 121, 100, 117};
    }

    static {
        A07();
    }

    public C0889Mi(C5O c5o, File file, byte[] bArr, boolean z2, boolean z3) {
        AbstractC04323y.A08((c5o == null && file == null) ? false : true);
        this.A05 = new HashMap<>();
        this.A02 = new SparseArray<>();
        this.A04 = new SparseBooleanArray();
        this.A03 = new SparseBooleanArray();
        C1861kQ c1861kQ = c5o != null ? new C1861kQ(c5o) : null;
        InterfaceC0888Mh databaseStorage = file != null ? new C1860kP(new File(file, A04(42, 24, 47)), bArr, z2) : null;
        if (c1861kQ == null || (databaseStorage != null && z3)) {
            InterfaceC0888Mh legacyStorage = (InterfaceC0888Mh) C5C.A0f(databaseStorage);
            this.A01 = legacyStorage;
            this.A00 = c1861kQ;
        } else {
            this.A01 = c1861kQ;
            this.A00 = databaseStorage;
        }
    }

    public static int A00(SparseArray<String> idToKey) {
        int id;
        int size = idToKey.size();
        if (size == 0) {
            id = 0;
        } else {
            int size2 = size - 1;
            id = idToKey.keyAt(size2) + 1;
        }
        if (id < 0) {
            id = 0;
            while (id < size) {
                int size3 = idToKey.keyAt(id);
                if (id != size3) {
                    break;
                }
                id++;
            }
        }
        return id;
    }

    private C0887Mg A01(String str) {
        int iA00 = A00(this.A02);
        C0887Mg c0887Mg = new C0887Mg(iA00, str);
        this.A05.put(str, c0887Mg);
        this.A02.put(iA00, str);
        this.A03.put(iA00, true);
        this.A01.AGK(c0887Mg);
        return c0887Mg;
    }

    public static C1858kN A02(DataInputStream dataInputStream) throws IOException {
        int i3 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int nextBytesToRead = 0; nextBytesToRead < i3; nextBytesToRead++) {
            String utf = dataInputStream.readUTF();
            int bytesRead = dataInputStream.readInt();
            if (bytesRead >= 0) {
                int valueSize = 0;
                int i4 = Math.min(bytesRead, 10485760);
                byte[] bArrCopyOf = C5C.A07;
                while (valueSize != bytesRead) {
                    int size = valueSize + i4;
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    dataInputStream.readFully(bArrCopyOf, valueSize, i4);
                    valueSize += i4;
                    int size2 = bytesRead - valueSize;
                    i4 = Math.min(size2, 10485760);
                }
                map.put(utf, bArrCopyOf);
            } else {
                throw new IOException(A04(22, 20, 56) + bytesRead);
            }
        }
        return new C1858kN(map);
    }

    public static Cipher A05() throws NoSuchPaddingException, NoSuchAlgorithmException {
        int i3 = C5C.A02;
        String strA04 = A04(0, 20, 102);
        if (i3 == 18) {
            try {
                return Cipher.getInstance(strA04, A04(20, 2, 81));
            } catch (Throwable unused) {
            }
        }
        Cipher cipher = Cipher.getInstance(strA04);
        String[] strArr = A07;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "EBBbD5OLh9DYDBrMigQNtJ";
        strArr2[1] = "xQSZ94mu2vygjBv0Ab9r12";
        return cipher;
    }

    public static void A08(C1858kN c1858kN, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setA06 = c1858kN.A06();
        dataOutputStream.writeInt(setA06.size());
        for (Map.Entry<String, byte[]> entry : setA06) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public static boolean A0A(String str) {
        return str.startsWith(A04(42, 24, 47));
    }

    public final int A0B(String str) {
        return A0D(str).A01;
    }

    public final C0887Mg A0C(String str) {
        return this.A05.get(str);
    }

    public final C0887Mg A0D(String str) {
        C0887Mg cachedContent = this.A05.get(str);
        return cachedContent == null ? A01(str) : cachedContent;
    }

    public final C1858kN A0E(String str) {
        C0887Mg cachedContent = A0C(str);
        return cachedContent != null ? cachedContent.A03() : C1858kN.A03;
    }

    public final String A0F(int i3) {
        return this.A02.get(i3);
    }

    public final Collection<C0887Mg> A0G() {
        return Collections.unmodifiableCollection(this.A05.values());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0H() {
        C4C c4cA0N = BO.A07(this.A05.keySet()).A0N();
        while (true) {
            boolean zHasNext = c4cA0N.hasNext();
            String[] strArr = A07;
            if (strArr[7].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "jpVmrDDiLa6KSoRZ9DaLqT";
            strArr2[1] = "R0FMfILNqJLoUgBryCIaQS";
            if (zHasNext) {
                A0K((String) c4cA0N.next());
            } else {
                return;
            }
        }
    }

    public final void A0I() throws IOException {
        this.A01.AKJ(this.A05);
        int size = this.A04.size();
        for (int i3 = 0; i3 < size; i3++) {
            SparseArray<String> sparseArray = this.A02;
            int removedIdCount = this.A04.keyAt(i3);
            sparseArray.remove(removedIdCount);
        }
        this.A04.clear();
        this.A03.clear();
    }

    public final void A0J(long j3) throws IOException {
        this.A01.AAF(j3);
        if (this.A00 != null) {
            this.A00.AAF(j3);
        }
        if (!this.A01.A6S() && this.A00 != null && this.A00.A6S()) {
            this.A00.AAs(this.A05, this.A02);
            this.A01.AKI(this.A05);
        } else {
            this.A01.AAs(this.A05, this.A02);
        }
        if (this.A00 != null) {
            InterfaceC0888Mh interfaceC0888Mh = this.A00;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "sHyLaDKMqWdH53QwNCQNuy";
            strArr2[1] = "kZIq1iKkwSA0yGMJ22HAvZ";
            interfaceC0888Mh.A5p();
            this.A00 = null;
        }
    }

    public final void A0K(String str) {
        C0887Mg c0887Mg = this.A05.get(str);
        if (c0887Mg != null && c0887Mg.A09() && c0887Mg.A0A()) {
            this.A05.remove(str);
            int i3 = c0887Mg.A01;
            boolean z2 = this.A03.get(i3);
            this.A01.AFd(c0887Mg, z2);
            if (z2) {
                this.A02.remove(i3);
                this.A03.delete(i3);
            } else {
                this.A02.put(i3, null);
                this.A04.put(i3, true);
            }
        }
    }

    public final void A0L(String str, C0892Ml c0892Ml) {
        C0887Mg c0887MgA0D = A0D(str);
        if (c0887MgA0D.A0E(c0892Ml)) {
            this.A01.AGK(c0887MgA0D);
        }
    }
}
