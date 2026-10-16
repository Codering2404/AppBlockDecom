package com.google.firebase.crashlytics.internal.common;

import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class NativeSessionFileGzipper {
    private static void a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i3 = inputStream.read(bArr);
                    if (i3 <= 0) {
                        gZIPOutputStream2.finish();
                        CommonUtils.g(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i3);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    CommonUtils.g(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static void b(File file, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NativeSessionFile nativeSessionFile = (NativeSessionFile) it.next();
            InputStream inputStreamI = null;
            try {
                inputStreamI = nativeSessionFile.i();
                if (inputStreamI != null) {
                    a(inputStreamI, new File(file, nativeSessionFile.b()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                CommonUtils.g(null);
                throw th;
            }
            CommonUtils.g(inputStreamI);
        }
    }
}
