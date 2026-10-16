package com.facebook.stetho.common;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProcessUtil {
    private static final int CMDLINE_BUFFER_SIZE = 64;
    private static String sProcessName;
    private static boolean sProcessNameRead;

    @Nullable
    public static synchronized String getProcessName() {
        if (!sProcessNameRead) {
            sProcessNameRead = true;
            try {
                sProcessName = readProcessName();
            } catch (IOException unused) {
            }
        }
        return sProcessName;
    }

    private static int indexOf(byte[] bArr, int i3, int i4, byte b3) {
        for (int i5 = 0; i5 < bArr.length; i5++) {
            if (bArr[i5] == b3) {
                return i5;
            }
        }
        return -1;
    }

    private static String readProcessName() throws Throwable {
        byte[] bArr = new byte[64];
        FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
        boolean z2 = false;
        try {
            int i3 = fileInputStream.read(bArr);
            try {
                int iIndexOf = indexOf(bArr, 0, i3, (byte) 0);
                if (iIndexOf > 0) {
                    i3 = iIndexOf;
                }
                String str = new String(bArr, 0, i3);
                Util.close(fileInputStream, false);
                return str;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                Util.close(fileInputStream, true ^ z2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
