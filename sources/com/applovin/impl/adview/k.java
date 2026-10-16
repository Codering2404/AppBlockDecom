package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.applovin.impl.da;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final da f58363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f58364b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface a {
        void a();

        void onFailure();
    }

    public k(da daVar, Context context) {
        super(context);
        this.f58363a = daVar;
        setClickable(false);
        setFocusable(false);
    }

    public boolean a() {
        return this.f58364b;
    }

    public void b() {
        a(null);
    }

    public String getIdentifier() {
        return this.f58363a.b();
    }

    public void a(a aVar) {
        if (this.f58364b) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        Drawable drawableA = this.f58363a.a();
        if (drawableA == null) {
            if (aVar != null) {
                aVar.onFailure();
            }
        } else {
            setBackground(drawableA);
            this.f58364b = true;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
