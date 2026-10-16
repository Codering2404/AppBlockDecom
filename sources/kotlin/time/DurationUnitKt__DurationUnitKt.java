package kotlin.time;

import kotlin.Metadata;
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
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f140649a;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.f140638b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.f140639c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.f140640d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.f140641f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.f140642g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.f140643h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.f140644i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f140649a = iArr;
        }
    }

    public static final DurationUnit d(char c3, boolean z2) {
        if (!z2) {
            if (c3 == 'D') {
                return DurationUnit.f140644i;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c3);
        }
        if (c3 == 'H') {
            return DurationUnit.f140643h;
        }
        if (c3 == 'M') {
            return DurationUnit.f140642g;
        }
        if (c3 == 'S') {
            return DurationUnit.f140641f;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c3);
    }

    public static final DurationUnit e(String shortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return DurationUnit.f140639c;
                                }
                            } else if (shortName.equals("ns")) {
                                return DurationUnit.f140638b;
                            }
                        } else if (shortName.equals("ms")) {
                            return DurationUnit.f140640d;
                        }
                    } else if (shortName.equals("s")) {
                        return DurationUnit.f140641f;
                    }
                } else if (shortName.equals("m")) {
                    return DurationUnit.f140642g;
                }
            } else if (shortName.equals("h")) {
                return DurationUnit.f140643h;
            }
        } else if (shortName.equals("d")) {
            return DurationUnit.f140644i;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    public static final String f(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "<this>");
        switch (WhenMappings.f140649a[durationUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }
}
