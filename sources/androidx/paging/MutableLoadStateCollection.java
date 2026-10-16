package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class MutableLoadStateCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoadState f49928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoadState f49929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LoadState f49930c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49931a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49931a = iArr;
        }
    }

    public MutableLoadStateCollection() {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.f49893b;
        this.f49928a = companion.b();
        this.f49929b = companion.b();
        this.f49930c = companion.b();
    }

    public final LoadState a(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i3 = WhenMappings.f49931a[loadType.ordinal()];
        if (i3 == 1) {
            return this.f49928a;
        }
        if (i3 == 2) {
            return this.f49930c;
        }
        if (i3 == 3) {
            return this.f49929b;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void b(LoadStates states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.f49928a = states.f();
        this.f49930c = states.d();
        this.f49929b = states.e();
    }

    public final void c(LoadType type, LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        int i3 = WhenMappings.f49931a[type.ordinal()];
        if (i3 == 1) {
            this.f49928a = state;
        } else if (i3 == 2) {
            this.f49930c = state;
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.f49929b = state;
        }
    }

    public final LoadStates d() {
        return new LoadStates(this.f49928a, this.f49929b, this.f49930c);
    }
}
