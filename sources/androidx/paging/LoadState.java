package androidx.paging;

import kotlin.Metadata;
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
public abstract class LoadState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f49890a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends LoadState {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f49891b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(false, null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f49891b = error;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return a() == error.a() && Intrinsics.areEqual(this.f49891b, error.f49891b);
        }

        public int hashCode() {
            return Boolean.hashCode(a()) + this.f49891b.hashCode();
        }

        public String toString() {
            return "Error(endOfPaginationReached=" + a() + ", error=" + this.f49891b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends LoadState {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Loading f49892b = new Loading();

        private Loading() {
            super(false, null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Loading) && a() == ((Loading) obj).a();
        }

        public int hashCode() {
            return Boolean.hashCode(a());
        }

        public String toString() {
            return "Loading(endOfPaginationReached=" + a() + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotLoading extends LoadState {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f49893b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final NotLoading f49894c = new NotLoading(true);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final NotLoading f49895d = new NotLoading(false);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NotLoading a() {
                return NotLoading.f49894c;
            }

            public final NotLoading b() {
                return NotLoading.f49895d;
            }

            private Companion() {
            }
        }

        public NotLoading(boolean z2) {
            super(z2, null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof NotLoading) && a() == ((NotLoading) obj).a();
        }

        public int hashCode() {
            return Boolean.hashCode(a());
        }

        public String toString() {
            return "NotLoading(endOfPaginationReached=" + a() + ')';
        }
    }

    public /* synthetic */ LoadState(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2);
    }

    public final boolean a() {
        return this.f49890a;
    }

    private LoadState(boolean z2) {
        this.f49890a = z2;
    }
}
