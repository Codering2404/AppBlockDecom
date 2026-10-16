package androidx.work;

import android.net.Network;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkerParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UUID f54606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Data f54607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f54608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RuntimeExtras f54609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f54610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Executor f54611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TaskExecutor f54612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WorkerFactory f54613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ProgressUpdater f54614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ForegroundUpdater f54615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f54616k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RuntimeExtras {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f54617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f54618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Network f54619c;

        public RuntimeExtras() {
            List list = Collections.EMPTY_LIST;
            this.f54617a = list;
            this.f54618b = list;
        }
    }

    public WorkerParameters(UUID uuid, Data data, Collection collection, RuntimeExtras runtimeExtras, int i3, int i4, Executor executor, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.f54606a = uuid;
        this.f54607b = data;
        this.f54608c = new HashSet(collection);
        this.f54609d = runtimeExtras;
        this.f54610e = i3;
        this.f54616k = i4;
        this.f54611f = executor;
        this.f54612g = taskExecutor;
        this.f54613h = workerFactory;
        this.f54614i = progressUpdater;
        this.f54615j = foregroundUpdater;
    }

    public Executor a() {
        return this.f54611f;
    }

    public ForegroundUpdater b() {
        return this.f54615j;
    }

    public UUID c() {
        return this.f54606a;
    }

    public Data d() {
        return this.f54607b;
    }

    public Network e() {
        return this.f54609d.f54619c;
    }

    public ProgressUpdater f() {
        return this.f54614i;
    }

    public int g() {
        return this.f54610e;
    }

    public Set h() {
        return this.f54608c;
    }

    public TaskExecutor i() {
        return this.f54612g;
    }

    public List j() {
        return this.f54609d.f54617a;
    }

    public List k() {
        return this.f54609d.f54618b;
    }

    public WorkerFactory l() {
        return this.f54613h;
    }
}
