package androidx.media3.common.util;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface BitmapLoader {
    boolean a(String str);

    ListenableFuture b(Uri uri);
}
