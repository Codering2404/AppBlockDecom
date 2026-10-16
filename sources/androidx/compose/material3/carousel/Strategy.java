package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class Strategy {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f21741m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f21742n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Strategy f21743o = new Strategy(KeylineListKt.a(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeylineList f21744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f21745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f21746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f21747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f21748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f21749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f21750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f21751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f21752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FloatList f21753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FloatList f21754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f21755l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Strategy a() {
            return Strategy.f21743o;
        }

        private Companion() {
        }
    }

    private Strategy(KeylineList keylineList, List list, List list2, float f3, float f4, float f5, float f6) {
        this.f21744a = keylineList;
        this.f21745b = list;
        this.f21746c = list2;
        this.f21747d = f3;
        this.f21748e = f4;
        this.f21749f = f5;
        this.f21750g = f6;
        float fN = StrategyKt.n(list, f5);
        this.f21751h = fN;
        float fK = StrategyKt.k(list2, f6);
        this.f21752i = fK;
        this.f21753j = StrategyKt.o(fN, list, true);
        this.f21754k = StrategyKt.o(fK, list2, false);
        this.f21755l = (keylineList.isEmpty() || f3 == 0.0f || e() == 0.0f) ? false : true;
    }

    public static /* synthetic */ KeylineList h(Strategy strategy, float f3, float f4, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return strategy.g(f3, f4, z2);
    }

    public final float b() {
        return this.f21747d;
    }

    public final KeylineList c() {
        return this.f21744a;
    }

    public final List d() {
        return this.f21746c;
    }

    public final float e() {
        return this.f21744a.f().e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        boolean z2 = this.f21755l;
        if (!z2 && !((Strategy) obj).f21755l) {
            return true;
        }
        Strategy strategy = (Strategy) obj;
        return z2 == strategy.f21755l && this.f21747d == strategy.f21747d && this.f21748e == strategy.f21748e && this.f21749f == strategy.f21749f && this.f21750g == strategy.f21750g && e() == strategy.e() && this.f21751h == strategy.f21751h && this.f21752i == strategy.f21752i && Intrinsics.areEqual(this.f21753j, strategy.f21753j) && Intrinsics.areEqual(this.f21754k, strategy.f21754k) && Intrinsics.areEqual(this.f21744a, strategy.f21744a);
    }

    public final float f() {
        return this.f21748e;
    }

    public final KeylineList g(float f3, float f4, boolean z2) {
        float fMax = Math.max(0.0f, f3);
        float f5 = this.f21751h;
        float fMax2 = Math.max(0.0f, f4 - this.f21752i);
        if (f5 <= fMax && fMax <= fMax2) {
            return this.f21744a;
        }
        float fP = StrategyKt.p(1.0f, 0.0f, 0.0f, f5, fMax);
        FloatList floatList = this.f21753j;
        List list = this.f21745b;
        if (fMax > fMax2) {
            fP = StrategyKt.p(0.0f, 1.0f, fMax2, f4, fMax);
            floatList = this.f21754k;
            list = this.f21746c;
        }
        ShiftPointRange shiftPointRangeL = StrategyKt.l(list.size(), floatList, fP);
        if (z2) {
            return (KeylineList) list.get(MathKt.d(shiftPointRangeL.b()) == 0 ? shiftPointRangeL.a() : shiftPointRangeL.c());
        }
        return KeylineListKt.e((KeylineList) list.get(shiftPointRangeL.a()), (KeylineList) list.get(shiftPointRangeL.c()), shiftPointRangeL.b());
    }

    public int hashCode() {
        boolean z2 = this.f21755l;
        return !z2 ? Boolean.hashCode(z2) : (((((((((((((((((((Boolean.hashCode(z2) * 31) + Float.hashCode(this.f21747d)) * 31) + Float.hashCode(this.f21748e)) * 31) + Float.hashCode(this.f21749f)) * 31) + Float.hashCode(this.f21750g)) * 31) + Float.hashCode(e())) * 31) + Float.hashCode(this.f21751h)) * 31) + Float.hashCode(this.f21752i)) * 31) + this.f21753j.hashCode()) * 31) + this.f21754k.hashCode()) * 31) + this.f21744a.hashCode();
    }

    public final List i() {
        return this.f21745b;
    }

    public final boolean j() {
        return this.f21755l;
    }

    public Strategy(KeylineList keylineList, float f3, float f4, float f5, float f6) {
        this(keylineList, StrategyKt.m(keylineList, f3, f4, f5), StrategyKt.j(keylineList, f3, f4, f6), f3, f4, f5, f6);
    }
}
