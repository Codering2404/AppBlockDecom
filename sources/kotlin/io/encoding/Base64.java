package kotlin.io.encoding;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class Base64 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Default f139988f = new Default(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f139989g = {Ascii.CR, 10};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Base64 f139990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Base64 f139991i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Base64 f139992j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f139993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f139994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f139995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PaddingOption f139996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f139997e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Default extends Base64 {
        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] p() {
            return Base64.f139989g;
        }

        private Default() {
            super(false, false, -1, PaddingOption.f139998a, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaddingOption {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PaddingOption f139998a = new PaddingOption("PRESENT", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final PaddingOption f139999b = new PaddingOption("ABSENT", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final PaddingOption f140000c = new PaddingOption("PRESENT_OPTIONAL", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final PaddingOption f140001d = new PaddingOption("ABSENT_OPTIONAL", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ PaddingOption[] f140002f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f140003g;

        static {
            PaddingOption[] paddingOptionArrA = a();
            f140002f = paddingOptionArrA;
            f140003g = EnumEntriesKt.a(paddingOptionArrA);
        }

        private PaddingOption(String str, int i3) {
        }

        private static final /* synthetic */ PaddingOption[] a() {
            return new PaddingOption[]{f139998a, f139999b, f140000c, f140001d};
        }

        public static PaddingOption valueOf(String str) {
            return (PaddingOption) Enum.valueOf(PaddingOption.class, str);
        }

        public static PaddingOption[] values() {
            return (PaddingOption[]) f140002f.clone();
        }
    }

    static {
        PaddingOption paddingOption = PaddingOption.f139998a;
        f139990h = new Base64(true, false, -1, paddingOption);
        f139991i = new Base64(false, true, 76, paddingOption);
        f139992j = new Base64(false, true, 64, paddingOption);
    }

    public /* synthetic */ Base64(boolean z2, boolean z3, int i3, PaddingOption paddingOption, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3, i3, paddingOption);
    }

    private final void b(int i3, int i4, int i5) {
        if (i4 < 0 || i4 > i3) {
            throw new IndexOutOfBoundsException("destination offset: " + i4 + ", destination size: " + i3);
        }
        int i6 = i4 + i5;
        if (i6 < 0 || i6 > i3) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i4 + ", destination size: " + i3 + ", capacity needed: " + i5);
        }
    }

    private final void c(int i3) {
        if (this.f139996d != PaddingOption.f139999b) {
            return;
        }
        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00db, code lost:
    
        if (r7 == (-2)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
    
        if (r7 == (-8)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e0, code lost:
    
        if (r4 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
    
        if (r19.f139996d == kotlin.io.encoding.Base64.PaddingOption.f139998a) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f0, code lost:
    
        throw new java.lang.IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f1, code lost:
    
        if (r8 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f3, code lost:
    
        r3 = o(r20, r6, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f7, code lost:
    
        if (r3 < r24) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
    
        return r9 - r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        r1 = r20[r3] & 255;
        r4 = new java.lang.StringBuilder();
        r4.append("Symbol '");
        r4.append((char) r1);
        r4.append("'(");
        r1 = java.lang.Integer.toString(r1, kotlin.text.CharsKt.checkRadix(r23));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        r4.append(r1);
        r4.append(") at index ");
        r4.append(r3 - 1);
        r4.append(" is prohibited after the pad character");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0135, code lost:
    
        throw new java.lang.IllegalArgumentException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013d, code lost:
    
        throw new java.lang.IllegalArgumentException("The pad bits must be zeros");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0145, code lost:
    
        throw new java.lang.IllegalArgumentException("The last unit of input does not have enough bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int e(byte[] r20, byte[] r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.encoding.Base64.e(byte[], byte[], int, int, int):int");
    }

    private final int l(byte[] bArr, int i3, int i4, int i5) {
        if (i5 == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + i3);
        }
        if (i5 == -6) {
            c(i3);
            return i3 + 1;
        }
        if (i5 != -4) {
            if (i5 == -2) {
                return i3 + 1;
            }
            throw new IllegalStateException("Unreachable");
        }
        c(i3);
        int iO = o(bArr, i3 + 1, i4);
        if (iO != i4 && bArr[iO] == 61) {
            return iO + 1;
        }
        throw new IllegalArgumentException("Missing one pad character at index " + iO);
    }

    private final boolean n() {
        PaddingOption paddingOption = this.f139996d;
        return paddingOption == PaddingOption.f139998a || paddingOption == PaddingOption.f140000c;
    }

    private final int o(byte[] bArr, int i3, int i4) {
        if (!this.f139994b) {
            return i3;
        }
        while (i3 < i4) {
            if (Base64Kt.f140005b[bArr[i3] & 255] != -1) {
                break;
            }
            i3++;
        }
        return i3;
    }

    public final void d(int i3, int i4, int i5) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i4, i5, i3);
    }

    public final int f(byte[] source, byte[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        d(source.length, i4, i5);
        b(destination.length, i3, g(source, i4, i5));
        return e(source, destination, i3, i4, i5);
    }

    public final int g(byte[] source, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        int i5 = i4 - i3;
        if (i5 == 0) {
            return 0;
        }
        if (i5 == 1) {
            throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + i3 + ", endIndex: " + i4);
        }
        if (this.f139994b) {
            while (true) {
                if (i3 >= i4) {
                    break;
                }
                int i6 = Base64Kt.f140005b[source[i3] & 255];
                if (i6 < 0) {
                    if (i6 == -2) {
                        i5 -= i4 - i3;
                        break;
                    }
                    i5--;
                }
                i3++;
            }
        } else if (source[i4 - 1] == 61) {
            i5 = source[i4 + (-2)] == 61 ? i5 - 2 : i5 - 1;
        }
        return (int) ((((long) i5) * ((long) 6)) / ((long) 8));
    }

    public final int h(byte[] source, byte[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return i(source, destination, i3, i4, i5);
    }

    public final int i(byte[] source, byte[] destination, int i3, int i4, int i5) {
        int i6 = i4;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        d(source.length, i6, i5);
        b(destination.length, i3, j(i5 - i6));
        byte[] bArr = this.f139993a ? Base64Kt.f140006c : Base64Kt.f140004a;
        int i7 = this.f139994b ? this.f139997e : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i8 = i3;
        while (i6 + 2 < i5) {
            int iMin = Math.min((i5 - i6) / 3, i7);
            for (int i9 = 0; i9 < iMin; i9++) {
                int i10 = source[i6] & 255;
                int i11 = i6 + 2;
                int i12 = source[i6 + 1] & 255;
                i6 += 3;
                int i13 = (i12 << 8) | (i10 << 16) | (source[i11] & 255);
                destination[i8] = bArr[i13 >>> 18];
                destination[i8 + 1] = bArr[(i13 >>> 12) & 63];
                int i14 = i8 + 3;
                destination[i8 + 2] = bArr[(i13 >>> 6) & 63];
                i8 += 4;
                destination[i14] = bArr[i13 & 63];
            }
            if (iMin == i7 && i6 != i5) {
                int i15 = i8 + 1;
                byte[] bArr2 = f139989g;
                destination[i8] = bArr2[0];
                i8 += 2;
                destination[i15] = bArr2[1];
            }
        }
        int i16 = i5 - i6;
        if (i16 == 1) {
            int i17 = i6 + 1;
            int i18 = (source[i6] & 255) << 4;
            destination[i8] = bArr[i18 >>> 6];
            int i19 = i8 + 2;
            destination[i8 + 1] = bArr[i18 & 63];
            if (n()) {
                int i20 = i8 + 3;
                destination[i19] = 61;
                i8 += 4;
                destination[i20] = 61;
                i6 = i17;
            } else {
                i6 = i17;
                i8 = i19;
            }
        } else if (i16 == 2) {
            int i21 = i6 + 1;
            int i22 = source[i6] & 255;
            i6 += 2;
            int i23 = ((source[i21] & 255) << 2) | (i22 << 10);
            destination[i8] = bArr[i23 >>> 12];
            destination[i8 + 1] = bArr[(i23 >>> 6) & 63];
            int i24 = i8 + 3;
            destination[i8 + 2] = bArr[i23 & 63];
            if (n()) {
                i8 += 4;
                destination[i24] = 61;
            } else {
                i8 = i24;
            }
        }
        if (i6 == i5) {
            return i8 - i3;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int j(int i3) {
        int i4 = i3 / 3;
        int i5 = i3 % 3;
        int i6 = i4 * 4;
        if (i5 != 0) {
            i6 += n() ? 4 : i5 + 1;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Input is too big");
        }
        if (this.f139994b) {
            i6 += ((i6 - 1) / this.f139995c) * 2;
        }
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    public final int k() {
        return this.f139995c;
    }

    public final boolean m() {
        return this.f139994b;
    }

    private Base64(boolean z2, boolean z3, int i3, PaddingOption paddingOption) {
        this.f139993a = z2;
        this.f139994b = z3;
        this.f139995c = i3;
        this.f139996d = paddingOption;
        if (z2 && z3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f139997e = i3 / 4;
    }
}
