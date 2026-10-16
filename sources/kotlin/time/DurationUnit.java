package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class DurationUnit {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DurationUnit f140638b = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DurationUnit f140639c = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DurationUnit f140640d = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DurationUnit f140641f = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DurationUnit f140642g = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DurationUnit f140643h = new DurationUnit("HOURS", 5, TimeUnit.HOURS);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DurationUnit f140644i = new DurationUnit("DAYS", 6, TimeUnit.DAYS);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ DurationUnit[] f140645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f140646k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeUnit f140647a;

    static {
        DurationUnit[] durationUnitArrA = a();
        f140645j = durationUnitArrA;
        f140646k = EnumEntriesKt.a(durationUnitArrA);
    }

    private DurationUnit(String str, int i3, TimeUnit timeUnit) {
        this.f140647a = timeUnit;
    }

    private static final /* synthetic */ DurationUnit[] a() {
        return new DurationUnit[]{f140638b, f140639c, f140640d, f140641f, f140642g, f140643h, f140644i};
    }

    public static DurationUnit valueOf(String str) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, str);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[]) f140645j.clone();
    }

    public final TimeUnit b() {
        return this.f140647a;
    }
}
