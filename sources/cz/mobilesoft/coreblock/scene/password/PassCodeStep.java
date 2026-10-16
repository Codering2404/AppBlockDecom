package cz.mobilesoft.coreblock.scene.password;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PassCodeStep {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PassCodeStep[] $VALUES;
    public static final Companion Companion;
    public static final PassCodeStep Create = new PassCodeStep("Create", 0);
    public static final PassCodeStep Confirm = new PassCodeStep("Confirm", 1);
    public static final PassCodeStep Check = new PassCodeStep("Check", 2);
    public static final PassCodeStep Remove = new PassCodeStep("Remove", 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f111677a;

            static {
                int[] iArr = new int[PassCodeType.values().length];
                try {
                    iArr[PassCodeType.Create.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PassCodeType.Check.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PassCodeType.Remove.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f111677a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PassCodeStep a(PassCodeType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i3 = WhenMappings.f111677a[type.ordinal()];
            if (i3 == 1) {
                return PassCodeStep.Create;
            }
            if (i3 == 2) {
                return PassCodeStep.Check;
            }
            if (i3 == 3) {
                return PassCodeStep.Remove;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PassCodeStep[] $values() {
        return new PassCodeStep[]{Create, Confirm, Check, Remove};
    }

    static {
        PassCodeStep[] passCodeStepArr$values = $values();
        $VALUES = passCodeStepArr$values;
        $ENTRIES = EnumEntriesKt.a(passCodeStepArr$values);
        Companion = new Companion(null);
    }

    private PassCodeStep(String str, int i3) {
    }

    public static EnumEntries<PassCodeStep> getEntries() {
        return $ENTRIES;
    }

    public static PassCodeStep valueOf(String str) {
        return (PassCodeStep) Enum.valueOf(PassCodeStep.class, str);
    }

    public static PassCodeStep[] values() {
        return (PassCodeStep[]) $VALUES.clone();
    }
}
