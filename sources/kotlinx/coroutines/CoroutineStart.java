package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class CoroutineStart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineStart f140916a = new CoroutineStart("DEFAULT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineStart f140917b = new CoroutineStart("LAZY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineStart f140918c = new CoroutineStart("ATOMIC", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineStart f140919d = new CoroutineStart("UNDISPATCHED", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ CoroutineStart[] f140920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f140921g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f140922a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.f140916a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.f140918c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.f140919d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.f140917b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f140922a = iArr;
        }
    }

    static {
        CoroutineStart[] coroutineStartArrA = a();
        f140920f = coroutineStartArrA;
        f140921g = EnumEntriesKt.a(coroutineStartArrA);
    }

    private CoroutineStart(String str, int i3) {
    }

    private static final /* synthetic */ CoroutineStart[] a() {
        return new CoroutineStart[]{f140916a, f140917b, f140918c, f140919d};
    }

    public static CoroutineStart valueOf(String str) {
        return (CoroutineStart) Enum.valueOf(CoroutineStart.class, str);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) f140920f.clone();
    }

    public final void b(Function2 function2, Object obj, Continuation continuation) {
        int i3 = WhenMappings.f140922a[ordinal()];
        if (i3 == 1) {
            CancellableKt.c(function2, obj, continuation);
            return;
        }
        if (i3 == 2) {
            ContinuationKt.b(function2, obj, continuation);
        } else if (i3 == 3) {
            UndispatchedKt.a(function2, obj, continuation);
        } else if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean c() {
        return this == f140917b;
    }
}
