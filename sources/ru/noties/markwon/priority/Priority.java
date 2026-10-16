package ru.noties.markwon.priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Priority {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Builder {
        Builder a(Class cls);

        Priority build();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl extends Priority {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f147390a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class BuilderImpl implements Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f147391a = new ArrayList(0);

            BuilderImpl() {
            }

            @Override // ru.noties.markwon.priority.Priority.Builder
            public Builder a(Class cls) {
                this.f147391a.add(cls);
                return this;
            }

            @Override // ru.noties.markwon.priority.Priority.Builder
            public Priority build() {
                return new Impl(Collections.unmodifiableList(this.f147391a));
            }
        }

        Impl(List list) {
            this.f147390a = list;
        }

        @Override // ru.noties.markwon.priority.Priority
        public List a() {
            return this.f147390a;
        }

        public String toString() {
            return "Priority{after=" + this.f147390a + '}';
        }
    }

    public static Priority b(Class cls) {
        return c().a(cls).build();
    }

    public static Builder c() {
        return new Impl.BuilderImpl();
    }

    public static Priority d() {
        return c().build();
    }

    public abstract List a();
}
