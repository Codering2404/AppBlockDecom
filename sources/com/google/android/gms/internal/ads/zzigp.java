package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigp {
    static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b3 : bArr) {
            if (b3 == 34) {
                sb.append("\\\"");
            } else if (b3 == 39) {
                sb.append("\\'");
            } else if (b3 != 92) {
                switch (b3) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b3 < 32 || b3 > 126) {
                            sb.append('\\');
                            sb.append((char) (((b3 >>> 6) & 3) + 48));
                            sb.append((char) (((b3 >>> 3) & 7) + 48));
                            sb.append((char) ((b3 & 7) + 48));
                        } else {
                            sb.append((char) b3);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
