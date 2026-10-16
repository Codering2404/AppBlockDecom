package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnSwipe f31505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private KeyFrames f31511g;

    public String toString() {
        String str = this.f31506b + ":{\nfrom:'" + this.f31508d + "',\nto:'" + this.f31507c + "',\n";
        if (this.f31509e != 400) {
            str = str + "duration:" + this.f31509e + ",\n";
        }
        if (this.f31510f != 0.0f) {
            str = str + "stagger:" + this.f31510f + ",\n";
        }
        if (this.f31505a != null) {
            str = str + this.f31505a.toString();
        }
        return (str + this.f31511g.toString()) + "},\n";
    }
}
