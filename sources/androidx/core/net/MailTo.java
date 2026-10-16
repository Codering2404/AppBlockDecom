package androidx.core.net;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MailTo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f34134a;

    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append('?');
        for (Map.Entry entry : this.f34134a.entrySet()) {
            sb.append(Uri.encode((String) entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode((String) entry.getValue()));
            sb.append('&');
        }
        return sb.toString();
    }
}
