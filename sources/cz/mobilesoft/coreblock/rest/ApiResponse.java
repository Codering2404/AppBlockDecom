package cz.mobilesoft.coreblock.rest;

import cz.mobilesoft.coreblock.rest.response.ErrorBody;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class ApiResponse<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f98451a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Data<T> extends Success<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f98452b;

        public Data(int i3, Object obj) {
            super(i3);
            this.f98452b = obj;
        }

        public final Object c() {
            return this.f98452b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoContent<T> extends Success<T> {
        public NoContent(int i3) {
            super(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Success<T> extends ApiResponse<T> {
        public Success(int i3) {
            super(i3, null);
        }
    }

    public /* synthetic */ ApiResponse(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    public final int a() {
        return this.f98451a;
    }

    public final ViewModelState b() {
        if (this instanceof Error) {
            Error error = (Error) this;
            return new FailedWithError(error.c(), Integer.valueOf(error.a()), error.d(), null, 8, null);
        }
        if (this instanceof Success) {
            return cz.mobilesoft.coreblock.util.Success.f128020a;
        }
        throw new NoWhenBranchMatchedException();
    }

    private ApiResponse(int i3) {
        this.f98451a = i3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error<T> extends ApiResponse<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f98453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Throwable f98454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ErrorBody f98455d;

        public Error(int i3, Object obj, Throwable th, ErrorBody errorBody) {
            super(i3, null);
            this.f98453b = obj;
            this.f98454c = th;
            this.f98455d = errorBody;
        }

        public final Throwable c() {
            return this.f98454c;
        }

        public final ErrorBody d() {
            return this.f98455d;
        }

        public /* synthetic */ Error(int i3, Object obj, Throwable th, ErrorBody errorBody, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i4 & 2) != 0 ? null : obj, (i4 & 4) != 0 ? null : th, (i4 & 8) != 0 ? null : errorBody);
        }
    }
}
