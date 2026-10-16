package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class StatusRunnable<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SettableFuture f55174a = SettableFuture.s();

    /* JADX INFO: renamed from: androidx.work.impl.utils.StatusRunnable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends StatusRunnable<List<WorkInfo>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f55175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f55176c;

        @Override // androidx.work.impl.utils.StatusRunnable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List d() {
            return (List) WorkSpec.f55012z.apply(this.f55175b.w().t().I(this.f55176c));
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.utils.StatusRunnable$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends StatusRunnable<WorkInfo> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f55177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UUID f55178c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.impl.utils.StatusRunnable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public WorkInfo d() {
            WorkSpec.WorkInfoPojo workInfoPojoJ = this.f55177b.w().t().j(this.f55178c.toString());
            if (workInfoPojoJ != null) {
                return workInfoPojoJ.e();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.utils.StatusRunnable$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 extends StatusRunnable<List<WorkInfo>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f55183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WorkQuery f55184c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.impl.utils.StatusRunnable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List d() {
            return (List) WorkSpec.f55012z.apply(this.f55183b.w().p().a(RawQueries.b(this.f55184c)));
        }
    }

    public static StatusRunnable a(final WorkManagerImpl workManagerImpl, final String str) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.work.impl.utils.StatusRunnable
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public List d() {
                return (List) WorkSpec.f55012z.apply(workManagerImpl.w().t().D(str));
            }
        };
    }

    public static StatusRunnable b(final WorkManagerImpl workManagerImpl, final String str) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.work.impl.utils.StatusRunnable
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public List d() {
                return (List) WorkSpec.f55012z.apply(workManagerImpl.w().t().p(str));
            }
        };
    }

    public ListenableFuture c() {
        return this.f55174a;
    }

    abstract Object d();

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f55174a.o(d());
        } catch (Throwable th) {
            this.f55174a.p(th);
        }
    }
}
