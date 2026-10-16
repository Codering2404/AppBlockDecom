package androidx.compose.ui.unit;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.google.android.gms.common.api.Api;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
public final class Constraints {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29963b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f29964a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(int i3, int i4, int i5, int i6) {
            int i7 = 262142;
            int iMin = Math.min(i5, 262142);
            int iMin2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int iMin3 = i6 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i6, 262142);
            int i8 = iMin3 == Integer.MAX_VALUE ? iMin : iMin3;
            if (i8 >= 8191) {
                if (i8 < 32767) {
                    i7 = 65534;
                } else if (i8 < 65535) {
                    i7 = 32766;
                } else {
                    if (i8 >= 262143) {
                        ConstraintsKt.l(i8);
                        throw new KotlinNothingValueException();
                    }
                    i7 = 8190;
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                iMin2 = Math.min(i7, i4);
            }
            return ConstraintsKt.a(Math.min(i7, i3), iMin2, iMin, iMin3);
        }

        public final long b(int i3, int i4, int i5, int i6) {
            int i7 = 262142;
            int iMin = Math.min(i3, 262142);
            int iMin2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int iMin3 = i4 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i4, 262142);
            int i8 = iMin3 == Integer.MAX_VALUE ? iMin : iMin3;
            if (i8 >= 8191) {
                if (i8 < 32767) {
                    i7 = 65534;
                } else if (i8 < 65535) {
                    i7 = 32766;
                } else {
                    if (i8 >= 262143) {
                        ConstraintsKt.l(i8);
                        throw new KotlinNothingValueException();
                    }
                    i7 = 8190;
                }
            }
            if (i6 != Integer.MAX_VALUE) {
                iMin2 = Math.min(i7, i6);
            }
            return ConstraintsKt.a(iMin, iMin3, Math.min(i7, i5), iMin2);
        }

        public final long c(int i3, int i4) {
            if (!((i4 >= 0) & (i3 >= 0))) {
                InlineClassHelperKt.a("width and height must be >= 0");
            }
            return ConstraintsKt.h(i3, i3, i4, i4);
        }

        public final long d(int i3) {
            if (!(i3 >= 0)) {
                InlineClassHelperKt.a("height must be >= 0");
            }
            return ConstraintsKt.h(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, i3, i3);
        }

        public final long e(int i3) {
            if (!(i3 >= 0)) {
                InlineClassHelperKt.a("width must be >= 0");
            }
            return ConstraintsKt.h(i3, i3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        private Companion() {
        }
    }

    private /* synthetic */ Constraints(long j3) {
        this.f29964a = j3;
    }

    public static final /* synthetic */ Constraints a(long j3) {
        return new Constraints(j3);
    }

    public static long b(long j3) {
        return j3;
    }

    public static final long c(long j3, int i3, int i4, int i5, int i6) {
        if (!(i4 >= i3 && i6 >= i5 && i3 >= 0 && i5 >= 0)) {
            InlineClassHelperKt.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return ConstraintsKt.h(i3, i4, i5, i6);
    }

    public static /* synthetic */ long d(long j3, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = n(j3);
        }
        int i8 = i3;
        if ((i7 & 2) != 0) {
            i4 = l(j3);
        }
        int i9 = i4;
        if ((i7 & 4) != 0) {
            i5 = m(j3);
        }
        int i10 = i5;
        if ((i7 & 8) != 0) {
            i6 = k(j3);
        }
        return c(j3, i8, i9, i10, i6);
    }

    public static boolean e(long j3, Object obj) {
        return (obj instanceof Constraints) && j3 == ((Constraints) obj).r();
    }

    public static final boolean f(long j3, long j4) {
        return j3 == j4;
    }

    public static final boolean g(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = ((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3);
        return (((int) (j3 >> (i4 + 46))) & ((1 << (18 - i4)) - 1)) != 0;
    }

    public static final boolean h(long j3) {
        int i3 = (int) (3 & j3);
        return (((int) (j3 >> 33)) & ((1 << ((((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3)) + 13)) - 1)) != 0;
    }

    public static final boolean i(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = ((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3);
        int i5 = (1 << (18 - i4)) - 1;
        int i6 = ((int) (j3 >> (i4 + 15))) & i5;
        int i7 = ((int) (j3 >> (i4 + 46))) & i5;
        return i6 == (i7 == 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i7 - 1);
    }

    public static final boolean j(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = (1 << ((((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3)) + 13)) - 1;
        int i5 = ((int) (j3 >> 2)) & i4;
        int i6 = ((int) (j3 >> 33)) & i4;
        return i5 == (i6 == 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i6 - 1);
    }

    public static final int k(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = ((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3);
        int i5 = ((int) (j3 >> (i4 + 46))) & ((1 << (18 - i4)) - 1);
        return i5 == 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i5 - 1;
    }

    public static final int l(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = ((int) (j3 >> 33)) & ((1 << ((((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3)) + 13)) - 1);
        return i4 == 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i4 - 1;
    }

    public static final int m(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = ((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3);
        return ((int) (j3 >> (i4 + 15))) & ((1 << (18 - i4)) - 1);
    }

    public static final int n(long j3) {
        int i3 = (int) (3 & j3);
        return ((int) (j3 >> 2)) & ((1 << ((((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3)) + 13)) - 1);
    }

    public static int o(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean p(long j3) {
        int i3 = (int) (3 & j3);
        int i4 = ((i3 & 1) << 1) + (((i3 & 2) >> 1) * 3);
        return ((((int) (j3 >> 33)) & ((1 << (i4 + 13)) - 1)) - 1 == 0) | ((((int) (j3 >> (i4 + 46))) & ((1 << (18 - i4)) - 1)) - 1 == 0);
    }

    public boolean equals(Object obj) {
        return e(this.f29964a, obj);
    }

    public int hashCode() {
        return o(this.f29964a);
    }

    public final /* synthetic */ long r() {
        return this.f29964a;
    }

    public String toString() {
        return q(this.f29964a);
    }

    public static String q(long j3) {
        String strValueOf;
        int iL = l(j3);
        String strValueOf2 = muQRKXGtpOhe.yckkmjVxWwr;
        if (iL == Integer.MAX_VALUE) {
            strValueOf = strValueOf2;
        } else {
            strValueOf = String.valueOf(iL);
        }
        int iK = k(j3);
        if (iK != Integer.MAX_VALUE) {
            strValueOf2 = String.valueOf(iK);
        }
        return "Constraints(minWidth = " + n(j3) + ", maxWidth = " + strValueOf + ", minHeight = " + m(j3) + ", maxHeight = " + strValueOf2 + ')';
    }
}
