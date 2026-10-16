package cz.mobilesoft.coreblock.usecase;

import android.content.Context;
import android.net.Uri;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class UpdateUserPhotoUseCase extends FlowUseCase<Params, DataState<? extends Unit>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127490a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f127491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f127492b;

        public Params(Uri uri, String nickName) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.f127491a = uri;
            this.f127492b = nickName;
        }

        public final Uri a() {
            return this.f127491a;
        }

        public final String b() {
            return this.f127492b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127491a, params.f127491a) && Intrinsics.areEqual(this.f127492b, params.f127492b);
        }

        public int hashCode() {
            Uri uri = this.f127491a;
            return ((uri == null ? 0 : uri.hashCode()) * 31) + this.f127492b.hashCode();
        }

        public String toString() {
            return "Params(imageUri=" + this.f127491a + ", nickName=" + this.f127492b + ")";
        }
    }

    public UpdateUserPhotoUseCase(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f127490a = applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(android.net.Uri r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$createMultipart$1
            if (r0 == 0) goto L14
            r0 = r12
            cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$createMultipart$1 r0 = (cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$createMultipart$1) r0
            int r1 = r0.f127499h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f127499h = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$createMultipart$1 r0 = new cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$createMultipart$1
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.f127497f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f127499h
            r8 = 0
            r9 = 1
            if (r1 == 0) goto L45
            if (r1 != r9) goto L3d
            java.lang.Object r11 = r7.f127495c
            java.io.ByteArrayOutputStream r11 = (java.io.ByteArrayOutputStream) r11
            java.lang.Object r0 = r7.f127494b
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r7.f127493a
            android.net.Uri r0 = (android.net.Uri) r0
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L39
            goto L78
        L39:
            r0 = move-exception
            r11 = r0
            goto Lba
        L3d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L45:
            kotlin.ResultKt.b(r12)
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream
            r12.<init>()
            android.content.Context r1 = r10.f127490a     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r2 = r1.getPackageName()     // Catch: java.lang.Throwable -> Lb7
            r1.grantUriPermission(r2, r11, r9)     // Catch: java.lang.Throwable -> Lb7
            cz.mobilesoft.coreblock.util.media.MediaUtil r1 = cz.mobilesoft.coreblock.util.media.MediaUtil.f128857a     // Catch: java.lang.Throwable -> Lb7
            android.content.Context r2 = r10.f127490a     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)     // Catch: java.lang.Throwable -> Lb7
            r7.f127493a = r3     // Catch: java.lang.Throwable -> Lb7
            r7.f127494b = r12     // Catch: java.lang.Throwable -> Lb7
            r7.f127495c = r12     // Catch: java.lang.Throwable -> Lb7
            r7.f127496d = r8     // Catch: java.lang.Throwable -> Lb7
            r7.f127499h = r9     // Catch: java.lang.Throwable -> Lb7
            r3 = 500(0x1f4, float:7.0E-43)
            r4 = 500(0x1f4, float:7.0E-43)
            r6 = 1
            r5 = r11
            java.lang.Object r11 = r1.g(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lb7
            if (r11 != r0) goto L75
            return r0
        L75:
            r1 = r12
            r12 = r11
            r11 = r1
        L78:
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12     // Catch: java.lang.Throwable -> L39
            if (r12 == 0) goto L87
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L39
            r2 = 100
            boolean r12 = r12.compress(r0, r2, r11)     // Catch: java.lang.Throwable -> L39
            kotlin.coroutines.jvm.internal.Boxing.a(r12)     // Catch: java.lang.Throwable -> L39
        L87:
            byte[] r3 = r11.toByteArray()     // Catch: java.lang.Throwable -> L39
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Throwable -> L39
            int r11 = r3.length     // Catch: java.lang.Throwable -> L39
            if (r11 != 0) goto L92
            r8 = r9
        L92:
            r11 = 0
            if (r8 != 0) goto Lb2
            okhttp3.MultipartBody$Part$Companion r12 = okhttp3.MultipartBody.Part.f144132c     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "picture"
            java.lang.String r9 = "picture.png"
            okhttp3.RequestBody$Companion r2 = okhttp3.RequestBody.f144218a     // Catch: java.lang.Throwable -> L39
            okhttp3.MediaType$Companion r4 = okhttp3.MediaType.f144108e     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = "application/octet-stream"
            okhttp3.MediaType r4 = r4.a(r5)     // Catch: java.lang.Throwable -> L39
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            okhttp3.RequestBody r2 = okhttp3.RequestBody.Companion.i(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L39
            okhttp3.MultipartBody$Part r12 = r12.c(r0, r9, r2)     // Catch: java.lang.Throwable -> L39
            goto Lb3
        Lb2:
            r12 = r11
        Lb3:
            kotlin.io.CloseableKt.a(r1, r11)
            return r12
        Lb7:
            r0 = move-exception
            r11 = r0
            r1 = r12
        Lba:
            throw r11     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            r0 = move-exception
            r12 = r0
            kotlin.io.CloseableKt.a(r1, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase.b(android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Flow c(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.I(new UpdateUserPhotoUseCase$invoke$1(params, this, null));
    }
}
