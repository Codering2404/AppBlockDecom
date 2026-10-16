package com.google.common.reflect;

import com.google.common.base.Splitter;
import java.io.File;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ClassPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f85531a = Logger.getLogger(ClassPath.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Splitter f85532b = Splitter.h(" ").e();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ClassInfo extends ResourceInfo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f85533c;

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.f85533c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LocationInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final File f85534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ClassLoader f85535b;

        public boolean equals(Object obj) {
            if (obj instanceof LocationInfo) {
                LocationInfo locationInfo = (LocationInfo) obj;
                if (this.f85534a.equals(locationInfo.f85534a) && this.f85535b.equals(locationInfo.f85535b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f85534a.hashCode();
        }

        public String toString() {
            return this.f85534a.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ResourceInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f85536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ClassLoader f85537b;

        public boolean equals(Object obj) {
            if (obj instanceof ResourceInfo) {
                ResourceInfo resourceInfo = (ResourceInfo) obj;
                if (this.f85536a.equals(resourceInfo.f85536a) && this.f85537b == resourceInfo.f85537b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f85536a.hashCode();
        }

        public String toString() {
            return this.f85536a;
        }
    }
}
