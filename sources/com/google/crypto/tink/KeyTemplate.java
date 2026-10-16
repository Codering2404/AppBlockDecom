package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class KeyTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.crypto.tink.proto.KeyTemplate f86012a;

    /* JADX INFO: renamed from: com.google.crypto.tink.KeyTemplate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f86014b;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f86014b = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86014b[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86014b[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86014b[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.google.crypto.tink.proto.OutputPrefixType.values().length];
            f86013a = iArr2;
            try {
                iArr2[com.google.crypto.tink.proto.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86013a[com.google.crypto.tink.proto.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f86013a[com.google.crypto.tink.proto.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f86013a[com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    private KeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        this.f86012a = keyTemplate;
    }

    public static KeyTemplate a(String str, byte[] bArr, OutputPrefixType outputPrefixType) {
        return new KeyTemplate((com.google.crypto.tink.proto.KeyTemplate) com.google.crypto.tink.proto.KeyTemplate.X().K(str).L(ByteString.p(bArr)).J(f(outputPrefixType)).build());
    }

    static OutputPrefixType b(com.google.crypto.tink.proto.OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.f86013a[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return OutputPrefixType.TINK;
        }
        if (i3 == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (i3 == 3) {
            return OutputPrefixType.RAW;
        }
        if (i3 == 4) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    static com.google.crypto.tink.proto.OutputPrefixType f(OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.f86014b[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return com.google.crypto.tink.proto.OutputPrefixType.TINK;
        }
        if (i3 == 2) {
            return com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
        }
        if (i3 == 3) {
            return com.google.crypto.tink.proto.OutputPrefixType.RAW;
        }
        if (i3 == 4) {
            return com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    public OutputPrefixType c() {
        return b(this.f86012a.U());
    }

    public String d() {
        return this.f86012a.V();
    }

    public byte[] e() {
        return this.f86012a.W().I();
    }
}
