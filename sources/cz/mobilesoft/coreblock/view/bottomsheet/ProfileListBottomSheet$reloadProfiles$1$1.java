package cz.mobilesoft.coreblock.view.bottomsheet;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$reloadProfiles$1$1", f = "ProfileListBottomSheet.kt", l = {109, 109, 110}, m = "invokeSuspend", v = 1)
final class ProfileListBottomSheet$reloadProfiles$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f130229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f130230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FragmentActivity f130231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ProfileListBottomSheet f130232d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Long f130233f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileListBottomSheet$reloadProfiles$1$1(FragmentActivity fragmentActivity, ProfileListBottomSheet profileListBottomSheet, Long l3, Continuation continuation) {
        super(1, continuation);
        this.f130231c = fragmentActivity;
        this.f130232d = profileListBottomSheet;
        this.f130233f = l3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileListBottomSheet$reloadProfiles$1$1(this.f130231c, this.f130232d, this.f130233f, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f130230b
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2e
            if (r1 == r5) goto L26
            if (r1 == r4) goto L22
            if (r1 != r3) goto L1a
            java.lang.Object r0 = r8.f130229a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r9)
            goto L67
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            kotlin.ResultKt.b(r9)
            goto L53
        L26:
            java.lang.Object r1 = r8.f130229a
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.b(r9)
            goto L40
        L2e:
            kotlin.ResultKt.b(r9)
            androidx.fragment.app.FragmentActivity r1 = r8.f130231c
            cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet r9 = r8.f130232d
            r8.f130229a = r1
            r8.f130230b = r5
            java.lang.Object r9 = r9.e0(r8)
            if (r9 != r0) goto L40
            goto L65
        L40:
            java.util.List r9 = (java.util.List) r9
            cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet r6 = r8.f130232d
            cz.mobilesoft.coreblock.util.profile.ProfileItemType r6 = r6.c0()
            r8.f130229a = r2
            r8.f130230b = r4
            java.lang.Object r9 = cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.E(r1, r9, r6, r8)
            if (r9 != r0) goto L53
            goto L65
        L53:
            java.util.List r9 = (java.util.List) r9
            cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet r1 = r8.f130232d
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.d0()
            r8.f130229a = r9
            r8.f130230b = r3
            java.lang.Object r1 = r1.emit(r9, r8)
            if (r1 != r0) goto L66
        L65:
            return r0
        L66:
            r0 = r9
        L67:
            java.lang.Long r9 = r8.f130233f
            if (r9 == 0) goto L94
            cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet r1 = r8.f130232d
            long r3 = r9.longValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r9 = r0.iterator()
        L77:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L8d
            java.lang.Object r0 = r9.next()
            r6 = r0
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r6 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO) r6
            long r6 = r6.k()
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 != 0) goto L77
            r2 = r0
        L8d:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r2 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO) r2
            if (r2 == 0) goto L94
            cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet.V(r1, r5, r2)
        L94:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$reloadProfiles$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ProfileListBottomSheet$reloadProfiles$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
