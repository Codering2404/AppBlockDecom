package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LiveDataUtils {

    /* JADX INFO: renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Observer<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f55153a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskExecutor f55154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f55155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function f55156d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f55157f;

        AnonymousClass1(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.f55154b = taskExecutor;
            this.f55155c = obj;
            this.f55156d = function;
            this.f55157f = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void a(final Object obj) {
            this.f55154b.d(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnonymousClass1.this.f55155c) {
                        try {
                            Object objApply = AnonymousClass1.this.f55156d.apply(obj);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Object obj2 = anonymousClass1.f55153a;
                            if (obj2 == null && objApply != null) {
                                anonymousClass1.f55153a = objApply;
                                anonymousClass1.f55157f.n(objApply);
                            } else if (obj2 != null && !obj2.equals(objApply)) {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                anonymousClass12.f55153a = objApply;
                                anonymousClass12.f55157f.n(objApply);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
    }

    public static LiveData a(LiveData liveData, Function function, TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.q(liveData, new AnonymousClass1(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }
}
