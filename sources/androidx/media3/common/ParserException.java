package androidx.media3.common;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ParserException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40938b;

    protected ParserException(String str, Throwable th, boolean z2, int i3) {
        super(str, th);
        this.f40937a = z2;
        this.f40938b = i3;
    }

    public static ParserException a(String str, Throwable th) {
        return new ParserException(str, th, true, 1);
    }

    public static ParserException b(String str, Throwable th) {
        return new ParserException(str, th, true, 0);
    }

    public static ParserException c(String str) {
        return new ParserException(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder();
        if (message != null) {
            str = message + " ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("{contentIsMalformed=");
        sb.append(this.f40937a);
        sb.append(", dataType=");
        sb.append(this.f40938b);
        sb.append("}");
        return sb.toString();
    }
}
