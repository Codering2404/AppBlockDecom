package androidx.credentials;

import android.credentials.PrepareGetCredentialResponse;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class PrepareGetCredentialResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingGetCredentialHandle f34824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f34825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f34826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f34827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f34828e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PendingGetCredentialHandle f34829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Function0 f34830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Function0 f34831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Function1 f34832d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private android.credentials.PrepareGetCredentialResponse f34833e;

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean e() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.f34833e;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasAuthenticationResults();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(String str) {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.f34833e;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasCredentialResults(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean g() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.f34833e;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasRemoteResults();
        }

        public final PrepareGetCredentialResponse d() {
            return new PrepareGetCredentialResponse(this.f34829a, this.f34830b, this.f34831c, this.f34832d, false, null);
        }

        public final Builder h(android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse) {
            this.f34833e = prepareGetCredentialResponse;
            if (prepareGetCredentialResponse != null) {
                this.f34832d = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$1(this);
                this.f34831c = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$2(this);
                this.f34830b = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$3(this);
            }
            return this;
        }

        public final Builder i(PendingGetCredentialHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            this.f34829a = handle;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PendingGetCredentialHandle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrepareGetCredentialResponse.PendingGetCredentialHandle f34834a;

        public PendingGetCredentialHandle(PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle) {
            this.f34834a = pendingGetCredentialHandle;
            if (Build.VERSION.SDK_INT >= 34) {
                Intrinsics.checkNotNull(pendingGetCredentialHandle);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TestBuilder {
    }

    public /* synthetic */ PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle, Function0 function0, Function0 function02, Function1 function1, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingGetCredentialHandle, function0, function02, function1, z2);
    }

    private PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle, Function0 function0, Function0 function02, Function1 function1, boolean z2) {
        this.f34824a = pendingGetCredentialHandle;
        this.f34825b = function0;
        this.f34826c = function02;
        this.f34827d = function1;
        this.f34828e = z2;
        if (Build.VERSION.SDK_INT < 34 || z2) {
            return;
        }
        Intrinsics.checkNotNull(pendingGetCredentialHandle);
    }
}
