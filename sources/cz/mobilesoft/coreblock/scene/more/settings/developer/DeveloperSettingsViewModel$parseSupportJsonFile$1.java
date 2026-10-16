package cz.mobilesoft.coreblock.scene.more.settings.developer;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$parseSupportJsonFile$1", f = "DeveloperSettingsViewModel.kt", l = {1355, 1360}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$parseSupportJsonFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f108901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f108902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f108903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f108904d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Uri f108906g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$parseSupportJsonFile$1(DeveloperSettingsViewModel developerSettingsViewModel, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.f108905f = developerSettingsViewModel;
        this.f108906g = uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState y(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, true, null, -1, 393215, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState z(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 393215, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$parseSupportJsonFile$1(this.f108905f, this.f108906g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
    
        if (r1.P0(r3, r7) != r0) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f108904d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L31
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r7.f108901a
            java.io.IOException r0 = (java.io.IOException) r0
            kotlin.ResultKt.b(r8)
            goto La5
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1f:
            java.lang.Object r1 = r7.f108903c
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r7.f108902b
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            java.lang.Object r3 = r7.f108901a
            java.io.InputStream r3 = (java.io.InputStream) r3
            kotlin.ResultKt.b(r8)     // Catch: java.io.IOException -> L2f
            goto L79
        L2f:
            r8 = move-exception
            goto L7f
        L31:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108905f     // Catch: java.io.IOException -> L2f
            cz.mobilesoft.coreblock.scene.more.settings.developer.i8 r1 = new cz.mobilesoft.coreblock.scene.more.settings.developer.i8     // Catch: java.io.IOException -> L2f
            r1.<init>()     // Catch: java.io.IOException -> L2f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r8, r1)     // Catch: java.io.IOException -> L2f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108905f     // Catch: java.io.IOException -> L2f
            android.content.Context r8 = r8.A0()     // Catch: java.io.IOException -> L2f
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.io.IOException -> L2f
            android.net.Uri r1 = r7.f108906g     // Catch: java.io.IOException -> L2f
            java.io.InputStream r8 = r8.openInputStream(r1)     // Catch: java.io.IOException -> L2f
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.io.IOException -> L2f
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L2f
            r4.<init>(r8)     // Catch: java.io.IOException -> L2f
            r1.<init>(r4)     // Catch: java.io.IOException -> L2f
            java.lang.String r4 = kotlin.io.TextStreamsKt.h(r1)     // Catch: java.io.IOException -> L2f
            r1.close()     // Catch: java.io.IOException -> L2f
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)     // Catch: java.io.IOException -> L2f
            r7.f108901a = r8     // Catch: java.io.IOException -> L2f
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)     // Catch: java.io.IOException -> L2f
            r7.f108902b = r8     // Catch: java.io.IOException -> L2f
            r7.f108903c = r4     // Catch: java.io.IOException -> L2f
            r7.f108904d = r3     // Catch: java.io.IOException -> L2f
            r5 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)     // Catch: java.io.IOException -> L2f
            if (r8 != r0) goto L78
            goto La4
        L78:
            r1 = r4
        L79:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108905f     // Catch: java.io.IOException -> L2f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.V1(r8, r1)     // Catch: java.io.IOException -> L2f
            goto Laf
        L7f:
            r8.printStackTrace()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r7.f108905f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r3 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = r8.getMessage()
            if (r4 != 0) goto L8e
            java.lang.String r4 = "Error reading file"
        L8e:
            r3.<init>(r4)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f108901a = r8
            r8 = 0
            r7.f108902b = r8
            r7.f108903c = r8
            r7.f108904d = r2
            java.lang.Object r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r3, r7)
            if (r8 != r0) goto La5
        La4:
            return r0
        La5:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108905f
            cz.mobilesoft.coreblock.scene.more.settings.developer.j8 r0 = new cz.mobilesoft.coreblock.scene.more.settings.developer.j8
            r0.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r8, r0)
        Laf:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$parseSupportJsonFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$parseSupportJsonFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
