package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f58335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f58336b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2),
        TRANSPARENT_SKIP(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f58342a;

        a(int i3) {
            this.f58342a = i3;
        }

        public int b() {
            return this.f58342a;
        }
    }

    protected e(Context context) {
        super(context);
        this.f58335a = 1.0f;
        this.f58336b = context;
    }

    public void a(int i3) {
        setViewScale(i3 / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public float getSize() {
        return this.f58335a * 30.0f;
    }

    public abstract a getStyle();

    public void setViewScale(float f3) {
        this.f58335a = f3;
    }

    public static e a(a aVar, Context context) {
        if (aVar.equals(a.INVISIBLE)) {
            return new h(context);
        }
        if (aVar.equals(a.WHITE_ON_TRANSPARENT)) {
            return new i(context);
        }
        if (aVar.equals(a.TRANSPARENT_SKIP)) {
            return new j(context);
        }
        return new n(context);
    }
}
