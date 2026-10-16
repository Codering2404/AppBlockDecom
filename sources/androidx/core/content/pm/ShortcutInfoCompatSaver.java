package androidx.core.content.pm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ShortcutInfoCompatSaver<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Void a(List list) {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void c() {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Void d(List list) {
            return null;
        }
    }

    public abstract Object a(List list);

    public List b() {
        return new ArrayList();
    }

    public abstract Object c();

    public abstract Object d(List list);
}
