package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakAvailability {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoreDataStore f120220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakDataStore f120221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Flow f120222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Flow f120223d;

    public StreakAvailability(CoreDataStore coreDataStore, StreakDataStore streakDataStore) {
        Intrinsics.checkNotNullParameter(coreDataStore, "coreDataStore");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        this.f120220a = coreDataStore;
        this.f120221b = streakDataStore;
        this.f120222c = FlowKt.m(coreDataStore.v3(), coreDataStore.w3(), new StreakAvailability$isEnabled$1(null));
        this.f120223d = coreDataStore.w3();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakAvailability$canTrack$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability$canTrack$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakAvailability$canTrack$1) r0
            int r1 = r0.f120226c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120226c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability$canTrack$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakAvailability$canTrack$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f120224a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120226c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            return r7
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            kotlin.ResultKt.b(r7)
            goto L6e
        L3b:
            kotlin.ResultKt.b(r7)
            goto L51
        L3f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r6.f120220a
            kotlinx.coroutines.flow.Flow r7 = r7.v3()
            r0.f120226c = r5
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L51
            goto L89
        L51:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5f
            r7 = 0
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r7
        L5f:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r6.f120220a
            kotlinx.coroutines.flow.Flow r7 = r7.w3()
            r0.f120226c = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L6e
            goto L89
        L6e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L7b
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r7
        L7b:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r7 = r6.f120221b
            kotlinx.coroutines.flow.Flow r7 = r7.K()
            r0.f120226c = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L8a
        L89:
            return r1
        L8a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakAvailability.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow b() {
        return this.f120223d;
    }

    public final Flow c() {
        return this.f120222c;
    }

    public final Object d(Continuation continuation) {
        return FlowKt.D(this.f120222c, continuation);
    }
}
