package ru.noties.markwon.image.data;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DataUriParser {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl extends DataUriParser {
        Impl() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
        @Override // ru.noties.markwon.image.data.DataUriParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ru.noties.markwon.image.data.DataUri b(java.lang.String r12) {
            /*
                r11 = this;
                r0 = 44
                int r0 = r12.indexOf(r0)
                r1 = 0
                if (r0 >= 0) goto La
                return r1
            La:
                r2 = 1
                r3 = 0
                if (r0 <= 0) goto L4c
                java.lang.String r4 = r12.substring(r3, r0)
                java.lang.String r5 = ";"
                java.lang.String[] r4 = r4.split(r5)
                int r5 = r4.length
                if (r5 <= 0) goto L4c
                r6 = -1
                r7 = 47
                r8 = 0
                java.lang.String r8 = androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN.iUmUPISJ
                if (r5 != r2) goto L35
                r4 = r4[r3]
                boolean r5 = r8.equals(r4)
                if (r5 == 0) goto L2e
                r4 = r1
                r3 = r2
                goto L4d
            L2e:
                int r5 = r4.indexOf(r7)
                if (r5 <= r6) goto L4c
                goto L4d
            L35:
                r9 = r4[r3]
                int r7 = r9.indexOf(r7)
                if (r7 <= r6) goto L40
                r3 = r4[r3]
                goto L41
            L40:
                r3 = r1
            L41:
                int r5 = r5 - r2
                r4 = r4[r5]
                boolean r4 = r8.equals(r4)
                r10 = r4
                r4 = r3
                r3 = r10
                goto L4d
            L4c:
                r4 = r1
            L4d:
                int r5 = r12.length()
                if (r0 >= r5) goto L6c
                int r0 = r0 + r2
                int r2 = r12.length()
                java.lang.String r12 = r12.substring(r0, r2)
                java.lang.String r0 = "\n"
                java.lang.String r2 = ""
                java.lang.String r12 = r12.replaceAll(r0, r2)
                int r0 = r12.length()
                if (r0 != 0) goto L6b
                goto L6c
            L6b:
                r1 = r12
            L6c:
                ru.noties.markwon.image.data.DataUri r12 = new ru.noties.markwon.image.data.DataUri
                r12.<init>(r4, r3, r1)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.image.data.DataUriParser.Impl.b(java.lang.String):ru.noties.markwon.image.data.DataUri");
        }
    }

    public static DataUriParser a() {
        return new Impl();
    }

    public abstract DataUri b(String str);
}
