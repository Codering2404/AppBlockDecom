package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AppUpdateOptions {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract AppUpdateOptions a();

        public abstract Builder b(boolean z2);
    }

    public static AppUpdateOptions c(int i3) {
        return d(i3).a();
    }

    public static Builder d(int i3) {
        zzv zzvVar = new zzv();
        zzvVar.c(i3);
        zzvVar.b(false);
        return zzvVar;
    }

    public abstract boolean a();

    public abstract int b();
}
