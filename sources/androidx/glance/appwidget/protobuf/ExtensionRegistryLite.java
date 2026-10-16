package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f38941b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExtensionRegistryLite f38942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ExtensionRegistryLite f38943d = new ExtensionRegistryLite(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f38944a = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExtensionClassHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Class f38945a = a();

        static Class a() {
            try {
                return Class.forName("androidx.glance.appwidget.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ObjectIntPair {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f38946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38947b;

        ObjectIntPair(Object obj, int i3) {
            this.f38946a = obj;
            this.f38947b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.f38946a == objectIntPair.f38946a && this.f38947b == objectIntPair.f38947b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f38946a) * 65535) + this.f38947b;
        }
    }

    ExtensionRegistryLite(boolean z2) {
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite extensionRegistryLiteA;
        ExtensionRegistryLite extensionRegistryLite = f38942c;
        if (extensionRegistryLite != null) {
            return extensionRegistryLite;
        }
        synchronized (ExtensionRegistryLite.class) {
            try {
                extensionRegistryLiteA = f38942c;
                if (extensionRegistryLiteA == null) {
                    extensionRegistryLiteA = f38941b ? ExtensionRegistryFactory.a() : f38943d;
                    f38942c = extensionRegistryLiteA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return extensionRegistryLiteA;
    }

    public GeneratedMessageLite.GeneratedExtension a(MessageLite messageLite, int i3) {
        return (GeneratedMessageLite.GeneratedExtension) this.f38944a.get(new ObjectIntPair(messageLite, i3));
    }
}
