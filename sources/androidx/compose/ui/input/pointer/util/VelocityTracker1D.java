package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class VelocityTracker1D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f26986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Strategy f26987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataPointAtTime[] f26989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f26991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f26992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f26993h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Strategy f26994a = new Strategy("Lsq2", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Strategy f26995b = new Strategy("Impulse", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Strategy[] f26996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f26997d;

        static {
            Strategy[] strategyArrA = a();
            f26996c = strategyArrA;
            f26997d = EnumEntriesKt.a(strategyArrA);
        }

        private Strategy(String str, int i3) {
        }

        private static final /* synthetic */ Strategy[] a() {
            return new Strategy[]{f26994a, f26995b};
        }

        public static Strategy valueOf(String str) {
            return (Strategy) Enum.valueOf(Strategy.class, str);
        }

        public static Strategy[] values() {
            return (Strategy[]) f26996c.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26998a;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.f26995b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.f26994a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f26998a = iArr;
        }
    }

    public VelocityTracker1D(boolean z2, Strategy strategy) {
        this.f26986a = z2;
        this.f26987b = strategy;
        if (z2 && strategy.equals(Strategy.f26994a)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i3 = WhenMappings.f26998a[strategy.ordinal()];
        int i4 = 2;
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i4 = 3;
        }
        this.f26988c = i4;
        this.f26989d = new DataPointAtTime[20];
        this.f26991f = new float[20];
        this.f26992g = new float[20];
        this.f26993h = new float[3];
    }

    private final float b(float[] fArr, float[] fArr2, int i3) {
        try {
            return VelocityTrackerKt.i(fArr2, fArr, i3, 2, this.f26993h)[1];
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final void a(long j3, float f3) {
        int i3 = (this.f26990e + 1) % 20;
        this.f26990e = i3;
        VelocityTrackerKt.j(this.f26989d, i3, j3, f3);
    }

    public final float c() {
        float f3;
        float[] fArr = this.f26991f;
        float[] fArr2 = this.f26992g;
        int i3 = this.f26990e;
        DataPointAtTime dataPointAtTime = this.f26989d[i3];
        if (dataPointAtTime == null) {
            return 0.0f;
        }
        int i4 = 0;
        DataPointAtTime dataPointAtTime2 = dataPointAtTime;
        while (true) {
            DataPointAtTime dataPointAtTime3 = this.f26989d[i3];
            if (dataPointAtTime3 == null) {
                break;
            }
            float fB = dataPointAtTime.b() - dataPointAtTime3.b();
            float fAbs = Math.abs(dataPointAtTime3.b() - dataPointAtTime2.b());
            DataPointAtTime dataPointAtTime4 = (this.f26987b == Strategy.f26994a || this.f26986a) ? dataPointAtTime3 : dataPointAtTime;
            if (fB > 100.0f || fAbs > 40.0f) {
                break;
            }
            fArr[i4] = dataPointAtTime3.a();
            fArr2[i4] = -fB;
            if (i3 == 0) {
                i3 = 20;
            }
            i3--;
            i4++;
            if (i4 >= 20) {
                break;
            }
            dataPointAtTime2 = dataPointAtTime4;
        }
        if (i4 < this.f26988c) {
            return 0.0f;
        }
        int i5 = WhenMappings.f26998a[this.f26987b.ordinal()];
        if (i5 == 1) {
            f3 = VelocityTrackerKt.f(fArr, fArr2, i4, this.f26986a);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f3 = b(fArr, fArr2, i4);
        }
        return f3 * 1000;
    }

    public final float d(float f3) {
        if (!(f3 > 0.0f)) {
            InlineClassHelperKt.c("maximumVelocity should be a positive value. You specified=" + f3);
        }
        float fC = c();
        if (fC == 0.0f || Float.isNaN(fC)) {
            return 0.0f;
        }
        return fC > 0.0f ? RangesKt.j(fC, f3) : RangesKt.e(fC, -f3);
    }

    public final void e() {
        ArraysKt.fill$default(this.f26989d, (Object) null, 0, 0, 6, (Object) null);
        this.f26990e = 0;
    }

    public /* synthetic */ VelocityTracker1D(boolean z2, Strategy strategy, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? Strategy.f26994a : strategy);
    }

    public VelocityTracker1D(boolean z2) {
        this(z2, Strategy.f26995b);
    }
}
