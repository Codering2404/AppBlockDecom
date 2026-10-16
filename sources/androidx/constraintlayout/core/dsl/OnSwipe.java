package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class OnSwipe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drag f31451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Side f31452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TouchUp f31455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f31456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Boundary f31465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Mode f31466p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Boundary {
        OVERSHOOT,
        BOUNCE_START,
        BOUNCE_END,
        BOUNCE_BOTH
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Drag {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        START,
        END,
        CLOCKWISE,
        ANTICLOCKWISE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Mode {
        VELOCITY,
        SPRING
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Side {
        TOP,
        LEFT,
        RIGHT,
        BOTTOM,
        MIDDLE,
        START,
        END
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TouchUp {
        AUTOCOMPLETE,
        TO_START,
        NEVER_COMPLETE_END,
        TO_END,
        STOP,
        DECELERATE,
        DECELERATE_COMPLETE,
        NEVER_COMPLETE_START
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnSwipe:{\n");
        if (this.f31453c != null) {
            sb.append("anchor:'");
            sb.append(this.f31453c);
            sb.append("',\n");
        }
        if (this.f31451a != null) {
            sb.append("direction:'");
            sb.append(this.f31451a.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.f31452b != null) {
            sb.append("side:'");
            sb.append(this.f31452b.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31459i)) {
            sb.append("scale:'");
            sb.append(this.f31459i);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31460j)) {
            sb.append("threshold:'");
            sb.append(this.f31460j);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31457g)) {
            sb.append("maxVelocity:'");
            sb.append(this.f31457g);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31458h)) {
            sb.append("maxAccel:'");
            sb.append(this.f31458h);
            sb.append("',\n");
        }
        if (this.f31454d != null) {
            sb.append("limitBounds:'");
            sb.append(this.f31454d);
            sb.append("',\n");
        }
        if (this.f31466p != null) {
            sb.append("mode:'");
            sb.append(this.f31466p.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.f31455e != null) {
            sb.append("touchUp:'");
            sb.append(this.f31455e.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31462l)) {
            sb.append("springMass:'");
            sb.append(this.f31462l);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31463m)) {
            sb.append("springStiffness:'");
            sb.append(this.f31463m);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31461k)) {
            sb.append("springDamping:'");
            sb.append(this.f31461k);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31464n)) {
            sb.append("stopThreshold:'");
            sb.append(this.f31464n);
            sb.append("',\n");
        }
        if (this.f31465o != null) {
            sb.append("springBoundary:'");
            sb.append(this.f31465o);
            sb.append("',\n");
        }
        if (this.f31456f != null) {
            sb.append("around:'");
            sb.append(this.f31456f);
            sb.append("',\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
