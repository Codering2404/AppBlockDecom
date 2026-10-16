package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FontRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f34194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f34195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f34196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f34197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f34198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f34199f;

    public FontRequest(String str, String str2, String str3, List list) {
        this.f34194a = (String) Preconditions.h(str);
        this.f34195b = (String) Preconditions.h(str2);
        this.f34196c = (String) Preconditions.h(str3);
        this.f34197d = (List) Preconditions.h(list);
        this.f34198e = 0;
        this.f34199f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f34197d;
    }

    public int c() {
        return this.f34198e;
    }

    String d() {
        return this.f34199f;
    }

    public String e() {
        return this.f34194a;
    }

    public String f() {
        return this.f34195b;
    }

    public String g() {
        return this.f34196c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f34194a + ", mProviderPackage: " + this.f34195b + ", mQuery: " + this.f34196c + ", mCertificates:");
        for (int i3 = 0; i3 < this.f34197d.size(); i3++) {
            sb.append(" [");
            List list = (List) this.f34197d.get(i3);
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i4), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f34198e);
        return sb.toString();
    }

    public FontRequest(String str, String str2, String str3, int i3) {
        this.f34194a = (String) Preconditions.h(str);
        this.f34195b = (String) Preconditions.h(str2);
        this.f34196c = (String) Preconditions.h(str3);
        this.f34197d = null;
        Preconditions.a(i3 != 0);
        this.f34198e = i3;
        this.f34199f = a(str, str2, str3);
    }
}
