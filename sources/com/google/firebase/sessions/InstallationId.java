package com.google.firebase.sessions;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class InstallationId {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f89981c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89983b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
        
            if (r10 == r1) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [com.google.firebase.installations.FirebaseInstallationsApi] */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.installations.FirebaseInstallationsApi, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(com.google.firebase.installations.FirebaseInstallationsApi r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L13
                r0 = r10
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.f89987d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f89987d = r1
                goto L18
            L13:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.f89985b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f89987d
                java.lang.String r3 = "FirebaseSessions"
                r4 = 2
                r5 = 1
                java.lang.String r6 = ""
                if (r2 == 0) goto L48
                if (r2 == r5) goto L3e
                if (r2 != r4) goto L36
                java.lang.Object r9 = r0.f89984a
                java.lang.String r9 = (java.lang.String) r9
                kotlin.ResultKt.b(r10)     // Catch: java.lang.Exception -> L34
                goto L85
            L34:
                r10 = move-exception
                goto L8c
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f89984a
                com.google.firebase.installations.FirebaseInstallationsApi r9 = (com.google.firebase.installations.FirebaseInstallationsApi) r9
                kotlin.ResultKt.b(r10)     // Catch: java.lang.Exception -> L46
                goto L60
            L46:
                r10 = move-exception
                goto L6a
            L48:
                kotlin.ResultKt.b(r10)
                r10 = 0
                com.google.android.gms.tasks.Task r10 = r9.a(r10)     // Catch: java.lang.Exception -> L46
                java.lang.String r2 = "getToken(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L46
                r0.f89984a = r9     // Catch: java.lang.Exception -> L46
                r0.f89987d = r5     // Catch: java.lang.Exception -> L46
                java.lang.Object r10 = kotlinx.coroutines.tasks.TasksKt.b(r10, r0)     // Catch: java.lang.Exception -> L46
                if (r10 != r1) goto L60
                goto L84
            L60:
                com.google.firebase.installations.InstallationTokenResult r10 = (com.google.firebase.installations.InstallationTokenResult) r10     // Catch: java.lang.Exception -> L46
                java.lang.String r10 = r10.b()     // Catch: java.lang.Exception -> L46
                r7 = r10
                r10 = r9
                r9 = r7
                goto L71
            L6a:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r3, r2, r10)
                r10 = r9
                r9 = r6
            L71:
                com.google.android.gms.tasks.Task r10 = r10.getId()     // Catch: java.lang.Exception -> L34
                java.lang.String r2 = "getId(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L34
                r0.f89984a = r9     // Catch: java.lang.Exception -> L34
                r0.f89987d = r4     // Catch: java.lang.Exception -> L34
                java.lang.Object r10 = kotlinx.coroutines.tasks.TasksKt.b(r10, r0)     // Catch: java.lang.Exception -> L34
                if (r10 != r1) goto L85
            L84:
                return r1
            L85:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L34
                if (r10 != 0) goto L8a
                goto L91
            L8a:
                r6 = r10
                goto L91
            L8c:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r3, r0, r10)
            L91:
                com.google.firebase.sessions.InstallationId r10 = new com.google.firebase.sessions.InstallationId
                r0 = 0
                r10.<init>(r6, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.a(com.google.firebase.installations.FirebaseInstallationsApi, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String a() {
        return this.f89983b;
    }

    public final String b() {
        return this.f89982a;
    }

    private InstallationId(String str, String str2) {
        this.f89982a = str;
        this.f89983b = str2;
    }
}
