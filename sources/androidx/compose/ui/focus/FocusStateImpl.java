package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FocusStateImpl implements FocusState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FocusStateImpl f25537a = new FocusStateImpl("Active", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FocusStateImpl f25538b = new FocusStateImpl("ActiveParent", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FocusStateImpl f25539c = new FocusStateImpl("Captured", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FocusStateImpl f25540d = new FocusStateImpl("Inactive", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ FocusStateImpl[] f25541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f25542g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25543a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.f25539c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.f25537a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.f25538b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.f25540d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f25543a = iArr;
        }
    }

    static {
        FocusStateImpl[] focusStateImplArrC = c();
        f25541f = focusStateImplArrC;
        f25542g = EnumEntriesKt.a(focusStateImplArrC);
    }

    private FocusStateImpl(String str, int i3) {
    }

    private static final /* synthetic */ FocusStateImpl[] c() {
        return new FocusStateImpl[]{f25537a, f25538b, f25539c, f25540d};
    }

    public static FocusStateImpl valueOf(String str) {
        return (FocusStateImpl) Enum.valueOf(FocusStateImpl.class, str);
    }

    public static FocusStateImpl[] values() {
        return (FocusStateImpl[]) f25541f.clone();
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean a() {
        int i3 = WhenMappings.f25543a[ordinal()];
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        if (i3 == 3 || i3 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean b() {
        int i3 = WhenMappings.f25543a[ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        if (i3 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
