package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
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
    private final Mutex f20247a = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f20248b = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SnackbarDataImpl implements SnackbarData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SnackbarVisuals f20249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CancellableContinuation f20250b;

        public SnackbarDataImpl(SnackbarVisuals snackbarVisuals, CancellableContinuation cancellableContinuation) {
            this.f20249a = snackbarVisuals;
            this.f20250b = cancellableContinuation;
        }

        @Override // androidx.compose.material3.SnackbarData
        public SnackbarVisuals a() {
            return this.f20249a;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void b() {
            if (this.f20250b.isActive()) {
                CancellableContinuation cancellableContinuation = this.f20250b;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(SnackbarResult.ActionPerformed));
            }
        }

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.f20250b.isActive()) {
                CancellableContinuation cancellableContinuation = this.f20250b;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarDataImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
            return Intrinsics.areEqual(a(), snackbarDataImpl.a()) && Intrinsics.areEqual(this.f20250b, snackbarDataImpl.f20250b);
        }

        public int hashCode() {
            return (a().hashCode() * 31) + this.f20250b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SnackbarVisualsImpl implements SnackbarVisuals {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f20253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SnackbarDuration f20254d;

        public SnackbarVisualsImpl(String str, String str2, boolean z2, SnackbarDuration snackbarDuration) {
            this.f20251a = str;
            this.f20252b = str2;
            this.f20253c = z2;
            this.f20254d = snackbarDuration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String a() {
            return this.f20252b;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean b() {
            return this.f20253c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarVisualsImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) obj;
            return Intrinsics.areEqual(getMessage(), snackbarVisualsImpl.getMessage()) && Intrinsics.areEqual(a(), snackbarVisualsImpl.a()) && b() == snackbarVisualsImpl.b() && getDuration() == snackbarVisualsImpl.getDuration();
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public SnackbarDuration getDuration() {
            return this.f20254d;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getMessage() {
            return this.f20251a;
        }

        public int hashCode() {
            int iHashCode = getMessage().hashCode() * 31;
            String strA = a();
            return ((((iHashCode + (strA != null ? strA.hashCode() : 0)) * 31) + Boolean.hashCode(b())) * 31) + getDuration().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(SnackbarData snackbarData) {
        this.f20248b.setValue(snackbarData);
    }

    public static /* synthetic */ Object f(SnackbarHostState snackbarHostState, String str, String str2, boolean z2, SnackbarDuration snackbarDuration, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            snackbarDuration = str3 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
        }
        return snackbarHostState.e(str, str3, z3, snackbarDuration, continuation);
    }

    public final SnackbarData b() {
        return (SnackbarData) this.f20248b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(androidx.compose.material3.SnackbarVisuals r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.SnackbarHostState$showSnackbar$2
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r0
            int r1 = r0.f20261h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20261h = r1
            goto L18
        L13:
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = new androidx.compose.material3.SnackbarHostState$showSnackbar$2
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f20259f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f20261h
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L5b
            if (r2 == r4) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r8 = r0.f20258d
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r8 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r8
            java.lang.Object r8 = r0.f20257c
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r1 = r0.f20256b
            androidx.compose.material3.SnackbarVisuals r1 = (androidx.compose.material3.SnackbarVisuals) r1
            java.lang.Object r0 = r0.f20255a
            androidx.compose.material3.SnackbarHostState r0 = (androidx.compose.material3.SnackbarHostState) r0
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L3e
            goto La9
        L3e:
            r9 = move-exception
            goto Lb2
        L41:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L49:
            java.lang.Object r8 = r0.f20257c
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.f20256b
            androidx.compose.material3.SnackbarVisuals r2 = (androidx.compose.material3.SnackbarVisuals) r2
            java.lang.Object r6 = r0.f20255a
            androidx.compose.material3.SnackbarHostState r6 = (androidx.compose.material3.SnackbarHostState) r6
            kotlin.ResultKt.b(r9)
            r9 = r8
            r8 = r2
            goto L70
        L5b:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.f20247a
            r0.f20255a = r7
            r0.f20256b = r8
            r0.f20257c = r9
            r0.f20261h = r4
            java.lang.Object r2 = r9.f(r5, r0)
            if (r2 != r1) goto L6f
            goto La4
        L6f:
            r6 = r7
        L70:
            r0.f20255a = r6     // Catch: java.lang.Throwable -> L9c
            r0.f20256b = r8     // Catch: java.lang.Throwable -> L9c
            r0.f20257c = r9     // Catch: java.lang.Throwable -> L9c
            r0.f20258d = r0     // Catch: java.lang.Throwable -> L9c
            r0.f20261h = r3     // Catch: java.lang.Throwable -> L9c
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L9c
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L9c
            r2.C()     // Catch: java.lang.Throwable -> L9c
            androidx.compose.material3.SnackbarHostState$SnackbarDataImpl r3 = new androidx.compose.material3.SnackbarHostState$SnackbarDataImpl     // Catch: java.lang.Throwable -> L9c
            r3.<init>(r8, r2)     // Catch: java.lang.Throwable -> L9c
            a(r6, r3)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r8 = r2.v()     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()     // Catch: java.lang.Throwable -> L9c
            if (r8 != r2) goto La2
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch: java.lang.Throwable -> L9c
            goto La2
        L9c:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r6
            goto Lb2
        La2:
            if (r8 != r1) goto La5
        La4:
            return r1
        La5:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r6
        La9:
            r0.c(r5)     // Catch: java.lang.Throwable -> Lb0
            r8.i(r5)
            return r9
        Lb0:
            r9 = move-exception
            goto Lb6
        Lb2:
            r0.c(r5)     // Catch: java.lang.Throwable -> Lb0
            throw r9     // Catch: java.lang.Throwable -> Lb0
        Lb6:
            r8.i(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostState.d(androidx.compose.material3.SnackbarVisuals, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object e(String str, String str2, boolean z2, SnackbarDuration snackbarDuration, Continuation continuation) {
        return d(new SnackbarVisualsImpl(str, str2, z2, snackbarDuration), continuation);
    }
}
