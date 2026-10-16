package com.google.gson;

import com.google.gson.internal.ReflectionAccessFilterHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface ReflectionAccessFilter {

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult a(Class cls) {
            return ReflectionAccessFilterHelper.f(cls) ? FilterResult.BLOCK_INACCESSIBLE : FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult a(Class cls) {
            return ReflectionAccessFilterHelper.f(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult a(Class cls) {
            return ReflectionAccessFilterHelper.c(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult a(Class cls) {
            return ReflectionAccessFilterHelper.e(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    FilterResult a(Class cls);
}
