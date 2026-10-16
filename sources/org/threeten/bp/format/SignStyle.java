package org.threeten.bp.format;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    boolean a(boolean z2, boolean z3, boolean z4) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return (z2 && z3) ? false : true;
        }
        if (iOrdinal == 1 || iOrdinal == 4) {
            return true;
        }
        return (z3 || z4) ? false : true;
    }
}
