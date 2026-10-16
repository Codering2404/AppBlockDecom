package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ContentResolverCompat {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) throws Exception {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (Exception e3) {
            if (e3 instanceof OperationCanceledException) {
                throw new androidx.core.os.OperationCanceledException();
            }
            throw e3;
        }
    }

    public static Cursor b(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, androidx.core.os.CancellationSignal cancellationSignal) {
        return a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal != null ? (CancellationSignal) cancellationSignal.b() : null);
    }
}
