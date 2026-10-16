package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

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
@CoreFriendModuleApi
@Metadata
public final class ElementMarker {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Companion f142800e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long[] f142801f = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SerialDescriptor f142802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f142803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f142804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long[] f142805d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ElementMarker(SerialDescriptor descriptor, Function2 readIfAbsent) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(readIfAbsent, "readIfAbsent");
        this.f142802a = descriptor;
        this.f142803b = readIfAbsent;
        int iE = descriptor.e();
        if (iE <= 64) {
            this.f142804c = iE != 64 ? (-1) << iE : 0L;
            this.f142805d = f142801f;
        } else {
            this.f142804c = 0L;
            this.f142805d = e(iE);
        }
    }

    private final void b(int i3) {
        int i4 = (i3 >>> 6) - 1;
        long[] jArr = this.f142805d;
        jArr[i4] = jArr[i4] | (1 << (i3 & 63));
    }

    private final int c() {
        int length = this.f142805d.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int i5 = i4 * 64;
            long j3 = this.f142805d[i3];
            while (j3 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j3);
                j3 |= 1 << iNumberOfTrailingZeros;
                int i6 = iNumberOfTrailingZeros + i5;
                if (((Boolean) this.f142803b.invoke(this.f142802a, Integer.valueOf(i6))).booleanValue()) {
                    this.f142805d[i3] = j3;
                    return i6;
                }
            }
            this.f142805d[i3] = j3;
            i3 = i4;
        }
        return -1;
    }

    private final long[] e(int i3) {
        long[] jArr = new long[(i3 - 1) >>> 6];
        if ((i3 & 63) != 0) {
            jArr[ArraysKt.getLastIndex(jArr)] = (-1) << i3;
        }
        return jArr;
    }

    public final void a(int i3) {
        if (i3 < 64) {
            this.f142804c |= 1 << i3;
        } else {
            b(i3);
        }
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iE = this.f142802a.e();
        do {
            long j3 = this.f142804c;
            if (j3 == -1) {
                if (iE > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j3);
            this.f142804c |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.f142803b.invoke(this.f142802a, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }
}
