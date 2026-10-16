package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class SnackbarHostState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mutex f14094a = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f14095b = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SnackbarDataImpl implements SnackbarData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SnackbarDuration f14098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CancellableContinuation f14099d;

        public SnackbarDataImpl(String str, String str2, SnackbarDuration snackbarDuration, CancellableContinuation cancellableContinuation) {
            this.f14096a = str;
            this.f14097b = str2;
            this.f14098c = snackbarDuration;
            this.f14099d = cancellableContinuation;
        }

        @Override // androidx.compose.material.SnackbarData
        public String a() {
            return this.f14097b;
        }

        @Override // androidx.compose.material.SnackbarData
        public void b() {
            if (this.f14099d.isActive()) {
                CancellableContinuation cancellableContinuation = this.f14099d;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(SnackbarResult.ActionPerformed));
            }
        }

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            if (this.f14099d.isActive()) {
                CancellableContinuation cancellableContinuation = this.f14099d;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(SnackbarResult.Dismissed));
            }
        }

        @Override // androidx.compose.material.SnackbarData
        public SnackbarDuration getDuration() {
            return this.f14098c;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getMessage() {
            return this.f14096a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(SnackbarData snackbarData) {
        this.f14095b.setValue(snackbarData);
    }

    public static /* synthetic */ Object e(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.d(str, str2, snackbarDuration, continuation);
    }

    public final SnackbarData b() {
        return (SnackbarData) this.f14095b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r9, java.lang.String r10, androidx.compose.material.SnackbarDuration r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostState.d(java.lang.String, java.lang.String, androidx.compose.material.SnackbarDuration, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
