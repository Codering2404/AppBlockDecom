package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FieldDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89131b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f89132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f89133b = null;

        Builder(String str) {
            this.f89132a = str;
        }

        public FieldDescriptor a() {
            return new FieldDescriptor(this.f89132a, this.f89133b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(this.f89133b)));
        }

        public Builder b(Annotation annotation) {
            if (this.f89133b == null) {
                this.f89133b = new HashMap();
            }
            this.f89133b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static Builder a(String str) {
        return new Builder(str);
    }

    public static FieldDescriptor d(String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f89130a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f89131b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.f89130a.equals(fieldDescriptor.f89130a) && this.f89131b.equals(fieldDescriptor.f89131b);
    }

    public int hashCode() {
        return (this.f89130a.hashCode() * 31) + this.f89131b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f89130a + ", properties=" + this.f89131b.values() + "}";
    }

    private FieldDescriptor(String str, Map map) {
        this.f89130a = str;
        this.f89131b = map;
    }
}
