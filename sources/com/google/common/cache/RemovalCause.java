package com.google.common.cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public enum RemovalCause {
    EXPLICIT { // from class: com.google.common.cache.RemovalCause.1
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return false;
        }
    },
    REPLACED { // from class: com.google.common.cache.RemovalCause.2
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return false;
        }
    },
    COLLECTED { // from class: com.google.common.cache.RemovalCause.3
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return true;
        }
    },
    EXPIRED { // from class: com.google.common.cache.RemovalCause.4
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return true;
        }
    },
    SIZE { // from class: com.google.common.cache.RemovalCause.5
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return true;
        }
    };

    abstract boolean b();
}
