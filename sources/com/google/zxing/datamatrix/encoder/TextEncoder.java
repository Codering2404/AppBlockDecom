package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class TextEncoder extends C40Encoder {
    TextEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int c(char c3, StringBuilder sb) {
        if (c3 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c3 >= '0' && c3 <= '9') {
            sb.append((char) (c3 - ','));
            return 1;
        }
        if (c3 >= 'a' && c3 <= 'z') {
            sb.append((char) (c3 - 'S'));
            return 1;
        }
        if (c3 < ' ') {
            sb.append((char) 0);
            sb.append(c3);
            return 2;
        }
        if (c3 >= '!' && c3 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c3 - '!'));
            return 2;
        }
        if (c3 >= ':' && c3 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c3 - '+'));
            return 2;
        }
        if (c3 >= '[' && c3 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c3 - 'E'));
            return 2;
        }
        if (c3 == '`') {
            sb.append((char) 2);
            sb.append((char) (c3 - '`'));
            return 2;
        }
        if (c3 >= 'A' && c3 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) (c3 - '@'));
            return 2;
        }
        if (c3 < '{' || c3 > 127) {
            sb.append("\u0001\u001e");
            return c((char) (c3 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c3 - '`'));
        return 2;
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int e() {
        return 2;
    }
}
