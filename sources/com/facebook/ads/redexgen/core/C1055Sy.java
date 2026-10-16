package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1055Sy {
    public static byte[] A03;
    public static String[] A04 = {"hUOGynEtmSUNsKdJkghkOGNAWtryygzy", "wzPRxUupX2XKUl6NSNI9kT750batbohw", "Jhw1FAiFO5yEDnp58HFyVFkAnHcYvwe5", "TOMeOtqGrF4uQ0cY9hasq1ESWlFY5vR9", "yYpnUvpVzVqKhRvrciBHRtLUwNGFzaUs", "hHaB", "31TBXmQRr4tlfWcucEg5Ko3P35yO7", "Q2"};
    public static final String A05;
    public static volatile C1055Sy A06;
    public final C1644ge A00;
    public final Map<String, C1052Sv> A02 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Float> A01 = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private Bitmap A02(T8 t8, C1052Sv c1052Sv, String str) throws Throwable {
        Bitmap bitmapA01;
        String str2 = c1052Sv.A08;
        int i3 = c1052Sv.A04;
        int i4 = c1052Sv.A05;
        long jCurrentTimeMillis = System.currentTimeMillis();
        IOException e3 = null;
        String strA08 = A08(223, 9, 68);
        boolean zStartsWith = str2.startsWith(strA08);
        String strA082 = A08(239, 22, 119);
        if (zStartsWith || str2.startsWith(strA082)) {
            String strSubstring = str2.startsWith(strA08) ? str2.substring(strA08.length()) : str2.substring(strA082.length());
            InputStream inputStreamOpen = null;
            try {
                try {
                    inputStreamOpen = this.A00.getAssets().open(strSubstring);
                    if (A0D(i3, i4)) {
                        try {
                            bitmapA01 = T2.A01(inputStreamOpen, i3, i4);
                        } catch (IOException e4) {
                            e = e4;
                            A0C(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e = e5;
                            A0C(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            throw th;
                        }
                    } else {
                        bitmapA01 = BitmapFactory.decodeStream(inputStreamOpen);
                    }
                    if (inputStreamOpen != null) {
                        A0A(inputStreamOpen);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (OutOfMemoryError e7) {
                e = e7;
            } catch (Throwable th3) {
                th = th3;
            }
        } else if (A0D(i3, i4)) {
            try {
                bitmapA01 = A05(str2, i3, i4);
            } catch (IOException e8) {
                e3 = e8;
                A0C(e3);
                bitmapA01 = A03(str2);
            }
        } else {
            bitmapA01 = A03(str2);
        }
        String string = e3 != null ? e3.toString() : null;
        if (bitmapA01 == null) {
            T0.A03(t8, c1052Sv, str, T0.A03, string, null, null);
            return null;
        }
        long jA00 = A00(str2, bitmapA01);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jA00 > 0) {
            T0.A03(t8, c1052Sv, str, T0.A02, string, Long.valueOf(jA00), Long.valueOf(jCurrentTimeMillis2));
            return bitmapA01;
        }
        T0.A03(t8, c1052Sv, str, T0.A01, string, null, null);
        if (C1098Up.A11(t8)) {
            return null;
        }
        return bitmapA01;
    }

    public static String A08(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A03 = new byte[]{3, 4, 119, 41, 55, 62, 58, Ascii.EM, Ascii.FS, 88, Ascii.ETB, Ascii.CR, Ascii.FF, 8, Ascii.CR, Ascii.FF, 88, Ascii.FS, Ascii.GS, Ascii.VT, Ascii.FF, 17, Ascii.SYN, Ascii.EM, Ascii.FF, 17, Ascii.ETB, Ascii.SYN, 88, 80, Ascii.RS, 17, Ascii.DC4, Ascii.GS, 69, 122, 81, 76, 85, 89, 72, Ascii.CAN, 75, 81, 66, 93, Ascii.CAN, 93, 64, 91, 93, 93, 92, 75, Ascii.CAN, 85, 89, 64, Ascii.CAN, 75, 81, 66, 93, Ascii.CAN, 94, 87, 74, Ascii.CAN, 75, 76, 87, 74, 89, Framer.STDIN_REQUEST_FRAME_PREFIX, 93, 2, Ascii.CAN, Ascii.DC2, 48, Framer.STDERR_FRAME_PREFIX, 57, 52, 113, 52, 35, 35, 62, 35, Ascii.DEL, 113, 19, 56, 37, 60, 48, Framer.ENTER_FRAME_PREFIX, 113, 56, 34, 113, 63, 36, 61, 61, Ascii.DEL, 125, 90, 82, 87, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.ESC, 79, 84, Ascii.ESC, 88, 84, 75, 66, Ascii.ESC, 87, 84, 88, 90, 87, Ascii.ESC, 82, 86, 90, 92, 94, Ascii.ESC, 82, 85, 79, 84, Ascii.ESC, 88, 90, 88, 83, 94, Ascii.ESC, 19, 78, 73, 87, 6, 38, Ascii.GS, Ascii.DC2, 17, Ascii.US, Ascii.SYN, 83, 7, Ascii.FS, 83, 4, 1, Ascii.SUB, 7, Ascii.SYN, 83, 17, Ascii.SUB, 7, Ascii.RS, Ascii.DC2, 3, 83, 7, Ascii.FS, 83, Ascii.NAK, Ascii.SUB, Ascii.US, Ascii.SYN, 83, 91, 6, 1, Ascii.US, 78, 70, 125, 114, 113, Ascii.DEL, 118, 51, 103, 124, 51, 100, 97, 122, 103, 118, 51, 113, 122, 103, 126, 114, 99, 51, 103, 124, 51, 124, 102, 103, 99, 102, 103, 51, 96, 103, 97, 118, 114, 126, 102, 116, 116, 98, 115, 61, 40, 40, 40, 85, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, 86, 9, Ascii.FS, Ascii.FS, 82, 93, 88, 81, Ascii.SO, Ascii.ESC, Ascii.ESC, Ascii.ESC, 85, 90, 80, 70, 91, 93, 80, 107, 85, 71, 71, 81, 64, Ascii.ESC, 115, 119, 123, 125, Ascii.DEL, 10, 9, 7, 2, 42, Framer.STDOUT_FRAME_PREFIX, 52, Framer.STDOUT_FRAME_PREFIX, 48, 40, Framer.STDOUT_FRAME_PREFIX};
    }

    static {
        A09();
        A05 = C1055Sy.class.getSimpleName();
    }

    public C1055Sy(C1644ge c1644ge) {
        this.A00 = c1644ge;
    }

    private int A00(String str, Bitmap bitmap) {
        String strA08 = A08(0, 2, 105);
        if (bitmap == null) {
            A0C(null);
            return 0;
        }
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 26));
        ByteArrayOutputStream bOut = null;
        FileOutputStream fileOutputStream = null;
        try {
            bOut = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bOut);
            int size = bOut.size();
            if (size >= C1098Up.A0H(this.A00)) {
                A0C(new Throwable(A08(35, 42, 123) + size));
                return 0;
            }
            fileOutputStream = new FileOutputStream(file);
            bOut.writeTo(fileOutputStream);
            fileOutputStream.flush();
            return size;
        } catch (OutOfMemoryError e3) {
            A0C(e3);
            Log.e(A05, A08(184, 39, 80), e3);
            return 0;
        } catch (FileNotFoundException e4) {
            Log.e(A05, A08(6, 29, 59) + file.getPath() + strA08, e4);
            A0C(e4);
            return 0;
        } catch (IOException e5) {
            A0C(e5);
            Log.e(A05, A08(148, 36, 48) + str + strA08, e5);
            return 0;
        } finally {
            A0A(bOut);
            A0A(fileOutputStream);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.graphics.Bitmap A01(com.facebook.ads.redexgen.core.T8 r12, com.facebook.ads.redexgen.core.C1052Sv r13, int r14, int r15, java.lang.String r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1055Sy.A01(com.facebook.ads.redexgen.X.T8, com.facebook.ads.redexgen.X.Sv, int, int, java.lang.String):android.graphics.Bitmap");
    }

    private Bitmap A03(String str) {
        byte[] bArrA72;
        InterfaceC1598fu interfaceC1598fuAGw = C1617gD.A00(this.A00).AGw(str, new C1613g9());
        if (interfaceC1598fuAGw == null || (bArrA72 = interfaceC1598fuAGw.A72()) == null) {
            return null;
        }
        int length = bArrA72.length;
        if (A04[4].charAt(22) == 'U') {
            throw new RuntimeException();
        }
        A04[2] = "99IwdndnBnCK07hgvsXqxjXsnHcettbD";
        return BitmapFactory.decodeByteArray(bArrA72, 0, length);
    }

    private Bitmap A04(String str, int i3, int i4) {
        Bitmap bitmapDecodeStream;
        int iA00;
        try {
            boolean zA0D = A0D(i3, i4);
            String strA08 = A08(232, 7, 112);
            if (zA0D) {
                bitmapDecodeStream = T2.A02(str.substring(strA08.length()), i3, i4, this.A00);
            } else {
                bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring(strA08.length())), null, null);
            }
            iA00 = A00(str, bitmapDecodeStream);
        } catch (IOException e3) {
            Log.e(A05, A08(105, 43, 120) + str + A08(0, 2, 105), e3);
        }
        if (C1098Up.A11(this.A00) && iA00 <= 0) {
            return null;
        }
        return bitmapDecodeStream;
    }

    private Bitmap A05(String str, int i3, int i4) throws IOException {
        URL urlObj = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        Bitmap bitmapA01 = T2.A01(inputStream, i3, i4);
        A0A(inputStream);
        return bitmapA01;
    }

    public static C1055Sy A06(C1644ge c1644ge) {
        if (A06 == null) {
            synchronized (C1055Sy.class) {
                if (A06 == null) {
                    A06 = new C1055Sy(c1644ge);
                }
            }
        }
        return A06;
    }

    public static File A07(T8 t8) {
        return t8.getCacheDir();
    }

    public static void A0A(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(String str, Bitmap bitmap) {
        if (!this.A01.containsKey(str) && bitmap != null && bitmap.getHeight() > 0) {
            float width = bitmap.getWidth() / bitmap.getHeight();
            if (width > 0.0f) {
                this.A01.put(str, Float.valueOf(width));
            }
        }
    }

    private void A0C(Throwable th) {
        String strA08 = A08(261, 5, 89);
        if (th != null) {
            this.A00.A08().ABC(strA08, AbstractC1060Td.A1f, new C1061Te(th));
        } else {
            this.A00.A08().ABC(strA08, AbstractC1060Td.A1f, new C1061Te(A08(77, 28, 18)));
        }
    }

    private boolean A0D(int i3, int i4) {
        return i3 > 0 && i4 > 0;
    }

    public final float A0E(String str) {
        if (this.A01.containsKey(str) && this.A01.get(str) != null) {
            return this.A01.get(str).floatValue();
        }
        if (A04[6].length() == 28) {
            throw new RuntimeException();
        }
        A04[6] = "EtgkjkQAQYyyMgrrXA05VcKpExUV0Ywa";
        return -1.0f;
    }

    public final Bitmap A0F(C1052Sv c1052Sv) {
        return A01(this.A00, c1052Sv, c1052Sv.A05, c1052Sv.A04, c1052Sv.A02);
    }

    public final Bitmap A0G(T8 t8, String str, int i3, int i4, String str2) {
        C1052Sv c1052Sv = this.A02.get(str);
        return (!T0.A06(t8) || c1052Sv == null) ? A01(t8, new C1052Sv(str, i3, i4, A08(270, 7, 28), A08(270, 7, 28)), i4, i3, str2) : A01(t8, c1052Sv, i4, i3, str2);
    }

    public final File A0H(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 26));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String A0I(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 26));
        return file.exists() ? file.getPath() : str;
    }
}
