package cz.mobilesoft.coreblock.scene.strictmode.passcode;

import android.app.Application;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils;
import cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel;
import cz.mobilesoft.coreblock.scene.password.PassCodeStep;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.scene.password.PassCodeViewState;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
public final class StrictModePassCodeViewModel extends BasePassCodeViewModel {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final StrictModeDataStore f121050t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f121051u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f121052v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrictModePassCodeViewModel(Application application, PassCodeType passCodeType, StrictModeDataStore strictModeDataStore) {
        super(application, PassCodeStep.Companion.a(passCodeType));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(passCodeType, "passCodeType");
        Intrinsics.checkNotNullParameter(strictModeDataStore, "strictModeDataStore");
        this.f121050t = strictModeDataStore;
        this.f121051u = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode.passcode.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StrictModePassCodeViewModel.C1(this.f121078a);
            }
        });
        this.f121052v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode.passcode.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StrictModePassCodeViewModel.B1(this.f121079a);
            }
        });
        r1();
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode.passcode.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictModePassCodeViewModel.A1((PassCodeViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState A1(PassCodeViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PassCodeViewState.b(updateState, null, null, null, false, 0, 0L, CollectionsKt.listOf(BackdoorUtils.UnlockType.StrictMode), 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow B1(StrictModePassCodeViewModel strictModePassCodeViewModel) {
        return strictModePassCodeViewModel.f121050t.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow C1(StrictModePassCodeViewModel strictModePassCodeViewModel) {
        return strictModePassCodeViewModel.f121050t.p0();
    }

    @Override // cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel
    public Flow h1() {
        return (Flow) this.f121052v.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel
    public Flow i1() {
        return (Flow) this.f121051u.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel
    public Object s1(long j3, Continuation continuation) {
        Object objV0 = this.f121050t.V0(j3, continuation);
        return objV0 == IntrinsicsKt.f() ? objV0 : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel
    public Object t1(int i3, Continuation continuation) {
        Object objW0 = this.f121050t.W0(i3, continuation);
        return objW0 == IntrinsicsKt.f() ? objW0 : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel
    public Object u1(String str, Continuation continuation) {
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object k1(java.lang.String r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel$isPassCodeCorrect$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel$isPassCodeCorrect$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel$isPassCodeCorrect$1) r0
            int r1 = r0.f121056d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121056d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel$isPassCodeCorrect$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel$isPassCodeCorrect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f121054b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121056d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f121053a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r6)
            goto L4a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r6 = 0
            java.lang.String r6 = kotlin.comparisons.xn.YvFRmou.paFPdKJlxkp
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r6 = r4.f121050t
            kotlinx.coroutines.flow.Flow r6 = r6.n0()
            r0.f121053a = r5
            r0.f121056d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r5)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel.k1(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
