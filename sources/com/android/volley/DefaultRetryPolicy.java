package com.android.volley;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultRetryPolicy implements RetryPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f57659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f57660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f57661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f57662d;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    @Override // com.android.volley.RetryPolicy
    public int a() {
        return this.f57660b;
    }

    @Override // com.android.volley.RetryPolicy
    public void b(VolleyError volleyError) throws VolleyError {
        this.f57660b++;
        int i3 = this.f57659a;
        this.f57659a = i3 + ((int) (i3 * this.f57662d));
        if (!d()) {
            throw volleyError;
        }
    }

    @Override // com.android.volley.RetryPolicy
    public int c() {
        return this.f57659a;
    }

    protected boolean d() {
        return this.f57660b <= this.f57661c;
    }

    public DefaultRetryPolicy(int i3, int i4, float f3) {
        this.f57659a = i3;
        this.f57661c = i4;
        this.f57662d = f3;
    }
}
