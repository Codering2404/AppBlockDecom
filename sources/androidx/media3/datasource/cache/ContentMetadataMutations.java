package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ContentMetadataMutations {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f42095a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f42096b = new ArrayList();

    private ContentMetadataMutations a(String str, Object obj) {
        this.f42095a.put((String) Assertions.e(str), Assertions.e(obj));
        this.f42096b.remove(str);
        return this;
    }

    public static ContentMetadataMutations g(ContentMetadataMutations contentMetadataMutations, long j3) {
        return contentMetadataMutations.e("exo_len", j3);
    }

    public static ContentMetadataMutations h(ContentMetadataMutations contentMetadataMutations, Uri uri) {
        return uri == null ? contentMetadataMutations.d("exo_redir") : contentMetadataMutations.f("exo_redir", uri.toString());
    }

    public Map b() {
        HashMap map = new HashMap(this.f42095a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public List c() {
        return Collections.unmodifiableList(new ArrayList(this.f42096b));
    }

    public ContentMetadataMutations d(String str) {
        this.f42096b.add(str);
        this.f42095a.remove(str);
        return this;
    }

    public ContentMetadataMutations e(String str, long j3) {
        return a(str, Long.valueOf(j3));
    }

    public ContentMetadataMutations f(String str, String str2) {
        return a(str, str2);
    }
}
