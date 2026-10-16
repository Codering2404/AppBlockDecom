package androidx.fragment.app;

import android.util.Log;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class LogWriter extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f37429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f37430b = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    LogWriter(String str) {
        this.f37429a = str;
    }

    private void a() {
        if (this.f37430b.length() > 0) {
            Log.d(this.f37429a, this.f37430b.toString());
            StringBuilder sb = this.f37430b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                a();
            } else {
                this.f37430b.append(c3);
            }
        }
    }
}
