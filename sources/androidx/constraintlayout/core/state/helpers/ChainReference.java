package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChainReference extends HelperReference {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected float f32177q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    protected HashMap f32178r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected HashMap f32179s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    protected HashMap f32180t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private HashMap f32181u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private HashMap f32182v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected State.Chain f32183w0;

    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
        this.f32177q0 = 0.5f;
        this.f32178r0 = new HashMap();
        this.f32179s0 = new HashMap();
        this.f32180t0 = new HashMap();
        this.f32183w0 = State.Chain.SPREAD;
    }

    float A0(String str) {
        HashMap map = this.f32181u0;
        if (map == null || !map.containsKey(str)) {
            return 0.0f;
        }
        return ((Float) this.f32181u0.get(str)).floatValue();
    }

    protected float B0(String str) {
        if (this.f32179s0.containsKey(str)) {
            return ((Float) this.f32179s0.get(str)).floatValue();
        }
        return 0.0f;
    }

    protected float C0(String str) {
        if (this.f32178r0.containsKey(str)) {
            return ((Float) this.f32178r0.get(str)).floatValue();
        }
        return -1.0f;
    }

    public ChainReference D0(State.Chain chain) {
        this.f32183w0 = chain;
        return this;
    }

    public void w0(Object obj, float f3, float f4, float f5, float f6, float f7) {
        super.s0(obj);
        String string = obj.toString();
        if (!Float.isNaN(f3)) {
            this.f32178r0.put(string, Float.valueOf(f3));
        }
        if (!Float.isNaN(f4)) {
            this.f32179s0.put(string, Float.valueOf(f4));
        }
        if (!Float.isNaN(f5)) {
            this.f32180t0.put(string, Float.valueOf(f5));
        }
        if (!Float.isNaN(f6)) {
            if (this.f32181u0 == null) {
                this.f32181u0 = new HashMap();
            }
            this.f32181u0.put(string, Float.valueOf(f6));
        }
        if (Float.isNaN(f7)) {
            return;
        }
        if (this.f32182v0 == null) {
            this.f32182v0 = new HashMap();
        }
        this.f32182v0.put(string, Float.valueOf(f7));
    }

    public ChainReference x0(float f3) {
        this.f32177q0 = f3;
        return this;
    }

    float y0(String str) {
        HashMap map = this.f32182v0;
        if (map == null || !map.containsKey(str)) {
            return 0.0f;
        }
        return ((Float) this.f32182v0.get(str)).floatValue();
    }

    protected float z0(String str) {
        if (this.f32180t0.containsKey(str)) {
            return ((Float) this.f32180t0.get(str)).floatValue();
        }
        return 0.0f;
    }
}
