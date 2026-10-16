package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TimePickerColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f21152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f21153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f21156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f21157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f21158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f21159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f21160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f21161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f21162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f21163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f21164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f21165n;

    public /* synthetic */ TimePickerColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
    }

    public final long a(boolean z2) {
        return z2 ? this.f21156e : this.f21157f;
    }

    public final long b() {
        return this.f21152a;
    }

    public final long c() {
        return this.f21155d;
    }

    public final long d() {
        return this.f21153b;
    }

    public final long e(boolean z2) {
        return z2 ? this.f21158g : this.f21159h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TimePickerColors.class != obj.getClass()) {
            return false;
        }
        TimePickerColors timePickerColors = (TimePickerColors) obj;
        return Color.t(this.f21152a, timePickerColors.f21152a) && Color.t(this.f21153b, timePickerColors.f21153b) && Color.t(this.f21154c, timePickerColors.f21154c) && Color.t(this.f21155d, timePickerColors.f21155d) && Color.t(this.f21158g, timePickerColors.f21158g) && Color.t(this.f21159h, timePickerColors.f21159h) && Color.t(this.f21160i, timePickerColors.f21160i) && Color.t(this.f21161j, timePickerColors.f21161j) && Color.t(this.f21162k, timePickerColors.f21162k) && Color.t(this.f21163l, timePickerColors.f21163l) && Color.t(this.f21164m, timePickerColors.f21164m) && Color.t(this.f21165n, timePickerColors.f21165n);
    }

    public final long f(boolean z2) {
        return z2 ? this.f21160i : this.f21161j;
    }

    public final long g(boolean z2) {
        return z2 ? this.f21162k : this.f21163l;
    }

    public final long h(boolean z2) {
        return z2 ? this.f21164m : this.f21165n;
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.z(this.f21152a) * 31) + Color.z(this.f21153b)) * 31) + Color.z(this.f21154c)) * 31) + Color.z(this.f21155d)) * 31) + Color.z(this.f21158g)) * 31) + Color.z(this.f21159h)) * 31) + Color.z(this.f21160i)) * 31) + Color.z(this.f21161j)) * 31) + Color.z(this.f21162k)) * 31) + Color.z(this.f21163l)) * 31) + Color.z(this.f21164m)) * 31) + Color.z(this.f21165n);
    }

    private TimePickerColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.f21152a = j3;
        this.f21153b = j4;
        this.f21154c = j5;
        this.f21155d = j6;
        this.f21156e = j7;
        this.f21157f = j8;
        this.f21158g = j9;
        this.f21159h = j10;
        this.f21160i = j11;
        this.f21161j = j12;
        this.f21162k = j13;
        this.f21163l = j14;
        this.f21164m = j15;
        this.f21165n = j16;
    }
}
