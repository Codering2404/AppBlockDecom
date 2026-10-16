package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ExtensionRegistryLite f36284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final ExtensionRegistryLite f36285c = new ExtensionRegistryLite(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f36286a = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExtensionClassHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Class f36287a = a();

        static Class a() {
            try {
                return Class.forName("androidx.datastore.preferences.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ObjectIntPair {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f36288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36289b;

        ObjectIntPair(Object obj, int i3) {
            this.f36288a = obj;
            this.f36289b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.f36288a == objectIntPair.f36288a && this.f36289b == objectIntPair.f36289b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f36288a) * 65535) + this.f36289b;
        }
    }

    ExtensionRegistryLite(boolean z2) {
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite extensionRegistryLiteA;
        if (Protobuf.f36554d) {
            return f36285c;
        }
        ExtensionRegistryLite extensionRegistryLite = f36284b;
        if (extensionRegistryLite != null) {
            return extensionRegistryLite;
        }
        synchronized (ExtensionRegistryLite.class) {
            try {
                extensionRegistryLiteA = f36284b;
                if (extensionRegistryLiteA == null) {
                    extensionRegistryLiteA = ExtensionRegistryFactory.a();
                    f36284b = extensionRegistryLiteA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return extensionRegistryLiteA;
    }

    public GeneratedMessageLite.GeneratedExtension a(MessageLite messageLite, int i3) {
        return (GeneratedMessageLite.GeneratedExtension) this.f36286a.get(new ObjectIntPair(messageLite, i3));
    }
}
