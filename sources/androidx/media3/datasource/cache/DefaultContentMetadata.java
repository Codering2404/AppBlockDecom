package androidx.media3.datasource.cache;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultContentMetadata implements ContentMetadata {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DefaultContentMetadata f42097c = new DefaultContentMetadata(Collections.EMPTY_MAP);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f42098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f42099b;

    public DefaultContentMetadata(Map map) {
        this.f42099b = Collections.unmodifiableMap(map);
    }

    private static void e(HashMap map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            map.put((String) entry.getKey(), i(entry.getValue()));
        }
    }

    private static Map f(Map map, ContentMetadataMutations contentMetadataMutations) {
        HashMap map2 = new HashMap(map);
        k(map2, contentMetadataMutations.c());
        e(map2, contentMetadataMutations.b());
        return map2;
    }

    private static byte[] i(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(StandardCharsets.UTF_8);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean j(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void k(HashMap map, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            map.remove(list.get(i3));
        }
    }

    @Override // androidx.media3.datasource.cache.ContentMetadata
    public final long a(String str, long j3) {
        byte[] bArr = (byte[]) this.f42099b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j3;
    }

    @Override // androidx.media3.datasource.cache.ContentMetadata
    public final String c(String str, String str2) {
        byte[] bArr = (byte[]) this.f42099b.get(str);
        return bArr != null ? new String(bArr, StandardCharsets.UTF_8) : str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return j(this.f42099b, ((DefaultContentMetadata) obj).f42099b);
    }

    public DefaultContentMetadata g(ContentMetadataMutations contentMetadataMutations) {
        Map mapF = f(this.f42099b, contentMetadataMutations);
        return j(this.f42099b, mapF) ? this : new DefaultContentMetadata(mapF);
    }

    public Set h() {
        return this.f42099b.entrySet();
    }

    public int hashCode() {
        if (this.f42098a == 0) {
            int iHashCode = 0;
            for (Map.Entry entry : this.f42099b.entrySet()) {
                iHashCode += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f42098a = iHashCode;
        }
        return this.f42098a;
    }
}
