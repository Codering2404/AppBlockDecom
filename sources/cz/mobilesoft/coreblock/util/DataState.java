package cz.mobilesoft.coreblock.util;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class DataState<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends DataState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f127813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f127814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Integer f127815c;

        public Error(Throwable th, String str, Integer num) {
            super(null);
            this.f127813a = th;
            this.f127814b = str;
            this.f127815c = num;
        }

        public final Integer a() {
            return this.f127815c;
        }

        public final String b() {
            return this.f127814b;
        }

        public final Throwable c() {
            return this.f127813a;
        }

        public final FailedWithError d() {
            return new FailedWithError(this.f127813a, this.f127815c, null, this.f127814b, 4, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual(this.f127813a, error.f127813a) && Intrinsics.areEqual(this.f127814b, error.f127814b) && Intrinsics.areEqual(this.f127815c, error.f127815c);
        }

        public int hashCode() {
            Throwable th = this.f127813a;
            int iHashCode = (th == null ? 0 : th.hashCode()) * 31;
            String str = this.f127814b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.f127815c;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "Error(throwable=" + this.f127813a + ", message=" + this.f127814b + ", code=" + this.f127815c + ")";
        }

        public /* synthetic */ Error(Throwable th, String str, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(th, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends DataState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Loading f127816a = new Loading();

        private Loading() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Loading);
        }

        public int hashCode() {
            return -636040524;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Success<R> extends DataState<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f127817a;

        public Success(Object obj) {
            super(null);
            this.f127817a = obj;
        }

        public final Object a() {
            return this.f127817a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.f127817a, ((Success) obj).f127817a);
        }

        public int hashCode() {
            Object obj = this.f127817a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f127817a + ")";
        }
    }

    public /* synthetic */ DataState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DataState() {
    }
}
