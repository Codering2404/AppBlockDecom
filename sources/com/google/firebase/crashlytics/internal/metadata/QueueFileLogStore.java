package com.google.firebase.crashlytics.internal.metadata;

import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.metadata.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class QueueFileLogStore implements FileLogStore {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f88541d = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f88542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private QueueFile f88544c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LogBytes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f88548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f88549b;

        LogBytes(byte[] bArr, int i3) {
            this.f88548a = bArr;
            this.f88549b = i3;
        }
    }

    QueueFileLogStore(File file, int i3) {
        this.f88542a = file;
        this.f88543b = i3;
    }

    private void f(long j3, String str) {
        if (this.f88544c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i3 = this.f88543b / 4;
            if (str.length() > i3) {
                str = "..." + str.substring(str.length() - i3);
            }
            this.f88544c.i(String.format(Locale.US, "%d %s%n", Long.valueOf(j3), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f88541d));
            while (!this.f88544c.r() && this.f88544c.V() > this.f88543b) {
                this.f88544c.M();
            }
        } catch (IOException e3) {
            Logger.f().e("There was a problem writing to the Crashlytics log.", e3);
        }
    }

    private LogBytes g() {
        if (!this.f88542a.exists()) {
            return null;
        }
        h();
        QueueFile queueFile = this.f88544c;
        if (queueFile == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[queueFile.V()];
        try {
            this.f88544c.m(new QueueFile.ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.1
                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void a(InputStream inputStream, int i3) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i3);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i3;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e3) {
            Logger.f().e("A problem occurred while reading the Crashlytics log file.", e3);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void h() {
        if (this.f88544c == null) {
            try {
                this.f88544c = new QueueFile(this.f88542a);
            } catch (IOException e3) {
                Logger.f().e("Could not open log file: " + this.f88542a, e3);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void a() {
        CommonUtils.f(this.f88544c, "There was a problem closing the Crashlytics log file.");
        this.f88544c = null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f88541d);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public byte[] c() {
        LogBytes logBytesG = g();
        if (logBytesG == null) {
            return null;
        }
        int i3 = logBytesG.f88549b;
        byte[] bArr = new byte[i3];
        System.arraycopy(logBytesG.f88548a, 0, bArr, 0, i3);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void d() {
        a();
        this.f88542a.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void e(long j3, String str) {
        h();
        f(j3, str);
    }
}
