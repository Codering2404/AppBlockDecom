package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class LegacyProtoKey extends Key {

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.LegacyProtoKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f86245b;

        static {
            int[] iArr = new int[KeyData.KeyMaterialType.values().length];
            f86245b = iArr;
            try {
                iArr[KeyData.KeyMaterialType.SYMMETRIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86245b[KeyData.KeyMaterialType.f86590d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[OutputPrefixType.values().length];
            f86244a = iArr2;
            try {
                iArr2[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86244a[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86244a[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86244a[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    private static class LegacyProtoParametersNotForCreation extends Parameters {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OutputPrefixType f86247b;

        private static String a(OutputPrefixType outputPrefixType) {
            int i3 = AnonymousClass1.f86244a[outputPrefixType.ordinal()];
            return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        }

        public String toString() {
            return String.format("(typeUrl=%s, outputPrefixType=%s)", this.f86246a, a(this.f86247b));
        }
    }
}
