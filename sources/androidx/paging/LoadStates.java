package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LoadStates {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f49897f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final LoadStates f49898g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LoadState f49899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoadState f49900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LoadState f49901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f49902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f49903e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoadStates a() {
            return LoadStates.f49898g;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49904a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.APPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49904a = iArr;
        }
    }

    static {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.f49893b;
        f49898g = new LoadStates(companion.b(), companion.b(), companion.b());
    }

    public LoadStates(LoadState refresh, LoadState prepend, LoadState append) {
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(prepend, "prepend");
        Intrinsics.checkNotNullParameter(append, "append");
        this.f49899a = refresh;
        this.f49900b = prepend;
        this.f49901c = append;
        this.f49902d = (refresh instanceof LoadState.Error) || (append instanceof LoadState.Error) || (prepend instanceof LoadState.Error);
        this.f49903e = (refresh instanceof LoadState.NotLoading) && (append instanceof LoadState.NotLoading) && (prepend instanceof LoadState.NotLoading);
    }

    public static /* synthetic */ LoadStates c(LoadStates loadStates, LoadState loadState, LoadState loadState2, LoadState loadState3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            loadState = loadStates.f49899a;
        }
        if ((i3 & 2) != 0) {
            loadState2 = loadStates.f49900b;
        }
        if ((i3 & 4) != 0) {
            loadState3 = loadStates.f49901c;
        }
        return loadStates.b(loadState, loadState2, loadState3);
    }

    public final LoadStates b(LoadState refresh, LoadState prepend, LoadState append) {
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(prepend, "prepend");
        Intrinsics.checkNotNullParameter(append, "append");
        return new LoadStates(refresh, prepend, append);
    }

    public final LoadState d() {
        return this.f49901c;
    }

    public final LoadState e() {
        return this.f49900b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadStates)) {
            return false;
        }
        LoadStates loadStates = (LoadStates) obj;
        return Intrinsics.areEqual(this.f49899a, loadStates.f49899a) && Intrinsics.areEqual(this.f49900b, loadStates.f49900b) && Intrinsics.areEqual(this.f49901c, loadStates.f49901c);
    }

    public final LoadState f() {
        return this.f49899a;
    }

    public final boolean g() {
        return this.f49902d;
    }

    public final boolean h() {
        return this.f49903e;
    }

    public int hashCode() {
        return (((this.f49899a.hashCode() * 31) + this.f49900b.hashCode()) * 31) + this.f49901c.hashCode();
    }

    public final LoadStates i(LoadType loadType, LoadState newState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(newState, "newState");
        int i3 = WhenMappings.f49904a[loadType.ordinal()];
        if (i3 == 1) {
            return c(this, null, null, newState, 3, null);
        }
        if (i3 == 2) {
            return c(this, null, newState, null, 5, null);
        }
        if (i3 == 3) {
            return c(this, newState, null, null, 6, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return "LoadStates(refresh=" + this.f49899a + ", prepend=" + this.f49900b + ", append=" + this.f49901c + ')';
    }
}
