package ru.noties.markwon.utils;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Dip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f147397a;

    public Dip(float f3) {
        this.f147397a = f3;
    }

    public static Dip a(Context context) {
        return new Dip(context.getResources().getDisplayMetrics().density);
    }

    public int b(int i3) {
        return (int) ((i3 * this.f147397a) + 0.5f);
    }
}
