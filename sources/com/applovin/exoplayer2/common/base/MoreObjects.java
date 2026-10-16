package com.applovin.exoplayer2.common.base;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class MoreObjects {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ToStringHelper {
        private final String className;
        private final a holderHead;
        private a holderTail;
        private boolean omitNullValues;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f57930a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f57931b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f57932c;

            private a() {
            }
        }

        private a addHolder() {
            a aVar = new a();
            this.holderTail.f57932c = aVar;
            this.holderTail = aVar;
            return aVar;
        }

        public ToStringHelper add(String str, @NullableDecl Object obj) {
            return addHolder(str, obj);
        }

        public ToStringHelper addValue(@NullableDecl Object obj) {
            return addHolder(obj);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean z2 = this.omitNullValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (a aVar = this.holderHead.f57932c; aVar != null; aVar = aVar.f57932c) {
                Object obj = aVar.f57931b;
                if (!z2 || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f57930a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(String str) {
            a aVar = new a();
            this.holderHead = aVar;
            this.holderTail = aVar;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public ToStringHelper add(String str, boolean z2) {
            return addHolder(str, String.valueOf(z2));
        }

        public ToStringHelper addValue(boolean z2) {
            return addHolder(String.valueOf(z2));
        }

        private ToStringHelper addHolder(@NullableDecl Object obj) {
            addHolder().f57931b = obj;
            return this;
        }

        public ToStringHelper add(String str, char c3) {
            return addHolder(str, String.valueOf(c3));
        }

        public ToStringHelper addValue(char c3) {
            return addHolder(String.valueOf(c3));
        }

        public ToStringHelper add(String str, double d3) {
            return addHolder(str, String.valueOf(d3));
        }

        public ToStringHelper addValue(double d3) {
            return addHolder(String.valueOf(d3));
        }

        private ToStringHelper addHolder(String str, @NullableDecl Object obj) {
            a aVarAddHolder = addHolder();
            aVarAddHolder.f57931b = obj;
            aVarAddHolder.f57930a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public ToStringHelper add(String str, float f3) {
            return addHolder(str, String.valueOf(f3));
        }

        public ToStringHelper addValue(float f3) {
            return addHolder(String.valueOf(f3));
        }

        public ToStringHelper add(String str, int i3) {
            return addHolder(str, String.valueOf(i3));
        }

        public ToStringHelper addValue(int i3) {
            return addHolder(String.valueOf(i3));
        }

        public ToStringHelper add(String str, long j3) {
            return addHolder(str, String.valueOf(j3));
        }

        public ToStringHelper addValue(long j3) {
            return addHolder(String.valueOf(j3));
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(@NullableDecl T t2, @NullableDecl T t3) {
        if (t2 != null) {
            return t2;
        }
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
