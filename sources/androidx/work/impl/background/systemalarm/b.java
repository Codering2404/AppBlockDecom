package androidx.work.impl.background.systemalarm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f54834a;

    public /* synthetic */ b(DelayMetCommandHandler delayMetCommandHandler) {
        this.f54834a = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f54834a.h();
    }
}
