package androidx.compose.foundation.layout;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Metadata
public abstract class FlowLayoutOverflow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OverflowType f6861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f6864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f6865e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OverflowType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OverflowType f6866a = new OverflowType("Visible", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final OverflowType f6867b = new OverflowType("Clip", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final OverflowType f6868c = new OverflowType("ExpandIndicator", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final OverflowType f6869d = new OverflowType("ExpandOrCollapseIndicator", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ OverflowType[] f6870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f6871g;

        static {
            OverflowType[] overflowTypeArrA = a();
            f6870f = overflowTypeArrA;
            f6871g = EnumEntriesKt.a(overflowTypeArrA);
        }

        private OverflowType(String str, int i3) {
        }

        private static final /* synthetic */ OverflowType[] a() {
            return new OverflowType[]{f6866a, f6867b, f6868c, f6869d};
        }

        public static OverflowType valueOf(String str) {
            return (OverflowType) Enum.valueOf(OverflowType.class, str);
        }

        public static OverflowType[] values() {
            return (OverflowType[]) f6870f.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6872a;

        static {
            int[] iArr = new int[OverflowType.values().length];
            try {
                iArr[OverflowType.f6868c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OverflowType.f6869d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6872a = iArr;
        }
    }

    public /* synthetic */ FlowLayoutOverflow(OverflowType overflowType, int i3, int i4, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, i3, i4, function1, function12);
    }

    public final void a(FlowLayoutOverflowState flowLayoutOverflowState, List list) {
        Function1 function1 = this.f6864d;
        Function2 function2 = function1 != null ? (Function2) function1.invoke(flowLayoutOverflowState) : null;
        Function1 function12 = this.f6865e;
        Function2 function22 = function12 != null ? (Function2) function12.invoke(flowLayoutOverflowState) : null;
        int i3 = WhenMappings.f6872a[this.f6861a.ordinal()];
        if (i3 == 1) {
            if (function2 != null) {
                list.add(function2);
            }
        } else {
            if (i3 != 2) {
                return;
            }
            if (function2 != null) {
                list.add(function2);
            }
            if (function22 != null) {
                list.add(function22);
            }
        }
    }

    public final FlowLayoutOverflowState b() {
        return new FlowLayoutOverflowState(this.f6861a, this.f6862b, this.f6863c);
    }

    private FlowLayoutOverflow(OverflowType overflowType, int i3, int i4, Function1 function1, Function1 function12) {
        this.f6861a = overflowType;
        this.f6862b = i3;
        this.f6863c = i4;
        this.f6864d = function1;
        this.f6865e = function12;
    }
}
