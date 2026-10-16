package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DetectionResultColumn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Codeword[] f91991a;

    final Codeword[] a() {
        return this.f91991a;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i3 = 0;
            for (Codeword codeword : this.f91991a) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i3));
                    i3++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i3), Integer.valueOf(codeword.a()), Integer.valueOf(codeword.b()));
                    i3++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
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
}
