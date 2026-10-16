package androidx.webkit;

import com.facebook.internal.AnalyticsEvents;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WebMessageCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebMessagePortCompat[] f53909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f53911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f53912d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.f53910b = str;
        this.f53911c = null;
        this.f53909a = webMessagePortCompatArr;
        this.f53912d = 0;
    }

    private void a(int i3) {
        if (i3 == this.f53912d) {
            return;
        }
        throw new IllegalStateException("Wrong data accessor type detected. " + f(this.f53912d) + " expected, but got " + f(i3));
    }

    private String f(int i3) {
        return i3 != 0 ? i3 != 1 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "ArrayBuffer" : "String";
    }

    public byte[] b() {
        a(1);
        Objects.requireNonNull(this.f53911c);
        return this.f53911c;
    }

    public String c() {
        a(0);
        return this.f53910b;
    }

    public WebMessagePortCompat[] d() {
        return this.f53909a;
    }

    public int e() {
        return this.f53912d;
    }

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.f53911c = bArr;
        this.f53910b = null;
        this.f53909a = webMessagePortCompatArr;
        this.f53912d = 1;
    }
}
