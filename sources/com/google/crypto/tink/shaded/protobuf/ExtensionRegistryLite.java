package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ExtensionRegistryLite {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f86802b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExtensionRegistryLite f86803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ExtensionRegistryLite f86804d = new ExtensionRegistryLite(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f86805a = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExtensionClassHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Class f86806a = a();

        static Class a() {
            try {
                return Class.forName("com.google.crypto.tink.shaded.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ObjectIntPair {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f86807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f86808b;

        ObjectIntPair(Object obj, int i3) {
            this.f86807a = obj;
            this.f86808b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.f86807a == objectIntPair.f86807a && this.f86808b == objectIntPair.f86808b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f86807a) * 65535) + this.f86808b;
        }
    }

    ExtensionRegistryLite(boolean z2) {
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite extensionRegistryLiteA;
        ExtensionRegistryLite extensionRegistryLite = f86803c;
        if (extensionRegistryLite != null) {
            return extensionRegistryLite;
        }
        synchronized (ExtensionRegistryLite.class) {
            try {
                extensionRegistryLiteA = f86803c;
                if (extensionRegistryLiteA == null) {
                    extensionRegistryLiteA = f86802b ? ExtensionRegistryFactory.a() : f86804d;
                    f86803c = extensionRegistryLiteA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return extensionRegistryLiteA;
    }

    public GeneratedMessageLite.GeneratedExtension a(MessageLite messageLite, int i3) {
        return (GeneratedMessageLite.GeneratedExtension) this.f86805a.get(new ObjectIntPair(messageLite, i3));
    }
}
