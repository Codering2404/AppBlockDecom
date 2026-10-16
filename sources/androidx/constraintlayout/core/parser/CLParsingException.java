package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLParsingException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f31925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f31927c;

    public CLParsingException(String str, CLElement cLElement) {
        super(str);
        this.f31925a = str;
        if (cLElement != null) {
            this.f31927c = cLElement.q();
            this.f31926b = cLElement.p();
        } else {
            this.f31927c = "unknown";
            this.f31926b = 0;
        }
    }

    public String a() {
        return this.f31925a + " (" + this.f31927c + " at line " + this.f31926b + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + a();
    }
}
