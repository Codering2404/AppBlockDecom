package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: com.google.common.base.Optional$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Iterable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f83331a;

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return new AbstractIterator<Object>() { // from class: com.google.common.base.Optional.1.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final Iterator f83332c;

                {
                    this.f83332c = (Iterator) Preconditions.t(AnonymousClass1.this.f83331a.iterator());
                }

                @Override // com.google.common.base.AbstractIterator
                protected Object a() {
                    while (this.f83332c.hasNext()) {
                        Optional optional = (Optional) this.f83332c.next();
                        if (optional.c()) {
                            return optional.b();
                        }
                    }
                    return b();
                }
            };
        }
    }

    Optional() {
    }

    public static Optional a() {
        return Absent.g();
    }

    public static Optional d(Object obj) {
        return new Present(Preconditions.t(obj));
    }

    public abstract Object b();

    public abstract boolean c();

    public abstract Object e(Object obj);

    public abstract Object f();
}
