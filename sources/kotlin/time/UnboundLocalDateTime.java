package kotlin.time;

import com.facebook.AccessTokenManager;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import kotlin.Metadata;
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
final class UnboundLocalDateTime {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f140671h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f140675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f140676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f140677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f140678g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnboundLocalDateTime a(Instant instant) {
            long j3;
            long j4;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long jD = instant.d();
            long j5 = jD / 86400;
            if ((jD ^ 86400) < 0 && j5 * 86400 != jD) {
                j5--;
            }
            long j6 = jD % 86400;
            int i3 = (int) (j6 + (86400 & (((j6 ^ 86400) & ((-j6) | j6)) >> 63)));
            long j7 = (j5 + ((long) 719528)) - ((long) 60);
            if (j7 < 0) {
                j3 = -1;
                long j8 = 146097;
                long j9 = ((j7 + 1) / j8) - 1;
                j4 = ((long) RCHTTPStatusCodes.BAD_REQUEST) * j9;
                j7 += (-j9) * j8;
            } else {
                j3 = -1;
                j4 = 0;
            }
            long j10 = RCHTTPStatusCodes.BAD_REQUEST;
            long j11 = ((j10 * j7) + ((long) 591)) / ((long) 146097);
            long j12 = 365;
            long j13 = 4;
            long j14 = 100;
            long j15 = j7 - ((((j12 * j11) + (j11 / j13)) - (j11 / j14)) + (j11 / j10));
            if (j15 < 0) {
                j11 += j3;
                j15 = j7 - ((((j12 * j11) + (j11 / j13)) - (j11 / j14)) + (j11 / j10));
            }
            long j16 = j11 + j4;
            int i4 = (int) j15;
            int i5 = ((i4 * 5) + 2) / 153;
            int i6 = ((i5 + 2) % 12) + 1;
            int i7 = (i4 - (((i5 * 306) + 5) / 10)) + 1;
            int i8 = (int) (j16 + ((long) (i5 / 10)));
            int i9 = i3 / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
            int i10 = i3 - (i9 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS);
            int i11 = i10 / 60;
            return new UnboundLocalDateTime(i8, i6, i7, i9, i11, i10 - (i11 * 60), instant.e());
        }

        private Companion() {
        }
    }

    public UnboundLocalDateTime(int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f140672a = i3;
        this.f140673b = i4;
        this.f140674c = i5;
        this.f140675d = i6;
        this.f140676e = i7;
        this.f140677f = i8;
        this.f140678g = i9;
    }

    public final int a() {
        return this.f140674c;
    }

    public final int b() {
        return this.f140675d;
    }

    public final int c() {
        return this.f140676e;
    }

    public final int d() {
        return this.f140673b;
    }

    public final int e() {
        return this.f140678g;
    }

    public final int f() {
        return this.f140677f;
    }

    public final int g() {
        return this.f140672a;
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.f140672a + '-' + this.f140673b + '-' + this.f140674c + ' ' + this.f140675d + ':' + this.f140676e + ':' + this.f140677f + '.' + this.f140678g + ')';
    }
}
