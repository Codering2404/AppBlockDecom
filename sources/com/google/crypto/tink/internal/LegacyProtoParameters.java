package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class LegacyProtoParameters extends Parameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProtoParametersSerialization f86248a;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.LegacyProtoParameters$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86249a;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f86249a = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86249a[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86249a[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86249a[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static String a(OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.f86249a[outputPrefixType.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LegacyProtoParameters)) {
            return false;
        }
        ProtoParametersSerialization protoParametersSerialization = ((LegacyProtoParameters) obj).f86248a;
        return this.f86248a.a().U().equals(protoParametersSerialization.a().U()) && this.f86248a.a().V().equals(protoParametersSerialization.a().V()) && this.f86248a.a().W().equals(protoParametersSerialization.a().W());
    }

    public int hashCode() {
        return Objects.hash(this.f86248a.a(), this.f86248a.b());
    }

    public String toString() {
        return String.format("(typeUrl=%s, outputPrefixType=%s)", this.f86248a.a().V(), a(this.f86248a.a().U()));
    }
}
