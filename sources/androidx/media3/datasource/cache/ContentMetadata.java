package androidx.media3.datasource.cache;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ContentMetadata {
    static long b(ContentMetadata contentMetadata) {
        return contentMetadata.a("exo_len", -1L);
    }

    static Uri d(ContentMetadata contentMetadata) {
        String strC = contentMetadata.c("exo_redir", null);
        if (strC == null) {
            return null;
        }
        return Uri.parse(strC);
    }

    long a(String str, long j3);

    String c(String str, String str2);
}
