package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MoreObjects {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f83323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ValueHolder f83324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ValueHolder f83325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f83326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f83327e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class ValueHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f83328a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f83329b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            ValueHolder f83330c;

            ValueHolder() {
            }
        }

        private ValueHolder f() {
            ValueHolder valueHolder = new ValueHolder();
            this.f83325c.f83330c = valueHolder;
            this.f83325c = valueHolder;
            return valueHolder;
        }

        private ToStringHelper g(Object obj) {
            f().f83329b = obj;
            return this;
        }

        private ToStringHelper h(String str, Object obj) {
            ValueHolder valueHolderF = f();
            valueHolderF.f83329b = obj;
            valueHolderF.f83328a = (String) Preconditions.t(str);
            return this;
        }

        private UnconditionalValueHolder i() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.f83325c.f83330c = unconditionalValueHolder;
            this.f83325c = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        private ToStringHelper j(String str, Object obj) {
            UnconditionalValueHolder unconditionalValueHolderI = i();
            unconditionalValueHolderI.f83329b = obj;
            unconditionalValueHolderI.f83328a = (String) Preconditions.t(str);
            return this;
        }

        private static boolean l(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof Optional ? !((Optional) obj).c() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public ToStringHelper a(String str, double d3) {
            return j(str, String.valueOf(d3));
        }

        public ToStringHelper b(String str, int i3) {
            return j(str, String.valueOf(i3));
        }

        public ToStringHelper c(String str, long j3) {
            return j(str, String.valueOf(j3));
        }

        public ToStringHelper d(String str, Object obj) {
            return h(str, obj);
        }

        public ToStringHelper e(String str, boolean z2) {
            return j(str, String.valueOf(z2));
        }

        public ToStringHelper k(Object obj) {
            return g(obj);
        }

        public ToStringHelper m() {
            this.f83326d = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r7 = this;
                boolean r0 = r7.f83326d
                boolean r1 = r7.f83327e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r7.f83323a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                com.google.common.base.MoreObjects$ToStringHelper$ValueHolder r3 = r7.f83324b
                com.google.common.base.MoreObjects$ToStringHelper$ValueHolder r3 = r3.f83330c
                java.lang.String r4 = ""
            L1b:
                if (r3 == 0) goto L65
                java.lang.Object r5 = r3.f83329b
                boolean r6 = r3 instanceof com.google.common.base.MoreObjects.ToStringHelper.UnconditionalValueHolder
                if (r6 != 0) goto L30
                if (r5 != 0) goto L28
                if (r0 != 0) goto L62
                goto L30
            L28:
                if (r1 == 0) goto L30
                boolean r6 = l(r5)
                if (r6 != 0) goto L62
            L30:
                r2.append(r4)
                java.lang.String r4 = r3.f83328a
                if (r4 == 0) goto L3f
                r2.append(r4)
                r4 = 61
                r2.append(r4)
            L3f:
                if (r5 == 0) goto L5d
                java.lang.Class r4 = r5.getClass()
                boolean r4 = r4.isArray()
                if (r4 == 0) goto L5d
                java.lang.Object[] r4 = new java.lang.Object[]{r5}
                java.lang.String r4 = java.util.Arrays.deepToString(r4)
                int r5 = r4.length()
                r6 = 1
                int r5 = r5 - r6
                r2.append(r4, r6, r5)
                goto L60
            L5d:
                r2.append(r5)
            L60:
                java.lang.String r4 = ", "
            L62:
                com.google.common.base.MoreObjects$ToStringHelper$ValueHolder r3 = r3.f83330c
                goto L1b
            L65:
                r0 = 125(0x7d, float:1.75E-43)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.MoreObjects.ToStringHelper.toString():java.lang.String");
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f83324b = valueHolder;
            this.f83325c = valueHolder;
            this.f83326d = false;
            this.f83327e = false;
            this.f83323a = (String) Preconditions.t(str);
        }
    }

    public static Object a(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper b(Class cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper c(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
