package cz.mobilesoft.appblock.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsBottomSheetDialog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1", f = "LockScreenProvider.kt", l = {766, 768}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initAvailableSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f95232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95233d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FragmentLockBinding f95234f;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f95235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentLockBinding f95236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LockScreenProvider f95237c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Set f95238d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FragmentLockBinding fragmentLockBinding, LockScreenProvider lockScreenProvider, Set set, Continuation continuation) {
            super(2, continuation);
            this.f95236b = fragmentLockBinding;
            this.f95237c = lockScreenProvider;
            this.f95238d = set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit A(LockScreenProvider lockScreenProvider, Set set, Intent intent) {
            Context context = lockScreenProvider.f95160r;
            lockScreenProvider.O();
            context.startActivity(SystemSettingsActivity.f105722p.a(context, intent, (String[]) set.toArray(new String[0])));
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit G() {
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(final LockScreenProvider lockScreenProvider, final Set set, View view) {
            new SystemSettingsBottomSheetDialog(lockScreenProvider.f95160r, SetsKt.emptySet(), new Function1() { // from class: cz.mobilesoft.appblock.view.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LockScreenProvider$initAvailableSettings$1.AnonymousClass1.A(lockScreenProvider, set, (Intent) obj);
                }
            }, new Function0() { // from class: cz.mobilesoft.appblock.view.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LockScreenProvider$initAvailableSettings$1.AnonymousClass1.G();
                }
            }).f();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95236b, this.f95237c, this.f95238d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95235a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            MaterialButton settingsButton = this.f95236b.f94019x;
            Intrinsics.checkNotNullExpressionValue(settingsButton, "settingsButton");
            settingsButton.setVisibility(0);
            MaterialButton materialButton = this.f95236b.f94019x;
            final LockScreenProvider lockScreenProvider = this.f95237c;
            final Set set = this.f95238d;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.appblock.view.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LockScreenProvider$initAvailableSettings$1.AnonymousClass1.z(lockScreenProvider, set, view);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initAvailableSettings$1(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, Continuation continuation) {
        super(2, continuation);
        this.f95233d = lockScreenProvider;
        this.f95234f = fragmentLockBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initAvailableSettings$1(this.f95233d, this.f95234f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r3, r4, r8) != r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f95232c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r8.f95231b
            java.util.Set r0 = (java.util.Set) r0
            java.lang.Object r0 = r8.f95230a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r9)
            goto L74
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            java.lang.Object r1 = r8.f95230a
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r9)
            goto L57
        L2a:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType$Companion r9 = cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType.Companion
            cz.mobilesoft.appblock.view.LockScreenProvider r1 = r8.f95233d
            android.content.Context r1 = cz.mobilesoft.appblock.view.LockScreenProvider.z(r1)
            java.util.List r1 = r9.a(r1)
            r9 = r1
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L74
            cz.mobilesoft.appblock.view.LockScreenProvider r9 = r8.f95233d
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r9 = cz.mobilesoft.appblock.view.LockScreenProvider.A(r9)
            kotlinx.coroutines.flow.Flow r9 = r9.i2()
            r8.f95230a = r1
            r8.f95232c = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r8)
            if (r9 != r0) goto L57
            goto L73
        L57:
            java.util.Set r9 = (java.util.Set) r9
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1$1 r4 = new cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1$1
            cz.mobilesoft.appblock.databinding.FragmentLockBinding r5 = r8.f95234f
            cz.mobilesoft.appblock.view.LockScreenProvider r6 = r8.f95233d
            r7 = 0
            r4.<init>(r5, r6, r9, r7)
            r8.f95230a = r1
            r8.f95231b = r9
            r8.f95232c = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r3, r4, r8)
            if (r9 != r0) goto L74
        L73:
            return r0
        L74:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider$initAvailableSettings$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$initAvailableSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
