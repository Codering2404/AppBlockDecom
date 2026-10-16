package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class TextFormatEscaper {

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.TextFormatEscaper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements ByteSequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f87132a;

        @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
        public byte a(int i3) {
            return this.f87132a[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
        public int size() {
            return this.f87132a.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ByteSequence {
        byte a(int i3);

        int size();
    }

    static String a(final ByteString byteString) {
        return b(new ByteSequence() { // from class: com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.1
            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            public byte a(int i3) {
                return byteString.e(i3);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return byteString.size();
            }
        });
    }

    static String b(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i3 = 0; i3 < byteSequence.size(); i3++) {
            byte bA = byteSequence.a(i3);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
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
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String c(String str) {
        return a(ByteString.s(str));
    }
}
