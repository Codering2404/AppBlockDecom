package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class DetectionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DetectionResultColumn[] f91989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91990b;

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.f91989a;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.f91990b + 1];
        }
        Formatter formatter = new Formatter();
        for (int i3 = 0; i3 < detectionResultColumn.a().length; i3++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i3));
                for (int i4 = 0; i4 < this.f91990b + 2; i4++) {
                    DetectionResultColumn detectionResultColumn2 = this.f91989a[i4];
                    if (detectionResultColumn2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        Codeword codeword = detectionResultColumn2.a()[i3];
                        if (codeword == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(codeword.a()), Integer.valueOf(codeword.b()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
